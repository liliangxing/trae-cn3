package org.jetbrains.compose.resources;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: AsyncCache.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "V", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "org.jetbrains.compose.resources.AsyncCache$getOrLoad$2", f = "AsyncCache.kt", i = {0, 0}, l = {36, 24}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class AsyncCache$getOrLoad$2<V> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super V>, Object> {
    final /* synthetic */ K $key;
    final /* synthetic */ Function1<Continuation<? super V>, Object> $load;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ AsyncCache<K, V> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncCache$getOrLoad$2(AsyncCache<K, V> asyncCache, K k, Function1<? super Continuation<? super V>, ? extends Object> function1, Continuation<? super AsyncCache$getOrLoad$2> continuation) {
        super(2, continuation);
        this.this$0 = asyncCache;
        this.$key = k;
        this.$load = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> asyncCache$getOrLoad$2 = new AsyncCache$getOrLoad$2<>(this.this$0, this.$key, this.$load, continuation);
        asyncCache$getOrLoad$2.L$0 = obj;
        return asyncCache$getOrLoad$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super V> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Mutex mutex;
        AsyncCache asyncCache;
        Function1<Continuation<? super V>, Object> function1;
        Object obj2;
        Map map;
        Map map2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                mutex = ((AsyncCache) this.this$0).mutex;
                asyncCache = this.this$0;
                Object obj3 = this.$key;
                function1 = this.$load;
                this.L$0 = coroutineScope;
                this.L$1 = mutex;
                this.L$2 = asyncCache;
                this.L$3 = obj3;
                this.L$4 = function1;
                this.label = 1;
                if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = obj3;
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$4;
                obj2 = this.L$3;
                asyncCache = (AsyncCache) this.L$2;
                mutex = (Mutex) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            map = asyncCache.cache;
            Deferred deferred = (Deferred) map.get(obj2);
            if (deferred == null || deferred.isCancelled()) {
                deferred = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, CoroutineStart.LAZY, new AsyncCache$getOrLoad$2$deferred$1$1(function1, null), 1, (Object) null);
                map2 = asyncCache.cache;
                map2.put(obj2, deferred);
            }
            mutex.unlock((Object) null);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 2;
            obj = deferred.await((Continuation) this);
            return obj == coroutine_suspended ? coroutine_suspended : obj;
        } catch (Throwable th) {
            mutex.unlock((Object) null);
            throw th;
        }
    }
}
