package com.nareksarkisyan.spring.springboot.spring_dada_jpa.dao;

import com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity.Employee;
import com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByName(String name);
}