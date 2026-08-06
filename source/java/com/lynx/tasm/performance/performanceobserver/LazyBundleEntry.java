package com.lynx.tasm.performance.performanceobserver;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class LazyBundleEntry extends PerformanceEntry {
    public String componentUrl;
    public double decodeEnd;
    public double decodeStart;
    public boolean loadSuccess;
    public String mode;
    public double requireEnd;
    public double requireStart;
    public double size;
    public boolean sync;

    public LazyBundleEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.componentUrl = hashMap.get("componentUrl") != null ? (String) hashMap.get("componentUrl") : "";
        this.mode = hashMap.get("mode") != null ? (String) hashMap.get("mode") : "";
        this.size = hashMap.get("size") != null ? ((Double) hashMap.get("size")).doubleValue() : -1.0d;
        this.sync = hashMap.get("sync") != null ? ((Boolean) hashMap.get("sync")).booleanValue() : false;
        this.loadSuccess = hashMap.get("loadSuccess") != null ? ((Boolean) hashMap.get("loadSuccess")).booleanValue() : false;
        this.requireStart = hashMap.get("requireStart") != null ? ((Double) hashMap.get("requireStart")).doubleValue() : -1.0d;
        this.requireEnd = hashMap.get("requireEnd") != null ? ((Double) hashMap.get("requireEnd")).doubleValue() : -1.0d;
        this.decodeStart = hashMap.get("decodeStart") != null ? ((Double) hashMap.get("decodeStart")).doubleValue() : -1.0d;
        this.decodeEnd = hashMap.get("decodeEnd") != null ? ((Double) hashMap.get("decodeEnd")).doubleValue() : -1.0d;
    }
}
