package com.lynx.tasm.performance.performanceobserver;

import com.lynx.tasm.TimingHandler;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class InitLynxviewEntry extends PerformanceEntry {
    public double createLynxEnd;
    public double createLynxStart;

    public InitLynxviewEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.createLynxStart = hashMap.get(TimingHandler.CREATE_LYNX_START) != null ? ((Double) hashMap.get(TimingHandler.CREATE_LYNX_START)).doubleValue() : -1.0d;
        this.createLynxEnd = hashMap.get(TimingHandler.CREATE_LYNX_END) != null ? ((Double) hashMap.get(TimingHandler.CREATE_LYNX_END)).doubleValue() : -1.0d;
    }
}
