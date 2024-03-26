package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery;

import java.util.List;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.enums.DeliveryType;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackRegistrationDTO;

public record DeliveryDetailDTO(long id, String senderUF, String recieverUF, DeliveryType deliveryType, List<Pack> packs) {

    public DeliveryDetailDTO(Delivery delivery){
        this(delivery.getId(), delivery.getSenderUF(), delivery.getRecieverUF(), 
       delivery.getDeliveryType(), delivery.getPacks());
    }
}
