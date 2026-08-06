package com.lynx.tasm.performance.timing;

/* loaded from: classes7.dex */
public interface ITimingCollector {
    void markHostPlatformTiming(String str);

    void markPaintEndTimingIfNeeded();

    void markTiming(String str, String str2);

    void setMsTiming(String str, long j, String str2);

    void setNeedMarkPaintEndTiming(String str);
}
