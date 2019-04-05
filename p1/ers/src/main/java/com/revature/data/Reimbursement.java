package com.revature.data;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int reimbursementId;
	private double amount;
	private Timestamp reimbursementSubmitted;
	private Timestamp reimbursementResolved;
	private String reimbursementDescription;
	private byte[] reimbursementReceipt;
	private int reimbursementAuthorId;
	private String authorFirstName;
	private String authorLastName;
	private int reimbursementResolverId;
	private String resolverFirstName;
	private String resolverLastName;
	private short reimbursementStatusId;
	private short reimbursementTypeId;
	private String reimbursementStatus;
	private String reimbursementType;
	
	public Reimbursement() { }
	
	public Reimbursement(int reimbursementId, double amount, Timestamp reimbursementSubmitted,
			Timestamp reimbursementResolved, String reimbursementDescription, byte[] reimbursementReceipt,
			int reimbursementAuthorId, String authorFirstName, String authorLastName, int reimbursementResolverId,
			String resolverFirstName, String resolverLastName, short reimbursementStatusId, short reimbursementTypeId,
			String reimbursementStatus, String reimbursementType) {
		super();
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.reimbursementSubmitted = reimbursementSubmitted;
		this.reimbursementResolved = reimbursementResolved;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementReceipt = reimbursementReceipt;
		this.reimbursementAuthorId = reimbursementAuthorId;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.reimbursementResolverId = reimbursementResolverId;
		this.resolverFirstName = resolverFirstName;
		this.resolverLastName = resolverLastName;
		this.reimbursementStatusId = reimbursementStatusId;
		this.reimbursementTypeId = reimbursementTypeId;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getReimbursementSubmitted() {
		return reimbursementSubmitted;
	}

	public void setReimbursementSubmitted(Timestamp reimbursementSubmitted) {
		this.reimbursementSubmitted = reimbursementSubmitted;
	}

	public Timestamp getReimbursementResolved() {
		return reimbursementResolved;
	}

	public void setReimbursementResolved(Timestamp reimbursementResolved) {
		this.reimbursementResolved = reimbursementResolved;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}

	public byte[] getReimbursementReceipt() {
		return reimbursementReceipt;
	}

	public void setReimbursementReceipt(byte[] reimbursementReceipt) {
		this.reimbursementReceipt = reimbursementReceipt;
	}

	public int getReimbursementAuthorId() {
		return reimbursementAuthorId;
	}

	public void setReimbursementAuthorId(int reimbursementAuthorId) {
		this.reimbursementAuthorId = reimbursementAuthorId;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public int getReimbursementResolverId() {
		return reimbursementResolverId;
	}

	public void setReimbursementResolverId(int reimbursementResolverId) {
		this.reimbursementResolverId = reimbursementResolverId;
	}

	public String getResolverFirstName() {
		return resolverFirstName;
	}

	public void setResolverFirstName(String resolverFirstName) {
		this.resolverFirstName = resolverFirstName;
	}

	public String getResolverLastName() {
		return resolverLastName;
	}

	public void setResolverLastName(String resolverLastName) {
		this.resolverLastName = resolverLastName;
	}

	public short getReimbursementStatusId() {
		return reimbursementStatusId;
	}

	public void setReimbursementStatusId(short reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}

	public short getReimbursementTypeId() {
		return reimbursementTypeId;
	}

	public void setReimbursementTypeId(short reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}

	public String getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public String getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}
	
	public String getAuthor() {
		return this.authorFirstName + " " + this.authorLastName;
	}
	
	public String getResolver() {
		return (this.resolverFirstName != null ? (this.resolverFirstName + " ") : "") +
				(this.resolverLastName != null ? this.resolverLastName : "");
	}
}
