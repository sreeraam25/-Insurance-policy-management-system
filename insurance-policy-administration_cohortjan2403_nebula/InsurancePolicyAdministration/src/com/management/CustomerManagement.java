package com.management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManagement {
	
	Connection con=DBConnectionManager.getConnection();
	public int addCustomer(List<Customer> list) throws ClassNotFoundException, SQLException {
		
		int count=0;
		for(Customer x:list) {
			String query="insert into customer values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=con.prepareStatement(query);
			p.setString(1,x.getCustomerId());
			p.setString(2,x.getCustomerName());
			p.setDate(3,(x.getDob()));
			p.setInt(4,x.getAge());
			p.setString(5,x.getGender());
			p.setString(6,x.getOccupation());
			p.setDouble(7,x.getAnnualIncome());
			p.setString(8,x.getMedicalHistory());
			p.setString(9, x.getAddress());
			p.setLong(10,x.getPhoneNumber());
			p.setString(11,x.getEmailId());
			int r=p.executeUpdate();
			if(r>0) {
				count++;
			}
			
		}
		return count;
	}
	public boolean updateCustomerId(String id,String email) throws SQLException {
		String query="update Customer set EMAIL_ID=? where CUSTOMER_ID=?";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1,email);
		p.setString(2, id);
		int t=p.executeUpdate();
		if(t==1) {
			return true;
		}
		
		return false;
	}
	public boolean updateCustomerPh(String id,long ph) throws SQLException {
		String query="update Customer set PHONE_NUMBER=? where CUSTOMER_ID=?";
		PreparedStatement p=con.prepareStatement(query);
		p.setLong(1, ph);
		p.setString(2, id);
		int t=p.executeUpdate();
		if(t==1) {
			return true;
		}
		
		return false;
	}
	public int checkexists() {
		int count=0;
		try {
			String query="Select * from Customer";
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
	public List<Customer> viewDataAll(){
		try {
			List<Customer> Clist=new ArrayList<>();
			String query="select * from Customer"; //where CUSTOMER_ID=? ";
			PreparedStatement p=con.prepareStatement(query);
//			p.setString(1, id);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				String customerId=rs.getString(1);
				String customerName=rs.getString(2);
				Date dob=rs.getDate(3);
				int age=rs.getInt(4);
				String gender=rs.getString(5);
				String occupation=rs.getString(6);
				double annualIncome=rs.getDouble(7);
				String medicalHistory=rs.getString(8);
				String address=rs.getString(9);
				long phoneNumber=rs.getLong(10);
				String emailId=rs.getString(11);
				Customer cus=new Customer(customerId,customerName,dob,age,gender,occupation,annualIncome,medicalHistory,address,phoneNumber,emailId);
				Clist.add(cus);
			}
			return Clist;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Customer> viewData(String id){
		try {
			List<Customer> Clist=new ArrayList<>();
			String query="select * from Customer where CUSTOMER_ID=? ";
			PreparedStatement p=con.prepareStatement(query);
			p.setString(1, id);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				String customerId=rs.getString(1);
				String customerName=rs.getString(2);
				Date dob=rs.getDate(3);
				int age=rs.getInt(4);
				String gender=rs.getString(5);
				String occupation=rs.getString(6);
				double annualIncome=rs.getDouble(7);
				String medicalHistory=rs.getString(8);
				String address=rs.getString(9);
				long phoneNumber=rs.getLong(10);
				String emailId=rs.getString(11);
				Customer cus=new Customer(customerId,customerName,dob,age,gender,occupation,annualIncome,medicalHistory,address,phoneNumber,emailId);
				Clist.add(cus);
			}
			return Clist;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean validId(String id) throws SQLException {
		String query="select * from Customer where CUSTOMER_ID=? ";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, id);
		ResultSet rs=p.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}
	public boolean delete(String id) throws SQLException {
		String query="delete from Customer where CUSTOMER_ID=?";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, id);
		int t=p.executeUpdate();
		if(t==1) {
			return true;
		}
		return false;
	}
}
