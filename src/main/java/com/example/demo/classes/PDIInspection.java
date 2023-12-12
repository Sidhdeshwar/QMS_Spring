package com.example.demo.classes;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class PDIInspection 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
  int id;

  String date;
  String shift;
  String inspectionstage;
  String inpectiontype;
  String burrsharpedge;
  String dentrust;
  double lupper;
  double bupper;
  double tupper;
  double llower;
  double blower;
  double tlower;
  double l;
  double b;
  double t;
  String status;
  
  @OneToOne
  Products products;
  
  @OneToOne
  Suppliers suppliers;
  
  @ManyToOne
  Customer customer;

public PDIInspection(int id, Products products, String date, String shift, String inspectionstage, String inpectiontype,
		String burrsharpedge, String dentrust, double lupper, double bupper, double tupper, double llower,
		double blower, double tlower, double l, double b, double t, String status, Suppliers suppliers,
		Customer customer) {
	super();
	this.id = id;
	this.products = products;
	this.date = date;
	this.shift = shift;
	this.inspectionstage = inspectionstage;
	this.inpectiontype = inpectiontype;
	this.burrsharpedge = burrsharpedge;
	this.dentrust = dentrust;
	this.lupper = lupper;
	this.bupper = bupper;
	this.tupper = tupper;
	this.llower = llower;
	this.blower = blower;
	this.tlower = tlower;
	this.l = l;
	this.b = b;
	this.t = t;
	this.status = status;
	this.suppliers = suppliers;
	this.customer = customer;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Products getProducts() {
	return products;
}

public void setProducts(Products products) {
	this.products = products;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getShift() {
	return shift;
}

public void setShift(String shift) {
	this.shift = shift;
}

public String getInspectionstage() {
	return inspectionstage;
}

public void setInspectionstage(String inspectionstage) {
	this.inspectionstage = inspectionstage;
}

public String getInpectiontype() {
	return inpectiontype;
}

public void setInpectiontype(String inpectiontype) {
	this.inpectiontype = inpectiontype;
}

public String getBurrsharpedge() {
	return burrsharpedge;
}

public void setBurrsharpedge(String burrsharpedge) {
	this.burrsharpedge = burrsharpedge;
}

public String getDentrust() {
	return dentrust;
}

public void setDentrust(String dentrust) {
	this.dentrust = dentrust;
}

public double getLupper() {
	return lupper;
}

public void setLupper(double lupper) {
	this.lupper = lupper;
}

public double getBupper() {
	return bupper;
}

public void setBupper(double bupper) {
	this.bupper = bupper;
}

public double getTupper() {
	return tupper;
}

public void setTupper(double tupper) {
	this.tupper = tupper;
}

public double getLlower() {
	return llower;
}

public void setLlower(double llower) {
	this.llower = llower;
}

public double getBlower() {
	return blower;
}

public void setBlower(double blower) {
	this.blower = blower;
}

public double getTlower() {
	return tlower;
}

public void setTlower(double tlower) {
	this.tlower = tlower;
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

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Suppliers getSuppliers() {
	return suppliers;
}

public void setSuppliers(Suppliers suppliers) {
	this.suppliers = suppliers;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

@Override
public String toString() {
	return "PDIInspection [id=" + id + ", products=" + products + ", date=" + date + ", shift=" + shift
			+ ", inspectionstage=" + inspectionstage + ", inpectiontype=" + inpectiontype + ", burrsharpedge="
			+ burrsharpedge + ", dentrust=" + dentrust + ", lupper=" + lupper + ", bupper=" + bupper + ", tupper="
			+ tupper + ", llower=" + llower + ", blower=" + blower + ", tlower=" + tlower + ", l=" + l + ", b=" + b
			+ ", t=" + t + ", status=" + status + ", suppliers=" + suppliers + ", customer=" + customer + "]";
}

public PDIInspection() {
	super();
	// TODO Auto-generated constructor stub
}

}
