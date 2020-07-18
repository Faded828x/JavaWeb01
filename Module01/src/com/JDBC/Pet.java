package com.JDBC;

public class Pet {
    private String name;
    private String owner;
    private String species;
    private int age;

    public Pet() {
    }

    public Pet(String name, String owner, String species, int age) {
        this.name = name;
        this.owner = owner;
        this.species = species;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                '}';
    }
}
