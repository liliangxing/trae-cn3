package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 0}, l = {895}, m = "awaitAllPointersUpWithSlopDetection", n = {"$this$awaitAllPointersUpWithSlopDetection", "pass", "pointer", "touchSlopDetector", "pointerSlopReached", "touchSlop"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "F$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1 extends ContinuationImpl {
    float F$0;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1(Continuation<? super DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.awaitAllPointersUpWithSlopDetection(null, null, null, (Continuation) this);
    }
}
