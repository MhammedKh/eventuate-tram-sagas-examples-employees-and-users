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
    // @Column(name = "EMP_ID", updatable = false, nullable = false, length = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "EMP_USER_ID", updatable = false, nullable = false, length = 50)
    private int user_id;

    @Column(name = "EMP_FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "EMP_MATRICULE", nullable = false, length = 10)
    private int matricule;

    @Column(name = "EMP_LAST_NAME", nullable = false, length = 50)
    private String lastName;

    public Employee(int id, int user_id, String firstName, int matricule, String lastName) {
        super();
        this.id = id;
        this.user_id = user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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