package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service;

import java.util.List;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.Delivery;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.dtos.request.DeliveryRegistrationRequest;

public interface DeliveryService {

    Delivery deliveryRegistration(DeliveryRegistrationRequest data);

    List<Delivery> findAll();

    List<Delivery> findByDeliveryCode(String deliveryCode);

    List<Delivery> findById(long id);   

}
