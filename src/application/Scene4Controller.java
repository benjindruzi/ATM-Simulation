package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene4Controller implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	Label label1;
	
	@FXML
	TextField textField5;
	
	ATM atm = new ATM();
	
	String name = "";
	String password = "";
	double checking;
	double savings;
	
	public void handle(ActionEvent event) {
		double balance = Double.valueOf(label1.getText());
		double newBalance = Double.valueOf(textField5.getText());
		balance += newBalance;
		checking += balance;
		for (User user: atm.getUsers()) {
			if (name.equals(user.getName()) && password.equals(user.getPassword())) {
				label1.setText(String.valueOf(checking));
			}
		}
	}
	
	public void handle2(ActionEvent event) {
		double balance = Double.valueOf(label1.getText());
		double newBalance = Double.valueOf(textField5.getText());
		balance -= newBalance;
		checking += balance;
		
		for (User user: atm.getUsers()) {
			if (name.equals(user.getName()) && password.equals(user.getPassword())) {
				label1.setText(String.valueOf(checking));
			}
		}
	}
	
	public void backToScene3(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
		root = loader.load();
		Scene3Controller three = loader.getController();
		three.atm.setUsers(this.atm.getUsers());
		three.checking = checking;
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}