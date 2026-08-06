package com.bytedance.trae.conversation.plugin.authorization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginConnectorOAuthManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager", f = "PluginConnectorOAuthManager.kt", i = {0, 0}, l = {365, 404}, m = "pollListConnectorConnections", n = {"provider", "onComplete"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginConnectorOAuthManager$pollListConnectorConnections$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginConnectorOAuthManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginConnectorOAuthManager$pollListConnectorConnections$1(PluginConnectorOAuthManager pluginConnectorOAuthManager, Continuation<? super PluginConnectorOAuthManager$pollListConnectorConnections$1> continuation) {
        super(continuation);
        this.this$0 = pluginConnectorOAuthManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object pollListConnectorConnections;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        pollListConnectorConnections = this.this$0.pollListConnectorConnections(null, null, null, (Continuation) this);
        return pollListConnectorConnections;
    }
}
