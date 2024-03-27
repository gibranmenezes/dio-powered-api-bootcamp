package io.diobootcamp.gibranmenezes.deliverytaxcalculator.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.Delivery;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.dtos.request.DeliveryRegistrationRequest;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.dtos.response.DeliveryRegistrationResponse;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.impl.DeliveryServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryServiceImpl deliveryService;

    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        return ResponseEntity.status(HttpStatus.OK)
                    .body(deliveryService.listAll()
                    .stream()
                    .toList()
                );

    }

    @PostMapping()
    public ResponseEntity deliveryRegistration(@RequestBody DeliveryRegistrationRequest data, UriComponentsBuilder uriBuilder){
        var delivery = deliveryService.deliveryRegistration(data);

        var uri = uriBuilder.path("/deliveries/{id}")
                            .buildAndExpand(delivery.getId())
                            .toUri();
             
        return ResponseEntity.created(uri).body(new DeliveryRegistrationResponse(delivery));
    }


}
