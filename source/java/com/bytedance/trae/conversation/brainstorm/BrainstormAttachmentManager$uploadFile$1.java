package com.bytedance.trae.conversation.brainstorm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormAttachmentManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormAttachmentManager", f = "BrainstormAttachmentManager.kt", i = {0}, l = {178}, m = "uploadFile", n = {"sourceUri"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormAttachmentManager$uploadFile$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BrainstormAttachmentManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormAttachmentManager$uploadFile$1(BrainstormAttachmentManager brainstormAttachmentManager, Continuation<? super BrainstormAttachmentManager$uploadFile$1> continuation) {
        super(continuation);
        this.this$0 = brainstormAttachmentManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadFile(null, null, null, null, (Continuation) this);
    }
}
