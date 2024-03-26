package io.diobootcamp.gibranmenezes.deliverytaxcalculator.utils.validations.pack.atributesvalidation;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackUpDateDTO;

public interface PackAttributesValidator {

    void validate(PackUpDateDTO data, Pack pack);

}
