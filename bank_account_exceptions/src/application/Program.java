package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountCreationException;
import model.exceptions.AccountDepositException;
import model.exceptions.AccountWithdrawException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("-Enter account data-");
			System.out.print("Number: ");
			int accountNumber = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initional balance: ");
			double initionalBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(accountNumber, holder, initionalBalance, withdrawLimit);
			
			System.out.printf("%n%nEnter amount for withdraw: ");
			double withdraw = sc.nextDouble();
			account.withdraw(withdraw);
			
			System.out.println("New balance: $ " + account.getBalance());
			
			System.out.printf("%n%nEnter amount for deposit: ");
			double deposit = sc.nextDouble();
			account.deposit(deposit);
			System.out.println("New balance: $ " + account.getBalance());
		}
		catch (InputMismatchException e) {
			System.out.println("Wrongly typed data");
		}
		catch (AccountCreationException e) {
			System.out.println("Error creating an account: " + e.getMessage());
		}
		catch (AccountWithdrawException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (AccountDepositException e) {
			System.out.println("Deposit error: " + e.getMessage());
		}
		
		sc.close();

	}

}
