package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.C0966z;
import com.hihonor.push.sdk.InterfaceC0910b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* renamed from: com.hihonor.push.sdk.f0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ServiceConnectionC0923f0 implements ServiceConnection {

    /* renamed from: e */
    public static final Object f706e = new Object();

    /* renamed from: a */
    public final RemoteServiceBean f707a;

    /* renamed from: b */
    public a f708b;

    /* renamed from: c */
    public Handler f709c = null;

    /* renamed from: d */
    public boolean f710d = false;

    /* renamed from: com.hihonor.push.sdk.f0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface a {
    }

    public ServiceConnectionC0923f0(RemoteServiceBean remoteServiceBean) {
        this.f707a = remoteServiceBean;
    }

    /* renamed from: a */
    public final void m765a(int i) {
        a aVar = this.f708b;
        if (aVar != null) {
            C0913c0 c0913c0 = (C0913c0) aVar;
            c0913c0.f693a.f696a.set(i == HonorPushErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode ? 2 : 1);
            c0913c0.f693a.m762a(i);
            c0913c0.f693a.f697b = null;
        }
    }

    /* renamed from: b */
    public void m766b() {
        try {
            Log.i("AIDLSrvConnection", "trying to unbind service from " + this);
            C0937l.f734e.m773a().unbindService(this);
        } catch (Exception e) {
            String str = "on unBind service exception:" + e.getMessage();
        }
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onNullBinding, than unBind.");
        if (this.f710d) {
            this.f710d = false;
            return;
        }
        m766b();
        m764a();
        a aVar = this.f708b;
        if (aVar != null) {
            C0913c0 c0913c0 = (C0913c0) aVar;
            c0913c0.f693a.f696a.set(1);
            c0913c0.f693a.m762a(8002005);
            c0913c0.f693a.f697b = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("AIDLSrvConnection", "enter onServiceConnected.");
        m764a();
        a aVar = this.f708b;
        if (aVar != null) {
            C0913c0 c0913c0 = (C0913c0) aVar;
            c0913c0.f693a.f697b = IPushInvoke.Stub.asInterface(iBinder);
            if (c0913c0.f693a.f697b == null) {
                c0913c0.f693a.f699d.m766b();
                c0913c0.f693a.f696a.set(1);
                c0913c0.f693a.m762a(8002001);
                return;
            }
            c0913c0.f693a.f696a.set(3);
            InterfaceC0910b0.a aVar2 = c0913c0.f693a.f698c;
            if (aVar2 != null) {
                C0966z.a aVar3 = (C0966z.a) aVar2;
                if (Looper.myLooper() == C0966z.this.f793a.getLooper()) {
                    aVar3.m787b();
                } else {
                    C0966z.this.f793a.post(new RunnableC0962x(aVar3));
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("AIDLSrvConnection", "enter onServiceDisconnected.");
        a aVar = this.f708b;
        if (aVar != null) {
            C0913c0 c0913c0 = (C0913c0) aVar;
            c0913c0.f693a.f696a.set(1);
            c0913c0.f693a.m762a(8002002);
            c0913c0.f693a.f697b = null;
        }
    }

    /* renamed from: a */
    public final void m764a() {
        synchronized (f706e) {
            Handler handler = this.f709c;
            if (handler != null) {
                handler.removeMessages(1001);
                this.f709c = null;
            }
        }
    }
}
