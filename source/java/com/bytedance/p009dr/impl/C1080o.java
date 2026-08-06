package com.bytedance.p009dr.impl;

import android.content.Context;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.a;
import java.lang.reflect.Method;

/* renamed from: com.bytedance.dr.impl.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1080o implements OaidApi {

    /* renamed from: a */
    public static Object f188a;

    /* renamed from: b */
    public static Class<?> f189b;

    /* renamed from: c */
    public static Method f190c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f189b = cls;
            f188a = cls.newInstance();
            f190c = f189b.getMethod("getOAID", Context.class);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "Oaid#Api#static reflect exception! ", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public static boolean m287a() {
        LoggerImpl.global().debug(a.a("Oaid#XiaomiOppoImpl isSupport -> ").append((f189b == null || f188a == null || f190c == null) ? false : true).toString(), new Object[0]);
        return (f189b == null || f188a == null || f190c == null) ? false : true;
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "Xiaomi";
    }

    @Override // com.bytedance.p009dr.OaidApi
    public OaidApi.C1053a getOaid(Context context) {
        String str;
        Object invoke;
        try {
            OaidApi.C1053a c1053a = new OaidApi.C1053a();
            Method method = f190c;
            Object obj = f188a;
            if (obj != null && method != null) {
                try {
                    invoke = method.invoke(obj, context);
                } catch (Throwable unused) {
                }
                if (invoke != null) {
                    str = (String) invoke;
                    c1053a.f153a = str;
                    return c1053a;
                }
            }
            str = null;
            c1053a.f153a = str;
            return c1053a;
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "Oaid#invokeMethod get oaid failed", th, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.p009dr.OaidApi
    public boolean support(Context context) {
        return m287a();
    }
}
