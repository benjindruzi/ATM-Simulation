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

public class Scene5Controller implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	Label label2;
	
	@FXML
	TextField textField6;
	
	ATM atm = new ATM();
	
	String name = "";
	String password = "";
	double checking;
	double savings;
	
	public void handle(ActionEvent event) {
		double balance = Double.valueOf(label2.getText());
		double newBalance = Double.valueOf(textField6.getText());
		balance += newBalance;
		savings += balance;
		for (User user: atm.getUsers()) {
			if (name.equals(user.getName()) && password.equals(user.getPassword())) {
				label2.setText(String.valueOf(savings));
			}
		}
	}
	
	public void handle2(ActionEvent event) {
		double balance = Double.valueOf(label2.getText());
		double newBalance = Double.valueOf(textField6.getText());
		balance -= newBalance;
		savings -= balance;
		for (User user: atm.getUsers()) {
			if (name.equals(user.getName()) && password.equals(user.getPassword())) {
				label2.setText(String.valueOf(savings));
			}
		}
	}
	
	public void backToScene3(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));	
		root = loader.load();
		Scene3Controller three = loader.getController();
		three.atm.setUsers(this.atm.getUsers());
		three.savings = savings;
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
