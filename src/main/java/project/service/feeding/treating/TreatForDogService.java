package project.service.feeding.treating;

import project.model.items.food.treats.FoodTreatsForDogs;

//Extends skeletal TreatForPet class to minimize code
public final class TreatForDogService extends TreatForPet<FoodTreatsForDogs> {

    public TreatForDogService(Class<FoodTreatsForDogs> clazz) {
        super(clazz);
    }
}
