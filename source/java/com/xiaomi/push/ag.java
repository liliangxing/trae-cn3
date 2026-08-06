package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ag implements ah {
    private static boolean a;

    /* renamed from: a, reason: collision with other field name */
    private Context f155a;

    /* renamed from: a, reason: collision with other field name */
    private ServiceConnection f156a;

    /* renamed from: a, reason: collision with other field name */
    private volatile int f154a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile String f158a = null;

    /* renamed from: b, reason: collision with other field name */
    private volatile boolean f159b = false;
    private volatile String b = null;

    /* renamed from: a, reason: collision with other field name */
    private final Object f157a = new Object();

    public ag(Context context) {
        this.f155a = context;
        a();
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo9615a() {
        return a;
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a, reason: collision with other method in class */
    public String mo9614a() {
        a("getOAID");
        return this.f158a;
    }

    private void a() {
        boolean z;
        this.f156a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            z = this.f155a.bindService(intent, this.f156a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f154a = z ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f156a;
        if (serviceConnection != null) {
            try {
                this.f155a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    private void a(String str) {
        if (this.f154a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f157a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m9528a("huawei's " + str + " wait...");
                this.f157a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
                        ag.this.f158a = b.a(iBinder);
                        ag.this.f159b = b.m9616a(iBinder);
                        ag.this.b();
                        ag.this.f154a = 2;
                        synchronized (ag.this.f157a) {
                            try {
                                ag.this.f157a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ag.this.b();
                        ag.this.f154a = 2;
                        synchronized (ag.this.f157a) {
                            try {
                                ag.this.f157a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        ag.this.b();
                        ag.this.f154a = 2;
                        synchronized (ag.this.f157a) {
                            try {
                                ag.this.f157a.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes7.dex */
    private static class b {
        static String a(IBinder iBinder) {
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

        /* renamed from: a, reason: collision with other method in class */
        static boolean m9616a(IBinder iBinder) {
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

    public static boolean a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }
}
