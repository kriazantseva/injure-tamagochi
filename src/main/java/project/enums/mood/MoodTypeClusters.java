package project.enums.mood;

import java.util.EnumSet;

//united emotions into mood groups: positive, neutral, mildly negative
//strongly negative and depressive
//each pet's character will get dominant emotional group
public enum MoodTypeClusters implements MoodTypesSet {
    POSITIVE() {
        @Override
        public EnumSet<MoodTypes> init() {
            return EnumSet.of(MoodTypes.JOYFUL,
                    MoodTypes.HAPPY, MoodTypes.CALM, MoodTypes.OPTIMISTIC,
                    MoodTypes.INSPIRED, MoodTypes.EXCITED);
        }
    },
    NEUTRAL() {
        @Override
        public EnumSet<MoodTypes> init() {
            return EnumSet.of(MoodTypes.INDIFFERENT);
        }
    },
    MILDLY_NEGATIVE() {
        @Override
        public EnumSet<MoodTypes> init() {
            return EnumSet.of(MoodTypes.IRRITATED, MoodTypes.WORRIED);
        }
    },
    STRONGLY_NEGATIVE() {
        @Override
        public EnumSet<MoodTypes> init() {
            return EnumSet.of(MoodTypes.ANGRY);
        }
    },
    DEPRESSIVE() {
        @Override
        public EnumSet<MoodTypes> init() {
            return EnumSet.of(MoodTypes.SAD, MoodTypes.HOPELESS);
        }
    }
}
