package project.service;

import project.enums.indicators.Indicators;
import project.enums.indicators.statuses.WellBeingStatuses;
import project.enums.indicators.wellbeing_dependency.MoodAndWellBeingDependencies;
import project.enums.indicators.wellbeing_dependency.WellBeingDependencies;
import project.enums.pets.LevelOfPets;
import project.enums.pets.LevelOfPetsHandler;
import project.enums.pets.LevelOfPetsStarter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PetSimulator {
    private final Indicators hungerIndicator;
    private final Indicators wellbeingIndicator;
    private final Indicators energyIndicator;
    private final Indicators thirstIndicator;

    private int wellbeingValue;
    private int hungerValue;
    private int energyValue;
    private int thirstValue;
    private WellBeingStatuses oldWellBeingStatus;
    private WellBeingStatuses newWellBeingStatus;

    public PetSimulator() {
        this.hungerIndicator = Indicators.HUNGER;
        this.wellbeingIndicator = Indicators.WELL_BEING;
        this.energyIndicator = Indicators.ENERGY;
        this.thirstIndicator = Indicators.THIRST;

        this.wellbeingValue = LevelOfPetsStarter.indicatorsValues.get(Indicators.WELL_BEING);
        this.hungerValue = LevelOfPetsStarter.indicatorsValues.get(Indicators.HUNGER);
        this.energyValue = LevelOfPetsStarter.indicatorsValues.get(Indicators.ENERGY);
        this.thirstValue = LevelOfPetsStarter.indicatorsValues.get(Indicators.THIRST);
        this.oldWellBeingStatus = WellBeingStatuses.GOOD;
    }

    public void simulate(LevelOfPets level) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        WellBeingDependencies wellBeingDependencies = new WellBeingDependencies();
        MoodAndWellBeingDependencies moodAndWellBeingDependencies =
                new MoodAndWellBeingDependencies();

        scheduler.scheduleAtFixedRate(() -> {
            hungerValue = level.changeIndicatorsLevel(hungerIndicator);
            energyValue = level.changeIndicatorsLevel(energyIndicator);
            thirstValue = level.changeIndicatorsLevel(thirstIndicator);
            wellbeingValue = wellBeingDependencies.wellBeingCurrentValueChecker(hungerValue, energyValue, thirstValue);
            newWellBeingStatus = (WellBeingStatuses) Indicators.WELL_BEING.getStatus(wellbeingValue);

            LevelOfPetsHandler.DECREASE.setCurrentValueForIndicator(hungerIndicator, hungerValue);
            LevelOfPetsHandler.DECREASE.setCurrentValueForIndicator(energyIndicator, energyValue);
            LevelOfPetsHandler.DECREASE.setCurrentValueForIndicator(thirstIndicator, thirstValue);
            LevelOfPetsHandler.DECREASE.setCurrentValueForIndicator(wellbeingIndicator, wellbeingValue);
            if(checkNewishOfWellBeingStatus(oldWellBeingStatus, newWellBeingStatus)) {
                moodAndWellBeingDependencies.updateMoodDependsOnWellBeing(newWellBeingStatus);
            }

            oldWellBeingStatus = newWellBeingStatus;

            System.out.println("New Hunger Status: " + Indicators.HUNGER.getStatus(hungerValue) +
                    LevelOfPetsStarter.indicatorsValues.get(Indicators.HUNGER));
            System.out.println("New Energy Status: " + Indicators.ENERGY.getStatus(energyValue) +
                    LevelOfPetsStarter.indicatorsValues.get(Indicators.ENERGY));
            System.out.println("New Thirst Status: " + Indicators.THIRST.getStatus(thirstValue) +
                    LevelOfPetsStarter.indicatorsValues.get(Indicators.THIRST));
            System.out.println("New Well-Being Status: " + Indicators.WELL_BEING.getStatus(wellbeingValue));
            System.out.println("Mood Status: " + moodAndWellBeingDependencies.getMood());


            if (wellbeingIndicator.getStatus(wellbeingValue) == WellBeingStatuses.DEAD) {
                System.out.println("Simulation ended: One or more indicators reached critical values.");
                scheduler.shutdown();
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    private boolean checkNewishOfWellBeingStatus(WellBeingStatuses oldSt, WellBeingStatuses newSt) {
        return newSt != oldSt;
    }
}
