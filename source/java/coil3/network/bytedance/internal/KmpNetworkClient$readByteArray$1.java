package coil3.network.bytedance.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: utils.common.kt */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.bytedance.internal.KmpNetworkClient", f = "utils.common.kt", i = {0}, l = {137}, m = "readByteArray", n = {"buffer"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class KmpNetworkClient$readByteArray$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNetworkClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpNetworkClient$readByteArray$1(KmpNetworkClient kmpNetworkClient, Continuation<? super KmpNetworkClient$readByteArray$1> continuation) {
        super(continuation);
        this.this$0 = kmpNetworkClient;
    }

    public final Object invokeSuspend(Object obj) {
        Object readByteArray;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readByteArray = this.this$0.readByteArray(null, (Continuation) this);
        return readByteArray;
    }
}
