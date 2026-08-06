package com.bytedance.tobshadow.bdtracker;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.util.SensitiveUtils;

/* renamed from: com.bytedance.tobshadow.bdtracker.o4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbstractC0486o4 {

    /* renamed from: a */
    public AbstractC0486o4 f895a;

    /* renamed from: b */
    public Handler f896b;

    /* renamed from: com.bytedance.tobshadow.bdtracker.o4$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements g<String> {
        public a() {
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo601a() {
            return AbstractC0486o4.this.mo532b("openudid");
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: b */
        public boolean mo605b(String str) {
            return C0411e.m381e(str);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public boolean mo604a(String str, String str2) {
            return C0411e.m362a(str, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo602a(String str, String str2, AbstractC0486o4 abstractC0486o4) {
            String str3 = str;
            return abstractC0486o4 == null ? str3 : abstractC0486o4.m597d(str3, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public void mo603a(String str) {
            AbstractC0486o4.this.mo531a("openudid", str);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.o4$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class b implements g<String> {
        public b() {
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo601a() {
            return AbstractC0486o4.this.mo532b("clientudid");
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: b */
        public boolean mo605b(String str) {
            return C0411e.m381e(str);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public boolean mo604a(String str, String str2) {
            return C0411e.m362a(str, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo602a(String str, String str2, AbstractC0486o4 abstractC0486o4) {
            String str3 = str;
            return abstractC0486o4 == null ? str3 : abstractC0486o4.m595b(str3, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public void mo603a(String str) {
            AbstractC0486o4.this.mo531a("clientudid", str);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.o4$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class c implements g<String> {
        public c() {
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo601a() {
            return AbstractC0486o4.this.mo532b("serial_number");
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: b */
        public boolean mo605b(String str) {
            String str2 = str;
            return (TextUtils.isEmpty(str2) || TextUtils.equals(str2, "unknown")) ? false : true;
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public boolean mo604a(String str, String str2) {
            return C0411e.m362a(str, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo602a(String str, String str2, AbstractC0486o4 abstractC0486o4) {
            String str3 = str;
            return abstractC0486o4 == null ? str3 : abstractC0486o4.m598e(str3, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public void mo603a(String str) {
            AbstractC0486o4.this.mo531a("serial_number", str);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.o4$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class d implements g<String> {
        public d() {
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo601a() {
            return AbstractC0486o4.this.mo532b("udid");
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: b */
        public boolean mo605b(String str) {
            return C0411e.m381e(str);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public boolean mo604a(String str, String str2) {
            return C0411e.m362a(str, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo602a(String str, String str2, AbstractC0486o4 abstractC0486o4) {
            String str3 = str;
            return abstractC0486o4 == null ? str3 : abstractC0486o4.m599f(str3, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public void mo603a(String str) {
            AbstractC0486o4.this.mo531a("udid", str);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.o4$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class e implements g<String> {
        public e() {
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo601a() {
            return AbstractC0486o4.this.mo532b("udid_list");
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: b */
        public boolean mo605b(String str) {
            return SensitiveUtils.validMultiImei(str);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public boolean mo604a(String str, String str2) {
            return C0411e.m362a(str, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo602a(String str, String str2, AbstractC0486o4 abstractC0486o4) {
            String str3 = str;
            return abstractC0486o4 == null ? str3 : abstractC0486o4.m600g(str3, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public void mo603a(String str) {
            AbstractC0486o4.this.mo531a("udid_list", str);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.o4$f */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class f implements g<String> {
        public f() {
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo601a() {
            return AbstractC0486o4.this.mo532b("device_id");
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: b */
        public boolean mo605b(String str) {
            return !TextUtils.isEmpty(str);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public boolean mo604a(String str, String str2) {
            return C0411e.m362a(str, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public String mo602a(String str, String str2, AbstractC0486o4 abstractC0486o4) {
            String str3 = str;
            return abstractC0486o4 == null ? str3 : abstractC0486o4.m596c(str3, str2);
        }

        @Override // com.bytedance.tobshadow.bdtracker.AbstractC0486o4.g
        /* renamed from: a */
        public void mo603a(String str) {
            AbstractC0486o4.this.mo531a("device_id", str);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.o4$g */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface g<L> {
        /* renamed from: a */
        L mo601a();

        /* renamed from: a */
        L mo602a(L l, L l2, AbstractC0486o4 abstractC0486o4);

        /* renamed from: a */
        void mo603a(L l);

        /* renamed from: a */
        boolean mo604a(L l, L l2);

        /* renamed from: b */
        boolean mo605b(L l);
    }

    /* renamed from: a */
    public void mo530a(String str) {
        AbstractC0486o4 abstractC0486o4 = this.f895a;
        if (abstractC0486o4 != null) {
            abstractC0486o4.mo530a(str);
        }
    }

    /* renamed from: a */
    public abstract void mo531a(String str, String str2);

    /* renamed from: b */
    public abstract String mo532b(String str);

    /* renamed from: b */
    public String m595b(String str, String str2) {
        return (String) m593a(str, str2, new b());
    }

    /* renamed from: c */
    public String m596c(String str, String str2) {
        return (String) m593a(str, str2, new f());
    }

    /* renamed from: d */
    public String m597d(String str, String str2) {
        return (String) m593a(str, str2, new a());
    }

    /* renamed from: e */
    public String m598e(String str, String str2) {
        return (String) m593a(str, str2, new c());
    }

    /* renamed from: f */
    public String m599f(String str, String str2) {
        return (String) m593a(str, str2, new d());
    }

    /* renamed from: g */
    public String m600g(String str, String str2) {
        return (String) m593a(str, str2, new e());
    }

    /* renamed from: a */
    public final <T> T m593a(T t, T t2, g<T> gVar) {
        boolean z;
        if (gVar == null) {
            throw new IllegalArgumentException("agent == null");
        }
        AbstractC0486o4 abstractC0486o4 = this.f895a;
        T mo601a = gVar.mo601a();
        boolean mo605b = gVar.mo605b(t);
        boolean mo605b2 = gVar.mo605b(mo601a);
        if (!mo605b && mo605b2) {
            t = mo601a;
        }
        if (abstractC0486o4 != null) {
            T mo602a = gVar.mo602a(t, t2, abstractC0486o4);
            if (!gVar.mo604a(mo602a, mo601a)) {
                gVar.mo603a(mo602a);
            }
            return mo602a;
        }
        if (mo605b || mo605b2) {
            t2 = t;
            z = false;
        } else {
            z = true;
        }
        if ((z && gVar.mo605b(t2)) || (mo605b && !gVar.mo604a(t2, mo601a))) {
            gVar.mo603a(t2);
        }
        return t2;
    }

    /* renamed from: a */
    public void m594a(Handler handler) {
        AbstractC0486o4 abstractC0486o4 = this.f895a;
        if (abstractC0486o4 != null) {
            abstractC0486o4.m594a(handler);
        }
        this.f896b = handler;
    }
}
