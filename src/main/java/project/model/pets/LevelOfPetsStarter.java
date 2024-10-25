package project.model.pets;

import project.model.indicators.Indicators;

import java.util.EnumMap;

public class LevelOfPetsStarter {
    /*Collect all pet's indicators in one EnumMap for access to decreasing and increasing indicator's values*/
    public static EnumMap<Indicators, Integer> indicatorsValues = new EnumMap<>(Indicators.class);
    static {
        /*for start set all values to their maximum*/
        indicatorsValues.put(Indicators.HUNGER, Indicators.HUNGER.getMaxValue());
        indicatorsValues.put(Indicators.ENERGY, Indicators.ENERGY.getMaxValue());
        indicatorsValues.put(Indicators.WELL_BEING, Indicators.WELL_BEING.getMaxValue());
    }
}
