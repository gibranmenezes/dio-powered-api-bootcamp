package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.Pack;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackRegistrationRequest;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackUpDateDTO;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.repository.PackRepository;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.PackService;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.utils.validations.pack.atributesvalidation.PackAttributesValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PackServiceImpl implements PackService{

    private final PackRepository packRepository;

    private final List<PackAttributesValidator> attributeValidators;

    @Override
    @Transactional
    public Pack register(PackRegistrationRequest data) {
        var pack = new Pack(data);
        return packRepository.save(pack);
    }

    @Override
    public List<Pack> listAll() {
        return packRepository.findAll();
    }
    

    @Override
    public Pack findPack(long id) {
        var pack = packRepository.getReferenceById(id);
        return pack;        
    }

    @Override
    @Transactional
    public Pack updatePack(PackUpDateDTO data) {
        Pack pack = packRepository.getReferenceById(data.id());
        attributeValidators.forEach(v -> v.validate(data, pack));        
        var updatedPack = packRepository.save(pack);
        return updatedPack;
    }

    @Override
    @Transactional
    public void removePack(long id) {
        packRepository.getReferenceById(id);
    }

    @SuppressWarnings("null")
    @Override
    public List<Pack> findAllById(List<Long> packIds) {
        return packRepository.findAllById(packIds);  
    }

}
