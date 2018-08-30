package com.sifast.employeeandusers.users.sagas.update.employee;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

import com.sifast.employees.api.commands.RejectUserCommand;
import com.sifast.employees.api.commands.UpdateEmployeeCommand;

import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

public class UpdateEmployeeSaga implements SimpleSaga<UpdateEmployeeSagaData> {

    private SagaDefinition<UpdateEmployeeSagaData> sagaDefinition = step().withCompensation(this::reject).step().invokeParticipant(this::updateEmployee).build();

    @Override
    public SagaDefinition<UpdateEmployeeSagaData> getSagaDefinition() {
        return this.sagaDefinition;
    }

    private CommandWithDestination updateEmployee(UpdateEmployeeSagaData data) {
        System.out.println("**** updateEmployee " + data);
        return send(new UpdateEmployeeCommand(data.getId(), data.getFirstName(), data.getMatricule(), data.getLastName())).to("employeeService").build();
    }

    public CommandWithDestination reject(UpdateEmployeeSagaData data) {
        System.out.println("***reject" + data.getId());
        return send(new RejectUserCommand(data.getOldUser(), false, true)).to("userService").build();
    }
}
