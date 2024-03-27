package io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.dtos.request;

import java.util.List;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.enums.DeliveryType;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackRegistrationRequest;

public record DeliveryRegistrationRequest(String addressUF, DeliveryType deliveryType, List<PackRegistrationRequest> packDimensions) {

}
