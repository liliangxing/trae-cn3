package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable2D.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.Scrollable2DKt", f = "Scrollable2D.kt", i = {0}, l = {526}, m = "semanticsScrollBy-d-4ec7I", n = {"previousValue"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class Scrollable2DKt$semanticsScrollBy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scrollable2DKt$semanticsScrollBy$1(Continuation<? super Scrollable2DKt$semanticsScrollBy$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object m769semanticsScrollByd4ec7I;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m769semanticsScrollByd4ec7I = Scrollable2DKt.m769semanticsScrollByd4ec7I(null, 0L, (Continuation) this);
        return m769semanticsScrollByd4ec7I;
    }
}
