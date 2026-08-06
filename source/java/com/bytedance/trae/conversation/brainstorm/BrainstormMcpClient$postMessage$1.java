package com.bytedance.trae.conversation.brainstorm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormMcpClient.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient", f = "BrainstormMcpClient.kt", i = {}, l = {125}, m = "postMessage", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormMcpClient$postMessage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BrainstormMcpClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormMcpClient$postMessage$1(BrainstormMcpClient brainstormMcpClient, Continuation<? super BrainstormMcpClient$postMessage$1> continuation) {
        super(continuation);
        this.this$0 = brainstormMcpClient;
    }

    public final Object invokeSuspend(Object obj) {
        Object postMessage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        postMessage = this.this$0.postMessage(null, null, (Continuation) this);
        return postMessage;
    }
}
