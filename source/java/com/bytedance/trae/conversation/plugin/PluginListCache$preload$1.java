package com.bytedance.trae.conversation.plugin;

import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginListCache.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.PluginListCache", f = "PluginListCache.kt", i = {0, 0, 0, 0, 0, 1, 2}, l = {82, 83, 84, 85}, m = OauthTokenTriggerScene.PRELOAD, n = {"this", "cliId", "workspaceFolder", "key", "isLocal", "marketDeferred", "installedDeferred"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginListCache$preload$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginListCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginListCache$preload$1(PluginListCache pluginListCache, Continuation<? super PluginListCache$preload$1> continuation) {
        super(continuation);
        this.this$0 = pluginListCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.preload(null, null, (Continuation) this);
    }
}
