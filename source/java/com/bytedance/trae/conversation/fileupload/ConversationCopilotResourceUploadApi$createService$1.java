package com.bytedance.trae.conversation.fileupload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourceUploadApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi", f = "ResourceUploadApi.kt", i = {}, l = {43}, m = "createService", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationCopilotResourceUploadApi$createService$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationCopilotResourceUploadApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationCopilotResourceUploadApi$createService$1(ConversationCopilotResourceUploadApi conversationCopilotResourceUploadApi, Continuation<? super ConversationCopilotResourceUploadApi$createService$1> continuation) {
        super(continuation);
        this.this$0 = conversationCopilotResourceUploadApi;
    }

    public final Object invokeSuspend(Object obj) {
        Object createService;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        createService = this.this$0.createService((Continuation) this);
        return createService;
    }
}
