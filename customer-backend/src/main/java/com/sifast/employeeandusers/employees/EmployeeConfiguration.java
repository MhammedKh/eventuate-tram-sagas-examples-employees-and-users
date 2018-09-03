package com.sifast.employeeandusers.employees;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sifast.employeeandusers.employees.service.EmployeeCommandHandler;
import com.sifast.employeeandusers.employees.service.EmployeeService;
import com.sifast.employeeandusers.users.sagas.create.employee.CreateEmployeeSaga;
import com.sifast.employeeandusers.users.sagas.create.employee.CreateEmployeeSagaData;
import com.sifast.employeeandusers.users.sagas.update.employee.UpdateEmployeeSaga;
import com.sifast.employeeandusers.users.sagas.update.employee.UpdateEmployeeSagaData;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.sagas.orchestration.Saga;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import io.eventuate.tram.sagas.orchestration.SagaManagerImpl;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;

@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
public class EmployeeConfiguration {

    @Bean
    public SagaManager<CreateEmployeeSagaData> createEmployeeSagaManager(Saga<CreateEmployeeSagaData> saga) {
        return new SagaManagerImpl<>(saga);
    }

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }

    @Bean
    public UpdateEmployeeSaga updateEmployeeSaga() {
        return new UpdateEmployeeSaga();
    }

    @Bean
    public SagaManager<UpdateEmployeeSagaData> updateOrderSagaManager(Saga<UpdateEmployeeSagaData> saga) {
        return new SagaManagerImpl<>(saga);
    }

    @Bean
    public CreateEmployeeSaga createEmployeeSaga() {
        return new CreateEmployeeSaga();
    }

    @Bean
    public EmployeeCommandHandler employeeCommandHandler() {
        return new EmployeeCommandHandler();
    }

    @Bean
    public CommandDispatcher employeeCommandDispatcher(EmployeeCommandHandler target) {
        return new SagaCommandDispatcher("employeeCommandDispatcher", target.commandHandlerDefinitions());
    }

}