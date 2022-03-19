package com.api.bankApi.services;

import com.api.bankApi.models.NewTransactionDto;
import com.api.bankApi.models.Transaction;
import com.api.bankApi.repositories.BankAccountRepository;
import com.api.bankApi.repositories.TransactionRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 *
 * @author martin
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionServiceTest {
    
    @Autowired
    private ITransactionService transactionService;
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private BankAccountRepository bankAccountRepository;
    
    @Before
    public void init() {
        transactionRepository.deleteAll().block();
        bankAccountRepository.updateAccountBalance(BigDecimal.ZERO).block();
        
    }
    
    
    @Test
    @DisplayName("Test balance fetched correctly")
    void getBalanceSuccess() throws Exception {
        Mono<BigDecimal> mockResp = Mono.just(BigDecimal.ZERO);
        
        Mono<BigDecimal> balance = transactionService.getBalance();
        StepVerifier.create(balance)
                .assertNext(b -> assertEquals(mockResp.block().intValue(),b.intValue()))
                .expectComplete()
                .verify();
    }
    
    @Test
    @DisplayName("Test deposit is saved successfully")
    void depositFundsSuccess() throws Exception {
        
        Mono<String> txnResp = transactionService.depositFunds(new NewTransactionDto("QACE4545SX", BigDecimal.TEN));
        StepVerifier.create(txnResp)
                .assertNext(r -> assertEquals("Funds deposited successfully.",r))
                .expectComplete()
                .log()
                .verify();
    }
    
    @Test
    @DisplayName("Test deposit limit per transaction exceeded successfully")
    void depositLimitPerTransactionExceededSuccess() throws Exception {
        
        Mono<String> txnResp = transactionService.depositFunds(new NewTransactionDto("QACE4545SX", BigDecimal.valueOf(80000.00)));
        StepVerifier.create(txnResp)
                .expectErrorMessage("Exceeded maximum deposit per transaction")
                .log()
                .verify();
    }
    
    @Test
    @DisplayName("Test deposit limit for max daily amount exceeded successfully")
    void depositLimitDailyAmountExceededSuccess() throws Exception {
        
        for (int i = 0; i < 3; i++) {
            transactionRepository.save(Transaction.builder().amount(BigDecimal.valueOf(40000.00)).creationDate(LocalDateTime.now())
                    .reference("QEQE2332").transaction_type("DEPOSIT").build()).block();
        }
        
        Mono<String> txnResp = transactionService.depositFunds(new NewTransactionDto("QACE4545SX", BigDecimal.valueOf(40000.00)));
        StepVerifier.create(txnResp)
                .expectErrorMessage("Exceeded maximum total deposit amounts per day")
                .log()
                .verify();
    }
    
//    @Test
//    @DisplayName("Test deposit limit for max daily count exceeded successfully")
//    void depositLimitDailyCountAmountExceededSuccess() throws Exception {
//        for (int i = 0; i < 4; i++) {
//            transactionRepository.save(Transaction.builder().amount(BigDecimal.ONE).creationDate(LocalDateTime.now())
//                    .reference("QEQE2332").transaction_type("DEPOSIT").build()).block();
//        }
//        
//        Mono<String> txnResp = transactionService.depositFunds(new NewTransactionDto("QACE4545SX", BigDecimal.valueOf(10.00)));
//        StepVerifier.create(txnResp)
//                .expectErrorMessage("Exceeded total number of deposits allowed per day")
//                .log()
//                .verify();
//    }
    
    @Test
    @DisplayName("Test withdraw is saved successfully")
    void withdrawFundsSuccess() throws Exception {
        
        bankAccountRepository.updateAccountBalance(BigDecimal.valueOf(100.00)).block();
        
        Mono<String> txnResp = transactionService.withdrawFunds(new NewTransactionDto("QACE4545SX", BigDecimal.TEN));
        StepVerifier.create(txnResp)
                .assertNext(r -> assertEquals("Funds Withdrawn successfully",r))
                .expectComplete()
                .log()
                .verify();
    }
    
    @Test
    @DisplayName("Test withdraw limit per transaction exceeded successfully")
    void withdrawLimitPerTransactionExceededSuccess() throws Exception {
        
        bankAccountRepository.updateAccountBalance(BigDecimal.valueOf(100000.00)).block();
        
        Mono<String> txnResp = transactionService.withdrawFunds(new NewTransactionDto("QACE4545SX", BigDecimal.valueOf(80000.00)));
        StepVerifier.create(txnResp)
                .expectErrorMessage("Exceeded maximum withdrawal per transaction")
                .log()
                .verify();
    }
    
    @Test
    @DisplayName("Test withdraw limit for max daily amount exceeded successfully")
    void withdrawLimitDailyAmountExceededSuccess() throws Exception {
        bankAccountRepository.updateAccountBalance(BigDecimal.valueOf(100000.00)).block();
        
        for (int i = 0; i < 2; i++) {
            transactionRepository.save(Transaction.builder().amount(BigDecimal.valueOf(20000.00)).creationDate(LocalDateTime.now())
                    .reference("QEQE2332").transaction_type("WITHDRAWAL").build()).block();
        }
        
        Mono<String> txnResp = transactionService.withdrawFunds(new NewTransactionDto("QACE4545SX3", BigDecimal.valueOf(20000.00)));
        StepVerifier.create(txnResp)
                .expectErrorMessage("Exceeded maximum total withdrawal amounts per day")
                .log()
                .verify();
    }
    
    @Test
    @DisplayName("Test withdraw insufficient funds successfully")
    void withdrawInsufficientFundsSuccess() throws Exception {
        bankAccountRepository.updateAccountBalance(BigDecimal.valueOf(10.00)).block();
        
        Mono<String> txnResp = transactionService.withdrawFunds(new NewTransactionDto("QACE4545SXW", BigDecimal.valueOf(12.00)));
        StepVerifier.create(txnResp)
                .expectErrorMessage("Insufficient funds.")
                .log()
                .verify();
    }
    
//    @Test
//    @DisplayName("Test withdraw limit for max daily count exceeded successfully")
//    void withdrawLimitDailyCountAmountExceededSuccess() throws Exception {
//        bankAccountRepository.updateAccountBalance(BigDecimal.valueOf(10.00)).block();
//        transactionRepository.deleteAll().block();
//        
//        for (int i = 0; i < 3; i++) {
//            transactionRepository.save(Transaction.builder().amount(BigDecimal.valueOf(2.00)).creationDate(LocalDateTime.now())
//                    .reference("QEQE2332").transaction_type("WITHDRAWAL").build()).block();
//        }
//                
//        Mono<String> txnResp = transactionService.withdrawFunds(new NewTransactionDto("QACE4545SXW", BigDecimal.valueOf(2.00)));
//        StepVerifier.create(txnResp)
//                .expectErrorMessage("Exceeded total number of withdrawals allowed per day")
//                .log()
//                .verify();
//    }
}
