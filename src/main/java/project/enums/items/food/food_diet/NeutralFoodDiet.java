package project.enums.items.food.food_diet;

import project.enums.items.food.FoodItems;

import java.util.EnumSet;

//Have no good or bad impact on the mood
public enum NeutralFoodDiet implements FoodItemsSet {
    PET_FOOD_LOVER {
        @Override
        public EnumSet<FoodItems> init() {
            return complementOfLikedAndDislikedSets(
                    LikedFoodDiet.PET_FOOD_LOVER.init(),
                    DislikedFoodDiet.PET_FOOD_LOVER.init()
            );
        }
    },
    MEET_FAN {
        @Override
        public EnumSet<FoodItems> init() {
            return complementOfLikedAndDislikedSets(
                    LikedFoodDiet.MEET_FAN.init(),
                    DislikedFoodDiet.MEET_FAN.init()
            );
        }
    },
    FISH_SOUL {
        @Override
        public EnumSet<FoodItems> init() {
            return complementOfLikedAndDislikedSets(
                    LikedFoodDiet.FISH_SOUL.init(),
                    DislikedFoodDiet.FISH_SOUL.init()
            );
        }
    },
    VEGETARIAN {
        @Override
        public EnumSet<FoodItems> init() {
            return complementOfLikedAndDislikedSets(
                    LikedFoodDiet.VEGETARIAN.init(),
                    DislikedFoodDiet.VEGETARIAN.init()
            );
        }
    },
    GOURMAND {
        @Override
        public EnumSet<FoodItems> init() {
            return complementOfLikedAndDislikedSets(
                    LikedFoodDiet.GOURMAND.init(),
                    DislikedFoodDiet.GOURMAND.init()
            );
        }
    },
    EXQUISITE_TASTE {
        @Override
        public EnumSet<FoodItems> init() {
            return complementOfLikedAndDislikedSets(
                    LikedFoodDiet.EXQUISITE_TASTE.init(),
                    DislikedFoodDiet.EXQUISITE_TASTE.init()
            );
        }
    },
    STRANGE_TASTE {
        @Override
        public EnumSet<FoodItems> init() {
            return complementOfLikedAndDislikedSets(
                    LikedFoodDiet.STRANGE_TASTE.init(),
                    DislikedFoodDiet.STRANGE_TASTE.init()
            );
        }
    },
    ONLY_BIRD {
        @Override
        public EnumSet<FoodItems> init() {
            return complementOfLikedAndDislikedSets(
                    LikedFoodDiet.ONLY_BIRD.init(),
                    DislikedFoodDiet.ONLY_BIRD.init()
            );
        }
    },
    NOT_MEAT_NOT_FISH {
        @Override
        public EnumSet<FoodItems> init() {
            return complementOfLikedAndDislikedSets(
                    LikedFoodDiet.NOT_MEAT_NOT_FISH.init(),
                    DislikedFoodDiet.NOT_MEAT_NOT_FISH.init()
            );
        }
    },
    FOOD_NEUTRAL {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.allOf(FoodItems.class); //Have all food items
        }
    },
    FOOD_ENTHUSIAST {
        @Override
        public EnumSet<FoodItems> init() {
            return null;
        }
    },
    RANDOM {
        @Override
        public EnumSet<FoodItems> init() {
            return RandomFoodDiet.neutralRandomSet;
        }
    };

    /*
    *Method for calculating the missing items in two EnumSets to create a new EnumSet
    *@param EnumSet<FoodItems> LikedFoodItem.class
    *@param EnumSet<FoodItems> DislikedFoodItem.class
    *@return EnumSet<FoodItems>
    */
    private static EnumSet<FoodItems> complementOfLikedAndDislikedSets(
            EnumSet<FoodItems> liked, EnumSet<FoodItems> disliked
    ) {
        EnumSet<FoodItems> unitedSets = EnumSet.copyOf(liked);
        unitedSets.addAll(disliked);
        return EnumSet.complementOf(unitedSets);
    }
}
