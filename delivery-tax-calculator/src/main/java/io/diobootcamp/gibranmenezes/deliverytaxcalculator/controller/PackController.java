package io.diobootcamp.gibranmenezes.deliverytaxcalculator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;


import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackDetailResponse;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackRegistrationDTO;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackRegistrationRequest;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackUpDateDTO;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.service.PackService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("packs")
@RequiredArgsConstructor
public class PackController {

    public final PackService packService;    

    @GetMapping("/{id}")     
    public ResponseEntity<PackDetailResponse> getPack(@PathVariable Long id) {
        var pack = packService.findPack(id);
        return ResponseEntity.ok(new PackDetailResponse(pack));
    }

    @GetMapping
    public ResponseEntity<List<PackDetailResponse>> getAllPacks(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(packService.listAll()
                .stream()
                .map(PackDetailResponse::new)
                .toList()
                );
    }

    @PostMapping
    public ResponseEntity createPack(@RequestBody PackRegistrationRequest data, UriComponentsBuilder uriBuilder){
        var pack = packService.register(data);
        var uri = uriBuilder.path("/packs/{id}").buildAndExpand(pack.getId()).toUri();

        return ResponseEntity.created(uri).body(new PackDetailResponse(pack));
    }

    @PutMapping
    public ResponseEntity modifyPack(@RequestBody PackUpDateDTO data) {
        var pack = packService.updatePack(data);
        return ResponseEntity.ok(new PackDetailResponse(pack));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removePack(@PathVariable Long id) {
        var pack = packService.findPack(id);
        packService.removePack(id);

        return ResponseEntity.noContent().build();
    }


    

}
