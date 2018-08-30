package com.sifast.employeeandusers.users.webapi;


public class UpdateUserResponse {
  private Long orderId;

  public UpdateUserResponse() {
  }

  public UpdateUserResponse(Long orderId) {
    this.orderId = orderId;
  }

  public Long getOrderId() {
    return orderId;
  }
}
