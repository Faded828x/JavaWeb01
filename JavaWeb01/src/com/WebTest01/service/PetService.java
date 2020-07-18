package com.WebTest01.service;

import com.WebTest01.domain.Pet;

import java.util.List;

public interface PetService {

    public Pet getByName(String name);

    public List<Pet> getAll();

    public void insertPet(Pet pet);

    public void updatePet(Pet pet);

    public void deletePet(Pet pet);

}
