package coil3.network.bytedance;

import coil3.network.NetworkClient;
import coil3.network.NetworkFetcher;
import coil3.network.bytedance.internal.KmpNetworkClient;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: KtorNetworkFetcher.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"KmpNetworkFetcherFactory", "Lcoil3/network/NetworkFetcher$Factory;", "factory", "coil_network_service_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class KtorNetworkFetcher {
    public static final NetworkFetcher.Factory factory() {
        return new NetworkFetcher.Factory(new Function0<NetworkClient>() { // from class: coil3.network.bytedance.KtorNetworkFetcher$KmpNetworkFetcherFactory$1
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final NetworkClient m3260invoke() {
                return new KmpNetworkClient();
            }
        }, null, null, 6, null);
    }
}
