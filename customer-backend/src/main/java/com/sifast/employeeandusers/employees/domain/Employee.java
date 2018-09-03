package com.sifast.employeeandusers.employees.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "EMP_USER_ID", updatable = false, nullable = false, length = 50)
    private int userId;

    @Column(name = "EMP_FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "EMP_MATRICULE", nullable = false, length = 10)
    private int matricule;

    @Column(name = "EMP_LAST_NAME", nullable = false, length = 50)
    private String lastName;

    public Employee(int userId, String firstName, int matricule, String lastName) {
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.matricule = matricule;
        this.lastName = lastName;
    }

    public Employee(int id, int userId, String firstName, int matricule, String lastName) {
        super();
        this.id = id;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", matricule=" + matricule + ", lastName=" + lastName + "]";
    }

}