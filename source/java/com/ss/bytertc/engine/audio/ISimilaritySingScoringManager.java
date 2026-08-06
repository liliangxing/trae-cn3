package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.data.SimilaritySingScoringConfig;

/* loaded from: classes7.dex */
public abstract class ISimilaritySingScoringManager {
    public abstract int getAverageScore();

    public abstract int getLastScore();

    public abstract int getTotalScore();

    public abstract int startSingScoring(SimilaritySingScoringConfig config);

    public abstract int stopSingScoring();
}
