package com.service;
import com.model.*;
import com.util.ApplicationUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.management.*;

public class PolicyService {
//	AllocationService as=new AllocationService();
private List<Policy> policyList=new ArrayList<>();
	
	public List<Policy> getPolicyList() {
	return policyList;
}
	public  int existId() {
		return pm.checkexists();
	}


public void setPolicyList(List<Policy> policyList) {
	this.policyList = policyList;
}
	ApplicationUtil appUtil=new ApplicationUtil();
	PolicyManagement pm=new PolicyManagement();
	
	public void addList(String... detList) {
		List<Policy> list=new ArrayList<>();
	
		for(String x:detList) {
			Policy pol=appUtil.policyRecordCreation(x);
			if(pol!=null) {
				list.add(pol);
				
			}
		}
		setPolicyList(list);
		
	}
	public int addcount() throws ClassNotFoundException, SQLException {
		
		int result=pm.addPolicyMan(policyList);
		return result;		
	
	}
	public boolean checkValidId(String id) {
		for(Policy x:policyList) {
			if(x.getPolicyId().equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}


	public boolean policyRecordModification1(String polId, int assured) throws SQLException {
				
		return pm.updatePolicyDetail1(polId,assured);
	}



	public boolean policyRecordModificationId2(String polId, int years) throws SQLException {
		
		return pm.updatePolicyDetail2(polId,years);
	}



	public List<Policy> dataRetrievalAll() {
		
		return pm.viewDataAll();
	}
public boolean checkValidId1(String id) throws SQLException {
		
		return pm.validId(id);
	}

	public boolean delete(String id) throws SQLException {
		return pm.delete(id);
	}
	
	
}
