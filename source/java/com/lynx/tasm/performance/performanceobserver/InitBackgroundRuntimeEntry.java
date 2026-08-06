package com.lynx.tasm.performance.performanceobserver;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class InitBackgroundRuntimeEntry extends PerformanceEntry {
    public double loadCoreEnd;
    public double loadCoreStart;

    public InitBackgroundRuntimeEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.loadCoreStart = hashMap.get("loadCoreStart") != null ? ((Double) hashMap.get("loadCoreStart")).doubleValue() : -1.0d;
        this.loadCoreEnd = hashMap.get("loadCoreEnd") != null ? ((Double) hashMap.get("loadCoreEnd")).doubleValue() : -1.0d;
    }
}
