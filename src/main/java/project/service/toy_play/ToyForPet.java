package project.service.toy_play;

import project.enums.indicators.statuses.WellBeingStatuses;
import project.enums.mood.MoodTypes;

import java.util.EnumSet;

public abstract class ToyForPet<T extends Enum<T>> implements ToyPlay<T>{
    private final EnumSet<T> toysForPet;

    public ToyForPet(Class<T> clazz) {
        RandomFavToys<T> randomFavToys = new RandomFavToys();
        this.toysForPet = randomFavToys.chooseRandomFavToys(clazz);
    }

    @Override
    public MoodTypes giveToy(T toy, WellBeingStatuses wellBeingStatus, EnumSet<T> toysSet) {
        return ToyPlay.super.giveToy(toy, wellBeingStatus, toysForPet);
    }

    @Override
    public EnumSet<T> getToySet() {
        return toysForPet;
    }
}
