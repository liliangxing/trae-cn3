package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class SimilaritySingScoringConfig {
    public int calculateIntervalMs;
    public SimilaritySingScoringMode mode;
    public RemoteStreamKey refStream;

    public SimilaritySingScoringConfig() {
        this.mode = SimilaritySingScoringMode.SING_SCORING_MODE_SPECTRAL_SIMILARITY;
        this.calculateIntervalMs = 10000;
        this.refStream = null;
    }

    public SimilaritySingScoringConfig(int calculateIntervalMs, SimilaritySingScoringMode mode, RemoteStreamKey refStream) {
        SimilaritySingScoringMode similaritySingScoringMode = SimilaritySingScoringMode.SING_SCORING_MODE_SPECTRAL_SIMILARITY;
        this.calculateIntervalMs = calculateIntervalMs;
        this.mode = mode;
        this.refStream = refStream;
    }
}
