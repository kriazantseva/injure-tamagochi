package project.enums.pets.pet_model;

import project.enums.indicators.Indicators;
import project.enums.pets.LevelOfPets;
import project.enums.pets.LevelOfPetsStarter;
import project.enums.pets.PetType;

import java.time.LocalDateTime;
import java.util.EnumMap;

public class PetModel {
    private String petName;
    private final LocalDateTime petAdoptDate;
    private String petDescription;
    private final LevelOfPets level;
    private final PetType petType;
    private final EnumMap<Indicators, Integer> indicatorsValues;

    public PetModel(LevelOfPets level, PetType petType) {
        this.petAdoptDate = LocalDateTime.now();
        this.level = level;
        this.petType = petType;
        this.indicatorsValues = LevelOfPetsStarter.indicatorsValues;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public LevelOfPets getLevel() {
        return level;
    }

    public LocalDateTime getPetAdoptDate() {
        return petAdoptDate;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    public PetType getPetType() {
        return petType;
    }
}
