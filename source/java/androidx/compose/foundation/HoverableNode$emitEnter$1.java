package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hoverable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.HoverableNode", f = "Hoverable.kt", i = {0}, l = {106}, m = "emitEnter", n = {"interaction"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class HoverableNode$emitEnter$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HoverableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HoverableNode$emitEnter$1(HoverableNode hoverableNode, Continuation<? super HoverableNode$emitEnter$1> continuation) {
        super(continuation);
        this.this$0 = hoverableNode;
    }

    public final Object invokeSuspend(Object obj) {
        Object emitEnter;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        emitEnter = this.this$0.emitEnter((Continuation) this);
        return emitEnter;
    }
}
