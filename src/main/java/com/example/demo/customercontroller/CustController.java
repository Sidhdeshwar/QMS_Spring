package com.example.demo.customercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.classes.Concern;
import com.example.demo.classes.Customer;
import com.example.demo.classes.PDIInspection;
import com.example.demo.classes.Products;
import com.example.demo.classes.Suppliers;
import com.example.demo.classes.Tolerence;
import com.example.demo.custSubRepo.SubCustomer;
import com.example.demo.customerDATA.SubCustomerList;
import com.example.demo.repo.ConcernRepo;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.PDIInspectionRepo;
import com.example.demo.repo.ProductsRepo;
import com.example.demo.repo.SupplierRepo;
import com.example.demo.repo.sub_interfaces.SubConcern;
import com.example.demo.repo.sub_interfaces.SubPDIRepo;
import com.example.demo.repo.TolerenceRepo;

@RestController
@CrossOrigin
public class CustController 
{
	@Autowired
  CustomerRepo customerRepo;
	
	@Autowired
	PDIInspectionRepo pdiInspectionRepo;
	
	@Autowired
	TolerenceRepo tolerenceRepo;
	
	@Autowired
	ConcernRepo concernRepo;
	
	@Autowired
	SupplierRepo supplierRepo;
  
	@Autowired
	ProductsRepo productsRepo;
  
	@RequestMapping("customerlogin/{email}/{password}")
	public SubCustomer  customerlogin(@PathVariable String email, String password)
	{
		System.out.println(email +" "+ password);
		if(customerRepo.countByEmail(email)!=1)
			return null;
		/*else if(!password.equals(customerRepo.findByPassward(password).getPassward()))
			return -2;*/
		else 
			return  customerRepo.findTheCustomerByEmail(email);
	}
	
	
//	  @RequestMapping("getCustomerObject/{email}") 
//	  public List<SubCustomer> getCustomerObject(@PathVariable String email)
//	  {
//	  	return customerRepo.findTheCustomerByEmail(email);
//	  }
  
	  @RequestMapping("getAllPDIfromSuppliers/{cust_id}")
  public List<SubPDIRepo> getAllPDIfromSuppliers(@PathVariable int cust_id)
  {
	 return pdiInspectionRepo.getPDIrecievedFromSuppliers(cust_id);
  }
  
  @RequestMapping("getAllSubCustomer/{sup_id}") 
  public List<SubCustomerList> getAllSubCustomer(@PathVariable int sup_id)
  {
  	return customerRepo.getAllSubCustomersBySupplierId(sup_id);
  }
  
  // For Checking Tolerence;
  @RequestMapping("checkSizeUnderTolerence")
  public int checkSizeUnderTolerence(@RequestBody CheckforTolerenceIN tol)
  {
	  List<Tolerence> list =  tolerenceRepo.findAll();
	  System.out.println("SSSSSSSSSSSSSS OBJECT ALLA CHECKING SATHI");
	  System.out.println(tol.id);
	  System.out.println(tol.name);
	  System.out.println(tol.l);
	  System.out.println(tol.b);
	  System.out.println(tol.t);
	  System.out.println(tol.sup_id);
	  System.out.println(tol.customer_id);
	  System.out.println(tol.products_id);
	  
	   int cnt=1;
	  for(int i=0 ; i<list.size() ; i++)
	  {  
		  System.out.println(list.get(i).getProduct().getName() + " Check ProdId "+ tol.name);
		  if(list.get(i).getProduct().getName().equals(tol.name))
		  {   System.out.println(" CHECKING CHALU AAHE...................");
			  if((tol.l>=list.get(i).getLl() && tol.l<=list.get(i).getLu()))
			  {
				  System.out.println("CHECKING DONE...........Acceptable");
				  cnt++;
			  }
			  else
			  {
				  return cnt;
			  }
			 if(tol.b>=list.get(i).getBl() && tol.b<=list.get(i).getBu())
			  {
				  cnt++;
			  }
			 else
			 {
				 return cnt;
			 }
			  
			 if(tol.t>=list.get(i).getTl() && tol.t<=list.get(i).getTu())
			  {
				  cnt++;
			  }
			 else
			 {
				 return cnt;
			 }
			 if(cnt==4)
			 {
				 return 100;
			 }
			 
		  }
	  }
	  System.out.println("CHECKING DONE...........NotAcceptable.........END");
	  return 0;
  }
  
  @RequestMapping("applyAcceptRejecttoSupplier/{status}/{id}")
  public boolean applyAcceptRejecttoSupplier(@PathVariable String status,@PathVariable int id)
  {
	  try {
	   PDIInspection updateStatus = pdiInspectionRepo.findById(id).get();
	   updateStatus.setStatus(status);
	   pdiInspectionRepo.save(updateStatus);
	   return true;
	  }
	  catch (Exception e) {
		// TODO: handle exception
		  return false;
	}
	  
  }
  
  //Concern Management..........................................
  
  @RequestMapping("getAllConcernsByCustomer_ID/{cust_id}")
  public List<SubConcern> getAllConcernsByCustomer_ID(@PathVariable int cust_id)
  {
	 return concernRepo.findtheAllComplaint(cust_id);
  }
  
  @RequestMapping("saveTheNewComplaint/{cust_id}/{sup_name}/{product_name}")
  public List<SubConcern>  saveTheNewComplaint(@RequestBody Concern con, @PathVariable int cust_id,@PathVariable String sup_name, @PathVariable String product_name)
  {
	  System.out.println(sup_name+"HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
	  
	  System.out.println("Add Customer Complent 1.................");
	Customer customer=  customerRepo.findById(cust_id).get();
	  con.setCustomer(customer);
	  System.out.println("Add Customer Complent 2.................");
	Suppliers suppliers =  supplierRepo.findByName(sup_name);
	con.setSupplier(suppliers);
	  System.out.println("Add Customer Complent 3................."+product_name );
	  
	  Products product = productsRepo.findByName(product_name);
	  con.setProduct(product);
	  
	  concernRepo.save(con);
	  return concernRepo.getAllConcernsByCustomer_ID(cust_id);
  }
  
  // Schedule New Audit 
  
  @RequestMapping("scheduleNewAudit/{cust_id}/{sup_name}")
  public List<SubConcern> scheduleNewAudit(@RequestBody Concern concern, @PathVariable int cust_id,@PathVariable String sup_name)
  {
	  System.out.println("Schedule Schedule Schedule Schedule Schedule.................");
		Customer customer=  customerRepo.findById(cust_id).get();
		concern.setCustomer(customer);
		  System.out.println("Add Customer Complent 2.................");
		Suppliers suppliers =  supplierRepo.findByName(sup_name);
		concern.setSupplier(suppliers);
		  System.out.println("Add Customer Complent 3.................");
		  
		  Products product = productsRepo.findByName("Boxer Main Tube");
		  concern.setProduct(product);
	  
	  concernRepo.save(concern);
	  return concernRepo.getAllConcernsByCustomer_ID(cust_id);
  }
  
  // For Edit the Audit status
  
  @RequestMapping("saveTheNewAuditUpdate/{cust_id}/{sup_name}")
  public List<SubConcern> saveTheNewAuditUpdate(@RequestBody Concern concern, @PathVariable int cust_id,@PathVariable String sup_name)
  {
	  System.out.println("Add Customer Complent 1...........");
		Customer customer=  customerRepo.findById(cust_id).get();
		concern.setCustomer(customer);
		  System.out.println("Add Customer Complent 2.................");
		Suppliers suppliers =  supplierRepo.findByName(sup_name);
		concern.setSupplier(suppliers);
		  System.out.println("Add Customer Complent 3.................");
		  
		  Products product = productsRepo.findByName("Boxer Main Tube");
		  concern.setProduct(product);
	  
	  concernRepo.save(concern);
	  return concernRepo.getAllConcernsByCustomer_ID(cust_id);
  }
  
  
  
  // For Supploer Action Plan
  
  @RequestMapping("saveTheNewComplaintUpdate/{sup_id}")
  public List<SubConcern>  saveTheNewComplaintUpdate(@RequestBody Concern con, @PathVariable int sup_id)
  {
	  concernRepo.save(con);
	  return concernRepo.getAllConcernsByCustomer_ID(sup_id);
  }
  
  
  @RequestMapping("AllCustomerCompalints/{id}")
  public List<SubConcern> AllCustomerCompalints(@PathVariable int id)
  {
	 return concernRepo.findtheAllComplaint(id);
  }
  
  @RequestMapping("deleteConcernByID/{con_id}")
  public boolean deleteConcernByID(@PathVariable int con_id)
  {
	  try
	  {
	  concernRepo.deleteById(con_id);
	  
	  return true;
	  }
	  catch (Exception e) {
		// TODO: handle exception
		  return false;
	}
	  
  }
  
  

  
}
