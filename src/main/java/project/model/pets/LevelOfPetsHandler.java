package project.model.pets;

import project.exceptions.NoSuchIndicatorException;
import project.exceptions.OperationNotSuccessException;
import project.model.indicators.Indicators;

public enum LevelOfPetsHandler {
    DECREASE,
    INCREASE;

    /*Method for getting current value for dynamically chosen indicator*/
    /*alternative for strategy pattern with switch case*/
    public int getCurrentValueForIndicator(Indicators indicator) {
        Integer value = LevelOfPetsStarter.indicatorsValues.get(indicator);
        if (value == null) {
            throw new NoSuchIndicatorException("Indicator " + indicator + " does not exist, try another");
        }
        return value;
    }

    /*Updating current value for dynamically chosen indicator*/
    public void setCurrentValueForIndicator(Indicators indicator, int value) {
        if (!LevelOfPetsStarter.indicatorsValues.containsKey(indicator)) {
            throw new NoSuchIndicatorException("Indicator " + indicator + " does not exist, try another");
        }
        LevelOfPetsStarter.indicatorsValues.put(indicator, value);
    }

    /*update current value of indicator, depending on kind of operation*/
    public int updateIndicatorValue(Indicators indicator, int levelChange, LevelOfPetsHandler changeType) {
        int currentValue = getCurrentValueForIndicator(indicator);
        /*check change type and choose operation method: increase or decrease*/
        if (changeType == LevelOfPetsHandler.DECREASE) {
            currentValue = decreaseCurrentValue(levelChange, currentValue);
        } else if (changeType == LevelOfPetsHandler.INCREASE) {
            currentValue = increaseCurrentValue(levelChange, currentValue);
        } else {
            throw new OperationNotSuccessException("Sorry, can't decrease or increase current value");
        }

        /*set updated value to the EnumMap*/
        /*check new value and return*/
        setCurrentValueForIndicator(indicator, currentValue);
        return indicator.checkCurrentValue(currentValue);
    }

    private int decreaseCurrentValue(int levelDecrease, int currentValue) {
        int decreasedValue = currentValue - levelDecrease;
        return Math.max(decreasedValue, 0); //protection from negative values
    }

    private int increaseCurrentValue(int levelIncrease, int currentValue) {
        int increasedValue = currentValue - levelIncrease;
        return Math.max(increasedValue, 0);
    }
}
