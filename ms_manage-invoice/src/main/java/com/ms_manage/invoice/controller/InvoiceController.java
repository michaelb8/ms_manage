package com.ms_manage.invoice.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ms_manage.invoice.dao.InvoiceMySqlCrudDao;
import com.ms_manage.invoice.model.Customer;
import com.ms_manage.invoice.model.CustomerClient;
import com.ms_manage.invoice.model.Invoice;
import com.ms_manage.invoice.model.Product;
import com.ms_manage.invoice.model.ProductClient;
import com.ms_manage.invoice.service.InvoiceService;

@Controller
public class InvoiceController {

	private InvoiceService invoiceService;
	private CustomerClient customerClient;
	private ProductClient productClient;
	private InvoiceMySqlCrudDao dao;
	
	@Autowired
	public InvoiceController(InvoiceService invoiceService, CustomerClient customerClient, ProductClient productClient,
			InvoiceMySqlCrudDao dao) {
		super();
		this.invoiceService = invoiceService;
		this.customerClient = customerClient;
		this.productClient = productClient;
		this.dao = dao;
	}
	
	@ModelAttribute("customers")
	public Collection<Customer> getAllCustomers(){
		return customerClient.getAllCustomers();
	}

	@ModelAttribute("products")
	public Collection<Product> getAllProducts(){
		return productClient.getAllProducts();
	}

//	@RequestMapping(value ="/", method = RequestMethod.GET)
//	public String handler() {
//	    
//		return "index";
//	}
	
	@RequestMapping("/test")
	public ModelAndView test() {
	    ModelAndView mav = new ModelAndView("test");
	    mav.addObject("message", "message");
	    return mav;
	}
	
	@RequestMapping("/")
	public ModelAndView getAllInvoices(){
		return new ModelAndView("invoicelist","invoices",dao.findAll());
	}
	
	@RequestMapping(value ="/form", method = RequestMethod.GET)
	public ModelAndView createInvoice(){
		return new ModelAndView("invoiceDetail","invoice", new Invoice());
	}
	
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteInvoice(@PathVariable int id){
		dao.delete(id);
		return new ModelAndView("done");
	}
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public ModelAndView removeInvoice(@PathVariable int id){
		dao.delete(id);
		return new ModelAndView("done");
	}
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ModelAndView	getInvoice(@PathVariable int id){
		return new ModelAndView("invoice","invoice",invoiceService.getInvoice(id));
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView addInvoice(Invoice inv){
		invoiceService.saveInvoice(inv);
		return new ModelAndView("done");
	}
	
	@RequestMapping(value = "/line", method = RequestMethod.POST)
	public ModelAndView addLine(Invoice inv) {
		inv.addEntry(1, productClient.getAllProducts().iterator().next().getId());
		return new ModelAndView("invoiceDetail", "invoice", inv);
	}
}
