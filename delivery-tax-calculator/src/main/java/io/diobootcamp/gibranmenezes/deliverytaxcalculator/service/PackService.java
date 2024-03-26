package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service;

import java.util.List;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackRegistrationDTO;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackUpDateDTO;

public interface PackService {

    Pack register(PackRegistrationDTO data);

    List<Pack> listAll();

    Pack findPack(long id);

    Pack updatePack(long id, PackUpDateDTO data);

    void removePack(long id);

}
