package com.sifast.employeeandusers.users.webapi;

public class CreateUserRequest {

    private String firstName;

    private String matricule;

    private String lastName;

    private String email;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String firstName, String matricule, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.matricule = matricule;
        this.lastName = lastName;
        this.email = email;
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

}
