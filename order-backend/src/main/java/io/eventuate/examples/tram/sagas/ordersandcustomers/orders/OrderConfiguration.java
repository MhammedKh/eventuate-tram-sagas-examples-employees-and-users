package io.eventuate.examples.tram.sagas.ordersandcustomers.orders;

import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.createorder.CreateUserSaga;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.sagas.createorder.CreateUserSagaData;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.service.OrderCommandHandler;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.service.UserService;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.orchestration.Saga;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import io.eventuate.tram.sagas.orchestration.SagaManagerImpl;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
public class OrderConfiguration {

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
  public OrderCommandHandler orderCommandHandler() {
    return new OrderCommandHandler();
  }

  @Bean
  public CommandDispatcher orderCommandDispatcher(OrderCommandHandler target) {
    return new SagaCommandDispatcher("orderCommandDispatcher", target.commandHandlerDefinitions());
  }

}
