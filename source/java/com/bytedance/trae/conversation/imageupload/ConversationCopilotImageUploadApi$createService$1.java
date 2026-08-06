package com.bytedance.trae.conversation.imageupload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageUploadApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi", f = "ImageUploadApi.kt", i = {0}, l = {53}, m = "createService", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationCopilotImageUploadApi$createService$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationCopilotImageUploadApi this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationCopilotImageUploadApi$createService$1(ConversationCopilotImageUploadApi conversationCopilotImageUploadApi, Continuation<? super ConversationCopilotImageUploadApi$createService$1> continuation) {
        super(continuation);
        this.this$0 = conversationCopilotImageUploadApi;
    }

    public final Object invokeSuspend(Object obj) {
        Object createService;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        createService = this.this$0.createService((Continuation) this);
        return createService;
    }
}
