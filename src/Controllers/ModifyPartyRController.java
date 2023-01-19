package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Models.PartyRoom;
import dao.ClientDaoImplementation;
import dao.RoomsDaoImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ModifyPartyRController {
	@FXML
    private TextField idAddress;

    @FXML
    private TextField idBudget;

    @FXML
    private Button idCancel;

    @FXML
    private Button idModify;

    @FXML
    private TextField idName;
    private int counter=0;
    private PartyRoom room;
    public String x;
    @FXML
    void ActionModifyRooms(ActionEvent event) throws IOException, SQLException {
    	 String url="/Interfaces/";
 	    if(event.getSource()==idModify) {
 	    	room.setName(idName.getText());
 	    	room.setAddress(idAddress.getText());
 	    	room.setBudgetRoom(Double.parseDouble(idBudget.getText()));
 	    	
 	    	Node node = (Node) event.getSource();
			 Stage thisStage = (Stage) node.getScene().getWindow();
			((RoomsDaoImplementation)thisStage.getUserData()).updateRooms(room);
			System.out.println(room.getAddress());
 	    	
   		     
 	    	url+="ManagePartyR.fxml";
   	    ((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
   	    
   	    	 
 	    }else if(event.getSource()==idCancel) {
 	    	
 	    	url+="ManagePartyR.fxml";
 	    	 ((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
 	    }	
    }
    @FXML

    void ShowData(MouseEvent event) {
    	if(counter==0) {
    	 Node node = (Node) event.getSource();
		 Stage thisStage = (Stage) node.getScene().getWindow();
		     room =((RoomsDaoImplementation)thisStage.getUserData()).getRms();
		     idName.setText(room.getName());
		     idAddress.setText(room.getAddress());
		     idBudget.setText((room.getBudgetRoom()).toString());
	
	System.out.println(room.getID());
    	}
    	counter++;
    }

}
