package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.User;
import application.DataBaseConn;



public class UserDaoImplementation implements  UserDao{
	static Connection connection = DataBaseConn.getConnection();

	@Override
	public void addUser(User user) throws SQLException {
		
		String query
        = "insert into user(Email, "
          + "Name,PhoneNum,HintPassword,Password,Username) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(query);//The PreparedStatement interface is a subinterface of Statement. It is used to execute parameterized query.
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPhoneNum());
		ps.setString(4, user.getHintPassword());
		ps.setString(5, user.getPassword());
		ps.setString(6,user.getUsername());
		ps.executeUpdate();
		System.out.println("User added");
		
	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		 String query = "select * from user";
	        PreparedStatement ps
	            = connection.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        List<User> users = new ArrayList<>();
	  
	        while (rs.next()) {
           	User user = new User();
           	user.setEmail(rs.getString("Email"));
    		user.setName(rs.getString("Name"));
    		user.setPhoneNum(rs.getString("PhoneNum"));
    		user.setHintPassword(rs.getString("HintPassword"));
    		user.setPassword(rs.getString("Password"));
    		user.setUsername(rs.getString("Username"));
	           
	            users.add(user);
		
	}
	        return users;

	}

	@Override
	public User getUser(String username) throws SQLException {
		String query
        = "select * from user where Username like ?";
		PreparedStatement ps
			= connection.prepareStatement(query);

		ps.setString(1, "%"+username+"%");
		User user = new User();
		ResultSet rs = ps.executeQuery();
		boolean check = false;

		while (rs.next()) {
        check = true;
    	user.setEmail(rs.getString("Email"));
		user.setName(rs.getString("Name"));
		user.setPhoneNum(rs.getString("PhoneNum"));
		user.setHintPassword(rs.getString("HintPassword"));
		user.setPassword(rs.getString("Password"));
		user.setUsername(rs.getString("Username"));
		}
		if (check) {
			return user;
		}
		else	return null;
	}

}
