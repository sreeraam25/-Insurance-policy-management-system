package com.management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Payment;


public class PaymentManagement {
	public int checkexists() {
		int count=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			String query="Select * from Payment";
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
	public boolean addPayment(List<Payment> list) throws ClassNotFoundException {
	
		try {
			Connection con=DBConnectionManager.getConnection();
			String query="insert into Payment values(?,?,?,?,?,?,?)";  //7 attributes
			
			for(Payment x:list) {
				PreparedStatement p=con.prepareStatement(query);
				p.setString(1, x.getPaymentId());
				p.setString(2,x.getCustomerId());
				p.setString(3,x.getAllocationId());
				p.setDouble(4,x.getPremium());
				p.setDate(5,x.getPaymentDate());
				p.setString(6,x.getPaymentMode());
				p.setInt(7,x.getInstallmentCount());
				
				
				int r=p.executeUpdate();
				
				if(r>0) {
					return true;
				}
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		
		}
		return false;
	}
	public List<Payment> viewData() throws SQLException {
		List<Payment> Plist=new ArrayList<>();
		Connection con=DBConnectionManager.getConnection();
		String query="select * from Payment"; //where CUSTOMER_ID=? ";
		PreparedStatement p=con.prepareStatement(query);
//		p.setString(1, id);
		ResultSet rs=p.executeQuery();
		while(rs.next()) {
			String paymentId=rs.getString(1);
			String customerId=rs.getString(2);
			String allocationId=rs.getString(3);
			double premium=rs.getDouble(4);
			Date paymentDate=rs.getDate(5);
			String paymentMode=rs.getString(6);
			int installmentCount=rs.getInt(7);
			 Payment pobj=new Payment(paymentId,customerId,allocationId,premium,paymentDate,paymentMode,installmentCount);
			 Plist.add(pobj);
		}
		
		return Plist;
	}
}
