package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.lang.reflect.Method;

/* renamed from: com.xiaomi.push.ak */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class C1477ak implements InterfaceC1474ah {

    /* renamed from: a */
    private Context f974a;

    /* renamed from: a */
    private Class<?> f975a;

    /* renamed from: a */
    private Object f976a;

    /* renamed from: a */
    private Method f977a = null;

    /* renamed from: b */
    private Method f978b = null;

    /* renamed from: c */
    private Method f979c = null;

    /* renamed from: d */
    private Method f980d = null;

    public C1477ak(Context context) {
        this.f974a = context;
        m1499a(context);
    }

    /* renamed from: a */
    private void m1499a(Context context) {
        try {
            Class<?> m3463a = C1702q.m3463a(context, "com.android.id.impl.IdProviderImpl");
            this.f975a = m3463a;
            this.f976a = m3463a.newInstance();
            this.f978b = this.f975a.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            AbstractC1417b.m1091a("miui load class error", e);
        }
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public boolean mo1483a() {
        return (this.f975a == null || this.f976a == null) ? false : true;
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public String mo1482a() {
        return m1498a(this.f974a, this.f978b);
    }

    /* renamed from: a */
    private String m1498a(Context context, Method method) {
        Object obj = this.f976a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            AbstractC1417b.m1091a("miui invoke error", e);
            return null;
        }
    }
}
