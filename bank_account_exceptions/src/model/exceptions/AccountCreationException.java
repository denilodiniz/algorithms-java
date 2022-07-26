package model.exceptions;

public class AccountCreationException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AccountCreationException(String msg) {
		super(msg);
	}
}
