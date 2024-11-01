package project.service.feeding.treating;

import project.enums.items.food.treats.FoodTreatsForFerrets;
import project.enums.pets.pet_model.PetFerret;
import project.enums.pets.pet_model.PetModel;

//Extends skeletal TreatForPet class to minimize code
public final class TreatForFerretService extends TreatForPet<FoodTreatsForFerrets> {
    private final PetFerret petModel;

    public TreatForFerretService(Class<FoodTreatsForFerrets> clazz, PetModel petModel) {
        super(clazz);
        this.petModel = (PetFerret) petModel;
    }

    @Override
    public void updateTreatSetInPet() {
        petModel.setFavTreats(getTreatSet());
    }
}
