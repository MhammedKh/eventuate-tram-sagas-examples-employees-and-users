package com.sifast.employeeandusers.users.webapi;


public class CreateUserResponse {
  private Long orderId;

  public CreateUserResponse() {
  }

  public CreateUserResponse(Long orderId) {
    this.orderId = orderId;
  }

  public Long getOrderId() {
    return orderId;
  }
}