package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.Delivery;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.dtos.request.DeliveryRegistrationRequest;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.repository.DeliveryRepository;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.DeliveryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final PackServiceImpl packService;

    private final DeliveryRepository deliveryRepository;

    private final TaxCalculationServiceImpl taxCalculationService;

    public List<Delivery> listAll() {
        return deliveryRepository.findAll();

    }


    @Override
    @Transactional
    public Delivery deliveryRegistration(DeliveryRegistrationRequest data) {
        var delivery = new Delivery(data);
        delivery.setDeliveryTax(taxCalculationService.calculateTax(data));
        delivery.setCode(this.generateDeliveryCode());

         data.packDimensions().forEach(e -> {
                        var pack  = packService.register(e);
                        pack.setDelivery(delivery);
                        delivery.addPack(pack);                                      
                      });
        return deliveryRepository.save(delivery);        
    }

    private String generateDeliveryCode(){
        var deliveryCode = UUID.randomUUID().toString();
        return deliveryCode;
    }


}
