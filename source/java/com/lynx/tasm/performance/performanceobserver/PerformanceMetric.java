package com.lynx.tasm.performance.performanceobserver;

import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class PerformanceMetric {
    public double duration;
    public double endTimestamp;
    public String endTimestampName;
    public String name;
    public double startTimestamp;
    public String startTimestampName;

    public PerformanceMetric(HashMap<String, Object> hashMap) {
        this.name = hashMap.get("name") != null ? (String) hashMap.get("name") : "";
        this.duration = hashMap.get("duration") != null ? ((Double) hashMap.get("duration")).doubleValue() : -1.0d;
        this.startTimestampName = hashMap.get(LynxTimingPerformanceReportProcessor.KEY_START_TIMESTAMP_NAME) != null ? (String) hashMap.get(LynxTimingPerformanceReportProcessor.KEY_START_TIMESTAMP_NAME) : "";
        this.startTimestamp = hashMap.get("startTimestamp") != null ? ((Double) hashMap.get("startTimestamp")).doubleValue() : -1.0d;
        this.endTimestampName = hashMap.get(LynxTimingPerformanceReportProcessor.KEY_END_TIMESTAMP_NAME) != null ? (String) hashMap.get(LynxTimingPerformanceReportProcessor.KEY_END_TIMESTAMP_NAME) : "";
        this.endTimestamp = hashMap.get("endTimestamp") != null ? ((Double) hashMap.get("endTimestamp")).doubleValue() : -1.0d;
    }
}
