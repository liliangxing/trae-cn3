package com.facebook.cache.common;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class MultiCacheEventListener implements CacheEventListener {
    private List<CacheEventListener> mCacheEventListeners = new CopyOnWriteArrayList();

    public void addCacheEventListener(CacheEventListener cacheEventListener) {
        this.mCacheEventListeners.add(cacheEventListener);
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onHit(CacheEvent cacheEvent) {
        Iterator<CacheEventListener> it = this.mCacheEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onHit(cacheEvent);
        }
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onMiss(CacheEvent cacheEvent) {
        Iterator<CacheEventListener> it = this.mCacheEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onMiss(cacheEvent);
        }
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteAttempt(CacheEvent cacheEvent) {
        Iterator<CacheEventListener> it = this.mCacheEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onWriteAttempt(cacheEvent);
        }
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteSuccess(CacheEvent cacheEvent) {
        Iterator<CacheEventListener> it = this.mCacheEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onWriteSuccess(cacheEvent);
        }
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onReadException(CacheEvent cacheEvent) {
        Iterator<CacheEventListener> it = this.mCacheEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onReadException(cacheEvent);
        }
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onWriteException(CacheEvent cacheEvent) {
        Iterator<CacheEventListener> it = this.mCacheEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onWriteException(cacheEvent);
        }
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onEviction(CacheEvent cacheEvent) {
        Iterator<CacheEventListener> it = this.mCacheEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onEviction(cacheEvent);
        }
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public void onCleared() {
        Iterator<CacheEventListener> it = this.mCacheEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onCleared();
        }
    }
}
