package com.ms_manage.invoice.dao;

import org.springframework.data.repository.CrudRepository;

import com.ms_manage.invoice.model.Invoice;

public interface InvoiceMySqlCrudDao extends CrudRepository<Invoice, Integer> {

}
