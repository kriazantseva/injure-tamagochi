package project.model.items.food.food_diet;

import project.model.items.food.FoodItems;

import java.util.EnumSet;

/*Liked food have an index to increase Hunger indicator points
* It has chance to increase mood to positive set*/
public enum LikedFoodDiet implements FoodItemsSet {
    PET_FOOD_LOVER(1.5) {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.DRY_KIBBLE, FoodItems.CANNED_WET_FOOD);
        }
    },
    MEET_FAN(1.5) {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.CHICKEN, FoodItems.TURKEY,
                    FoodItems.RABBIT, FoodItems.BEEF);
        }
    },
    FISH_SOUL(1.5) {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.RIVER_FISH, FoodItems.SALMON);
        }
    },
    VEGETARIAN(1.8) {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.CARROT, FoodItems.SWEET_POTATO, FoodItems.GREEN_BEANS);
        }
    },
    GOURMAND(1.5) {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.SAUSAGE, FoodItems.EGG,
                    FoodItems.CANNED_WET_FOOD, FoodItems.SWEET_POTATO);
        }
    },
    EXQUISITE_TASTE(1.8) {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.RABBIT, FoodItems.SALMON);
        }
    },
    STRANGE_TASTE(1.5) {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.DRY_KIBBLE, FoodItems.GREEN_BEANS,
                    FoodItems.EGG);
        }
    },
    ONLY_BIRD(1.5) {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.CHICKEN, FoodItems.TURKEY);
        }
    },
    NOT_MEAT_NOT_FISH(2.0) {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.of(FoodItems.CARROT, FoodItems.EGG, FoodItems.SAUSAGE);
        }
    },
    FOOD_ENTHUSIAST(1.2) {
        @Override
        public EnumSet<FoodItems> init() {
            return EnumSet.allOf(FoodItems.class);
        }
    },
    RANDOM(2.0) {
        @Override
        public EnumSet<FoodItems> init() {
            return RandomFoodDiet.likedRandomSet;
        }
    };

    private final double index;

    LikedFoodDiet(double index) {
        this.index = index;
    }

    public double getIndex() {
        return index;
    }
}
