package com.sifast.employeeandusers.users.sagas.create.employee;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

import com.sifast.employees.api.commands.CreateEmployeeCommand;
import com.sifast.employees.api.commands.CreateUserCommand;
import com.sifast.employees.api.commands.CreateUserReply;
import com.sifast.employees.api.commands.RejectUserCommand;

<<<<<<< 9db08f142f3f650860ef88b6ad0ca9dc314b05df:order-backend/src/main/java/io/eventuate/examples/tram/sagas/ordersandcustomers/orders/sagas/createorder/CreateUserSaga.java
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.commandsandreplies.RejectUserCommand;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.User;
=======
>>>>>>> add employee saga in progress:order-backend/src/main/java/com/sifast/employeeandusers/users/sagas/createorder/CreateUserSaga.java
import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

public class CreateEmployeeSaga implements SimpleSaga<CreateEmployeeSagaData> {

    private SagaDefinition<CreateEmployeeSagaData> sagaDefinition = step().withCompensation(this::reject).step().invokeParticipant(this::createUser)
            .onReply(CreateUserReply.class, CreateEmployeeSagaData::handleCreateUserReply).step().invokeParticipant(this::createEmployee).build();

    @Override
    public SagaDefinition<CreateEmployeeSagaData> getSagaDefinition() {
        return this.sagaDefinition;
    }

    private CommandWithDestination createEmployee(CreateEmployeeSagaData data) {
        System.out.println("***id from userService***" + data.getId());
        return send(new CreateEmployeeCommand(data.getId(), data.getFirstName(), data.getMatricule(), data.getLastName())).to("employeeService").build();
    }

    private CommandWithDestination createUser(CreateEmployeeSagaData data) {
        System.out.println("***create user" + data.getId());
        return send(new CreateUserCommand(data.getEmail())).to("userService").build();
    }

    public CommandWithDestination reject(CreateEmployeeSagaData data) {
        System.out.println("***reject" + data.getId());
        return send(new RejectUserCommand(new User(data.getId(), data.getEmail()), true, false)).to("userService").build();
    }

}
