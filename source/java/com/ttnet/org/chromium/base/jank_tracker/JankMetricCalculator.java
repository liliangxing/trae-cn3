package com.ttnet.org.chromium.base.jank_tracker;

import java.util.ArrayList;

/* loaded from: classes7.dex */
class JankMetricCalculator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long JANK_BURST_CONSECUTIVE_FRAME_THRESHOLD_NS = 50000000;
    private static final long JANK_THRESHOLD_NS = 16000000;
    private static final long NANOSECONDS_PER_MILLISECOND = 1000000;

    JankMetricCalculator() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (isFrameJanky(r8, r11) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long[] calculateJankBurstDurationsNs(long[] jArr, long[] jArr2) {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0 && j > 0 && !areFramesConsecutive(i - 1, i, jArr, jArr2)) {
                arrayList.add(Long.valueOf(j));
                j = 0;
            }
            long j2 = jArr2[i];
            if (!isFrameJanky(i, jArr2)) {
                if (j > 0) {
                    if (areFramesConsecutive(i - 1, i, jArr, jArr2)) {
                        int i2 = i + 1;
                        if (areFramesConsecutive(i, i2, jArr, jArr2)) {
                        }
                    }
                    arrayList.add(Long.valueOf(j));
                    j = 0;
                }
            }
            j += j2;
        }
        if (j > 0) {
            arrayList.add(Long.valueOf(j));
        }
        return longArrayToPrimitiveArray((Long[]) arrayList.toArray(new Long[arrayList.size()]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JankMetrics calculateJankMetrics(FrameMetrics frameMetrics) {
        long[] longArrayToPrimitiveArray = longArrayToPrimitiveArray(frameMetrics.timestampsNs);
        long[] longArrayToPrimitiveArray2 = longArrayToPrimitiveArray(frameMetrics.durationsNs);
        return new JankMetrics(longArrayToPrimitiveArray, longArrayToPrimitiveArray2, calculateJankBurstDurationsNs(longArrayToPrimitiveArray, longArrayToPrimitiveArray2), sumArray(frameMetrics.skippedFrames));
    }

    private static boolean isFrameJanky(int i, long[] jArr) {
        return i >= 0 && i < jArr.length && jArr[i] > JANK_THRESHOLD_NS;
    }

    private static boolean areFramesConsecutive(int i, int i2, long[] jArr, long[] jArr2) {
        if (i < 0 || i2 < 0 || i >= jArr.length || i2 >= jArr.length) {
            return false;
        }
        return (jArr[i2] - jArr2[i2]) - jArr[i] < JANK_BURST_CONSECUTIVE_FRAME_THRESHOLD_NS;
    }

    private static long[] longArrayToPrimitiveArray(Long[] lArr) {
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    private static int sumArray(Integer[] numArr) {
        int i = 0;
        for (Integer num : numArr) {
            i += num.intValue();
        }
        return i;
    }
}
