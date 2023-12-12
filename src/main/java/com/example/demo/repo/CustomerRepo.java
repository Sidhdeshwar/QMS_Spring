package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.classes.Customer;
import com.example.demo.custSubRepo.SubCustomer;
import com.example.demo.customerDATA.SubCustomerList;
import com.example.demo.repo.sub_interfaces.SubPDIRepo;

public interface CustomerRepo extends JpaRepository<Customer, Integer> 
{
	
   public int countByEmail(String email);
   public Customer findByEmail(String email);
   
   @Query (value = "SELECT id,name,location,email FROM qms.customer where passward like ?1",nativeQuery = true)
   public SubCustomer findTheCustomerByEmail(String email);
	
	
  @Query (value = "SELECT c.id,c.name,c.location,c.contactperson,c.mobile,c.email FROM qms.customer c join qms.customer_suppliers s  where s.suppliers_id=?1", nativeQuery = true)
  List<SubCustomerList> getAllSubCustomersBySupplierId(int sup_id);
  
  @Query (value = "SELECT p.id,p.date,p.inspectionstage,p.inpectiontype,p.dentrust,p.shift,p.l,p.b,p.t,p.lupper,p.llower,p.bupper,p.blower,p.tupper,p.tlower,p.status FROM qms.pdiinspection p join qms.pdiinspection_products pp  where suppliers_id=?1 order by date", nativeQuery = true)
  List<SubPDIRepo> getAllPDIDataSendBySupplier(int sup_id);


  
  
}
