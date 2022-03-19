package com.api.bankApi.controllers;

import com.api.bankApi.exceptions.SystemException;
import com.api.bankApi.models.NewTransactionDto;
import com.api.bankApi.services.ITransactionService;
import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author martin
 */
@RestController
@RequestMapping("/account/api/")
public class TransactionsController {
    
    private final ITransactionService transactionsService;
    
    public TransactionsController(ITransactionService transactionsService) {
        this.transactionsService = transactionsService;
    }
    
    @GetMapping("/balance")
    public Mono<BigDecimal> getBalance() {
        return transactionsService.getBalance()
                .onErrorReturn(BigDecimal.ZERO);
    }
    
    @PostMapping("/deposit")
    public Mono<ResponseEntity> depositFunds(@RequestBody NewTransactionDto transaction) {
        return transactionsService.depositFunds(transaction)
                .map(resp -> new ResponseEntity(resp, HttpStatus.OK))
                .onErrorResume(SystemException.class, re -> Mono.just(new ResponseEntity(re.getMessage(), HttpStatus.BAD_REQUEST)));
    }
    
    @PostMapping("/withdraw")
    public Mono<ResponseEntity> withdrawFunds(@RequestBody NewTransactionDto transaction) {
        return transactionsService.withdrawFunds(transaction)
                .map(resp -> new ResponseEntity(resp, HttpStatus.OK))
                .onErrorResume(SystemException.class, re -> Mono.just(new ResponseEntity(re.getMessage(), HttpStatus.BAD_REQUEST)));
    }
}
