package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.common;

import javax.persistence.Embeddable;

@Embeddable
public class UserDetails {

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
