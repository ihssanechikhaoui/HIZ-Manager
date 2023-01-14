package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Models.Provider;
import application.DataBaseConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProviderDaoImplementation implements ProviderDao{
	
	static Connection connection = DataBaseConn.getConnection();
	private Provider prv;
	public Provider getPrv() {
		return prv;
	}



	public void setPrv(Provider prv) {
		this.prv = prv;
	}


	ObservableList<Provider> Providers;
	


	@Override
	public  ObservableList<Provider> getAllProviders() throws SQLException {
		 String query = "select * from provider";
	        PreparedStatement ps
	            = connection.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        Providers=FXCollections.observableArrayList();
	  
	        while (rs.next()) {
	        	Provider prv = new Provider();
	        	
	        	prv.setName(rs.getString("nameProv"));
	        	prv.setEmail(rs.getString("mailProv"));
	        	prv.setPhoneNum(rs.getString("phoneNumProv"));
	        	prv.setLevelOfProvider(rs.getString("providerLevel"));
	        	prv.setID(rs.getInt("idProvider"));
	           
	            Providers.add(prv);
		
	}
	      
	
		return Providers;
	}

	
	
	/**
	 * 
	 * AddProvider method is used to get information from user input while trying to create a Provider on the AddProvider controller
	 * the method's aim is to get the object ,set it's attribute to the prepared statement object and execute the query to add the object
	 *  on the database we add also the parameter object to the table view so that changes are immediately shown on the table 
	 * @param: provider: it's the parameter taken from the controller part so that all the informations required on the database row are filled from user input
	 */

	@Override
	public void addProvider(Provider prv) throws SQLException {
		String query
        = "insert into provider(mailProv, "
          + "nameProv,phoneNumProv,providerLevel) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, prv.getEmail());
		ps.setString(2, prv.getName());
		ps.setString(3, prv.getPhoneNum());
		ps.setString(4, prv.getLevelOfProvider());
		
		ps.executeUpdate();
		System.out.println("provider added");
		Providers.add(prv);	
	}


	@Override
	public void updateProvider(Provider prv) throws SQLException {
		String query = "update provider set mailProv=?, "
          + " nameProv= ?, phoneNumProv = ? ,providerLevel = ? where idProvider = ?";
		PreparedStatement ps
			= connection.prepareStatement(query);
		System.out.println(prv.getEmail());
		ps.setString(1, prv.getEmail());
		ps.setString(2, prv.getName());
		ps.setString(3, prv.getPhoneNum());
		ps.setString(4, prv.getLevelOfProvider());
		ps.setInt(5, prv.getID());
		ps.executeUpdate();
		System.out.println("Provider is updated**");
		
		
	}


	@Override
	public void deleteProvider(Provider prv) throws SQLException {
				String query = "delete from provider where idProvider =?";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, prv.getID());
				ps.executeUpdate();
				Providers.remove(Providers.indexOf(prv)) ;
				System.out.println("Delete provider");
		
	}
}
