package com.lynx.tasm.performance.performanceobserver;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class MemoryUsageItem {
    public String category;
    public HashMap<String, String> detail;
    public long sizeBytes;

    public MemoryUsageItem(HashMap<String, Object> hashMap) {
        this.category = hashMap.get("category") != null ? (String) hashMap.get("category") : "";
        this.sizeBytes = hashMap.get("sizeBytes") != null ? ((Long) hashMap.get("sizeBytes")).longValue() : -1L;
        this.detail = hashMap.get("detail") != null ? (HashMap) hashMap.get("detail") : new HashMap<>();
    }
}
