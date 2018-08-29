package com.sifast.employeeandusers.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sifast.employeeandusers.users.webapi.CreateUserRequest;
import com.sifast.employeeandusers.users.webapi.CreateUserResponse;

import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.common.UserDetails;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.User;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.service.UserService;

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

}
