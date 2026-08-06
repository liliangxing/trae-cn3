package com.vivo.push.p016g;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* compiled from: PushSecurityManager.java */
/* renamed from: com.vivo.push.g.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1261b {

    /* renamed from: c */
    private static volatile C1261b f444c;

    /* renamed from: a */
    private InterfaceC1260a f445a;

    /* renamed from: b */
    private Context f446b;

    /* renamed from: a */
    public static synchronized C1261b m693a() {
        C1261b c1261b;
        synchronized (C1261b.class) {
            if (f444c == null) {
                f444c = new C1261b();
            }
            c1261b = f444c;
        }
        return c1261b;
    }

    private C1261b() {
    }

    /* renamed from: a */
    public final synchronized InterfaceC1260a m694a(Context context) {
        InterfaceC1260a interfaceC1260a = this.f445a;
        if (interfaceC1260a != null) {
            return interfaceC1260a;
        }
        if (context == null) {
            return null;
        }
        if (interfaceC1260a == null) {
            this.f446b = ContextDelegate.getContext(context.getApplicationContext());
            this.f445a = new C1262c(this.f446b);
        }
        return this.f445a;
    }
}
