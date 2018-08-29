package io.eventuate.examples.tram.sagas.ordersandcustomers.customers.service;

import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.examples.tram.sagas.ordersandcustomers.customers.api.commands.CreateEmployeeCommand;
import io.eventuate.examples.tram.sagas.ordersandcustomers.customers.api.replies.EmployeeCreated;
import io.eventuate.examples.tram.sagas.ordersandcustomers.customers.api.replies.EmployeeNotCreated;
import io.eventuate.examples.tram.sagas.ordersandcustomers.customers.domain.Employee;
import io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

public class CustomerCommandHandler {

    @Autowired
    private EmployeeService employeerService;

    public CommandHandlers commandHandlerDefinitions() {
        return SagaCommandHandlersBuilder.fromChannel("employeeService").onMessage(CreateEmployeeCommand.class, this::createEmployee).build();
    }

    public Message createEmployee(CommandMessage<CreateEmployeeCommand> cm) {
        System.out.println("**** create Employee in progress");
        CreateEmployeeCommand cmd = cm.getCommand();
        boolean isEmployeeCreated = false;
        try {
            Employee employee = new Employee(0, cmd.getFirstName(), cmd.getMatricule(), cmd.getLastName());
            System.out.println("**** " + employee.toString());
            Integer.parseInt("aaa");
            employeerService.createEmployee(employee);
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

    // withLock(Customer.class, customerId).
    // TODO @Validate to trigger validation and error reply

}
