package com.ms_manage.invoice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.client.RestTemplate;
//
//import com.ms_manage.invoice.model.Customer;
//import com.ms_manage.invoice.model.CustomerClient;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
public class InvoiceMain extends SpringBootServletInitializer {

	public InvoiceMain() {
	    super();
	    setRegisterErrorPageFilter(false); // <- this one
	}
	
	private static final Logger log = LoggerFactory.getLogger(InvoiceMain.class);
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(InvoiceMain.class);
    }
	
	public static void main(String[] args) {
//		RestTemplate restTemplate = new RestTemplate();
//		Customer c1 = restTemplate.getForObject("http://localhost:8000/ms_manage-customer/customers/22", Customer.class);
//        
//		CustomerClient cc = new CustomerClient("localhost", 8000, "/ms_manage-customer");
//		List<Customer> cl = cc.getAllCustomers();
//		
//		for (Customer ci : cl){
//			log.info(ci.toString());
//		}
//		Customer c2 = cc.getCustomer(21);
//		
//		log.info(c1.toString());
//		log.info(c2.toString());
//		ProductClient cc = new ProductClient("localhost", 8000, "/ms_manage-products");
//		List<Customer> cl = cc.getAllCustomers();
//		
//		for (Customer ci : cl){
//			log.info(ci.toString());
//		}
		
		SpringApplication.run(InvoiceMain.class, args);
		
		
	}

}
