package project.service.feeding.treating;

import project.model.items.food.treats.FoodTreatsForCats;

//Extends skeletal TreatForPet class to minimize code
public final class TreatForCatService extends TreatForPet<FoodTreatsForCats> {

    public TreatForCatService(Class<FoodTreatsForCats> clazz) {
        super(clazz);
        super.getTreatSet().add(FoodTreatsForCats.CATNIP); //no matter what must be in the Set
    }
}
