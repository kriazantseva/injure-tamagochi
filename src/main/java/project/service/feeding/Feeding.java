package project.service.feeding;

import project.model.items.food.FoodItems;
import project.model.mood.MoodTypes;

public interface Feeding {
    void feeding(FoodItems food);
    MoodTypes impactOnMood(FoodItems food);
}
