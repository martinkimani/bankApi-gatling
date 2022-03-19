package com.api.bankApi.repositories;

import com.api.bankApi.models.Account;
import java.math.BigDecimal;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 *
 * @author martin
 */
@Repository
public interface BankAccountRepository extends ReactiveSortingRepository<Account, Long>{
    @Query(value = "select balance from bank_account where id =1;")
    Mono<BigDecimal> getAccountBalance();
    
    @Query(value = "update bank_account set balance = :amount where id =1;")
    Mono<Void> updateAccountBalance(BigDecimal amount);
    
    
}
