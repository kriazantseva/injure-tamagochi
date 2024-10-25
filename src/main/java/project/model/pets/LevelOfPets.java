package project.model.pets;

import project.model.indicators.ChangeOfIndicators;
import project.model.indicators.Indicators;

public enum LevelOfPets implements ChangeOfIndicators {
    EASY() {
        @Override
        public int changeIndicatorsLevel(Indicators indicator) {
            return LevelOfPetsHandler.DECREASE.updateIndicatorValue(
                    indicator, LevelOfPetsUtil.EASY_LEVEL_DECREASE, LevelOfPetsHandler.DECREASE
                    );
        }
    },
    MEDIUM() {
        @Override
        public int changeIndicatorsLevel(Indicators indicator) {
            return LevelOfPetsHandler.DECREASE.updateIndicatorValue(
                    indicator, LevelOfPetsUtil.MEDIUM_LEVEL_DECREASE, LevelOfPetsHandler.DECREASE
            );
        }
    },
    HARD() {
        @Override
        public int changeIndicatorsLevel(Indicators indicator) {
            return LevelOfPetsHandler.DECREASE.updateIndicatorValue(
                    indicator, LevelOfPetsUtil.TEST_LEVEL_DECREASE, LevelOfPetsHandler.DECREASE
            );
        }
    }
}
