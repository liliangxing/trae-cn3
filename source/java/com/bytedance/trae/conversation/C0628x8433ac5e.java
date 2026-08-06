package com.bytedance.trae.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel", f = "ConversationViewModel.kt", i = {}, l = {2637}, m = "handleCreateTaskErrorWithoutModelFallbackIfNeeded", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0628x8433ac5e extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0628x8433ac5e(ConversationViewModel conversationViewModel, Continuation<? super C0628x8433ac5e> continuation) {
        super(continuation);
        this.this$0 = conversationViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleCreateTaskErrorWithoutModelFallbackIfNeeded;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleCreateTaskErrorWithoutModelFallbackIfNeeded = this.this$0.handleCreateTaskErrorWithoutModelFallbackIfNeeded(0L, null, null, (Continuation) this);
        return handleCreateTaskErrorWithoutModelFallbackIfNeeded;
    }
}
