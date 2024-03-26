package io.diobootcamp.gibranmenezes.deliverytaxcalculator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;


import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackDetailDTO;
import io.diobootcamp.gibranmenezes.deliverytaxcalculator.domain.pack.PackRegistrationDTO;
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
    public ResponseEntity getPack(@PathVariable Long id) {
        var pack = packService.findPack(id);
        return ResponseEntity.ok(new PackDetailDTO(pack));
    }

    @GetMapping
    public ResponseEntity<List<PackDetailDTO>> getAllPacks(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(packService.listAll()
                .stream()
                .map(PackDetailDTO::new)
                .toList()
                );
    }

    @PostMapping
    public ResponseEntity createPack(@RequestBody PackRegistrationDTO data, UriComponentsBuilder uriBuilder){
        var pack = packService.register(data);
        var uri = uriBuilder.path("/packs/{id}").buildAndExpand(pack.getId()).toUri();

        return ResponseEntity.created(uri).body(new PackDetailDTO(pack));
    }

    @PutMapping
    public ResponseEntity modifyPack(@RequestBody PackUpDateDTO data) {
        var pack = packService.updatePack(data);
        return ResponseEntity.ok(new PackDetailDTO(pack));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removePack(@PathVariable Long id) {
        var pack = packService.findPack(id);
        packService.removePack(id);

        return ResponseEntity.noContent().build();
    }


    

}
