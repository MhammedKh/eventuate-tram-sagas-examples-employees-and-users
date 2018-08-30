package com.sifast.employees.api.commands;

import io.eventuate.tram.commands.common.Command;

public class CreateEmployeeCommand implements Command {

    private int id;

    private String firstName;

    private String matricule;

    private String lastName;

    public CreateEmployeeCommand() {
    }

    public CreateEmployeeCommand(int id, String firstName, String matricule, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.matricule = matricule;
        this.lastName = lastName;
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

}
