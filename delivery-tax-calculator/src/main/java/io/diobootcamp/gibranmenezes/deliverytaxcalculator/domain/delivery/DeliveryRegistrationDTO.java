package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery;

import java.util.List;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.enums.DeliveryPackDTO;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.enums.DeliveryType;

public record DeliveryRegistrationDTO(String senderUF, String recieverUF, DeliveryType deliveryType, List<DeliveryPackDTO> packIds) {

}
