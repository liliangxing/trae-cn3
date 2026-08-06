package com.bytedance.retrofit2;

/* loaded from: classes4.dex */
public class TTMetricsUtil {
    public static long nanoSecondsToMilliSeconds(long j) {
        if (j == -1) {
            return -1L;
        }
        return j / 1000000;
    }

    public static long nanoSecondsToMicroSeconds(long j) {
        if (j == -1) {
            return -1L;
        }
        return j / 1000;
    }

    public static long calculateWallClockTimeMs(long j, long j2, long j3) {
        if (j < 0 || j2 < 0 || j3 < 0 || j2 > j3) {
            return -1L;
        }
        return nanoSecondsToMilliSeconds(j3 - j2) + j;
    }

    public static long calculateDurationUs(long j, long j2) {
        if (j == -1 || j2 == -1 || j > j2) {
            return -1L;
        }
        return nanoSecondsToMicroSeconds(j2 - j);
    }
}
