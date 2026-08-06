package com.bytedance.trae.im.network;

import com.bytedance.trae.network.FrontierConfig;
import com.bytedance.trae.network.FrontierConnection;
import com.bytedance.trae.network.HubClientMetadata;
import com.bytedance.trae.network.HubConnectionListener;
import com.bytedance.trae.network.HubNetConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* compiled from: INetworkDepend.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J:\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/network/INetworkDepend;", "", "connect", "", "listener", "Lcom/bytedance/trae/network/HubConnectionListener;", "disconnect", "isNetworkAvailable", "", "initConfig", "config", "Lcom/bytedance/trae/network/FrontierConfig;", "extraHeaders", "", "", "isToB", "clientMetadata", "Lcom/bytedance/trae/network/HubClientMetadata;", "getPushFrontierConnection", "Lcom/bytedance/trae/network/FrontierConnection;", "getHubNetConnection", "Lcom/bytedance/trae/network/HubNetConnection;", "checkAlive", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface INetworkDepend {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void checkAlive();

    void connect(HubConnectionListener listener);

    void disconnect();

    /* renamed from: getHubNetConnection */
    HubNetConnection getHubNet();

    /* renamed from: getPushFrontierConnection */
    FrontierConnection getPushFrontier();

    void initConfig(FrontierConfig config, Map<String, String> extraHeaders, boolean isToB, HubClientMetadata clientMetadata);

    boolean isNetworkAvailable();

    /* compiled from: INetworkDepend.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/im/network/INetworkDepend$Companion;", "", "<init>", "()V", "getInstance", "Lcom/bytedance/trae/im/network/INetworkDepend;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final INetworkDepend getInstance() {
            return NetworkDependImpl.INSTANCE.getInstance();
        }
    }

    /* compiled from: INetworkDepend.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void connect$default(INetworkDepend iNetworkDepend, HubConnectionListener hubConnectionListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connect");
            }
            if ((i & 1) != 0) {
                hubConnectionListener = null;
            }
            iNetworkDepend.connect(hubConnectionListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void initConfig$default(INetworkDepend iNetworkDepend, FrontierConfig frontierConfig, Map map, boolean z, HubClientMetadata hubClientMetadata, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initConfig");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                hubClientMetadata = HubClientMetadata.Companion.fromSystem();
            }
            iNetworkDepend.initConfig(frontierConfig, map, z, hubClientMetadata);
        }
    }
}
