package project.service.feeding;

import project.enums.items.food.food_diet.DislikedFoodDiet;
import project.enums.items.food.food_diet.LikedFoodDiet;
import project.enums.items.food.food_diet.NeutralFoodDiet;
import project.enums.pets.LevelOfPets;
import project.enums.pets.pet_model.PetInfoUtil;
import project.enums.pets.pet_model.PetModel;
import project.enums.pets.PetType;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//Class for randomly choose liked, disliked and neutral food preference
public final class FoodDietRandomizer {
    private static final int RANDOM_INDEX = 1;
    private static final int MAX_INDEX = 3;
    private static final Random random = new Random();
    private static NeutralFoodDiet neutralFoodDiet;

    /*
    * First choose method is getRandomNeutralDiet
    *
    * @return static neutralFoodDiet
    * */
    public static NeutralFoodDiet getRandomNeutralDiet() {
        EnumSet<NeutralFoodDiet> neutralSet = EnumSet.allOf(NeutralFoodDiet.class);
        Map<Integer, NeutralFoodDiet> neutralMap = new HashMap<>();
        int index = 1;

        //Add extra constraints for ferrets cuz they can't like vegetables, it's not healthy for them
        if(PetInfoUtil.getPetType() == PetType.FERRET) {
            for(NeutralFoodDiet neutral : neutralSet) {
                if(neutral == NeutralFoodDiet.RANDOM ||
                        neutral == NeutralFoodDiet.VEGETARIAN ||
                        neutral == NeutralFoodDiet.FOOD_ENTHUSIAST ||
                        neutral == NeutralFoodDiet.GOURMAND ||
                        neutral == NeutralFoodDiet.NOT_MEAT_NOT_FISH) {
                    continue;
                }
                neutralMap.put(index, neutral);
                index++;
            }
        //Check if LevelOfPets equals to Hard level
        //if it is, include random diet in neutralMap
        } else if(PetInfoUtil.getLevel() == LevelOfPets.HARD) {
            //if it has Random index be chosen,
            // Random diet directly included into neutralFoodDiet
            if(chanceToGetRandomDiet()) {
                System.out.println("Chance was activated");
                return neutralFoodDiet = NeutralFoodDiet.RANDOM;
            }
            for(NeutralFoodDiet neutral : neutralSet) {
                neutralMap.put(index, neutral);
                index++;
            }
        } else {
            for(NeutralFoodDiet neutral : neutralSet) {
                if(neutral == NeutralFoodDiet.RANDOM) {
                    continue;
                }
                neutralMap.put(index, neutral);
                index++;
            }
        }

        Random random = new Random();
        neutralFoodDiet = neutralMap.get(random.nextInt(neutralMap.size()) + 1);
        System.out.println(neutralFoodDiet);
        return neutralFoodDiet;
    }

    /*
    * Choose LikedFoodDiet depends on neutralFoodDiet
    *
    * @return LikedFoodDiet if neutralFoodDiet has an analog
    * @return null if analog not exist
    * */
    public static LikedFoodDiet getLikedDiet() {
        EnumSet<LikedFoodDiet> likedSet = EnumSet.allOf(LikedFoodDiet.class);
        for (LikedFoodDiet liked : likedSet) {
            if(liked.toString().equals(neutralFoodDiet.toString())) {
                System.out.println(liked);
                return liked;
            }
        }
        System.out.println("Don`t have liked food");
        return null;
    }

    /*
    * Choose DislikedFoodDiet depends on neutralFoodDiet
    *
    * @return DislikedFoodDiet if neutralFoodDiet has an analog
    * @return null if analog not exist
    * */
    public static DislikedFoodDiet getDislikedDiet() {
        EnumSet<DislikedFoodDiet> dislikedSet = EnumSet.allOf(DislikedFoodDiet.class);
        for (DislikedFoodDiet disliked : dislikedSet) {
            if(disliked.toString().equals(neutralFoodDiet.toString())) {
                System.out.println(disliked);
                return disliked;
            }
        }
        System.out.println("Don't have disliked food");
        return null;
    }

    /*
    * return true in case the result match the random index
    * chance of random diet 33%
    * */
    private static boolean chanceToGetRandomDiet() {
        return random.nextInt(MAX_INDEX) == RANDOM_INDEX;
    }
}
