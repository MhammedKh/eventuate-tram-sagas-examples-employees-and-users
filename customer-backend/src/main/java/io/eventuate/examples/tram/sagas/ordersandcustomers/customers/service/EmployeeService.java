package io.eventuate.examples.tram.sagas.ordersandcustomers.customers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import io.eventuate.examples.tram.sagas.ordersandcustomers.customers.domain.Employee;
import io.eventuate.examples.tram.sagas.ordersandcustomers.customers.domain.EmployeeRepository;

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
