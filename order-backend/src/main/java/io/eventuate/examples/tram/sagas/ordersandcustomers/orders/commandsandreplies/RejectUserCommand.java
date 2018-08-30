package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.commandsandreplies;

import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.User;
import io.eventuate.tram.commands.common.Command;

public class RejectUserCommand implements Command {

    private User oldUser;

    private boolean isRejectCreate;

    private boolean isRejectUpdate;

    public RejectUserCommand() {
    }

    public RejectUserCommand(User oldUser, boolean isRejectCreate, boolean isRejectUpdate) {
        super();
        this.oldUser = oldUser;
        this.isRejectCreate = isRejectCreate;
        this.isRejectUpdate = isRejectUpdate;
    }

    public User getOldUser() {
        return oldUser;
    }

    public void setOldUser(User oldUser) {
        this.oldUser = oldUser;
    }

    public boolean isRejectCreate() {
        return isRejectCreate;
    }

    public void setRejectCreate(boolean isRejectCreate) {
        this.isRejectCreate = isRejectCreate;
    }

    public boolean isRejectUpdate() {
        return isRejectUpdate;
    }

    public void setRejectUpdate(boolean isRejectUpdate) {
        this.isRejectUpdate = isRejectUpdate;
    }

}
