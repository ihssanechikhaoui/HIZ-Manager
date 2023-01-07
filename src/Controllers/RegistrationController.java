package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import Models.User;
import dao.UserDaoImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RegistrationController {
	@FXML private TextField textFieldFullN;
	@FXML private TextField textFieldEmail;
	@FXML private TextField textFieldPhone;
	@FXML private TextField textFieldUsern;
	@FXML private TextField textFieldHint;
	@FXML private PasswordField textFieldPassword;
	@FXML private Label labelHint;
	UserDaoImplementation userdao = new UserDaoImplementation();
	 public void ActionRegistration(ActionEvent event) throws SQLException {
		 if(textFieldFullN.getText().isBlank()||textFieldEmail.getText().isBlank()||textFieldPhone.getText().isBlank()||textFieldUsern.getText().isBlank()||textFieldHint.getText().isBlank()||textFieldPassword.getText().isBlank()) {
		 Alert alert = new Alert(AlertType.ERROR, "Please fill the hole form", ButtonType.CANCEL);
		 alert.showAndWait();
		 }else{
		 User user = new User(textFieldHint.getText(),textFieldPassword.getText(),textFieldUsern.getText(),textFieldEmail.getText(),textFieldFullN.getText(),textFieldPhone.getText());
		 userdao.addUser(user);
		 }
     }
	 public void ActionBack(ActionEvent event) throws IOException {
		 Node node = (Node) event.getSource();
		  Stage thisStage = (Stage) node.getScene().getWindow();
		 Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Login.fxml"));
			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			thisStage.setScene(scene);
     }
     public void ActionHint(ActionEvent event) {
	   	 labelHint.setText("Enter a hint that can remind you of your password");
     }
	 
}

