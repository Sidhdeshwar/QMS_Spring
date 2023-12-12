package com.example.demo.classes;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Departments
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
   int id;
   String name;
   
   @ManyToMany (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
   List<Suppliers> supplier;

public Departments(int id, String name, List<Suppliers> supplier) {
	super();
	this.id = id;
	this.name = name;
	this.supplier = supplier;
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

public List<Suppliers> getSupplier() {
	return supplier;
}

public void setSupplier(List<Suppliers> supplier) {
	this.supplier = supplier;
}

@Override
public String toString() {
	return "Departments [id=" + id + ", name=" + name + ", supplier=" + supplier + "]";
}

public Departments() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
   
}
