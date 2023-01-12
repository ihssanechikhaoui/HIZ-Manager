package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Models.Client;
import dao.ClientDaoImplementation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ClientController implements Initializable{
	@FXML private Button idHome;
	@FXML private Button idProvider;
	@FXML private Button idParty;
	@FXML private Button idProfil;
	@FXML private Button idAdd;
	@FXML private Button idModify;
	@FXML private Button idSupprim;
	@FXML private Button idEvent;
    @FXML
    private TableView<Client> tableClient;

    @FXML
    private TableColumn<Client, Integer> idClient;

    public ClientDaoImplementation getCilentDao() {
		return ClientDao;
	}
	

	@FXML
    private TableColumn<Client, String> idName;

    @FXML
    private TableColumn<Client, String> idMail;

    @FXML
    private TableColumn<Client, String> idPhoneNum;

    @FXML
    private TableColumn<Client, String> idCin;
  
    private  ClientDaoImplementation ClientDao =new ClientDaoImplementation();
    public TableView<Client> getTableClient() {
		return tableClient;
	}
	public void setTableClient(TableView<Client> tableClient) {
		this.tableClient = tableClient;
	}

	public void ActionClientController(ActionEvent event) throws IOException, SQLException {
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
   	    	System.out.println("Adding clients");
   	    	url+="AddClient.fxml";
 
 			Node node = (Node) event.getSource();
			 Stage thisStage = (Stage) node.getScene().getWindow();
 			 thisStage.close();
   			
  			 Parent root = FXMLLoader.load(getClass().getResource(url));
  			 thisStage.setUserData(ClientDao);
  			 
  				Scene scene = new Scene(root);
  				thisStage.setScene(scene);
  				thisStage.show();
 			
	    }else if(event.getSource()==idEvent) {
   	    	System.out.println("EVENT AREA");
   	    	url+="CreateEventArea.fxml";
 
	    }else if(event.getSource()==idSupprim) {
   	    	url+="DeleteItemMessage.fxml";
   	    	ClientDao.setClt(tableClient.getSelectionModel().getSelectedItem());
   	    	Node node = (Node) event.getSource();
			 Stage thisStage = (Stage) node.getScene().getWindow();
			 thisStage.close();
 			 Parent root = FXMLLoader.load(getClass().getResource(url));
 			 thisStage.setUserData(ClientDao);
 				Scene scene = new Scene(root);
 				thisStage.setScene(scene);
 				thisStage.show();
   	    	
   	    	
	    }else if(event.getSource()==idModify) {
   	    	System.out.println("Client modified");
   	    	url+="UpdateClient.fxml";
   	    	ClientDao.setClt(tableClient.getSelectionModel().getSelectedItem());
   	    	System.out.println(ClientDao.getClt());
   	    	Node node = (Node) event.getSource();
			 Stage thisStage = (Stage) node.getScene().getWindow();
			 thisStage.close();
 			 Parent root = FXMLLoader.load(getClass().getResource(url));
 			 thisStage.setUserData(ClientDao);
 				Scene scene = new Scene(root);
 				thisStage.setScene(scene);
 				thisStage.show();
   	    	
   	    	
 
	    }
		if(event.getSource()!=idModify &&event.getSource()!=idSupprim && event.getSource()!=idAdd) {
		((Stage) ((Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
		}

}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 idClient.setCellValueFactory(new PropertyValueFactory<Client, Integer>("ID"));
		 idName.setCellValueFactory(new PropertyValueFactory<Client, String>("Name"));
		 idMail.setCellValueFactory(new PropertyValueFactory<Client, String>("Email"));
		 idPhoneNum.setCellValueFactory(new PropertyValueFactory<Client, String>("PhoneNum"));
		 idCin.setCellValueFactory(new PropertyValueFactory<Client, String>("CIN"));
		 
		 try {
			tableClient.getItems().setAll(ClientDao.getAllClients());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}