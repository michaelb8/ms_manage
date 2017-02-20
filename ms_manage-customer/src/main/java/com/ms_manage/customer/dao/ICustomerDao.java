package com.ms_manage.customer.dao;

import java.util.Collection;

import com.ms_manage.customer.model.Customer;

public interface ICustomerDao {

	Collection<Customer> getAllCustomers();

	Customer getCustomer(int id);

	void updateCustomer(Customer customer);

	void removeCustomer(int id);

	void insertCustomer(Customer customer);

}