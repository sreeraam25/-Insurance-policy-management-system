package com.management;


import com.model.Allocation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AllocationManagement {
	public boolean addAllocation(List<Allocation> list) throws ClassNotFoundException {
		try {
			Connection con=DBConnectionManager.getConnection();
			String query="insert into Allocation values(?,?,?,?,?,?,?,?,?,?)";  //9 attributes
			for(Allocation allobj:list) {
			PreparedStatement p=con.prepareStatement(query);
			p.setString(1, allobj.getAllocationId());
			p.setString(2, allobj.getCustomerId());
			
			p.setString(3, allobj.getPolicyId());
			p.setString(4, allobj.getNomineeName());
			p.setDouble(5, allobj.getSumAssured());
			p.setInt(6, allobj.getNoOfYears());
			p.setDouble(7, allobj.getPremiumAmount());
			p.setString(8, allobj.getPremiumPaymentCycle());
			p.setDouble(9, allobj.getTotalPayment());
			p.setString(10,allobj.getPolicyStatus());
			int count=p.executeUpdate();
			if(count==1) {
				return true;
			}
			
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		
		}
		return false;
	}
	public int checkexists() {
		int count=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			String query="Select * from Allocation";
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
	public boolean validId(String id) throws SQLException {
		Connection con=DBConnectionManager.getConnection();
		String query="select * from Allocation where ALLOCATION_ID=? ";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, id);
		ResultSet rs=p.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}
	public boolean validId1(String id) throws SQLException {
		Connection con=DBConnectionManager.getConnection();
		String query="select * from Allocation where CUSTOMER_ID=? ";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, id);
		ResultSet rs=p.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}

	public List<Allocation> viewDataAll() throws SQLException{
		
			List<Allocation> Clist=new ArrayList<>();
			Connection con=DBConnectionManager.getConnection();
			String query="select * from Allocation"; //where CUSTOMER_ID=? ";
			PreparedStatement p=con.prepareStatement(query);
//			p.setString(1, id);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				String allocationId=rs.getString(1);
				 String customerId=rs.getString(2);
				 String policyId=rs.getString(3);
				 String nomineeName=rs.getString(4);
				 double sumAssured=rs.getDouble(5);
				 int noOfYears=rs.getInt(6);
				 double premiumAmount=rs.getDouble(7);
				 String premiumPaymentCycle=rs.getString(8);
				 double totalPayment=rs.getDouble(9);
				 String policyStatus=rs.getString(10);
				 
				 Allocation alc=new Allocation(allocationId,customerId,policyId,nomineeName,sumAssured,noOfYears,premiumAmount,premiumPaymentCycle,totalPayment,policyStatus);
				 Clist.add(alc);
			}
			return Clist;
	}
	public List<Allocation> viewData(String id) throws SQLException{
		
		List<Allocation> Clist=new ArrayList<>();
		Connection con=DBConnectionManager.getConnection();
		String query="select * from Allocation where ALLOCATION_ID=? ";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, id);
		ResultSet rs=p.executeQuery();
		while(rs.next()) {
			String allocationId=rs.getString(1);
			 String customerId=rs.getString(2);
			 String policyId=rs.getString(3);
			 String nomineeName=rs.getString(4);
			 double sumAssured=rs.getDouble(5);
			 int noOfYears=rs.getInt(6);
			 double premiumAmount=rs.getDouble(7);
			 String premiumPaymentCycle=rs.getString(8);
			 double totalPayment=rs.getDouble(9);
			 String policyStatus=rs.getString(10);
			 
			 Allocation alc=new Allocation(allocationId,customerId,policyId,nomineeName,sumAssured,noOfYears,premiumAmount,premiumPaymentCycle,totalPayment,policyStatus);
			 Clist.add(alc);
		}
		return Clist;
}
public List<Allocation> viewData1(String id) throws SQLException{
		
		List<Allocation> Clist=new ArrayList<>();
		Connection con=DBConnectionManager.getConnection();
		String query="select * from Allocation where CUSTOMER_ID=? ";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, id);
		ResultSet rs=p.executeQuery();
		while(rs.next()) {
			String allocationId=rs.getString(1);
			 String customerId=rs.getString(2);
			 String policyId=rs.getString(3);
			 String nomineeName=rs.getString(4);
			 double sumAssured=rs.getDouble(5);
			 int noOfYears=rs.getInt(6);
			 double premiumAmount=rs.getDouble(7);
			 String premiumPaymentCycle=rs.getString(8);
			 double totalPayment=rs.getDouble(9);
			 String policyStatus=rs.getString(10);
			 
			 Allocation alc=new Allocation(allocationId,customerId,policyId,nomineeName,sumAssured,noOfYears,premiumAmount,premiumPaymentCycle,totalPayment,policyStatus);
			 Clist.add(alc);
		}
		return Clist;
}
	public int updateStatus(String id,String type,double asu) throws SQLException {
		Connection con=DBConnectionManager.getConnection();
		String query="update Allocation set POLICY_STATUS=?,SUM_ASSURED=? where ALLOCATION_ID=? ";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1,type);
		p.setDouble(2, asu);
		p.setString(3, id);

		int count=p.executeUpdate();
		if(count>0) {
			return 1;
		}
		return 0;
	}
	public int updateStatus1(String id,double tot) throws SQLException {
		Connection con=DBConnectionManager.getConnection();
		String query="update Allocation set TOTAL_PAYMENT=? where ALLOCATION_ID=? ";
		PreparedStatement p=con.prepareStatement(query);
		p.setDouble(1,tot);
		p.setString(2, id);

		int count=p.executeUpdate();
		if(count>0) {
			return 1;
		}
		return 0;
	}
	public boolean delete(String id) throws SQLException {
		Connection con=DBConnectionManager.getConnection();
		String query="delete from Allocation where ALLOCATION_ID=?";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, id);
		int t=p.executeUpdate();
		if(t==1) {
			return true;
		}
		return false;
	}
	
}

