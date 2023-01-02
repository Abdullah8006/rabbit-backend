package com.rabbit.backend.repository;

import com.rabbit.backend.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

	@Query("Select distinct ba from BankAccount ba join fetch ba.userBankAccounts uba join fetch uba.user user")
	public List<BankAccount> findAll();

	@Query("Select distinct ba from BankAccount ba join fetch ba.userBankAccounts uba join fetch uba.user user where ba.accountNumber = ?1")
	public List<BankAccount> findByBankAccountNumber(long accountNumber);

}
