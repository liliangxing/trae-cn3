package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class NativeSimilaritySingScoringManagerFunctions {
    public static native int nativeGetAverageSimilarityScore(long singScoringManagerPtr);

    public static native int nativeGetLastSimilarityScore(long singScoringManagerPtr);

    public static native int nativeGetTotalSimilarityScore(long singScoringManagerPtr);

    public static native int nativeStartSimilaritySingScoring(long singScoringManagerPtr, int calculateInterval, int mode, String ref_room_id, String ref_user_id, int ref_stream_index);

    public static native int nativeStopSimilaritySingScoring(long singScoringManagerPtr);
}
