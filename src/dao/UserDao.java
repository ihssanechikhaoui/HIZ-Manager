package dao;

import java.sql.SQLException;
import java.util.List;

import Models.User;





public interface UserDao {
	public List<User> getAllUsers()throws SQLException ;
	public void addUser(User user)throws SQLException;
	public User getUser(String username)throws SQLException;
	public void isOnline(User user)throws SQLException;
}