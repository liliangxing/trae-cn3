package com.lynx.animax.util;

import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.monitor.MetricsAndEventStore;
import com.lynx.animax.service.IAnimaXMonitorService;
import java.util.Map;

/* loaded from: classes6.dex */
public class AnimaXMetricsCallback {
    private final IAnimaXMonitorService mMonitor;
    private final Map<String, Object> mPlatform;
    private final String mTrigger;

    public AnimaXMetricsCallback(IAnimaXMonitorService iAnimaXMonitorService, String str, Map<String, Object> map) {
        this.mMonitor = iAnimaXMonitorService;
        this.mTrigger = str;
        this.mPlatform = map;
    }

    public void onMetricsReady(ReadableMap readableMap, ReadableMap readableMap2) {
        this.mMonitor.reportPerformanceMetrics(new MetricsAndEventStore(readableMap, readableMap2, this.mPlatform, this.mTrigger));
    }
}
