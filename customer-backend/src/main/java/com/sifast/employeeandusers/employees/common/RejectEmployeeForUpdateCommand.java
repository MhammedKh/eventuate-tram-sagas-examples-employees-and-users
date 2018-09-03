package com.sifast.employeeandusers.employees.common;

import com.sifast.employeeandusers.employees.domain.Employee;

import io.eventuate.tram.commands.common.Command;

public class RejectEmployeeForUpdateCommand implements Command {

    private int userId;

    private Employee oldEmployee;

    private boolean isRejectCreate;

    private boolean isRejectUpdate;

    public RejectEmployeeForUpdateCommand() {
    }

    public RejectEmployeeForUpdateCommand(Employee oldEmployee, boolean isRejectCreate, boolean isRejectUpdate) {
        super();
        this.oldEmployee = oldEmployee;
        this.isRejectCreate = isRejectCreate;
        this.isRejectUpdate = isRejectUpdate;
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

    public boolean isRejectCreate() {
        return isRejectCreate;
    }

    public void setRejectCreate(boolean isRejectCreate) {
        this.isRejectCreate = isRejectCreate;
    }

    public boolean isRejectUpdate() {
        return isRejectUpdate;
    }

    public void setRejectUpdate(boolean isRejectUpdate) {
        this.isRejectUpdate = isRejectUpdate;
    }

}