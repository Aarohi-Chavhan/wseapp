package com.anz.wseapp.model;

import com.anz.wseapp.util.Currency;
import lombok.Data;

import java.util.Date;

@Data
public class AccountTransactionData {
    private String accountNumber;
    private String accountName;
    private Date valueDate;
    private Currency currency;
    private Double debitAmount;
    private Double creditAmount;
    private String transactionType;
    private String  transactionNarrative;

    public AccountTransactionData(String accountNumber, String accountName, Date valueDate, Currency currency, Double debitAmount, Double creditAmount, String transactionType, String transactionNarrative) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.valueDate = valueDate;
        this.currency = currency;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.transactionType = transactionType;
        this.transactionNarrative = transactionNarrative;
    }
}
