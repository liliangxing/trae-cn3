package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.android.http.legacy.protocol.HTTP;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1471ae;
import com.xiaomi.push.providers.C1701a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.push.fy */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1626fy {

    /* renamed from: a */
    private static C1471ae f1864a = new C1471ae(true);

    /* renamed from: a */
    private static volatile int f1862a = -1;

    /* renamed from: a */
    private static long f1863a = System.currentTimeMillis();

    /* renamed from: a */
    private static final Object f1866a = new Object();

    /* renamed from: a */
    private static List<a> f1868a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a */
    private static String f1867a = "";

    /* renamed from: a */
    private static C1701a f1865a = null;

    /* renamed from: a */
    public static void m2661a(Context context) {
        f1862a = m2667b(context);
    }

    /* renamed from: a */
    public static int m2654a(Context context) {
        if (f1862a == -1) {
            f1862a = m2667b(context);
        }
        return f1862a;
    }

    /* renamed from: b */
    private static int m2667b(Context context) {
        C1487au m1530a = C1486at.m1530a();
        if (m1530a == null) {
            return -1;
        }
        return m1530a.m1557a();
    }

    /* renamed from: a */
    private static synchronized String m2659a(Context context) {
        synchronized (C1626fy.class) {
            if (TextUtils.isEmpty(f1867a)) {
                return "";
            }
            return f1867a;
        }
    }

    /* renamed from: a */
    public static synchronized void m2666a(String str) {
        synchronized (C1626fy.class) {
            if (!C1694j.m3437d() && !TextUtils.isEmpty(str)) {
                f1867a = str;
            }
        }
    }

    /* renamed from: a */
    public static void m2663a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        m2662a(context, str, m2656a(m2654a(context), j, z, j2, z2), z, j2);
    }

    /* renamed from: a */
    private static void m2662a(final Context context, String str, long j, boolean z, long j2) {
        int m2654a;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (m2654a = m2654a(context))) {
            return;
        }
        synchronized (f1866a) {
            isEmpty = f1868a.isEmpty();
            m2665a(new a(str, j2, m2654a, z ? 1 : 0, m2654a == 0 ? m2659a(context) : "", j));
        }
        if (isEmpty) {
            f1864a.m1466a(new C1471ae.b() { // from class: com.xiaomi.push.fy.1
                @Override // com.xiaomi.push.C1471ae.b
                /* renamed from: b */
                public void mo1470b() {
                    ArrayList arrayList;
                    synchronized (C1626fy.f1866a) {
                        arrayList = new ArrayList(C1626fy.f1868a);
                        C1626fy.f1868a.clear();
                    }
                    C1626fy.m2668b(context, arrayList);
                }
            }, 5000L);
        }
    }

    /* renamed from: a */
    private static long m2656a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f1863a;
            f1863a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * (i == 0 ? 13 : 11)) / 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m2668b(Context context, List<a> list) {
        try {
            synchronized (C1701a.f2830a) {
                SQLiteDatabase writableDatabase = m2657a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Constants.PACKAGE_NAME, aVar.f1872a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f1871a));
                        contentValues.put("network_type", Integer.valueOf(aVar.f1870a));
                        contentValues.put("bytes", Long.valueOf(aVar.f1874b));
                        contentValues.put("rcv", Integer.valueOf(aVar.f1873b));
                        contentValues.put("imsi", aVar.f1875b);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            AbstractC1417b.m1093a(th);
        }
    }

    /* renamed from: a */
    private static C1701a m2657a(Context context) {
        C1701a c1701a = f1865a;
        if (c1701a != null) {
            return c1701a;
        }
        C1701a c1701a2 = new C1701a(context);
        f1865a = c1701a2;
        return c1701a2;
    }

    /* renamed from: a */
    public static int m2655a(String str) {
        try {
            return str.getBytes(HTTP.UTF_8).length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    /* renamed from: a */
    private static void m2665a(a aVar) {
        for (a aVar2 : f1868a) {
            if (aVar2.m2669a(aVar)) {
                aVar2.f1874b += aVar.f1874b;
                return;
            }
        }
        f1868a.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.fy$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        public int f1870a;

        /* renamed from: a */
        public long f1871a;

        /* renamed from: a */
        public String f1872a;

        /* renamed from: b */
        public int f1873b;

        /* renamed from: b */
        public long f1874b;

        /* renamed from: b */
        public String f1875b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f1872a = str;
            this.f1871a = j;
            this.f1870a = i;
            this.f1873b = i2;
            this.f1875b = str2;
            this.f1874b = j2;
        }

        /* renamed from: a */
        public boolean m2669a(a aVar) {
            return TextUtils.equals(aVar.f1872a, this.f1872a) && TextUtils.equals(aVar.f1875b, this.f1875b) && aVar.f1870a == this.f1870a && aVar.f1873b == this.f1873b && Math.abs(aVar.f1871a - this.f1871a) <= 5000;
        }
    }
}
