package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.CustomerBean;
import com.example.demo.data.CustomerInfo;
import com.example.demo.exception.UserNotFoundInDB;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	public CustomerBean service (String customerId) throws UserNotFoundInDB {
		
		Optional<CustomerInfo> customerInfo=customerRepo.findById(customerId);
		if(customerInfo.isPresent()) {
			CustomerInfo f=customerInfo.get();
			CustomerBean info=new CustomerBean();
			info.setId(f.getId());
			info.setName(f.getName());
			info.setCompanyName(f.getCompany());
			return info;
		}else {
			throw new UserNotFoundInDB("User not found");
		}
	}
	
	public CustomerInfo postService(CustomerBean c) {
		CustomerInfo info=new CustomerInfo();
		info.setId(c.getId());
		info.setName(c.getName());
		info.setCompany(c.getCompanyName());
		return customerRepo.save(info);
		
	}
}
