package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateEventsController {
	@FXML private TextField idRoomsBudget;
	@FXML private TextField idTotalBudget;
	@FXML private TextField idProvidersBudget;
	@FXML private TextField idAvance;
	@FXML private Button idNext;
	@FXML private Button idCancel;
	
	 public void ActionCreateEventsController(ActionEvent event) throws IOException {
		 String url="/Interfaces/";
   	    if(event.getSource()==idRoomsBudget) {
   	    	System.out.println("Room's Budget");
   	    }else if(event.getSource()==idTotalBudget) {
   	    	System.out.println("Total Budget");
   	    }else if(event.getSource()==idProvidersBudget) {
   	    	System.out.println("Provider's budget");
   	    }else if(event.getSource()==idAvance) {
   	    	System.out.println("Avance");
   	    }else if(event.getSource()==idNext) {
   	    	System.out.println("Next");
   	    	url+="CreatEvent.fxml";
   	    }else if(event.getSource()==idCancel) {
   	    	System.out.println("Cancel");
   	    	url+="CreateEventArea.fxml";
   	    }

//    Node node = (Node) event.getSource();
//	Stage thisStage = (Stage)( (Node) event.getSource()).getScene().getWindow();
//	Parent root = FXMLLoader.load(getClass().getResource(url));
//	Scene scene = new Scene(FXMLLoader.load(getClass().getResource(url)));
		((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
   	}

	
	
}