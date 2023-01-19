package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import Models.PartyRoom;
import dao.RoomsDaoImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PartyRController implements Initializable{
	 @FXML
	    private Button idAdd;

	    @FXML
	    private TableColumn<PartyRoom, String> idAddressRoom;

	    @FXML
	    private TableColumn<PartyRoom, Double> idBudgetRoom;

	    @FXML
	    private Button idClients;

	    @FXML
	    private Button idHome;

	    @FXML
	    private Button idModify;

	    @FXML
	    private TableColumn<PartyRoom, String> idNameRoom;

	    @FXML
	    private TableColumn<PartyRoom, Integer> idPartyRoom;

	    @FXML
	    private Button idProfil;

	    @FXML
	    private Button idProvider;

	    @FXML
	    private Button idSupprim;

	    @FXML
	    private TableView<PartyRoom> tablePartyRooms;
	    
	    public TableView<PartyRoom> getTablePartyRooms() {
			return tablePartyRooms;
		}
		public void setTablePartyRooms(TableView<PartyRoom> tablePartyRooms) {
			this.tablePartyRooms = tablePartyRooms;
		}
		private  RoomsDaoImplementation RoomsDao =new RoomsDaoImplementation();

	 public void ActionPartyController(ActionEvent event) throws IOException, SQLException {
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
 
 			Node node = (Node) event.getSource();
			 Stage thisStage = (Stage) node.getScene().getWindow();
 			 thisStage.close();
   			
  			 Parent root = FXMLLoader.load(getClass().getResource(url));
  			 thisStage.setUserData(RoomsDao);
  			 
  				Scene scene = new Scene(root);
  				thisStage.setScene(scene);
  				thisStage.show();
   	    }
   	 else if(event.getSource()==idModify) {
	    	System.out.println("Modify");
	    	url+="UpdatePartyR.fxml";
   	    	RoomsDao.setRms(tablePartyRooms.getSelectionModel().getSelectedItem());
   	    	System.out.println(RoomsDao.getRms());
   	    	Node node = (Node) event.getSource();
			 Stage thisStage = (Stage) node.getScene().getWindow();
			 thisStage.close();
 			 Parent root = FXMLLoader.load(getClass().getResource(url));
 			 thisStage.setUserData(RoomsDao);
 				Scene scene = new Scene(root);
 				thisStage.setScene(scene);
 				thisStage.show();
	    }
   	else if(event.getSource()==idSupprim) {
	    	System.out.println("Supprim");
	    	RoomsDao.setRms(tablePartyRooms.getSelectionModel().getSelectedItem());
	    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
   	    	alert.setTitle("Delete");
   	    	alert.setHeaderText("You are trying to delete an item");
   	    	alert.setContentText("Are you sure you want to proocced");
   	    	alert.getDialogPane().getStylesheets().add("/application/Alert.css");
   	    	ButtonType buttonTypeProceed = new ButtonType("Delete");
   	    	ButtonType buttonTypeCancel = new ButtonType("Cancel");
   	    	alert.getButtonTypes().setAll(buttonTypeProceed, buttonTypeCancel);

   	    	Optional<ButtonType> result = alert.showAndWait();

   	    	if (result.get() == buttonTypeProceed){
   	    		
   	    		System.out.println("yes");
   	    		
    			 RoomsDao.deleteRooms(RoomsDao.getRms());
    			 tablePartyRooms.getItems().setAll(RoomsDao.getAllRooms());
    			 url+="ManagePartyR.fxml";
    			
   	    	} else {
   	    		
   	    	}
	    }
   	else if(event.getSource()==idProfil) {
	    	System.out.println("Profil");
	    	url+="ManageProfil.fxml";
	    }
 
	    
   	 if(event.getSource()!=idModify &&event.getSource()!=idSupprim && event.getSource()!=idAdd) {
		((Stage)( (Node) event.getSource()).getScene().getWindow()).setScene
		(new Scene(FXMLLoader.load(getClass().getResource(url))));
   	}
	 }




	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		idPartyRoom.setCellValueFactory(new PropertyValueFactory<PartyRoom, Integer>("ID"));
		idNameRoom.setCellValueFactory(new PropertyValueFactory<PartyRoom, String>("name"));
		idAddressRoom.setCellValueFactory(new PropertyValueFactory<PartyRoom, String>("Address"));
		idBudgetRoom.setCellValueFactory(new PropertyValueFactory<PartyRoom, Double>("budgetRoom"));
		 
		 try {
			 tablePartyRooms.getItems().setAll(RoomsDao.getAllRooms());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

    
	
	
	
	
	
	
	
	
}