package com.anz.wseapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "ACCOUNT_TRANSACTION_DETAILS")
public class AccountTransactionDetails {
    @Id
    @GeneratedValue
    private Long transactionId;
    private Long accountId;
    private Date valueDate;
    private Double debitAmount;
    private Double creditAmount;
    private String transactionType;
    private String transactionNarrative;
}
