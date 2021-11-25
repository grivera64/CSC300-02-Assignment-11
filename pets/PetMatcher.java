//package assignment11.pets;

/*
 *
 * Name: Addable.java
 * Purpose: Functional interface for adding values
 *          via lambda expressions
 * Author: grivera64
 * Date: 11/28/2021
 *
 */

import java.util.List;

public interface PetMatcher {

    List<Pet> matchPet(Pet pet);

    default Pet firstPet(Pet pet) {

        int index = Pet.pets.indexOf(pet);

        if (index < 0) {

            return null;

        } else {

            return Pet.pets.get(index);

        }

    }

}
