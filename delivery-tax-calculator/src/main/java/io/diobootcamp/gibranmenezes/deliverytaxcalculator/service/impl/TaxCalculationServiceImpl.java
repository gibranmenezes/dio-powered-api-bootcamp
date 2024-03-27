package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.delivery.dtos.request.DeliveryRegistrationRequest;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackRegistrationRequest;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.TaxCalculationService;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.impl.DistanceServiceImpl;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaxCalculationServiceImpl /*implements TaxCalculationService*/ {

    private  final DistanceServiceImpl distanceService;   

    public  BigDecimal calculateTax(DeliveryRegistrationRequest data) {
        var taxRates = this.getTaxRates(data.deliveryType().name());
        var cubicWeight = this.getCubicWeight(data.packDimensions());
        var distance = this.getDistancy(data.addressUF());

        return cubicWeight.multiply(taxRates.get("cubicWeigthRate"))
                        .add(distance.multiply(taxRates.get("distanceRate")))
                        .setScale(2, RoundingMode.HALF_UP);
            
        
    }

    private BigDecimal getCubicWeight(List<PackRegistrationRequest> packDimensions) {
        return packDimensions.stream()
                        .map(this::calculateCubicWeightForDimension)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateCubicWeightForDimension(PackRegistrationRequest dimension){
        BigDecimal volume =  BigDecimal.valueOf(dimension.height() * dimension.width() * dimension.lenght());
        BigDecimal cubicWeigth = volume.divide(BigDecimal.valueOf(6000), 2, RoundingMode.HALF_UP);
        
        return cubicWeigth.compareTo(BigDecimal.TEN) < 0 ? BigDecimal.valueOf(dimension.weigth()) : cubicWeigth;
    }

    private BigDecimal getDistancy(String addressUF) {
        return distanceService.getDistance(addressUF); 
    }

    // private BigDecimal getDistance(String postalCode) {
    //     viaCepSerice.getUf(postalCode)
    // }

    private HashMap<String, BigDecimal> getTaxRates(String deliveryType) {
        var taxRates = new HashMap<String, BigDecimal>();

        switch (deliveryType) {
            case "COMMOM":
                taxRates.put("distanceRate", BigDecimal.valueOf(0.05));
                taxRates.put("cubicWeigthRate", BigDecimal.valueOf(0.02));                          
                break;
            case "EXPRESS":
                taxRates.put("distanceRate", BigDecimal.valueOf(0.08));
                taxRates.put("cubicWeigthRate", BigDecimal.valueOf(0.05));            
            break;        
            default:
                break;
        }

        return taxRates;

    }    
}
