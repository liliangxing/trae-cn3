package com.lynx.tasm.performance.performanceobserver;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class JSBlockingEntry extends PerformanceEntry {
    public double avg_blocking_time;
    public double blocking_ratio;
    public String stage;
    public double time_after_fcp;
    public double total_blocking_count;
    public double total_blocking_time;
    public double total_duration;

    public JSBlockingEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.stage = hashMap.get("stage") != null ? (String) hashMap.get("stage") : "";
        this.total_blocking_time = hashMap.get("total_blocking_time") != null ? ((Double) hashMap.get("total_blocking_time")).doubleValue() : -1.0d;
        this.total_blocking_count = hashMap.get("total_blocking_count") != null ? ((Double) hashMap.get("total_blocking_count")).doubleValue() : -1.0d;
        this.total_duration = hashMap.get("total_duration") != null ? ((Double) hashMap.get("total_duration")).doubleValue() : -1.0d;
        this.blocking_ratio = hashMap.get("blocking_ratio") != null ? ((Double) hashMap.get("blocking_ratio")).doubleValue() : -1.0d;
        this.avg_blocking_time = hashMap.get("avg_blocking_time") != null ? ((Double) hashMap.get("avg_blocking_time")).doubleValue() : -1.0d;
        this.time_after_fcp = hashMap.get("time_after_fcp") != null ? ((Double) hashMap.get("time_after_fcp")).doubleValue() : -1.0d;
    }
}
