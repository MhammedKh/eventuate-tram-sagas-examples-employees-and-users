package com.sifast.employeeandusers.users;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sifast.employeeandusers.users.service.UserCommandHandler;
import com.sifast.employeeandusers.users.service.UserService;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaLockManager;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;

@Configuration
@Import(SagaParticipantConfiguration.class)
@EnableJpaRepositories
@EnableAutoConfiguration
public class UserConfiguration {

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public UserCommandHandler userCommandHandler() {
        return new UserCommandHandler();
    }

    @Bean
    public CommandDispatcher userCommandDispatcher(UserCommandHandler target, SagaLockManager sagaLockManager) {
        return new SagaCommandDispatcher("userCommandDispatcher", target.commandHandlerDefinitions());
    }

}
