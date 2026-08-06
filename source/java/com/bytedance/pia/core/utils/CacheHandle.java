package com.bytedance.pia.core.utils;

import com.bytedance.pia.core.api.utils.IConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* loaded from: classes4.dex */
public class CacheHandle<T> {
    private final AtomicReference<IConsumer<T>> consumer = new AtomicReference<>();
    private final ConcurrentLinkedQueue<T> cache = new ConcurrentLinkedQueue<>();
    private final AtomicBoolean isProcessing = new AtomicBoolean(false);
    private volatile boolean isClose = false;

    public void offer(T t) {
        if (this.isClose) {
            return;
        }
        this.cache.offer(t);
        process();
    }

    public boolean hasConsumer() {
        return (this.isClose || this.consumer.get() == null) ? false : true;
    }

    public void setConsumer(IConsumer<T> iConsumer) {
        if (this.isClose) {
            return;
        }
        UByte$$ExternalSyntheticBackport0.m((AtomicReference) this.consumer, (Object) null, (Object) iConsumer);
        process();
    }

    public void close() {
        this.isClose = true;
        process();
        this.consumer.set(null);
    }

    private void process() {
        if (this.consumer.get() != null && this.isProcessing.compareAndSet(false, true)) {
            while (!this.cache.isEmpty()) {
                T poll = this.cache.poll();
                if (poll != null) {
                    this.consumer.get().accept(poll);
                }
            }
            this.isProcessing.set(false);
        }
    }
}
