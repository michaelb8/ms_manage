package com.ms_manage.products.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

import com.ms_manage.products.model.Product;
@Qualifier("mysql")
public interface ProductMySqlCrudDao extends CrudRepository<Product, Integer>{

}
