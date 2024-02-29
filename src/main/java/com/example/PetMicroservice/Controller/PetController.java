package com.example.PetMicroservice.Controller;

import com.example.PetMicroservice.Model.Pet;
import com.example.PetMicroservice.Service.IPetService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    private final IPetService petService;

    public PetController(IPetService petService) {
        this.petService = petService;
    }

    @GetMapping(value = "pets", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pet>> show(){
        List<Pet> pets = petService.findAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("total", String.valueOf(pets.size()));
        return new ResponseEntity<List<Pet>>(pets, httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "pets/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> show(@PathVariable(name = "type")String type){
        return new ResponseEntity<>(petService.showByType(type), HttpStatus.OK);
    }

    @PostMapping(value = "pets", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addPet(@RequestBody Pet pet){
        if(petService.addPet(pet)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "pets", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Pet pet){
        petService.update(pet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "pets/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") int id){
        petService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
