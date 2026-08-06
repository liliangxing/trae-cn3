package com.lynx.tasm.performance.performanceobserver;

import com.lynx.tasm.performance.timing.TimingConstants;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class HostPlatformTiming {
    public double drawEnd;
    public double drawStart;
    public String hostPlatformType;
    public double layoutEnd;
    public double layoutStart;
    public double measureEnd;
    public double measureStart;

    public HostPlatformTiming(HashMap<String, Object> hashMap) {
        this.hostPlatformType = hashMap.get("hostPlatformType") != null ? (String) hashMap.get("hostPlatformType") : "";
        this.measureStart = hashMap.get(TimingConstants.HOST_PLATFORM_MEASURE_START) != null ? ((Double) hashMap.get(TimingConstants.HOST_PLATFORM_MEASURE_START)).doubleValue() : -1.0d;
        this.measureEnd = hashMap.get(TimingConstants.HOST_PLATFORM_MEASURE_END) != null ? ((Double) hashMap.get(TimingConstants.HOST_PLATFORM_MEASURE_END)).doubleValue() : -1.0d;
        this.layoutStart = hashMap.get(TimingConstants.HOST_PLATFORM_LAYOUT_START) != null ? ((Double) hashMap.get(TimingConstants.HOST_PLATFORM_LAYOUT_START)).doubleValue() : -1.0d;
        this.layoutEnd = hashMap.get(TimingConstants.HOST_PLATFORM_LAYOUT_END) != null ? ((Double) hashMap.get(TimingConstants.HOST_PLATFORM_LAYOUT_END)).doubleValue() : -1.0d;
        this.drawStart = hashMap.get(TimingConstants.HOST_PLATFORM_DRAW_START) != null ? ((Double) hashMap.get(TimingConstants.HOST_PLATFORM_DRAW_START)).doubleValue() : -1.0d;
        this.drawEnd = hashMap.get(TimingConstants.HOST_PLATFORM_DRAW_END) != null ? ((Double) hashMap.get(TimingConstants.HOST_PLATFORM_DRAW_END)).doubleValue() : -1.0d;
    }
}
