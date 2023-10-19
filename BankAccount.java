package Sample;
import java.util.*;

public class BankAccount {
	private int accountno;
	private String name;
	private double balance;
	private double minbalance;
	
	public BankAccount(int accountno, String name, double minbalance) {
		this.accountno=accountno;
		this.name=name;
		this.minbalance=minbalance;
	}
	
	public void deposit(double amount) {
		if (amount>0) {
			balance+=amount;
			System.out.println("Deposit of $ "+amount+" successful.");
		}
		else {
			System.out.println("Invalid deposit.");
		}
	}
	
	public void withdraw(double amount) {
		if (balance-amount>=minbalance && amount>0) {
			balance-=amount;
			System.out.println("Withdrawal of $ "+amount+" successful.");
		}
		else {
			System.out.println("Insufficient balance or invalid withdrawal amount.");			
		}
	}
	public double getbalance() {
		return balance;
	}
	 public static void main(String []args) {
		 BankAccount b = new BankAccount(1234,"Anshad",100);
		 b.deposit(500);
		 b.withdraw(200);
		 b.withdraw(250);
		 
		System.out.println("Account No : "+b.accountno);
		System.out.println("Account holder name : "+b.name);
		System.out.println("Balance : "+b.getbalance());

	 }
	
	
	

}
