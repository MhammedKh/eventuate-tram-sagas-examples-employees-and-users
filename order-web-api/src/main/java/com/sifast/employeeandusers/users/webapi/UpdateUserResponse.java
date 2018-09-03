package com.sifast.employeeandusers.users.webapi;

public class UpdateUserResponse {

    private int userId;

    public UpdateUserResponse() {
    }

    public UpdateUserResponse(int userId) {
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
