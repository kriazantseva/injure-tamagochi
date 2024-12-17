package project;

import project.enums.indicators.statuses.WellBeingStatuses;
import project.enums.items.food.treats.FoodTreatsForCats;
import project.enums.mood.MoodGenerator;
import project.enums.pets.LevelOfPets;
import project.enums.pets.PetType;
import project.enums.pets.pet_model.PetCat;
import project.enums.pets.pet_model.PetInfoUtil;
import project.service.PetSimulator;
import project.service.feeding.treating.Treat;
import project.service.feeding.treating.TreatForCatService;

public class Main {
    public static void main(String[] args) {
//        PetCat cat = new PetCat(LevelOfPets.MEDIUM, PetType.CAT);
//        MoodGenerator moodGenerator = new MoodGenerator();
//
//        PetSimulator petSimulator = new PetSimulator(moodGenerator);
//        petSimulator.simulate(cat.getLevel());
//
//        TreatForCatService catTreat = new TreatForCatService(FoodTreatsForCats.class, cat);
//        System.out.println(catTreat.giveTreat(FoodTreatsForCats.CATNIP, petSimulator.getWellBeingStatus(), null, moodGenerator));
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

//        MoodGenerator moodGenerator = new MoodGenerator();
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

//        System.out.println(FoodDietRandomizer.getRandomNeutralDiet());

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

//        Treat<FoodTreatsForFerrets> treat = new TreatForFerretService(FoodTreatsForFerrets.class);
//        System.out.println(treat.giveTreat(FoodTreatsForFerrets.MICE, WellBeingStatuses.GOOD, null));
//        System.out.println(treat.getTreatSet());
//
//        Treat<FoodTreatsForCats> treatCat = new TreatForCatService(FoodTreatsForCats.class);
//        System.out.println(treatCat.giveTreat(FoodTreatsForCats.CATNIP, WellBeingStatuses.GOOD, null));
//        System.out.println(treatCat.getTreatSet());
//
//        Treat<FoodTreatsForDogs> treatDog = new TreatForDogService(FoodTreatsForDogs.class);
//        System.out.println(treatDog.giveTreat(FoodTreatsForDogs.YOGURT, WellBeingStatuses.GOOD, null));
//        System.out.println(treatDog.getTreatSet());

//        PetCat cat = new PetCat(LevelOfPets.EASY, PetType.CAT);
//        PetInfoUtil.init(cat);
//        Treat<FoodTreatsForCats> treatService = new TreatForCatService(FoodTreatsForCats.class, cat);
//        treatService.updateTreatSetInPet();
//        System.out.println(treatService.giveTreat(FoodTreatsForCats.TUNA_BITES, WellBeingStatuses.GOOD, null));
//        System.out.println(treatService.getTreatSet());
//        System.out.println(cat.getFavTreats());
    }
}
