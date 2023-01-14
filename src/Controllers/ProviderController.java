package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Models.Provider;
import dao.ProviderDaoImplementation;
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

public class ProviderController implements Initializable{
	@FXML private Button idAdd;
	@FXML private Button idModify;
	@FXML private Button idSupprim;
	@FXML private Button idHome;
	@FXML private Button idClients;
	@FXML private Button idProfil;
	@FXML private Button idPartyR;
	@FXML
    private TableView<Provider> tableProvider;

    @FXML
    private TableColumn<Provider, Integer> idProv;

    @FXML
    private TableColumn<Provider, String> nameProv;

    @FXML
    private TableColumn<Provider, String> emailProv;

    @FXML
    private TableColumn<Provider, String> PhoneNumProv;

	@FXML
    private TableColumn<Provider, String> levelProv;
	private ProviderDaoImplementation ProviderDao = new ProviderDaoImplementation();
	
	 public void ActionProviderController(ActionEvent event) throws IOException {
		 String url="/Interfaces/";
   	    if(event.getSource()==idHome) {
   	    	System.out.println("Home");
   	    	url+="Home.fxml";
   	    }else if(event.getSource()==idClients) {
   	    	System.out.println("Client");
   	    	url+="Manage Client.fxml";
   	    }else if(event.getSource()==idAdd) {
   	    	System.out.println("Adding providdr");
   	    	url+="AddProviders.fxml";
   	    	Node node = (Node) event.getSource();
			 Stage thisStage = (Stage) node.getScene().getWindow();
			 thisStage.close();
 			 Parent root = FXMLLoader.load(getClass().getResource(url));
 			 thisStage.setUserData(ProviderDao);
 			 
 				Scene scene = new Scene(root);
 				thisStage.setScene(scene);
 				thisStage.show();
   	    }
    	else if(event.getSource()==idModify) {
	    	System.out.println("Modify");
   	    	url+="UpdateProviders.fxml";
   	    	ProviderDao.setPrv(tableProvider.getSelectionModel().getSelectedItem());
   	    	System.out.println(ProviderDao.getPrv());
   	    	Node node = (Node) event.getSource();
			 Stage thisStage = (Stage) node.getScene().getWindow();
			 thisStage.close();
 			 Parent root = FXMLLoader.load(getClass().getResource(url));
 			 thisStage.setUserData(ProviderDao);
 				Scene scene = new Scene(root);
 				thisStage.setScene(scene);
 				thisStage.show();
	    }
    	else if(event.getSource()==idSupprim) {
	    	System.out.println("Supprim");
	    	url+="DeleteItemMessage.fxml";
   	    	ProviderDao.setPrv(tableProvider.getSelectionModel().getSelectedItem());
   	    	Node node = (Node) event.getSource();
			 Stage thisStage = (Stage) node.getScene().getWindow();
			 thisStage.close();
 			 Parent root = FXMLLoader.load(getClass().getResource(url));
 			 thisStage.setUserData(ProviderDao);
 				Scene scene = new Scene(root);
 				thisStage.setScene(scene);
 				thisStage.show();
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idProv.setCellValueFactory(new PropertyValueFactory<Provider,Integer>("ID"));
		nameProv.setCellValueFactory(new PropertyValueFactory<Provider,String>("Name"));
		emailProv.setCellValueFactory(new PropertyValueFactory<Provider,String>("Email"));
		PhoneNumProv.setCellValueFactory(new PropertyValueFactory<Provider,String>("PhoneNum"));
		levelProv.setCellValueFactory(new PropertyValueFactory<Provider,String>("levelOfProvider"));
        try {
			tableProvider.getItems().setAll(ProviderDao.getAllProviders());
		} catch (SQLException e) {
			e.getCause();
			e.printStackTrace();
		}
		
	}

    
}