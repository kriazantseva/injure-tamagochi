package project.service.feeding.treating;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
* Class with private-package access for using only in treating package
*/
class RandomFavTreat<T extends Enum<T>> {
    private static final int MAX_INDEX = 2;

    protected EnumSet<T> choseRandomFavTreat(Class<T> clazz) {
        EnumSet<T> treatsSet = EnumSet.allOf(clazz);
        Map<Integer, T> treatsMap = new HashMap<>();
        int index = 1;
        for(T treat : treatsSet) {
            treatsMap.put(index, treat);
            index++;
        }
        Random random = new Random();
        EnumSet<T> newSet = EnumSet.noneOf(clazz);
        for(int i = 0; i < MAX_INDEX; i++) {
            newSet.add(treatsMap.get(random.nextInt(treatsMap.size()) + 1));
        }
        return newSet;
    }
}
