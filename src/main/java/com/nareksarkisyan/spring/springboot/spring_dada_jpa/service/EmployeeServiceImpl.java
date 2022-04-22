package com.nareksarkisyan.spring.springboot.spring_dada_jpa.service;

import com.nareksarkisyan.spring.springboot.spring_dada_jpa.dao.EmployeeRepository;
import com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity.Employee;
import com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity.EmployeeDto;
import com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity.EmployeeMapper;
import com.nareksarkisyan.spring.springboot.spring_dada_jpa.entity.EmployeeMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employee = employeeRepository.findAll();
        return employeeMapper.listEmployeeDto(employee);
    }

    @Override
    @Modifying
    @Transactional
    public void saveEmployee(EmployeeDto employee) {
        Employee employee1 = employeeMapper.map(employee);
        if(employee.getId() != 0){
            employee1.setDateCreated(employeeRepository.getById(employee.getId()).getDateCreated());
        }
        employee1 = setAuditFields(employee1);
        employeeRepository.save(employee1);
        employee.setId(employee1.getId());
        employee.setDateCreated(employee1.getDateCreated());
        employee.setDateUpdated(employee1.getDateUpdated());
    }

    @PrePersist
    @PreUpdate
    public Employee setAuditFields(Employee employee) {
        Date now = new Date();
        if (employee.getDateCreated() == null) {
            employee.setDateCreated(now);
            return employee;
        }
        employee.setDateUpdated(now);
        return employee;
    }

    @Override
    public EmployeeDto getEmployee(int id) {
        return employeeMapper.employeeDto(employeeRepository.findById(id).orElse(null));
    }

    @Override
    @Modifying
    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> findAllByName(String name) {
        List<Employee> employee = employeeRepository.findAllByName(name);
        return employeeMapper.listEmployeeDto(employee);
    }
}
