package project.model.indicators.wellbeing_dependency;

import project.model.indicators.Indicators;
import project.model.indicators.statuses.WellBeingStatuses;
import project.model.pets.LevelOfPetsStarter;

public class WellBeingDependencies {
//    private int hungerValue;
//    private int energyValue;
//
//    public WellBeingDependencies() {
//        this.hungerValue = LevelOfPetsStarter.indicatorsValues.get(Indicators.HUNGER);
//        this.energyValue = LevelOfPetsStarter.indicatorsValues.get(Indicators.ENERGY);
//    }
    /*this is the trick for WELL_BEING status changes*/
    /*the standalone method that checks current value, depends on levels of other indicators*/
    public int wellBeingCurrentValueChecker(int hungerValue, int energyValue) {
        if (hungerValue >= 80 && energyValue >= 80) {
            return WellBeingStatuses.EXCELLENT.getThreshold();
        } else if (hungerValue >= 60 || energyValue >= 60) {
            return WellBeingStatuses.GOOD.getThreshold();
        } else if (hungerValue >= 40 || energyValue >= 50) {
            return WellBeingStatuses.FAIR.getThreshold();
        } else if (hungerValue >= 30 && energyValue >= 40) {
            return WellBeingStatuses.TIRED.getThreshold();
        } else if (hungerValue >= 20 || energyValue >= 20) {
            return WellBeingStatuses.UNWELL.getThreshold();
        } else if (hungerValue >= 10 && energyValue >= 10) {
            return WellBeingStatuses.SICK.getThreshold();
        }
        return WellBeingStatuses.DEAD.getThreshold();
    }
}
