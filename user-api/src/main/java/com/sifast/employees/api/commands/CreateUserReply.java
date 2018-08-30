package com.sifast.employees.api.commands;

public class CreateUserReply {

    private int userId;

    public CreateUserReply() {
    }

    public CreateUserReply(int userId) {
        super();
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
