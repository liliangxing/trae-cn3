package com.bytedance.push.notification;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class MaxSizeHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public MaxSizeHashMap(int i) {
        this.maxSize = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.maxSize;
    }
}
