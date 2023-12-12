package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.classes.Tolerence;
import com.example.demo.repo.sub_interfaces.SubTolerence;

public interface TolerenceRepo extends JpaRepository<Tolerence, Integer>
{
   @Query (value = "SELECT product_id,name,ll,lu,bl,bu,tl,tu FROM qms.tolerence where sup_id=1", nativeQuery = true)
   List<SubTolerence> getAllProductSubTolerence(int sup_id);
}
