//package assignment11.pets;

/*
 *
 * Name: Pet.java
 * Purpose: Represents a Single Pet
 * Author: grivera64
 * Date: 11/28/2021
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Pet {

    public static List<Pet> pets = new ArrayList<>();

    private String name;
    private String animal;
    private String breed;
    private String color;
    private double price;

    public Pet() {}

    public Pet(String name, String animal, String breed, String color, double price) {

        this.setName(name);
        this.setAnimal(animal);
        this.setBreed(breed);
        this.setColor(color);
        this.setPrice(price);

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return this.name;

    }

    public void setAnimal(String animal) {

        this.animal = animal;

    }

    public String getAnimal() {

        return this.animal;

    }

    public void setBreed(String breed) {

        this.breed = breed;

    }

    public String getBreed() {

        return this.breed;

    }

    public void setColor(String color) {

        this.color = color;

    }

    public String getColor() {

        return this.color;

    }

    public void setPrice(double price) {

        this.price = price;

    }

    public double getPrice() {

        return this.price;

    }

    public String toString() {

        return String.format("%s: a %s %s %s purchased for $%.2f",
                this.getName(), this.getColor(), this.getBreed(), this.getAnimal(), this.getPrice());

    }

    public boolean equals(Object o) {

        if (!(o instanceof Pet)) {

            return false;

        }

        Pet pet = (Pet) o;
        return this.animal.equals(pet.animal) && this.breed.equals(pet.breed);

    }

}
