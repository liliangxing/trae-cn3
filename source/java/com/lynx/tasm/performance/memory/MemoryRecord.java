package com.lynx.tasm.performance.memory;

import java.util.Map;

/* loaded from: classes7.dex */
public class MemoryRecord {
    private String mCategory;
    public Map<String, String> mDetail;
    public int mInstanceCount;
    public long mSizeBytes;

    public MemoryRecord(String str, long j, int i, Map<String, String> map) {
        this.mCategory = str;
        this.mSizeBytes = j;
        this.mInstanceCount = i;
        this.mDetail = map;
    }

    public String getCategory() {
        return this.mCategory;
    }
}
