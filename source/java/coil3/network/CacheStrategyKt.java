package coil3.network;

import coil3.network.CacheStrategy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: CacheStrategy.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"CacheStrategy", "Lcoil3/network/CacheStrategy;", "coil-network-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CacheStrategyKt {
    public static final CacheStrategy CacheStrategy() {
        return new CacheStrategy() { // from class: coil3.network.CacheStrategyKt$CacheStrategy$1
            @Override // coil3.network.CacheStrategy
            public final Object compute(CacheStrategy.Input input, Continuation<? super CacheStrategy.Output> continuation) {
                return new CacheStrategy.Output(input.getCacheResponse());
            }
        };
    }
}
