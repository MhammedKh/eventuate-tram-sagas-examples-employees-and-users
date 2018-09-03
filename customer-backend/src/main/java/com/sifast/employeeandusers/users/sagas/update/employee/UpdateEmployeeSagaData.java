package com.sifast.employeeandusers.users.sagas.update.employee;

import com.sifast.employeeandusers.employees.common.UpdateEmployeeReply;
import com.sifast.employeeandusers.employees.domain.Employee;

public class UpdateEmployeeSagaData {

    private int id;

    private int userId;

    private String firstName;

    private String matricule;

    private String lastName;

    private String email;

    private Employee oldEmployee;

    public UpdateEmployeeSagaData() {
        super();
    }

    public UpdateEmployeeSagaData(int id, String firstName, String matricule, String lastName, String email) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Employee getOldEmployee() {
        return oldEmployee;
    }

    public void setOldEmployee(Employee oldEmployee) {
        this.oldEmployee = oldEmployee;
    }

    public void handleUpdateEmployeeReply(UpdateEmployeeReply reply) {
        System.out.println("Oldemployee {}" + reply.getOldEmployee());
        setOldEmployee(reply.getOldEmployee());
        setUserId(reply.getOldEmployee().getUserId());
    }

    @Override
    public String toString() {
        return "UpdateUserSagaData [id=" + id + ", firstName=" + firstName + ", matricule=" + matricule + ", lastName=" + lastName + ", email=" + email + ", oldUser=" + oldEmployee
                + "]";
    }

}
