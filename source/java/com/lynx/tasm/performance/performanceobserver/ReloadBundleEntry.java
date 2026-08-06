package com.lynx.tasm.performance.performanceobserver;

import com.lynx.tasm.performance.timing.TimingConstants;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class ReloadBundleEntry extends PipelineEntry {
    public double ffiEnd;
    public double ffiStart;
    public double reloadBackgroundEnd;
    public double reloadBackgroundStart;
    public double reloadBundleEnd;
    public double reloadBundleStart;

    public ReloadBundleEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.reloadBundleStart = hashMap.get(TimingConstants.RELOAD_BUNDLE_START) != null ? ((Double) hashMap.get(TimingConstants.RELOAD_BUNDLE_START)).doubleValue() : -1.0d;
        this.reloadBundleEnd = hashMap.get("reloadBundleEnd") != null ? ((Double) hashMap.get("reloadBundleEnd")).doubleValue() : -1.0d;
        this.reloadBackgroundStart = hashMap.get("reloadBackgroundStart") != null ? ((Double) hashMap.get("reloadBackgroundStart")).doubleValue() : -1.0d;
        this.reloadBackgroundEnd = hashMap.get("reloadBackgroundEnd") != null ? ((Double) hashMap.get("reloadBackgroundEnd")).doubleValue() : -1.0d;
        this.ffiStart = hashMap.get(TimingConstants.FFI_START) != null ? ((Double) hashMap.get(TimingConstants.FFI_START)).doubleValue() : -1.0d;
        this.ffiEnd = hashMap.get("ffiEnd") != null ? ((Double) hashMap.get("ffiEnd")).doubleValue() : -1.0d;
    }
}
