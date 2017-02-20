package com.ms_manage.invoice.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerClient {

	private RestTemplate restTemplate;
	public String name="CustomerClient";
	private String host;
	private int port;
	private String postfix;
	@Autowired
	public CustomerClient(
	@Value("${service.customer.host:localhost}")		String host, 
	@Value("${service.customer.port:8080}")		int port,
	@Value("${service.customer.postfix:'/ms_manage-customer'}") String postfix) {
		super();
		this.restTemplate = new RestTemplate();
		this.host = host;
		this.port = port;
		this.postfix = postfix;
	}
	
	public String getURL(){
		return "http://"+this.host+":"+this.port+this.postfix+"/customers/";
	}
	
	public List<Customer> getAllCustomers(){
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(getURL(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>(){});
		return responseEntity.getBody();
	}
	
	public Customer getCustomer(int id){
		Customer c = restTemplate.getForObject(getURL()+id, Customer.class);
		return c;
	}
}
