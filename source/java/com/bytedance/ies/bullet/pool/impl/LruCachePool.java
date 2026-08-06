package com.bytedance.ies.bullet.pool.impl;

import android.net.Uri;
import android.util.LruCache;
import android.view.View;
import com.bytedance.ies.bullet.p003ui.common.BulletContainerView;
import com.bytedance.ies.bullet.pool.api.IViewPool;
import com.bytedance.ies.bullet.pool.util.PoolUtilKt;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.base.CacheItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LruCachePool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f*\u0001\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/pool/impl/LruCachePool;", "Lcom/bytedance/ies/bullet/pool/api/IViewPool;", "Landroid/net/Uri;", "Lcom/bytedance/ies/bullet/service/base/CacheItem;", "maxSize", "", "(I)V", "mLruCache", "com/bytedance/ies/bullet/pool/impl/LruCachePool$createLruCache$1", "Lcom/bytedance/ies/bullet/pool/impl/LruCachePool$createLruCache$1;", "clearAll", "", "contains", "", "uniqueSchema", "createLruCache", "(I)Lcom/bytedance/ies/bullet/pool/impl/LruCachePool$createLruCache$1;", PrefetchRequestConfig.METHOD_GET, "evict", "put", "cache", "remove", "resize", "newSize", "size", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LruCachePool implements IViewPool<Uri, CacheItem> {
    private LruCachePool$createLruCache$1 mLruCache;

    public LruCachePool(int i) {
        this.mLruCache = createLruCache(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ies.bullet.pool.impl.LruCachePool$createLruCache$1] */
    private final LruCachePool$createLruCache$1 createLruCache(final int maxSize) {
        return new LruCache<Uri, CacheItem>(maxSize) { // from class: com.bytedance.ies.bullet.pool.impl.LruCachePool$createLruCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public void entryRemoved(boolean evicted, Uri key, CacheItem oldValue, CacheItem newValue) {
                View view;
                BulletContainerView bulletView;
                super.entryRemoved(evicted, (boolean) key, oldValue, newValue);
                if (!evicted || oldValue == null || (view = oldValue.getView()) == null || (bulletView = PoolUtilKt.toBulletView(view)) == null) {
                    return;
                }
                bulletView.release();
            }
        };
    }

    @Override // com.bytedance.ies.bullet.pool.api.IViewPool
    public boolean put(Uri uniqueSchema, CacheItem cache) {
        Intrinsics.checkNotNullParameter(uniqueSchema, "uniqueSchema");
        Intrinsics.checkNotNullParameter(cache, "cache");
        put(uniqueSchema, cache);
        return true;
    }

    @Override // com.bytedance.ies.bullet.pool.api.IViewPool
    public CacheItem get(Uri uniqueSchema, boolean evict) {
        Intrinsics.checkNotNullParameter(uniqueSchema, "uniqueSchema");
        if (evict) {
            return remove(uniqueSchema);
        }
        return get(uniqueSchema);
    }

    @Override // com.bytedance.ies.bullet.pool.api.IViewPool
    public boolean contains(Uri uniqueSchema) {
        Intrinsics.checkNotNullParameter(uniqueSchema, "uniqueSchema");
        return get(uniqueSchema) != null;
    }

    @Override // com.bytedance.ies.bullet.pool.api.IViewPool
    public void clearAll() {
        evictAll();
    }

    @Override // com.bytedance.ies.bullet.pool.api.IViewPool
    public void resize(int newSize) {
        evictAll();
        this.mLruCache = createLruCache(newSize);
    }

    @Override // com.bytedance.ies.bullet.pool.api.IViewPool
    public int size() {
        return size();
    }

    @Override // com.bytedance.ies.bullet.pool.api.IViewPool
    public boolean remove(Uri uniqueSchema) {
        View view;
        BulletContainerView bulletView;
        Intrinsics.checkNotNullParameter(uniqueSchema, "uniqueSchema");
        CacheItem remove = remove(uniqueSchema);
        if (remove != null && (view = remove.getView()) != null && (bulletView = PoolUtilKt.toBulletView(view)) != null) {
            bulletView.release();
        }
        return remove != null;
    }
}
