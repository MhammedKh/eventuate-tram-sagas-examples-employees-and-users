package com.sifast.employeeandusers.employees.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sifast.employeeandusers.employees.domain.Employee;
import com.sifast.employees.api.commands.CreateEmployeeCommand;
import com.sifast.employees.api.commands.UpdateEmployeeCommand;
import com.sifast.employees.api.replies.EmployeeCreated;
import com.sifast.employees.api.replies.EmployeeNotCreated;
import com.sifast.employees.api.replies.EmployeeNotUpdated;
import com.sifast.employees.api.replies.EmployeeUpdated;

import io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

public class CustomerCommandHandler {

    @Autowired
    private EmployeeService employeerService;

    public CommandHandlers commandHandlerDefinitions() {
        return SagaCommandHandlersBuilder.fromChannel("employeeService").onMessage(CreateEmployeeCommand.class, this::createEmployee)
                .onMessage(UpdateEmployeeCommand.class, this::updateEmployee).build();
    }

    public Message createEmployee(CommandMessage<CreateEmployeeCommand> cm) {
        System.out.println("**** create Employee in progress");
        CreateEmployeeCommand cmd = cm.getCommand();
        boolean isEmployeeCreated = false;
        try {
            Employee employee = new Employee(0, cmd.getFirstName(), cmd.getMatricule(), cmd.getLastName());
            System.out.println("**** " + employee.toString());
            employeerService.createOrUpdateEmployee(employee);
            isEmployeeCreated = true;
            System.out.println("**** Employee created successfuly");
            return CommandHandlerReplyBuilder.withSuccess(new EmployeeCreated());
        } catch (Exception e) {
            if (!isEmployeeCreated) {
                return CommandHandlerReplyBuilder.withFailure(new EmployeeNotCreated());
            } else {
                return CommandHandlerReplyBuilder.withSuccess(new EmployeeCreated());
            }
        }
    }

    public Message updateEmployee(CommandMessage<UpdateEmployeeCommand> cm) {
        System.out.println("**** update Employee in progress");
        UpdateEmployeeCommand cmd = cm.getCommand();
        boolean isEmployeeCreated = false;
        try {
            Employee employee = new Employee((int) (long) cmd.getId(), cmd.getFirstName(), cmd.getMatricule(), cmd.getLastName());
            System.out.println("**** " + employee.toString());
            Integer.parseInt("aaa");
            employeerService.createOrUpdateEmployee(employee);
            isEmployeeCreated = true;
            System.out.println("**** Employee updated successfuly");
            return CommandHandlerReplyBuilder.withSuccess(new EmployeeUpdated());
        } catch (Exception e) {
            if (!isEmployeeCreated) {
                return CommandHandlerReplyBuilder.withFailure(new EmployeeNotUpdated());
            } else {
                return CommandHandlerReplyBuilder.withSuccess(new EmployeeUpdated());
            }
        }
    }

    // withLock(Customer.class, customerId).
    // TODO @Validate to trigger validation and error reply

}
