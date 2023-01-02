package com.rabbit.backend.controller;

import com.rabbit.backend.model.BankAccountDto;
import com.rabbit.backend.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bank-account")
@RequiredArgsConstructor
public class BankAccountController {

	private final BankAccountService bankAccountService;

	@GetMapping()
	public List<BankAccountDto> getBankAccount(@RequestParam(required = false) Long id) {
		return bankAccountService.getForId(id);
	}
}
