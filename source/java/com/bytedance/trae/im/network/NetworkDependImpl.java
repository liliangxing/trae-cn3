package com.bytedance.trae.im.network;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.FrontierConfig;
import com.bytedance.trae.network.FrontierConnection;
import com.bytedance.trae.network.FrontierSwitchConfig;
import com.bytedance.trae.network.HubClientMetadata;
import com.bytedance.trae.network.HubConnectionListener;
import com.bytedance.trae.network.HubNetConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NetworkDependImpl.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J4\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010#\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006%"}, d2 = {"Lcom/bytedance/trae/im/network/NetworkDependImpl;", "Lcom/bytedance/trae/im/network/INetworkDepend;", "<init>", "()V", "hubNet", "Lcom/bytedance/trae/network/HubNetConnection;", "pushFrontier", "Lcom/bytedance/trae/network/FrontierConnection;", "currentPushUserId", "", "Ljava/lang/Long;", "currentServiceId", "", "Ljava/lang/Integer;", "updateHubNet", "", "serviceId", "(Ljava/lang/Integer;)V", "connect", "listener", "Lcom/bytedance/trae/network/HubConnectionListener;", "disconnect", "isNetworkAvailable", "", "initConfig", "config", "Lcom/bytedance/trae/network/FrontierConfig;", "extraHeaders", "", "", "isToB", "clientMetadata", "Lcom/bytedance/trae/network/HubClientMetadata;", "getPushFrontierConnection", "getHubNetConnection", "checkAlive", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NetworkDependImpl implements INetworkDepend {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HUB_REASON_IMSDK = "imsdk";
    private static final String PUSH_REASON = "push";
    private static final String PUSH_REASON_USER_CHANGED = "push_user_changed";
    private static volatile NetworkDependImpl instance;
    private Long currentPushUserId;
    private Integer currentServiceId;
    private HubNetConnection hubNet;
    private FrontierConnection pushFrontier;

    public /* synthetic */ NetworkDependImpl(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NetworkDependImpl() {
        updateHubNet(1);
    }

    /* compiled from: NetworkDependImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/im/network/NetworkDependImpl$Companion;", "", "<init>", "()V", "HUB_REASON_IMSDK", "", "PUSH_REASON", "PUSH_REASON_USER_CHANGED", "instance", "Lcom/bytedance/trae/im/network/NetworkDependImpl;", "getInstance", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NetworkDependImpl getInstance() {
            NetworkDependImpl networkDependImpl = NetworkDependImpl.instance;
            if (networkDependImpl == null) {
                synchronized (this) {
                    networkDependImpl = NetworkDependImpl.instance;
                    if (networkDependImpl == null) {
                        networkDependImpl = new NetworkDependImpl(null);
                        Companion companion = NetworkDependImpl.INSTANCE;
                        NetworkDependImpl.instance = networkDependImpl;
                    }
                }
            }
            return networkDependImpl;
        }
    }

    private final void updateHubNet(Integer serviceId) {
        if (serviceId == null || Intrinsics.areEqual(serviceId, this.currentServiceId)) {
            return;
        }
        this.currentServiceId = serviceId;
        this.hubNet = new HubNetConnection(serviceId.intValue());
    }

    @Override // com.bytedance.trae.im.network.INetworkDepend
    public void connect(HubConnectionListener listener) {
        HubNetConnection hubNetConnection = this.hubNet;
        if (hubNetConnection != null) {
            hubNetConnection.connect(HUB_REASON_IMSDK, listener);
        }
        FrontierConnection frontierConnection = this.pushFrontier;
        if (frontierConnection != null) {
            frontierConnection.connect(PUSH_REASON);
        }
    }

    @Override // com.bytedance.trae.im.network.INetworkDepend
    public void disconnect() {
        HubNetConnection hubNetConnection = this.hubNet;
        if (hubNetConnection != null) {
            hubNetConnection.disconnect(HUB_REASON_IMSDK);
        }
        FrontierConnection frontierConnection = this.pushFrontier;
        if (frontierConnection != null) {
            frontierConnection.disconnect(PUSH_REASON);
        }
        if (FrontierSwitchConfig.INSTANCE.isDisabled()) {
            return;
        }
        this.pushFrontier = null;
        this.currentPushUserId = null;
        Integer num = this.currentServiceId;
        this.hubNet = new HubNetConnection(num != null ? num.intValue() : 1);
    }

    @Override // com.bytedance.trae.im.network.INetworkDepend
    public boolean isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailable(AppHost.INSTANCE.getApplication());
    }

    @Override // com.bytedance.trae.im.network.INetworkDepend
    public void initConfig(FrontierConfig config, Map<String, String> extraHeaders, boolean isToB, HubClientMetadata clientMetadata) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(extraHeaders, "extraHeaders");
        Intrinsics.checkNotNullParameter(clientMetadata, "clientMetadata");
        HubNetConnection hubNetConnection = this.hubNet;
        if (hubNetConnection != null) {
            hubNetConnection.setup(config, extraHeaders, isToB, clientMetadata);
        }
        if (isToB) {
            FrontierConnection frontierConnection = this.pushFrontier;
            if (frontierConnection != null) {
                frontierConnection.disconnect("tob_no_push");
            }
            this.pushFrontier = null;
            this.currentPushUserId = null;
            return;
        }
        String str = extraHeaders.get("user_id");
        Long longOrNull = str != null ? StringsKt.toLongOrNull(str) : null;
        if (!FrontierSwitchConfig.INSTANCE.isDisabled() && !Intrinsics.areEqual(longOrNull, this.currentPushUserId)) {
            FrontierConnection frontierConnection2 = this.pushFrontier;
            if (frontierConnection2 != null) {
                frontierConnection2.disconnect(PUSH_REASON_USER_CHANGED);
            }
            this.pushFrontier = null;
            this.currentPushUserId = null;
        }
        if (longOrNull == null || longOrNull.longValue() <= 0) {
            return;
        }
        if (this.pushFrontier == null) {
            Integer num = this.currentServiceId;
            this.pushFrontier = new FrontierConnection((num != null ? num.intValue() : 1) + 1, longOrNull);
        }
        this.currentPushUserId = longOrNull;
        Map mutableMap = MapsKt.toMutableMap(extraHeaders);
        String ppeEnv = DebugSettings.INSTANCE.getPpeEnv();
        if (ppeEnv.length() > 0) {
            mutableMap.put("x-tt-env", ppeEnv);
        }
        FrontierConnection frontierConnection3 = this.pushFrontier;
        if (frontierConnection3 != null) {
            frontierConnection3.setup(config, mutableMap, clientMetadata);
        }
    }

    @Override // com.bytedance.trae.im.network.INetworkDepend
    /* renamed from: getPushFrontierConnection, reason: from getter */
    public FrontierConnection getPushFrontier() {
        return this.pushFrontier;
    }

    @Override // com.bytedance.trae.im.network.INetworkDepend
    /* renamed from: getHubNetConnection, reason: from getter */
    public HubNetConnection getHubNet() {
        return this.hubNet;
    }

    @Override // com.bytedance.trae.im.network.INetworkDepend
    public void checkAlive() {
        HubNetConnection hubNetConnection = this.hubNet;
        if (hubNetConnection != null) {
            hubNetConnection.checkAliveAndReconnect();
        }
    }
}
