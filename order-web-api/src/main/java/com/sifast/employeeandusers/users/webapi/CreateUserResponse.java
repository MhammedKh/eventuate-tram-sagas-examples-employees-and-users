package com.sifast.employeeandusers.users.webapi;

public class CreateUserResponse {

    private int orderId;

    public CreateUserResponse() {
    }

    public CreateUserResponse(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}
