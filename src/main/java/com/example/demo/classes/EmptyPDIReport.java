package com.example.demo.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmptyPDIReport 
{
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
   int id;
   String parameters;
   String inspectiontype;
   String ltl;
   String  utl;
   String  value1;
   String  value2;
   String  value3;
   String  value4;
   String  value5;
   
   
   
public EmptyPDIReport(int id, String parameters, String inspectiontype, String ltl, String utl, String value1,
		String value2, String value3, String value4, String value5) {
	super();
	this.id = id;
	this.parameters = parameters;
	this.inspectiontype = inspectiontype;
	this.ltl = ltl;
	this.utl = utl;
	this.value1 = value1;
	this.value2 = value2;
	this.value3 = value3;
	this.value4 = value4;
	this.value5 = value5;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getParameters() {
	return parameters;
}
public void setParameters(String parameters) {
	this.parameters = parameters;
}
public String getInspectiontype() {
	return inspectiontype;
}
public void setInspectiontype(String inspectiontype) {
	this.inspectiontype = inspectiontype;
}
public String getLtl() {
	return ltl;
}
public void setLtl(String ltl) {
	this.ltl = ltl;
}
public String getUtl() {
	return utl;
}
public void setUtl(String utl) {
	this.utl = utl;
}
public String getValue1() {
	return value1;
}
public void setValue1(String value1) {
	this.value1 = value1;
}
public String getValue2() {
	return value2;
}
public void setValue2(String value2) {
	this.value2 = value2;
}
public String getValue3() {
	return value3;
}
public void setValue3(String value3) {
	this.value3 = value3;
}
public String getValue4() {
	return value4;
}
public void setValue4(String value4) {
	this.value4 = value4;
}
public String getValue5() {
	return value5;
}
public void setValue5(String value5) {
	this.value5 = value5;
}
@Override
public String toString() {
	return "EmptyPDIReport [id=" + id + ", parameters=" + parameters + ", inspectiontype=" + inspectiontype + ", ltl="
			+ ltl + ", utl=" + utl + ", value1=" + value1 + ", value2=" + value2 + ", value3=" + value3 + ", value4="
			+ value4 + ", value5=" + value5 + "]";
}
public EmptyPDIReport() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
   
   
   
   
   
   

   
   
}
