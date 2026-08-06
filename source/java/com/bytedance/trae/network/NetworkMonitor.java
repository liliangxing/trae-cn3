package com.bytedance.trae.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: NetworkMonitor.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J\u0015\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/network/NetworkMonitor;", "", "<init>", "()V", "DEFAULT_CONNECTED", "", "_isConnected", "Lkotlinx/coroutines/flow/MutableStateFlow;", "isConnected", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "initialized", "connectivityManager", "Landroid/net/ConnectivityManager;", EventConstants.PARAM_SOURCE_INIT, "", "context", "Landroid/content/Context;", "isNetworkAvailable", "applyE2EConnectivityOverride", "available", "(Ljava/lang/Boolean;)V", "checkConnectivity", "cm", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NetworkMonitor {
    private static final boolean DEFAULT_CONNECTED = true;
    public static final NetworkMonitor INSTANCE = new NetworkMonitor();
    private static final MutableStateFlow<Boolean> _isConnected;
    private static ConnectivityManager connectivityManager;
    private static volatile boolean initialized;
    private static final StateFlow<Boolean> isConnected;

    private NetworkMonitor() {
    }

    static {
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(true);
        _isConnected = MutableStateFlow;
        isConnected = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<Boolean> isConnected() {
        return isConnected;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (initialized) {
            return;
        }
        initialized = true;
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        ConnectivityManager connectivityManager2 = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager2 == null) {
            return;
        }
        connectivityManager = connectivityManager2;
        _isConnected.setValue(Boolean.valueOf(checkConnectivity(connectivityManager2)));
        connectivityManager2.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.trae.network.NetworkMonitor$init$callback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                MutableStateFlow mutableStateFlow;
                Intrinsics.checkNotNullParameter(network, ErrorType.NETWORK);
                if (E2ENetworkOverrides.INSTANCE.networkAvailableOverrideOrNull() != null) {
                    return;
                }
                mutableStateFlow = NetworkMonitor._isConnected;
                mutableStateFlow.setValue(true);
                BytecloudNetworkCacheReset.INSTANCE.onNetworkChanged();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                MutableStateFlow mutableStateFlow;
                Intrinsics.checkNotNullParameter(network, ErrorType.NETWORK);
                if (E2ENetworkOverrides.INSTANCE.networkAvailableOverrideOrNull() != null) {
                    return;
                }
                mutableStateFlow = NetworkMonitor._isConnected;
                mutableStateFlow.setValue(false);
                BytecloudNetworkCacheReset.INSTANCE.onNetworkChanged();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                MutableStateFlow mutableStateFlow;
                if (E2ENetworkOverrides.INSTANCE.networkAvailableOverrideOrNull() != null) {
                    return;
                }
                mutableStateFlow = NetworkMonitor._isConnected;
                mutableStateFlow.setValue(false);
            }
        });
    }

    public final boolean isNetworkAvailable() {
        Boolean networkAvailableOverrideOrNull = E2ENetworkOverrides.INSTANCE.networkAvailableOverrideOrNull();
        if (networkAvailableOverrideOrNull != null) {
            return networkAvailableOverrideOrNull.booleanValue();
        }
        ConnectivityManager connectivityManager2 = connectivityManager;
        return connectivityManager2 == null ? ((Boolean) _isConnected.getValue()).booleanValue() : checkConnectivity(connectivityManager2);
    }

    public final void applyE2EConnectivityOverride(Boolean available) {
        if (available != null) {
            _isConnected.setValue(available);
        } else {
            ConnectivityManager connectivityManager2 = connectivityManager;
            _isConnected.setValue(Boolean.valueOf(connectivityManager2 != null ? checkConnectivity(connectivityManager2) : true));
        }
        BytecloudNetworkCacheReset.INSTANCE.onNetworkChanged();
    }

    private final boolean checkConnectivity(ConnectivityManager cm) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = cm.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = cm.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }
}
