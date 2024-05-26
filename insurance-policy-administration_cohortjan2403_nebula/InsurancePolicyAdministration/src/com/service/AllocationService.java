package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.management.AllocationManagement;
import com.management.PolicyManagement;
import com.model.Allocation;
import com.model.Policy;
import com.util.ApplicationUtil;
import com.exception.*;

public class AllocationService {
	PolicyManagement pol=new PolicyManagement();
	public static int num2=100+existId();
	public String generateAllocId() {
		num2++;
		String id="Alloc"+num2;
			
		
		return id;
		
	}
	PolicyService ps=new PolicyService();
	 AllocationManagement am=new AllocationManagement();
	private List<Allocation> AllocList=new ArrayList<>();
	
	public List<Allocation> getAllocList() {
		return AllocList;
	}
	public void setAllocList(List<Allocation> allocList) {
		AllocList = allocList;
	}

	ApplicationUtil appUtil=new ApplicationUtil();

	@SuppressWarnings("unused")
	public void calculatePremiumAmount(String cid,String pid,String name,int cycle) throws InvalidAllocationException {
		List<Allocation> list=new ArrayList<>();
		List<Policy> policy=pol.viewDataAll();
		double sum_assured=0;
		double rate=0;
		int years=0;
		for(Policy x:policy) {
			if(x.getPolicyId().equalsIgnoreCase(pid)) {
				 sum_assured=x.getMaxSumAssured();
				 rate=x.getPremiumRate();
				 
			}

		}
		double amount=(sum_assured*rate);
		double preamount=0;
		String cyc="";
		String status="Active";
		if(cycle==1) {
			cyc="Half-year";
			preamount=amount/2;
			years=(int) (sum_assured/preamount);
		}
		else if(cycle==2) {
			 cyc="Yearly";
			 preamount=amount;
			 years=(int) (sum_assured/preamount);
		}
		
		
		Allocation obj=new Allocation(generateAllocId(),cid,pid,name,sum_assured,years,preamount,cyc,0,status);
		if(obj==null)
		{
			throw new InvalidAllocationException("Allocation object is null");
		}
		else
		{
		list.add(obj);
		setAllocList(list);
		}
	}
public boolean allocationCreation() throws ClassNotFoundException, SQLException {
		
		boolean result=am.addAllocation(AllocList);
		return result;		
	
	}
		public boolean checkValidId(String id) throws SQLException {
	
				return am.validId(id);
		}
		public boolean checkValidId1(String id) throws SQLException {
			
			return am.validId1(id);
	}

	
	public List<Allocation> dataRetrievalAll() throws SQLException {
		return am.viewDataAll();
	}
	public List<Allocation> dataRetrieval(String id) throws SQLException {
		return am.viewData(id);
	}
	public List<Allocation> dataRetrievalC(String id) throws SQLException {
		return am.viewData1(id);
	}
	public static  int existId() {
		AllocationManagement as=new AllocationManagement();
		return as.checkexists();
	}
	public int updateStatusClaim(String id,String type,double asu) throws SQLException {
		return am.updateStatus(id, type,asu);
	}
	public int updateStatuspay(String id,double tot) throws SQLException {
		return am.updateStatus1(id, tot);
	}
	public boolean delete(String id) throws SQLException {
		return am.delete(id);
	}
}
