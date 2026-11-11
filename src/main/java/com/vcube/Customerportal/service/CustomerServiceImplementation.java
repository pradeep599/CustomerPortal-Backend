package com.vcube.Customerportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;

import com.vcube.Customerportal.model.Customer;
import com.vcube.Customerportal.repo.CustomerRepo;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Override
	public Customer createCustomerData(Customer c) {
		return customerRepo.save(c);
	}

	@Override
	public List<Customer> getAllCustomerInfo() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomer(Integer id) {
		return customerRepo.findById(id).get();
	}

	@Override
	public Customer updateData(Customer c, Integer id) {
		Customer customerFromDB = getCustomer(id);
		customerFromDB.setCname(c.getCname());
		customerFromDB.setCity(c.getCity());
		customerFromDB.setAge(c.getAge());
		customerFromDB.setPhone(c.getPhone());
		customerFromDB.setEmail(c.getEmail());

		return customerRepo.save(customerFromDB);
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerRepo.deleteById(id);
	}

}
