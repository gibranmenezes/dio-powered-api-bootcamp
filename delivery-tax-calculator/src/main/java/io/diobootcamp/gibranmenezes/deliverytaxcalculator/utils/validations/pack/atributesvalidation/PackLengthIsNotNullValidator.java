package io.diobootcamp.gibranmenezes.deliverytaxcalculator.utils.validations.pack.atributesvalidation;

import org.springframework.stereotype.Component;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackUpDateDTO;

@Component
public class PackLengthIsNotNullValidator implements PackAttributesValidator {

    @Override
    public void validate(PackUpDateDTO data, Pack pack) {
        if(data.lenght() != null) pack.setHeight(data.lenght());
    }

}
