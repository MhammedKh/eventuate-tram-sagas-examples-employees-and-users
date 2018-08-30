package com.sifast.employeeandusers.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sifast.employeeandusers.users.web.UserWebConfiguration;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;
import io.eventuate.tram.commands.producer.TramCommandProducerConfiguration;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.orchestration.SagaOrchestratorConfiguration;

@SpringBootApplication
@Configuration
@Import({ UserWebConfiguration.class, UserConfiguration.class, TramEventsPublisherConfiguration.class, TramCommandProducerConfiguration.class, SagaOrchestratorConfiguration.class,
        TramJdbcKafkaConfiguration.class })
@ComponentScan
public class UsersServiceMain {

    @Bean
    public ChannelMapping channelMapping() {
        return DefaultChannelMapping.builder().build();
    }

    public static void main(String[] args) {
        SpringApplication.run(UsersServiceMain.class, args);
    }

}