package com.bytedance.apm6.util.cache;

import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class LimitedQueue<T> {
    private final int cacheSize;
    private EvictListener<T> evictListener;
    private ConcurrentLinkedQueue<T> queue = new ConcurrentLinkedQueue<>();

    /* loaded from: classes3.dex */
    public interface EvictListener<T> {
        void onEvict(T t);
    }

    public LimitedQueue(int i) {
        this.cacheSize = i;
    }

    public void setEvictListener(EvictListener<T> evictListener) {
        this.evictListener = evictListener;
    }

    public void push(T t) {
        this.queue.add(t);
        if (this.queue.size() > this.cacheSize) {
            T poll = this.queue.poll();
            EvictListener<T> evictListener = this.evictListener;
            if (evictListener != null) {
                evictListener.onEvict(poll);
            }
        }
    }

    public T pop() {
        return this.queue.poll();
    }

    public T peek() {
        return this.queue.peek();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void clear() {
        this.queue.clear();
    }
}
