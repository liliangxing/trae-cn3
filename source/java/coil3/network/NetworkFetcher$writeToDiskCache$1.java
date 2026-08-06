package coil3.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetworkFetcher.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0, 0}, l = {152}, m = "writeToDiskCache", n = {"networkResponseBody", "editor"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class NetworkFetcher$writeToDiskCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$writeToDiskCache$1(NetworkFetcher networkFetcher, Continuation<? super NetworkFetcher$writeToDiskCache$1> continuation) {
        super(continuation);
        this.this$0 = networkFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        Object writeToDiskCache;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        writeToDiskCache = this.this$0.writeToDiskCache(null, null, null, null, (Continuation) this);
        return writeToDiskCache;
    }
}
