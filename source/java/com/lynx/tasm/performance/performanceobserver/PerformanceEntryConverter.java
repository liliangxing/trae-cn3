package com.lynx.tasm.performance.performanceobserver;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.performance.timing.TimingConstants;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PerformanceEntryConverter {
    public static PerformanceEntry makePerformanceEntry(ReadableMap readableMap) {
        HashMap asHashMap = readableMap.asHashMap();
        String str = (String) asHashMap.get("name");
        String str2 = (String) asHashMap.get("entryType");
        if (str2.equals("pipeline") && str.equals("updateTriggeredByBts")) {
            return new PipelineEntry(readableMap.asHashMap());
        }
        if (str2.equals("pipeline") && str.equals(TimingConstants.UPDATE_TRIGGERED_BY_NATIVE)) {
            return new PipelineEntry(readableMap.asHashMap());
        }
        if (str2.equals("pipeline") && str.equals("reactLynxHydrate")) {
            return new PipelineEntry(readableMap.asHashMap());
        }
        if (str2.equals("pipeline") && str.equals("setNativeProps")) {
            return new PipelineEntry(readableMap.asHashMap());
        }
        if (str2.equals("pipeline") && str.equals("updateGlobalProps")) {
            return new PipelineEntry(readableMap.asHashMap());
        }
        if (str2.equals("pipeline") && str.equals(TimingConstants.LOAD_BUNDLE)) {
            return new LoadBundleEntry(readableMap.asHashMap());
        }
        if (str2.equals("init") && str.equals("container")) {
            return new InitContainerEntry(readableMap.asHashMap());
        }
        if (str2.equals("init") && str.equals("lynxview")) {
            return new InitLynxviewEntry(readableMap.asHashMap());
        }
        if (str2.equals("init") && str.equals("backgroundRuntime")) {
            return new InitBackgroundRuntimeEntry(readableMap.asHashMap());
        }
        if (str2.equals("metric") && str.equals("fcp")) {
            return new MetricFcpEntry(readableMap.asHashMap());
        }
        if (str2.equals("metric") && str.equals("fsp")) {
            return new MetricFspEntry(readableMap.asHashMap());
        }
        if (str2.equals("metric") && str.equals("actualFmp")) {
            return new MetricActualFmpEntry(readableMap.asHashMap());
        }
        if (str2.equals("pipeline") && str.equals(TimingConstants.RELOAD_BUNDLE_FROM_NATIVE)) {
            return new ReloadBundleEntry(readableMap.asHashMap());
        }
        if (str2.equals("pipeline") && str.equals("reloadBundleFromBts")) {
            return new ReloadBundleEntry(readableMap.asHashMap());
        }
        if (str2.equals("memory") && str.equals("memory")) {
            return new MemoryUsageEntry(readableMap.asHashMap());
        }
        if (str2.equals("resource") && str.equals("lazyBundle")) {
            return new LazyBundleEntry(readableMap.asHashMap());
        }
        if (str2.equals("jsBlocking") && str.equals("jsBlocking")) {
            return new JSBlockingEntry(readableMap.asHashMap());
        }
        return new PerformanceEntry(readableMap.asHashMap());
    }
}
