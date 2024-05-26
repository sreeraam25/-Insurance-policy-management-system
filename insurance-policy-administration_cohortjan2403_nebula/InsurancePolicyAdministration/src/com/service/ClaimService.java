package com.service;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import com.management.ClaimManagement;
import com.model.*;
import com.util.*;
public class ClaimService {
	public static int num2=100+existId();
	public String generateClaimId() {
		num2++;
		String id="Claim"+num2;
			
		
		return id;
		
	}
	ApplicationUtil appUtil=new ApplicationUtil();
	AllocationService as=new AllocationService();
	ClaimManagement cm=new ClaimManagement();
	private List<Claim> claimList=new ArrayList<Claim>();
		public List<Claim> getClaimList() {
		return claimList;
	}
	public void setClaimList(List<Claim> claimList) {
		this.claimList = claimList;
	}
		double claimamount=0;
		public void claimCreation(String custId,String alid,String type) throws SQLException {
			List<Claim> li=new ArrayList<Claim>();
				 claimamount=claimCalc(alid,type);
				Date d=ApplicationUtil.getCurrentDateInSQLFormat();
				
			Claim obj=new Claim(generateClaimId(), custId, alid, type, claimamount,d);
			li.add(obj);
			setClaimList(li);
		
//				
		}
		int a=0;
		public double addClaim() throws SQLException{
			if(cm.addClaim(claimList)) {
				return claimamount;
			}
			return 0;
			
		}
		public double claimCalc(String id,String type) throws SQLException {
			List<Allocation> li=as.dataRetrieval(id);
			double sumAsu=0;
			double tot=0;
			double amount=0;
			String status="";
			double upsumAsu=0;
			for(Allocation x:li) {
				 sumAsu=x.getSumAssured();
				 tot=x.getTotalPayment();
			}
			if(type.equalsIgnoreCase("Death")) {
				amount=sumAsu;
				status="inactive";
				upsumAsu=0;
			}
			else if(type.equalsIgnoreCase("Maturity")) {
					amount=tot;
					status="inactive";
					upsumAsu=0;
				}
			else if(type.equalsIgnoreCase("Survival benefit")){
				amount= sumAsu*0.05; //50% of amount in sum assured
				status="active";
				upsumAsu=sumAsu-amount;
				
			}
				
			a=as.updateStatusClaim(id,status,upsumAsu); // update in allocation DB
			
			return amount;
		}

		public static  int existId() {
			ClaimManagement as=new ClaimManagement();
			return as.checkexists();
		}
		public List<Claim> getData() throws SQLException {
			
			return cm.viewData();
		}
		public boolean delete(String id) throws SQLException {
			return cm.delete(id);
		}
		
}
