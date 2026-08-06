package com.bytedance.trae.conversation.plugin;

import com.bytedance.trae.conversation.network.IMarketplaceApi;
import com.bytedance.trae.conversation.network.MarketplacePluginItem;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginListCache.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "", "Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.PluginListCache$ensureMarketplaceLoading$2$deferred$1", f = "PluginListCache.kt", i = {1, 1}, l = {148, 260}, m = "invokeSuspend", n = {"result", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginListCache$ensureMarketplaceLoading$2$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends MarketplacePluginItem>>, Object> {
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PluginListCache$ensureMarketplaceLoading$2$deferred$1(Continuation<? super PluginListCache$ensureMarketplaceLoading$2$deferred$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PluginListCache$ensureMarketplaceLoading$2$deferred$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, MarketplacePluginItem>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0057 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:7:0x0050, B:9:0x0057, B:10:0x0065), top: B:6:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Map map;
        Mutex mutex;
        Mutex mutex2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = IMarketplaceApi.INSTANCE.fetchMarketplacePlugins((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) this.L$1;
                map = (Map) this.L$0;
                ResultKt.throwOnFailure(obj);
                try {
                    if (!map.isEmpty()) {
                        PluginListCache pluginListCache = PluginListCache.INSTANCE;
                        PluginListCache.marketplaceByName = map;
                        PluginListCache pluginListCache2 = PluginListCache.INSTANCE;
                        PluginListCache.marketplaceLoadedAt = System.currentTimeMillis();
                    }
                    PluginListCache pluginListCache3 = PluginListCache.INSTANCE;
                    PluginListCache.marketplacePromise = null;
                    Unit unit = Unit.INSTANCE;
                    return map;
                } finally {
                    mutex2.unlock((Object) null);
                }
            }
            ResultKt.throwOnFailure(obj);
        }
        map = (Map) obj;
        mutex = PluginListCache.mutex;
        this.L$0 = map;
        this.L$1 = mutex;
        this.label = 2;
        if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutex2 = mutex;
        if (!map.isEmpty()) {
        }
        PluginListCache pluginListCache32 = PluginListCache.INSTANCE;
        PluginListCache.marketplacePromise = null;
        Unit unit2 = Unit.INSTANCE;
        return map;
    }
}
