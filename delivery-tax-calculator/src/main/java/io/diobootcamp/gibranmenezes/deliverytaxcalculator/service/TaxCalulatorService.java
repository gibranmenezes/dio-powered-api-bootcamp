package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service;

import java.math.BigDecimal;
import java.util.List;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;

public interface TaxCalulatorService {

    BigDecimal calculateTax(List<Pack> packs);

}
