package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customerInfo")
public class CustomerInfo {

	@Id
	@NotEmpty(message = "Username cant be empty")
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
		return "CustomerInfo [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
}
