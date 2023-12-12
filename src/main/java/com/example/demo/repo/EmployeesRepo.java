package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.classes.Employees;
import com.example.demo.repo.sub_interfaces.SubEmployeesData;

public interface EmployeesRepo extends JpaRepository<Employees, Integer>
{
   @Query (value = "SELECT e.name,e.designation,d.name as depname,e.mobile FROM qms.employees e join qms.departments d on e.department_id=d.id where suppliers_id=?1", nativeQuery = true)
   List<SubEmployeesData> getAllEmployeesBySupplierID(int sup_id);

}
