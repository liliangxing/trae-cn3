package com.bytedance.ies.bullet.preloadv2.cache;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: PreloadCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"expireHandler", "Landroid/os/Handler;", "getExpireHandler", "()Landroid/os/Handler;", "expireHandler$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreloadCacheKt {
    private static final Lazy expireHandler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.ies.bullet.preloadv2.cache.PreloadCacheKt$expireHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m542invoke() {
            HandlerThread handlerThread = new HandlerThread("PreloadCache", 10);
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });

    public static final Handler getExpireHandler() {
        return (Handler) expireHandler$delegate.getValue();
    }
}
