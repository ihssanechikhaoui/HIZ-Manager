package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.Client;
import application.DataBaseConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * @since: 11/2023
 * @author: HIZ
 * @class : this class is the implementation of ClienDao interface it's used to describe all the methods that can be called while accessing the Manage Client interface
 *
 */

public class ClientDaoImplementation implements ClientDao{
	/**
	 * The class have an attribute connection which is used to get the connection object generated while connecting the java project to mysql server
	 * It has also the clients observable list which have the ability to be binded with the tableview on the fxml file so that any change that occurs on this list will automatically appear on the table view 
	 */
	
	static Connection connection = DataBaseConn.getConnection();
	private Client clt;
	

	public Client getClt() {
		return clt;
	}


	public void setClt(Client clt) {
		this.clt = clt;
	}
	ObservableList<Client> Clients;
	/**
	 *
	 * @method:getAllClients 
	 * @return: an observable list which is the clients attribute 
	 * This method is used for initializing the tableview by getting all the registered rows from the database 
	 */
	@Override
	public  ObservableList<Client> getAllClients() throws SQLException {
		 String query = "select * from client";
	        PreparedStatement ps
	            = connection.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        Clients=FXCollections.observableArrayList();
	  
	        while (rs.next()) {
        	Client client = new Client();
        	client.setEmail(rs.getString("mail"));
        	client.setName(rs.getString("Name"));
        	client.setPhoneNum(rs.getString("PhoneNum"));
 		    client.setCIN(rs.getString("CIN"));
 		    client.setID(rs.getInt("idClient"));
	           
	            Clients.add(client);
		
	}
	      
	
		return Clients;
	}

	
	public ObservableList<Client> getClients() {
		return Clients;
	}
	/**
	 * 
	 * AddClient method is used to get information from user input while trying to create a Client on the AddClient controller
	 * the method's aim is to get the object ,set it's attribute to the prepared statement object and execute the query to add the object
	 *  on the database we add also the parameter object to the table view so that changes are immediately shown on the table 
	 * @param: client: it's the parameter taken from the controller part so that all the informations required on the database row are filled from user input
	 */

	@Override
	public void addClient(Client client) throws SQLException {
		String query
        = "insert into client(mail, "
          + "Name,PhoneNum,CIN) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, client.getEmail());
		ps.setString(2, client.getName());
		ps.setString(3, client.getPhoneNum());
		ps.setString(4, client.getCIN());
		
		ps.executeUpdate();
		System.out.println("client added");
		Clients.add(client);	
	}


	@Override
	public void updateClient(Client clt) throws SQLException {
		String query = "update client set mail=?, "
          + " Name= ?, PhoneNum = ? ,CIN = ? where idClient = ?";
		PreparedStatement ps
			= connection.prepareStatement(query);
		System.out.println(clt.getEmail());
		ps.setString(1, clt.getEmail());
		ps.setString(2, clt.getName());
		ps.setString(3, clt.getPhoneNum());
		ps.setString(4, clt.getCIN());
		ps.setInt(5, clt.getID());
		ps.executeUpdate();
		System.out.println("Client is updated**");
		
		
	}


	@Override
	public void deleteClient(Client clt) throws SQLException {
				String query = "delete from client where idClient =?";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, clt.getID());
				ps.executeUpdate();
				Clients.remove(Clients.indexOf(clt)) ;
				System.out.println("Delete client");
		
	}
	
	
	

}