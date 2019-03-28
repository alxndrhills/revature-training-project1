package com.revature.data;

public class ReimbursementType {

	private short reimbursementTypeId;
	private String reimbursementType;
	
	public ReimbursementType(short reimbursementTypeId, String reimbursementType) {
		this.reimbursementTypeId = reimbursementTypeId;
		this.reimbursementType = reimbursementType;
	}

	public short getReimbursementTypeId() {
		return reimbursementTypeId;
	}
	
	public void setReimbursementTypeId(short reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}
	
	public String getReimbursementType() {
		return reimbursementType;
	}
	
	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}
	
	
}
