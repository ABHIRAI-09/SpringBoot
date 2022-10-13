package com.example.demo.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.example.demo.exception.UserNotFoundInDB;
import com.example.demo.service.CustomerService;

@RestController
@Validated
public class MainController {
	
	@Autowired
	CustomerService customerService;
	@ResponseBody
	@GetMapping("/")
	public ResponseEntity<String> start( ) {
		
		return new ResponseEntity<>("Let's Start", HttpStatus.OK);
	}
	@ResponseBody
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome( ) {
		
		return new ResponseEntity<>("Welcome to my website", HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('NORMAL')")
	@ResponseBody
	@GetMapping("/public")
	public ResponseEntity<String> normal( ) {
		
		return new ResponseEntity<>("Hello, this is for NORMAL role ", HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	@GetMapping("/private")
	public ResponseEntity<String> admin( ) {
		
		return new ResponseEntity<>("Hello, this is for ADMIN role", HttpStatus.OK);
	}
	@ResponseBody
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<CustomerBean>  getCustomers( @PathVariable String customerId) throws UserNotFoundInDB {
		
		return new ResponseEntity<>(customerService.service(customerId), HttpStatus.OK);
	}
	
	
	@ResponseBody
	@PostMapping("/customers")
	public ResponseEntity<CustomerInfo>  posCustomers( @RequestBody @Valid CustomerDetails customerDetails) {
		CustomerBean customerBean= new CustomerBean();
		customerBean.setId(customerDetails.getId());
		customerBean.setName(customerDetails.getName());
		customerBean.setCompanyName(customerDetails.getCompany());
		System.out.println(customerBean.toString());
		return new ResponseEntity<>(customerService.postService(customerBean),HttpStatus.CREATED);
		//return customerService.service(customerBean);
	}

}
