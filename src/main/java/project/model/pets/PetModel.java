package project.model.pets;

import java.time.LocalDateTime;
import java.util.EnumSet;

public final class PetModel<E extends Enum<E>> {
    private String petName;
    private LocalDateTime petAdoptDate;
    private String petDescription;
    private static LevelOfPets level = LevelOfPets.EASY;
    private static PetType petType;
    private EnumSet<E> favTreats;

    public static LevelOfPets getLevel() {
        return level;
    }

    public static PetType getPetType() {
        return petType;
    }

    public EnumSet<E> getFavTreats() {
        return favTreats;
    }

    public void setFavTreats(EnumSet<E> favTreats) {
        this.favTreats = favTreats;
    }
}
