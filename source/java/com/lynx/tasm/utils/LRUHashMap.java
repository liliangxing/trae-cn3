package com.lynx.tasm.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class LRUHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUHashMap(int i) {
        super(i, 0.75f, true);
        this.capacity = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
