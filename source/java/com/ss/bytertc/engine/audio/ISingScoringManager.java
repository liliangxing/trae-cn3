package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.ISingScoringEventHandler;
import com.ss.bytertc.engine.data.SingScoringConfig;
import com.ss.bytertc.engine.data.StandardPitchInfo;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class ISingScoringManager {
    public abstract int getAverageScore();

    public abstract int getLastSentenceScore();

    public abstract List<StandardPitchInfo> getStandardPitchInfo(String midiFilepath);

    public abstract int getTotalScore();

    public abstract int initSingScoring(String singScoringAppkey, String singAcoringToken, ISingScoringEventHandler handler);

    public abstract int setSingScoringConfig(SingScoringConfig config);

    public abstract int startSingScoring(int position, int scoringInfoInterval);

    public abstract int stopSingScoring();
}
