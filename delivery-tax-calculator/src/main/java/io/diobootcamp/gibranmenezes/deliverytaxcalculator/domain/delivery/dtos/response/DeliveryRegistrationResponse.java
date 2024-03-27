package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.dtos.response;

import java.math.BigDecimal;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.Delivery;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.enums.DeliveryType;

public record DeliveryRegistrationResponse (String deliveryCode, String addressUF, DeliveryType deliveryType, int packAmount, BigDecimal tax) {

    public DeliveryRegistrationResponse(Delivery delivery) {
        this(delivery.getCode(), delivery.getAddressUF(), delivery.getDeliveryType(), delivery.getPacks().size(), delivery.getDeliveryTax());

    }

    
}
