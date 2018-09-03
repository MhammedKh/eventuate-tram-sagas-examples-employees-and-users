package com.sifast.employeeandusers.employees.common;

import com.sifast.employeeandusers.employees.domain.Employee;

public class UpdateEmployeeReply {

    private Employee oldEmployee;

    public UpdateEmployeeReply() {
    }

    public UpdateEmployeeReply(Employee oldEmployee) {
        super();
        this.oldEmployee = oldEmployee;
    }

    public Employee getOldEmployee() {
        return oldEmployee;
    }

    public void setOldEmployee(Employee oldEmployee) {
        this.oldEmployee = oldEmployee;
    }

}
