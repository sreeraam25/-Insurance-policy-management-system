package com.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.management.PaymentManagement;
import com.model.Allocation;
import com.model.Payment;
import com.util.ApplicationUtil;

public class PaymentService {
	private List<Payment> payList=new ArrayList<>();
	
	public List<Payment> getPayList() {
		return payList;
	}
	public void setPayList(List<Payment> payList) {
		this.payList = payList;
	}
	AllocationService as=new AllocationService();
	PaymentManagement pm=new PaymentManagement();
		public boolean upidValid(String id) {
			if(id.matches("[a-z0-9]{10,}(@paytm|@oksbi|@okaxis)")) {
				return true;
			}
			else {
				return false;
			}
		}
		public boolean cardValid(String id) {
			if(id.matches("\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}")) {
				return true;
			}
			else {
				return false;
			}
		}
		public static int num2=100+existId();
		public String generateClaimId() {
			num2++;
			String id="Pay"+num2;
			
			return id;
		}
		public String generateTransactionId() {
	        return UUID.randomUUID().toString();
	    }
		public double paymentCreation(String cusid, String allocid, int type) throws SQLException {
			List<Payment> plist=getData();
			int count=0;
			for(Payment x:plist) {
				if(x.getAllocationId().equalsIgnoreCase(allocid)) {
					count+=x.getInstallmentCount();
				}
			}
			
			String ptype="";
			double preamount=payemntCalc(allocid);
			List<Payment> li=new ArrayList<Payment>();
			Date d=ApplicationUtil.getCurrentDateInSQLFormat();
			if(type==1) {
				ptype="UPI";
			}
			else {
				ptype="CARD";
			}
			count++;
			Payment pobj=new Payment(generateClaimId(), cusid, allocid, preamount, d, ptype, count);
			li.add(pobj);
			setPayList(li);
			
			return preamount;
			
		}
		int t=0;
		double sumAsu=0;
		public boolean addPayment() throws ClassNotFoundException {
			
			return pm.addPayment(payList);
		}
		public double payemntCalc(String id) throws SQLException {
			List<Allocation> li=as.dataRetrieval(id);
			
			double tot=0;
			
			double preamount=0;
			for(Allocation x:li) {
				if(x.getAllocationId().equalsIgnoreCase(id)) {
				 sumAsu=x.getSumAssured();
				  preamount=x.getPremiumAmount();
				  tot=preamount+x.getTotalPayment();
				}
			}
			 t=as.updateStatuspay(id, tot);
			return preamount;
		}
		public static  int existId() {
			PaymentManagement as=new PaymentManagement();
			return as.checkexists();
		}
		public List<Payment> getData() throws SQLException {
			List<Payment> plist=pm.viewData();
			
			return plist;
		}
//		public boolean delete(String id) throws SQLException {
//			return pm.delete(id);
//		}

}