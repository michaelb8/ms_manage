package com.ms_manage.customer.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

import com.ms_manage.customer.model.Customer;

@Qualifier("mysql")
public interface CustomerMySQLCrudDao extends CrudRepository<Customer, Integer>{

}
