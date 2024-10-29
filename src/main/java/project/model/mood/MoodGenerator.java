package project.model.mood;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * The MoodGenerator class is responsible for generating and updating the mood state of a pet.
 * It maintains mappings of mood types organized by clusters, providing methods to select random moods
 * from specified clusters, and updating the current mood.
 *
 * <p>This class offers functionality for:
 * - Retrieving and setting the current mood from a specified mood map.
 * - Selecting a random mood from specified mood clusters.
 * </p>
 *
 * <p>Usage:</p>
 * MoodGenerator allows dynamic mood changes and mood cluster randomization, useful in pet behavior simulations.
 */
public final class MoodGenerator {
    /** Key for accessing the current mood in the mood map. */
    private static final String KEY_STRING = "Mood";

    /** Map storing mood clusters with their corresponding mood types in EnumSets. */
    private final Map<MoodTypeClusters, EnumSet<MoodTypes>> moodTypeClustersMap =
            new HashMap<>();

    /** Map storing the current mood of the pet. */
    private final Map<String, MoodTypes> moodMap = new HashMap<>();

    /** Random object used for random selection of moods and clusters. */
    private final Random random = new Random();

    // Initializer to populate the mood type clusters with predefined mood sets.
    {
        moodTypeClustersMap.put(MoodTypeClusters.POSITIVE, MoodTypeClusters.POSITIVE.init());
        moodTypeClustersMap.put(MoodTypeClusters.NEUTRAL, MoodTypeClusters.NEUTRAL.init());
        moodTypeClustersMap.put(MoodTypeClusters.MILDLY_NEGATIVE, MoodTypeClusters.MILDLY_NEGATIVE.init());
        moodTypeClustersMap.put(MoodTypeClusters.STRONGLY_NEGATIVE, MoodTypeClusters.STRONGLY_NEGATIVE.init());
        moodTypeClustersMap.put(MoodTypeClusters.DEPRESSIVE, MoodTypeClusters.DEPRESSIVE.init());
    }
    // Initializer for setting the default mood.
    {
        moodMap.put(KEY_STRING, MoodTypes.HAPPY);
    }

    /**
     * Retrieves the current mood from the mood map.
     *
     * @return The current MoodTypes value.
     */
    public MoodTypes getMoodMap() {
        return moodMap.get(KEY_STRING);
    }

    /**
     * Sets the current mood in the mood map.
     *
     * @param mood The mood to set as the current mood.
     */
    public void setMoodMap(MoodTypes mood) {
        moodMap.put(KEY_STRING, mood);
    }

    /**
     * Randomly selects a mood type from the provided clusters, updates the current mood map,
     * and returns the selected mood type.
     *
     * @param clusters The mood clusters to select from.
     * @return The randomly selected MoodTypes value.
     * @throws RuntimeException if no clusters are provided.
     */
    public MoodTypes getRandomMoodFromUpdatedRandomMap(MoodTypeClusters... clusters) {
        MoodTypeClusters moodCluster = getRandomMoodCluster(clusters);
        EnumSet<MoodTypes> moodTypes = getMoodSetFromMoodTypeCluster(moodCluster);
        setMoodMap(getRandomMoodFromMoodSet(moodTypes));
        return getMoodMap();
    }

    /**
     * Randomly selects a mood from the provided set of moods.
     *
     * @param moodTypes The set of mood types to select from.
     * @return The randomly selected MoodTypes.
     */
    private MoodTypes getRandomMoodFromMoodSet(EnumSet<MoodTypes> moodTypes) {
        Map<Integer, MoodTypes> moods = new HashMap<>();
        int i = 1;

        for(MoodTypes mood : moodTypes) {
            moods.put(i, mood);
            i++;
        }
        return moods.get(random.nextInt(moods.size()) + 1);
    }

    /**
     * Retrieves the set of moods associated with a given mood cluster.
     *
     * @param key The mood cluster key.
     * @return The EnumSet of MoodTypes for the specified cluster.
     */
    private EnumSet<MoodTypes> getMoodSetFromMoodTypeCluster(MoodTypeClusters key) {
        return moodTypeClustersMap.get(key);
    }

    /**
     * Randomly selects a mood cluster from the provided clusters.
     *
     * @param clusters The mood clusters to select from.
     * @return The randomly selected MoodTypeClusters value.
     * @throws RuntimeException if no clusters are provided.
     */
    private MoodTypeClusters getRandomMoodCluster(MoodTypeClusters... clusters) {
        if(clusters.length == 0) {
            throw new RuntimeException("Need at least one Mood Cluster");
        }
        if(clusters.length == 1) {
            return clusters[0];
        }
        Map<Integer, MoodTypeClusters> moodClusters = new HashMap<>();
        for(int i = 0; i < clusters.length; i++) {
            moodClusters.put(i + 1, clusters[i]);
        }
        return moodClusters.get(random.nextInt(moodClusters.size()) + 1);
    }
}
