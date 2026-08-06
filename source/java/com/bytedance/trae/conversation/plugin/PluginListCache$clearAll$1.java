package com.bytedance.trae.conversation.plugin;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: PluginListCache.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.PluginListCache$clearAll$1", f = "PluginListCache.kt", i = {0}, l = {260}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class PluginListCache$clearAll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PluginListCache$clearAll$1(Continuation<? super PluginListCache$clearAll$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PluginListCache$clearAll$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Mutex mutex2;
        Job job;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = PluginListCache.mutex;
            this.L$0 = mutex;
            this.label = 1;
            if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex2 = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            PluginListCache pluginListCache = PluginListCache.INSTANCE;
            PluginListCache.marketplaceByName = MapsKt.emptyMap();
            PluginListCache pluginListCache2 = PluginListCache.INSTANCE;
            PluginListCache.marketplaceLoadedAt = 0L;
            job = PluginListCache.marketplacePromise;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            PluginListCache pluginListCache3 = PluginListCache.INSTANCE;
            PluginListCache.marketplacePromise = null;
            concurrentHashMap = PluginListCache.installedPromises;
            Collection values = concurrentHashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            Iterator it = values.iterator();
            while (it.hasNext()) {
                Job.DefaultImpls.cancel$default((Deferred) it.next(), (CancellationException) null, 1, (Object) null);
            }
            concurrentHashMap2 = PluginListCache.installedPromises;
            concurrentHashMap2.clear();
            concurrentHashMap3 = PluginListCache.installedCache;
            concurrentHashMap3.clear();
            Unit unit = Unit.INSTANCE;
            mutex2.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex2.unlock((Object) null);
            throw th;
        }
    }
}
