package com.ms_manage.invoice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="Kunde_ID")
	private int customerId;
	
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.PERSIST, orphanRemoval=true)
	private List<InvoiceEntry> invoiceEntries;

	public Invoice() {
		super();
		this.invoiceEntries = new ArrayList<InvoiceEntry>();
	}
	
	
	public List<InvoiceEntry> getInvoiceEntries() {
		return invoiceEntries;
	}
	public void setInvoiceEntries(List<InvoiceEntry> invoiceEntries) {
		this.invoiceEntries = invoiceEntries;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Transient
	public int getNumberOfEntries(){
		return invoiceEntries.size();
	}
	
	public void addEntry(int cnt, int pId){
		InvoiceEntry ie = new InvoiceEntry(cnt, pId);
		ie.setInvoice(this);
		this.invoiceEntries.add(ie);
	}
}
