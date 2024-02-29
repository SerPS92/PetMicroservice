package com.example.PetMicroservice.Repository;

import com.example.PetMicroservice.Model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepo extends JpaRepository<Pet, Integer> {

    Pet findByType(String type);
}
