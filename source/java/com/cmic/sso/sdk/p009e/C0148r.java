package com.cmic.sso.sdk.p009e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;

/* compiled from: WifiNetworkUtils.java */
/* renamed from: com.cmic.sso.sdk.e.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0148r {

    /* renamed from: a */
    private static C0148r f337a;

    /* renamed from: b */
    private ConnectivityManager f338b;

    /* compiled from: WifiNetworkUtils.java */
    /* renamed from: com.cmic.sso.sdk.e.r$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface a {
        /* renamed from: a */
        void mo191a(Network network, ConnectivityManager.NetworkCallback networkCallback);
    }

    private C0148r(Context context) {
        try {
            this.f338b = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static C0148r m405a(Context context) {
        if (f337a == null) {
            synchronized (C0148r.class) {
                if (f337a == null) {
                    f337a = new C0148r(context);
                }
            }
        }
        return f337a;
    }

    /* renamed from: a */
    public synchronized void m407a(final a aVar) {
        if (this.f338b == null) {
            C0133c.m326a("WifiNetworkUtils", "mConnectivityManager 为空");
            aVar.mo191a(null, null);
            return;
        }
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.cmic.sso.sdk.e.r.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                try {
                    if (C0148r.this.f338b.getNetworkCapabilities(network).hasTransport(0)) {
                        aVar.mo191a(network, this);
                    } else {
                        C0133c.m326a("WifiNetworkUtils", "切换失败，未开启数据网络");
                        aVar.mo191a(null, this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar.mo191a(null, this);
                }
            }
        };
        try {
            this.f338b.requestNetwork(build, networkCallback);
        } catch (Exception e) {
            e.printStackTrace();
            aVar.mo191a(null, networkCallback);
        }
    }

    /* renamed from: a */
    public void m406a(ConnectivityManager.NetworkCallback networkCallback) {
        if (this.f338b == null || networkCallback == null) {
            return;
        }
        try {
            C0133c.m328b("WifiNetworkUtils", "unregisterNetworkCallback");
            this.f338b.unregisterNetworkCallback(networkCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
