package project.service.toy_play;

import project.model.indicators.statuses.WellBeingStatuses;
import project.model.mood.MoodTypes;
import project.model.pets.PetModel;

import java.util.EnumSet;

public abstract class ToyForPet<T extends Enum<T>> implements ToyPlay<T>{
    private final EnumSet<T> toysForPet;
    private final PetModel<T> petModel;

    public ToyForPet(Class<T> clazz, PetModel<T> petModel) {
        RandomFavToys<T> randomFavToys = new RandomFavToys();
        this.toysForPet = randomFavToys.chooseRandomFavToys(clazz);
        this.petModel = petModel;
    }

    @Override
    public MoodTypes giveToy(T toy, WellBeingStatuses wellBeingStatus, EnumSet<T> toysSet) {
        return ToyPlay.super.giveToy(toy, wellBeingStatus, toysForPet);
    }
}
