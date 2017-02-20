package com.ms_manage.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ms_manage.customer.dao.CustomerMySQLCrudDao;
import com.ms_manage.customer.model.Customer;

@Service
public class CustomerService {

	@Autowired
	@Qualifier("mysql")
	private CustomerMySQLCrudDao customerDao;
	
	public List<Customer> getAllCustomers(){
		List<Customer> custs = new ArrayList<Customer>();
		for(Customer cust : customerDao.findAll()){
			custs.add(cust);
		}
		return custs;
	}
	
	public Customer getCustomer (int id){
		return this.customerDao.findOne(id);
	}
	
	public void removeCustomer (int id){
		this.customerDao.delete(id);;
	}
	
	public void updateCustomer (Customer c){
		this.customerDao.save(c);
	}
	
	public void insertCustomer (Customer c){
		this.customerDao.save(c);
	}
	/*
	public Collection<Customer> getAllCustomers(){
		return this.customerDao.findAll();
	}
	
	public Customer getCustomer (int id){
		return this.customerDao.getCustomer(id);
	}
	
	public void removeCustomer (int id){
		this.customerDao.removeCustomer(id);
	}
	
	public void updateCustomer (Customer c){
		this.customerDao.updateCustomer(c);
	}
	
	public void insertCustomer (Customer c){
		this.customerDao.insertCustomer(c);
	}
	*/
}
