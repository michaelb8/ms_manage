package com.ms_manage.customer.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms_manage.customer.model.Customer;
import com.ms_manage.customer.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable("id") int id){
		return customerService.getCustomer(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public void insertCustomer (@RequestBody Customer c){
		customerService.insertCustomer(c);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeCustomer (@PathVariable("id") int id){
		customerService.removeCustomer(id);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public void updateCustomer (@RequestBody Customer c){
		customerService.updateCustomer(c);
	}
}
