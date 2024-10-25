package project.model.indicators.statuses;

public enum WellBeingStatuses {
    EXCELLENT(7),
    GOOD(6),
    FAIR(5),
    TIRED(4),
    UNWELL(3),
    SICK(2),
    DEAD(1);

    private final int threshold;

    WellBeingStatuses(int threshold) {
        this.threshold = threshold;
    };

    public int getThreshold() {
        return threshold;
    }
}
