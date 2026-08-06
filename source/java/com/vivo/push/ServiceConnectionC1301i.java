package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1373ah;
import com.vivo.push.util.C1393t;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IPCManager.java */
/* renamed from: com.vivo.push.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ServiceConnectionC1301i implements ServiceConnection {

    /* renamed from: a */
    private static final Object f495a = new Object();

    /* renamed from: b */
    private static Map<String, ServiceConnectionC1301i> f496b = new HashMap();

    /* renamed from: c */
    private boolean f497c;

    /* renamed from: d */
    private String f498d;

    /* renamed from: e */
    private Context f499e;

    /* renamed from: g */
    private volatile IPCInvoke f501g;

    /* renamed from: i */
    private String f503i;

    /* renamed from: j */
    private Handler f504j;

    /* renamed from: h */
    private Object f502h = new Object();

    /* renamed from: f */
    private AtomicInteger f500f = new AtomicInteger(1);

    private ServiceConnectionC1301i(Context context, String str) {
        this.f498d = null;
        this.f504j = null;
        this.f499e = context;
        this.f503i = str;
        this.f504j = new Handler(Looper.getMainLooper(), new C1303j(this));
        String m925a = C1366aa.m925a(context);
        this.f498d = m925a;
        if (TextUtils.isEmpty(m925a) || TextUtils.isEmpty(this.f503i)) {
            C1393t.m1047c(this.f499e, "init error : push pkgname is " + this.f498d + " ; action is " + this.f503i);
            this.f497c = false;
        } else {
            this.f497c = C1373ah.m952a(context, this.f498d) >= 1260;
            m741b();
        }
    }

    /* renamed from: a */
    public static ServiceConnectionC1301i m738a(Context context, String str) {
        ServiceConnectionC1301i serviceConnectionC1301i;
        ServiceConnectionC1301i serviceConnectionC1301i2 = f496b.get(str);
        if (serviceConnectionC1301i2 != null) {
            return serviceConnectionC1301i2;
        }
        synchronized (f495a) {
            serviceConnectionC1301i = f496b.get(str);
            if (serviceConnectionC1301i == null) {
                serviceConnectionC1301i = new ServiceConnectionC1301i(context, str);
                f496b.put(str, serviceConnectionC1301i);
            }
        }
        return serviceConnectionC1301i;
    }

    /* renamed from: a */
    public final boolean m748a() {
        String m925a = C1366aa.m925a(this.f499e);
        this.f498d = m925a;
        if (TextUtils.isEmpty(m925a)) {
            C1393t.m1047c(this.f499e, "push pkgname is null");
            return false;
        }
        boolean z = C1373ah.m952a(this.f499e, this.f498d) >= 1260;
        this.f497c = z;
        return z;
    }

    /* renamed from: b */
    private void m741b() {
        int i = this.f500f.get();
        C1393t.m1048d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i)));
        if (i == 4 || i == 2 || i == 3 || i == 5 || !this.f497c) {
            return;
        }
        m740a(2);
        if (!m744c()) {
            m740a(1);
            C1393t.m1034a("AidlManager", "bind core service fail");
        } else {
            m745d();
        }
    }

    /* renamed from: c */
    private boolean m744c() {
        Intent intent = new Intent(this.f503i);
        intent.setPackage(this.f498d);
        try {
            return this.f499e.bindService(intent, this, 1);
        } catch (Exception e) {
            C1393t.m1035a("AidlManager", "bind core error", e);
            return false;
        }
    }

    /* renamed from: d */
    private void m745d() {
        this.f504j.removeMessages(1);
        this.f504j.sendEmptyMessageDelayed(1, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m740a(int i) {
        this.f500f.set(i);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m746e();
        this.f501g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.f501g == null) {
            C1393t.m1048d("AidlManager", "onServiceConnected error : aidl must not be null.");
            m747f();
            this.f500f.set(1);
            return;
        }
        if (this.f500f.get() == 2) {
            m740a(4);
        } else if (this.f500f.get() != 4) {
            m747f();
        }
        synchronized (this.f502h) {
            this.f502h.notifyAll();
        }
    }

    /* renamed from: e */
    private void m746e() {
        this.f504j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m747f() {
        try {
            this.f499e.unbindService(this);
        } catch (Exception e) {
            C1393t.m1034a("AidlManager", "On unBindServiceException:" + e.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f501g = null;
        m740a(1);
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        C1393t.m1041b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    /* renamed from: a */
    public final boolean m749a(Bundle bundle) {
        m741b();
        if (this.f500f.get() == 2) {
            synchronized (this.f502h) {
                try {
                    this.f502h.wait(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            int i = this.f500f.get();
            if (i != 4) {
                C1393t.m1048d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i)));
                return false;
            }
            this.f504j.removeMessages(2);
            this.f504j.sendEmptyMessageDelayed(2, 30000L);
            this.f501g.asyncCall(bundle, null);
            return true;
        } catch (Exception e2) {
            C1393t.m1035a("AidlManager", "invoke error ", e2);
            int i2 = this.f500f.get();
            C1393t.m1048d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i2)));
            if (i2 == 2) {
                m746e();
                m740a(1);
                return false;
            }
            if (i2 == 3) {
                m740a(1);
                return false;
            }
            if (i2 != 4) {
                return false;
            }
            m740a(1);
            m747f();
            return false;
        }
    }
}
