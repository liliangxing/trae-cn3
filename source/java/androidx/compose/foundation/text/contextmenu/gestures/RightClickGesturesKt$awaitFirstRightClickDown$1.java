package androidx.compose.foundation.text.contextmenu.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RightClickGestures.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.gestures.RightClickGesturesKt", f = "RightClickGestures.kt", i = {0}, l = {45}, m = "awaitFirstRightClickDown", n = {"$this$awaitFirstRightClickDown"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class RightClickGesturesKt$awaitFirstRightClickDown$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RightClickGesturesKt$awaitFirstRightClickDown$1(Continuation<? super RightClickGesturesKt$awaitFirstRightClickDown$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object awaitFirstRightClickDown;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitFirstRightClickDown = RightClickGesturesKt.awaitFirstRightClickDown(null, (Continuation) this);
        return awaitFirstRightClickDown;
    }
}
