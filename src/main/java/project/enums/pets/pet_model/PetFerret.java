package project.enums.pets.pet_model;

import project.enums.items.food.treats.FoodTreatsForFerrets;
import project.enums.items.toys.ToysForFerrets;
import project.enums.pets.LevelOfPets;
import project.enums.pets.PetType;

import java.util.EnumSet;

public class PetFerret extends PetModel {
    private EnumSet<FoodTreatsForFerrets> favTreats;
    private EnumSet<ToysForFerrets> favToys;

    public PetFerret(LevelOfPets level, PetType petType) {
        super(level, petType);
    }

    public EnumSet<FoodTreatsForFerrets> getFavTreats() {
        return favTreats;
    }

    public void setFavTreats(EnumSet<FoodTreatsForFerrets> favTreats) {
        this.favTreats = favTreats;
    }

    public EnumSet<ToysForFerrets> getFavToys() {
        return favToys;
    }

    public void setFavToys(EnumSet<ToysForFerrets> favToys) {
        this.favToys = favToys;
    }
}
