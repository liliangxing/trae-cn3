package com.bytedance.trae.conversation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public /* synthetic */ class ConversationActivity$observeManagedPrompts$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ConversationActivity$observeManagedPrompts$1(Object obj) {
        super(1, obj, ConversationActivity.class, "resolveManagedPromptsWhileResumed", "resolveManagedPromptsWhileResumed(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        Object resolveManagedPromptsWhileResumed;
        resolveManagedPromptsWhileResumed = ((ConversationActivity) this.receiver).resolveManagedPromptsWhileResumed(continuation);
        return resolveManagedPromptsWhileResumed;
    }
}
