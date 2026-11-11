package com.vcube.Customerportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.Customerportal.model.Customer;
import com.vcube.Customerportal.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins="http://localhost:3000")
public class CustomerController {

	@Autowired
	CustomerService customerService;

//	http://localhost:7788/customer/wel
	@GetMapping("/wel")
	String welcome() {
		return "Hello, Welcome to Customer Portal";
	}

//	http://localhost:7788/customer/create
	@PostMapping("/create")
	Customer createCustomerInfo(@RequestBody Customer c) {
		return customerService.createCustomerData(c);

	}

	@GetMapping("/getCustomers")
	List<Customer> getAllCustomers() {
		return customerService.getAllCustomerInfo();
	}

	@GetMapping("/getCus/{cid}")
	Customer getCustomer(@PathVariable Integer cid) {
		return customerService.getCustomer(cid);

	}

	// http://localhost:7788/customer/update/1
	@PutMapping("/update/{id}")
	Customer updateCustomer(@RequestBody Customer c, @PathVariable Integer id) {
		return customerService.updateData(c, id);
	}

	@DeleteMapping("/delete/{id}")
	void deleteCustomer(@PathVariable Integer id) {
		customerService.deleteCustomer(id);
	}
}
