package coil3.network.bytedance.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: utils.common.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.bytedance.internal.Utils_commonKt", f = "utils.common.kt", i = {}, l = {48}, m = "getAllInterceptors", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class Utils_commonKt$getAllInterceptors$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Utils_commonKt$getAllInterceptors$1(Continuation<? super Utils_commonKt$getAllInterceptors$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object allInterceptors;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        allInterceptors = Utils_commonKt.getAllInterceptors((Continuation) this);
        return allInterceptors;
    }
}
