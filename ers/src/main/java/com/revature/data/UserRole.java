package com.revature.data;

public class UserRole {
	
	private short userRoleId;
	private String userRole;
	
	public UserRole(short userRoleId, String userRole) {
		super();
		this.userRoleId = userRoleId;
		this.userRole = userRole;
	}

	public short getUserRoleId() {
		return userRoleId;
	}
	
	public void setUserRoleId(short userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	public String getUserRole() {
		return userRole;
	}
	
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}
