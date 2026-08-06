package com.bytedance.realx.video;

/* loaded from: classes4.dex */
public class TimestampAligner {
    private volatile long nativeTimestampAligner = nativeCreateTimestampAligner();

    private static native long nativeCreateTimestampAligner();

    private static native void nativeReleaseTimestampAligner(long timestampAligner);

    private static native long nativeRtcTimeNanos();

    private static native long nativeTranslateTimestamp(long timestampAligner, long cameraTimeNs);

    public static long getRtcTimeNanos() {
        return nativeRtcTimeNanos();
    }

    public long translateTimestamp(long cameraTimeNs) {
        checkNativeAlignerExists();
        return nativeTranslateTimestamp(this.nativeTimestampAligner, cameraTimeNs);
    }

    public void dispose() {
        checkNativeAlignerExists();
        nativeReleaseTimestampAligner(this.nativeTimestampAligner);
        this.nativeTimestampAligner = 0L;
    }

    private void checkNativeAlignerExists() {
        if (this.nativeTimestampAligner == 0) {
            throw new IllegalStateException("TimestampAligner has been disposed.");
        }
    }
}
