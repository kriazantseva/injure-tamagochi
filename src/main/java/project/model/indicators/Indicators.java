package project.model.indicators;

import project.model.indicators.statuses.EnergyStatuses;
import project.model.indicators.statuses.HungerStatuses;

/*індикатори самопочуття, які впливають на стан тваринки*/
public enum Indicators implements getStatusProcess {
    HUNGER (100) {
        /*динамічна зміна статусів голоду
        * @param currentValue приймає поточне значення індикатору голоду
        * @return повертає статус*/
        @Override
        public HungerStatuses getStatus(int currentValue) {
            HUNGER.checkCurrentValue(currentValue); //перевірка валідності поточного значення
            for (HungerStatuses status : HungerStatuses.values()) {
                if (currentValue >= status.getThreshold()) {
                    return status;
                }
            }
            return HungerStatuses.EXHAUSTED; // Якщо поточне значення нижче всіх порогів
        }
    },
    WELL_BEING(100) {
        /*єдиний індикатор, який не має підстатусів та повертає числовий показник*/
        @Override
        public Object getStatus(int currentValue) {
            Integer status = currentValue;
            return status;
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
            return EnergyStatuses.EXHAUSTED; // Якщо поточне значення нижче всіх порогів
        }
    };
//    MOOD (6) {
//        @Override
//        public Object getStatus(int currentValue) {
//            return null;
//        }
//
//        public enum MoodStatuses {
//            HAPPY,
//            INSPIRED,
//            INDIFFERENT,
//            WARY,
//            SAD,
//            ANGRY
//        }
//    },
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
            return 1; //в майбутньому буде особливий статус
        }
        return currentValue;
    }
}
