package com.bytedance.pia.core.misc;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;

    public LRUCache(int i) {
        super(i, 1.0f, true);
        this.cacheSize = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry entry) {
        return size() > this.cacheSize;
    }
}
