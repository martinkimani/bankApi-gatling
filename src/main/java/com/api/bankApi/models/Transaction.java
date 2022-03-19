package com.api.bankApi.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author martin
 */
@ToString
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(value = "transactions")
public class Transaction implements Serializable {
    
    @Id
    @Column(value = "id")
    private int id;
    
    @Column(value = "transaction_type")
    private String transaction_type;
    
    @Column(value = "reference")
    private String reference;

    @Column(value = "amount")
    private BigDecimal amount;
    
    @Column(value = "creation_date")
    private LocalDateTime creationDate;
    
    
}
