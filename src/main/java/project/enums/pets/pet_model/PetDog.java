package project.enums.pets.pet_model;

import project.enums.items.food.treats.FoodTreatsForDogs;
import project.enums.items.toys.ToysForDogs;
import project.enums.pets.LevelOfPets;
import project.enums.pets.PetType;

import java.util.EnumSet;

public class PetDog extends PetModel {
    private EnumSet<FoodTreatsForDogs> favTreats;
    private EnumSet<ToysForDogs> favToys;

    public PetDog(LevelOfPets level, PetType petType) {
        super(level, petType);
    }

    public EnumSet<FoodTreatsForDogs> getFavTreats() {
        return favTreats;
    }

    public void setFavTreats(EnumSet<FoodTreatsForDogs> favTreats) {
        this.favTreats = favTreats;
    }

    public EnumSet<ToysForDogs> getFavToys() {
        return favToys;
    }

    public void setFavToys(EnumSet<ToysForDogs> favToys) {
        this.favToys = favToys;
    }
}
