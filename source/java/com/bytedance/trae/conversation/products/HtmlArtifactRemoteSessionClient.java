package com.bytedance.trae.conversation.products;

import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;", "", "wakeupSandbox", "Lcom/bytedance/trae/network/response/HttpDataResult;", "", "chatSessionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChatSession", "Lcom/bytedance/trae/im/service/ChatSessionResponse;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface HtmlArtifactRemoteSessionClient {
    Object getChatSession(String str, Continuation<? super HttpDataResult<ChatSessionResponse>> continuation);

    Object wakeupSandbox(String str, Continuation<? super HttpDataResult<Unit>> continuation);
}
