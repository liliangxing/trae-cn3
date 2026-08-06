package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum SimilaritySingScoringMode {
    SING_SCORING_MODE_SPECTRAL_SIMILARITY(0);

    private int value;

    SimilaritySingScoringMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static SimilaritySingScoringMode fromId(int value) {
        for (SimilaritySingScoringMode similaritySingScoringMode : values()) {
            if (similaritySingScoringMode.value == value) {
                return similaritySingScoringMode;
            }
        }
        return null;
    }
}
