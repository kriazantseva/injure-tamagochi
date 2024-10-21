package project.model.indicators.statuses;

public enum HungerStatuses {
    FULL(80),
    SATISFIED(60),
    SLIGHTLY_HUNGRY(40),
    HUNGRY(20),
    EXHAUSTED(10);

    private final int threshold;

    HungerStatuses(int threshold) {
        this.threshold = threshold;
    };

    public int getThreshold() {
        return threshold;
    }
}
