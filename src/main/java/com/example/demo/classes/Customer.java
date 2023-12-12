package com.example.demo.classes;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
   int id;
   String name;
   String email;
   String passward;
   String location;
   @OneToMany
   List<Suppliers> suppliers;
   
   String contactperson;
   String mobile;
   
   @OneToMany
   List<PDIInspection> pdiinpeInspection;

public Customer(int id, String name, String email, String passward, String location, List<Suppliers> suppliers,
		String contactperson, String mobile, List<PDIInspection> pdiinpeInspection) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.passward = passward;
	this.location = location;
	this.suppliers = suppliers;
	this.contactperson = contactperson;
	this.mobile = mobile;
	this.pdiinpeInspection = pdiinpeInspection;
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

public List<Suppliers> getSuppliers() {
	return suppliers;
}

public void setSuppliers(List<Suppliers> suppliers) {
	this.suppliers = suppliers;
}

public String getContactperson() {
	return contactperson;
}

public void setContactperson(String contactperson) {
	this.contactperson = contactperson;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public List<PDIInspection> getPdiinpeInspection() {
	return pdiinpeInspection;
}

public void setPdiinpeInspection(List<PDIInspection> pdiinpeInspection) {
	this.pdiinpeInspection = pdiinpeInspection;
}

@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", passward=" + passward + ", location="
			+ location + ", suppliers=" + suppliers + ", contactperson=" + contactperson + ", mobile=" + mobile
			+ ", pdiinpeInspection=" + pdiinpeInspection + "]";
}

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}

}
