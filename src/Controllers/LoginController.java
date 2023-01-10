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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

public class LoginController {
      @FXML private TextField textFieldUsername;
      @FXML private PasswordField textFieldPassword;
      @FXML private Label labelHint;     
      private UserDaoImplementation user ;
     
      public void ActionLogin(ActionEvent event) throws SQLException, IOException {
    	  System.out.println("btn clicked");
    	  labelHint.setText("Hint password is : jhgfduj");
    	  String username = textFieldUsername.getText();
    	  String password = textFieldPassword.getText();
    	  user = new UserDaoImplementation();
       	  User user1 = user.getUser(username);
    	  if(user1 != null){
    		  if(user1.getPassword().equals(password)) {
    			  System.out.println("connexion avec succée");
  	    		((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource("/Interfaces/Home.fxml"))));
    		  }else {
    			  System.out.println("incorrect psw");
    			  labelHint.setText(" Incorrect Password.\n Hint password is : " +user1.getHintPassword());
    			 // labelHint.setFont(new Font ("Arial","23"))
    		  }
	    		
	    		
	    		
	    		
	    	}else {
	    		System.out.println("identifiant incorrect");
	    		 labelHint.setText(" Username doesn't exist " );
	    	}
    	  
      }
      public void ActionCreateAccount(ActionEvent event) throws IOException {
    	  System.out.println("Create ACcount");
    	  Node node = (Node) event.getSource();
 		  Stage thisStage = (Stage) node.getScene().getWindow();
 		
 		 Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Registration.fxml"));
 			Scene scene = new Scene(root);
// 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 			thisStage.setScene(scene);
      }
      
}