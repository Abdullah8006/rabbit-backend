package com.rabbit.backend.service;

import com.rabbit.backend.entity.BankAccount;
import com.rabbit.backend.entity.User;
import com.rabbit.backend.entity.UserBankAccount;
import com.rabbit.backend.model.BankAccountDto;
import com.rabbit.backend.model.UserDto;
import com.rabbit.backend.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BankAccountService {

	private final BankAccountRepository bankAccountRepository;

	public List<BankAccountDto> getForId(Long id) {
		List<BankAccount> byBankAccountId = null;

		if (id != null)
			byBankAccountId = bankAccountRepository.findByBankAccountNumber(id);
		else
			byBankAccountId = bankAccountRepository.findAll();

		return byBankAccountId.stream().map(bankAccount -> {
			BankAccountDto dto = new BankAccountDto();
			dto.setAccountBalance(bankAccount.getBalance());
			dto.setAccountNumber(bankAccount.getAccountNumber());

			List<User> users = bankAccount.getUserBankAccounts().stream().map(UserBankAccount::getUser).collect(Collectors.toList());

			dto.setUsers(mapUserDto(users));
			return dto;
		}).collect(Collectors.toList());
	}

	private List<UserDto> mapUserDto(List<User> users) {
		return users.stream().map(user -> {
			UserDto dto = new UserDto();
			dto.setId(user.getId());
			dto.setName(user.getName());

			return dto;
		}).collect(Collectors.toList());
	}

}
