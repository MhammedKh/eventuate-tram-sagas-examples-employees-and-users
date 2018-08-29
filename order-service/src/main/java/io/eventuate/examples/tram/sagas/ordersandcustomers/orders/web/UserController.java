package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.common.UserDetails;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.User;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.service.UserService;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.webapi.CreateUserRequest;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.webapi.CreateUserResponse;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public CreateUserResponse createOrder(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService
                .createUser(new UserDetails(createUserRequest.getFirstName(), createUserRequest.getMatricule(), createUserRequest.getLastName(), createUserRequest.getEmail()));
        return new CreateUserResponse(user.getId());
    }

    // @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    // public ResponseEntity<GetOrderResponse> getOrder(@PathVariable Long orderId) {
    //
    // User order = orderRepository.findOne(orderId);
    //
    // if (order == null) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // } else {
    // return new ResponseEntity<>(new GetOrderResponse(order.getId(), order.getState()), HttpStatus.OK);
    // }
    // }
}
