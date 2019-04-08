package com.revature.ers;

import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

import com.revature.dao.ReimbursementDAO;
import com.revature.data.Reimbursement;

public class App {
	
    public static void main( String[] args ) {
    	
    	List<String> pwList = createPwList();
    	hashPw(pwList);
    	
    	/*
    	ReimbursementDAO reimbDAO = new ReimbursementDAO();
    	List<Reimbursement> reimbList = reimbDAO.getReimbursementList(null, null);
    	
    	reimbList = reimbDAO.getReimbursementList((short)2, 1);
    	
    	for (int i = 0; i < reimbList.size(); i++) {
    		System.out.println(reimbList.get(i).getReimbursementDescription());
    	}
    	
    	Reimbursement reimb = reimbDAO.getReimbursementById(3);
    	
    	System.out.println(reimb.getReimbursementDescription());
    	*/
    }
    
    public static List<String> createPwList() {
    	List<String> pwList = new ArrayList<String>();
    
    	pwList.add("qgBQJH4M");
    	pwList.add("7O5GoZkx");
    	pwList.add("gJ2ix8rm");
    	pwList.add("qBQ9N7yi");
    	pwList.add("UF2auh9r");
    	pwList.add("K0SKYrWv");
    	pwList.add("W7hmSNX9");
    	pwList.add("bri8EYqQ");
    	pwList.add("xJG3J1MD");
    	pwList.add("Fl1u6bVM");
    	
    	pwList.add("CCWlW61M");
    	pwList.add("62K2mTAg");
    	pwList.add("zm72CyYC");
    	pwList.add("aBwL5E9t");
    	pwList.add("k4Om2ALa");
    	pwList.add("zT3gxSmf");
    	pwList.add("CeJj7KAj");
    	pwList.add("5KxmcD8b");
    	pwList.add("19lZsE6O");
    	pwList.add("OSNyb68P");
    	
    	pwList.add("1cZfpBOD");
    	pwList.add("xKeP0zIr");
    	pwList.add("q0uVbOsC");
    	pwList.add("N5spw7ri");
    	pwList.add("AD5pst4i");
    	pwList.add("3KCpcSKn");
    	pwList.add("3t0s8cAj");
    	pwList.add("SmSV20Q1");
    	pwList.add("EP6FcaDF");
    	pwList.add("eLTbL3Ib");
    	
    	pwList.add("Hk6tnJdJ");
    	pwList.add("QhDY9o6v");
    	pwList.add("6xi8QTXE");
    	pwList.add("z0zWTigl");
    	pwList.add("bLY8L4Fi");
    	pwList.add("IZCZyr9W");
    	pwList.add("nJL9Lm6o");
    	pwList.add("NxMR2Jy3");
    	pwList.add("9wyIbE1D");
    	pwList.add("RvtQGo0h");
    	
    	return pwList;
    }
    
    public static void hashPw(List<String> pwList) {
    	
    	for (String pw : pwList) {
    		String pwHash = BCrypt.hashpw(pw, BCrypt.gensalt()); 
        	System.out.println(pwHash);
    	}
    }
}
