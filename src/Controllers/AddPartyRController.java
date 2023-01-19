package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import Models.Client;
import Models.PartyRoom;
import dao.ClientDaoImplementation;
import dao.RoomsDaoImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPartyRController {
	  @FXML
	    private Button idAdd;

	    @FXML
	    private TextField idAddress;

	    @FXML
	    private TextField idBudget;

	    @FXML
	    private Button idCancel;

	    @FXML
	    private TextField idName;
	    
	    private PartyRoom room;
	    @FXML
	    void ActionAddRooms(ActionEvent event) throws IOException, SQLException {

	    	String url="/Interfaces/";
    	    if(event.getSource()==idAdd) {
     	    	room = new PartyRoom(idName.getText(),idAddress.getText(),Double.parseDouble(idBudget.getText()));
     	    	 Node node = (Node) event.getSource();
      			 Stage thisStage = (Stage) node.getScene().getWindow();
      			 System.out.println((RoomsDaoImplementation)thisStage.getUserData());
      			 System.out.println(room);
      		     ((RoomsDaoImplementation)thisStage.getUserData()).addRooms(room);
    	    	url+="ManagePartyR.fxml";
      	    ((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
      	    
      	    	 
    	    }else if(event.getSource()==idCancel) {
    	    	
    	    	url+="ManagePartyR.fxml";
    	    	 ((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
    	    }	
	    }

}
