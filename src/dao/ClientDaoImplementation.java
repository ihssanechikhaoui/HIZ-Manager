package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Models.Client;
import application.DataBaseConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ClientDaoImplementation implements ClientDao{
	static Connection connection = DataBaseConn.getConnection();

	ObservableList<Client> Clients;
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
	           
	            Clients.add(client);
		
	}
	      
	
		return Clients;
	}

	public ObservableList<Client> getClients() {
		return Clients;
	}

	@Override
	public void addClient(Client client) throws SQLException {
		String query
        = "insert into client(mail, "
          + "Name,PhoneNum,CIN) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = connection.prepareStatement(query);//The PreparedStatement interface is a subinterface of Statement. It is used to execute parameterized query.
		ps.setString(1, client.getEmail());
		ps.setString(2, client.getName());
		ps.setString(3, client.getPhoneNum());
		ps.setString(4, client.getCIN());
		
		ps.executeUpdate();
		System.out.println("client added");
		Clients.add(client);
		
	}
	

}
