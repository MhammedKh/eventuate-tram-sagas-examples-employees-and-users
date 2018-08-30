package com.sifast.employeeandusers.users.commandsandreplies;

import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.User;
import io.eventuate.tram.commands.common.Command;

public class RejectUserCommand implements Command {

<<<<<<< 9db08f142f3f650860ef88b6ad0ca9dc314b05df:order-backend/src/main/java/io/eventuate/examples/tram/sagas/ordersandcustomers/orders/commandsandreplies/RejectUserCommand.java
    private User oldUser;

    private boolean isRejectCreate;

    private boolean isRejectUpdate;
=======
    private int userId;
>>>>>>> add employee saga in progress:order-backend/src/main/java/com/sifast/employeeandusers/users/commandsandreplies/RejectUserCommand.java

    public RejectUserCommand() {
    }

<<<<<<< 9db08f142f3f650860ef88b6ad0ca9dc314b05df:order-backend/src/main/java/io/eventuate/examples/tram/sagas/ordersandcustomers/orders/commandsandreplies/RejectUserCommand.java
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
=======
    public RejectUserCommand(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
>>>>>>> add employee saga in progress:order-backend/src/main/java/com/sifast/employeeandusers/users/commandsandreplies/RejectUserCommand.java
    }

}
