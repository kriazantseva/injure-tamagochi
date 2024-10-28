package project.service.feeding;

import java.util.Random;

/*
* Food refuse randomizer works only with DislikedFoodDiet.class
* It has default chance of refuse 33%
*/
public final class FoodRefuseRandomizer {
    public static final int REFUSE = 1;
    public static  final int DEFAULT_MAX_INDEX = 2;
    private static final Random random = new Random();

    //return true in case the result match the refuse index
    public static boolean chanceOfRefuseDefault() {
        return random.nextInt(DEFAULT_MAX_INDEX) == REFUSE;
    }

    //method for individual chance of refuse
    //has its own max index
    public static boolean chanceOfRefuseCustom(int index) {
        return random.nextInt(index) == REFUSE;
    }
}
