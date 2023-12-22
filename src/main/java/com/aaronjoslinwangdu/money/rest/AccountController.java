package com.aaronjoslinwangdu.money.rest;

import java.util.Optional;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaronjoslinwangdu.money.account.domain.Account;
import com.aaronjoslinwangdu.money.account.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping(path = "/{accountId}")
	public @ResponseBody Optional<Account> getAccountByIdAccount (@PathVariable Long accountId) {
		return accountService.findAccountByDbky(accountId);
	}
	
	@PostMapping(path = "/add")
	public @ResponseBody Account saveAccount(Account account) {
		return accountService.saveAccount(account);
	}
	
}
