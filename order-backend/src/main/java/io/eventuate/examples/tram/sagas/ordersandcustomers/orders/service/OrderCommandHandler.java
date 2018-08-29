package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.service;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

import org.springframework.beans.factory.annotation.Autowired;

import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.commandsandreplies.RejectUserCommand;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;

public class OrderCommandHandler {

    @Autowired
    private UserService userService;

    public CommandHandlers commandHandlerDefinitions() {
        return SagaCommandHandlersBuilder.fromChannel("userService").onMessage(RejectUserCommand.class, this::reject).build();
    }

    public Message reject(CommandMessage<RejectUserCommand> cm) {

        System.out.println("***delete employee");
        long userId = cm.getCommand().getUserId();
        userService.deleteUser(userId);
        return withSuccess();
    }

}
