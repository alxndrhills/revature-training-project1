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

public class LoginServlet extends HttpServlet {
	
	static final Logger log = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = APIUtils.getCurrentUser(req);
			
			if (user != null) {
				log.trace("Current session found for: " + user.getUsername());
			}
			else {
				log.warn("No active session found");
			}
			
			ObjectMapper mapper = new ObjectMapper();
			String userOutput = mapper.writeValueAsString(user);
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			resp.setStatus(200);
			writer.write(userOutput);
		}
		catch (Exception e) {
			log.error(e);
			resp.setStatus(500);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			User inputUser = mapper.readValue(req.getInputStream(), User.class);
			
			UserService userService = new UserService();
			User user = userService.loginUser(inputUser.getUsername(), inputUser.getPassword());
			
			resp.setStatus(200);
			String userOutput = null;
			
			if (user == null) {
				userOutput = mapper.writeValueAsString(null);
				//log.warn("Login failed for: " + inputUser.getUsername());
				log.warn("Login failed");
			}
			else {
				log.trace("Successfull login: " + user.getUsername());
				HttpSession session = req.getSession();
				session.setAttribute(Constants.currentUserSessionAttributeName, user);
				userOutput = mapper.writeValueAsString(user);
			}
			PrintWriter writer = resp.getWriter();
			resp.setContentType("application/json");
			writer.write(userOutput);	
		}
		catch (Exception e) {
			log.error(e);
			resp.setStatus(500);
		}	
	}
}
