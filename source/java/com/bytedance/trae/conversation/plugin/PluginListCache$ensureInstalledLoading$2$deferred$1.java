package com.bytedance.trae.conversation.plugin;

import com.bytedance.trae.conversation.network.PluginItem;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.plugin.PluginListCache;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lcom/bytedance/trae/conversation/network/PluginItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.PluginListCache$ensureInstalledLoading$2$deferred$1", f = "PluginListCache.kt", i = {1, 1}, l = {177, 260}, m = "invokeSuspend", n = {"allItems", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginListCache$ensureInstalledLoading$2$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PluginItem>>, Object> {
    final /* synthetic */ String $cliId;
    final /* synthetic */ boolean $isLocal;
    final /* synthetic */ PluginListCache.InstalledCacheKey $key;
    final /* synthetic */ String $workspaceFolder;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginListCache$ensureInstalledLoading$2$deferred$1(boolean z, String str, String str2, PluginListCache.InstalledCacheKey installedCacheKey, Continuation<? super PluginListCache$ensureInstalledLoading$2$deferred$1> continuation) {
        super(2, continuation);
        this.$isLocal = z;
        this.$cliId = str;
        this.$workspaceFolder = str2;
        this.$key = installedCacheKey;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PluginListCache$ensureInstalledLoading$2$deferred$1(this.$isLocal, this.$cliId, this.$workspaceFolder, this.$key, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PluginItem>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        List list;
        PluginListCache.InstalledCacheKey installedCacheKey;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = PluginListCache.INSTANCE.fetchAllInstalledPages(this.$isLocal, this.$cliId, this.$workspaceFolder, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                installedCacheKey = (PluginListCache.InstalledCacheKey) this.L$2;
                mutex = (Mutex) this.L$1;
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                try {
                    concurrentHashMap = PluginListCache.installedCache;
                    concurrentHashMap.put(installedCacheKey, new PluginListCache.InstalledCacheEntry(list, System.currentTimeMillis()));
                    concurrentHashMap2 = PluginListCache.installedPromises;
                    return list;
                } finally {
                    mutex.unlock((Object) null);
                }
            }
            ResultKt.throwOnFailure(obj);
        }
        List list2 = (List) obj;
        mutex = PluginListCache.mutex;
        PluginListCache.InstalledCacheKey installedCacheKey2 = this.$key;
        this.L$0 = list2;
        this.L$1 = mutex;
        this.L$2 = installedCacheKey2;
        this.label = 2;
        if (mutex.lock((Object) null, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        list = list2;
        installedCacheKey = installedCacheKey2;
        concurrentHashMap = PluginListCache.installedCache;
        concurrentHashMap.put(installedCacheKey, new PluginListCache.InstalledCacheEntry(list, System.currentTimeMillis()));
        concurrentHashMap2 = PluginListCache.installedPromises;
        return list;
    }
}
