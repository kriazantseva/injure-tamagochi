package project.service;

import project.enums.indicators.Indicators;
import project.enums.pets.LevelOfPetsHandler;

public class SleepService {
    public void takeNap() {
        LevelOfPetsHandler.INCREASE.updateIndicatorValue(Indicators.ENERGY, 40,
                LevelOfPetsHandler.INCREASE);
    }
}
