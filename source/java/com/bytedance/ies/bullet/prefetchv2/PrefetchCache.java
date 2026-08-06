package com.bytedance.ies.bullet.prefetchv2;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchCache;", "", "context", "Landroid/content/Context;", "cacheCapacity", "", "(Landroid/content/Context;I)V", "getContext", "()Landroid/content/Context;", "memCache", "Lcom/bytedance/ies/bullet/prefetchv2/TrimmableLruCache;", "", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchResult;", "clear", "", "delete", "request", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest;", PrefetchRequestConfig.METHOD_GET, "memOnly", "", "put", "result", "trim", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchCache {
    private final Context context;
    private final TrimmableLruCache<String, PrefetchResult> memCache;

    public PrefetchCache(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.memCache = new TrimmableLruCache<>(i, new Function2<String, PrefetchResult, Boolean>() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchCache$memCache$1
            public final Boolean invoke(String str, PrefetchResult prefetchResult) {
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(prefetchResult, "v");
                return Boolean.valueOf(prefetchResult.isExpire());
            }
        }, new Function2<String, PrefetchResult, Unit>() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchCache$memCache$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (PrefetchResult) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, PrefetchResult prefetchResult) {
                Intrinsics.checkNotNullParameter(str, "k");
                Intrinsics.checkNotNullParameter(prefetchResult, "v");
                PrefetchLogger.INSTANCE.m36d("Prefetch 缓存过期移除，key: " + str);
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    public final synchronized void put(PrefetchRequest request, PrefetchResult result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        this.memCache.put(request.getRequestKey(), result);
    }

    public static /* synthetic */ PrefetchResult get$default(PrefetchCache prefetchCache, PrefetchRequest prefetchRequest, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return prefetchCache.get(prefetchRequest, z);
    }

    public final synchronized PrefetchResult get(PrefetchRequest request, boolean memOnly) {
        Intrinsics.checkNotNullParameter(request, "request");
        PrefetchResult prefetchResult = this.memCache.get(request.getRequestKey());
        if (prefetchResult == null) {
            return null;
        }
        if (!prefetchResult.isExpire()) {
            return prefetchResult;
        }
        PrefetchLogger.INSTANCE.m39w("内存缓存过期: " + request.getRequestKey());
        trim();
        return null;
    }

    public final synchronized PrefetchResult delete(PrefetchRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.memCache.remove(request.getRequestKey());
    }

    public final synchronized void trim() {
        this.memCache.trim();
    }

    public final void clear() {
        this.memCache.evictAll();
    }
}
