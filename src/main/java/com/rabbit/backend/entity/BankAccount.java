package com.rabbit.backend.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long accountNumber;

	private BigDecimal balance;

	@OneToMany(mappedBy = "bankAccount")
	private List<UserBankAccount> userBankAccounts;

}