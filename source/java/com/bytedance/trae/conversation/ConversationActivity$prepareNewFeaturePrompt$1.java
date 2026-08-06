package com.bytedance.trae.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity", f = "ConversationActivity.kt", i = {0, 0}, l = {2164}, m = "prepareNewFeaturePrompt", n = {"userId", "config"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$prepareNewFeaturePrompt$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$prepareNewFeaturePrompt$1(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$prepareNewFeaturePrompt$1> continuation) {
        super(continuation);
        this.this$0 = conversationActivity;
    }

    public final Object invokeSuspend(Object obj) {
        Object prepareNewFeaturePrompt;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        prepareNewFeaturePrompt = this.this$0.prepareNewFeaturePrompt(null, (Continuation) this);
        return prepareNewFeaturePrompt;
    }
}
