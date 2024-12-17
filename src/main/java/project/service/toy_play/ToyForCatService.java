package project.service.toy_play;

import project.enums.items.toys.ToysForCats;
import project.enums.pets.pet_model.PetCat;
import project.enums.pets.pet_model.PetModel;

import java.util.EnumSet;

public class ToyForCatService extends ToyForPet<ToysForCats> {
    private final PetCat petModel;

    public ToyForCatService(Class<ToysForCats> clazz, PetModel petModel) {
        super(clazz);
        super.getToySet().add(ToysForCats.CATNIP_MICE); //it has a catnip
        this.petModel = (PetCat) petModel;
    }

    @Override
    public void updateToySetInPet(EnumSet<ToysForCats> toySet) {
        petModel.setFavToys(getToySet());
    }
}
