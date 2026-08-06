package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AwaitFirstLayoutModifier.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier", f = "AwaitFirstLayoutModifier.kt", i = {0}, l = {56}, m = "waitForFirstLayout", n = {"continuation"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AwaitFirstLayoutModifier$waitForFirstLayout$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwaitFirstLayoutModifier this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AwaitFirstLayoutModifier$waitForFirstLayout$1(AwaitFirstLayoutModifier awaitFirstLayoutModifier, Continuation<? super AwaitFirstLayoutModifier$waitForFirstLayout$1> continuation) {
        super(continuation);
        this.this$0 = awaitFirstLayoutModifier;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.waitForFirstLayout((Continuation) this);
    }
}
