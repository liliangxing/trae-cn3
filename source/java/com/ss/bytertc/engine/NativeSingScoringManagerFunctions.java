package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.StandardPitchInfo;
import com.ss.bytertc.engine.handler.NativeSingScoringEventHandler;

/* loaded from: classes7.dex */
public class NativeSingScoringManagerFunctions {
    public static native int nativeGetAverageScore(long singScoringManagerPtr);

    public static native int nativeGetLastSentenceScore(long singScoringManagerPtr);

    public static native StandardPitchInfo[] nativeGetStandardPitchInfo(long singScoringManagerPtr, String midiFilepath);

    public static native int nativeGetTotalScore(long singScoringManagerPtr);

    public static native int nativeInitSingScoring(long enginePtr, long singScoringManagerPtr, String singScoringAppkey, String singAcoringToken, NativeSingScoringEventHandler handler);

    public static native int nativeSetSingScoringConfig(long singScoringManagerPtr, int sampleRate, int mode, String lyricsFilepath, String midiFilepath);

    public static native int nativeStartSingScoring(long singScoringManagerPtr, int position, int scoringInfoInterval);

    public static native int nativeStopSingScoring(long singScoringManagerPtr);
}
