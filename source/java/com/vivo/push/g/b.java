package com.vivo.push.g;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* compiled from: PushSecurityManager.java */
/* loaded from: classes7.dex */
public final class b {
    private static volatile b c;
    private a a;
    private Context b;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    private b() {
    }

    public final synchronized a a(Context context) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar;
        }
        if (context == null) {
            return null;
        }
        if (aVar == null) {
            this.b = ContextDelegate.getContext(context.getApplicationContext());
            this.a = new c(this.b);
        }
        return this.a;
    }
}
