package com.api.bankApi.models;

import java.math.BigDecimal;

/**
 *
 * @author martin
 */
public record AccountLimits(BigDecimal total_transactions,int frequency) {
    
}
