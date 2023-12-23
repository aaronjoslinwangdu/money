package com.aaronjoslinwangdu.money.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronjoslinwangdu.money.account.domain.Account;
import com.aaronjoslinwangdu.money.account.dto.AccountDTO;
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
	
	public Account saveAccount(AccountDTO request) {
		
		Account account;
		account = Account.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.location(request.getLocation())
				.build();
	
		return accountJpaRepository.save(account);
	}
	
	public void deleteAccountByDbky(Long accountDbky) {
		accountJpaRepository.deleteById(accountDbky);
	}
	
}
