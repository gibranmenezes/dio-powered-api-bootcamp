package io.diobootcamp.gibranmenezes.deliverytaxcalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
