package com.bytedance.trae.conversation.network;

import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.trae.conversation.network.IMarketplaceApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMarketplaceApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.IMarketplaceApi$Companion", f = "IMarketplaceApi.kt", i = {0, 0, 0, 0}, l = {36}, m = "fetchMarketplacePlugins", n = {TracingConstants.KEY_TRACE_NAME, "plugins", "seenPageTokens", "pageToken"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IMarketplaceApi$Companion$fetchMarketplacePlugins$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMarketplaceApi.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMarketplaceApi$Companion$fetchMarketplacePlugins$1(IMarketplaceApi.Companion companion, Continuation<? super IMarketplaceApi$Companion$fetchMarketplacePlugins$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchMarketplacePlugins((Continuation) this);
    }
}
