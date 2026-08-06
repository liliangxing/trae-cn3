package com.bytedance.trae.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel", f = "ConversationViewModel.kt", i = {0, 0, 0, 0, 0, 0}, l = {2618, 2620}, m = "handleModelUnavailableCreateTaskErrorIfNeeded", n = {"this", "message", "errorData", "device", "mode", "code"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0"})
/* renamed from: com.bytedance.trae.conversation.ConversationViewModel$handleModelUnavailableCreateTaskErrorIfNeeded$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0629x22372314 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0629x22372314(ConversationViewModel conversationViewModel, Continuation<? super C0629x22372314> continuation) {
        super(continuation);
        this.this$0 = conversationViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleModelUnavailableCreateTaskErrorIfNeeded;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleModelUnavailableCreateTaskErrorIfNeeded = this.this$0.handleModelUnavailableCreateTaskErrorIfNeeded(0L, null, null, null, null, (Continuation) this);
        return handleModelUnavailableCreateTaskErrorIfNeeded;
    }
}
