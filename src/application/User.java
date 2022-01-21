package application;

public class User {
	private String name;
	private String password;
	CheckingAccount ca = new CheckingAccount(0);
	SavingsAccount sa = new SavingsAccount(0);
	
	User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return this.name+" "+this.password; 
	}
}
