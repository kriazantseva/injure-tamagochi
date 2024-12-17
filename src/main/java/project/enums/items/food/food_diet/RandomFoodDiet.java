package project.enums.items.food.food_diet;

import project.enums.items.food.FoodItems;

import java.util.*;

/*
* Hard level food diet for hard level pet, generates randomly all types of food sets
* Has Neutral, Liked and Disliked food sets
*/
public enum RandomFoodDiet implements FoodItemsSet {
    NEUTRAL() {
        @Override
        public EnumSet<FoodItems> init() {
            EnumSet<FoodItems> allItemsSet = EnumSet.allOf(FoodItems.class);
            return randomFoodSet(allItemsSet);
        }
    },
    LIKED {
        @Override
        public EnumSet<FoodItems> init() {
            EnumSet<FoodItems> itemsSet = EnumSet.complementOf(neutralRandomSet);
            return randomFoodSet(itemsSet);
        }
    },
    DISLIKED {
        @Override
        public EnumSet<FoodItems> init() {
            EnumSet<FoodItems> itemsSet = EnumSet.copyOf(neutralRandomSet);
            itemsSet.addAll(likedRandomSet);
            return EnumSet.complementOf(itemsSet);
        }
    };

    public static final EnumSet<FoodItems> neutralRandomSet = NEUTRAL.init();
    public static final EnumSet<FoodItems> likedRandomSet = LIKED.init();
    public static final EnumSet<FoodItems> dislikedRandomSet = DISLIKED.init();

    private static final int MIN_BOUND = 2; //for set at least have 1 or 2 items
    private static final int MAX_BOUND = 6; //max line for  generating random index
    private static EnumSet<FoodItems> randomFoodSet(EnumSet<FoodItems> startFood) {
        Map<Integer, FoodItems> foodMap = mapOfFoodItems(startFood);
        EnumSet<FoodItems> newSet = null;
        Random random = new Random();
        int times = random.nextInt(MIN_BOUND, MAX_BOUND);
        for(int i = 0; i < times; i++) {
            if(newSet == null) {
                newSet = EnumSet.of(foodMap.get(random.nextInt(foodMap.size()) + 1));
                continue;
            }
            newSet.add(foodMap.get(random.nextInt(foodMap.size()) + 1));
        }
        System.out.println(newSet);
        return newSet;
    }

    private static Map<Integer, FoodItems> mapOfFoodItems(EnumSet<FoodItems> startFood) {
        Map<Integer, FoodItems> foodMap = new HashMap<>();
        int i = 1;
        for(FoodItems item : startFood) {
            foodMap.put(i, item);
            i++;
        }
        return foodMap;
    }
}
