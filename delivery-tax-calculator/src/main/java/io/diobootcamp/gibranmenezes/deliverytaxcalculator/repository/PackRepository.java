package io.diobootcamp.gibranmenezes.deliverytaxcalculator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;


public interface PackRepository extends JpaRepository<Pack, Long> {

    @Query("SELECT p FROM Pack p WHERE p.delivery.id = :deliveryId")    
    List<Pack> findByDeliveryId(String deliveyId);

    @Query("SELECT p FROM Pack p WHERE p.delivery.code = :deliveryCode")    
    List<Pack> findByDeliveryCode(String deliveryCode);


}
