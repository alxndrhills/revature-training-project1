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
import com.revature.dao.ReimbursementTypeDAO;
import com.revature.data.ReimbursementType;

public class TypeServlet extends HttpServlet {

	static final Logger log = Logger.getLogger(TypeServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ReimbursementTypeDAO reimbursementTypeDAO = new ReimbursementTypeDAO();
			PrintWriter writer = resp.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			
			List<ReimbursementType> reimbursementTypeList = reimbursementTypeDAO.getTypeList();
			
			if (reimbursementTypeList != null) {
				resp.setContentType("application/json");
				String dataStr = mapper.writeValueAsString(reimbursementTypeList);
				writer.write(dataStr);
				log.trace(reimbursementTypeList.size() + " reimbursement types found");
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
