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

public class LoginController {
	@FXML private TextField textFieldUsername;
	@FXML private PasswordField textFieldPassword;
	@FXML private Label labelHint;
	public void ActionLogin (ActionEvent event) {
		System.out.print("fghjklp");
		labelHint.setText("hintpassword");
	}
	public void ActionCreateAccount (ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();
		Stage thisStage = (Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Registration.fxml"));
		Scene scene = new Scene(root);
		thisStage.setScene(scene);
	}
}
