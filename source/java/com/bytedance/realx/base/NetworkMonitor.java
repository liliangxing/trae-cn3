package com.bytedance.realx.base;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.ParcelFileDescriptor;

/* loaded from: classes4.dex */
public class NetworkMonitor {
    private static final String TAG = "NetworkMonitor";
    private String cellularIfName;
    private ConnectivityManager connectivityManager;
    private Network cellularNetwork = null;
    private long cellularRequestCallback = 0;
    private Boolean cellularNetworkRequested = false;
    private Boolean shouldEmitAvailable = false;
    private NetworkMonitoCallback networkMonitorCallback = null;

    /* loaded from: classes4.dex */
    class NetworkMonitoCallback extends ConnectivityManager.NetworkCallback {
        NetworkMonitoCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            synchronized (NetworkMonitor.this) {
                RXLogging.w(NetworkMonitor.TAG, "on available, network: " + network.toString());
                if (NetworkMonitor.this.cellularNetwork == null) {
                    NetworkMonitor.this.cellularNetwork = network;
                    NetworkMonitor.this.shouldEmitAvailable = true;
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            synchronized (NetworkMonitor.this) {
                RXLogging.w(NetworkMonitor.TAG, "on unavailable");
                if (NetworkMonitor.this.cellularRequestCallback != 0) {
                    NativeNetworkFunctions.nativeOnNetworkUnavailable(NetworkMonitor.this.cellularRequestCallback);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            synchronized (NetworkMonitor.this) {
                RXLogging.w(NetworkMonitor.TAG, "on lost, network: " + network.toString());
                if (network.equals(NetworkMonitor.this.cellularNetwork)) {
                    NetworkMonitor.this.cellularNetwork = null;
                    if (NetworkMonitor.this.cellularRequestCallback != 0 && NetworkMonitor.this.cellularIfName != null) {
                        NativeNetworkFunctions.nativeOnNetworkLost(NetworkMonitor.this.cellularIfName, NetworkMonitor.this.cellularRequestCallback);
                    }
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            synchronized (NetworkMonitor.this) {
                RXLogging.w(NetworkMonitor.TAG, "on capabilities changed, network: " + network.toString() + ", capabilities: " + networkCapabilities.toString());
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            synchronized (NetworkMonitor.this) {
                RXLogging.w(NetworkMonitor.TAG, "on link properties changed, network: " + network.toString() + ", capabilities: " + linkProperties.toString());
                if (network.equals(NetworkMonitor.this.cellularNetwork)) {
                    NetworkMonitor.this.cellularIfName = linkProperties.getInterfaceName();
                    if (NetworkMonitor.this.cellularRequestCallback != 0 && NetworkMonitor.this.shouldEmitAvailable.booleanValue() && NetworkMonitor.this.cellularIfName != null) {
                        NativeNetworkFunctions.nativeOnNetworkAvailable(NetworkMonitor.this.cellularIfName, NetworkMonitor.this.cellularRequestCallback);
                        NetworkMonitor.this.shouldEmitAvailable = false;
                    }
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean blocked) {
            synchronized (NetworkMonitor.this) {
                RXLogging.w(NetworkMonitor.TAG, "on network block status changed, network: " + network.toString() + ", blocked: " + blocked);
                if (network.equals(NetworkMonitor.this.cellularNetwork) && NetworkMonitor.this.cellularRequestCallback != 0 && NetworkMonitor.this.cellularIfName != null) {
                    NativeNetworkFunctions.nativeOnBlockedStatusChanged(NetworkMonitor.this.cellularIfName, blocked, NetworkMonitor.this.cellularRequestCallback);
                }
            }
        }
    }

    public static NetworkMonitor create() {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        return new NetworkMonitor();
    }

    public NetworkMonitor() {
        this.connectivityManager = null;
        this.connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
    }

    public void requestCellularNetwork(long callback) {
        synchronized (this) {
            if (!this.cellularNetworkRequested.booleanValue()) {
                try {
                    this.cellularRequestCallback = callback;
                    NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
                    NetworkMonitoCallback networkMonitoCallback = new NetworkMonitoCallback();
                    this.networkMonitorCallback = networkMonitoCallback;
                    this.connectivityManager.requestNetwork(build, networkMonitoCallback);
                    this.cellularNetworkRequested = true;
                } catch (Exception e) {
                    RXLogging.w(TAG, "Request cellular network exception: " + e.toString());
                }
            }
        }
    }

    public void cancelRequestCellularNetwork() {
        synchronized (this) {
            if (this.cellularNetworkRequested.booleanValue()) {
                try {
                    this.connectivityManager.unregisterNetworkCallback(this.networkMonitorCallback);
                    this.cellularNetwork = null;
                    this.cellularRequestCallback = 0L;
                    this.cellularNetworkRequested = false;
                } catch (Exception e) {
                    RXLogging.w(TAG, "Cancel request cellular network exception: " + e.toString());
                }
            }
        }
    }

    public int bindSocketToCellularNetwork(int fd, String networkName) {
        int i;
        synchronized (this) {
            if (this.cellularNetwork != null && networkName.equals(this.cellularIfName)) {
                RXLogging.w(TAG, "bind socket to network, fd: " + fd);
                try {
                    ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(fd);
                    this.cellularNetwork.bindSocket(fromFd.getFileDescriptor());
                    fromFd.detachFd();
                    fromFd.close();
                    i = 0;
                } catch (Exception e) {
                    RXLogging.w(TAG, "bind socket to network exception: " + e.toString());
                    e.printStackTrace();
                }
            }
            i = -1;
        }
        return i;
    }
}
