package com.example.PetMicroservice.Model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "pets")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private int age;
}
