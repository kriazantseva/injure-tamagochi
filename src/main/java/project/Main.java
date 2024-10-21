package project;

import project.model.indicators.statuses.EnergyStatuses;
import project.model.indicators.statuses.HungerStatuses;
import project.model.indicators.Indicators;
import project.model.pets.LevelOfPets;
import project.service.PetSimulator;

public class Main {
    public static void main(String[] args) {
        PetSimulator petSimulator = new PetSimulator();
        petSimulator.simulate(LevelOfPets.HARD);
    }
}
