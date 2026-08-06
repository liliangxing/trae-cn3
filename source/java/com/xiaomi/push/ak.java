package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
class ak implements ah {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private Class<?> f171a;

    /* renamed from: a, reason: collision with other field name */
    private Object f172a;

    /* renamed from: a, reason: collision with other field name */
    private Method f173a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public ak(Context context) {
        this.a = context;
        a(context);
    }

    private void a(Context context) {
        try {
            Class<?> a = q.a(context, "com.android.id.impl.IdProviderImpl");
            this.f171a = a;
            this.f172a = a.newInstance();
            this.b = this.f171a.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public boolean mo9615a() {
        return (this.f171a == null || this.f172a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public String mo9614a() {
        return a(this.a, this.b);
    }

    private String a(Context context, Method method) {
        Object obj = this.f172a;
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
            com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e);
            return null;
        }
    }
}
