package com.bytedance.ies.bullet.pool.impl;

import android.view.View;
import com.bytedance.ies.bullet.p003ui.common.BulletCardView;
import com.bytedance.ies.bullet.p003ui.common.BulletContainerView;
import com.bytedance.ies.bullet.pool.api.IPreRenderBasicPoolWithKey;
import com.bytedance.ies.bullet.pool.api.IViewPool;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.CacheItem;
import com.bytedance.ies.bullet.service.base.CacheItemStatus;
import com.bytedance.ies.bullet.service.base.IEventObserver;
import com.bytedance.ies.bullet.service.base.IPreRenderCallback;
import com.bytedance.ies.bullet.service.base.PoolResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyPreRenderPool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016Jr\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122X\u0010\u0013\u001aT\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012%\u0012#\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u0014j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ies/bullet/pool/impl/KeyPreRenderPool;", "Lcom/bytedance/ies/bullet/pool/api/IPreRenderBasicPoolWithKey;", "", "Lcom/bytedance/ies/bullet/service/base/CacheItem;", "preRenderPoolSize", "", "observer", "Lcom/bytedance/ies/bullet/service/base/IEventObserver;", "(ILcom/bytedance/ies/bullet/service/base/IEventObserver;)V", "mPreRenderPool", "Lcom/bytedance/ies/bullet/pool/impl/KeyLruCachePool;", "clearAll", "", "fetch", "uniqueSchema", "preRender", "cacheKey", "callback", "Lcom/bytedance/ies/bullet/service/base/IPreRenderCallback;", "preRenderOp", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/bytedance/ies/bullet/service/base/CacheItemStatus;", "Lcom/bytedance/ies/bullet/pool/api/PreRenderOperationWithKey;", "remove", "", "resize", "newSize", "size", "toBulletView", "Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "view", "Landroid/view/View;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KeyPreRenderPool implements IPreRenderBasicPoolWithKey<String, CacheItem> {
    private final KeyLruCachePool mPreRenderPool;
    private IEventObserver observer;
    private final int preRenderPoolSize;

    public KeyPreRenderPool(int i, IEventObserver iEventObserver) {
        this.preRenderPoolSize = i;
        this.observer = iEventObserver;
        this.mPreRenderPool = new KeyLruCachePool(i, this.observer);
    }

    public /* synthetic */ KeyPreRenderPool(int i, IEventObserver iEventObserver, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : iEventObserver);
    }

    @Override // com.bytedance.ies.bullet.pool.api.IPreRenderBasicPoolWithKey
    public void preRender(final String cacheKey, final IPreRenderCallback callback, Function2<? super String, ? super Function2<? super CacheItemStatus, ? super CacheItem, Unit>, Unit> preRenderOp) {
        String str;
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(preRenderOp, "preRenderOp");
        if (this.mPreRenderPool.contains(cacheKey)) {
            CacheItem cacheItem = this.mPreRenderPool.get(cacheKey, false);
            View view = cacheItem != null ? cacheItem.getView() : null;
            BulletCardView bulletCardView = view instanceof BulletCardView ? (BulletCardView) view : null;
            if (bulletCardView == null || (str = bulletCardView.getSessionId()) == null) {
                str = "";
            }
            callback.onSuccess(str);
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "PreRender cacheKey " + cacheKey + " already exists", null, "XPreRender", 2, null);
            return;
        }
        try {
            preRenderOp.invoke(cacheKey, new Function2<CacheItemStatus, CacheItem, Unit>() { // from class: com.bytedance.ies.bullet.pool.impl.KeyPreRenderPool$preRender$1

                /* compiled from: KeyPreRenderPool.kt */
                @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[CacheItemStatus.values().length];
                        try {
                            iArr[CacheItemStatus.LOADING.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[CacheItemStatus.SUCCESS.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[CacheItemStatus.FAILED.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((CacheItemStatus) obj, (CacheItem) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(CacheItemStatus cacheItemStatus, CacheItem cacheItem2) {
                    KeyLruCachePool keyLruCachePool;
                    String str2;
                    KeyLruCachePool keyLruCachePool2;
                    BulletContainerView bulletView;
                    KeyLruCachePool keyLruCachePool3;
                    Intrinsics.checkNotNullParameter(cacheItemStatus, "status");
                    Intrinsics.checkNotNullParameter(cacheItem2, "cacheItem");
                    int i = WhenMappings.$EnumSwitchMapping$0[cacheItemStatus.ordinal()];
                    if (i == 1) {
                        keyLruCachePool = KeyPreRenderPool.this.mPreRenderPool;
                        keyLruCachePool.put(cacheKey, cacheItem2);
                        return;
                    }
                    if (i == 2) {
                        View view2 = cacheItem2.getView();
                        BulletCardView bulletCardView2 = view2 instanceof BulletCardView ? (BulletCardView) view2 : null;
                        if (bulletCardView2 == null || (str2 = bulletCardView2.getSessionId()) == null) {
                            str2 = "";
                        }
                        callback.onSuccess(str2);
                        BulletLogger.printLog$default(BulletLogger.INSTANCE, "PreRender cacheKey " + cacheKey + " success", null, "XPreRender", 2, null);
                        return;
                    }
                    if (i != 3) {
                        return;
                    }
                    IPreRenderCallback.DefaultImpls.onFailed$default(callback, PoolResult.FAIL_LOAD_ERROR, null, 2, null);
                    keyLruCachePool2 = KeyPreRenderPool.this.mPreRenderPool;
                    if (keyLruCachePool2.contains(cacheKey)) {
                        bulletView = KeyPreRenderPool.this.toBulletView(cacheItem2.getView());
                        if (bulletView != null) {
                            bulletView.release();
                        }
                        keyLruCachePool3 = KeyPreRenderPool.this.mPreRenderPool;
                        keyLruCachePool3.remove(cacheKey);
                    }
                }
            });
        } catch (Exception e) {
            if (this.mPreRenderPool.contains(cacheKey)) {
                this.mPreRenderPool.remove(cacheKey);
            }
            callback.onFailed(PoolResult.FAIL_EXCEPTION, e.getMessage());
        }
    }

    @Override // com.bytedance.ies.bullet.pool.api.IBasicPool
    public CacheItem fetch(String uniqueSchema) {
        Intrinsics.checkNotNullParameter(uniqueSchema, "uniqueSchema");
        return (CacheItem) IViewPool.DefaultImpls.get$default(this.mPreRenderPool, uniqueSchema, false, 2, null);
    }

    @Override // com.bytedance.ies.bullet.pool.api.IBasicPool
    public void clearAll() {
        this.mPreRenderPool.clearAll();
    }

    @Override // com.bytedance.ies.bullet.pool.api.IBasicPool
    public void resize(int newSize) {
        this.mPreRenderPool.resize(newSize);
    }

    @Override // com.bytedance.ies.bullet.pool.api.IBasicPool
    public int size() {
        return this.mPreRenderPool.size();
    }

    @Override // com.bytedance.ies.bullet.pool.api.IBasicPool
    public boolean remove(String uniqueSchema) {
        Intrinsics.checkNotNullParameter(uniqueSchema, "uniqueSchema");
        return this.mPreRenderPool.remove(uniqueSchema);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BulletContainerView toBulletView(View view) {
        if (view == null) {
            return null;
        }
        if (!(view instanceof BulletContainerView)) {
            view = null;
        }
        if (view != null) {
            return (BulletContainerView) view;
        }
        return null;
    }
}
