package com.ms_manage.products.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms_manage.products.model.Product;
import com.ms_manage.products.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product getCustomer(@PathVariable("id") int id){
		return productService.getProduct(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public void insertCustomer (@RequestBody Product p){
		productService.insertProduct(p);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeCustomer (@PathVariable("id") int id){
		productService.removeProduct(id);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public void updateCustomer (@RequestBody Product p){
		productService.updateProduct(p);
	}
}
