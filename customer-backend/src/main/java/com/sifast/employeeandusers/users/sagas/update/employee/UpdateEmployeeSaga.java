package com.sifast.employeeandusers.users.sagas.update.employee;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

import com.sifast.employeeandusers.employees.common.RejectEmployeeForUpdateCommand;
import com.sifast.employeeandusers.employees.common.UpdateEmployeeReply;
import com.sifast.employees.api.commands.UpdateEmployeeCommand;
import com.sifast.employees.api.commands.UpdateUserCommand;

import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

public class UpdateEmployeeSaga implements SimpleSaga<UpdateEmployeeSagaData> {

    private SagaDefinition<UpdateEmployeeSagaData> sagaDefinition = step().withCompensation(this::reject).step().invokeParticipant(this::updateEmployee)
            .onReply(UpdateEmployeeReply.class, UpdateEmployeeSagaData::handleUpdateEmployeeReply).step().invokeParticipant(this::updateUser).build();

    @Override
    public SagaDefinition<UpdateEmployeeSagaData> getSagaDefinition() {
        return this.sagaDefinition;
    }

    private CommandWithDestination updateEmployee(UpdateEmployeeSagaData data) {
        System.out.println("**** updateEmployee " + data);
        return send(new UpdateEmployeeCommand(data.getId(), data.getFirstName(), data.getMatricule(), data.getLastName())).to("employeeService").build();
    }

    private CommandWithDestination updateUser(UpdateEmployeeSagaData data) {
        System.out.println("**** updateUser " + data);
        return send(new UpdateUserCommand(data.getUserId(), data.getEmail())).to("userService").build();
    }

    public CommandWithDestination reject(UpdateEmployeeSagaData data) {
        System.out.println("***reject" + data.getId());
        System.out.println("***reject" + data.getOldEmployee());
        return send(new RejectEmployeeForUpdateCommand(data.getOldEmployee())).to("employeeService").build();
    }
}
