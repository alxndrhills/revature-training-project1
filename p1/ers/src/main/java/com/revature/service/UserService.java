package com.revature.service;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.dao.UserDAO;
import com.revature.data.User;


public class UserService {
	
	public User loginUser(String username, String password) {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getByLogin(username);
		return user != null && checkPassword(user.getPassword(), password) ? user : null;
	}
	
	private boolean checkPassword(String password, String entered) {
		if (entered != null && password != null) {
			return BCrypt.checkpw(entered, password);
			//return entered.equals(password);
		}
		return false;
	}
}
