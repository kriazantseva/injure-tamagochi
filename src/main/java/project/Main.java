package project;

import project.model.indicators.statuses.EnergyStatuses;
import project.model.indicators.statuses.HungerStatuses;
import project.model.indicators.Indicators;
import project.model.mood.MoodTypeClusters;
import project.model.pets.LevelOfPets;
import project.model.pets.LevelOfPetsHandler;
import project.model.pets.LevelOfPetsStarter;
import project.service.PetSimulator;

import java.util.EnumMap;

public class Main {
    public static void main(String[] args) {
//        PetSimulator petSimulator = new PetSimulator();
//        petSimulator.simulate(LevelOfPets.HARD);
//
//        System.out.println(LevelOfPetsStarter.indicatorsValues.keySet());

        System.out.println(MoodTypeClusters.POSITIVE.init());
        System.out.println(MoodTypeClusters.DEPRESSIVE.init());


    }
}
