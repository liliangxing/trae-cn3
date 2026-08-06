package com.bytedance.android.anniex.detect.detection;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PureColorDetectionStep.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PureColorDetectionStep", f = "PureColorDetectionStep.kt", i = {0, 0, 0}, l = {34}, m = "execute", n = {"context", StrategyConstants.RESULT, "start$iv"}, s = {"L$0", "L$1", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PureColorDetectionStep$execute$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PureColorDetectionStep this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PureColorDetectionStep$execute$1(PureColorDetectionStep pureColorDetectionStep, Continuation<? super PureColorDetectionStep$execute$1> continuation) {
        super(continuation);
        this.this$0 = pureColorDetectionStep;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, (Continuation) this);
    }
}
