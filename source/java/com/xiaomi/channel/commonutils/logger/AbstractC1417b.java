package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.C1694j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.channel.commonutils.logger.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1417b {

    /* renamed from: a */
    private static int f742a = 2;

    /* renamed from: a */
    private static Context f743a;

    /* renamed from: a */
    private static boolean f749a;

    /* renamed from: b */
    private static boolean f751b;

    /* renamed from: a */
    private static String f746a = "XMPush-" + Process.myPid();

    /* renamed from: a */
    private static LoggerInterface f744a = new a();

    /* renamed from: a */
    private static final HashMap<Integer, Long> f747a = new HashMap<>();

    /* renamed from: b */
    private static final HashMap<Integer, String> f750b = new HashMap<>();

    /* renamed from: a */
    private static final Integer f745a = -1;

    /* renamed from: a */
    private static AtomicInteger f748a = new AtomicInteger(1);

    /* renamed from: a */
    private static boolean m1094a() {
        return false;
    }

    /* renamed from: com.xiaomi.channel.commonutils.logger.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static class a implements LoggerInterface {

        /* renamed from: a */
        private String f752a = AbstractC1417b.f746a;

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.f752a = str;
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.f752a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.f752a, str, th);
        }
    }

    /* renamed from: a */
    public static void m1087a(LoggerInterface loggerInterface) {
        f744a = loggerInterface;
    }

    /* renamed from: a */
    private static boolean m1095a(int i) {
        return i >= f742a || m1094a();
    }

    /* renamed from: a */
    public static void m1089a(String str) {
        if (m1095a(2)) {
            m1083a(2, m1079a(str));
        }
    }

    /* renamed from: a */
    public static void m1090a(String str, String str2) {
        if (m1095a(2)) {
            m1083a(2, m1097b(str, str2));
        }
    }

    /* renamed from: a */
    public static void m1092a(String str, Object... objArr) {
        if (m1095a(2)) {
            m1083a(2, m1081a(str, objArr));
        }
    }

    /* renamed from: b */
    public static void m1098b(String str) {
        if (m1095a(0)) {
            m1083a(0, m1079a(str));
        }
    }

    /* renamed from: c */
    public static void m1101c(String str) {
        if (m1095a(0)) {
            m1083a(1, m1079a(str));
        }
    }

    /* renamed from: b */
    public static void m1099b(String str, String str2) {
        if (m1095a(1)) {
            m1083a(1, m1097b(str, str2));
        }
    }

    /* renamed from: b */
    public static void m1100b(String str, Object... objArr) {
        if (m1095a(1)) {
            m1083a(1, m1081a(str, objArr));
        }
    }

    /* renamed from: a */
    public static void m1091a(String str, Throwable th) {
        if (m1095a(4)) {
            m1084a(4, m1079a(str), th);
        }
    }

    /* renamed from: a */
    public static void m1093a(Throwable th) {
        if (m1095a(4)) {
            m1085a(4, th);
        }
    }

    /* renamed from: d */
    public static void m1103d(String str) {
        if (m1095a(4)) {
            m1083a(4, m1079a(str));
        }
    }

    /* renamed from: c */
    public static void m1102c(String str, String str2) {
        if (m1095a(4)) {
            m1083a(4, m1097b(str, str2));
        }
    }

    /* renamed from: a */
    public static Integer m1077a(String str) {
        if (f742a <= 1) {
            Integer valueOf = Integer.valueOf(f748a.incrementAndGet());
            f747a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            f750b.put(valueOf, str);
            f744a.log(str + " starts");
            return valueOf;
        }
        return f745a;
    }

    /* renamed from: a */
    public static void m1088a(Integer num) {
        if (f742a <= 1) {
            HashMap<Integer, Long> hashMap = f747a;
            if (hashMap.containsKey(num)) {
                long longValue = hashMap.remove(num).longValue();
                f744a.log(f750b.remove(num) + " ends in " + (System.currentTimeMillis() - longValue) + " ms");
            }
        }
    }

    /* renamed from: a */
    public static void m1083a(int i, String str) {
        if (i >= f742a) {
            f744a.log(str);
        } else if (m1094a()) {
            Log.d("MyLog", "-->log(" + i + "): " + str);
        }
    }

    /* renamed from: a */
    public static void m1085a(int i, Throwable th) {
        if (i >= f742a) {
            f744a.log("", th);
        } else if (m1094a()) {
            Log.w("MyLog", "-->log(" + i + "): ", th);
        }
    }

    /* renamed from: a */
    public static void m1084a(int i, String str, Throwable th) {
        if (i >= f742a) {
            f744a.log(str, th);
        } else if (m1094a()) {
            Log.w("MyLog", "-->log(" + i + "): " + str, th);
        }
    }

    /* renamed from: a */
    private static String m1079a(String str) {
        return m1096b() + str;
    }

    /* renamed from: b */
    private static String m1097b(String str, String str2) {
        return m1096b() + m1080a(str, str2);
    }

    /* renamed from: a */
    private static String m1081a(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder("[Tid:");
        sb.append(Thread.currentThread().getId()).append("] [");
        sb.append(str).append("] ");
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m1080a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    /* renamed from: b */
    private static String m1096b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    /* renamed from: a */
    public static void m1082a(int i) {
        if (i < 0 || i > 5) {
            m1083a(2, "set log level as " + i);
        }
        f742a = i;
    }

    /* renamed from: a */
    public static int m1076a() {
        return f742a;
    }

    /* renamed from: a */
    public static void m1086a(Context context) {
        f743a = context;
        if (C1694j.m3427a(context)) {
            f749a = true;
        }
        if (C1694j.m3426a()) {
            f751b = true;
        }
    }

    /* renamed from: e */
    public static void m1105e(String str) {
        if (f749a) {
            m1089a(str);
            return;
        }
        Log.w(f746a, m1079a(str));
        if (f751b) {
            return;
        }
        m1089a(str);
    }

    /* renamed from: d */
    public static void m1104d(String str, String str2) {
        if (f749a) {
            m1090a(str, str2);
            return;
        }
        Log.w(f746a, m1097b(str, str2));
        if (f751b) {
            return;
        }
        m1090a(str, str2);
    }
}
