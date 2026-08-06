package com.lynx.tasm.base;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class GlobalRefQueue {
    private final ConcurrentHashMap<Long, Object> mRefs = new ConcurrentHashMap<>();
    private final AtomicLong mIndex = new AtomicLong(0);

    public long push(Object obj) {
        if (obj == null) {
            return -1L;
        }
        long incrementAndGet = this.mIndex.incrementAndGet();
        this.mRefs.put(Long.valueOf(incrementAndGet), obj);
        return incrementAndGet;
    }

    public Object pop(long j) {
        if (j < 0) {
            return null;
        }
        return this.mRefs.remove(Long.valueOf(j));
    }
}
