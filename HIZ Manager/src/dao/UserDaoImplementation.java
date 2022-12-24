package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.User;
import application.DataBaseConn;


public class UserDaoImplementation implements  UserDao{
	static Connection connection = DataBaseConn.getConnection();

	@Override
	public User getReceptionniste(String Username, String Password) throws SQLException {
		String query
        = "select * from user where Username = ? and Password = ?";
		PreparedStatement ps
			= connection.prepareStatement(query);

		ps.setString(1, Username);
		ps.setString(2, Password);
		User  user = new User();
		ResultSet rs = ps.executeQuery();
		boolean check = false;

		while (rs.next()) {
        check = true;
        user.setID( rs.getInt("idUser"));
        user.setEmail(rs.getString("Email"));
        user.setHintPassword(rs.getString("HintPassword"));
        user.setName(rs.getString("Name"));
        user.setPhoneNum(rs.getString("PhoneNum"));
        user.setPassword(rs.getString("Password"));
        user.setUsername(rs.getString("Username"));
        
		}

		if (check) {
			return user;
		}
		return null;
	}

}
