package com.example.demo.bean;



public class CustomerBean {

	
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
