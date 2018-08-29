package com.sifast.employeeandusers.employees;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sifast.employeeandusers.employees.service.CustomerCommandHandler;
import com.sifast.employeeandusers.employees.service.EmployeeService;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaLockManager;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;

@Configuration
@Import(SagaParticipantConfiguration.class)
@EnableJpaRepositories
@EnableAutoConfiguration
public class EmployeeConfiguration {

    @Bean
    public EmployeeService employeerService() {
        return new EmployeeService();
    }

    @Bean
    public CustomerCommandHandler customerCommandHandler() {
        return new CustomerCommandHandler();
    }

    // TODO Exception handler for CustomerCreditLimitExceededException

    @Bean
    public CommandDispatcher consumerCommandDispatcher(CustomerCommandHandler target, SagaLockManager sagaLockManager) {

        return new SagaCommandDispatcher("employeeCommandDispatcher", target.commandHandlerDefinitions());
    }

}
