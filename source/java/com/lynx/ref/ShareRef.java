package com.lynx.ref;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public final class ShareRef<T> implements Cloneable {
    private static final Collection<Wrap> LIVE_OBJECTS = new HashSet();
    private final AtomicInteger mRefCount;
    private volatile boolean mReleased;
    private volatile ResourceReleaser<T> mReleaser;
    private volatile Wrap mWrap;

    public ShareRef(T t, ResourceReleaser<T> resourceReleaser) {
        this.mRefCount = new AtomicInteger(1);
        this.mReleaser = resourceReleaser;
        this.mWrap = new Wrap(t);
        Collection<Wrap> collection = LIVE_OBJECTS;
        synchronized (collection) {
            collection.add(this.mWrap);
        }
    }

    private ShareRef(AtomicInteger atomicInteger, ResourceReleaser<T> resourceReleaser, Wrap wrap) {
        this.mRefCount = atomicInteger;
        this.mReleaser = resourceReleaser;
        this.mWrap = wrap;
    }

    public int getRefCount() {
        return this.mRefCount.get();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public synchronized ShareRef<T> m9373clone() {
        if (this.mReleased) {
            throw new IllegalStateException("already released");
        }
        this.mRefCount.incrementAndGet();
        return new ShareRef<>(this.mRefCount, this.mReleaser, this.mWrap);
    }

    public synchronized T get() {
        if (this.mReleased) {
            return null;
        }
        return (T) this.mWrap.get();
    }

    public synchronized void release() {
        if (this.mReleased) {
            return;
        }
        this.mReleased = true;
        releaseIfNeeded();
        this.mWrap = null;
        this.mReleaser = null;
    }

    protected void finalize() throws Throwable {
        if (!this.mReleased) {
            releaseIfNeeded();
        }
        super.finalize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void releaseIfNeeded() {
        if (this.mRefCount.decrementAndGet() != 0) {
            return;
        }
        Object obj = this.mWrap.get();
        Collection<Wrap> collection = LIVE_OBJECTS;
        synchronized (collection) {
            collection.remove(this.mWrap);
        }
        if (this.mReleaser != null) {
            this.mReleaser.release(obj);
        }
    }
}
