package com.rabbit.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class BankAccountDto {
	private long accountNumber;
	private BigDecimal accountBalance;

	private List<UserDto> users;
}
