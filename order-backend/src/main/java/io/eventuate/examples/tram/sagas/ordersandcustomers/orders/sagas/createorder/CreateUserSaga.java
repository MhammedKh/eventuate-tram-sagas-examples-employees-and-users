package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.createorder;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

import io.eventuate.examples.tram.sagas.ordersandcustomers.customers.api.commands.CreateEmployeeCommand;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.commandsandreplies.RejectUserCommand;
import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

public class CreateUserSaga implements SimpleSaga<CreateUserSagaData> {

    private SagaDefinition<CreateUserSagaData> sagaDefinition = step().withCompensation(this::reject).step().invokeParticipant(this::createEmployee).build();

    @Override
    public SagaDefinition<CreateUserSagaData> getSagaDefinition() {
        return this.sagaDefinition;
    }

    private CommandWithDestination createEmployee(CreateUserSagaData data) {
        return send(new CreateEmployeeCommand(data.getId(), data.getFirstName(), data.getMatricule(), data.getLastName())).to("employeeService").build();
    }

    public CommandWithDestination reject(CreateUserSagaData data) {
        System.out.println("***reject" + data.getId());
        return send(new RejectUserCommand(data.getId())).to("userService").build();
    }
}
