package com.aaronjoslinwangdu.money.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaronjoslinwangdu.money.account.domain.Account;
import com.aaronjoslinwangdu.money.account.dto.AccountDTO;
import com.aaronjoslinwangdu.money.account.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping(path = "/")
	public @ResponseBody List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}
	
	@GetMapping(path = "/{accountId}")
	public @ResponseBody Optional<Account> getAccountByIdAccount(@PathVariable Long accountId) {
		return accountService.findAccountByDbky(accountId);
	}
	
	@PostMapping(path = "/add")
	public void addAccount(@RequestBody AccountDTO accountDto) {
		accountService.addAccount(accountDto);
	}
	
	@PutMapping(path = "/{accountId}")
	public void updateAccount(@PathVariable Long accountId, @RequestBody AccountDTO accountDto) {
		accountService.updateAccount(accountId, accountDto);
	}
	
}
