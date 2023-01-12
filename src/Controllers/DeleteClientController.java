package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import dao.ClientDaoImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

	public class DeleteClientController {

	    @FXML
	    private Button idCancel;

	    @FXML
	    private Button idDelete;

	    @FXML
	    void ActionDeleteController(ActionEvent event) throws SQLException, IOException {
	    	 String url="/Interfaces/";
	    	    if(event.getSource()==idDelete) {
	    	    	Node node = (Node) event.getSource();
		   			 Stage thisStage = (Stage) node.getScene().getWindow();
		   			((ClientDaoImplementation)thisStage.getUserData()).deleteClient((((ClientDaoImplementation)thisStage.getUserData()).getClt()));
		   			url+="Manage Client.fxml";
	    	    }
	    	    else if(event.getSource()==idCancel) {
	    	    	
	    	    }
	    	    ((Stage) ((Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));

	    }

	}