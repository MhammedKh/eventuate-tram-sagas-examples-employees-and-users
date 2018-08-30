package com.sifast.employeeandusers.employees.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sifast.employeeanduser.employees.webapi.CreateEmployeeRequest;
import com.sifast.employeeanduser.employees.webapi.CreateEmployeeResponse;
import com.sifast.employeeandusers.users.sagas.create.employee.CreateEmployeeSagaData;

import io.eventuate.tram.sagas.orchestration.SagaManager;

@RestController
public class EmployeeController {

    @Autowired
    private SagaManager<CreateEmployeeSagaData> createOrderSagaManager;

    @RequestMapping(value = "/employeess", method = RequestMethod.POST)
    public CreateEmployeeResponse createOrder(@RequestBody CreateEmployeeRequest createUserRequest) {

        CreateEmployeeSagaData data = new CreateEmployeeSagaData(createUserRequest.getFirstName(), createUserRequest.getMatricule(), createUserRequest.getLastName(),
                createUserRequest.getEmail());
        createOrderSagaManager.create(data);
        return new CreateEmployeeResponse(0);
    }
}
