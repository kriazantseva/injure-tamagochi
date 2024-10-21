package project.model.indicators.statuses;

public enum EnergyStatuses {
    ENERGETIC(70),
    NEUTRAL(50),
    TIRED(30),
    EXHAUSTED(10);

    private final int threshold;

    EnergyStatuses(int threshold) {
        this.threshold = threshold;
    };

    public int getThreshold() {
        return threshold;
    }
}
