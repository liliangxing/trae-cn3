package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ai implements ah, InvocationHandler {
    private static final String[][] a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a, reason: collision with other field name */
    private Context f163a;

    /* renamed from: a, reason: collision with other field name */
    private Class f165a = null;
    private Class b = null;

    /* renamed from: a, reason: collision with other field name */
    private Method f167a = null;

    /* renamed from: b, reason: collision with other field name */
    private Method f168b = null;
    private Method c = null;
    private Method d = null;
    private Method e = null;
    private Method f = null;
    private Method g = null;

    /* renamed from: a, reason: collision with other field name */
    private final Object f166a = new Object();

    /* renamed from: a, reason: collision with other field name */
    private volatile int f161a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile long f162a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile a f164a = null;

    public ai(Context context) {
        this.f163a = context.getApplicationContext();
        a(context);
        b(context);
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public boolean mo9615a() {
        a("isSupported");
        return this.f164a != null && Boolean.TRUE.equals(this.f164a.f169a);
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public String mo9614a() {
        a("getOAID");
        if (this.f164a == null) {
            return null;
        }
        return this.f164a.b;
    }

    private void a(Context context) {
        Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = a;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> a3 = a(context, strArr2[0]);
            Class<?> a4 = a(context, strArr2[1]);
            if (a3 != null && a4 != null) {
                b("found class in index " + i);
                cls2 = a4;
                cls = a3;
                break;
            } else {
                i++;
                cls2 = a4;
                cls = a3;
            }
        }
        this.f165a = a2;
        this.f167a = a(a2, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.b = cls;
        this.c = a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f = a(cls2, "isSupported", (Class<?>[]) new Class[0]);
        this.g = a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    private void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        Class cls = this.b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f167a, this.f165a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.b}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
            }
            this.f162a = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.f162a = elapsedRealtime;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f162a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 != null && !a(obj2)) {
                    aVar.b = (String) a(this.c, obj2, new Object[0]);
                    aVar.f169a = (Boolean) a(this.f, obj2, new Object[0]);
                    a(this.g, obj2, new Object[0]);
                    if (aVar.a()) {
                        b("has get succ, check duplicate:" + (this.f164a != null));
                        synchronized (ai.class) {
                            if (this.f164a == null) {
                                this.f164a = aVar;
                            }
                        }
                    }
                }
                i++;
            }
        }
        a();
        return null;
    }

    private void a(String str) {
        if (this.f164a != null) {
            return;
        }
        long j = this.f162a;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
        int i = this.f161a;
        if (elapsedRealtime > 3000 && i < 3) {
            synchronized (this.f166a) {
                if (this.f162a == j && this.f161a == i) {
                    b("retry, current count is " + i);
                    this.f161a++;
                    b(this.f163a);
                    long j2 = this.f162a;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
                    j = j2;
                }
            }
        }
        if (this.f164a != null || j < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f166a) {
            if (this.f164a == null) {
                try {
                    b(str + " wait...");
                    this.f166a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    private void a() {
        synchronized (this.f166a) {
            try {
                this.f166a.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a, reason: collision with other field name */
        Boolean f169a;

        /* renamed from: a, reason: collision with other field name */
        String f170a;
        String b;
        String c;
        String d;

        private a() {
            this.f169a = null;
            this.f170a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        boolean a() {
            if (!TextUtils.isEmpty(this.f170a) || !TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.c) || !TextUtils.isEmpty(this.d)) {
                this.f169a = true;
            }
            return this.f169a != null;
        }
    }

    private static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private static Class<?> a(Context context, String str) {
        try {
            return q.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T t = (T) method.invoke(obj, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void b(String str) {
        com.xiaomi.channel.commonutils.logger.b.m9528a("mdid:" + str);
    }
}
