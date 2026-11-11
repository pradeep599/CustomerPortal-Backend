package com.vcube.Customerportal.service;

import java.util.List;

import com.vcube.Customerportal.model.Customer;

public interface CustomerService {
	
	Customer createCustomerData(Customer c);
	
	List<Customer>getAllCustomerInfo();
	
	Customer getCustomer(Integer id);
	
	void deleteCustomer(Integer id);

	Customer updateData(Customer c, Integer id);
}
