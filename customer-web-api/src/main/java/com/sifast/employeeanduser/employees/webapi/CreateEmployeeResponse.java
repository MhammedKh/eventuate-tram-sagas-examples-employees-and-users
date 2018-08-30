package com.sifast.employeeanduser.employees.webapi;

public class CreateEmployeeResponse {

    private int userId;

    public CreateEmployeeResponse() {
    }

    public CreateEmployeeResponse(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
