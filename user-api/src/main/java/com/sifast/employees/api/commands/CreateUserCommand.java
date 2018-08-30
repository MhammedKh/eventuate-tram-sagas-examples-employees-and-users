package com.sifast.employees.api.commands;

import io.eventuate.tram.commands.common.Command;

public class CreateUserCommand implements Command {

    private String email;

    public CreateUserCommand() {
    }

    public CreateUserCommand(String email) {
        super();
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
