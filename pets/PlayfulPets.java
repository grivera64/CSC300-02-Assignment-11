//package assignment11.pets;

/*
 *
 * Name: PlayfulPets.java
 * Purpose: Tests the PetMatcher functional interface with Pets
 * Author: grivera64
 * Date: 11/28/2021
 *
 */

import java.util.List;

public class PlayfulPets {

    public static void matchPet(String criteria, PetMatcher matcher, Pet myPet) {

        System.out.printf("%s:\n", criteria);
        System.out.printf("First: %s\n\n", matcher.firstPet(myPet));

        System.out.println("All matches:");
        List<Pet> matches = matcher.matchPet(myPet);
        for (Pet p : matches) {

            System.out.printf("%s\n", p);

        }

        System.out.println();

    }

    public static void main(String[] args) {

        Pet.pets.add(new Pet("Scruffy", "dog", "poodle", "white", 895.00));
        Pet.pets.add(new Pet("Meow", "cat", "siamese", "white", 740.25));
        Pet.pets.add(new Pet("Max", "dog", "poodle", "black", 540.50));
        Pet.pets.add(new Pet("Cuddles", "dog", "pug", "black", 1282.75));
        Pet.pets.add(new Pet("Slider", "snake", "garden", "green", 320.00));

        PetMatcher breedMatcher = (pet) ->
                Pet.pets.stream()
                        .filter((p) -> p.getBreed().equals(pet.getBreed()))
                        .toList();

        PetMatcher priceMatcher = new PetMatcher() {

            //@Override
            public List<Pet> matchPet(Pet pet) {

                return Pet.pets.stream()
                               .filter((p) -> p.getPrice() <= pet.getPrice() + 0.0001)
                               .toList();

            }

            //@Override
            public Pet firstPet(Pet pet) {

                for (Pet p : Pet.pets) {

                    if (p.getPrice() <= pet.getPrice() + 0.0001) {

                        return p;

                    }

                }

                return null;

            }

        };

        Pet tempPet = new Pet();
        tempPet.setBreed("poodle");
        tempPet.setAnimal("dog");
        tempPet.setPrice(800);

        PlayfulPets.matchPet("Poodles", breedMatcher, tempPet);
        PlayfulPets.matchPet("Pets for $800 or less", priceMatcher, tempPet);

    }

}
