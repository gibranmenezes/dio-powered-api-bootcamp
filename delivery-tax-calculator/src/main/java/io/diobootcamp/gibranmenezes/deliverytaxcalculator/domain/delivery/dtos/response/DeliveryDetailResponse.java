package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.dtos.response;

import java.util.List;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.Delivery;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.enums.DeliveryType;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;

public record DeliveryDetailResponse(long id, String code, String addressUF, DeliveryType deliveryType, List<Pack> packs) {

    public DeliveryDetailResponse(Delivery delivery){
        this(delivery.getId(), delivery.getCode(), delivery.getAddressUF(), 
       delivery.getDeliveryType(), delivery.getPacks());
    }
}
