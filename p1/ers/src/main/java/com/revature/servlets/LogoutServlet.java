package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.User;
import com.revature.service.UserService;

public class LogoutServlet extends HttpServlet {
	
	static final Logger log = Logger.getLogger(LogoutServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			session.removeAttribute(Constants.currentUserSessionAttributeName);
			log.trace("User logged out");
			resp.setStatus(200);
		}
		catch (Exception e) {
			log.error(e);
			resp.setStatus(500);
		}
	}
}
