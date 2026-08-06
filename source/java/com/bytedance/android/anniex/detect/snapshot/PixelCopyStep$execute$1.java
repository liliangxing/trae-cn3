package com.bytedance.android.anniex.detect.snapshot;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PixelCopyStep.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.snapshot.PixelCopyStep", f = "PixelCopyStep.kt", i = {0, 0}, l = {37}, m = "execute", n = {"this", "captureLog"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PixelCopyStep$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PixelCopyStep this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PixelCopyStep$execute$1(PixelCopyStep pixelCopyStep, Continuation<? super PixelCopyStep$execute$1> continuation) {
        super(continuation);
        this.this$0 = pixelCopyStep;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, (Continuation) this);
    }
}
