package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.common.UserDetails;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.User;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.UserRepository;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.createorder.CreateUserSagaData;
import io.eventuate.tram.events.ResultWithEvents;
import io.eventuate.tram.sagas.orchestration.SagaManager;

public class UserService {

    @Autowired
    private SagaManager<CreateUserSagaData> createOrderSagaManager;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(UserDetails userDetails) {
        ResultWithEvents<User> oe = User.createUser(userDetails.getEmail());
        User user = oe.result;
        userRepository.save(user);
        CreateUserSagaData data = new CreateUserSagaData(user.getId(), userDetails.getFirstName(), userDetails.getMatricule(), userDetails.getEmail(), user.getEmail());
        createOrderSagaManager.create(data, User.class, user.getId());
        return user;
    }

    public void deleteUser(long userId) {
        userRepository.delete(userId);
    }

}
