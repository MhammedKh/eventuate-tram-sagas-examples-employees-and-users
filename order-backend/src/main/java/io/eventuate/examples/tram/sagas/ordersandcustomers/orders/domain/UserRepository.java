package io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
