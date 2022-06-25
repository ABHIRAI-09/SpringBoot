package com.example.demo.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CustomerDetails {
	
	@Min(3)
	@NotNull
	String id;
	
	String name;
	
	String company;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
	

}
