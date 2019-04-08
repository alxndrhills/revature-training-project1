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
import com.revature.dao.ReimbursementDAO;
import com.revature.data.Reimbursement;
import com.revature.data.User;
import com.revature.util.Utils;

public class ReimbursementServlet extends HttpServlet {

	static final Logger log = Logger.getLogger(ReimbursementServlet.class);
	static final String idParameterName = "id";
	static final String statusIdParameterName = "statusId";
	static final String authorIdParameterName = "authorId";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = APIUtils.getCurrentUser(req);
			if (user != null) {
				String idStr = req.getParameter(idParameterName);
				ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
				PrintWriter writer = resp.getWriter();
				ObjectMapper mapper = new ObjectMapper();
				
				if (idStr != null) {
					int id = Integer.parseInt(idStr);
					Reimbursement reimbursement = reimbursementDAO.getReimbursementById(id);
					
					if (reimbursement != null) {
						resp.setContentType("application/json");
						String dataStr = mapper.writeValueAsString(reimbursement);
						writer.write(dataStr);
					}
					else {
						log.error("Reimbursement was not found");
						resp.setStatus(404);
					}
				}
				else {
					String statusIdStr = req.getParameter(statusIdParameterName);
					String authorIdStr = req.getParameter(authorIdParameterName);
					
					Short statusId = Utils.parseShort(statusIdStr);
					Integer authorId = Utils.parseInt(authorIdStr);
					
					List<Reimbursement> reimbursementList = reimbursementDAO.getReimbursementList(statusId, authorId);
					
					resp.setContentType("application/json");
					String dataStr = mapper.writeValueAsString(reimbursementList);
					writer.write(dataStr);
				}
			}
			else {
				log.error("Unauthorized");
				resp.setStatus(401); //unauthorized
			}
		}
		catch (Exception e) {
			log.error(e.getMessage() + " " + e.getStackTrace());
			resp.setStatus(500);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = APIUtils.getCurrentUser(req);
			if (user != null) {
				ObjectMapper mapper = new ObjectMapper();
				Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
				
				if (reimbursement != null) {
					ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
					reimbursement.setReimbursementStatusId((short) 1);
					reimbursement.setReimbursementAuthorId(user.getUserId());
					
					if (reimbursementDAO.createReimbursement(reimbursement)) {
						log.trace("New reimbursement created");
						resp.setStatus(200);
					}
					else {
						log.error("Error creating reimbursement");
						resp.setStatus(418);
					}
				}
				else {
					log.error("Invalid parameters");
					resp.setStatus(400);
				}
			}
			else {
				log.error("Unauthorized");
				resp.setStatus(401); //unauthorized
			}
		}
		catch (Exception e) {
			log.error(e);
			resp.setStatus(500);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = APIUtils.getCurrentUser(req);
			if (user != null) {
				ObjectMapper mapper = new ObjectMapper();
				Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
				
				if (reimbursement != null) {
					ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
					
					Reimbursement loadedReimbursement = reimbursementDAO.getReimbursementById(reimbursement.getReimbursementId());
					
					if (loadedReimbursement != null) {
						loadedReimbursement.setReimbursementStatusId(reimbursement.getReimbursementStatusId());
						loadedReimbursement.setReimbursementResolverId(user.getUserId());
						if (reimbursementDAO.updateReimbursement(loadedReimbursement)) {
							log.trace("Reimbursement was updaded successfully");
							resp.setStatus(200);
						}
						else {
							log.error("Error creating reimbursement");
							resp.setStatus(418);
						}
					}
					else {
						log.error("Reimbursement was not found");
						resp.setStatus(404);
					}
				}
				else {
					log.error("Invalid parameters");
					resp.setStatus(400);
				}
			}
			else {
				log.error("Unauthorized");
				resp.setStatus(401); //unauthorized
			}
		}
		catch (Exception e) {
			log.error(e);
			resp.setStatus(500);
		}

	}
}
