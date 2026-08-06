package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MergeDiffManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MergeDiffManager", f = "MergeDiffManager.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {44, 79}, m = "fetchMergeDiffs", n = {"this", "mergeData", "taskName", "this", "mergeData", "taskName", "fileConflictMap"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MergeDiffManager$fetchMergeDiffs$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MergeDiffManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MergeDiffManager$fetchMergeDiffs$1(MergeDiffManager mergeDiffManager, Continuation<? super MergeDiffManager$fetchMergeDiffs$1> continuation) {
        super(continuation);
        this.this$0 = mergeDiffManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchMergeDiffs(null, null, null, (Continuation) this);
    }
}
