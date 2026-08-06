package coil3.network.bytedance.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: utils.common.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.bytedance.internal.KmpNetworkClient", f = "utils.common.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {64, 67, 91, 96}, m = "executeRequest", n = {"block", "modifyRequest", "block", "modifyRequest", "block", "modifyRequest", "sentRequestAtMillis"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class KmpNetworkClient$executeRequest$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNetworkClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpNetworkClient$executeRequest$1(KmpNetworkClient kmpNetworkClient, Continuation<? super KmpNetworkClient$executeRequest$1> continuation) {
        super(continuation);
        this.this$0 = kmpNetworkClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeRequest(null, null, (Continuation) this);
    }
}
