package com.apm.lite.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.lite.C0749e;

/* renamed from: com.apm.lite.runtime.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0836q {

    /* renamed from: a */
    private String f743a = null;

    /* renamed from: b */
    private String f744b = null;

    /* renamed from: c */
    private int f745c = -1;

    public C0836q(Context context) {
    }

    /* renamed from: a */
    public String m1226a() {
        if (!TextUtils.isEmpty(this.f743a) && !"0".equals(this.f743a)) {
            return this.f743a;
        }
        if (!TextUtils.isEmpty(this.f744b) && !"0".equals(this.f744b)) {
            return this.f744b;
        }
        String m1124d = C0749e.m553a().m1124d();
        this.f743a = m1124d;
        if (!TextUtils.isEmpty(m1124d) && !"0".equals(this.f743a)) {
            return this.f743a;
        }
        String m1210b = C0835p.m1198a().m1210b();
        this.f744b = m1210b;
        return m1210b;
    }

    /* renamed from: a */
    public void m1227a(String str) {
        this.f743a = str;
        C0835p.m1198a().m1212b(str);
    }

    /* renamed from: b */
    public boolean m1228b() {
        return this.f743a != null;
    }
}
