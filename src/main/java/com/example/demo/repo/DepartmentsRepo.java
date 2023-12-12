package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.classes.Departments;
import com.example.demo.repo.sub_interfaces.DepartmentNames;

public interface DepartmentsRepo extends JpaRepository<Departments, Integer> 
{
     @Query (value = "SELECT distinct(departments_id) FROM qms.departments_supplier join qms.suppliers where supplier_id=?1", nativeQuery = true)
	List<Integer> findAllDepListBySupId(int sup_id);
    
     @Query (value = "SELECT distinct(name) FROM qms.departments d join qms.departments_supplier s on d.id=s.departments_id where supplier_id=?1",nativeQuery = true)
	List<DepartmentNames> getAllDepartmentNamesBySupplierId(int sup_id);
  
}
