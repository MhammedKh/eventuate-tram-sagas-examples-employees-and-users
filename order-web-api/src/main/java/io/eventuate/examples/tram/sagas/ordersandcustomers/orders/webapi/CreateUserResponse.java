package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.webapi;


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
