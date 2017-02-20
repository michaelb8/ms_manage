package com.ms_manage.customer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ms_manage.customer.model.Customer;

@Repository
public class CustomerMySQLDao implements ICustomerDao {

	@Autowired
	private static JdbcTemplate jdbcTemplate;
	
	private static class CustomRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        	Customer customer = new Customer();
        	customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("name"));
            return customer;
        }
    }
	
	@Override
	public Collection<Customer> getAllCustomers() {
		final String sql ="SELECT * FROM kunde";
		List<Customer> customers = jdbcTemplate.query(sql, new CustomRowMapper());
		return customers;
	}

	@Override
	public Customer getCustomer(int id) {
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		final String sql = "UPDATE kunde SET name = ? WHERE id = ?";
        final int id = customer.getId();
        final String name = customer.getName();
        jdbcTemplate.update(sql, new Object[]{name, id});

	}

	@Override
	public void removeCustomer(int id) {

	}

	@Override
	public void insertCustomer(Customer customer) {

	}

}
