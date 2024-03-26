package io.diobootcamp.gibranmenezes.deliverytaxcalculator.utils.validations.pack.atributesvalidation;

import org.springframework.stereotype.Component;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackUpDateDTO;

@Component
public class PackWeigthtIsNotNullValidator implements PackAttributesValidator {

    @Override
    public void validate(PackUpDateDTO data, Pack pack) {
        if(data.weigth() != null) pack.setHeight(data.weigth());
    }

}
