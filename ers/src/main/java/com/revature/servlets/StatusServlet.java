package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementStatusDAO;
import com.revature.data.ReimbursementStatus;


public class StatusServlet extends HttpServlet{

	static final Logger log = Logger.getLogger(StatusServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ReimbursementStatusDAO reimbursementStatusDAO = new ReimbursementStatusDAO();
			PrintWriter writer = resp.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			
			List<ReimbursementStatus> reimbursementStatusList = reimbursementStatusDAO.getStatusList();
			
			if (reimbursementStatusList != null) {
				resp.setContentType("application/json");
				String dataStr = mapper.writeValueAsString(reimbursementStatusList);
				writer.write(dataStr);
				log.trace(reimbursementStatusList.size() + " reimbursement statuses found");
				resp.setStatus(200);
			}
			else {
				log.error("Failed to retrieve reimbursement statuses list");
			}
		}
		catch (Exception e) {
			log.error(e);
			resp.setStatus(500);
		}
	}
}
