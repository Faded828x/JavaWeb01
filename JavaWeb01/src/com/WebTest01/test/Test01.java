package com.WebTest01.test;

import com.WebTest01.domain.Pet;
import com.WebTest01.service.Impl.PetServiceImpl;
import com.WebTest01.service.PetService;
import com.WebTest01.util.ServiceFactory;

public class Test01 {
    public static void main(String[] args) {
        PetService petService = (PetService) ServiceFactory.getService(new PetServiceImpl());
        Pet pet = new Pet("ttt", "S", 9999);
        petService.deletePet(pet);
    }
}
