package com.example.demo.classes;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Products
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
  int id;
  String name;
  String model;
  double l;
  double b;
  double t;
  
  @ManyToMany
  List<Departments> departments;

public Products(int id, String name, String model, double l, double b, double t, List<Departments> departments) {
	super();
	this.id = id;
	this.name = name;
	this.model = model;
	this.l = l;
	this.b = b;
	this.t = t;
	this.departments = departments;
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

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
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

public List<Departments> getDepartments() {
	return departments;
}

public void setDepartments(List<Departments> departments) {
	this.departments = departments;
}

@Override
public String toString() {
	return "Products [id=" + id + ", name=" + name + ", model=" + model + ", l=" + l + ", b=" + b + ", t=" + t
			+ ", departments=" + departments + "]";
}

public Products() {
	super();
	// TODO Auto-generated constructor stub
}
  
}
