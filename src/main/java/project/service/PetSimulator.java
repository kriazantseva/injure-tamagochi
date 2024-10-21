package project.service;

import project.model.indicators.Indicators;
import project.model.pets.LevelOfPets;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PetSimulator {
    private final Indicators hungerIndicator;
    private final Indicators wellbeingIndicator;
    private final Indicators energyIndicator;

    public PetSimulator() {
        this.hungerIndicator = Indicators.HUNGER;
        this.wellbeingIndicator = Indicators.WELL_BEING;
        this.energyIndicator = Indicators.ENERGY;
    }

    public void simulate(LevelOfPets level) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Запускаємо зменшення індикаторів кожні 5 секунд
        scheduler.scheduleAtFixedRate(() -> {
            int newHungerValue = level.decreaseIndicatorsLevel(hungerIndicator);
            System.out.println("New Hunger Status: " + hungerIndicator.getStatus(newHungerValue));

            int newEnergyValue = level.decreaseIndicatorsLevel(energyIndicator);
            System.out.println("New Energy Status: " + energyIndicator.getStatus(newEnergyValue));

            int newWellBeingValue = level.decreaseIndicatorsLevel(wellbeingIndicator);
            System.out.println("New Well-Being Status: " + wellbeingIndicator.getStatus(newWellBeingValue));

            if (newHungerValue == 0 || newEnergyValue == 0 || newWellBeingValue == 1) {
                System.out.println("Simulation ended: One or more indicators reached critical values.");
                scheduler.shutdown();
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
}
