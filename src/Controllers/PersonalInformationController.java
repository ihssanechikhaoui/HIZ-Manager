package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
	private int counter=0;
	private User user;
	
	public void ActionPersonalInfo(ActionEvent event) throws IOException, SQLException {
		String url="/Interfaces/";
   	    if(event.getSource()==idBack) {
   	    	System.out.println("Manage profile");
   	    	url+="ManageProfil.fxml";
   	    	((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
   	    }else if(event.getSource()==idSaveAcc) {
   	    	String name=idTextFieldName.getText() ;
   	    	String email = idTextFieldEmail.getText();
   	    	String password =idTextFieldPassword.getText();
   	    	String phonenum = idTextFieldPhoneNum.getText();
   	    	String username = idTextFieldUsername.getText();
   	        String Hintpsw = idTextFieldHintpassword.getText();
   	       if(!(username.equals(user.getUsername()))) {
   	    	  if((LoginController.getUser()).getUser(username)==null) {
   	    	   user.setEmail(email);
   	    	   user.setName(name);
   	    	   user.setUsername(username);
   	    	   user.setPassword(password);
   	    	   user.setPhoneNum(phonenum);
   	    	   user.setHintPassword(Hintpsw);
   	    	   LoginController.getUser().UpdateUser(user);
   	    	  url+="ManageProfil.fxml";
   	    	((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
   	    	}else {

      	    	Alert alert = new Alert(Alert.AlertType.ERROR);
      	    	alert.setTitle("Changing personal information");
      	    	alert.setHeaderText("Username needs to be unique ");
      	    	alert.setContentText("The username you are trying to have is already used ");
      	    	alert.getDialogPane().getStylesheets().add("/application/Alert.css");
      	    	alert.getDialogPane().setPrefSize(500, 200);
      	    	ButtonType buttonTypeCancel = new ButtonType("Cancel");
      	    	alert.getButtonTypes().setAll( buttonTypeCancel);
      	        alert.showAndWait();
      	       
   	       }
   	    	
   	    	
   	    	
   	    }else {
   	          user.setEmail(email);
	    	   user.setName(name);
	    	   user.setUsername(username);
	    	   user.setPassword(password);
	    	   user.setPhoneNum(phonenum);
	    	   user.setHintPassword(Hintpsw);
	    	   LoginController.getUser().UpdateUser(user);
	    	   url+="ManageProfil.fxml";
	    	   ((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
	    }
   	  
   	    
   	    }
   	     
   	       
	}
	 @FXML
	    void ShowData(MouseEvent event) {
		 if(counter==0) {
		Stage thisStage = (Stage)( (Node) event.getSource()).getScene().getWindow();
  	     user =LoginController.getUser1();
  	     idTextFieldName.setText(user.getName());
  	     idTextFieldEmail.setText(user.getEmail());
  	     idTextFieldPassword.setText(user.getPassword());
  	     idTextFieldPhoneNum.setText(user.getPhoneNum());
  	     idTextFieldUsername.setText(user.getUsername());
  	     idTextFieldHintpassword.setText(user.getHintPassword());
		 }
		 counter++;

	    }

}
