package project.model.indicators.wellbeing_dependency;

import project.model.indicators.statuses.WellBeingStatuses;
import project.model.mood.MoodTypes;

public class WellBeingDependencies {
    private final MoodAndWellBeingDependencies moodAndWellBeingDependencies =
            new MoodAndWellBeingDependencies();
    /*this is the trick for WELL_BEING status changes*/
    /*the standalone method that checks current value, depends on levels of other indicators*/
    public int wellBeingCurrentValueChecker(int hungerValue, int energyValue) {
        WellBeingStatuses wellBeingStatuses = WellBeingStatuses.DEAD;
        if (hungerValue >= 80 && energyValue >= 80) {
            wellBeingStatuses = WellBeingStatuses.EXCELLENT;
        } else if (hungerValue >= 60 || energyValue >= 60) {
            wellBeingStatuses = WellBeingStatuses.GOOD;
        } else if (hungerValue >= 40 || energyValue >= 50) {
            wellBeingStatuses = WellBeingStatuses.FAIR;
        } else if (hungerValue >= 30 && energyValue >= 40) {
            wellBeingStatuses = WellBeingStatuses.TIRED;
        } else if (hungerValue >= 20 || energyValue >= 20) {
            wellBeingStatuses = WellBeingStatuses.UNWELL;
        } else if (hungerValue >= 10 && energyValue >= 10) {
            wellBeingStatuses = WellBeingStatuses.SICK;
        }
        return wellBeingStatuses.getThreshold();
    }
}
