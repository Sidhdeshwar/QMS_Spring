package com.example.demo.classes;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Suppliers
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
  int id;
  String name;
  String email;
  String passward;
  String location;
  
  @OneToMany
  List<Products> products;

  
  
public Suppliers(int id, String name, String email, String passward, String location, List<Products> products) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.passward = passward;
	this.location = location;
	this.products = products;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassward() {
	return passward;
}

public void setPassward(String passward) {
	this.passward = passward;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public List<Products> getProducts() {
	return products;
}

public void setProducts(List<Products> products) {
	this.products = products;
}

@Override
public String toString() {
	return "Suppliers [id=" + id + ", name=" + name + ", email=" + email + ", passward=" + passward + ", location="
			+ location + ", products=" + products + "]";
}

public Suppliers() {
	super();
	// TODO Auto-generated constructor stub
}
  
  
  
  
}
