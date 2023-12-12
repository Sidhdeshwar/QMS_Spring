package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.classes.Products;
import com.example.demo.repo.sub_interfaces.SubProductsData;

public interface ProductsRepo extends JpaRepository<Products, Integer>
{
   @Query (value = "SELECT distinct(p.id),p.name,p.model,p.l,p.b,p.t FROM qms.products p join qms.suppliers_products s  where s.suppliers_id=?1 order by p.id ", nativeQuery = true)
   List<SubProductsData> getSubProductBySuppliersID(int sup_id);
   
   Products findByName(String name);
}
