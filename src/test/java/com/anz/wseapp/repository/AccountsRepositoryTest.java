package com.anz.wseapp.repository;

import com.anz.wseapp.WholesaleEngineeringApp;
import com.anz.wseapp.model.AccountDetails;
import com.anz.wseapp.model.AccountTransactionData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = NONE)
@SpringBootTest(classes={WholesaleEngineeringApp.class})
public class AccountsRepositoryTest {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private AccountTransactionDataRepository transactionDataRepository;

    @Test
    public void whenGetAllAccounts_findAll(){
        List<AccountDetails> data = new ArrayList<>();
        accountsRepository.findAll().forEach(account -> data.add(account));
        Assert.assertEquals(6, data.size());
    }

    @Test
    public void getTransactionDetails_getAllForValidAccountProvided(){
        List<AccountTransactionData> data = transactionDataRepository.getAccountTransactionData("321143048");
        Assert.assertEquals(5, data.size());
    }

    @Test
    public void getEmptyTransactionDetails_getAllForInValidAccountProvided(){
        List<AccountTransactionData> data = transactionDataRepository.getAccountTransactionData("123456789");
        Assert.assertEquals(0, data.size());
    }
}
