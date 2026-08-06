package com.bytedance.trae.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity", f = "ConversationActivity.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 8, 8, 9, 9, 9}, l = {1990, 1993, 1997, 2020, 2047, 2062, 2082, 2091, 2095, 2112}, m = "resolveManagedPromptsWhileResumed", n = {"this", "preparedGuide", "preparedGuideDevices", "this", "preparedGuide", "preparedGuideDevices", "this", "preparedGuide", "preparedGuideDevices", "this", "preparedGuide", "preparedGuideDevices", "this", "preparedGuide", "preparedGuideDevices", "this", "preparedGuide", "preparedGuideDevices", "userId", "billingForFinalDecision", "this", "preparedGuide", "preparedGuideDevices", "this", "preparedGuide", "preparedGuideDevices", "this", "preparedGuide", "preparedGuideDevices", "userId", "finalDecision", "selectedGuide", "this", "preparedGuide", "preparedGuideDevices"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$resolveManagedPromptsWhileResumed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$resolveManagedPromptsWhileResumed$1(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$resolveManagedPromptsWhileResumed$1> continuation) {
        super(continuation);
        this.this$0 = conversationActivity;
    }

    public final Object invokeSuspend(Object obj) {
        Object resolveManagedPromptsWhileResumed;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolveManagedPromptsWhileResumed = this.this$0.resolveManagedPromptsWhileResumed((Continuation) this);
        return resolveManagedPromptsWhileResumed;
    }
}
