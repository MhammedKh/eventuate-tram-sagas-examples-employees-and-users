package com.sifast.employeeandusers.employees.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sifast.employeeanduser.employees.webapi.CreateEmployeeRequest;
import com.sifast.employeeanduser.employees.webapi.CreateEmployeeResponse;
import com.sifast.employeeanduser.employees.webapi.UpdateEmployeeRequest;
import com.sifast.employeeanduser.employees.webapi.UpdateEmployeeResponse;
import com.sifast.employeeandusers.users.sagas.create.employee.CreateEmployeeSagaData;
import com.sifast.employeeandusers.users.sagas.update.employee.UpdateEmployeeSagaData;

import io.eventuate.tram.sagas.orchestration.SagaManager;

@RestController
public class EmployeeController {

    @Autowired
    private SagaManager<CreateEmployeeSagaData> createEmployeeSagaManager;

    @Autowired
    private SagaManager<UpdateEmployeeSagaData> updateEmployeeSagaManager;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public CreateEmployeeResponse createOrder(@RequestBody CreateEmployeeRequest createUserRequest) {

        CreateEmployeeSagaData data = new CreateEmployeeSagaData(createUserRequest.getFirstName(), createUserRequest.getMatricule(), createUserRequest.getLastName(),
                createUserRequest.getEmail());
        createEmployeeSagaManager.create(data);
        return new CreateEmployeeResponse(0);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public UpdateEmployeeResponse updateOrder(@RequestBody UpdateEmployeeRequest updateEmployeeRequest, @PathVariable("id") int id) {

        UpdateEmployeeSagaData data = new UpdateEmployeeSagaData(id, updateEmployeeRequest.getFirstName(), updateEmployeeRequest.getLastName(),
                updateEmployeeRequest.getMatricule(), updateEmployeeRequest.getEmail());
        System.out.println("**** data " + data);
        updateEmployeeSagaManager.create(data);
        return new UpdateEmployeeResponse(id);
    }
}
