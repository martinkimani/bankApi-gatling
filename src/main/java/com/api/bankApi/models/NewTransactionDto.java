package com.api.bankApi.models;

import java.math.BigDecimal;
import org.springframework.lang.NonNull;

/**
 *
 * @author martin
 */
public record NewTransactionDto (@NonNull String reference,@NonNull BigDecimal amount) {
    
}
