package cn.com.chinatelecom.account.api.p008c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import cn.com.chinatelecom.account.api.CtAuth;
import java.net.InetAddress;

/* renamed from: cn.com.chinatelecom.account.api.c.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0683c {

    /* renamed from: a */
    private static final String f184a = "c";

    /* renamed from: b */
    private static Handler f185b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private boolean f186c;

    /* renamed from: d */
    private Context f187d;

    /* renamed from: e */
    private ConnectivityManager.NetworkCallback f188e;

    public C0683c(Context context) {
        this.f187d = context;
    }

    /* renamed from: a */
    public static int m221a(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
        } catch (Throwable th) {
            CtAuth.warn(f184a, "When InetAddress.getByName(),throws exception", th);
            return -1;
        }
    }

    /* renamed from: b */
    public static String m224b(String str) {
        int indexOf = str.indexOf("://");
        if (indexOf > 0) {
            str = str.substring(indexOf + 3);
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 >= 0) {
            str = str.substring(0, indexOf2);
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 >= 0) {
            str = str.substring(0, indexOf3);
        }
        int indexOf4 = str.indexOf(63);
        return indexOf4 >= 0 ? str.substring(0, indexOf4) : str;
    }

    /* renamed from: b */
    private void m225b(final InterfaceC0682b interfaceC0682b) {
        f185b.postDelayed(new Runnable() { // from class: cn.com.chinatelecom.account.api.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (C0683c.this.m229d() || interfaceC0682b == null) {
                    return;
                }
                C0683c.this.m228c();
                interfaceC0682b.mo201a();
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m227c(String str) {
        try {
            Class<?> cls = Class.forName("android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f187d.getSystemService("connectivity");
            if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0) {
                cls.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class).invoke(connectivityManager, 0, "enableHIPRI");
                for (int i = 0; i < 5; i++) {
                    try {
                        if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                            break;
                        }
                        Thread.sleep(500L);
                    } catch (Throwable th) {
                        CtAuth.warn(f184a, "STMN_V4", th);
                    }
                }
            }
            boolean booleanValue = ((Boolean) cls.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(m221a(m224b(str))))).booleanValue();
            CtAuth.info(f184a, "STMN_V4 ：" + booleanValue);
            return booleanValue ? 0 : -2;
        } catch (Throwable th2) {
            CtAuth.warn(f184a, "STMN_V4_T", th2);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m228c() {
        this.f186c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public synchronized boolean m229d() {
        return this.f186c;
    }

    /* renamed from: a */
    public void m230a() {
        try {
            if (this.f188e != null) {
                ((ConnectivityManager) this.f187d.getSystemService("connectivity")).unregisterNetworkCallback(this.f188e);
                this.f188e = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m231a(final InterfaceC0682b interfaceC0682b) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            m225b(interfaceC0682b);
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f187d.getSystemService("connectivity");
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: cn.com.chinatelecom.account.api.c.c.2
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    if (C0683c.this.m229d() || interfaceC0682b == null) {
                        return;
                    }
                    C0683c.this.m228c();
                    interfaceC0682b.mo203a(network, System.currentTimeMillis() - currentTimeMillis);
                }
            };
            this.f188e = networkCallback;
            connectivityManager.requestNetwork(build, networkCallback);
        } catch (Throwable unused) {
            if (m229d() || interfaceC0682b == null) {
                return;
            }
            interfaceC0682b.mo202a(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    /* renamed from: a */
    public void m232a(final InterfaceC0682b interfaceC0682b, final String str) {
        new C0684d().m233a(new AbstractRunnableC0685e() { // from class: cn.com.chinatelecom.account.api.c.c.3
            @Override // cn.com.chinatelecom.account.api.p008c.AbstractRunnableC0685e
            /* renamed from: a */
            public void mo204a() {
                final long currentTimeMillis = System.currentTimeMillis();
                int m227c = C0683c.this.m227c(str);
                if (m227c == 0) {
                    interfaceC0682b.mo203a(null, System.currentTimeMillis() - currentTimeMillis);
                } else if (m227c == -1) {
                    C0683c.f185b.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.c.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            interfaceC0682b.mo202a(System.currentTimeMillis() - currentTimeMillis);
                        }
                    });
                } else {
                    C0683c.f185b.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.c.c.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            interfaceC0682b.mo201a();
                        }
                    });
                }
            }
        });
    }
}
