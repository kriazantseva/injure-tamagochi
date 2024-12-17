package project.enums.pets;

import project.enums.indicators.ChangeOfIndicators;
import project.enums.indicators.Indicators;

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
                    indicator, LevelOfPetsUtil.HARD_LEVEL_DECREASE, LevelOfPetsHandler.DECREASE
            );
        }
    }
}
