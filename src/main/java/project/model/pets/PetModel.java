package project.model.pets;

import java.time.LocalDateTime;

public final class PetModel {
    private String petName;
    private LocalDateTime petAdoptDate;
    private String petDescription;
    private static LevelOfPets level = LevelOfPets.EASY;
    private static PetType petType;

    public static LevelOfPets getLevel() {
        return level;
    }

    public static PetType getPetType() {
        return petType;
    }
}
