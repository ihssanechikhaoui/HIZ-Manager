package dao;

import java.sql.SQLException;
import java.util.List;

import Models.User;

public interface UserDao {
	public void addUser(User user)throws SQLException; 
		
	public List<User>  getAllUsers() throws SQLException;
	
	public User getUser(String username)throws SQLException;

}
