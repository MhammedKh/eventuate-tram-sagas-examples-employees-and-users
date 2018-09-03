package com.sifast.employees.api.commands;

import io.eventuate.tram.commands.common.Command;

public class UpdateUserCommand implements Command {

    private int userId;

    private String email;

    public UpdateUserCommand() {
    }

    public UpdateUserCommand(int userId, String email) {
        super();
        this.userId = userId;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
