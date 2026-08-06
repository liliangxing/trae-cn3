package coil3.compose.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConstraintsSizeResolver.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.internal.LegacyConstraintsSizeResolver", f = "ConstraintsSizeResolver.kt", i = {}, l = {66}, m = "size", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LegacyConstraintsSizeResolver$size$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyConstraintsSizeResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegacyConstraintsSizeResolver$size$1(LegacyConstraintsSizeResolver legacyConstraintsSizeResolver, Continuation<? super LegacyConstraintsSizeResolver$size$1> continuation) {
        super(continuation);
        this.this$0 = legacyConstraintsSizeResolver;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.size((Continuation) this);
    }
}
