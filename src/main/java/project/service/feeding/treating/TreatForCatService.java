package project.service.feeding.treating;

import project.enums.items.food.treats.FoodTreatsForCats;
import project.enums.pets.pet_model.PetCat;
import project.enums.pets.pet_model.PetModel;

//Extends skeletal TreatForPet class to minimize code
public final class TreatForCatService extends TreatForPet<FoodTreatsForCats> {
    private final PetCat petModel;

    public TreatForCatService(Class<FoodTreatsForCats> clazz, PetModel petModel) {
        super(clazz);
        super.getTreatSet().add(FoodTreatsForCats.CATNIP); //no matter what must be in the Set
        this.petModel = (PetCat) petModel;
    }

    @Override
    public void updateTreatSetInPet() {
        petModel.setFavTreats(getTreatSet());
    }
}
