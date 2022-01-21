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

public class MainController implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	TextField textField1;
	
	@FXML
	TextField textField2;
	
	ATM atm = new ATM();

	public void handle(ActionEvent event) {
		try {
			String name = textField1.getText();
			String password = textField2.getText();
			
			if (name.isBlank() && password.isBlank()) {
				
			}
			
			else {
				User user = new User(name, password);
				atm.save(user);
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));	
				root = loader.load();
				
				Scene2Controller two = loader.getController();
				two.atm.setUsers(this.atm.getUsers());
				
				//root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
	
	public void goToLogIn(ActionEvent event) throws IOException {
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