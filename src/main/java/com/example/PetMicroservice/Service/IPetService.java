package com.example.PetMicroservice.Service;

import com.example.PetMicroservice.Model.Pet;

import java.util.List;

public interface IPetService {

    List<Pet> findAll();
    Pet showByType(String type);
    void delete(int id);
    void update(Pet pet);
    boolean addPet(Pet pet);
}
