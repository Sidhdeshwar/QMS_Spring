package com.example.demo.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Tolerence
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int id;
	String name;
	double lu;
	double ll;
	double bu;
	double bl;
	double tu;
	double tl;
	
	@OneToOne
	Suppliers sup;
	
	@OneToOne
	Customer customer;

	@OneToOne
	Products product;

	public Tolerence(int id, String name, double lu, double ll, double bu, double bl, double tu, double tl,
			Suppliers sup, Customer customer, Products product) {
		super();
		this.id = id;
		this.name = name;
		this.lu = lu;
		this.ll = ll;
		this.bu = bu;
		this.bl = bl;
		this.tu = tu;
		this.tl = tl;
		this.sup = sup;
		this.customer = customer;
		this.product = product;
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

	public double getLu() {
		return lu;
	}

	public void setLu(double lu) {
		this.lu = lu;
	}

	public double getLl() {
		return ll;
	}

	public void setLl(double ll) {
		this.ll = ll;
	}

	public double getBu() {
		return bu;
	}

	public void setBu(double bu) {
		this.bu = bu;
	}

	public double getBl() {
		return bl;
	}

	public void setBl(double bl) {
		this.bl = bl;
	}

	public double getTu() {
		return tu;
	}

	public void setTu(double tu) {
		this.tu = tu;
	}

	public double getTl() {
		return tl;
	}

	public void setTl(double tl) {
		this.tl = tl;
	}

	public Suppliers getSup() {
		return sup;
	}

	public void setSup(Suppliers sup) {
		this.sup = sup;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Tolerence [id=" + id + ", name=" + name + ", lu=" + lu + ", ll=" + ll + ", bu=" + bu + ", bl=" + bl
				+ ", tu=" + tu + ", tl=" + tl + ", sup=" + sup + ", customer=" + customer + ", product=" + product
				+ "]";
	}

	public Tolerence() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
