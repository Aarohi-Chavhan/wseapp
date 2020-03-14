package com.anz.wseapp.repository;

import com.anz.wseapp.model.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountsRepository extends JpaRepository<AccountDetails, Long> {
}
