package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.classes.Concern;
import com.example.demo.repo.sub_interfaces.SubConcern;

public interface ConcernRepo extends JpaRepository<Concern, Integer>
{
    @Query (value = "SELECT id,product_id,date,problem,affectqty,customer_id,supplier_id,level,actionplan,problemstatus,audit,auditstatus, meeting, meetingstatus FROM qms.concern where customer_id=?1",nativeQuery = true)
	 List<SubConcern> getAllConcernsByCustomer_ID(int cust_id);

    @Query (value = "SELECT id,product_id,date,problem,affectqty,customer_id,supplier_id,level,actionplan,problemstatus,audit,auditstatus, meeting, meetingstatus FROM qms.concern where customer_id=?1",nativeQuery = true)
	List<SubConcern> findtheAllComplaint(int cust_id);
    
    @Query (value = "SELECT id,product_id,date,problem,affectqty,customer_id,supplier_id,level,actionplan,problemstatus,audit,auditstatus, meeting, meetingstatus FROM qms.concern where supplier_id=?1",nativeQuery = true)
	 List<SubConcern> getAllConcernsBySupplier_ID(int sup_id);
	
}
