package com.anz.wseapp.dto;

import com.anz.wseapp.util.AccountType;
import com.anz.wseapp.util.Currency;
import lombok.Data;

@Data
public class AccountDetailsDto {
    private String accountNumber;
    private String accountName;
    private AccountType accountType;
    private Currency currency;
    private String balanceDate;
    private Double openAvailableBalance;

    public AccountDetailsDto(String accountNumber, String accountName, AccountType accountType, Currency currency, String balanceDate, Double openAvailableBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.currency = currency;
        this.balanceDate = balanceDate;
        this.openAvailableBalance = openAvailableBalance;
    }

    public AccountDetailsDto() {
    }
}
