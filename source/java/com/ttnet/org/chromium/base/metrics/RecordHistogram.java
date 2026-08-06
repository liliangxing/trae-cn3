package com.ttnet.org.chromium.base.metrics;

import androidx.collection.SieveCacheKt;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.ttnet.org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: classes7.dex */
public class RecordHistogram {
    private static int clampToInt(long j) {
        if (j > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        if (j < SieveCacheKt.NodeMetaAndPreviousMask) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static void recordBooleanHistogram(String str, boolean z) {
        UmaRecorderHolder.get().recordBooleanHistogram(str, z);
    }

    public static void recordEnumeratedHistogram(String str, int i, int i2) {
        recordExactLinearHistogram(str, i, i2);
    }

    public static void recordCount1MHistogram(String str, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, 1, 1000000, 50);
    }

    public static void recordCount100Histogram(String str, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, 1, 100, 50);
    }

    public static void recordCount1000Histogram(String str, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, 1, 1000, 50);
    }

    public static void recordCount100000Histogram(String str, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, 1, AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength, 50);
    }

    public static void recordCustomCountHistogram(String str, int i, int i2, int i3, int i4) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, i2, i3, i4);
    }

    public static void recordLinearCountHistogram(String str, int i, int i2, int i3, int i4) {
        UmaRecorderHolder.get().recordLinearHistogram(str, i, i2, i3, i4);
    }

    public static void recordPercentageHistogram(String str, int i) {
        recordExactLinearHistogram(str, i, 101);
    }

    public static void recordSparseHistogram(String str, int i) {
        UmaRecorderHolder.get().recordSparseHistogram(str, i);
    }

    public static void recordTimesHistogram(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 1L, 10000L, 50);
    }

    public static void recordMediumTimesHistogram(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 10L, 180000L, 50);
    }

    public static void recordLongTimesHistogram(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 1L, 3600000L, 50);
    }

    public static void recordLongTimesHistogram100(String str, long j) {
        recordCustomTimesHistogramMilliseconds(str, j, 1L, 3600000L, 100);
    }

    public static void recordCustomTimesHistogram(String str, long j, long j2, long j3, int i) {
        recordCustomTimesHistogramMilliseconds(str, j, j2, j3, i);
    }

    public static void recordMemoryKBHistogram(String str, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, i, 1000, 500000, 50);
    }

    public static void recordExactLinearHistogram(String str, int i, int i2) {
        UmaRecorderHolder.get().recordLinearHistogram(str, i, 1, i2, i2 + 1);
    }

    private static void recordCustomTimesHistogramMilliseconds(String str, long j, long j2, long j3, int i) {
        UmaRecorderHolder.get().recordExponentialHistogram(str, clampToInt(j), clampToInt(j2), clampToInt(j3), i);
    }

    public static int getHistogramValueCountForTesting(String str, int i) {
        return UmaRecorderHolder.get().getHistogramValueCountForTesting(str, i);
    }

    public static int getHistogramTotalCountForTesting(String str) {
        return UmaRecorderHolder.get().getHistogramTotalCountForTesting(str);
    }
}
