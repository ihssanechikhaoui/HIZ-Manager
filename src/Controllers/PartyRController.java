package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PartyRController {
	@FXML private Button idAdd;
	@FXML private Button idModify;
	@FXML private Button idSupprim;
	@FXML private Button idHome;
	@FXML private Button idProvider;
	@FXML private Button idClients;
	@FXML private Button idProfil;
	
	 public void ActionPartyController(ActionEvent event) throws IOException {
		 String url="/Interfaces/";
   	    if(event.getSource()==idHome) {
   	    	System.out.println("Home");
   	    	url+="Home.fxml";
   	    }else if(event.getSource()==idProvider) {
   	    	System.out.println("Provider");
   	    	url+="ManageProviders.fxml";
   	    }else if(event.getSource()==idClients) {
   	    	System.out.println("Client");
   	    	url+="Manage Client.fxml";
   	    }else if(event.getSource()==idAdd) {
   	    	System.out.println("Add");
   	    	url+="AddRooms.fxml";
   	    }
   	 else if(event.getSource()==idModify) {
	    	System.out.println("Modify");
	    }
   	else if(event.getSource()==idSupprim) {
	    	System.out.println("Supprim");
	    }
   	else if(event.getSource()==idProfil) {
	    	System.out.println("Profil");
	    	url+="ManageProfil.fxml";
	    }

		((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
   	}

    
	
	
	
	
	
	
	
	
}
