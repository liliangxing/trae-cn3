package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Draggable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0}, l = {575}, m = "processDragStop", n = {"event"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DragGestureNode$processDragStop$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureNode$processDragStop$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$processDragStop$1> continuation) {
        super(continuation);
        this.this$0 = dragGestureNode;
    }

    public final Object invokeSuspend(Object obj) {
        Object processDragStop;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        processDragStop = this.this$0.processDragStop(null, (Continuation) this);
        return processDragStop;
    }
}
