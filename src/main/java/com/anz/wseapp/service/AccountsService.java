package com.anz.wseapp.service;

import com.anz.wseapp.dto.AccountDetailsDto;
import com.anz.wseapp.dto.AccountTransactionDataDto;
import com.anz.wseapp.model.AccountDetails;
import com.anz.wseapp.model.AccountTransactionData;
import com.anz.wseapp.repository.AccountTransactionDataRepository;
import com.anz.wseapp.repository.AccountsRepository;
import com.anz.wseapp.util.MapperUtlity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private AccountTransactionDataRepository transactionDataRepository;

    @Autowired
    private MapperUtlity mapperUtlity;


    public List<AccountDetailsDto> getAllAccounts(){
        List<AccountDetails> accountDetailsList = new ArrayList<>();
        accountsRepository.findAll().forEach(account -> accountDetailsList.add(account));
        return accountDetailsList.stream().map(this.mapperUtlity::convertToDtoAccountDetails).collect(Collectors.toList());
    }

    public List<AccountTransactionDataDto> getTransactionData(String accountNumber){
        List<AccountTransactionData> list = transactionDataRepository.getAccountTransactionData(accountNumber);
        return list.stream().map(this.mapperUtlity::convertToDtoAccountTxData).collect(Collectors.toList());
    }
}