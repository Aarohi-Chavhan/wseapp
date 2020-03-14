package com.anz.wseapp.integration;

import com.anz.wseapp.WholesaleEngineeringApp;
import com.anz.wseapp.service.AccountsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = WholesaleEngineeringApp.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class WholesaleEngineeringAppIntegrationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private AccountsService accountsService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllAccounts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/allAccounts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetTransactionDetailsForValidAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/getTransactionData/{accountNo}", "328745968").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetTransactionDetailsForInValidAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/getTransactionData/{accountNo}", "123456789").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
