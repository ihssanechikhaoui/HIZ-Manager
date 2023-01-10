package Controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ProviderController {
	@FXML private Button idAdd;
	@FXML private Button idModify;
	@FXML private Button idSupprim;
	@FXML private Button idHome;
	@FXML private Button idClients;
	@FXML private Button idProfil;
	@FXML private Button idPartyR;
	//TABLE
	@FXML private TableView<Provider> tableid;
	//COLUMNS
	@FXML private TableColumn<Provider, Integer> id; 
	@FXML private TableColumn<Provider, String> namecolumn;
	@FXML private TableColumn<Provider, String> emailcolumn;
	@FXML private TableColumn<Provider, String> numbercolumn;
	@FXML private TableColumn<Provider, String> levelcolumn;
	
	 public void ActionProviderController(ActionEvent event) throws IOException {
		 String url="/Interfaces/";
   	    if(event.getSource()==idHome) {
   	    	System.out.println("Home");
   	    	url+="Home.fxml";
   	    }else if(event.getSource()==idClients) {
   	    	System.out.println("Client");
   	    	url+="Manage Client.fxml";
   	    }else if(event.getSource()==idAdd) {
   	    	System.out.println("Add");
   	    	url+="AddProviders.fxml";
   	    	Stage addStage = new Stage();
   	    	Parent root = FXMLLoader.load(getClass().getResource(url));
			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			addStage.setScene(scene);
			addStage.show();
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
	    }else if(event.getSource()==idPartyR) {
	    	System.out.println("Party room");
	    	url+="ManagePartyR.fxml";
	    }
   	    if(event.getSource()!=idModify && event.getSource()!=idSupprim && event.getSource()!=idAdd ) {
		((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
   	    }
   	}

    
}