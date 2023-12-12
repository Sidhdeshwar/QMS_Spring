package com.example.demo.classes;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Concern 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
  int id;
  String date;
  String problem;
  String problemstatus;
  int affectqty;
  String level;
  String actionplan;
  String audit;
  String auditstatus;
  String meeting;
  String meetingstatus;
  
  @OneToOne
  Products product;
  
  @ManyToOne
  Suppliers supplier;
  
  @ManyToOne
  Customer customer;

public Concern(int id, String date, String problem, String problemstatus, int affectqty, String level,
		String actionplan, String audit, String auditstatus, String meeting, String meetingstatus, Products product,
		Suppliers supplier, Customer customer) {
	super();
	this.id = id;
	this.date = date;
	this.problem = problem;
	this.problemstatus = problemstatus;
	this.affectqty = affectqty;
	this.level = level;
	this.actionplan = actionplan;
	this.audit = audit;
	this.auditstatus = auditstatus;
	this.meeting = meeting;
	this.meetingstatus = meetingstatus;
	this.product = product;
	this.supplier = supplier;
	this.customer = customer;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getProblem() {
	return problem;
}

public void setProblem(String problem) {
	this.problem = problem;
}

public String getProblemstatus() {
	return problemstatus;
}

public void setProblemstatus(String problemstatus) {
	this.problemstatus = problemstatus;
}

public int getAffectqty() {
	return affectqty;
}

public void setAffectqty(int affectqty) {
	this.affectqty = affectqty;
}

public String getLevel() {
	return level;
}

public void setLevel(String level) {
	this.level = level;
}

public String getActionplan() {
	return actionplan;
}

public void setActionplan(String actionplan) {
	this.actionplan = actionplan;
}

public String getAudit() {
	return audit;
}

public void setAudit(String audit) {
	this.audit = audit;
}

public String getAuditstatus() {
	return auditstatus;
}

public void setAuditstatus(String auditstatus) {
	this.auditstatus = auditstatus;
}

public String getMeeting() {
	return meeting;
}

public void setMeeting(String meeting) {
	this.meeting = meeting;
}

public String getMeetingstatus() {
	return meetingstatus;
}

public void setMeetingstatus(String meetingstatus) {
	this.meetingstatus = meetingstatus;
}

public Products getProduct() {
	return product;
}

public void setProduct(Products product) {
	this.product = product;
}

public Suppliers getSupplier() {
	return supplier;
}

public void setSupplier(Suppliers supplier) {
	this.supplier = supplier;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

@Override
public String toString() {
	return "Concern [id=" + id + ", date=" + date + ", problem=" + problem + ", problemstatus=" + problemstatus
			+ ", affectqty=" + affectqty + ", level=" + level + ", actionplan=" + actionplan + ", audit=" + audit
			+ ", auditstatus=" + auditstatus + ", meeting=" + meeting + ", meetingstatus=" + meetingstatus
			+ ", product=" + product + ", supplier=" + supplier + ", customer=" + customer + "]";
}

public Concern() {
	super();
	// TODO Auto-generated constructor stub
}


}
