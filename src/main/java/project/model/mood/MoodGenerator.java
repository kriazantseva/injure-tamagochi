package project.model.mood;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class MoodGenerator {
    private static final String KEY_STRING = "Mood";
    private final Map<MoodTypeClusters, EnumSet<MoodTypes>> moodTypeClustersMap =
            new HashMap<>();
    private final Map<String, MoodTypes> moodMap = new HashMap<>();
    private final Random random = new Random();
    {
        moodTypeClustersMap.put(MoodTypeClusters.POSITIVE, MoodTypeClusters.POSITIVE.init());
        moodTypeClustersMap.put(MoodTypeClusters.NEUTRAL, MoodTypeClusters.NEUTRAL.init());
        moodTypeClustersMap.put(MoodTypeClusters.MILDLY_NEGATIVE, MoodTypeClusters.MILDLY_NEGATIVE.init());
        moodTypeClustersMap.put(MoodTypeClusters.STRONGLY_NEGATIVE, MoodTypeClusters.STRONGLY_NEGATIVE.init());
        moodTypeClustersMap.put(MoodTypeClusters.DEPRESSIVE, MoodTypeClusters.DEPRESSIVE.init());
    }
    {
        moodMap.put(KEY_STRING, MoodTypes.HAPPY);
    }

    public MoodTypes getMoodMap() {
        return moodMap.get(KEY_STRING);
    }

    public void setMoodMap(MoodTypes mood) {
        moodMap.put(KEY_STRING, mood);
    }

    public MoodTypes getRandomMoodFromUpdatedRandomMap(MoodTypeClusters... clusters) {
        MoodTypeClusters moodCluster = getRandomMoodCluster(clusters);
        EnumSet<MoodTypes> moodTypes = getMoodSetFromMoodTypeCluster(moodCluster);
        setMoodMap(getRandomMoodFromMoodSet(moodTypes));
        return getMoodMap();
    }

    private MoodTypes getRandomMoodFromMoodSet(EnumSet<MoodTypes> moodTypes) {
        Map<Integer, MoodTypes> moods = new HashMap<>();
        int i = 1;

        for(MoodTypes mood : moodTypes) {
            moods.put(i, mood);
            i++;
        }
        return moods.get(random.nextInt(moods.size()) + 1);
    }

    private EnumSet<MoodTypes> getMoodSetFromMoodTypeCluster(MoodTypeClusters key) {
        return moodTypeClustersMap.get(key);
    }

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
