package com.bytedance.kmp.image.utils;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: AsyncCache.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ4\u0010\f\u001a\u00028\u00012\u0006\u0010\r\u001a\u00028\u00002\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0086@¢\u0006\u0002\u0010\u0011R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/kmp/image/utils/AsyncCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "()V", "cache", "", "Lkotlinx/coroutines/Deferred;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "clear", "", "getOrLoad", "key", "load", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AsyncCache<K, V> {
    public static final int $stable = 8;
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);
    private final Map<K, Deferred<V>> cache = new LinkedHashMap();

    public final Object getOrLoad(K k, Function1<? super Continuation<? super V>, ? extends Object> function1, Continuation<? super V> continuation) {
        return CoroutineScopeKt.coroutineScope(new AsyncCache$getOrLoad$2(this, k, function1, null), continuation);
    }

    public final void clear() {
        this.cache.clear();
    }
}
