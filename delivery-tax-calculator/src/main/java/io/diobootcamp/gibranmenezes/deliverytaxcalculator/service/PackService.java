package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service;

import java.util.List;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackRegistrationRequest;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackUpDateDTO;

public interface PackService {

    Pack register(PackRegistrationRequest data);

    List<Pack> listAllByDeliveryCode(String deliveryCode);
    
    Pack findPack(long id);

    Pack updatePack(PackUpDateDTO data);

    void removePack(long id);

}
