package com.bytedance.trae.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationViewModel", f = "ConversationViewModel.kt", i = {0}, l = {741, 752, 764}, m = "performCreateTaskCheck", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationViewModel$performCreateTaskCheck$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationViewModel$performCreateTaskCheck$1(ConversationViewModel conversationViewModel, Continuation<? super ConversationViewModel$performCreateTaskCheck$1> continuation) {
        super(continuation);
        this.this$0 = conversationViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object performCreateTaskCheck;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        performCreateTaskCheck = this.this$0.performCreateTaskCheck(null, (Continuation) this);
        return performCreateTaskCheck;
    }
}
