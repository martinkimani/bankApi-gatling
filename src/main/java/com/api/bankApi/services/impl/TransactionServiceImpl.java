package com.api.bankApi.services.impl;

import com.api.bankApi.exceptions.SystemException;
import com.api.bankApi.models.NewTransactionDto;
import com.api.bankApi.models.Transaction;
import com.api.bankApi.repositories.BankAccountRepository;
import com.api.bankApi.repositories.TransactionRepository;
import com.api.bankApi.services.ITransactionService;
import com.api.bankApi.utils.Limits;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 *
 * @author martin
 */
@Service
public class TransactionServiceImpl implements ITransactionService {

    private final TransactionRepository transactionRepository;
    private final BankAccountRepository bankAccountRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, BankAccountRepository bankAccountRepository) {
        this.transactionRepository = transactionRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Mono<BigDecimal> getBalance() {
        return bankAccountRepository.getAccountBalance().subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<String> depositFunds(NewTransactionDto transaction) {
        return verifyTransactionLimits(transaction, Limits.DEPOSIT)
                .filter(verified -> verified.equalsIgnoreCase("verified"))
                .flatMap(save -> {
                    var txn = Transaction.builder().amount(transaction.amount()).creationDate(LocalDateTime.now()).reference(transaction.reference())
                            .transaction_type(Limits.DEPOSIT.toString()).build();
                    return transactionRepository.save(txn).publishOn(Schedulers.boundedElastic())
                            .doOnNext(saved -> updateAccountbalance(saved.getAmount(), "DEPOSIT"))
                            .map(resp -> "Funds deposited successfully.");
                });
    }

    @Override
    public Mono<String> withdrawFunds(NewTransactionDto transaction) {
        return bankAccountRepository.getAccountBalance()
                .subscribeOn(Schedulers.boundedElastic())
                .filter(bal -> bal.compareTo(transaction.amount()) > 0)
                .switchIfEmpty(Mono.error(new SystemException("Insufficient funds.")))
                .flatMap(verify -> verifyTransactionLimits(transaction, Limits.WITHDRAWAL))
                .filter(verified -> verified.equalsIgnoreCase("verified"))
                .flatMap(save -> {
                    var txn = Transaction.builder().amount(transaction.amount()).creationDate(LocalDateTime.now()).reference(transaction.reference())
                            .transaction_type(Limits.WITHDRAWAL.toString()).build();
                    return transactionRepository.save(txn).publishOn(Schedulers.boundedElastic())
                            .doOnNext(saved -> updateAccountbalance(saved.getAmount(), "WITHDRAWAL"))
                            .map(resp -> "Funds Withdrawn successfully");
                });
    }

    private Mono<String> verifyTransactionLimits(NewTransactionDto transaction, Limits txn_type) {
        return transactionRepository.getAccountlimits(txn_type.toString())
                .publishOn(Schedulers.boundedElastic())
                .log()
                .map(acc_lim -> {
                    var max_txn_amt = BigDecimal.valueOf(txn_type.valueOfmaxTransactionAmount());
                    var max_daily_amt = BigDecimal.valueOf(txn_type.valueOfmaxDailyAmount());
                    var max_txn_count = txn_type.valueOfmaxTransactions();
                    if (transaction.amount().compareTo(max_txn_amt) > 0) {
                        throw new SystemException(String.format("Exceeded maximum %s per transaction", txn_type.toString().toLowerCase()));
                    }
                    if (acc_lim.total_transactions().add(transaction.amount()).compareTo(max_daily_amt) > 0) {
                        throw new SystemException(String.format("Exceeded maximum total %s amounts per day", txn_type.toString().toLowerCase()));
                    }
                    
                    if(transaction.amount().compareTo(BigDecimal.ZERO) < 0) {
                        throw new SystemException("Negative amounts not allowed");
                    }

//                    if (acc_lim.frequency() >= max_txn_count) {
//                        throw new SystemException(String.format("Exceeded total number of %ss allowed per day", txn_type.toString().toLowerCase()));
//                    }
                    return "verified";
                });

    }

    private void updateAccountbalance(BigDecimal amount, String txn_type) {
        getBalance().subscribe(bal -> {
            if (txn_type.equals(Limits.DEPOSIT.toString())) {
                bankAccountRepository.updateAccountBalance(bal.add(amount)).publishOn(Schedulers.boundedElastic()).subscribe();
            } else {
                bankAccountRepository.updateAccountBalance(bal.subtract(amount)).publishOn(Schedulers.boundedElastic()).subscribe();
            }
        });
    }

}
