package com.ms_manage.invoice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoice_entry")
public class InvoiceEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="Anzahl")
	private int count;
	@Column(name="Produkt_ID")
	private int productId;
	@JoinColumn(name = "Assigned_Invoice")
	@ManyToOne(cascade=CascadeType.REMOVE)
	private Invoice invoice;

	public InvoiceEntry(){
		//this.invoice = new Invoice();
	}
	
	public InvoiceEntry(int count, int productId) {
		super();
		this.count = count;
		this.productId = productId;
	}
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
}
