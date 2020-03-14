package com.anz.wseapp.mockdata;

import com.anz.wseapp.dto.AccountDetailsDto;
import com.anz.wseapp.dto.AccountTransactionDataDto;
import com.anz.wseapp.model.AccountDetails;
import com.anz.wseapp.model.AccountTransactionData;
import com.anz.wseapp.util.AccountType;
import com.anz.wseapp.util.Currency;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountsMockData {
    public List<AccountDetailsDto> getAcctDetailsDtoList(){
        AccountDetailsDto dto1 = new AccountDetailsDto("189234569", "AUSavings123", AccountType.SAVINGS , Currency.AUD, "08/11/2018", 1673469.98);
        AccountDetailsDto dto2 = new AccountDetailsDto("765419834", "AUCurrent123", AccountType.CURRENT, Currency.AUD, "07/07/2013", 4563.25);
        AccountDetailsDto dto3 = new AccountDetailsDto("547834902", "SGSavings902", AccountType.SAVINGS, Currency.SGD, "01/04/2016", 56423.20);
        AccountDetailsDto dto4 = new AccountDetailsDto("098561234", "INRCurrent123", AccountType.CURRENT, Currency.INR, "03/03/2012", 65432.25);

        List<AccountDetailsDto> data = new ArrayList<>();
        data.add(dto1);
        data.add(dto2);
        data.add(dto3);
        data.add(dto4);

        return data;
    }

    public List<AccountDetails> getAcctDetailsList() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        AccountDetails data1 = new AccountDetails(1l,"189234569", "AUSavings123", AccountType.SAVINGS , Currency.AUD, formatter.parse("08/11/2018"), 1673469.98);
        AccountDetails data2 = new AccountDetails(2l,"765419834", "AUCurrent123", AccountType.CURRENT, Currency.AUD, formatter.parse("07/07/2013"), 4563.25);
        AccountDetails data3 = new AccountDetails(3l,"547834902", "SGSavings902", AccountType.SAVINGS, Currency.SGD, formatter.parse("01/04/2016"), 56423.20);
        AccountDetails data4 = new AccountDetails(4l,"098561234", "INRCurrent123", AccountType.CURRENT, Currency.INR, formatter.parse("03/03/2012"), 65432.25);

        List<AccountDetails> data = new ArrayList<>();
        data.add(data1);
        data.add(data2);
        data.add(data3);
        data.add(data4);

        return data;
    }

    public List<AccountTransactionDataDto> getAcctTransactionDataDtoList(){
        AccountTransactionDataDto obj1 = new AccountTransactionDataDto("123456789", "AUSavings123", "Jan. 12, 2019", Currency.AUD, "1234.34", "", "Debit", "Debit Tx");
        AccountTransactionDataDto obj2 = new AccountTransactionDataDto("123456789", "AUSavings123", "Jan. 15, 2019", Currency.AUD, "", "5647.23", "Credit", "Credit Tx");

        List<AccountTransactionDataDto> data = new ArrayList<>();
        data.add(obj1);
        data.add(obj2);

        return data;
    }

    public List<AccountTransactionData> getAcctTransactionDataList() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM. dd, yyyy");
        AccountTransactionData obj1 = new AccountTransactionData("123456789", "AUSavings123", formatter.parse("Jan. 12, 2019"), Currency.AUD, 1234.34, 0.00, "Debit", "Debit Tx");
        AccountTransactionData obj2 = new AccountTransactionData("123456789", "AUSavings123", formatter.parse("Jan. 15, 2019"), Currency.AUD, 0.00, 5647.23, "Credit", "Credit Tx");

        List<AccountTransactionData> data = new ArrayList<>();
        data.add(obj1);
        data.add(obj2);

        return data;
    }
}
