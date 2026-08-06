package com.lynx.tasm.performance.performanceobserver;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class MetricFcpEntry extends PerformanceEntry {
    public PerformanceMetric fcp;
    public PerformanceMetric lynxFcp;
    public PerformanceMetric totalFcp;

    public MetricFcpEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.fcp = hashMap.get("fcp") != null ? new PerformanceMetric((HashMap) hashMap.get("fcp")) : new PerformanceMetric(new HashMap());
        this.lynxFcp = hashMap.get("lynxFcp") != null ? new PerformanceMetric((HashMap) hashMap.get("lynxFcp")) : new PerformanceMetric(new HashMap());
        this.totalFcp = hashMap.get("totalFcp") != null ? new PerformanceMetric((HashMap) hashMap.get("totalFcp")) : new PerformanceMetric(new HashMap());
    }
}
