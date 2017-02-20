package com.ms_manage.customer.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ms_manage.customer.model.Customer;

@SuppressWarnings("serial")
@Repository
@Qualifier("testData")
public class CustomerTestDao implements ICustomerDao {

	private static Map<Integer, Customer> customers;
	
	static{
		customers = new HashMap<Integer, Customer>(){
			{
				put(1, new Customer(1, "Name 1", "Straße1", "59939", "Olsberg", "555", "mail1", "00", "00"));
				put(2, new Customer(2, "Name 2", "Straße2", "59939", "Olsberg", "555", "mail1", "00", "00"));
				put(3, new Customer(3, "Name 3", "Straße3", "59939", "Olsberg", "555", "mail1", "00", "00"));
			}
		};
	}
	/* (non-Javadoc)
	 * @see com.ms_manage.dao.ICustomerDao#getAllCustomers()
	 */
	@SuppressWarnings("static-access")
	@Override
	public Collection<Customer> getAllCustomers(){
		return this.customers.values();
	}
	
	/* (non-Javadoc)
	 * @see com.ms_manage.dao.ICustomerDao#getCustomer(int)
	 */
	@SuppressWarnings("static-access")
	@Override
	public Customer getCustomer(int id){
		return this.customers.get(id);
	}
	
	/* (non-Javadoc)
	 * @see com.ms_manage.dao.ICustomerDao#updateCustomer(com.ms_manage.model.Customer)
	 */
	@Override
	public void updateCustomer(Customer customer){
		Customer cust = customers.get(customer.getId());
		cust.setName(customer.getName());
		cust.setStrasse(customer.getStrasse());
		cust.setOrt(customer.getOrt());
		customers.put(customer.getId(),cust);
	}
	
	/* (non-Javadoc)
	 * @see com.ms_manage.dao.ICustomerDao#removeCustomer(int)
	 */
	@SuppressWarnings("static-access")
	@Override
	public void removeCustomer(int id){
		this.customers.remove(id);
	}
	
	/* (non-Javadoc)
	 * @see com.ms_manage.dao.ICustomerDao#insertCustomer(com.ms_manage.model.Customer)
	 */
	@SuppressWarnings("static-access")
	@Override
	public void insertCustomer(Customer customer){
		this.customers.put(customer.getId(), customer);
	}
}
