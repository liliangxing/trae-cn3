package com.apm.lite.runtime;

import com.apm.lite.C0749e;
import com.apm.lite.p016d.C0747c;

/* renamed from: com.apm.lite.runtime.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0825f {

    /* renamed from: b */
    private static final C0825f f708b = new C0825f() { // from class: com.apm.lite.runtime.f.1

        /* renamed from: a */
        C0747c f710a = null;

        @Override // com.apm.lite.runtime.C0825f
        /* renamed from: b */
        public Object mo1141b(String str) {
            if (this.f710a == null) {
                this.f710a = C0747c.m517b(C0749e.m565g());
            }
            return this.f710a.m537g().opt(str);
        }
    };

    /* renamed from: a */
    private C0825f f709a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0825f() {
        this(f708b);
    }

    C0825f(C0825f c0825f) {
        this.f709a = c0825f;
    }

    /* renamed from: a */
    public Object mo1013a(String str) {
        C0825f c0825f = this.f709a;
        if (c0825f != null) {
            return c0825f.mo1013a(str);
        }
        return null;
    }

    /* renamed from: b */
    public Object mo1141b(String str) {
        C0825f c0825f = this.f709a;
        if (c0825f != null) {
            return c0825f.mo1141b(str);
        }
        return null;
    }
}
