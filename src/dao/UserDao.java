package dao;

import java.sql.SQLException;

import Models.User;





public interface UserDao {
	public User getReceptionniste(String Username, String Password) throws SQLException;
}
