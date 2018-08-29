package io.eventuate.examples.tram.sagas.ordersandcustomers.customers.domain;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
