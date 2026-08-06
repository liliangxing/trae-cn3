package com.bytedance.trae.conversation.products;

import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSessionClient;", "Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;", "<init>", "()V", "wakeupSandbox", "Lcom/bytedance/trae/network/response/HttpDataResult;", "", "chatSessionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChatSession", "Lcom/bytedance/trae/im/service/ChatSessionResponse;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultHtmlArtifactRemoteSessionClient implements HtmlArtifactRemoteSessionClient {
    public static final DefaultHtmlArtifactRemoteSessionClient INSTANCE = new DefaultHtmlArtifactRemoteSessionClient();

    private DefaultHtmlArtifactRemoteSessionClient() {
    }

    @Override // com.bytedance.trae.conversation.products.HtmlArtifactRemoteSessionClient
    public Object wakeupSandbox(String str, Continuation<? super HttpDataResult<Unit>> continuation) {
        return IChatSessionApi.INSTANCE.wakeupSandboxRawCall(str, continuation);
    }

    @Override // com.bytedance.trae.conversation.products.HtmlArtifactRemoteSessionClient
    public Object getChatSession(String str, Continuation<? super HttpDataResult<ChatSessionResponse>> continuation) {
        return IChatSessionApi.INSTANCE.getChatSessionRawCall(str, continuation);
    }
}
