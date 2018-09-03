package com.sifast.employeeanduser.employees.webapi;

public class UpdateEmployeeResponse {

    private int userId;

    public UpdateEmployeeResponse() {
    }

    public UpdateEmployeeResponse(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return userId;
    }
}