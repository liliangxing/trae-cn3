package com.lynx.tasm.performance.performanceobserver;

import com.lynx.tasm.performance.timing.TimingConstants;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class LoadBundleEntry extends PipelineEntry {
    public double ffiEnd;
    public double ffiStart;
    public double loadBackgroundEnd;
    public double loadBackgroundStart;
    public double loadBundleEnd;
    public double loadBundleStart;
    public double parseEnd;
    public double parseStart;
    public double verifyTasmEnd;
    public double verifyTasmStart;

    public LoadBundleEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.loadBundleStart = hashMap.get(TimingConstants.LOAD_BUNDLE_START) != null ? ((Double) hashMap.get(TimingConstants.LOAD_BUNDLE_START)).doubleValue() : -1.0d;
        this.loadBundleEnd = hashMap.get("loadBundleEnd") != null ? ((Double) hashMap.get("loadBundleEnd")).doubleValue() : -1.0d;
        this.parseStart = hashMap.get("parseStart") != null ? ((Double) hashMap.get("parseStart")).doubleValue() : -1.0d;
        this.parseEnd = hashMap.get("parseEnd") != null ? ((Double) hashMap.get("parseEnd")).doubleValue() : -1.0d;
        this.loadBackgroundStart = hashMap.get("loadBackgroundStart") != null ? ((Double) hashMap.get("loadBackgroundStart")).doubleValue() : -1.0d;
        this.loadBackgroundEnd = hashMap.get("loadBackgroundEnd") != null ? ((Double) hashMap.get("loadBackgroundEnd")).doubleValue() : -1.0d;
        this.verifyTasmStart = hashMap.get(TimingConstants.VERIFY_TASM_START) != null ? ((Double) hashMap.get(TimingConstants.VERIFY_TASM_START)).doubleValue() : -1.0d;
        this.verifyTasmEnd = hashMap.get(TimingConstants.VERIFY_TASM_END) != null ? ((Double) hashMap.get(TimingConstants.VERIFY_TASM_END)).doubleValue() : -1.0d;
        this.ffiStart = hashMap.get(TimingConstants.FFI_START) != null ? ((Double) hashMap.get(TimingConstants.FFI_START)).doubleValue() : -1.0d;
        this.ffiEnd = hashMap.get("ffiEnd") != null ? ((Double) hashMap.get("ffiEnd")).doubleValue() : -1.0d;
    }
}
