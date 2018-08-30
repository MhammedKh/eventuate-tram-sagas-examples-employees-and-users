package com.sifast.employeeandusers.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sifast.employeeandusers.employees.web.EmployeeWebConfiguration;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;
import io.eventuate.tram.commands.producer.TramCommandProducerConfiguration;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.orchestration.SagaOrchestratorConfiguration;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;

@SpringBootApplication
@Configuration
@Import({ EmployeeConfiguration.class, EmployeeWebConfiguration.class, TramEventsPublisherConfiguration.class, TramCommandProducerConfiguration.class,
        SagaOrchestratorConfiguration.class, TramJdbcKafkaConfiguration.class, SagaParticipantConfiguration.class })
@ComponentScan
public class EmployeesServiceMain {

    @Bean
    public ChannelMapping channelMapping() {
        return DefaultChannelMapping.builder().build();
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeesServiceMain.class, args);
    }
}
