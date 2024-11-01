package project.service.toy_play;

import project.enums.indicators.statuses.WellBeingStatuses;
import project.enums.items.toys.ToysForCats;
import project.enums.items.toys.ToysForDogs;
import project.enums.mood.MoodGenerator;
import project.enums.mood.MoodTypeClusters;
import project.enums.mood.MoodTypes;

import java.util.EnumSet;
import java.util.Random;

public interface ToyPlay<T extends Enum<T>> {
    default MoodTypes giveToy(T toy, WellBeingStatuses wellBeingStatus, EnumSet<T> toysSet) {
        MoodGenerator moodGenerator = new MoodGenerator();
        if(wellBeingStatus == WellBeingStatuses.EXCELLENT || wellBeingStatus == WellBeingStatuses.GOOD ||
                wellBeingStatus == WellBeingStatuses.FAIR || wellBeingStatus == WellBeingStatuses.TIRED) {
            if(toy == ToysForCats.INTERACTIVE_PUZZLE_FEEDER || toy == ToysForDogs.INTERACTIVE_TREAT_PUZZLE) {
                if(chanceOfSolving()) {
                    TreatToySolvingCalc.solvedTimes++;
                    return moodGenerator.getRandomMoodFromUpdatedRandomMap(MoodTypeClusters.POSITIVE);
                }
                TreatToySolvingCalc.tries++;
                return moodGenerator.getRandomMoodFromUpdatedRandomMap(MoodTypeClusters.MILDLY_NEGATIVE,
                        MoodTypeClusters.NEUTRAL);
            }
            if(toysSet.contains(toy)) {
                return moodGenerator.getRandomMoodFromUpdatedRandomMap(MoodTypeClusters.POSITIVE);
            }
        } else if(wellBeingStatus == WellBeingStatuses.UNWELL || wellBeingStatus == WellBeingStatuses.SICK) {
            return moodGenerator.getMoodMap();
        }
        moodGenerator.setMoodMap(MoodTypes.INDIFFERENT);
        return moodGenerator.getMoodMap();
    }

    EnumSet<T> getToySet();

    void updateToySetInPet(EnumSet<T> toySet);

    private boolean chanceOfSolving() {
        final int RANDOM_INDEX = 1;
        final int MAX_INDEX = 3;
        final Random random = new Random();
        if(TreatToySolvingCalc.solvedTimes >= 0 && TreatToySolvingCalc.solvedTimes <= 5) {
            return random.nextInt(MAX_INDEX) == RANDOM_INDEX;
        }
        if(TreatToySolvingCalc.solvedTimes > 5) {
            return true;
        }
        if(TreatToySolvingCalc.tries == 5 && TreatToySolvingCalc.solvedTimes <= 1) {
            return false;
        }
        return false;
    }
}
