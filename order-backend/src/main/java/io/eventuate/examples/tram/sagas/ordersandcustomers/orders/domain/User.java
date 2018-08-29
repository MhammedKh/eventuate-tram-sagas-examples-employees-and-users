package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain;

import java.util.Collections;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.eventuate.tram.events.ResultWithEvents;

@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    public User() {
    }

    public User(String email) {
        super();
        this.email = email;
    }

    public User(Long id, String email) {
        super();
        this.id = id;
        this.email = email;
    }

    public static ResultWithEvents<User> createUser(String email) {
        return new ResultWithEvents<User>(new User(email), Collections.emptyList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
