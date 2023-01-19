package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.PartyRoom;
import application.DataBaseConn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RoomsDaoImplementation implements RoomsDao{
	
	static Connection connection = DataBaseConn.getConnection();
	private PartyRoom rms;

	public PartyRoom getRms() {
		return rms;
	}

	public void setRms(PartyRoom rms) {
		this.rms = rms;
	}
	
	ObservableList<PartyRoom> Rooms;

	@Override
	

	public  ObservableList<PartyRoom> getAllRooms() throws SQLException {
		 String query = "select * from partyroom";
	        PreparedStatement ps
	            = connection.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        Rooms=FXCollections.observableArrayList();
	  
	        while (rs.next()) {
	        	PartyRoom rooms = new PartyRoom();
	        	
	        	rooms.setName(rs.getString("partyRoomName"));
	        	rooms.setAddress(rs.getString("partyRoomAddress"));
	        	
	        	rooms.setBudgetRoom(rs.getDouble("partyRoomBudget"));
	 		    rooms.setID(rs.getInt("idpartyRoom"));
	           System.out.println(rooms.getBudgetRoom());
	        	Rooms.add(rooms);
		
	}
	      
	
		return Rooms;
	}

	
	
	
	
	
	
	@Override
	public void addRooms(PartyRoom rms) throws SQLException {
		String query
        = "insert into partyroom(partyRoomName, "
          + "partyRoomAddress ,partyRoomBudget) VALUES (?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, rms.getName());
		ps.setString(2, rms.getAddress());
		ps.setDouble(3, rms.getBudgetRoom());
		
		
		
		ps.executeUpdate();
		System.out.println("room added");
		Rooms.add(rms);	
	}
	

	@Override
	public void updateRooms(PartyRoom rms) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update partyroom set partyRoomName=?, "
		          + " partyRoomAddress= ?, partyRoomBudget = ? where idpartyRoom = ?";
				PreparedStatement ps
					= connection.prepareStatement(query);
				System.out.println(rms.getName());
				ps.setString(1, rms.getName());
				ps.setString(2, rms.getAddress());
				ps.setDouble(3, rms.getBudgetRoom());
				ps.setInt(4, rms.getID());
				
				ps.executeUpdate();
				System.out.println("room is updated");
		
	}

	@Override
	public void deleteRooms(PartyRoom rms) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from partyroom where idpartyRoom =?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, rms.getID());
		ps.executeUpdate();
		Rooms.remove(Rooms.indexOf(rms)) ;
		System.out.println("Delete rooms");
		
		
	}

}
