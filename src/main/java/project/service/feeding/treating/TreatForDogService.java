package project.service.feeding.treating;

import project.enums.items.food.treats.FoodTreatsForDogs;
import project.enums.pets.pet_model.PetDog;
import project.enums.pets.pet_model.PetModel;

//Extends skeletal TreatForPet class to minimize code
public final class TreatForDogService extends TreatForPet<FoodTreatsForDogs> {
    private final PetDog petModel;

    public TreatForDogService(Class<FoodTreatsForDogs> clazz, PetModel petModel) {
        super(clazz);
        this.petModel = (PetDog) petModel;
    }

    @Override
    public void updateTreatSetInPet() {
        petModel.setFavTreats(getTreatSet());
    }
}
