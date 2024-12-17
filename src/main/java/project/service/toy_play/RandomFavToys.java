package project.service.toy_play;

import project.service.randomizer.RandomFavThings;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

class RandomFavToys<T extends Enum<T>> {
    private static final int MAX_INDEX = 4;

    protected EnumSet<T> chooseRandomFavToys(Class<T> clazz) {
        RandomFavThings<T> randomFavThings = new RandomFavThings<>();
        return randomFavThings.chooseRandomFavThing(clazz, MAX_INDEX);
    }
}
