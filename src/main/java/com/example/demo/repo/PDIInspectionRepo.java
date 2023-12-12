package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.classes.PDIInspection;
import com.example.demo.repo.sub_interfaces.SubPDIRepo;
import com.example.demo.repo.sub_interfaces.Top3Users;

public interface PDIInspectionRepo extends JpaRepository<PDIInspection, Integer>
{
   @Query (value = "SELECT p.id,products_id ,p.date,p.inspectionstage,p.inpectiontype,p.dentrust,p.shift,p.l,p.b,p.t,p.status,t.name,t.ll,t.lu,t.bl,t.bu,t.tl,t.tu FROM qms.pdiinspection p join qms.tolerence t on p.products_id=t.product_id where p.suppliers_id=?1 order by p.date",nativeQuery = true)
   List<SubPDIRepo> getAllPDIDetailsByProductID(int sup_id);
   
   @Query (value = "SELECT p.id,products_id ,p.date,p.inspectionstage,p.inpectiontype,p.dentrust,p.shift,p.l,p.b,p.t,p.status,t.name,t.ll,t.lu,t.bl,t.bu,t.tl,t.tu FROM qms.pdiinspection p join qms.tolerence t on p.products_id=t.product_id where p.customer_id=?1 order by p.date",nativeQuery = true)
   List<SubPDIRepo> getPDIrecievedFromSuppliers(int cust_id);

   @Query(value = "UPDATE `qms`.`pdiinspection` SET `status` = '?1' WHERE (`id` = '?2')",nativeQuery = true)
   boolean applyAcceptReject(String status,int id);
   
   @Query (value = "SELECT distinct( s.name ),s.location FROM qms.pdiinspection p join qms.suppliers s on p.suppliers_id=s.id  limit ?1",nativeQuery = true)
   List<Top3Users>getQMSTop3Users(int limit);
    
   
  
}
