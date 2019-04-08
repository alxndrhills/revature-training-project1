package com.revature.data;

public class ReimbursementStatus {
	
	private short reimbursementStatusId;
	private String reimbursementStatus;
	
	public ReimbursementStatus(short reimbursementStatusId, String reimbursementStatus) {
		this.reimbursementStatusId = reimbursementStatusId;
		this.reimbursementStatus = reimbursementStatus;
	}

	public short getReimbursementStatusId() {
		return reimbursementStatusId;
	}
	
	public void setReimbursementStatusId(short reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}
	
	public String getReimbursementStatus() {
		return reimbursementStatus;
	}
	
	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

}
