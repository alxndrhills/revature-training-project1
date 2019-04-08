package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.data.ReimbursementType;
import com.revature.util.ConnectionFactory;

public class ReimbursementTypeDAO {

	public List<ReimbursementType> getTypeList() {
		List<ReimbursementType> reimbursementTypeList =
				new ArrayList<ReimbursementType>();
		
		try(Connection connection = 
				ConnectionFactory.getInstance().getConnection()){
			String query = 
					"select " +
							"REIMB_TYPE_ID, " +
							"REIMB_TYPE " +
					"from ERS_REIMBURSEMENT_TYPE";
	
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				short reimbursementTypeId = resultSet.getShort("REIMB_STATUS_ID");
				String reimbursementType = resultSet.getString("REIMB_STATUS");
				
				ReimbursementType reimbursementTypeObject = 
						new ReimbursementType(reimbursementTypeId, reimbursementType);
				reimbursementTypeList.add(reimbursementTypeObject);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursementTypeList;
	}
}
