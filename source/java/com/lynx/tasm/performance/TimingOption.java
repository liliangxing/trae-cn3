package com.lynx.tasm.performance;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.performance.timing.TimingConstants;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TimingOption {
    public final String pipelineOrigin;
    public final HashMap<String, Long> timingInfo = new HashMap<>();

    public static TimingOption createTimingOption(String str, String str2) {
        TimingOption timingOption = new TimingOption(str);
        long currentSystemTimeMicroseconds = PerformanceController.currentSystemTimeMicroseconds();
        timingOption.setTiming(TimingConstants.PIPELINE_START, currentSystemTimeMicroseconds);
        timingOption.setTiming(str2, currentSystemTimeMicroseconds);
        return timingOption;
    }

    public TimingOption(String str) {
        this.pipelineOrigin = str;
    }

    public void setTiming(String str, long j) {
        this.timingInfo.put(str, Long.valueOf(j));
    }

    public void markTiming(String str) {
        this.timingInfo.put(str, Long.valueOf(PerformanceController.currentSystemTimeMicroseconds()));
    }

    public JavaOnlyMap toJavaOnlyMap() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString(TimingConstants.PIPELINE_ORIGIN, this.pipelineOrigin);
        javaOnlyMap.putMap(TimingConstants.TIMESTAMP_MAP, JavaOnlyMap.from(this.timingInfo));
        return javaOnlyMap;
    }
}
