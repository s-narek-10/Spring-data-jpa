package com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "string")
public interface EmployeeMapper {
    EmployeeDto employeeDto(Employee employee);

    List<EmployeeDto> listEmployeeDto(List<Employee> listEmployee);

    Employee map(EmployeeDto employeeDto);
}
