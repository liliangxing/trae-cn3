package com.bytedance.ies.bullet.pool.impl;

import android.net.Uri;
import com.bytedance.ies.bullet.p003ui.common.BulletContainerView;
import com.bytedance.ies.bullet.pool.api.IReUseBasicPool;
import com.bytedance.ies.bullet.pool.api.IViewPool;
import com.bytedance.ies.bullet.pool.util.PoolUtilKt;
import com.bytedance.ies.bullet.service.base.CacheItem;
import com.bytedance.ies.bullet.service.base.PoolResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReUsePool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/pool/impl/ReUsePool;", "Lcom/bytedance/ies/bullet/pool/api/IReUseBasicPool;", "Landroid/net/Uri;", "Lcom/bytedance/ies/bullet/service/base/CacheItem;", "reUsePoolSize", "", "(I)V", "mReUsePool", "Lcom/bytedance/ies/bullet/pool/impl/LruCachePool;", "clearAll", "", "fetch", "uniqueSchema", "reUse", "Lcom/bytedance/ies/bullet/service/base/PoolResult;", "cacheItem", "remove", "", "resize", "newSize", "size", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ReUsePool implements IReUseBasicPool<Uri, CacheItem> {
    private final LruCachePool mReUsePool;
    private final int reUsePoolSize;

    public ReUsePool(int i) {
        this.reUsePoolSize = i;
        this.mReUsePool = new LruCachePool(i);
    }

    @Override // com.bytedance.ies.bullet.pool.api.IReUseBasicPool
    public PoolResult reUse(CacheItem cacheItem) {
        Intrinsics.checkNotNullParameter(cacheItem, "cacheItem");
        if (this.mReUsePool.contains(cacheItem.getUniqueSchema())) {
            return PoolResult.FAIL_EXISTS;
        }
        BulletContainerView bulletView = PoolUtilKt.toBulletView(cacheItem.getView());
        boolean z = false;
        if (bulletView != null && !bulletView.isLoadSuccess()) {
            z = true;
        }
        if (z) {
            return PoolResult.FAIL_LOAD_ERROR;
        }
        this.mReUsePool.put(cacheItem.getUniqueSchema(), cacheItem);
        return PoolResult.SUCCESS;
    }

    @Override // com.bytedance.ies.bullet.pool.api.IBasicPool
    public CacheItem fetch(Uri uniqueSchema) {
        Intrinsics.checkNotNullParameter(uniqueSchema, "uniqueSchema");
        return (CacheItem) IViewPool.DefaultImpls.get$default(this.mReUsePool, uniqueSchema, false, 2, null);
    }

    @Override // com.bytedance.ies.bullet.pool.api.IBasicPool
    public void clearAll() {
        this.mReUsePool.clearAll();
    }

    @Override // com.bytedance.ies.bullet.pool.api.IBasicPool
    public void resize(int newSize) {
        this.mReUsePool.resize(newSize);
    }

    @Override // com.bytedance.ies.bullet.pool.api.IBasicPool
    public int size() {
        return this.mReUsePool.size();
    }

    @Override // com.bytedance.ies.bullet.pool.api.IBasicPool
    public boolean remove(Uri uniqueSchema) {
        Intrinsics.checkNotNullParameter(uniqueSchema, "uniqueSchema");
        return this.mReUsePool.remove(uniqueSchema);
    }
}
