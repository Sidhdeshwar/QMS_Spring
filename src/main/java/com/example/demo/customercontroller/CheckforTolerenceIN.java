package com.example.demo.customercontroller;

public class CheckforTolerenceIN 
{
  int id;
  String name;
  double l;
  double b;
  double t;
  int sup_id;
  int customer_id;
  int products_id;
  
public CheckforTolerenceIN(int id, String name, double l, double b, double t, int sup_id, int customer_id,
		int products_id) {
	super();
	this.id = id;
	this.name = name;
	this.l = l;
	this.b = b;
	this.t = t;
	this.sup_id = sup_id;
	this.customer_id = customer_id;
	this.products_id = products_id;
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
public double getL() {
	return l;
}
public void setL(double l) {
	this.l = l;
}
public double getB() {
	return b;
}
public void setB(double b) {
	this.b = b;
}
public double getT() {
	return t;
}
public void setT(double t) {
	this.t = t;
}
public int getSup_id() {
	return sup_id;
}
public void setSup_id(int sup_id) {
	this.sup_id = sup_id;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public int getProducts_id() {
	return products_id;
}
public void setProducts_id(int products_id) {
	this.products_id = products_id;
}
@Override
public String toString() {
	return "CheckforTolerenceIN [id=" + id + ", name=" + name + ", l=" + l + ", b=" + b + ", t=" + t + ", sup_id="
			+ sup_id + ", customer_id=" + customer_id + ", products_id=" + products_id + "]";
}
public CheckforTolerenceIN() {
	super();
	// TODO Auto-generated constructor stub
}
  
 
  
}
