package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.Delivery;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.dtos.request.DeliveryRegistrationRequest;

public interface DeliveryService {

    //Delivery calculateTax(DeliveryRegistrationDTO data);

     Delivery save(DeliveryRegistrationRequest data);

     Delivery deliveryRegistration(DeliveryRegistrationRequest data);
    

}
