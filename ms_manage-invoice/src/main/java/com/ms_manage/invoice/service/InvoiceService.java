package com.ms_manage.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_manage.invoice.dao.InvoiceMySqlCrudDao;
import com.ms_manage.invoice.model.CustomerClient;
import com.ms_manage.invoice.model.Invoice;
import com.ms_manage.invoice.model.InvoiceEntry;
import com.ms_manage.invoice.model.ProductClient;

@Service
public class InvoiceService {
	private InvoiceMySqlCrudDao mySqlCrudDao;
	
	@SuppressWarnings("unused")
	private CustomerClient customerClient;
	@SuppressWarnings("unused")
	private ProductClient productClient;
	
	@Autowired
	public InvoiceService(InvoiceMySqlCrudDao mySqlCrudDao, CustomerClient customerClient,
			ProductClient productClient) {
		super();
		this.mySqlCrudDao = mySqlCrudDao;
		this.customerClient = customerClient;
		this.productClient = productClient;
	}
	
	public Invoice saveInvoice(Invoice inv){
		List<InvoiceEntry> il = inv.getInvoiceEntries();
		for (InvoiceEntry ie : il){
			ie.setInvoice(inv);
		}
		return mySqlCrudDao.save(inv);
	}
	
	public Invoice getInvoice(int id){
		return mySqlCrudDao.findOne(id);
	}
	
	public List<Invoice> getAllInvoices(){
		return (List<Invoice>) mySqlCrudDao.findAll();
	}
}
