package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.Delivery;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.DeliveryRegistrationDTO;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.enums.DeliveryPackDTO;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.repository.DeliveryRepository;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.DeliveryService;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.PackService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final PackService packService;

    private final DeliveryRepository deliveryRepository;

    @Override
    @Transactional
    public Delivery save(DeliveryRegistrationDTO data) {
        var delivery = new Delivery(data);
             
        List<Pack> packs = packService.findAllById(
                        data.packIds()
                            .stream()
                            .map(DeliveryPackDTO::id)
                            .toList());
                            
        packs.forEach(e -> {
            delivery.addPack(e);
        });

        return deliveryRepository.save(delivery);
       
    }

    
    public List<Delivery> listAll() {
        return deliveryRepository.findAll();

    }






}
