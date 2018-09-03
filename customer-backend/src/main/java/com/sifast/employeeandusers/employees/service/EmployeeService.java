package com.sifast.employeeandusers.employees.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sifast.employeeandusers.employees.domain.Employee;
import com.sifast.employeeandusers.employees.domain.EmployeeRepository;

@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Employee createOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findById(int employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    public Employee getEmployeeByUserId(int userId) {
        return (Employee) this.sessionFactory.getCurrentSession().createQuery("from Employee e where e.userId*:userId").setParameter(userId, userId).uniqueResult();
    }
}
