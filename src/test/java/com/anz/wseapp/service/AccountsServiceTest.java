package com.anz.wseapp.service;

import com.anz.wseapp.WholesaleEngineeringApp;
import com.anz.wseapp.dto.AccountDetailsDto;
import com.anz.wseapp.dto.AccountTransactionDataDto;
import com.anz.wseapp.mockdata.AccountsMockData;
import com.anz.wseapp.repository.AccountTransactionDataRepository;
import com.anz.wseapp.repository.AccountsRepository;
import com.anz.wseapp.util.MapperUtlity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes={WholesaleEngineeringApp.class})
public class AccountsServiceTest extends AccountsMockData {

    @InjectMocks
    private AccountsService accountsService;

    @Mock
    private MapperUtlity mapperUtlity;

    @Mock
    private AccountsRepository accountsRepository;

    @Mock
    private AccountTransactionDataRepository transactionDataRepository;

    @Test
    public void whenGetAllAccounts_thenReturnAllAccount() throws ParseException {
        when(accountsRepository.findAll()).thenReturn(getAcctDetailsList());
        when(mapperUtlity.convertToDtoAccountDetails(any())).thenReturn(getAcctDetailsDtoList().get(0));

        List<AccountDetailsDto> list = accountsService.getAllAccounts();

        Assert.assertEquals(4, list.size());
    }

    @Test
    public void whenGetTransactionDetails_thenReturnDetails() throws ParseException {
        when(transactionDataRepository.getAccountTransactionData("123456789")).thenReturn(getAcctTransactionDataList());
        when(mapperUtlity.convertToDtoAccountTxData(any())).thenReturn(getAcctTransactionDataDtoList().get(0));
        List<AccountTransactionDataDto> list = accountsService.getTransactionData("123456789");
        Assert.assertEquals(2, list.size());
    }
}
