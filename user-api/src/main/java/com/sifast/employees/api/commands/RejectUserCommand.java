package com.sifast.employees.api.commands;

import com.sifast.employeeandusers.users.domain.User;

import io.eventuate.tram.commands.common.Command;

public class RejectUserCommand implements Command {

    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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