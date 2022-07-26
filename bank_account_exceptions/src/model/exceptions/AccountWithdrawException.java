package model.exceptions;

public class AccountWithdrawException extends Exception{
	private static final long serialVersionUID = 1L;

	public AccountWithdrawException(String msg) {
		super(msg);
	}
	
}
