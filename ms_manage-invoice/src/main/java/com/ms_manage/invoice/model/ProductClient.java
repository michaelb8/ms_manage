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
public class ProductClient {
	private RestTemplate restTemplate;
	public String name = "ProductClient";
	private String host;
	private int port;
	
	private String postfix;
	
	@Autowired
	public ProductClient(
	@Value("${service.product.host:localhost}")					String host, 
	@Value("${service.product.port:8080}")						int port,
	@Value("${service.product.postfix:/ms_manage-products}") 	String postfix) {
		super();
		this.restTemplate = new RestTemplate();
		this.host = host;
		this.port = port;
		this.postfix = postfix;
	}
	
	public String getURL(){
		return "http://"+this.host+":"+this.port+this.postfix+"/products/";
	}
	
	public List<Product> getAllProducts(){
		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(getURL(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>(){});
		return responseEntity.getBody();
	}
	
	public Product getProduct(int id){
		Product p = restTemplate.getForObject(getURL()+id, Product.class);
		return p;
	}
}
