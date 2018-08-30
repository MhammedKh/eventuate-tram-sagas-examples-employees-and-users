package com.sifast.employeeandusers.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sifast.employeeandusers.users.common.UserDetails;
import com.sifast.employeeandusers.users.sagas.createorder.CreateUserSagaData;
import com.sifast.employeeandusers.users.webapi.CreateUserRequest;
import com.sifast.employeeandusers.users.webapi.CreateUserResponse;
import com.sifast.employeeandusers.users.webapi.UpdateUserRequest;
import com.sifast.employeeandusers.users.webapi.UpdateUserResponse;

<<<<<<< 9db08f142f3f650860ef88b6ad0ca9dc314b05df
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.common.UserDetails;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.User;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.UserRepository;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.updateorder.UpdateUserSagaData;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.service.UserService;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import io.swagger.annotations.ApiParam;
=======
import io.eventuate.tram.sagas.orchestration.SagaManager;
>>>>>>> add employee saga in progress

@RestController
public class UserController {

    @Autowired
    private SagaManager<CreateUserSagaData> createOrderSagaManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SagaManager<UpdateUserSagaData> updateOrderSagaManager;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public CreateUserResponse createOrder(@RequestBody CreateUserRequest createUserRequest) {
        UserDetails userDetails = new UserDetails(createUserRequest.getFirstName(), createUserRequest.getMatricule(), createUserRequest.getLastName(),
                createUserRequest.getEmail());

        CreateUserSagaData data = new CreateUserSagaData(0, userDetails.getFirstName(), userDetails.getMatricule(), userDetails.getLastName(), userDetails.getEmail());
        createOrderSagaManager.create(data);
        return new CreateUserResponse(0);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public UpdateUserResponse updateOrder(@RequestBody UpdateUserRequest updateUserRequest,
            @ApiParam(value = "ID of employee that will be updated", required = true, allowableValues = "range[1,infinity]") @PathVariable("id") Long id) {
        User oldUser = userRepository.findOne(id);
        User oldUser_ = new User(oldUser.getId(), oldUser.getEmail());
        System.out.println("**** oldOser  " + oldUser.toString());
        User user = userService
                .updateUser(new UserDetails(id, updateUserRequest.getFirstName(), updateUserRequest.getMatricule(), updateUserRequest.getLastName(), updateUserRequest.getEmail()));
        UpdateUserSagaData data = new UpdateUserSagaData(user.getId(), updateUserRequest.getFirstName(), updateUserRequest.getLastName(), updateUserRequest.getMatricule(),
                user.getEmail(), oldUser_);
        System.out.println("**** data " + data);
        updateOrderSagaManager.create(data);
        return new UpdateUserResponse(user.getId());
    }

}
