package com.ms_manage.products.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ms_manage.products.dao.ProductMySqlCrudDao;
import com.ms_manage.products.model.Product;

@Service
public class ProductService {
	@Autowired
	@Qualifier("mysql")
	private ProductMySqlCrudDao productDao;
	
	public List<Product> getAllProducts(){
		List<Product> prods = new ArrayList<Product>();
		for(Product p : productDao.findAll()){
			prods.add(p);
		}
		return prods;
	}
	
	public Product getProduct (int id){
		return this.productDao.findOne(id);
	}
	
	public void removeProduct (int id){
		this.productDao.delete(id);;
	}
	
	public void updateProduct (Product p){
		this.productDao.save(p);
	}
	
	public void insertProduct (Product p){
		this.productDao.save(p);
	}
}
