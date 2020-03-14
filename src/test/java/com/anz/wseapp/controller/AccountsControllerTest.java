package com.anz.wseapp.controller;

import com.anz.wseapp.dto.AccountDetailsDto;
import com.anz.wseapp.dto.AccountTransactionDataDto;
import com.anz.wseapp.exceptions.NoTransactionDetailsForAccountException;
import com.anz.wseapp.mockdata.AccountsMockData;
import com.anz.wseapp.service.AccountsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountsControllerTest extends AccountsMockData {

    @Mock
    AccountsService accountsService;

    @InjectMocks
    private AccountsController accountsController;

    @Test
    public void whenGetAllAccounts_thenReturnData() throws Exception {
        when(accountsService.getAllAccounts()).thenReturn(getAcctDetailsDtoList());
        ResponseEntity<List<AccountDetailsDto>> response = accountsController.getAllAccounts();
        assertEquals(4, response.getBody().size());
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void whenGetTransactionDetailsForAccount_WithValidAccount_thenReturnTransactionDetails() throws Exception{
        when(accountsService.getTransactionData("123456789")).thenReturn(getAcctTransactionDataDtoList());
        ResponseEntity<List<AccountTransactionDataDto>> response = accountsController.getTransactionData("123456789");
        assertEquals(2, response.getBody().size());
        assertEquals(200, response.getStatusCode().value());
    }
    @Test(expected = NoTransactionDetailsForAccountException.class)
    public void whenGetTransactionDetailsForAccount_WithInValidAccount_thenReturnTransactionDetails() throws Exception{
        when(accountsService.getTransactionData("36463846")).thenReturn(new ArrayList<>());
        accountsController.getTransactionData("36463846");
    }

}
