package account.application;

import java.util.Locale;
import java.util.Scanner;

import account.model.entities.Account;
import account.model.exceptions.AccountException;
import rooms.model.exceptions.DomainException;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			System.out.println();
			
			Account account = new Account(number, holder, initialBalance, withdrawLimit);
			
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			
			System.out.println();
			System.out.printf("Novo saldo: %.2f%n", account.getBalance());
		}
		catch(AccountException e) {
			System.out.println("Witdraw error: " + e.getMessage());
		}
		
		sc.close();
	}

}
