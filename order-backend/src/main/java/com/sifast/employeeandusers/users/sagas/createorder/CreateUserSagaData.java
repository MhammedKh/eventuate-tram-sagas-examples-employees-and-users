package com.sifast.employeeandusers.users.sagas.createorder;

import com.sifast.employees.api.commands.CreateUserReply;

public class CreateUserSagaData {

    private int id;

    private String firstName;

    private String matricule;

    private String lastName;

    private String email;

    public CreateUserSagaData() {
        super();
    }

    public CreateUserSagaData(int id, String firstName, String matricule, String lastName, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.matricule = matricule;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void handleCreateUserReply(CreateUserReply reply) {
        System.out.println("getUserId {}" + reply.getUserId());
        setId(reply.getUserId());
    }

}
