package com.nareksarkisyan.spring.springboot.spring_dada_jpa.service;

import com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    void saveEmployee(EmployeeDto employee);

    EmployeeDto getEmployee(int id);

    void deleteEmployee(int id);

    List<EmployeeDto> findAllByName(String name);
}
