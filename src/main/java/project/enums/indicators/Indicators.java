package project.enums.indicators;

import project.enums.indicators.statuses.ThirstStatuses;
import project.exceptions.NoSuchIndicatorException;
import project.enums.indicators.statuses.EnergyStatuses;
import project.enums.indicators.statuses.HungerStatuses;
import project.enums.indicators.statuses.WellBeingStatuses;

/*indicators that have impact on pet*/
public enum Indicators implements getStatusProcess {
    HUNGER (100) {
        /* Dynamic status update for hunger
         * @param currentValue accepts the current value of the hunger indicator
         * @return returns the status */
        @Override
        public HungerStatuses getStatus(int currentValue) {
            HUNGER.checkCurrentValue(currentValue);
            for (HungerStatuses status : HungerStatuses.values()) {
                if (currentValue >= status.getThreshold()) {
                    return status;
                }
            }
            return HungerStatuses.STARVING;
        }
    },
    WELL_BEING(7) {
        /*this is a special indicator that doesn't independent, it's level depends on levels of other indicators*/
        /*also this is an example of tiny minus of enums, if some constant is slightly different from other
        * constants, it has a trouble. Here was trouble with currentValue, which in Well_Being was redundant
        * and made it look pretty ugly, so I fall to some trick */
        @Override
        public Object getStatus(int currentValue) {
            WELL_BEING.checkCurrentValue(currentValue);
            for (WellBeingStatuses status : WellBeingStatuses.values()) {
                if (currentValue == status.getThreshold()) {
                    return status;
                }
            }
            throw new NoSuchIndicatorException("Indicator of well being has troubles");
//            WellBeingDependencies dependencies = new WellBeingDependencies();
//            return dependencies.wellBeingStatus();
        }
    },
    ENERGY(100) {
        @Override
        public EnergyStatuses getStatus(int currentValue) {
            ENERGY.checkCurrentValue(currentValue);
            for (EnergyStatuses status : EnergyStatuses.values()) {
                if (currentValue >= status.getThreshold()) {
                    return status;
                }
            }
            return EnergyStatuses.EXHAUSTED;
        }
    },
    THIRST(100) {
        @Override
        public ThirstStatuses getStatus(int currentValue) {
            THIRST.checkCurrentValue(currentValue);
            for (ThirstStatuses status : ThirstStatuses.values()) {
                if (currentValue >= status.getThreshold()) {
                    return status;
                }
            }
            return ThirstStatuses.DEHYDRATED;
        }
    };
//    CLEANLINESS(100) {
//        @Override
//        public Object getStatus(int currentValue) {
//            return null;
//        }
//
//        public enum CleanlinessStatus {
//            CLEAN(50),
//            DIRTY(10);
//
//            CleanlinessStatus(int Value) {};
//        }
//    };
    private final int maxValue;

    Indicators(int maxValue) {
        this.maxValue = maxValue;
    };

    public int getMaxValue() {
        return maxValue;
    }

    public int checkCurrentValue(int currentValue) {
        if (currentValue > maxValue) {
            System.out.println("Current value is greater than max value " + currentValue);
            return maxValue;
        }
        if (currentValue <= 0) {
            System.out.println("Sorry, your pet is dead now(((");
            return 1;
        }
        return currentValue;
    }
}
