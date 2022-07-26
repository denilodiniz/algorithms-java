package model.exceptions;

public class AccountDepositException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public AccountDepositException(String msg) {
		super(msg);
	}

}
