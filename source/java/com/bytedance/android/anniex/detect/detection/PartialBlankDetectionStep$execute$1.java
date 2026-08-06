package com.bytedance.android.anniex.detect.detection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PartialBlankDetectionStep.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep", f = "PartialBlankDetectionStep.kt", i = {0, 0, 0}, l = {41, 119}, m = "execute", n = {"context", "resultDeferred", "start$iv"}, s = {"L$0", "L$1", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PartialBlankDetectionStep$execute$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PartialBlankDetectionStep this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartialBlankDetectionStep$execute$1(PartialBlankDetectionStep partialBlankDetectionStep, Continuation<? super PartialBlankDetectionStep$execute$1> continuation) {
        super(continuation);
        this.this$0 = partialBlankDetectionStep;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, (Continuation) this);
    }
}
