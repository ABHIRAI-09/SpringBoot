package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class MainController {
	
	@Autowired
	CustomerService customerService;
	@ResponseBody
	@GetMapping("/")
	public ResponseEntity<String> start( ) {
		
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	@ResponseBody
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome( ) {
		
		return new ResponseEntity<>("Welcome\n first page", HttpStatus.OK);
	}
	@ResponseBody
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<CustomerBean>  getCustomers( @PathVariable String customerId) {
		
		return new ResponseEntity<>(customerService.service(customerId), HttpStatus.OK);
	}
	
	
	@ResponseBody
	@PostMapping("/customers")
	public ResponseEntity<CustomerInfo>  posCustomers( @RequestBody CustomerDetails customerDetails) {
		CustomerBean customerBean= new CustomerBean();
		customerBean.setId(customerDetails.getId());
		customerBean.setName(customerDetails.getName());
		customerBean.setCompanyName(customerDetails.getCompany());
		System.out.println(customerBean.toString());
		return new ResponseEntity<>(customerService.postService(customerBean),HttpStatus.OK);
		//return customerService.service(customerBean);
	}

}
