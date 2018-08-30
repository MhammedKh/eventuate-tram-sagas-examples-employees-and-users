package com.sifast.employeeandusers.users.common;

import javax.persistence.Embeddable;

@Embeddable
public class UserDetails {

    private Long id;

    private String firstName;

    private String matricule;

    private String lastName;

    private String email;

    public UserDetails() {
    }

    public UserDetails(String firstName, String matricule, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.matricule = matricule;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDetails(Long id, String firstName, String matricule, String lastName, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.matricule = matricule;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

}
