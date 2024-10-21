package project.model.pets;

import project.model.indicators.ChangeOfIndicators;
import project.model.indicators.Indicators;

public enum LevelOfPets implements ChangeOfIndicators {
    EASY() {
        @Override
        public int decreaseIndicatorsLevel(Indicators indicator) {
            return EASY.updateIndicatorValue(indicator, LevelOfPetsUtil.EASY_LEVEL_DECREASE);
        }
    },
    MEDIUM() {
        @Override
        public int decreaseIndicatorsLevel(Indicators indicator) {
            return MEDIUM.updateIndicatorValue(indicator, LevelOfPetsUtil.MEDIUM_LEVEL_DECREASE);
        }
    },
    HARD() {
        @Override
        public int decreaseIndicatorsLevel(Indicators indicator) {
            return HARD.updateIndicatorValue(indicator, LevelOfPetsUtil.HARD_LEVEL_DECREASE);
        }
    };

    // Окремі поля для поточних значень кожного індикатора
    private int hungerValue = Indicators.HUNGER.getMaxValue();
    private int energyValue = Indicators.ENERGY.getMaxValue();
    private int wellBeingValue = Indicators.WELL_BEING.getMaxValue();

    // Метод для оновлення значення індикатора залежно від рівня складності
    private int updateIndicatorValue(Indicators indicator, int levelDecrease) {
        int currentValue = getCurrentValueForIndicator(indicator); // Отримуємо поточне значення для відповідного індикатора
        currentValue = currentValueChanger(levelDecrease, currentValue); // Застосовуємо зменшення
        setCurrentValueForIndicator(indicator, currentValue); // Оновлюємо поточне значення

        return indicator.checkCurrentValue(currentValue); // Перевіряємо нове значення
    }

    // Отримуємо поточне значення для відповідного індикатора
    public int getCurrentValueForIndicator(Indicators indicator) {
        switch (indicator) {
            case HUNGER:
                return hungerValue;
            case ENERGY:
                return energyValue;
            case WELL_BEING:
                return wellBeingValue;
            default:
                throw new IllegalArgumentException("Unknown indicator: " + indicator);
        }
    }

    // Оновлюємо поточне значення для відповідного індикатора
    private void setCurrentValueForIndicator(Indicators indicator, int value) {
        switch (indicator) {
            case HUNGER:
                hungerValue = value;
                break;
            case ENERGY:
                energyValue = value;
                break;
            case WELL_BEING:
                wellBeingValue = value;
                break;
            default:
                throw new IllegalArgumentException("Unknown indicator: " + indicator);
        }
    }

    // Метод для динамічної зміни значення
    private int currentValueChanger(int levelDecrease, int currentValue) {
        int decreasedValue = currentValue - levelDecrease;
        return Math.max(decreasedValue, 0); // Захист від негативних значень
    }
}
