package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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

    @FXML
    private TableColumn<Client, String> idName;

    @FXML
    private TableColumn<Client, String> idMail;

    @FXML
    private TableColumn<Client, String> idPhoneNum;

    @FXML
    private TableColumn<Client, String> idCin;
    private static   ClientDaoImplementation CilentDao =new ClientDaoImplementation();
    public TableView<Client> getTableClient() {
		return tableClient;
	}
	public void setTableClient(TableView<Client> tableClient) {
		this.tableClient = tableClient;
	}
	public static ClientDaoImplementation getCilentDao() {
		return CilentDao;
	}
	protected List<Client> getClientList() {
		System.out.println(ClientDaoImplementation.getClients().toString());
			return ClientDaoImplementation.getClients();
	}
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
   	    	System.out.println("Adding clients");
   	    	url+="AddClient.fxml";
   	    
//   	     Stage thisStage = new Stage();
//		 Parent root = FXMLLoader.load(getClass().getResource(url));
//			Scene scene = new Scene(root);
////			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			thisStage.setScene(scene);
//			thisStage.show();
 
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
//		if(event.getSource()!=idModify &&event.getSource()!=idSupprim && event.getSource()!=idAdd) {
		((Stage) ((Node) event.getSource()).getScene().getWindow()).setScene(new Scene(FXMLLoader.load(getClass().getResource(url))));
//		}

}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 idClient.setCellValueFactory(new PropertyValueFactory<Client, Integer>("ID"));
		 idName.setCellValueFactory(new PropertyValueFactory<Client, String>("Name"));
		 idMail.setCellValueFactory(new PropertyValueFactory<Client, String>("Email"));
		 idPhoneNum.setCellValueFactory(new PropertyValueFactory<Client, String>("PhoneNum"));
		 idCin.setCellValueFactory(new PropertyValueFactory<Client, String>("CIN"));
		 
		 tableClient.getItems().setAll(getClientList());
	}

}