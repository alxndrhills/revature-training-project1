package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ReimbursementReceiptServlet extends HttpServlet {

	static final Logger log = Logger.getLogger(ReimbursementReceiptServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		}
		catch (Exception e) {
			log.error(e);
			resp.setStatus(500);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
		}
		catch (Exception e) {
			log.error(e);
			resp.setStatus(500);
		}
	}
}
