package com.WebTest01.service.Impl;

import com.WebTest01.dao.PetDao;
import com.WebTest01.domain.Pet;
import com.WebTest01.service.PetService;
import com.WebTest01.util.SqlSessionUtil;

import java.util.List;

public class PetServiceImpl implements PetService {
    //mybatis动态代理创建PetDao实现类
    private PetDao petDao = SqlSessionUtil.getSession().getMapper(PetDao.class);

    @Override
    public Pet getByName(String name) {
        return petDao.getByName(name);
    }

    @Override
    public List<Pet> getAll() {
        return petDao.getAll();
    }

    @Override
    public void insertPet(Pet pet) {
        petDao.insertPet(pet);
    }

    @Override
    public void updatePet(Pet pet) {
        petDao.updatePet(pet);
    }

    @Override
    public void deletePet(Pet pet) {
        petDao.deletePet(pet);
    }
}
