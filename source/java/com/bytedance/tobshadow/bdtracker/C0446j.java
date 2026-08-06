package com.bytedance.tobshadow.bdtracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.bytedance.tobshadow.bdtracker.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0446j<SERVICE, RESULT> {

    /* renamed from: a */
    public final CountDownLatch f689a = new CountDownLatch(1);

    /* renamed from: b */
    public final Intent f690b;

    /* renamed from: c */
    public final b<SERVICE, RESULT> f691c;

    /* renamed from: d */
    public final Context f692d;

    /* renamed from: com.bytedance.tobshadow.bdtracker.j$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements ServiceConnection {

        /* renamed from: a */
        public final CountDownLatch f693a;

        /* renamed from: b */
        public final b<SERVICE, RESULT> f694b;

        /* renamed from: c */
        public SERVICE f695c;

        public a(C0446j c0446j, CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.f693a = countDownLatch;
            this.f694b = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LoggerImpl.global().debug(1, "Oaid#ServiceBlockBinder#onServiceConnected " + componentName, new Object[0]);
            try {
                this.f695c = this.f694b.m482a(iBinder);
                try {
                    this.f693a.countDown();
                } catch (Exception e) {
                    LoggerImpl.global().error(1, "Oaid#count down failed", e, new Object[0]);
                }
            } catch (Throwable th) {
                try {
                    LoggerImpl.global().error(1, "Oaid#ServiceBlockBinder#onServiceConnected", th, new Object[0]);
                    try {
                        this.f693a.countDown();
                    } catch (Exception e2) {
                        LoggerImpl.global().error(1, "Oaid#count down failed", e2, new Object[0]);
                    }
                } catch (Throwable th2) {
                    try {
                        this.f693a.countDown();
                    } catch (Exception e3) {
                        LoggerImpl.global().error(1, "Oaid#count down failed", e3, new Object[0]);
                    }
                    throw th2;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LoggerImpl.global().debug(1, "Oaid#ServiceBlockBinder#onServiceDisconnected" + componentName, new Object[0]);
            try {
                this.f693a.countDown();
            } catch (Exception e) {
                LoggerImpl.global().error(1, "Oaid#countDown failed", e, new Object[0]);
            }
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.j$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface b<T, RESULT> {
        /* renamed from: a */
        T m482a(IBinder iBinder);

        /* renamed from: a */
        RESULT m483a(T t);
    }

    public C0446j(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.f692d = context;
        this.f690b = intent;
        this.f691c = bVar;
    }

    /* renamed from: a */
    public RESULT m480a() {
        Throwable th;
        C0446j<SERVICE, RESULT>.a aVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            LoggerImpl.global().warn(1, "Oaid#can't run in ui thread", new Object[0]);
            return null;
        }
        try {
            aVar = new a(this, this.f689a, this.f691c);
            this.f692d.bindService(this.f690b, aVar, 1);
            this.f689a.await();
            try {
                return this.f691c.m483a((b<SERVICE, RESULT>) aVar.f695c);
            } catch (Throwable th2) {
                th = th2;
                try {
                    LoggerImpl.global().error(1, "Oaid#blockFetchResult failed", th, new Object[0]);
                    return null;
                } finally {
                    m481a(aVar);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            aVar = null;
        }
    }

    /* renamed from: a */
    public final void m481a(C0446j<SERVICE, RESULT>.a aVar) {
        if (aVar != null) {
            try {
                this.f692d.unbindService(aVar);
            } catch (Throwable th) {
                LoggerImpl.global().error(1, "Oaid#Release connection failed", th, new Object[0]);
            }
        }
    }
}
