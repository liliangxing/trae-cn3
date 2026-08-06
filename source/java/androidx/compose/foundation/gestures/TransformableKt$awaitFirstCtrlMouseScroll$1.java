package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transformable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0}, l = {299}, m = "awaitFirstCtrlMouseScroll", n = {"$this$awaitFirstCtrlMouseScroll", "scrollConfig"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TransformableKt$awaitFirstCtrlMouseScroll$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformableKt$awaitFirstCtrlMouseScroll$1(Continuation<? super TransformableKt$awaitFirstCtrlMouseScroll$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object awaitFirstCtrlMouseScroll;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitFirstCtrlMouseScroll = TransformableKt.awaitFirstCtrlMouseScroll(null, null, (Continuation) this);
        return awaitFirstCtrlMouseScroll;
    }
}
