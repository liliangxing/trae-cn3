package com.ss.ttm.player.UnifiedCodec.pool;

/* loaded from: classes7.dex */
public interface Pool<T, Y> {
    void clear();

    boolean isEmpty();

    boolean isFull();

    T obtain(Y y);

    void put(T t);

    void remove(T t);
}
