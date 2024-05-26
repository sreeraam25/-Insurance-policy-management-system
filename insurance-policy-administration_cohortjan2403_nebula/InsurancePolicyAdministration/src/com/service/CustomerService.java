package com.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.management.CustomerManagement;
import com.model.Customer;
import com.util.ApplicationUtil;

public class CustomerService {
	private List<Customer> cusList=new ArrayList<>();
	
	
	public List<Customer> getCusList() {
		return cusList;
	}

	public void setCusList(List<Customer> cusList) {
		this.cusList = cusList;
	}
	

	ApplicationUtil appUtil=new ApplicationUtil();
	CustomerManagement cm=new CustomerManagement();
	
	
	
	public void addList(String... detList) {
		List<Customer> list=new ArrayList<>();
	
		for(String x:detList) {
			Customer cus=appUtil.customerRecordCreation(x);
			if(cus!=null){
				list.add(cus);
				
			}
		}
		setCusList(list);
		
	}
	public int addCustomercount() throws ClassNotFoundException, SQLException {
		
		int result=cm.addCustomer(cusList);
		return result;		
	
	}
	public boolean checkValidId(String id) throws SQLException {
		
		return cm.validId(id);
	}


	
	public boolean customerRecordModificationPh(String id,long ph) throws SQLException {
		return  cm.updateCustomerPh(id,ph);
		
	}
	public boolean customerRecordModificationId(String id,String email) throws SQLException {
		return  cm.updateCustomerId(id,email);
		
	}
	public List<Customer> dataRetrievalAll() {
		return cm.viewDataAll();
	}
	public List<Customer> dataRetrieval(String id) {
		return cm.viewData(id);
	}
	public  int existId() {
		return cm.checkexists();
	}
	public boolean delete(String id) throws SQLException {
		return cm.delete(id);
	}
	
}
