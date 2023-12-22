package com.aaronjoslinwangdu.money.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronjoslinwangdu.money.account.domain.Account;
import com.aaronjoslinwangdu.money.account.repository.AccountJpaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	@Autowired
	private AccountJpaRepository accountJpaRepository;
	
	public Optional<Account> findAccountByDbky(Long accountDbky) {
		return accountJpaRepository.findById(accountDbky);
	}
	
	public Account saveAccount(Account account) {
		return accountJpaRepository.save(account);
	}
	
	public void deleteAccountByDbky(Long accountDbky) {
		accountJpaRepository.deleteById(accountDbky);
	}
	
}
