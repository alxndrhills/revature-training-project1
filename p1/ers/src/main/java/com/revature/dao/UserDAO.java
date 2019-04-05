package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.data.User;
import com.revature.util.ConnectionFactory;

public class UserDAO {
	
	public User getByLogin(String login) {
		User user = null;
		
		try(Connection connection = 
				ConnectionFactory.getInstance().getConnection()) {
			String query = 
				"select " +
						"U.USER_ID, " +
						"U.USERNAME, " +
						"U.PASSWORD, " +
						"U.USER_FIRST_NAME, " +
						"U.USER_LAST_NAME, " +
						"U.USER_EMAIL, " +
						"U.USER_ROLE_ID, " +
						"R.USER_ROLE " +
				"from ERS_USERS U " +
						"inner join ERS_USER_ROLES R " +
							"on U.USER_ROLE_ID = R.USER_ROLE_ID " +
						"where lower(U.USERNAME) = ?";
	
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int id = resultSet.getInt("USER_ID");
				String username = resultSet.getString("USERNAME");
				String password = resultSet.getString("PASSWORD");
				String firstName = resultSet.getString("USER_FIRST_NAME");
				String lastName = resultSet.getString("USER_LAST_NAME");
				String email = resultSet.getString("USER_EMAIL");
				short roleId = resultSet.getShort("USER_ROLE_ID");
				String roleName = resultSet.getString("USER_ROLE");
				user = new User(id, username, password, firstName, lastName, email,
						roleId, roleName);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
