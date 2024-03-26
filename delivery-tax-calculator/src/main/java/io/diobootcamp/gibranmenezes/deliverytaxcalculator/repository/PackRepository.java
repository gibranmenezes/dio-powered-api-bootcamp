package io.diobootcamp.gibranmenezes.deliverytaxcalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;


public interface PackRepository extends JpaRepository<Pack, Long> {

    

}
