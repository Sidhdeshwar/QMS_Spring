package com.example.demo.classes;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Employees
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
  int id;
  String name;
  String designation;
  String mobile;

  @ManyToOne
  Departments department;
  
  @ManyToMany
  List<Products> products;
  
  @ManyToOne
  Suppliers suppliers;

public Employees(int id, String name, String designation, String mobile, Departments department,
		List<Products> products, Suppliers suppliers) {
	super();
	this.id = id;
	this.name = name;
	this.designation = designation;
	this.mobile = mobile;
	this.department = department;
	this.products = products;
	this.suppliers = suppliers;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public Departments getDepartment() {
	return department;
}

public void setDepartment(Departments department) {
	this.department = department;
}

public List<Products> getProducts() {
	return products;
}

public void setProducts(List<Products> products) {
	this.products = products;
}

public Suppliers getSuppliers() {
	return suppliers;
}

public void setSuppliers(Suppliers suppliers) {
	this.suppliers = suppliers;
}

@Override
public String toString() {
	return "Employees [id=" + id + ", name=" + name + ", designation=" + designation + ", mobile=" + mobile
			+ ", department=" + department + ", products=" + products + ", suppliers=" + suppliers + "]";
}

public Employees() {
	super();
	// TODO Auto-generated constructor stub
}
  

}
