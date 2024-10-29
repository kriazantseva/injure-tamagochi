package project.service.feeding.treating;

import project.model.items.food.treats.FoodTreatsForFerrets;

//Extends skeletal TreatForPet class to minimize code
public final class TreatForFerretService extends TreatForPet<FoodTreatsForFerrets> {

    public TreatForFerretService(Class<FoodTreatsForFerrets> clazz) {
        super(clazz);
    }
}
