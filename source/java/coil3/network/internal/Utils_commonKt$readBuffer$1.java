package coil3.network.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: utils.common.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.internal.Utils_commonKt", f = "utils.common.kt", i = {0}, l = {22}, m = "readBuffer", n = {"buffer"}, s = {"L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class Utils_commonKt$readBuffer$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Utils_commonKt$readBuffer$1(Continuation<? super Utils_commonKt$readBuffer$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Utils_commonKt.readBuffer(null, (Continuation) this);
    }
}
