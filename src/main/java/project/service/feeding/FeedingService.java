package project.service.feeding;

import project.enums.indicators.Indicators;
import project.enums.items.food.FoodItems;
import project.enums.items.food.WaterItem;
import project.enums.items.food.food_diet.DislikedFoodDiet;
import project.enums.items.food.food_diet.LikedFoodDiet;
import project.enums.items.food.food_diet.NeutralFoodDiet;
import project.enums.mood.MoodGenerator;
import project.enums.mood.MoodTypeClusters;
import project.enums.mood.MoodTypes;
import project.enums.pets.LevelOfPetsHandler;

/**
 * FeedingService class implements the Feeding interface and provides functionality
 * to feed a pet based on their food preferences and impact their mood based on the food type.
 * This class contains three diet categories: Liked, Neutral, and Disliked, each affecting
 * the pet's hunger and mood differently.
 *
 * <p>Usage:</p>
 * FeedingService manages feeding and mood impact processes for various types of foods.
 * - When a pet is fed a liked food, the hunger level increases significantly.
 * - Neutral foods increase hunger at a standard rate.
 * - Disliked foods may decrease mood, with a chance the pet will refuse to eat.
 */
public class FeedingService implements Feeding {
    /** Constant representing the refusal to eat disliked food. */
    private static final int REFUSE_TO_EAT = 0;
    private final NeutralFoodDiet neutralFood = FoodDietRandomizer.getRandomNeutralDiet();
    private final LikedFoodDiet likedFood = FoodDietRandomizer.getLikedDiet();
    private final DislikedFoodDiet dislikedFood = FoodDietRandomizer.getDislikedDiet();

    /**
     * Processes feeding for the given food item, adjusting the hunger indicator based on food type.
     *
     * <p>If the food item is liked, hunger increases with a multiplier.
     * If it is neutral, hunger increases at the base rate.
     * If it is disliked, there is a chance the pet will refuse the food.</p>
     *
     * @param food The food item to feed to the pet.
     */
    @Override
    public void feeding(FoodItems food) {
        double foodIndex = 1;
        // Liked food gives a higher hunger increase
        if(likedFood != null && likedFood.init().contains(food)) {
            foodIndex = likedFood.getIndex();
            System.out.println("This food is liked one=)");
            feedingProcess((int) (food.getPointsOfSaturation() * foodIndex));
            System.out.println("Indicator raised on: " + (int) (food.getPointsOfSaturation() * foodIndex) + " points!");
            return;
        }
        // Neutral food gives a standard hunger increase
        if(neutralFood.init() != null && neutralFood.init().contains(food)) {
            feedingProcess((int) (food.getPointsOfSaturation() * foodIndex));
            return;
        }
        // Disliked food might be refused or slightly increase hunger
        if(checkDislikedFood(food)) {
            if(FoodRefuseRandomizer.chanceOfRefuseDefault()) {
                feedingProcess(REFUSE_TO_EAT);
                System.out.println("I'm done.. I don't want to eat this shit>:(");
                return;
            }
            feedingProcess((int) (food.getPointsOfSaturation() * foodIndex));
        }
    }

    /**
     * Determines the impact of a given food item on the pet's mood.
     *
     * <p>If the food item is disliked, the pet's mood is set to a negative or depressive state.</p>
     *
     * @param food The food item whose effect on mood is to be determined.
     * @return The updated MoodType after feeding.
     */
    @Override
    public MoodTypes impactOnMood(FoodItems food) {
        MoodGenerator moodGenerator = new MoodGenerator();
        if(checkDislikedFood(food)) {
            moodGenerator.setMoodMap(getRandomNegativeOrDepressiveMoodType());
            System.out.println("Oh... Discusting..");
        }
        return moodGenerator.getMoodMap();
    }

    /**
     * Processes give water for the only one existing water item, adjusting the thirst indicator.
     *
     * @param water The water item to give water to the pet.
     */
    @Override
    public void giveWater(WaterItem water) {
        giveWaterProcess(water.getPoints());
    }

    /**
     * Checks if the given food item belongs to the disliked diet category.
     *
     * @param food The food item to check.
     * @return true if the food is disliked; false otherwise.
     */
    private boolean checkDislikedFood(FoodItems food) {
        return dislikedFood != null && dislikedFood.init().contains(food);
    }

    /**
     * Selects a random mood type from negative or depressive clusters.
     *
     * @return A random MoodType from mildly negative, strongly negative, or depressive clusters.
     */
    private MoodTypes getRandomNegativeOrDepressiveMoodType() {
        MoodGenerator moodGenerator = new MoodGenerator();
        return moodGenerator.getRandomMoodFromUpdatedRandomMap(
                MoodTypeClusters.MILDLY_NEGATIVE,
                MoodTypeClusters.STRONGLY_NEGATIVE,
                MoodTypeClusters.DEPRESSIVE
        );
    }

    /**
     * Updates the pet's hunger indicator based on the feeding process and the type of food consumed.
     *
     * @param points The points to increase hunger by, calculated based on food type.
     */
    private void feedingProcess(int points) {
        LevelOfPetsHandler.INCREASE.updateIndicatorValue(
                Indicators.HUNGER, points,
                LevelOfPetsHandler.INCREASE
        );
    }

    /**
     * Updates the pet's thirst indicator based on the give water process and the type of food consumed.
     *
     * @param points The points to increase thirst by, calculated based on food type.
     */
    private void giveWaterProcess(int points) {
        LevelOfPetsHandler.INCREASE.updateIndicatorValue(
                Indicators.THIRST, points,
                LevelOfPetsHandler.INCREASE
        );
    }
}
