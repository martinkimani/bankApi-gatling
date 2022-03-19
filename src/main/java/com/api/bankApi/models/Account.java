package com.api.bankApi.models;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author martin
 */
@ToString
@EqualsAndHashCode
@Data
@AllArgsConstructor
@Table(value = "bank_account")
public class Account {
    private int id;
    private BigDecimal balance;
    
}
