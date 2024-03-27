package io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.impl;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.DistanceService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DistanceServiceImpl implements DistanceService{

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final JsonNode distanceData;

    static {
        try {
            distanceData = objectMapper.readTree(DistanceService.class.getResourceAsStream("/distances.json"));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo JSON", e);
        }
    }

    @Override
    public BigDecimal getDistance(String addressUf) {
        var distance = distanceData.get(addressUf);

        return distance != null ? distance.decimalValue() : BigDecimal.ZERO;
    }

}
