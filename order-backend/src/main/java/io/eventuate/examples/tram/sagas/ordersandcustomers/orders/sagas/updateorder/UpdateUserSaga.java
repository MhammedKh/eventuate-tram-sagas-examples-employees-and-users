package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.updateorder;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

import com.sifast.employees.api.commands.UpdateEmployeeCommand;

import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.commandsandreplies.RejectUserCommand;
import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

public class UpdateUserSaga implements SimpleSaga<UpdateUserSagaData> {

    private SagaDefinition<UpdateUserSagaData> sagaDefinition = step().withCompensation(this::reject).step().invokeParticipant(this::updateEmployee).build();

    @Override
    public SagaDefinition<UpdateUserSagaData> getSagaDefinition() {
        return this.sagaDefinition;
    }

    private CommandWithDestination updateEmployee(UpdateUserSagaData data) {
        System.out.println("**** updateEmployee " + data);
        return send(new UpdateEmployeeCommand(data.getId(), data.getFirstName(), data.getMatricule(), data.getLastName())).to("employeeService").build();
    }

    public CommandWithDestination reject(UpdateUserSagaData data) {
        System.out.println("***reject" + data.getId());
        return send(new RejectUserCommand(data.getOldUser(), false, true)).to("userService").build();
    }
}
