package com.nareksarkisyan.spring.springboot.spring_dada_jpa.service;

import com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    List<Employee> findAllByName(String name);
}
