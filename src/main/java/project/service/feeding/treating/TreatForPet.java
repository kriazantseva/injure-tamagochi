package project.service.feeding.treating;

import project.enums.indicators.statuses.WellBeingStatuses;
import project.enums.mood.MoodTypes;

import java.util.EnumSet;

/*
*Skeletal implementation of Treat interface
*/
public abstract class TreatForPet<T extends Enum<T>> implements Treat<T> {
    //EnumSet of random chosen food treats
    private final EnumSet<T> treatsForPet;

    //constructor for generic flexibility, creates enum set
    //based on RandomFavTreat class, that have class parameter
    public TreatForPet(Class<T> clazz) {
        RandomFavTreat<T> randomFavTreat = new RandomFavTreat<>();
        treatsForPet = randomFavTreat.choseRandomFavTreat(clazz);
    }

    //return EnumSet of food treats
    @Override
    public EnumSet<T> getTreatSet() {
        return treatsForPet;
    }

    //implementation of giveTreat method from Treat<T extends Enum<T>> interface
    //use EnumSet<T> treatsForPet as parameter
    @Override
    public MoodTypes giveTreat(T treat, WellBeingStatuses wellBeingStatus, EnumSet<T> treatSet) {
        return Treat.super.giveTreat(treat, wellBeingStatus, treatsForPet);
    }
}
