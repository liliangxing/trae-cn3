package com.bytedance.trae.conversation.plugin;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginListCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.PluginListCache", f = "PluginListCache.kt", i = {0}, l = {260}, m = "ensureMarketplaceLoading", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginListCache$ensureMarketplaceLoading$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginListCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginListCache$ensureMarketplaceLoading$1(PluginListCache pluginListCache, Continuation<? super PluginListCache$ensureMarketplaceLoading$1> continuation) {
        super(continuation);
        this.this$0 = pluginListCache;
    }

    public final Object invokeSuspend(Object obj) {
        Object ensureMarketplaceLoading;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ensureMarketplaceLoading = this.this$0.ensureMarketplaceLoading((Continuation) this);
        return ensureMarketplaceLoading;
    }
}
