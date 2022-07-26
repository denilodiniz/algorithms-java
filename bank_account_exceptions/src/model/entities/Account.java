package model.entities;

import model.exceptions.AccountCreationException;
import model.exceptions.AccountDepositException;
import model.exceptions.AccountWithdrawException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws AccountCreationException {
		String numberAccount = String.valueOf(number);
		if (numberAccount.length() != 4) {
			throw new AccountCreationException("account number invalid");
		}
		
		if (balance < 0) {
			throw new AccountCreationException("initional balance cannot be less than zero");
		}
		if (withdrawLimit < 1) {
			throw new AccountCreationException("withdrawal limit cannot be less than one");
		}
		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) throws AccountDepositException{
		if (amount < 0) {
			throw new AccountDepositException("the deposit amount cannot be less than zero");
		}
		
		balance += amount;
	}
	
	public void withdraw(double amount) throws AccountWithdrawException {
		if (amount > balance) {
			throw new AccountWithdrawException("the amount exceeds account balance");
		}
		if (amount > withdrawLimit) {
			throw new AccountWithdrawException("the amount exceeds withdraw limit");
		}
		
		balance -= amount;
	}
	
}	
