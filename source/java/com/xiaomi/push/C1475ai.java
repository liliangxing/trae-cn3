package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.ai */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1475ai implements InterfaceC1474ah, InvocationHandler {

    /* renamed from: a */
    private static final String[][] f952a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a */
    private Context f955a;

    /* renamed from: a */
    private Class f957a = null;

    /* renamed from: b */
    private Class f960b = null;

    /* renamed from: a */
    private Method f959a = null;

    /* renamed from: b */
    private Method f961b = null;

    /* renamed from: c */
    private Method f962c = null;

    /* renamed from: d */
    private Method f963d = null;

    /* renamed from: e */
    private Method f964e = null;

    /* renamed from: f */
    private Method f965f = null;

    /* renamed from: g */
    private Method f966g = null;

    /* renamed from: a */
    private final Object f958a = new Object();

    /* renamed from: a */
    private volatile int f953a = 0;

    /* renamed from: a */
    private volatile long f954a = 0;

    /* renamed from: a */
    private volatile a f956a = null;

    public C1475ai(Context context) {
        this.f955a = context.getApplicationContext();
        m1490a(context);
        m1493b(context);
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public boolean mo1483a() {
        m1491a("isSupported");
        return this.f956a != null && Boolean.TRUE.equals(this.f956a.f968a);
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public String mo1482a() {
        m1491a("getOAID");
        if (this.f956a == null) {
            return null;
        }
        return this.f956a.f970b;
    }

    /* renamed from: a */
    private void m1490a(Context context) {
        Class<?> m1486a = m1486a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = f952a;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> m1486a2 = m1486a(context, strArr2[0]);
            Class<?> m1486a3 = m1486a(context, strArr2[1]);
            if (m1486a2 != null && m1486a3 != null) {
                m1494b("found class in index " + i);
                cls2 = m1486a3;
                cls = m1486a2;
                break;
            } else {
                i++;
                cls2 = m1486a3;
                cls = m1486a2;
            }
        }
        this.f957a = m1486a;
        this.f959a = m1488a(m1486a, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.f960b = cls;
        this.f962c = m1488a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f965f = m1488a(cls2, "isSupported", (Class<?>[]) new Class[0]);
        this.f966g = m1488a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    /* renamed from: b */
    private void m1493b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        Class cls = this.f960b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                m1487a(this.f959a, this.f957a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f960b}, this));
            } catch (Throwable th) {
                m1494b("call init sdk error:" + th);
            }
            this.f954a = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.f954a = elapsedRealtime;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f954a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 != null && !m1492a(obj2)) {
                    aVar.f970b = (String) m1487a(this.f962c, obj2, new Object[0]);
                    aVar.f968a = (Boolean) m1487a(this.f965f, obj2, new Object[0]);
                    m1487a(this.f966g, obj2, new Object[0]);
                    if (aVar.m1495a()) {
                        m1494b("has get succ, check duplicate:" + (this.f956a != null));
                        synchronized (C1475ai.class) {
                            if (this.f956a == null) {
                                this.f956a = aVar;
                            }
                        }
                    }
                }
                i++;
            }
        }
        m1489a();
        return null;
    }

    /* renamed from: a */
    private void m1491a(String str) {
        if (this.f956a != null) {
            return;
        }
        long j = this.f954a;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
        int i = this.f953a;
        if (elapsedRealtime > 3000 && i < 3) {
            synchronized (this.f958a) {
                if (this.f954a == j && this.f953a == i) {
                    m1494b("retry, current count is " + i);
                    this.f953a++;
                    m1493b(this.f955a);
                    long j2 = this.f954a;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
                    j = j2;
                }
            }
        }
        if (this.f956a != null || j < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f958a) {
            if (this.f956a == null) {
                try {
                    m1494b(str + " wait...");
                    this.f958a.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: a */
    private void m1489a() {
        synchronized (this.f958a) {
            try {
                this.f958a.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.ai$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class a {

        /* renamed from: a */
        Boolean f968a;

        /* renamed from: a */
        String f969a;

        /* renamed from: b */
        String f970b;

        /* renamed from: c */
        String f971c;

        /* renamed from: d */
        String f972d;

        private a() {
            this.f968a = null;
            this.f969a = null;
            this.f970b = null;
            this.f971c = null;
            this.f972d = null;
        }

        /* renamed from: a */
        boolean m1495a() {
            if (!TextUtils.isEmpty(this.f969a) || !TextUtils.isEmpty(this.f970b) || !TextUtils.isEmpty(this.f971c) || !TextUtils.isEmpty(this.f972d)) {
                this.f968a = true;
            }
            return this.f968a != null;
        }
    }

    /* renamed from: a */
    private static boolean m1492a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    /* renamed from: a */
    private static Class<?> m1486a(Context context, String str) {
        try {
            return C1702q.m3463a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static Method m1488a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static <T> T m1487a(Method method, Object obj, Object... objArr) {
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

    /* renamed from: b */
    private static void m1494b(String str) {
        AbstractC1417b.m1089a("mdid:" + str);
    }
}
