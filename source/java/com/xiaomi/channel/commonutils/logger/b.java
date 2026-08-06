package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public abstract class b {
    private static int a = 2;

    /* renamed from: a, reason: collision with other field name */
    private static Context f58a;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f64a;

    /* renamed from: b, reason: collision with other field name */
    private static boolean f65b;

    /* renamed from: a, reason: collision with other field name */
    private static String f61a = "XMPush-" + Process.myPid();

    /* renamed from: a, reason: collision with other field name */
    private static LoggerInterface f59a = new a();

    /* renamed from: a, reason: collision with other field name */
    private static final HashMap<Integer, Long> f62a = new HashMap<>();
    private static final HashMap<Integer, String> b = new HashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private static final Integer f60a = -1;

    /* renamed from: a, reason: collision with other field name */
    private static AtomicInteger f63a = new AtomicInteger(1);

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m9531a() {
        return false;
    }

    /* loaded from: classes7.dex */
    static class a implements LoggerInterface {
        private String a = b.f61a;

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String str) {
            this.a = str;
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str) {
            Log.v(this.a, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String str, Throwable th) {
            Log.v(this.a, str, th);
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f59a = loggerInterface;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m9532a(int i) {
        return i >= a || m9531a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m9528a(String str) {
        if (m9532a(2)) {
            a(2, m9527a(str));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m9529a(String str, String str2) {
        if (m9532a(2)) {
            a(2, b(str, str2));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m9530a(String str, Object... objArr) {
        if (m9532a(2)) {
            a(2, a(str, objArr));
        }
    }

    public static void b(String str) {
        if (m9532a(0)) {
            a(0, m9527a(str));
        }
    }

    public static void c(String str) {
        if (m9532a(0)) {
            a(1, m9527a(str));
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public static void m9533b(String str, String str2) {
        if (m9532a(1)) {
            a(1, b(str, str2));
        }
    }

    public static void b(String str, Object... objArr) {
        if (m9532a(1)) {
            a(1, a(str, objArr));
        }
    }

    public static void a(String str, Throwable th) {
        if (m9532a(4)) {
            a(4, m9527a(str), th);
        }
    }

    public static void a(Throwable th) {
        if (m9532a(4)) {
            a(4, th);
        }
    }

    public static void d(String str) {
        if (m9532a(4)) {
            a(4, m9527a(str));
        }
    }

    public static void c(String str, String str2) {
        if (m9532a(4)) {
            a(4, b(str, str2));
        }
    }

    public static Integer a(String str) {
        if (a <= 1) {
            Integer valueOf = Integer.valueOf(f63a.incrementAndGet());
            f62a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            b.put(valueOf, str);
            f59a.log(str + " starts");
            return valueOf;
        }
        return f60a;
    }

    public static void a(Integer num) {
        if (a <= 1) {
            HashMap<Integer, Long> hashMap = f62a;
            if (hashMap.containsKey(num)) {
                long longValue = hashMap.remove(num).longValue();
                f59a.log(b.remove(num) + " ends in " + (System.currentTimeMillis() - longValue) + " ms");
            }
        }
    }

    public static void a(int i, String str) {
        if (i >= a) {
            f59a.log(str);
        } else if (m9531a()) {
            Log.d("MyLog", "-->log(" + i + "): " + str);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= a) {
            f59a.log("", th);
        } else if (m9531a()) {
            Log.w("MyLog", "-->log(" + i + "): ", th);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= a) {
            f59a.log(str, th);
        } else if (m9531a()) {
            Log.w("MyLog", "-->log(" + i + "): " + str, th);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m9527a(String str) {
        return b() + str;
    }

    private static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    private static String a(String str, Object... objArr) {
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

    public static String a(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    private static String b() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        a = i;
    }

    public static int a() {
        return a;
    }

    public static void a(Context context) {
        f58a = context;
        if (j.m10105a(context)) {
            f64a = true;
        }
        if (j.m10104a()) {
            f65b = true;
        }
    }

    public static void e(String str) {
        if (f64a) {
            m9528a(str);
            return;
        }
        Log.w(f61a, m9527a(str));
        if (f65b) {
            return;
        }
        m9528a(str);
    }

    public static void d(String str, String str2) {
        if (f64a) {
            m9529a(str, str2);
            return;
        }
        Log.w(f61a, b(str, str2));
        if (f65b) {
            return;
        }
        m9529a(str, str2);
    }
}
