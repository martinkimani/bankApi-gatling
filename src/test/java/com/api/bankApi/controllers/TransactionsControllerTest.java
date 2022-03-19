package com.api.bankApi.controllers;

import com.api.bankApi.controllers.TransactionsController;
import com.api.bankApi.models.NewTransactionDto;
import com.api.bankApi.services.ITransactionService;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

/**
 *
 * @author martin
 */
@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = TransactionsController.class)
public class TransactionsControllerTest {

    @MockBean
    private ITransactionService transactionService;

    @Autowired
    private WebTestClient webClient;

    @Test
    @DisplayName("test deposit of funds")
    void depositFundsIT() {
        NewTransactionDto deposit = new NewTransactionDto("SRGEW532", BigDecimal.valueOf(10));

        Mockito.when(transactionService.depositFunds(deposit)).thenReturn(Mono.just("Funds deposited successfully."));

        webClient.post()
                .uri("/account/api/deposit")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(deposit))
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Funds deposited successfully.");
    }

    @Test
    @DisplayName("test get balance")
    void getBalanceIT() {
        NewTransactionDto deposit = new NewTransactionDto("SRGEW532", BigDecimal.valueOf(10));

        Mockito.when(transactionService.getBalance()).thenReturn(Mono.just(BigDecimal.valueOf(20.0)));

        webClient.get()
                .uri("/account/api/balance")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("20.0");
    }

    @Test
    @DisplayName("test withdraw of funds")
    void withdrawFundsIT() {
        NewTransactionDto withdraw = new NewTransactionDto("SRGEW532", BigDecimal.valueOf(10));

        Mockito.when(transactionService.withdrawFunds(withdraw)).thenReturn(Mono.just("Funds Withdrawn successfully."));

        webClient.post()
                .uri("/account/api/withdraw")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(withdraw))
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Funds Withdrawn successfully.");
    }

}
