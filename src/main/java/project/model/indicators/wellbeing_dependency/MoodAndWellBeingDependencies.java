package project.model.indicators.wellbeing_dependency;

import project.model.indicators.statuses.WellBeingStatuses;
import project.model.mood.MoodGenerator;
import project.model.mood.MoodTypeClusters;
import project.model.mood.MoodTypes;

import java.util.Random;

/**
 * The {@code MoodAndWellBeingDependencies} class is responsible for updating a pet's mood based
 * on its well-being status. It uses a {@code MoodGenerator} instance to adjust mood according to
 * predefined conditions that vary by well-being state.
 *
 * <p>This class defines mood responses for various {@code WellBeingStatuses} such as
 * {@code EXCELLENT}, {@code FAIR}, {@code TIRED}, {@code UNWELL}, and {@code SICK}.
 * It includes a probabilistic check for certain well-being statuses to add variation in mood updates.
 */
public final class MoodAndWellBeingDependencies {
    /** Random index used in mood updating chance calculation. */
    private static final int RANDOM_INDEX = 1;

    /** Maximum value for random index range to evaluate mood update chances. */
    private static final int MAX_INDEX = 3;

    /** Mood generator to manage mood states based on well-being changes. */
    private final MoodGenerator moodGenerator = new MoodGenerator();

    /**
     * Updates the mood of the pet depending on its current well-being status.
     *
     * <p>The following mood updates are applied based on {@code WellBeingStatuses}:
     * <ul>
     *   <li>{@code EXCELLENT} - Sets a random positive mood.</li>
     *   <li>{@code FAIR} or {@code TIRED} - Sets a random neutral or mildly negative mood
     *       if a randomly determined chance succeeds; otherwise, the current mood is retained.</li>
     *   <li>{@code UNWELL} - Sets the mood to {@code ANGRY}.</li>
     *   <li>{@code SICK} - Sets a random mood from mildly negative or depressive clusters.</li>
     * </ul>
     *
     * <p>If none of the above statuses apply, there is a random chance to select a positive mood.
     * The current mood is retained if the random chance is not met.
     *
     * @param wellBeing the current well-being status of the pet
     */
    public void updateMoodDependsOnWellBeing(WellBeingStatuses wellBeing) {
        if(wellBeing == WellBeingStatuses.EXCELLENT) {
            moodGenerator.getRandomMoodFromUpdatedRandomMap(MoodTypeClusters.POSITIVE);
            return;
        } else if(wellBeing == WellBeingStatuses.FAIR || wellBeing == WellBeingStatuses.TIRED) {
            if(chanceForMoodUpdating()) {
                moodGenerator.getRandomMoodFromUpdatedRandomMap(MoodTypeClusters.NEUTRAL,
                        MoodTypeClusters.MILDLY_NEGATIVE);
                return;
            }
            moodGenerator.getMoodMap();
            return;
        } else if(wellBeing == WellBeingStatuses.UNWELL) {
            moodGenerator.setMoodMap(MoodTypes.ANGRY);
            moodGenerator.getMoodMap();
            return;
        } else if(wellBeing == WellBeingStatuses.SICK) {
            moodGenerator.getRandomMoodFromUpdatedRandomMap(MoodTypeClusters.MILDLY_NEGATIVE,
                    MoodTypeClusters.DEPRESSIVE);
            return;
        }
        if(chanceForMoodUpdating()) {
            moodGenerator.getRandomMoodFromUpdatedRandomMap(MoodTypeClusters.POSITIVE);
        }
        moodGenerator.getMoodMap();
    }

    /**
     * Retrieves the current mood from the {@code MoodGenerator} instance.
     *
     * @return the current {@code MoodTypes} based on the last updated well-being status
     */
    public MoodTypes getMood() {
        return moodGenerator.getMoodMap();
    }

    /**
     * Calculates the chance for updating the mood based on a random probability.
     *
     * <p>This method returns {@code true} approximately 1 in {@code MAX_INDEX} times.
     *
     * @return {@code true} if the randomly determined index matches {@code RANDOM_INDEX},
     *         indicating mood update; {@code false} otherwise
     */
    private boolean chanceForMoodUpdating() {
        Random random = new Random();
        return random.nextInt(MAX_INDEX) == RANDOM_INDEX;
    }
}
