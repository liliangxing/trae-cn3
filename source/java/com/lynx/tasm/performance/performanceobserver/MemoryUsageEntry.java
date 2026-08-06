package com.lynx.tasm.performance.performanceobserver;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class MemoryUsageEntry extends PerformanceEntry {
    public HashMap<String, MemoryUsageItem> detail;
    public long sizeBytes;

    /* JADX WARN: Multi-variable type inference failed */
    public MemoryUsageEntry(HashMap<String, Object> hashMap) {
        super(hashMap);
        this.sizeBytes = hashMap.get("sizeBytes") != null ? ((Long) hashMap.get("sizeBytes")).longValue() : -1L;
        HashMap hashMap2 = hashMap.get("detail") != null ? (HashMap) hashMap.get("detail") : new HashMap();
        this.detail = new HashMap<>();
        for (Map.Entry entry : hashMap2.entrySet()) {
            this.detail.put(entry.getKey(), new MemoryUsageItem((HashMap) entry.getValue()));
        }
    }
}
