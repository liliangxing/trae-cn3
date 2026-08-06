package coil3.network;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkFetcher.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0, 0, 0, 1, 1, 2}, l = {45, 59, 88}, m = "fetch", n = {"this", StrategyConstants.SNAPSHOT, "output", "this", StrategyConstants.SNAPSHOT, StrategyConstants.SNAPSHOT}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class NetworkFetcher$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$fetch$1(NetworkFetcher networkFetcher, Continuation<? super NetworkFetcher$fetch$1> continuation) {
        super(continuation);
        this.this$0 = networkFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetch((Continuation) this);
    }
}
