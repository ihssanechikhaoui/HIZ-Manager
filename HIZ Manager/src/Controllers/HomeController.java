package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {
	@FXML private Button idProvider;
	@FXML private Button idParty;
	@FXML private Button idClients;
	@FXML private Button idProfil;
	
	
	public void ActionHomeController(ActionEvent event) throws IOException {
//		event.getSource()
		String url="/Interfaces/";
		if(event.getSource()==idProfil) {
   	    	System.out.println("Profil");
   	    	url+="ManageProfil.fxml";
   	    }else if(event.getSource()==idProvider) {
   	    	System.out.println("Provider");
   	    	url+="ManageProviders.fxml";
   	    }else if(event.getSource()==idParty) {
   	    	System.out.println("Party");
   	    	url+="ManagePartyR.fxml";
   	    }else if(event.getSource()==idClients) {
   	    	System.out.println("Client");
   	    	url+="Manage Client.fxml";
   	    }
		((Stage) ((Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
	}


}