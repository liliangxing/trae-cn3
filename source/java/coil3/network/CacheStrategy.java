package coil3.network;

import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: CacheStrategy.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bç\u0080\u0001\u0018\u00002\u00020\u0001:\u0002\u0007\bJ\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcoil3/network/CacheStrategy;", "", "compute", "Lcoil3/network/CacheStrategy$Output;", "input", "Lcoil3/network/CacheStrategy$Input;", "(Lcoil3/network/CacheStrategy$Input;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Input", "Output", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CacheStrategy {
    Object compute(Input input, Continuation<? super Output> continuation);

    /* compiled from: CacheStrategy.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcoil3/network/CacheStrategy$Input;", "", "cacheResponse", "Lcoil3/network/CacheResponse;", "networkRequest", "Lcoil3/network/NetworkRequest;", "options", "Lcoil3/request/Options;", "<init>", "(Lcoil3/network/CacheResponse;Lcoil3/network/NetworkRequest;Lcoil3/request/Options;)V", "getCacheResponse", "()Lcoil3/network/CacheResponse;", "getNetworkRequest", "()Lcoil3/network/NetworkRequest;", "getOptions", "()Lcoil3/request/Options;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Input {
        private final CacheResponse cacheResponse;
        private final NetworkRequest networkRequest;
        private final Options options;

        public Input(CacheResponse cacheResponse, NetworkRequest networkRequest, Options options) {
            this.cacheResponse = cacheResponse;
            this.networkRequest = networkRequest;
            this.options = options;
        }

        public final CacheResponse getCacheResponse() {
            return this.cacheResponse;
        }

        public final NetworkRequest getNetworkRequest() {
            return this.networkRequest;
        }

        public final Options getOptions() {
            return this.options;
        }
    }

    /* compiled from: CacheStrategy.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcoil3/network/CacheStrategy$Output;", "", "cacheResponse", "Lcoil3/network/CacheResponse;", "<init>", "(Lcoil3/network/CacheResponse;)V", "networkRequest", "Lcoil3/network/NetworkRequest;", "(Lcoil3/network/NetworkRequest;)V", "(Lcoil3/network/CacheResponse;Lcoil3/network/NetworkRequest;)V", "getCacheResponse", "()Lcoil3/network/CacheResponse;", "getNetworkRequest", "()Lcoil3/network/NetworkRequest;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Output {
        private final CacheResponse cacheResponse;
        private final NetworkRequest networkRequest;

        public final CacheResponse getCacheResponse() {
            return this.cacheResponse;
        }

        public final NetworkRequest getNetworkRequest() {
            return this.networkRequest;
        }

        public Output(CacheResponse cacheResponse) {
            this.cacheResponse = cacheResponse;
            this.networkRequest = null;
        }

        public Output(NetworkRequest networkRequest) {
            this.cacheResponse = null;
            this.networkRequest = networkRequest;
        }

        public Output(CacheResponse cacheResponse, NetworkRequest networkRequest) {
            this.cacheResponse = cacheResponse;
            this.networkRequest = networkRequest;
        }
    }
}
