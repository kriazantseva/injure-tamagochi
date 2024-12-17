package project.service.randomizer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class RandomFavThings<T extends Enum<T>> {
    public EnumSet<T> chooseRandomFavThing(Class<T> clazz, int maxIndex) {
        EnumSet<T> treatsSet = EnumSet.allOf(clazz);
        Map<Integer, T> treatsMap = new HashMap<>();
        int index = 1;
        for(T treat : treatsSet) {
            treatsMap.put(index, treat);
            index++;
        }
        Random random = new Random();
        EnumSet<T> newSet = EnumSet.noneOf(clazz);
        for(int i = 0; i < maxIndex; i++) {
            newSet.add(treatsMap.get(random.nextInt(treatsMap.size()) + 1));
        }
        return newSet;
    }
}
