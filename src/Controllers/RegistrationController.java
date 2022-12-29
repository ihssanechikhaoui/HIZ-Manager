package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {
	@FXML private TextField textFieldFullN;
	@FXML private TextField textFieldEmail;
	@FXML private TextField textFieldPhone;
	@FXML private TextField textFieldUsern;
	@FXML private PasswordField textFieldPassword;
	@FXML private TextField textFieldHint;
	@FXML private Label labelHint;
	public void ActionRegistration(ActionEvent event) {
		
	}
public void ActionBack(ActionEvent event) throws IOException {
	Node node = (Node) event.getSource();
	Stage thisStage = (Stage) node.getScene().getWindow();
	Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Login.fxml"));
	Scene scene = new Scene(root);
	thisStage.setScene(scene);
	}
public void ActionHint(ActionEvent event) {
	labelHint.setText("Enter a hint that can remind you of your password ");
	
}
	

}
