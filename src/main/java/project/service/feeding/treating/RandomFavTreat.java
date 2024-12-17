package project.service.feeding.treating;

import project.service.randomizer.RandomFavThings;

import java.util.EnumSet;

/*
* Class with private-package access for using only in treating package
*/
class RandomFavTreat<T extends Enum<T>> {
    private static final int MAX_INDEX = 2;

    protected EnumSet<T> choseRandomFavTreat(Class<T> clazz) {
        RandomFavThings<T> randomFavThings = new RandomFavThings<>();
        return randomFavThings.chooseRandomFavThing(clazz, MAX_INDEX);
    }
}
