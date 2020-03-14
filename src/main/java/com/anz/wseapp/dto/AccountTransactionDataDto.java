package com.anz.wseapp.dto;

import com.anz.wseapp.util.Currency;
import lombok.Data;

@Data
public class AccountTransactionDataDto {
    private String accountNumber;
    private String accountName;
    private String valueDate;
    private Currency currency;
    private String debitAmount;
    private String creditAmount;
    private String transactionType;
    private String  transactionNarrative;

    public AccountTransactionDataDto(String accountNumber, String accountName, String valueDate, Currency currency, String debitAmount, String creditAmount, String transactionType, String transactionNarrative) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.valueDate = valueDate;
        this.currency = currency;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.transactionType = transactionType;
        this.transactionNarrative = transactionNarrative;
    }

    public AccountTransactionDataDto() {
    }
}
