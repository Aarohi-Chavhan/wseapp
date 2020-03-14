package com.anz.wseapp.controller;

import com.anz.wseapp.dto.AccountDetailsDto;
import com.anz.wseapp.dto.AccountTransactionDataDto;
import com.anz.wseapp.exceptions.NoTransactionDetailsForAccountException;
import com.anz.wseapp.service.AccountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @GetMapping("/allAccounts")
    public ResponseEntity<List<AccountDetailsDto>> getAllAccounts(){
        log.info("Request received to retrieve all accounts from system..");
        return new ResponseEntity<>(accountsService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/getTransactionData/{accountNo}")

    public ResponseEntity<List<AccountTransactionDataDto>> getTransactionData(@PathVariable("accountNo") String accountNumber){
        log.info("Request received to retrieve transaction data for account from system..");
        List<AccountTransactionDataDto> trxDetails =  accountsService.getTransactionData(accountNumber);
        if(CollectionUtils.isEmpty(trxDetails)){
            log.error("Account Transactions retrieving issue..Check logs!!");
            throw new NoTransactionDetailsForAccountException(accountNumber);
        }
        log.info("Request completed to retrieve transaction data for account from system..");
        return new ResponseEntity<>(trxDetails, HttpStatus.OK);
    }
}
