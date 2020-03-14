package com.anz.wseapp.model;

import com.anz.wseapp.util.AccountType;
import com.anz.wseapp.util.Currency;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ACCOUNT_DETAILS")
public class AccountDetails {
    @Id
    @GeneratedValue
    private Long accountId;

    private String accountNumber;
    private String accountName;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private Currency currency;
    private Date balanceDate;
    private Double openAvailableBalance;

    public AccountDetails(Long accountId, String accountNumber, String accountName, AccountType accountType, Currency currency, Date balanceDate, Double openAvailableBalance) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.currency = currency;
        this.balanceDate = balanceDate;
        this.openAvailableBalance = openAvailableBalance;
    }

    public AccountDetails() {
    }
}
