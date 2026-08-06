package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.ag */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1473ag implements InterfaceC1474ah {

    /* renamed from: a */
    private static boolean f941a;

    /* renamed from: a */
    private Context f943a;

    /* renamed from: a */
    private ServiceConnection f944a;

    /* renamed from: a */
    private volatile int f942a = 0;

    /* renamed from: a */
    private volatile String f946a = null;

    /* renamed from: b */
    private volatile boolean f948b = false;

    /* renamed from: b */
    private volatile String f947b = null;

    /* renamed from: a */
    private final Object f945a = new Object();

    public C1473ag(Context context) {
        this.f943a = context;
        m1476a();
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public boolean mo1483a() {
        return f941a;
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public String mo1482a() {
        m1478a("getOAID");
        return this.f946a;
    }

    /* renamed from: a */
    private void m1476a() {
        boolean z;
        this.f944a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            z = this.f943a.bindService(intent, this.f944a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f942a = z ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1481b() {
        ServiceConnection serviceConnection = this.f944a;
        if (serviceConnection != null) {
            try {
                this.f943a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m1478a(String str) {
        if (this.f942a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f945a) {
            try {
                AbstractC1417b.m1089a("huawei's " + str + " wait...");
                this.f945a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.ag$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            new Thread(new Runnable() { // from class: com.xiaomi.push.ag.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C1473ag.this.f946a = b.m1484a(iBinder);
                        C1473ag.this.f948b = b.m1485a(iBinder);
                        C1473ag.this.m1481b();
                        C1473ag.this.f942a = 2;
                        synchronized (C1473ag.this.f945a) {
                            try {
                                C1473ag.this.f945a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        C1473ag.this.m1481b();
                        C1473ag.this.f942a = 2;
                        synchronized (C1473ag.this.f945a) {
                            try {
                                C1473ag.this.f945a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        C1473ag.this.m1481b();
                        C1473ag.this.f942a = 2;
                        synchronized (C1473ag.this.f945a) {
                            try {
                                C1473ag.this.f945a.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    }
                }
            }).start();
        }
    }

    /* renamed from: com.xiaomi.push.ag$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class b {
        /* renamed from: a */
        static String m1484a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a */
        static boolean m1485a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: a */
    public static boolean m1479a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            f941a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }
}
