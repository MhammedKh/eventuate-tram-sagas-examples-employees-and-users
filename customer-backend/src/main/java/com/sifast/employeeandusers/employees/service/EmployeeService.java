package com.sifast.employeeandusers.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sifast.employeeandusers.employees.domain.Employee;
import com.sifast.employeeandusers.employees.domain.EmployeeRepository;

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
