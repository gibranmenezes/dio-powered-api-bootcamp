package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackDetailDTO;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackRegistrationDTO;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackUpDateDTO;

public interface PackService {

    void register(PackRegistrationDTO data);

    List<Pack> listAll();

    Pack findPack(long id);

    Pack updatePack(long id, PackUpDateDTO data);

    void removePack(long id);

}
