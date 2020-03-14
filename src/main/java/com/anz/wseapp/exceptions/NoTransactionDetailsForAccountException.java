package com.anz.wseapp.exceptions;

public class NoTransactionDetailsForAccountException extends RuntimeException {
    public NoTransactionDetailsForAccountException(String acctNo){
        super("No transaction details for account: "+acctNo + " or invalid account number");
    }
}
