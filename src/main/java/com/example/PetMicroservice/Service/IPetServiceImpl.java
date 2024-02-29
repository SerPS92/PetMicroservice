package com.example.PetMicroservice.Service;

import com.example.PetMicroservice.Model.Pet;
import com.example.PetMicroservice.Repository.IPetRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPetServiceImpl implements IPetService {

    private final IPetRepo petRepo;

    public IPetServiceImpl(IPetRepo petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public List<Pet> findAll() {
        return petRepo.findAll();
    }

    @Override
    public Pet showByType(String type) {
        return petRepo.findByType(type);
    }

    @Override
    public void delete(int id) {
        petRepo.deleteById(id);
    }

    @Override
    public void update(Pet pet) {
        if (petRepo.findById(pet.getId()).isPresent()) {
            petRepo.save(pet);
        }

    }

    @Override
    public boolean addPet(Pet pet) {
        if (petRepo.findById(pet.getId()).isEmpty()) {
            petRepo.save(pet);
            return true;
        }
        return false;
    }
}
