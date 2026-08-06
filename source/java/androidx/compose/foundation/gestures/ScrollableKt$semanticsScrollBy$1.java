package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt", f = "Scrollable.kt", i = {0, 0}, l = {1051}, m = "semanticsScrollBy-d-4ec7I", n = {"$this$semanticsScrollBy_u2dd_u2d4ec7I", "previousValue"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ScrollableKt$semanticsScrollBy$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollableKt$semanticsScrollBy$1(Continuation<? super ScrollableKt$semanticsScrollBy$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object m775semanticsScrollByd4ec7I;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m775semanticsScrollByd4ec7I = ScrollableKt.m775semanticsScrollByd4ec7I(null, 0L, (Continuation) this);
        return m775semanticsScrollByd4ec7I;
    }
}
