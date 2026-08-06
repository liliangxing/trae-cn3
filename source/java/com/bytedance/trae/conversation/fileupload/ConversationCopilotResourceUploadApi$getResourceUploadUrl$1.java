package com.bytedance.trae.conversation.fileupload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourceUploadApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi", f = "ResourceUploadApi.kt", i = {0}, l = {48, 48}, m = "getResourceUploadUrl", n = {"req"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationCopilotResourceUploadApi$getResourceUploadUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationCopilotResourceUploadApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationCopilotResourceUploadApi$getResourceUploadUrl$1(ConversationCopilotResourceUploadApi conversationCopilotResourceUploadApi, Continuation<? super ConversationCopilotResourceUploadApi$getResourceUploadUrl$1> continuation) {
        super(continuation);
        this.this$0 = conversationCopilotResourceUploadApi;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getResourceUploadUrl(null, (Continuation) this);
    }
}
