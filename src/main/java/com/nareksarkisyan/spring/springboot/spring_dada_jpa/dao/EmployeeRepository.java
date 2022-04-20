package com.nareksarkisyan.spring.springboot.spring_dada_jpa.dao;

import com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByName(String name);
}
