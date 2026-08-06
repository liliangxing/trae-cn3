package androidx.compose.p001ui.precompose;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PausableSubPreComposeController.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.precompose.PausableSubPreComposeController", f = "PausableSubPreComposeController.kt", i = {}, l = {34}, m = "triggerSubPreCompose$ui_release", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PausableSubPreComposeController$triggerSubPreCompose$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PausableSubPreComposeController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PausableSubPreComposeController$triggerSubPreCompose$1(PausableSubPreComposeController pausableSubPreComposeController, Continuation<? super PausableSubPreComposeController$triggerSubPreCompose$1> continuation) {
        super(continuation);
        this.this$0 = pausableSubPreComposeController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.triggerSubPreCompose$ui_release((Continuation) this);
    }
}
