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

/* loaded from: classes7.dex */
public class w {
    private static w f;
    private Network a = null;
    private ConnectivityManager.NetworkCallback b = null;
    private ConnectivityManager c = null;
    private List<a> d = new ArrayList();
    private Timer e = null;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, Object obj);
    }

    private w() {
    }

    public static w a() {
        if (f == null) {
            synchronized (w.class) {
                if (f == null) {
                    f = new w();
                }
            }
        }
        return f;
    }

    private synchronized void a(a aVar) {
        try {
            this.d.add(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, Network network) {
        try {
            Timer timer = this.e;
            if (timer != null) {
                timer.cancel();
                this.e = null;
            }
            Iterator<a> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().a(z, network);
            }
            this.d.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final synchronized void a(Context context, a aVar) {
        Network network = this.a;
        if (network != null) {
            aVar.a(true, network);
            return;
        }
        a(aVar);
        if (this.b == null || this.d.size() < 2) {
            try {
                this.c = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addTransportType(0);
                builder.addCapability(12);
                NetworkRequest build = builder.build();
                this.b = new ConnectivityManager.NetworkCallback() { // from class: com.unicom.online.account.kernel.w.1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onAvailable(Network network2) {
                        super.onAvailable(network2);
                        aa.b("Network onAvailable");
                        w.this.a = network2;
                        w.this.a(true, network2);
                        try {
                            String extraInfo = w.this.c.getNetworkInfo(w.this.a).getExtraInfo();
                            if (TextUtils.isEmpty(extraInfo)) {
                                return;
                            }
                            ab.d(extraInfo);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onLost(Network network2) {
                        super.onLost(network2);
                        aa.b("Network onLost");
                        w.this.b();
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onUnavailable() {
                        super.onUnavailable();
                        aa.b("Network onUnavailable");
                        w.this.a(false, (Network) null);
                        w.this.b();
                    }
                };
                int i = 3000;
                if (ab.f() < 3000) {
                    i = 2000;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    this.c.requestNetwork(build, this.b, i);
                    return;
                }
                Timer timer = new Timer();
                this.e = timer;
                timer.schedule(new TimerTask() { // from class: com.unicom.online.account.kernel.w.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public final void run() {
                        w.this.a(false, (Network) null);
                    }
                }, i);
                this.c.requestNetwork(build, this.b);
            } catch (Exception e) {
                e.printStackTrace();
                a(false, (Network) null);
            }
        }
    }

    public final synchronized void b() {
        ConnectivityManager.NetworkCallback networkCallback;
        try {
            Timer timer = this.e;
            if (timer != null) {
                timer.cancel();
                this.e = null;
            }
            ConnectivityManager connectivityManager = this.c;
            if (connectivityManager != null && (networkCallback = this.b) != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            }
            this.c = null;
            this.b = null;
            this.a = null;
            this.d.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
