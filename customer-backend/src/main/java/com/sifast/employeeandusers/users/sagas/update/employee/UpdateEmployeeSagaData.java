package com.sifast.employeeandusers.users.sagas.update.employee;

import com.sifast.employeeandusers.users.domain.User;

public class UpdateEmployeeSagaData {

    private Long id;

    private String firstName;

    private String matricule;

    private String lastName;

    private String email;

    private User oldUser;

    public UpdateEmployeeSagaData() {
        super();
    }

    public UpdateEmployeeSagaData(Long id, String firstName, String matricule, String lastName, String email, User oldUser) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.matricule = matricule;
        this.lastName = lastName;
        this.email = email;
        this.oldUser = oldUser;
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

    public User getOldUser() {
        return oldUser;
    }

    public void setOldUser(User oldUser) {
        this.oldUser = oldUser;
    }

    @Override
    public String toString() {
        return "UpdateUserSagaData [id=" + id + ", firstName=" + firstName + ", matricule=" + matricule + ", lastName=" + lastName + ", email=" + email + ", oldUser=" + oldUser
                + "]";
    }

}
