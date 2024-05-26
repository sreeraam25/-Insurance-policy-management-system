package com.util;

import java.sql.*;
import com.model.Customer;
import com.model.Policy;
import com.service.CustomerService;
import com.service.PolicyService;



public class ApplicationUtil {
	static CustomerService cs=new CustomerService();
	static PolicyService ps=new PolicyService();
	public static int num=100+cs.existId();;
	
	public static int num1=100+ps.existId();;
	
	
	public String generateId() {

		
		num++;
		String id="STAR"+num;
		return id;	
	}
	
	public String generatePolicyId() {
		num1++;
		String id="Policy"+num1;
		return id;	
	}
	
	
		public Date convertDate(String date) {
			Date sqlDate=Date.valueOf(date);
			return sqlDate;
		}
//		CustomerManagement cusManage=new CustomerManagement();
	public Customer customerRecordCreation(String details)  {
		String[] info=details.split(":");
		String customerId=generateId();
		String customerName=info[0];
		Date dob=convertDate(info[1]);
		int	age=Integer.parseInt(info[2]);
		String gender=info[3];
		String occupation=info[4];
		 double annualIncome=Double.parseDouble(info[5]);
		 String medicalHistory=info[6];
		 String address=info[7];
		 long phoneNumber=Long.parseLong(info[8]);
		 String emailId=info[9];
		 Customer cusObj=new Customer(customerId,customerName,dob,age,gender,occupation,annualIncome,medicalHistory,address,phoneNumber,emailId);
//		 cusManage.addCustomer();
		 	return cusObj;
	}
	public Policy policyRecordCreation(String details) {
		String[] info=details.split(":");
		String policyId=generatePolicyId();
		int schemeNumber=Integer.parseInt(info[0]);
		String policyName=info[1];
		String policyType=info[2];
		int maxNoOfYears=Integer.parseInt(info[3]);
		double premiumRate=Double.parseDouble(info[4]);
		int maxSumAssured=Integer.parseInt(info[5]);
		Policy pObj=new Policy(policyId,schemeNumber,policyName,policyType,maxNoOfYears,premiumRate,maxSumAssured);
		
		
		return pObj;
	}

	
	public static Date getCurrentDateInSQLFormat() {
        
        long currentTimeMillis = System.currentTimeMillis();
        
        
        Date sqlDate = new Date(currentTimeMillis);
        
        return sqlDate;
    }

}
