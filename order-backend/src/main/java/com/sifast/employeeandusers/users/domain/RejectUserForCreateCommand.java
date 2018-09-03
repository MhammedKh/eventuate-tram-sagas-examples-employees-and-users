package com.sifast.employeeandusers.users.domain;

import io.eventuate.tram.commands.common.Command;

public class RejectUserForCreateCommand implements Command {

    private int userId;

    public RejectUserForCreateCommand() {
    }

    public RejectUserForCreateCommand(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
