package com.management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Claim;

public class ClaimManagement {
	Connection con=DBConnectionManager.getConnection();
	
	public boolean addClaim(List<Claim> claim) throws SQLException {
		String query="insert into claim values(?,?,?,?,?,?)";
		for(Claim cObj:claim) {
			PreparedStatement p=con.prepareStatement(query);
			p.setString(1,cObj.getClaimId());
			p.setString(2,cObj.getCustomerId());
			p.setString(3,cObj.getAllocationId());
			p.setString(4,cObj.getClaimType());
			p.setDouble(5, cObj.getClaimAmount());
			p.setDate(6,cObj.getClaimDate());
			
			int res=p.executeUpdate();
			
			if(res>0) {
				return true;
			}
			return false;
		}
		return false;
	}
	public int checkexists() {
		int count=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			String query="Select * from Claim";
			PreparedStatement p=con.prepareStatement(query);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				count++;
			}

			return count;
			
		}
		catch(Exception e) {
			
		}
		return count;
	}
	
	public List<Claim> viewData() throws SQLException {
		List<Claim> Clist=new ArrayList<>();
		Connection con=DBConnectionManager.getConnection();
		String query="select * from Claim"; //where CUSTOMER_ID=? ";
		PreparedStatement p=con.prepareStatement(query);
//		p.setString(1, id);
		ResultSet rs=p.executeQuery();
		while(rs.next()) {
			 String claimId=rs.getString(1);
			 String customerId=rs.getString(2);
			 String allocationId=rs.getString(3);
			 String claimType=rs.getString(4);
			 double claimAmount=rs.getDouble(5);
			 Date claimDate=rs.getDate(6);
			 Claim cobj=new Claim(claimId,customerId,allocationId,claimType,claimAmount,claimDate);
			 Clist.add(cobj);
		}
		
		return Clist;
	}
	public boolean delete(String id) throws SQLException {
		Connection con=DBConnectionManager.getConnection();
		String query="delete from Claim where CLAIM_ID=?";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, id);
		int t=p.executeUpdate();
		if(t==1) {
			return true;
		}
		return false;
	}
}
