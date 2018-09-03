package com.sifast.employeeandusers.employees.common;

import com.sifast.employeeandusers.employees.domain.Employee;

import io.eventuate.tram.commands.common.Command;

public class RejectEmployeeForUpdateCommand implements Command {

    private int userId;

    private Employee oldEmployee;

    public RejectEmployeeForUpdateCommand() {
    }

    public RejectEmployeeForUpdateCommand(Employee oldEmployee) {
        super();
        this.oldEmployee = oldEmployee;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Employee getOldEmployee() {
        return oldEmployee;
    }

    public void setOldEmployee(Employee oldEmployee) {
        this.oldEmployee = oldEmployee;
    }

}