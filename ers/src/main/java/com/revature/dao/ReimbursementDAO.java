package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.data.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO {
	
	public List<Reimbursement> getReimbursementList(Short filterByStatusId, Integer filterByAuthorId) {
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		
		try(Connection connection = 
				ConnectionFactory.getInstance().getConnection()) {
			String query = 
					"select " +
							"R.REIMB_ID, " +
							"R.REIMB_AMOUNT, " +
							"R.REIMB_SUBMITTED, " +
							"R.REIMB_RESOLVED, " +
							"R.REIMB_DESCRIPTION, " +
							"R.REIMB_RECEIPT, " +
							"R.REIMB_AUTHOR, " +
							"U_A.USER_FIRST_NAME AUTHOR_FIRST_NAME, " +
							"U_A.USER_LAST_NAME AUTHOR_LAST_NAME, " +
							"R.REIMB_RESOLVER, " +
							"U_R.USER_FIRST_NAME RESOLVER_FIRST_NAME, " +
							"U_R.USER_LAST_NAME RESOLVER_LAST_NAME, " +
							"R.REIMB_STATUS_ID, " +
							"S.REIMB_STATUS, " +
							"R.REIMB_TYPE_ID, " +
							"T.REIMB_TYPE " +
					"from ERS_REIMBURSEMENT R " +
							"inner join ERS_REIMBURSEMENT_TYPE T " +
								"on R.REIMB_TYPE_ID = T.REIMB_TYPE_ID " +
							"inner join ERS_REIMBURSEMENT_STATUS S " +
								"on R.REIMB_STATUS_ID = S.REIMB_STATUS_ID " +
							"inner join ERS_USERS U_A " +
								"on R.REIMB_AUTHOR = U_A.USER_ID " +
							"left join ERS_USERS U_R " +
								"on R.REIMB_RESOLVER = U_R.USER_ID ";
			
			if (filterByStatusId != null || filterByAuthorId != null) {
				query += "where ";
				if (filterByStatusId != null) {
					query += "R.REIMB_STATUS_ID = ? and ";
				}
				if (filterByAuthorId != null) {
					query += "R.REIMB_AUTHOR = ? and ";
				}
				query = query.substring(0, query.length() - 5);
			}

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			int paramIndex = 1;
			
			if (filterByStatusId != null) {
				preparedStatement.setShort(paramIndex++, filterByStatusId);
			}
			if (filterByAuthorId != null) {
				preparedStatement.setInt(paramIndex++, filterByAuthorId);
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				reimbursementList.add(readReimbursement(resultSet));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursementList;
	}
	
	public Reimbursement getReimbursementById(int reimbursementId) {
		Reimbursement reimbursement = null;
		
		try(Connection connection = 
				ConnectionFactory.getInstance().getConnection()) {
			String query = 
					"select " +
							"R.REIMB_ID, " +
							"R.REIMB_AMOUNT, " +
							"R.REIMB_SUBMITTED, " +
							"R.REIMB_RESOLVED, " +
							"R.REIMB_DESCRIPTION, " +
							"R.REIMB_RECEIPT, " +
							"R.REIMB_AUTHOR, " +
							"U_A.USER_FIRST_NAME AUTHOR_FIRST_NAME, " +
							"U_A.USER_LAST_NAME AUTHOR_LAST_NAME, " +
							"R.REIMB_RESOLVER, " +
							"U_R.USER_FIRST_NAME RESOLVER_FIRST_NAME, " +
							"U_R.USER_LAST_NAME RESOLVER_LAST_NAME, " +
							"R.REIMB_STATUS_ID, " +
							"S.REIMB_STATUS, " +
							"R.REIMB_TYPE_ID, " +
							"T.REIMB_TYPE " +
					"from ERS_REIMBURSEMENT R " +
							"inner join ERS_REIMBURSEMENT_TYPE T " +
								"on R.REIMB_TYPE_ID = T.REIMB_TYPE_ID " +
							"inner join ERS_REIMBURSEMENT_STATUS S " +
								"on R.REIMB_STATUS_ID = S.REIMB_STATUS_ID " +
							"inner join ERS_USERS U_A " +
								"on R.REIMB_AUTHOR = U_A.USER_ID " +
							"left join ERS_USERS U_R " +
								"on R.REIMB_RESOLVER = U_R.USER_ID " +
					"where R.REIMB_ID = ? ";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, reimbursementId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				reimbursement = readReimbursement(resultSet);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}
	
	public boolean createReimbursement(Reimbursement reimbursement) {
		if (reimbursement == null) {
			return false;
		}
		
		int updatedRowCount = 0;
		String query = null;
		
		query = "insert into ERS_REIMBURSEMENT(" +
				"REIMB_AMOUNT, " +
				"REIMB_DESCRIPTION, " +
				"REIMB_STATUS_ID, " +
				"REIMB_TYPE_ID, " +
				"REIMB_AUTHOR) " +
			"values(?, ?, ?, ?, ?)";
		
		try(Connection connection = 
				ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, reimbursement.getAmount());
			preparedStatement.setString(2, reimbursement.getReimbursementDescription());
			preparedStatement.setShort(3, reimbursement.getReimbursementStatusId());
			preparedStatement.setShort(4, reimbursement.getReimbursementTypeId());
			preparedStatement.setInt(5, reimbursement.getReimbursementAuthorId());
			
			updatedRowCount = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRowCount > 0;
	}
	
	public boolean updateReimbursement(Reimbursement reimbursement) {
		if (reimbursement == null) {
			return false;
		}
		
		int updatedRowCount = 0;
		String query = null;
		
		query = "update ERS_REIMBURSEMENT set " +
						"REIMB_AMOUNT = ?, " +
						"REIMB_DESCRIPTION = ?, " +
						"REIMB_RESOLVER = ?, " +
						"REIMB_STATUS_ID = ?, " +
						"REIMB_TYPE_ID = ?, " +
						"REIMB_RESOLVED = ? " +
				"where REIMB_ID = ?";
		
		try(Connection connection = 
				ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, reimbursement.getAmount());
			preparedStatement.setString(2, reimbursement.getReimbursementDescription());
			preparedStatement.setInt(3, reimbursement.getReimbursementResolverId());
			preparedStatement.setShort(4, reimbursement.getReimbursementStatusId());
			preparedStatement.setShort(5, reimbursement.getReimbursementTypeId());
			preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			preparedStatement.setInt(7, reimbursement.getReimbursementId());
		
			updatedRowCount = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRowCount > 0;
	}
	
	private Reimbursement readReimbursement(ResultSet resultSet) throws SQLException {
		int reimbursementId = resultSet.getInt("REIMB_ID");
		double amount = resultSet.getDouble("REIMB_AMOUNT");
		Timestamp reimbursementSubmitted = resultSet.getTimestamp("REIMB_SUBMITTED");
		Timestamp reimbursementResolved = resultSet.getTimestamp("REIMB_RESOLVED");
		String reimbursementDescription = resultSet.getString("REIMB_DESCRIPTION");
		byte[] reimbursementReceipt = resultSet.getBytes("REIMB_RECEIPT");
		int reimbursementAuthorId = resultSet.getInt("REIMB_AUTHOR");
		String authorFirstName = resultSet.getString("AUTHOR_FIRST_NAME");
		String authorLastName = resultSet.getString("AUTHOR_LAST_NAME");
		int reimbursementResolverId = resultSet.getInt("REIMB_RESOLVER");
		String resolverFirstName = resultSet.getString("RESOLVER_FIRST_NAME");
		String resolverLastName = resultSet.getString("RESOLVER_LAST_NAME");
		short reimbursementStatusId = resultSet.getShort("REIMB_STATUS_ID");
		short reimbursementTypeId = resultSet.getShort("REIMB_TYPE_ID");
		String reimbursementStatus = resultSet.getString("REIMB_STATUS");
		String reimbursementType = resultSet.getString("REIMB_TYPE");
		
		Reimbursement reimbursement = new Reimbursement(reimbursementId, amount, reimbursementSubmitted,
				reimbursementResolved, reimbursementDescription, reimbursementReceipt,
				reimbursementAuthorId, authorFirstName, authorLastName,
				reimbursementResolverId, resolverFirstName, resolverLastName,
				reimbursementStatusId, reimbursementTypeId, reimbursementStatus,
				reimbursementType);
		
		return reimbursement;
	}
}
