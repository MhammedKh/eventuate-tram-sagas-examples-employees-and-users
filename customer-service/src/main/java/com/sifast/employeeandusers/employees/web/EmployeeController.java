package com.sifast.employeeandusers.employees.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sifast.employeeandusers.employees.service.EmployeeService;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService customerService) {
        this.employeeService = customerService;
    }

    // @RequestMapping(value = "/customers", method = RequestMethod.POST)
    // public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
    // Employee customer = customerService.createCustomer(createCustomerRequest.getName(), createCustomerRequest.getCreditLimit());
    // return new CreateCustomerResponse(customer.getId());
    // }
}
