package com.api.bankApi.perfomance;

import com.api.bankApi.models.NewTransactionDto;
import io.gatling.javaapi.core.CoreDsl;
import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.bodyString;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.global;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import static io.gatling.javaapi.http.HttpDsl.header;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author martin
 */
public class TransactionSimulation extends Simulation {

    // Protocol Definition
    HttpProtocolBuilder httpProtocol = HttpDsl.http
        .baseUrl("http://localhost:8080")
        .acceptHeader("application/json")
        .userAgentHeader("Gatling/Performance Test");

    Iterator<Map<String, Object>> feeder
        = Stream.generate((Supplier<Map<String, Object>>) () -> {
            NewTransactionDto deposit = new NewTransactionDto(UUID.randomUUID().toString(), generateRandAmount(1.00, 3.00));
            return Collections.singletonMap("deposit", deposit);
        }
        ).iterator();
    
    ScenarioBuilder scn = CoreDsl.scenario("Load Test posting deposits")
        .feed(feeder)
        .exec(http("post-deposit-request")
        .post("/account/api/deposit")
        .header("Content-Type", "application/json")
        .body(StringBody("{ \"reference\": \"${deposit.reference}\",\"amount\": ${deposit.amount} }"))
        .check(status().is(200))
        )
        .exec(http("check balance after deposit")
        .get("/account/api/balance")
        .check(bodyString().not("0")));
        
    public TransactionSimulation() {
        this.setUp(scn.injectOpen(constantUsersPerSec(60).during(Duration.ofSeconds(60)).randomized()))
        .protocols(httpProtocol)
        .assertions(
             global().responseTime().max().lt(200),
             global().successfulRequests().percent().gt(95.0)
         );
    }    

    private BigDecimal generateRandAmount(Double min, Double max) {
        return new BigDecimal(((Math.random() * (max - min)) + min)).setScale(2, RoundingMode.HALF_UP);
    }
}
