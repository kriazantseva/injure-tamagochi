package project.enums.pets.pet_model;

import project.enums.items.food.treats.FoodTreatsForCats;
import project.enums.items.toys.ToysForCats;
import project.enums.pets.LevelOfPets;
import project.enums.pets.PetType;

import java.util.EnumSet;

public class PetCat extends PetModel {
    private EnumSet<FoodTreatsForCats> favTreats;
    private EnumSet<ToysForCats> favToys;

    public PetCat(LevelOfPets level, PetType petType) {
        super(level, petType);
    }

    public EnumSet<FoodTreatsForCats> getFavTreats() {
        return favTreats;
    }

    public void setFavTreats(EnumSet<FoodTreatsForCats> favTreats) {
        this.favTreats = favTreats;
    }

    public EnumSet<ToysForCats> getFavToys() {
        return favToys;
    }

    public void setFavToys(EnumSet<ToysForCats> favToys) {
        this.favToys = favToys;
    }
}
