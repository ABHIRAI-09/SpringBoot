package com.example.demo.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerBean {

	@NotEmpty(message = "Username cant be empty")
	String Id;
	String name;
	String companyName;
	public String getId() {
		return Id;
	}
	public void setId(String string) {
		Id = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "CustomerBean [Id=" + Id + ", name=" + name + ", companyName=" + companyName + "]";
	}
	
}
