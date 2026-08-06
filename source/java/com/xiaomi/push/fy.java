package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public class fy {

    /* renamed from: a, reason: collision with other field name */
    private static ae f532a = new ae(true);
    private static volatile int a = -1;

    /* renamed from: a, reason: collision with other field name */
    private static long f531a = System.currentTimeMillis();

    /* renamed from: a, reason: collision with other field name */
    private static final Object f534a = new Object();

    /* renamed from: a, reason: collision with other field name */
    private static List<a> f536a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a, reason: collision with other field name */
    private static String f535a = "";

    /* renamed from: a, reason: collision with other field name */
    private static com.xiaomi.push.providers.a f533a = null;

    /* renamed from: a, reason: collision with other method in class */
    public static void m9925a(Context context) {
        a = b(context);
    }

    public static int a(Context context) {
        if (a == -1) {
            a = b(context);
        }
        return a;
    }

    private static int b(Context context) {
        au m9622a = at.m9622a();
        if (m9622a == null) {
            return -1;
        }
        return m9622a.a();
    }

    /* renamed from: a, reason: collision with other method in class */
    private static synchronized String m9923a(Context context) {
        synchronized (fy.class) {
            if (TextUtils.isEmpty(f535a)) {
                return "";
            }
            return f535a;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized void m9926a(String str) {
        synchronized (fy.class) {
            if (!j.m10110d() && !TextUtils.isEmpty(str)) {
                f535a = str;
            }
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(final Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f534a) {
            isEmpty = f536a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m9923a(context) : "", j));
        }
        if (isEmpty) {
            f532a.a(new ae.b() { // from class: com.xiaomi.push.fy.1
                @Override // com.xiaomi.push.ae.b
                public void b() {
                    ArrayList arrayList;
                    synchronized (fy.f534a) {
                        arrayList = new ArrayList(fy.f536a);
                        fy.f536a.clear();
                    }
                    fy.b(context, arrayList);
                }
            }, 5000L);
        }
    }

    private static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f531a;
            f531a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * (i == 0 ? 13 : 11)) / 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f906a) {
                SQLiteDatabase writableDatabase = m9922a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f538a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f537a));
                        contentValues.put("network_type", Integer.valueOf(aVar.a));
                        contentValues.put("bytes", Long.valueOf(aVar.f539b));
                        contentValues.put("rcv", Integer.valueOf(aVar.b));
                        contentValues.put("imsi", aVar.f540b);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m9922a(Context context) {
        com.xiaomi.push.providers.a aVar = f533a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f533a = aVar2;
        return aVar2;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static void a(a aVar) {
        for (a aVar2 : f536a) {
            if (aVar2.a(aVar)) {
                aVar2.f539b += aVar.f539b;
                return;
            }
        }
        f536a.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a {
        public int a;

        /* renamed from: a, reason: collision with other field name */
        public long f537a;

        /* renamed from: a, reason: collision with other field name */
        public String f538a;
        public int b;

        /* renamed from: b, reason: collision with other field name */
        public long f539b;

        /* renamed from: b, reason: collision with other field name */
        public String f540b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f538a = str;
            this.f537a = j;
            this.a = i;
            this.b = i2;
            this.f540b = str2;
            this.f539b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f538a, this.f538a) && TextUtils.equals(aVar.f540b, this.f540b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f537a - this.f537a) <= 5000;
        }
    }
}
