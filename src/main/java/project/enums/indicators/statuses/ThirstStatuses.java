package project.enums.indicators.statuses;

public enum ThirstStatuses {
    HYDRATED(60),
    THIRSTY(30),
    DEHYDRATED(20);

    private final int threshold;

    ThirstStatuses(int threshold) {
        this.threshold = threshold;
    };

    public int getThreshold() {
        return threshold;
    }
}
