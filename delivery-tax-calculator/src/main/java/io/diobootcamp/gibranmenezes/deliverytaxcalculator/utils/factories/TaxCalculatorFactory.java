package io.diobootcamp.gibranmenezes.deliverytaxcalculator.utils.factories;

import org.springframework.stereotype.Component;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.TaxCalulatorService;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.impl.CommomDeliveryTaxCalulatorService;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.impl.ExpressDeliveryTaxCalculatorService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TaxCalculatorFactory {

    private final ExpressDeliveryTaxCalculatorService expressDeliveryTaxservice;
    private final CommomDeliveryTaxCalulatorService commomDeliveryTaxCalulatorService;


    public TaxCalulatorService getTaxCalulatorService(String deliveryType) {
        switch (deliveryType) {
            case "COMMOM":
                return commomDeliveryTaxCalulatorService;
                        
            case "EXPRESS":
                return expressDeliveryTaxservice;
        
            default:
            throw new IllegalArgumentException("Delivery type not suported" + deliveryType);
        }
    }

}
