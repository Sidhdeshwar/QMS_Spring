package com.example.demo.controller;

import java. util.ArrayList;
import java. util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.classes.Customer;
import com.example.demo.classes.Departments;
import com.example.demo.classes.Employees;
import com.example.demo.classes.EmptyPDIReport;
import com.example.demo.classes.PDIInspection;
import com.example.demo.classes.Products;
import com.example.demo.classes.Suppliers;
import com.example.demo.repo.ConcernRepo;
import com.example.demo.repo.CurrentSuppliers;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.DepartmentsRepo;
import com.example.demo.repo.EmployeesRepo;
import com.example.demo.repo.EmptyPDIReportRepo;
import com.example.demo.repo.PDIInspectionRepo;
import com.example.demo.repo.ProductsRepo;
import com.example.demo.repo.SupplierRepo;
import com.example.demo.repo.TolerenceRepo;
import com.example.demo.repo.sub_interfaces.DepartmentNames;
import com.example.demo.repo.sub_interfaces.SubConcern;
import com.example.demo.repo.sub_interfaces.SubEmployeesData;
import com.example.demo.repo.sub_interfaces.SubPDIRepo;
import com.example.demo.repo.sub_interfaces.SubProductsData;
import com.example.demo.repo.sub_interfaces.SubTolerence;
import com.example.demo.repo.sub_interfaces.Top3Users;

@RestController
@CrossOrigin
public class MyController 
{
	// This is myController 2nd Commit
	
	@Autowired
    SupplierRepo supplierRepo;
	@Autowired
	DepartmentsRepo departmentsRepo;

	@Autowired
	PDIInspectionRepo pdiinspectionRepo;
	@Autowired
	ProductsRepo productsRepo;
    @Autowired
    EmptyPDIReportRepo emptyPDIReportRepo;
    
    @Autowired
    EmployeesRepo employeesRepo;
    
    @Autowired
    CustomerRepo customerRepo;
    
    @Autowired
    TolerenceRepo tolerenceRepo;
    
// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    @Autowired
    ConcernRepo concernRepo;
    
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    @RequestMapping("login/{email}/{password}")
    public int login(@PathVariable String email, @PathVariable String password)
    {
    	try
    	{
    		if(supplierRepo.countByEmail(email)!=1)
    			return -1;
    		else if(!(password.equals(supplierRepo.findByPassward(password).getPassward())))
    		{ 
    			return -2;
    		}
    		else
    			return 1;	
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		return 0;
		}
    }

    @RequestMapping("findUserCurrent/{email}")
    public Suppliers getCurrentSupplier(@PathVariable String email)
    {
    	Suppliers list =  supplierRepo.findByEmail(email);
    	return list;
    }
	//[A]...... MASTER => 2) Employee Details
    @RequestMapping("getAllEmpBYSuppliersId/{sup_id}")
    public List<SubEmployeesData> getAllEmpBYSuppliersId(@PathVariable int sup_id)
    {
    	return employeesRepo.getAllEmployeesBySupplierID(sup_id);
    }
    
    
    // To Add Suppliers And Dep together
    @RequestMapping("assignSupplierIdToDepartment")
    public boolean assignSupplierIdToDepartment()
    {
    	try {
    	List<Suppliers> list = new ArrayList<>();
    	
    	Suppliers sup1 = supplierRepo.findById(1).get();
    	Suppliers sup2 = supplierRepo.findById(2).get();
  
    	list.add(sup1);
    	list.add(sup2);
    	
    	Departments dep = new Departments(7, "Store Dep",list);
        departmentsRepo.save(dep);
        return true;
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		return false;
		}
    }
    
    // =============================================================
    
    // [A] MASTER ......... 3) Departments
    @RequestMapping("getAllDepartmentBySupID/{sup_id}")
    public List<DepartmentNames> getAllDepartmentBySupID(@PathVariable int sup_id)
    {
    	return departmentsRepo.getAllDepartmentNamesBySupplierId(sup_id);
    }
     // [A] MASTER ..........4) Products
    @RequestMapping("getSpecificCOLUMNFromProducts/{sup_id}")
    public List<SubProductsData> getSpecificCOLUMNFromProducts(@PathVariable int sup_id)
    {
    	return productsRepo.getSubProductBySuppliersID(sup_id);
    
    }
    
    
    
 // Add Product Product with Department List;
    @RequestMapping("addProdWithDepartment/{sup_id}")
    public boolean addProdWithDepartment(@PathVariable int sup_id)
    {
    	List<Departments> DepList = new ArrayList<>();
    	//Get all Dep ID by Supplier.......
    	List<Integer> intList = departmentsRepo.findAllDepListBySupId(sup_id);
    	for(int i=0 ; i<intList.size() ; i++)
    	{
    		int a = intList.get(i);
    		Departments dep = departmentsRepo.findById(a).get();
    		DepList.add(dep);
    	}
    	  //Add Dep into Products
    	List<Products>prodList =  productsRepo.findAll();
    	
    	for(int i=0 ; i<prodList.size() ; i++)
    	{
    		Products prod = prodList.get(i);
    	   prod = new Products(prod.getId(), prod.getName(), prod.getModel(), prod.getL(),prod.getB(),prod.getT(), DepList);
    	   prodList.set(i, prod);
    	  Suppliers sup =  supplierRepo.findById(sup_id).get(); // Same time ......
    	  sup.getProducts().add(prod);  // Prod saved in Supplier Class Also
    	  supplierRepo.save(sup);
    	}
        productsRepo.saveAll(prodList);
        return true;
    }
	
    //To get products By Supplier ID;
    
    @RequestMapping("getAllProductsBySupplierId/{sup_id}")
    public List<Products> getAllProductsBySupplierId(@PathVariable int sup_id)
    {
    	List<Integer> prodIdList = supplierRepo.findProdIdBySupplierId(sup_id);
    	List<Products> prodList = new ArrayList<>();
    	
    	for(int i=0 ; i<prodIdList.size() ; i++)
    	{
    	    Products prod1 =productsRepo.findById(prodIdList.get(i)).get();
    	    prodList.add(prod1);
    	}
    	return prodList;
    }
    
    // ==========--------------------------============+++++++++++++++++
   //PPPPPPPPPPPPPPPPPPPPPDDDDDDDDDDDDDDDDDDDDDDDDDDIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
    @RequestMapping("findPDIData/{sup_id}")
    public List<SubPDIRepo> findPDIData(@PathVariable int sup_id )
    {
    	return pdiinspectionRepo.getAllPDIDetailsByProductID(sup_id); //Supplier =PDI
    }
    
 /*  @RequestMapping("SavePDI")
    public boolean addProductToPDI()
    { 
    	
    	Products product = productsRepo.findByName("Boxer Support Tube");
    	
    	
    	Suppliers sup = supplierRepo.findById(1).get();
    	Customer cust = customerRepo.findById(1).get();
    	
    	pdiinspectionRepo.save(pdi);
    	return true;
    }*/
    
    @RequestMapping("sendPDI/{name:[a-zA-Z &+-]*}/{sup_id}/{cust_id}")
    public boolean sendPDI(@RequestBody PDIInspection pdi1, @PathVariable String name, @PathVariable int sup_id, @PathVariable int cust_id)
    { 
    	System.out.println( pdi1 + "Siddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
    	
    	try {
    		
    		System.out.println(name+" "+sup_id+" "+cust_id+ "  ................OBJ ....AAAAAAAAAAAAAAAAAAAAAAA.....ALA");
     	Products product = productsRepo.findByName(name);
    
 	Suppliers sup = supplierRepo.findById(sup_id).get();
	Customer cust = customerRepo.findById(cust_id).get();
	System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
    
      Suppliers setSupp = pdi1.getSuppliers(); 
      setSupp = sup;
      pdi1.setSuppliers(setSupp);              // Supplier Set
      System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
      Customer setCust = pdi1.getCustomer();
      setCust = cust;
      pdi1.setCustomer(setCust);              // Customer Set
      System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
      
      Products prod = pdi1.getProducts();
        prod = product;
       pdi1.setProducts(product);
      
      System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
            // Product Set
    	 pdiinspectionRepo.save(pdi1);  //.............. PDI Saved
    	 return true;
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		System.out.println("FalSeFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
    		return false;
		}
    	 
    }
    
///////////////////// For pdi --- get Product * All 
    
    @RequestMapping("findProductbyName/{name}")
    public Products findProductbyName(@PathVariable String name)
    {
    	return productsRepo.findByName(name);
    }
    
    // Delete PDI  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    
    @RequestMapping("DeletePDIByID/{pdi_id}")
    public boolean DeletePDIByID( @PathVariable int pdi_id )
    {
    	 pdiinspectionRepo.deleteById(pdi_id);
    	 return true;
    }
    
    // Tolerence Data /////////////////........
    
    @RequestMapping("getStandardTolerences/{sup_id}")
    public List<SubTolerence> getStandardTolerences(@PathVariable int sup_id)
    {
    	 return tolerenceRepo.getAllProductSubTolerence(sup_id);
    }
    
    // Top3Users 
    @RequestMapping("getMyQMSTop3Users/{limit}")
    public List<Top3Users> getMyQMSTop3Users(@PathVariable int limit)
    {
    	return pdiinspectionRepo.getQMSTop3Users(limit);
    }
    
    @RequestMapping("findAllProducts")
    public List<Products> findAllProducts()
    {
    	return productsRepo.findAll();
    }
    
    //Meeting Attend By Supplier
    
    @RequestMapping("getAllConcernsBySupplier_ID/{sup_id}")
    public List<SubConcern> getAllConcernsBySupplier_ID(@PathVariable int sup_id)
    {
  	 return concernRepo.getAllConcernsBySupplier_ID(sup_id);
    }
   
    
}
    
