package com.anz.wseapp.repository;

import com.anz.wseapp.model.AccountTransactionData;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AccountTransactionDataRepository{
    @PersistenceContext
    private EntityManager em;

    public List<AccountTransactionData> getAccountTransactionData(String accountNumber){
        Query query = em.createQuery("Select NEW com.anz.wseapp.model.AccountTransactionData(act.accountNumber, act.accountName, tx.valueDate, act.currency, tx.debitAmount, tx.creditAmount, tx.transactionType, tx.transactionNarrative)" +
                " from AccountDetails act join AccountTransactionDetails tx on act.accountId = tx.accountId where act.accountNumber =:accountNo", AccountTransactionData.class);
        query.setParameter("accountNo", accountNumber);
        return  query.getResultList();

    }
}
