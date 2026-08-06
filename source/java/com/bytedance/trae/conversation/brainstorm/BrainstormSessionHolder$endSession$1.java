package com.bytedance.trae.conversation.brainstorm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormSessionHolder.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder", f = "BrainstormSessionHolder.kt", i = {0, 0, 0}, l = {565}, m = "endSession$conversation_mainlandRelease", n = {"this", "hasSummaryWorthyInput", "isAbort"}, s = {"L$0", "I$0", "I$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormSessionHolder$endSession$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BrainstormSessionHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormSessionHolder$endSession$1(BrainstormSessionHolder brainstormSessionHolder, Continuation<? super BrainstormSessionHolder$endSession$1> continuation) {
        super(continuation);
        this.this$0 = brainstormSessionHolder;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.endSession$conversation_mainlandRelease(null, (Continuation) this);
    }
}
