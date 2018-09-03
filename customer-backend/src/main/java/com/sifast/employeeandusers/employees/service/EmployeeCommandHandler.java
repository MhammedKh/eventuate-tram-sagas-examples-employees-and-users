package com.sifast.employeeandusers.employees.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sifast.employeeandusers.employees.common.RejectEmployeeForUpdateCommand;
import com.sifast.employeeandusers.employees.common.UpdateEmployeeReply;
import com.sifast.employeeandusers.employees.domain.Employee;
import com.sifast.employees.api.commands.CreateEmployeeCommand;
import com.sifast.employees.api.commands.UpdateEmployeeCommand;
import com.sifast.employees.api.replies.EmployeeCreated;
import com.sifast.employees.api.replies.EmployeeNotCreated;

import io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

public class EmployeeCommandHandler {

    @Autowired
    private EmployeeService employeerService;

    public CommandHandlers commandHandlerDefinitions() {
        return SagaCommandHandlersBuilder.fromChannel("employeeService").onMessage(CreateEmployeeCommand.class, this::createEmployee)
                .onMessage(UpdateEmployeeCommand.class, this::updateEmployee).onMessage(RejectEmployeeForUpdateCommand.class, this::rejectEmployee).build();
    }

    public Message createEmployee(CommandMessage<CreateEmployeeCommand> cm) {
        CreateEmployeeCommand cmd = cm.getCommand();
        System.out.println("**** create Employee in progress " + cmd.getId());

        boolean isEmployeeCreated = false;
        try {
            Employee employee = new Employee(0, cmd.getId(), cmd.getFirstName(), Integer.parseInt(cmd.getMatricule()), cmd.getLastName());
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

    public Message rejectEmployee(CommandMessage<RejectEmployeeForUpdateCommand> cm) {
        System.out.println("**** reject Employee in progress " + cm.getCommand().getOldEmployee());
        employeerService.createOrUpdateEmployee(cm.getCommand().getOldEmployee());
        return CommandHandlerReplyBuilder.withSuccess();
    }

    public Message updateEmployee(CommandMessage<UpdateEmployeeCommand> cm) {
        System.out.println("**** update Employee in progress");
        UpdateEmployeeCommand cmd = cm.getCommand();
        Employee oldEmployee = null;
        boolean isEmployeeUpdated = false;
        try {
            oldEmployee = employeerService.findById(cmd.getId());
            Employee employee = new Employee(oldEmployee.getId(), oldEmployee.getUserId(), cmd.getFirstName(), Integer.parseInt(cmd.getMatricule()), cmd.getLastName());
            System.out.println("**** old employee " + oldEmployee.toString());
            System.out.println("**** new employee " + employee.toString());
            employeerService.createOrUpdateEmployee(employee);
            isEmployeeUpdated = true;
            System.out.println("**** Employee updated successfuly");
            return CommandHandlerReplyBuilder.withSuccess(new UpdateEmployeeReply(oldEmployee));
        } catch (Exception e) {
            if (!isEmployeeUpdated) {
                return CommandHandlerReplyBuilder.withFailure(new UpdateEmployeeReply(oldEmployee));
            } else {
                return CommandHandlerReplyBuilder.withSuccess(new UpdateEmployeeReply(oldEmployee));
            }
        }
    }

}