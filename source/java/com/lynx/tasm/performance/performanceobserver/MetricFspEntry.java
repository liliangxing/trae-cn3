package com.lynx.tasm.performance.performanceobserver;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class MetricFspEntry extends PerformanceEntry {
    public PerformanceMetric fsp;
    public PerformanceMetric lynxFsp;
    public PerformanceMetric totalFsp;

    public MetricFspEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.fsp = hashMap.get("fsp") != null ? new PerformanceMetric((HashMap) hashMap.get("fsp")) : new PerformanceMetric(new HashMap());
        this.lynxFsp = hashMap.get("lynxFsp") != null ? new PerformanceMetric((HashMap) hashMap.get("lynxFsp")) : new PerformanceMetric(new HashMap());
        this.totalFsp = hashMap.get("totalFsp") != null ? new PerformanceMetric((HashMap) hashMap.get("totalFsp")) : new PerformanceMetric(new HashMap());
    }
}
