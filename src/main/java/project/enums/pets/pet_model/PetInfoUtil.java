package project.enums.pets.pet_model;

import project.enums.pets.LevelOfPets;
import project.enums.pets.PetType;
import project.exceptions.OperationNotSuccessException;

public final class PetInfoUtil {
    private static LevelOfPets level;
    private static PetType petType;

    private PetInfoUtil() {
        throw new IllegalCallerException("Object of class can't be implemented");
    }

    public static void init(PetModel petModel) {
        if(level == null && petType == null) {
            level = petModel.getLevel();
            petType = petModel.getPetType();
            return;
        }
        throw new OperationNotSuccessException("Pet info already exist");
    }

    public static LevelOfPets getLevel() {
        return level;
    }

    public static PetType getPetType() {
        return petType;
    }
}
