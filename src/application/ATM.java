package application;

import java.io.IOException;
import java.util.ArrayList;

public class ATM {
	private ArrayList<User> users = new ArrayList<User>();
	
	public ArrayList<User> getUsers() {
		return this.users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public void save(User user) throws IOException {
		users.add(user);
	}
}