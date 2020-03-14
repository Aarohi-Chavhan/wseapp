package com.anz.wseapp.util;

import com.anz.wseapp.dto.AccountDetailsDto;
import com.anz.wseapp.dto.AccountTransactionDataDto;
import com.anz.wseapp.model.AccountDetails;
import com.anz.wseapp.model.AccountTransactionData;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MapperUtlity {

    public AccountDetailsDto convertToDtoAccountDetails(AccountDetails data) {
        ModelMapper mapper = new ModelMapper();
        Converter<Date, String> toStringDate = new AbstractConverter<Date, String>() {
            @Override
            protected String convert(Date source) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                return format.format(source);
            }
        };
        mapper.addConverter(toStringDate);
        AccountDetailsDto acctDto = mapper.map(data, AccountDetailsDto.class);
        mapper.map(data.getBalanceDate(), acctDto.getBalanceDate());
        return acctDto;
    }

    public AccountTransactionDataDto convertToDtoAccountTxData(AccountTransactionData data){
        ModelMapper mapper = new ModelMapper();
        Converter<Date, String> toStringDate = new AbstractConverter<Date, String>() {
            @Override
            protected String convert(Date source) {
                SimpleDateFormat format = new SimpleDateFormat("MMM. dd, yyyy");
                return format.format(source);
            }
        };
        Converter<Double, String> toStringDouble = new AbstractConverter<Double, String>() {
            @Override
            protected String convert(Double amt) {
                if(Double.compare(amt, 0.00) == 0){
                    return "";
                } else{
                    return amt.toString();
                }
            }
        };
        Converter<String, String> formatAcctNo = new AbstractConverter<String, String>() {
            @Override
            protected String convert(String accountSrc) {
                String fmtAcct = accountSrc.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
                return fmtAcct;
            }
        };
        mapper.addConverter(toStringDate);
        mapper.addConverter(toStringDouble);
        mapper.addConverter(formatAcctNo);
        AccountTransactionDataDto txDto = mapper.map(data, AccountTransactionDataDto.class);
        mapper.map(data.getValueDate(),txDto.getValueDate());
        mapper.map(data.getDebitAmount(), txDto.getDebitAmount());
        mapper.map(data.getCreditAmount(), txDto.getCreditAmount());
        mapper.map(data.getAccountNumber(), txDto.getAccountNumber());
        return txDto;
    }
}
