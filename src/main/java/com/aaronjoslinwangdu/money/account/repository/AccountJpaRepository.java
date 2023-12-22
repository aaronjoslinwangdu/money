package com.aaronjoslinwangdu.money.account.repository;

import com.aaronjoslinwangdu.money.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountJpaRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account>{

}
