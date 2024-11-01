package project.service.feeding;

import project.enums.items.food.FoodItems;
import project.enums.items.food.WaterItem;
import project.enums.mood.MoodTypes;

public interface Feeding {
    void feeding(FoodItems food);

    MoodTypes impactOnMood(FoodItems food);

    void giveWater(WaterItem water);
}
