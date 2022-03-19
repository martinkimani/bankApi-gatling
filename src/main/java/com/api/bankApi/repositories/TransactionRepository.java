package com.api.bankApi.repositories;

import com.api.bankApi.models.AccountLimits;
import com.api.bankApi.models.Transaction;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 *
 * @author martin
 */
@Repository
public interface TransactionRepository extends ReactiveSortingRepository<Transaction, Long> {
    
    @Override
    Mono<Transaction> save(Transaction transaction);
    
        
    @Query(value = "select ifnull(sum(amount),0) as total_transactions, count(id) as frequency from transactions "
            + "where transaction_type = :txn_type and FORMATDATETIME(creation_date,'yyyy-MM-dd') = current_date() ;")
    Mono<AccountLimits> getAccountlimits(String txn_type);
    
    
}
