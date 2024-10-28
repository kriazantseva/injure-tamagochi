package project.model.items.food.food_diet;

import project.model.items.food.FoodItems;

import java.util.EnumSet;

/*Food types that have chance to decrease the mood*/
public enum DislikedFoodDiet implements FoodItemsSet {
    PET_FOOD_LOVER {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.BEEF, FoodItems.RIVER_FISH, FoodItems.CARROT);
        }
    },
    MEET_FAN {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.CARROT, FoodItems.SWEET_POTATO,
                    FoodItems.GREEN_BEANS);
        }
    },
    FISH_SOUL {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.RABBIT,
                    FoodItems.EGG, FoodItems.CARROT);
        }
    },
    VEGETARIAN {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.RABBIT, FoodItems.BEEF);
        }
    },
    GOURMAND {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.SALMON, FoodItems.GREEN_BEANS);
        }
    },
    EXQUISITE_TASTE {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.DRY_KIBBLE, FoodItems.RIVER_FISH,
                    FoodItems.CHICKEN);
        }
    },
    STRANGE_TASTE {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.SAUSAGE, FoodItems.CANNED_WET_FOOD);
        }
    },
    ONLY_BIRD {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.RABBIT, FoodItems.BEEF);
        }
    },
    NOT_MEAT_NOT_FISH {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.CHICKEN, FoodItems.TURKEY,
                    FoodItems.RABBIT, FoodItems.BEEF, FoodItems.RIVER_FISH,
                    FoodItems.SALMON);
        }
    },
    RANDOM {
        @Override
        public EnumSet<FoodItems> init() {
            return RandomFoodDiet.dislikedRandomSet;
        }
    }
}
