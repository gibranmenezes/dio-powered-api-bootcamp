package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.Delivery;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.DeliveryRegistrationDTO;

public interface DeliveryService {

    //Delivery calculateTax(DeliveryRegistrationDTO data);

     Delivery save(DeliveryRegistrationDTO data);
    

}
