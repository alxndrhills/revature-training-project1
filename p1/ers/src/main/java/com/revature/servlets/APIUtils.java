package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.data.User;

public class APIUtils {

	public static User getCurrentUser(HttpServletRequest req) {
		Object user = req.getSession().getAttribute(Constants.currentUserSessionAttributeName);
		
		return user instanceof User ? (User) user : null;
	}
}
