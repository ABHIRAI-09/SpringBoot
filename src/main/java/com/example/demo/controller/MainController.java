package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.CustomerBean;
import com.example.demo.bean.CustomerDetails;
import com.example.demo.data.CustomerInfo;
import com.example.demo.service.CustomerService;

@RestController
@Validated
public class MainController {
	
	@Autowired
	CustomerService customerService;
	@ResponseBody
	@GetMapping("/welcome")
	public String welcome( ) {
		
		return "Welcome\n first page";
	}
	@ResponseBody
	@GetMapping("/customers/{customerId}")
	public CustomerBean  getCustomers( @PathVariable String customerId) {
		
		return customerService.service(customerId);
	}
	
	
	@ResponseBody
	@PostMapping("/customers")
	public CustomerInfo  posCustomers( @RequestBody CustomerDetails customerDetails) {
		CustomerBean customerBean= new CustomerBean();
		customerBean.setId(customerDetails.getId());
		customerBean.setName(customerDetails.getName());
		customerBean.setCompanyName(customerDetails.getCompany());
		System.out.println(customerBean.toString());
		return customerService.postService(customerBean);
		//return customerService.service(customerBean);
	}

}
