package project.enums.indicators.wellbeing_dependency;

import project.enums.indicators.statuses.WellBeingStatuses;

public class WellBeingDependencies {
    /*this is the trick for WELL_BEING status changes*/
    /*the standalone method that checks current value, depends on levels of other indicators*/
    public int wellBeingCurrentValueChecker(int hungerValue, int energyValue, int thirstValue) {
        WellBeingStatuses wellBeingStatuses = WellBeingStatuses.DEAD;
        if (hungerValue >= 80 && energyValue >= 80 && thirstValue >= 70) {
            wellBeingStatuses = WellBeingStatuses.EXCELLENT;
        } else if ((hungerValue >= 60 || energyValue >= 60) && thirstValue >= 60) {
            wellBeingStatuses = WellBeingStatuses.GOOD;
        } else if ((hungerValue >= 40 || energyValue >= 50) && thirstValue >= 50) {
            wellBeingStatuses = WellBeingStatuses.FAIR;
        } else if (hungerValue >= 30 && energyValue >= 40 && thirstValue >= 30) {
            wellBeingStatuses = WellBeingStatuses.TIRED;
        } else if (hungerValue >= 20 || energyValue >= 20 || thirstValue >=  20) {
            wellBeingStatuses = WellBeingStatuses.UNWELL;
        } else if ((hungerValue >= 10 && energyValue >= 10) || thirstValue >= 10) {
            wellBeingStatuses = WellBeingStatuses.SICK;
        } else if (hungerValue < 5 || energyValue < 5 || thirstValue < 5) {
            wellBeingStatuses = WellBeingStatuses.DEAD;
        }
        return wellBeingStatuses.getThreshold();
    }
}
