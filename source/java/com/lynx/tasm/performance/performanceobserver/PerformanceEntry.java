package com.lynx.tasm.performance.performanceobserver;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class PerformanceEntry {
    public String entryType;
    public String name;
    public HashMap<String, Object> rawMap;

    public PerformanceEntry(HashMap<String, Object> hashMap) {
        this.name = hashMap.get("name") != null ? (String) hashMap.get("name") : "";
        this.entryType = hashMap.get("entryType") != null ? (String) hashMap.get("entryType") : "";
        this.rawMap = hashMap;
    }

    public HashMap<String, Object> toHashMap() {
        return this.rawMap;
    }
}
