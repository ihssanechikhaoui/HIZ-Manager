package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddClientController {
	@FXML private TextField idName;
	@FXML private TextField idEmail;
	@FXML private TextField idPhoneNumber;
	@FXML private TextField idCIN;
	@FXML private Button idAdd;
	@FXML private Button idCancel;
	
	 public void ActionAddClientController(ActionEvent event) throws IOException {
		 String url="/Interfaces/";
   	    if(event.getSource()==idCancel) {
   	    	System.out.println("Back");
   	    Node node = (Node) event.getSource();
   	 	Stage thisStage = (Stage)( (Node) event.getSource()).getScene().getWindow();
   	 	thisStage.hide();

   	    }
	 }
}
