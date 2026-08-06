package com.bytedance.trae.conversation.plugin;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginListCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.PluginListCache", f = "PluginListCache.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {211, 213}, m = "fetchAllInstalledPages", n = {"cliId", "workspaceFolder", "allItems", "seenTokens", "pageToken", "isLocal", "cliId", "workspaceFolder", "allItems", "seenTokens", "pageToken", "isLocal"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginListCache$fetchAllInstalledPages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginListCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginListCache$fetchAllInstalledPages$1(PluginListCache pluginListCache, Continuation<? super PluginListCache$fetchAllInstalledPages$1> continuation) {
        super(continuation);
        this.this$0 = pluginListCache;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchAllInstalledPages;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchAllInstalledPages = this.this$0.fetchAllInstalledPages(false, null, null, (Continuation) this);
        return fetchAllInstalledPages;
    }
}
