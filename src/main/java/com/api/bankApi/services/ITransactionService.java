package com.api.bankApi.services;

import com.api.bankApi.models.NewTransactionDto;
import java.math.BigDecimal;
import reactor.core.publisher.Mono;

/**
 *
 * @author martin
 */
public interface ITransactionService {
    
    public Mono<BigDecimal> getBalance();
    
    public Mono<String> depositFunds(NewTransactionDto transaction);
    
    public Mono<String> withdrawFunds(NewTransactionDto transaction);
}
