package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource;", "Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;", "<init>", "()V", "updates", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;", "WS_PROTO_SANDBOX_STATUS_CHANGE", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultHtmlArtifactRemoteSandboxStatusSource implements HtmlArtifactRemoteSandboxStatusSource {
    public static final DefaultHtmlArtifactRemoteSandboxStatusSource INSTANCE = new DefaultHtmlArtifactRemoteSandboxStatusSource();
    private static final int WS_PROTO_SANDBOX_STATUS_CHANGE = 9;

    private DefaultHtmlArtifactRemoteSandboxStatusSource() {
    }

    @Override // com.bytedance.trae.conversation.products.HtmlArtifactRemoteSandboxStatusSource
    public Flow<RealtimeSandboxStatusUpdate> updates() {
        return FlowKt.callbackFlow(new DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1(null));
    }
}
