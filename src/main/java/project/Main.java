package project;

import project.model.items.food.FoodItems;
import project.model.items.food.food_diet.RandomFoodDiet;
import project.model.mood.MoodGenerator;
import project.service.feeding.Feeding;
import project.service.feeding.FeedingService;
import project.service.feeding.FoodDietRandomizer;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
//        PetSimulator petSimulator = new PetSimulator();
//        petSimulator.simulate(LevelOfPets.HARD);
//
//        System.out.println(LevelOfPetsStarter.indicatorsValues.keySet());

//        System.out.println(MoodTypeClusters.POSITIVE.init());
//        System.out.println(MoodTypeClusters.DEPRESSIVE.init());
//        System.out.println(LikedFoodDiet.FOOD_ENTHUSIAST.init());

//        System.out.println(LikedFoodDiet.PET_FOOD_LOVER.init());
//        System.out.println(DislikedFoodDiet.PET_FOOD_LOVER.init());
//        System.out.println(NeutralFoodDiet.PET_FOOD_LOVER.init());
//        System.out.println(NeutralFoodDiet.VEGETARIAN.init());

//        Feeding feedingService = new FeedingService();
//        feedingService.feeding(FoodItems.RABBIT);
//        System.out.println(feedingService.impactOnMood(FoodItems.RABBIT));

        MoodGenerator moodGenerator = new MoodGenerator();
//        System.out.println(moodGenerator.getRandomMoodFromMoodSet(MoodTypeClusters.DEPRESSIVE));
//        EnumSet<MoodTypes> init = MoodTypeClusters.MILDLY_NEGATIVE.init();
//        for (MoodTypes mood : init) {
//            System.out.println(mood.ordinal());
//        }

//        MoodTypeClusters randomMoodCluster = moodGenerator.getRandomMoodCluster(MoodTypeClusters.DEPRESSIVE,
//                MoodTypeClusters.STRONGLY_NEGATIVE, MoodTypeClusters.MILDLY_NEGATIVE);
//        System.out.println(randomMoodCluster);

//        System.out.println(moodGenerator.getRandomMoodFromUpdatedRandomMap(MoodTypeClusters.MILDLY_NEGATIVE,
//                MoodTypeClusters.DEPRESSIVE, MoodTypeClusters.STRONGLY_NEGATIVE));
//        EnumSet<NeutralFoodDiet> neutralSet = EnumSet.allOf(NeutralFoodDiet.class);
//        System.out.println(neutralSet);
//        for(int i = 0; i < 50; i++) {
//            System.out.println(FoodDietRandomizer.getRandomNeutralDiet());
//            System.out.println("----------");
//        }

//        System.out.println(FoodDietRandomizer.getRandomNeutralDiet());
//        System.out.println(FoodDietRandomizer.getLikedDiet());
//        System.out.println(FoodDietRandomizer.getDislikedDiet());

//        for(int i = 0; i < 50; i++) {
//            System.out.println(FoodDietRandomizer.getRandomNeutralDiet());
//            System.out.println(FoodDietRandomizer.getLikedDiet());
//            System.out.println(FoodDietRandomizer.getDislikedDiet());
//            System.out.println("----------");
//        }

//        Feeding feedingService = new FeedingService();
//        feedingService.feeding(FoodItems.RABBIT);
//        System.out.println(feedingService.impactOnMood(FoodItems.RABBIT));

        System.out.println(FoodDietRandomizer.getRandomNeutralDiet());

//        RandomFoodDiet.NEUTRAL.init();
//        for(int i = 0; i < 50; i++) {
//            EnumSet<FoodItems> neutralSet = RandomFoodDiet.neutralRandomSet;
//            System.out.println(neutralSet);
//            System.out.println("Neutral Set : " + neutralSet.size());
//            EnumSet<FoodItems> likedSet = RandomFoodDiet.likedRandomSet;
//            System.out.println(likedSet);
//            System.out.println("Liked Set : " + likedSet.size());
//            EnumSet<FoodItems> dislikedSet = RandomFoodDiet.dislikedRandomSet;
//            System.out.println(dislikedSet);
//            System.out.println("Disliked Set : " + dislikedSet.size());
//            for(FoodItems item : likedSet) {
//                if(neutralSet.contains(item)) {
//                    System.out.println("ALARM");
//                }
//                if(dislikedSet.contains(item)) {
//                    System.out.println("ALARMALARM");
//                }
//            }
//            System.out.println("----------");
//        }
    }
}
