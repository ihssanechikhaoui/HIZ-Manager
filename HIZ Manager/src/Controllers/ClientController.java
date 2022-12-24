package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ClientController {
	@FXML private Button idHome;
	@FXML private Button idProvider;
	@FXML private Button idParty;
	@FXML private Button idProfil;
	@FXML private Button idAdd;
	@FXML private Button idModify;
	@FXML private Button idSupprim;
	@FXML private Button idEvent;
	
	public void ActionClientController(ActionEvent event) throws IOException {
//		event.getSource()
		String url="/Interfaces/";
		if(event.getSource()==idHome) {
   	    	System.out.println("Home");
   	    	url+="Home.fxml";
   	    }else if(event.getSource()==idProvider) {
   	    	System.out.println("Provider");
   	    	url+="ManageProviders.fxml";
   	    }else if(event.getSource()==idParty) {
   	    	System.out.println("Party");
   	    	url+="ManagePartyR.fxml";
   	    }else if(event.getSource()==idProfil) {
   	    	System.out.println("Client");
   	    	url+="Manage Client.fxml";
 
	    }else if(event.getSource()==idAdd) {
   	    	System.out.println("Client Added");
   	    	url+="AddClient.fxml";
   	    	Stage addstage = new Stage();
   	    	Parent root =(Parent)FXMLLoader.load(getClass().getResource(url));
			Scene scene = new Scene(root);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			addstage.setScene(scene);
			addstage.show();
 
	    }else if(event.getSource()==idEvent) {
   	    	System.out.println("Client Added");
   	    	url+="CreateEventArea.fxml";
 
	    }else if(event.getSource()==idSupprim) {
   	    	System.out.println("Client deleted");
   	    	//url+="AddClient.fxml";
 
	    }else if(event.getSource()==idModify) {
   	    	System.out.println("Client modified");
   	    	//url+="AddClient.fxml";
 
	    }
		if(event.getSource()!=idModify &&event.getSource()!=idSupprim && event.getSource()!=idAdd) {
		((Stage) ((Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
		}

}
}