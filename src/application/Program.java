package application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.entities.CheckingAccount;
import model.exception.DomainException;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = input.nextInt();
			System.out.print("Holder: ");
			String holder = input.nextLine();
			input.nextLine();
			System.out.print("Initial balance: ");
			Double balance = input.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdraw = input.nextDouble();
			
			Account account = new CheckingAccount(number, holder, balance, withdraw);
			
			System.out.print("\nEnter amount for withdraw: ");
			Double amount = input.nextDouble();
			account.withdraw(amount);
			
			System.out.println("New balance: " + account.getBalance());
			//System.out.println("Account data:\n" + account.toString());
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		
		input.close();
	}
}
