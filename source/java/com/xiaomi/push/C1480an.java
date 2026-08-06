package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.an */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1480an implements InterfaceC1474ah {

    /* renamed from: a */
    private static boolean f985a;

    /* renamed from: a */
    private Context f987a;

    /* renamed from: a */
    private ServiceConnection f988a;

    /* renamed from: a */
    private volatile int f986a = 0;

    /* renamed from: a */
    private volatile a f989a = null;

    /* renamed from: a */
    private final Object f990a = new Object();

    public C1480an(Context context) {
        this.f987a = context;
        m1514a();
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public boolean mo1483a() {
        return f985a;
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public String mo1482a() {
        m1516a("getOAID");
        if (this.f989a == null) {
            return null;
        }
        return this.f989a.f993b;
    }

    /* renamed from: a */
    private void m1514a() {
        boolean z;
        this.f988a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            z = this.f987a.bindService(intent, this.f988a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f986a = z ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1519b() {
        ServiceConnection serviceConnection = this.f988a;
        if (serviceConnection != null) {
            try {
                this.f987a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m1516a(String str) {
        if (this.f986a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f990a) {
            try {
                AbstractC1417b.m1089a("oppo's " + str + " wait...");
                this.f990a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.an$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class b implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (C1480an.this.f989a != null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.xiaomi.push.an.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String packageName = C1480an.this.f987a.getPackageName();
                        String m1518b = C1480an.this.m1518b();
                        a aVar = new a();
                        aVar.f993b = c.m1520a(iBinder, packageName, m1518b, "OUID");
                        C1480an.this.f989a = aVar;
                        C1480an.this.m1519b();
                        C1480an.this.f986a = 2;
                        synchronized (C1480an.this.f990a) {
                            try {
                                C1480an.this.f990a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        C1480an.this.m1519b();
                        C1480an.this.f986a = 2;
                        synchronized (C1480an.this.f990a) {
                            try {
                                C1480an.this.f990a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        C1480an.this.m1519b();
                        C1480an.this.f986a = 2;
                        synchronized (C1480an.this.f990a) {
                            try {
                                C1480an.this.f990a.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    }
                }
            }).start();
        }
    }

    /* renamed from: com.xiaomi.push.an$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class a {

        /* renamed from: a */
        String f992a;

        /* renamed from: b */
        String f993b;

        /* renamed from: c */
        String f994c;

        /* renamed from: d */
        String f995d;

        private a() {
            this.f992a = null;
            this.f993b = null;
            this.f994c = null;
            this.f995d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m1518b() {
        try {
            Signature[] signatureArr = this.f987a.getPackageManager().getPackageInfo(this.f987a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: com.xiaomi.push.an$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class c {
        /* renamed from: a */
        static String m1520a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: a */
    public static boolean m1517a(Context context) {
        long j;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    j = packageInfo.getLongVersionCode();
                } else {
                    j = packageInfo.versionCode;
                }
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                f985a = j >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
