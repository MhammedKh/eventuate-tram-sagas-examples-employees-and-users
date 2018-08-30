package com.sifast.employeeandusers.users;

<<<<<<< 9db08f142f3f650860ef88b6ad0ca9dc314b05df:order-backend/src/main/java/io/eventuate/examples/tram/sagas/ordersandcustomers/orders/OrderConfiguration.java
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.createorder.CreateUserSaga;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.createorder.CreateUserSagaData;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.updateorder.UpdateUserSaga;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.updateorder.UpdateUserSagaData;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.service.OrderCommandHandler;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.service.UserService;
=======
>>>>>>> add employee saga in progress:order-backend/src/main/java/com/sifast/employeeandusers/users/OrderConfiguration.java
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.orchestration.Saga;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import io.eventuate.tram.sagas.orchestration.SagaManagerImpl;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;

import com.sifast.employeeandusers.users.sagas.createorder.CreateUserSaga;
import com.sifast.employeeandusers.users.sagas.createorder.CreateUserSagaData;
import com.sifast.employeeandusers.users.service.UserCommandHandler;
import com.sifast.employeeandusers.users.service.UserService;

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
public class OrderConfiguration {

<<<<<<< 9db08f142f3f650860ef88b6ad0ca9dc314b05df:order-backend/src/main/java/io/eventuate/examples/tram/sagas/ordersandcustomers/orders/OrderConfiguration.java
    @Bean
    public UserService orderService() {
        return new UserService();
    }

    @Bean
    public SagaManager<CreateUserSagaData> createOrderSagaManager(Saga<CreateUserSagaData> saga) {
        return new SagaManagerImpl<>(saga);
    }

    @Bean
    public SagaManager<UpdateUserSagaData> uodateOrderSagaManager(Saga<UpdateUserSagaData> saga) {
        return new SagaManagerImpl<>(saga);
    }

    @Bean
    public CreateUserSaga createOrderSaga() {
        return new CreateUserSaga();
    }

    @Bean
    public UpdateUserSaga updateOrderSaga() {
        return new UpdateUserSaga();
    }

    @Bean
    public OrderCommandHandler orderCommandHandler() {
        return new OrderCommandHandler();
    }

    @Bean
    public CommandDispatcher orderCommandDispatcher(OrderCommandHandler target) {
        return new SagaCommandDispatcher("orderCommandDispatcher", target.commandHandlerDefinitions());
    }
=======
  @Bean
  public UserService orderService() {
    return new UserService();
  }


  @Bean
  public SagaManager<CreateUserSagaData> createOrderSagaManager(Saga<CreateUserSagaData> saga) {
    return new SagaManagerImpl<>(saga);
  }


  @Bean
  public CreateUserSaga createOrderSaga() {
    return new CreateUserSaga();
  }

  @Bean
  public UserCommandHandler orderCommandHandler() {
    return new UserCommandHandler();
  }

  @Bean
  public CommandDispatcher orderCommandDispatcher(UserCommandHandler target) {
    return new SagaCommandDispatcher("orderCommandDispatcher", target.commandHandlerDefinitions());
  }
>>>>>>> add employee saga in progress:order-backend/src/main/java/com/sifast/employeeandusers/users/OrderConfiguration.java

}
