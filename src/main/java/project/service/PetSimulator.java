package project.service;

import project.model.indicators.Indicators;
import project.model.indicators.statuses.WellBeingStatuses;
import project.model.indicators.wellbeing_dependency.WellBeingDependencies;
import project.model.pets.LevelOfPets;
import project.model.pets.LevelOfPetsHandler;
import project.model.pets.LevelOfPetsStarter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PetSimulator {

    private final Indicators hungerIndicator;
    private final Indicators wellbeingIndicator;
    private final Indicators energyIndicator;

    private int wellbeingValue;
    private int hungerValue;
    private int energyValue;

    public PetSimulator() {
        this.hungerIndicator = Indicators.HUNGER;
        this.wellbeingIndicator = Indicators.WELL_BEING;
        this.energyIndicator = Indicators.ENERGY;

        this.wellbeingValue = LevelOfPetsStarter.indicatorsValues.get(Indicators.WELL_BEING);
        this.hungerValue = LevelOfPetsStarter.indicatorsValues.get(Indicators.HUNGER);
        this.energyValue = LevelOfPetsStarter.indicatorsValues.get(Indicators.ENERGY);
    }

    public void simulate(LevelOfPets level) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        WellBeingDependencies wellBeingDependencies = new WellBeingDependencies();

        // Запускаємо зменшення індикаторів кожні 5 секунд
        scheduler.scheduleAtFixedRate(() -> {
            // Зменшуємо значення індикаторів за допомогою рівня складності
            hungerValue = level.changeIndicatorsLevel(hungerIndicator);
            energyValue = level.changeIndicatorsLevel(energyIndicator);
            wellbeingValue = wellBeingDependencies.wellBeingCurrentValueChecker(hungerValue, energyValue);

            // Оновлюємо значення в EnumMap за допомогою setCurrentValueForIndicator
            LevelOfPetsHandler.DECREASE.setCurrentValueForIndicator(hungerIndicator, hungerValue);
            LevelOfPetsHandler.DECREASE.setCurrentValueForIndicator(energyIndicator, energyValue);
            LevelOfPetsHandler.DECREASE.setCurrentValueForIndicator(wellbeingIndicator, wellbeingValue);

            // Виводимо статуси
            System.out.println("New Hunger Status: " + Indicators.HUNGER.getStatus(hungerValue) +
                    LevelOfPetsStarter.indicatorsValues.get(Indicators.HUNGER));
            System.out.println("New Energy Status: " + Indicators.ENERGY.getStatus(energyValue) +
                    LevelOfPetsStarter.indicatorsValues.get(Indicators.ENERGY));
            System.out.println("New Well-Being Status: " + Indicators.WELL_BEING.getStatus(wellbeingValue));

            // Перевірка на завершення симуляції
            if (wellbeingIndicator.getStatus(wellbeingValue) == WellBeingStatuses.DEAD) {
                System.out.println("Simulation ended: One or more indicators reached critical values.");
                scheduler.shutdown();
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
}
