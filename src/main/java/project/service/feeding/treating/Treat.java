package project.service.feeding.treating;

import project.enums.indicators.statuses.WellBeingStatuses;
import project.enums.mood.MoodGenerator;
import project.enums.mood.MoodTypes;

import java.util.EnumSet;

/**
 * The {@code Treat} interface represents the ability to provide treats to a pet,
 * impacting its mood based on the type of treat and the pet's current well-being status.
 * It includes a default method to process the treat and determine the resulting mood.
 *
 * @param <T> the type of treat, constrained to enums representing specific treat types.
 */
public interface Treat<T extends Enum<T>> {
    /**
     * Provides a treat to the pet and evaluates its effect on the pet's mood.
     * The resulting mood is determined based on:
     * <ul>
     *   <li>Whether the treat is included in the preferred {@code treatSet}</li>
     *   <li>The pet's current well-being status, defined by {@code wellBeingStatus}</li>
     * </ul>
     *
     * <p>The logic for mood determination is as follows:
     * <ul>
     *   <li>If the treat is preferred and well-being status is {@code EXCELLENT} or {@code GOOD},
     *   the pet's mood is set to {@code JOYFUL}.</li>
     *   <li>If the treat is preferred and the pet is neither {@code UNWELL} nor {@code SICK}, the mood is {@code INSPIRED}.</li>
     *   <li>If the treat is not preferred but the pet is in a moderate condition, the mood is set to {@code OPTIMISTIC}.</li>
     *   <li>If none of the above conditions are met, the mood is set to {@code INDIFFERENT}.</li>
     * </ul>
     *
     * @param treat          the specific treat given to the pet
     * @param wellBeingStatus the pet's current well-being status, influencing mood response
     * @param treatSet       the set of preferred treats for the pet
     * @return the resulting {@code MoodTypes} based on the treat and well-being status
     */
    default MoodTypes giveTreat(T treat, WellBeingStatuses wellBeingStatus,
                                EnumSet<T> treatSet, MoodGenerator moodGenerator) {
        if(treatSet.contains(treat) &&
                (wellBeingStatus == WellBeingStatuses.EXCELLENT ||
                        wellBeingStatus == WellBeingStatuses.GOOD)) {
            moodGenerator.setMoodMap(MoodTypes.JOYFUL);
            return moodGenerator.getMoodMap();
        } else if(treatSet.contains(treat) &&
                wellBeingStatus != WellBeingStatuses.UNWELL &&
                wellBeingStatus != WellBeingStatuses.SICK) {
            moodGenerator.setMoodMap(MoodTypes.INSPIRED);
            return moodGenerator.getMoodMap();
        } else if(!treatSet.contains(treat) &&
                wellBeingStatus != WellBeingStatuses.UNWELL &&
                wellBeingStatus != WellBeingStatuses.SICK) {
            moodGenerator.setMoodMap(MoodTypes.OPTIMISTIC);
            return moodGenerator.getMoodMap();
        }
        moodGenerator.setMoodMap(MoodTypes.INDIFFERENT);
        return moodGenerator.getMoodMap();
    }

    /**
     * Retrieves the set of treats that are considered preferable or liked by the pet.
     * The specific implementation will provide the treat set.
     *
     * @return an {@code EnumSet} of preferred treats for the pet
     */
    EnumSet<T> getTreatSet();

    void updateTreatSetInPet();
}
