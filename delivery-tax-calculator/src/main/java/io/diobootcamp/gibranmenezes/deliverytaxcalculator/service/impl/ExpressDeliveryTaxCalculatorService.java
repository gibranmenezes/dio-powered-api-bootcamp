package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.TaxCalulatorService;

@Service
public class ExpressDeliveryTaxCalculatorService implements TaxCalulatorService {

    @Override
    public BigDecimal calculateTax(List<Pack> packs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateTax'");
    }

}
