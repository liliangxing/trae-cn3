package com.unicom.online.account.kernel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.unicom.online.account.kernel.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1191w {

    /* renamed from: f */
    private static C1191w f316f;

    /* renamed from: a */
    private Network f317a = null;

    /* renamed from: b */
    private ConnectivityManager.NetworkCallback f318b = null;

    /* renamed from: c */
    private ConnectivityManager f319c = null;

    /* renamed from: d */
    private List<a> f320d = new ArrayList();

    /* renamed from: e */
    private Timer f321e = null;

    /* renamed from: com.unicom.online.account.kernel.w$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        /* renamed from: a */
        void mo548a(boolean z, Object obj);
    }

    private C1191w() {
    }

    /* renamed from: a */
    public static C1191w m564a() {
        if (f316f == null) {
            synchronized (C1191w.class) {
                if (f316f == null) {
                    f316f = new C1191w();
                }
            }
        }
        return f316f;
    }

    /* renamed from: a */
    private synchronized void m565a(a aVar) {
        try {
            this.f320d.add(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m567a(boolean z, Network network) {
        try {
            Timer timer = this.f321e;
            if (timer != null) {
                timer.cancel();
                this.f321e = null;
            }
            Iterator<a> it = this.f320d.iterator();
            while (it.hasNext()) {
                it.next().mo548a(z, network);
            }
            this.f320d.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final synchronized void m569a(Context context, a aVar) {
        Network network = this.f317a;
        if (network != null) {
            aVar.mo548a(true, network);
            return;
        }
        m565a(aVar);
        if (this.f318b == null || this.f320d.size() < 2) {
            try {
                this.f319c = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addTransportType(0);
                builder.addCapability(12);
                NetworkRequest build = builder.build();
                this.f318b = new ConnectivityManager.NetworkCallback() { // from class: com.unicom.online.account.kernel.w.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onAvailable(Network network2) {
                        super.onAvailable(network2);
                        C1165aa.m448b("Network onAvailable");
                        C1191w.this.f317a = network2;
                        C1191w.this.m567a(true, network2);
                        try {
                            String extraInfo = C1191w.this.f319c.getNetworkInfo(C1191w.this.f317a).getExtraInfo();
                            if (TextUtils.isEmpty(extraInfo)) {
                                return;
                            }
                            C1166ab.m461d(extraInfo);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onLost(Network network2) {
                        super.onLost(network2);
                        C1165aa.m448b("Network onLost");
                        C1191w.this.m570b();
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onUnavailable() {
                        super.onUnavailable();
                        C1165aa.m448b("Network onUnavailable");
                        C1191w.this.m567a(false, (Network) null);
                        C1191w.this.m570b();
                    }
                };
                int i = 3000;
                if (C1166ab.m464f() < 3000) {
                    i = 2000;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f319c.requestNetwork(build, this.f318b, i);
                    return;
                }
                Timer timer = new Timer();
                this.f321e = timer;
                timer.schedule(new TimerTask() { // from class: com.unicom.online.account.kernel.w.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public final void run() {
                        C1191w.this.m567a(false, (Network) null);
                    }
                }, i);
                this.f319c.requestNetwork(build, this.f318b);
            } catch (Exception e) {
                e.printStackTrace();
                m567a(false, (Network) null);
            }
        }
    }

    /* renamed from: b */
    public final synchronized void m570b() {
        ConnectivityManager.NetworkCallback networkCallback;
        try {
            Timer timer = this.f321e;
            if (timer != null) {
                timer.cancel();
                this.f321e = null;
            }
            ConnectivityManager connectivityManager = this.f319c;
            if (connectivityManager != null && (networkCallback = this.f318b) != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            }
            this.f319c = null;
            this.f318b = null;
            this.f317a = null;
            this.f320d.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
