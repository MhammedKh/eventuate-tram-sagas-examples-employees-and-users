package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.commandsandreplies;

import io.eventuate.tram.commands.common.Command;

public class RejectUserCommand implements Command {

    private long userId;

    public RejectUserCommand() {
    }

    public RejectUserCommand(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
