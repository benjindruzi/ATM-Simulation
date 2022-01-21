package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scene3Controller implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	ATM atm = new ATM();
	
	String name = "";
	String password = "";
	double checking;
	double savings;
	
	public void handle(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));	
			root = loader.load();
			
			Scene4Controller four = loader.getController();
			four.atm.setUsers(this.atm.getUsers());
			four.name = name;
			four.password = password;
			
			for (User user: atm.getUsers()) {
				if (name.equals(user.getName()) && password.equals(user.getPassword())) {
					checking += user.ca.getBalance();
					four.label1.setText(String.valueOf(checking));
				}
			}

			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void goToSavings(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene5.fxml"));	
			root = loader.load();
			
			Scene5Controller five = loader.getController();
			five.atm.setUsers(this.atm.getUsers());
			five.name = name;
			five.password = password;
			
			for (User user: atm.getUsers()) {
				if (name.equals(user.getName()) && password.equals(user.getPassword())) {
					savings += user.ca.getBalance();
					five.label2.setText(String.valueOf(savings));
				}
			}

			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void backToScene2(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));	
		root = loader.load();
		Scene2Controller two = loader.getController();
		two.atm.setUsers(this.atm.getUsers());
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}