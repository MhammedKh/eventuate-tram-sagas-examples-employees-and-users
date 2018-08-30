package com.sifast.employeeandusers.users.service;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import org.springframework.beans.factory.annotation.Autowired;

import com.sifast.employeeandusers.users.commandsandreplies.RejectUserCommand;
import com.sifast.employeeandusers.users.domain.User;
import com.sifast.employees.api.commands.CreateUserCommand;
import com.sifast.employees.api.commands.CreateUserReply;

import io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

public class UserCommandHandler {

    @Autowired
    private UserService userService;

    public CommandHandlers commandHandlerDefinitions() {
        return SagaCommandHandlersBuilder.fromChannel("userService").onMessage(CreateUserCommand.class, this::create).onMessage(RejectUserCommand.class, this::reject).build();
    }

    public Message reject(CommandMessage<RejectUserCommand> cm) {

        System.out.println("***delete employee");
        int userId = cm.getCommand().getUserId();
        userService.deleteUser(userId);
        return withSuccess();
    }

    public Message create(CommandMessage<CreateUserCommand> cm) {
        System.out.println("***create user");
        User user = new User(0, cm.getCommand().getEmail());
        try {
            user = userService.createUser(user);
            CreateUserReply reply = new CreateUserReply(user.getId());
            return CommandHandlerReplyBuilder.withSuccess(reply);
        } catch (Exception e) {
            return CommandHandlerReplyBuilder.withFailure();
        }

    }

}
