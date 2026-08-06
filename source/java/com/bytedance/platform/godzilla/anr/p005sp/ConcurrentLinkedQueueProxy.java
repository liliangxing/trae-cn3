package com.bytedance.platform.godzilla.anr.p005sp;

import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ConcurrentLinkedQueueProxy<E> extends ConcurrentLinkedQueue<E> {
    public ConcurrentLinkedQueue<Runnable> workFinishers;

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public E poll() {
        return null;
    }

    public ConcurrentLinkedQueueProxy(ConcurrentLinkedQueue<Runnable> concurrentLinkedQueue) {
        this.workFinishers = concurrentLinkedQueue;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        return this.workFinishers.add((Runnable) e);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.workFinishers.remove(obj);
    }
}
