package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.classes.EmptyPDIReport;

public interface EmptyPDIReportRepo extends JpaRepository<EmptyPDIReport, Integer>
{

}
