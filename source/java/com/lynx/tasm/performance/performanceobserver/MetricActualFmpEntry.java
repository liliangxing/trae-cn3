package com.lynx.tasm.performance.performanceobserver;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class MetricActualFmpEntry extends PerformanceEntry {
    public PerformanceMetric actualFmp;
    public PerformanceMetric lynxActualFmp;
    public PerformanceMetric totalActualFmp;

    public MetricActualFmpEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.actualFmp = hashMap.get("actualFmp") != null ? new PerformanceMetric((HashMap) hashMap.get("actualFmp")) : new PerformanceMetric(new HashMap());
        this.lynxActualFmp = hashMap.get("lynxActualFmp") != null ? new PerformanceMetric((HashMap) hashMap.get("lynxActualFmp")) : new PerformanceMetric(new HashMap());
        this.totalActualFmp = hashMap.get("totalActualFmp") != null ? new PerformanceMetric((HashMap) hashMap.get("totalActualFmp")) : new PerformanceMetric(new HashMap());
    }
}
