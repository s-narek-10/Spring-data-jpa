package com.nareksarkisyan.spring.springboot.spring_dada_jpa.controller;

import com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity.EmployeeDto;
import com.nareksarkisyan.spring.springboot.spring_dada_jpa.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public List<EmployeeDto> showAllEmployees() {
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable int id) {
        EmployeeDto employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/")
    public EmployeeDto addNewEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.saveEmployee(employeeDto);
        return employeeDto;
    }

    @PutMapping("/")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/name/{name}")
    public List<EmployeeDto> findAllByName(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }
}
