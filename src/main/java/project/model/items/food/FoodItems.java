package project.model.items.food;

/*each food item has its point of saturation to increase hunger points*/
public enum FoodItems {
    DRY_KIBBLE(40),
    CANNED_WET_FOOD(40),
    CHICKEN(30),
    TURKEY(30),
    RABBIT(30),
    BEEF(30),
    RIVER_FISH(20),
    SALMON(20),
    CARROT(10),
    SWEET_POTATO(10),
    GREEN_BEANS(5),
    EGG(10),
    SAUSAGE(20);

    private final int pointsOfSaturation;

    FoodItems(int pointsOfSaturation) {
        this.pointsOfSaturation = pointsOfSaturation;
    }

    public int getPointsOfSaturation() {
        return pointsOfSaturation;
    }
}
