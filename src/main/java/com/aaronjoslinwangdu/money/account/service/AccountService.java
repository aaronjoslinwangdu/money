package com.aaronjoslinwangdu.money.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronjoslinwangdu.money.account.domain.Account;
import com.aaronjoslinwangdu.money.account.dto.AccountDTO;
import com.aaronjoslinwangdu.money.account.mapper.AccountMapper;
import com.aaronjoslinwangdu.money.account.repository.AccountJpaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	/** The constant Account JPA Repository */
	@Autowired
	private AccountJpaRepository accountJpaRepository;
	
	/** The constant Account mapper */
	@Autowired
	private AccountMapper accountMapper;
	
	/**
	 * Get all Accounts
	 * 
	 * @return List<Account>
	 */
	public List<Account> getAllAccounts() {
		return accountJpaRepository.findAll();
	}
	
	
	/**
	 * Gets an existing Account
	 * 
	 * @param accountDbky
	 * @return
	 */
	public Optional<Account> findAccountByDbky(Long accountDbky) {
		return accountJpaRepository.findById(accountDbky);
	}
	
	
	/**
	 * Adds a new account
	 * 
	 * @param request
	 * @return
	 */
	public Account addAccount(AccountDTO request) {
		
		Account account;
		account = Account.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.location(request.getLocation())
				.build();
	
		return accountJpaRepository.save(account);
	}
	
	
	/**
	 * Deletes an existing Account
	 * 
	 * @param accountDbky
	 */
	public void deleteAccountByDbky(Long accountDbky) {
		accountJpaRepository.deleteById(accountDbky);
	}
	
	
	/**
	 * Updates an existing Account
	 * 
	 * @param accountId
	 * @param request
	 */
	public void updateAccount(Long accountId, AccountDTO request) {
		Optional<Account> existingAccount = accountJpaRepository.findById(accountId);
		if (existingAccount.isPresent()) {
			accountMapper.updateValuesToAccountEntity(request, existingAccount.get());
			accountJpaRepository.save(existingAccount.get());
		}
	}
	
}
