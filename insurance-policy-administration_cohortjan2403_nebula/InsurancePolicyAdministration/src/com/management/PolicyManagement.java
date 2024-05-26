package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.model.Policy;

public class PolicyManagement {
	public int addPolicyMan(List<Policy> list) throws ClassNotFoundException {
		int count=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			String query="insert into Policy values(?,?,?,?,?,?,?)";  //9 attributes
			
			for(Policy polobj:list) {
				PreparedStatement p=con.prepareStatement(query);
				p.setString(1, polobj.getPolicyId());
				p.setInt(2, polobj.getSchemeNumber());
				
				p.setString(3, polobj.getPolicyName());
				p.setString(4, polobj.getPolicyType());
				p.setInt(5, polobj.getMaxNoOfYears());
				p.setDouble(6, polobj.getPremiumRate());
				p.setInt(7, polobj.getMaxSumAssured());
				
				
				int r=p.executeUpdate();
				
				if(r>0) {
					count++;
				}
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		
		}
		return count;
	}
	public boolean updatePolicyDetail1(String id, int assured) throws SQLException {
		Connection con=DBConnectionManager.getConnection();
		String query="update policy set MAX_SUM_ASSURED =? where POLICY_ID=?";   
		PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, assured);
		p.setString(2, id);
		int t=p.executeUpdate();
		if(t==1) {
			return true;
		}
		
		return false;
	}
	public boolean updatePolicyDetail2(String id, int years) throws SQLException {
		Connection con=DBConnectionManager.getConnection();
		String query="update policy set MAX_NO_OF_YEARS	=? where POLICY_ID=?";
		PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, years);
		p.setString(2, id);
		int t=p.executeUpdate();
		if(t==1) {
			return true;
		}
		
		return false;
		
	}
	
	public List<Policy> viewDataAll() {
		
		try {
			Connection con=DBConnectionManager.getConnection();
			List<Policy> plist=new ArrayList<>();
			String query="select * from Policy"; //where CUSTOMER_ID=? ";
			PreparedStatement p=con.prepareStatement(query);
//			p.setString(1, id);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				String policyId=rs.getString(1);
				int schemaNumber=rs.getInt(2);
				String policyName=rs.getString(3);
				String policyType=rs.getString(4);
				int maxNoOfYears=rs.getInt(5);
				double premiumRate=rs.getDouble(6);
				int maxSumAssured=rs.getInt(7);

				Policy cus=new Policy(policyId,schemaNumber,policyName,policyType,maxNoOfYears,premiumRate,maxSumAssured);
				plist.add(cus);
			}
			return plist;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public int checkexists() {
		int count=0;
		try {
			String query="Select * from Policy";
			Connection con=DBConnectionManager.getConnection();
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
	public boolean delete(String id) throws SQLException {
		Connection con=DBConnectionManager.getConnection();
		String query="delete from Policy where Policy_ID=?";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, id);
		int t=p.executeUpdate();
		if(t==1) {
			return true;
		}
		return false;
	}
	public boolean validId(String id) throws SQLException {
		Connection con=DBConnectionManager.getConnection();
		String query="select * from Policy where Policy_ID=? ";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, id);
		ResultSet rs=p.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}	
	
}
