package com.aaronjoslinwangdu.money.account.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	private final AccountJpaRepository accountJpaRepository;
	
	/** The constant Account mapper */
	private final AccountMapper accountMapper;
	
	/**
	 * Get all Accounts
	 * 
	 * @return List<Account>
	 */
	public List<AccountDTO> getAllAccounts() {
		List<Account> accounts = accountJpaRepository.findAll();
		return accounts.stream().map(account -> accountMapper.convertAccountDomainToDto(account)).collect(Collectors.toList());
	}
	
	
	/**
	 * Gets an existing Account
	 * 
	 * @param accountDbky
	 * @return
	 */
	public AccountDTO findAccountByDbky(Long accountDbky) {
		Account account = accountJpaRepository.findById(accountDbky).orElse(null);
		return accountMapper.convertAccountDomainToDto(account);
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
				.email(request.getEmail())
				.username(request.getUsername())
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.location(request.getLocation())
				.build();
		account.setPrincipal(request.getCreatedBy());
		
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
