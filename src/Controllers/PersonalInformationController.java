package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonalInformationController {
	@FXML private Button idSaveAcc;
	@FXML private Button idDelete;
	@FXML private Button idBack;
	@FXML private TextField idTextFieldName;
	@FXML private TextField idTextFieldEmail;
	@FXML private TextField idTextFieldPassword;
	@FXML private TextField idTextFieldPhoneNum;
	@FXML private TextField idTextFieldUsername;
	@FXML private TextField idTextFieldHintpassword;
	public void ActionPersonalInfo(ActionEvent event) throws IOException {
		String url="/Interfaces/";
   	    if(event.getSource()==idBack) {
   	    	System.out.println("Manage profile");
   	    	url+="ManageProfil.fxml";
   	    	((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
   	    }
	}
}