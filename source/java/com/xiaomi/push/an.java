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
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class an implements ah {
    private static boolean a;

    /* renamed from: a, reason: collision with other field name */
    private Context f177a;

    /* renamed from: a, reason: collision with other field name */
    private ServiceConnection f178a;

    /* renamed from: a, reason: collision with other field name */
    private volatile int f176a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile a f179a = null;

    /* renamed from: a, reason: collision with other field name */
    private final Object f180a = new Object();

    public an(Context context) {
        this.f177a = context;
        a();
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public boolean mo9615a() {
        return a;
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public String mo9614a() {
        a("getOAID");
        if (this.f179a == null) {
            return null;
        }
        return this.f179a.b;
    }

    private void a() {
        boolean z;
        this.f178a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            z = this.f177a.bindService(intent, this.f178a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f176a = z ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: collision with other method in class */
    public void m9621b() {
        ServiceConnection serviceConnection = this.f178a;
        if (serviceConnection != null) {
            try {
                this.f177a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    private void a(String str) {
        if (this.f176a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f180a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m9528a("oppo's " + str + " wait...");
                this.f180a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (an.this.f179a != null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.xiaomi.push.an.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String packageName = an.this.f177a.getPackageName();
                        String b = an.this.b();
                        a aVar = new a();
                        aVar.b = c.a(iBinder, packageName, b, "OUID");
                        an.this.f179a = aVar;
                        an.this.m9621b();
                        an.this.f176a = 2;
                        synchronized (an.this.f180a) {
                            try {
                                an.this.f180a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        an.this.m9621b();
                        an.this.f176a = 2;
                        synchronized (an.this.f180a) {
                            try {
                                an.this.f180a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        an.this.m9621b();
                        an.this.f176a = 2;
                        synchronized (an.this.f180a) {
                            try {
                                an.this.f180a.notifyAll();
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
    private class a {

        /* renamed from: a, reason: collision with other field name */
        String f181a;
        String b;
        String c;
        String d;

        private a() {
            this.f181a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        try {
            Signature[] signatureArr = this.f177a.getPackageManager().getPackageInfo(this.f177a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* loaded from: classes7.dex */
    private static class c {
        static String a(IBinder iBinder, String str, String str2, String str3) {
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

    public static boolean a(Context context) {
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
                a = j >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
