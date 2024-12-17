package project.enums.items.food;

public enum WaterItem {
    WATER(60);

    private final int points;

    WaterItem(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
