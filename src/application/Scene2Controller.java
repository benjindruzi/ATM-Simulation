package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Scene2Controller implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	TextField textField3;
	
	@FXML
	TextField textField4;
	
	ATM atm = new ATM();
	
	public void handle(ActionEvent event) {
		try {
			String name = textField3.getText();
			String password = textField4.getText();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));	
			root = loader.load();	
			
			Scene3Controller three = loader.getController();
			three.atm.setUsers(this.atm.getUsers());
			three.name = name;
			three.password = password;
			
			for (User user: atm.getUsers()) {
				if (name.equals(user.getName()) && password.equals(user.getPassword())) {
					stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				}
			}
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
	
	public void backToMain(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));	
		root = loader.load();
		MainController main = loader.getController();
		main.atm.setUsers(this.atm.getUsers());
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}