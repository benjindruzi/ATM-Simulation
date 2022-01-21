package application;

public class CheckingAccount {
	private double balance = 0;
	
	CheckingAccount(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double newBalance) {
		balance += newBalance;
	}
	
	public void withdraw(double newBalance) {
		balance -= newBalance;
	}
}
