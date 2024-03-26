package io.diobootcamp.gibranmenezes.deliverytaxcalculator.utils.validations.pack.atributesvalidation;

import org.springframework.stereotype.Component;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackUpDateDTO;

@Component
public class PackWidthIsNotNullValidator implements PackAttributesValidator {

    @Override
    public void validate(PackUpDateDTO data, Pack pack) {
        if(data.width() != null) pack.setHeight(data.width());
    }

}
