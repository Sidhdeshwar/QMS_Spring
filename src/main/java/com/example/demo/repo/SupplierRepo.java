package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.classes.Suppliers;

public interface SupplierRepo extends JpaRepository<Suppliers, Integer>
{

	int countByEmail(String email);

	int countByPassward(String passward);

	Suppliers findByPassward(String password);

	@Query (value = "SELECT distinct(products_id) FROM qms.suppliers join qms.suppliers_products where suppliers_id =?1", nativeQuery = true)
	List<Integer> findProdIdBySupplierId(int sup_id);


  public  Suppliers findByEmail(String email);

	Suppliers findByName(String sup_name);
	
	
  
}
