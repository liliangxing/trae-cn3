package com.cmic.sso.sdk.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;

/* compiled from: WifiNetworkUtils.java */
/* loaded from: classes6.dex */
public class r {
    private static r a;
    private ConnectivityManager b;

    /* compiled from: WifiNetworkUtils.java */
    /* loaded from: classes6.dex */
    public interface a {
        void a(Network network, ConnectivityManager.NetworkCallback networkCallback);
    }

    private r(Context context) {
        try {
            this.b = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static r a(Context context) {
        if (a == null) {
            synchronized (r.class) {
                if (a == null) {
                    a = new r(context);
                }
            }
        }
        return a;
    }

    public synchronized void a(final a aVar) {
        if (this.b == null) {
            c.a("WifiNetworkUtils", "mConnectivityManager 为空");
            aVar.a(null, null);
            return;
        }
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.cmic.sso.sdk.e.r.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                try {
                    if (r.this.b.getNetworkCapabilities(network).hasTransport(0)) {
                        aVar.a(network, this);
                    } else {
                        c.a("WifiNetworkUtils", "切换失败，未开启数据网络");
                        aVar.a(null, this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar.a(null, this);
                }
            }
        };
        try {
            this.b.requestNetwork(build, networkCallback);
        } catch (Exception e) {
            e.printStackTrace();
            aVar.a(null, networkCallback);
        }
    }

    public void a(ConnectivityManager.NetworkCallback networkCallback) {
        if (this.b == null || networkCallback == null) {
            return;
        }
        try {
            c.b("WifiNetworkUtils", "unregisterNetworkCallback");
            this.b.unregisterNetworkCallback(networkCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
