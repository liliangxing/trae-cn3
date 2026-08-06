package com.apm.lite.runtime.p024a;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.apm.lite.AttachUserData;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.ICommonParams;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0785h;
import com.apm.lite.p023k.C0799v;
import com.apm.lite.p023k.C0800w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.apm.lite.runtime.a.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AbstractC0813c {

    /* renamed from: a */
    protected CrashType f680a;

    /* renamed from: b */
    protected Context f681b;

    /* renamed from: c */
    protected ICommonParams f682c = C0749e.m553a().m1123c();

    /* renamed from: d */
    protected C0812b f683d;

    /* renamed from: e */
    protected C0814d f684e;

    /* renamed from: com.apm.lite.runtime.a.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface a {
        /* renamed from: a */
        C0745a mo612a(int i, C0745a c0745a);

        /* renamed from: a */
        C0745a mo613a(int i, C0745a c0745a, boolean z);

        /* renamed from: a */
        void mo614a(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0813c(CrashType crashType, Context context, C0812b c0812b, C0814d c0814d) {
        this.f680a = crashType;
        this.f681b = context;
        this.f683d = c0812b;
        this.f684e = c0814d;
    }

    /* renamed from: i */
    private void m1088i(C0745a c0745a) {
        List<AttachUserData> m374a = C0749e.m558b().m374a(this.f680a);
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = c0745a.m498h().optJSONObject("custom");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            c0745a.m484a("custom", optJSONObject);
        }
        if (m374a != null) {
            for (int i = 0; i < m374a.size(); i++) {
                try {
                    AttachUserData attachUserData = m374a.get(i);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    C0745a.m468a(optJSONObject, attachUserData.getUserData(this.f680a));
                    hashMap.put("custom_cost_" + attachUserData.getClass().getName() + "_" + hashMap.size(), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                } catch (Throwable th) {
                    C0745a.m467a(optJSONObject, th);
                }
            }
        }
        try {
            optJSONObject.put("fd_count", C0785h.m778a());
        } catch (Throwable unused) {
        }
        List<AttachUserData> m377b = C0749e.m558b().m377b(this.f680a);
        if (m377b != null) {
            JSONObject optJSONObject2 = c0745a.m498h().optJSONObject("custom_long");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                c0745a.m484a("custom_long", optJSONObject2);
            }
            for (int i2 = 0; i2 < m377b.size(); i2++) {
                try {
                    AttachUserData attachUserData2 = m377b.get(i2);
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    C0745a.m468a(optJSONObject2, attachUserData2.getUserData(this.f680a));
                    hashMap.put("custom_cost_" + attachUserData2.getClass().getName() + "_" + hashMap.size(), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis2));
                } catch (Throwable th2) {
                    C0745a.m467a(optJSONObject2, th2);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                optJSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Throwable unused2) {
            }
        }
    }

    /* renamed from: a */
    public C0745a mo1089a(int i, C0745a c0745a) {
        if (c0745a == null) {
            c0745a = new C0745a();
        }
        if (i == 0) {
            m1092b(c0745a);
        } else if (i == 1) {
            m1093c(c0745a);
            m1088i(c0745a);
        } else if (i == 2) {
            m1097e(c0745a);
        } else if (i == 4) {
            m1098f(c0745a);
        } else if (i == 5) {
            m1095d(c0745a);
        }
        return c0745a;
    }

    /* renamed from: a */
    public C0745a mo1031a(C0745a c0745a) {
        return c0745a;
    }

    /* renamed from: a */
    public C0745a m1090a(C0745a c0745a, a aVar, boolean z) {
        if (c0745a == null) {
            c0745a = new C0745a();
        }
        C0745a c0745a2 = c0745a;
        for (int i = 0; i < mo1091b(); i++) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (aVar != null) {
                try {
                    c0745a2 = aVar.mo612a(i, c0745a2);
                } catch (Throwable th) {
                    aVar.mo614a(th);
                }
            }
            try {
                c0745a2 = mo1089a(i, c0745a2);
            } catch (Throwable th2) {
                if (aVar != null) {
                    aVar.mo614a(th2);
                }
            }
            if (aVar != null) {
                try {
                    boolean z2 = true;
                    if (i != mo1091b() - 1) {
                        z2 = false;
                    }
                    c0745a2 = aVar.mo613a(i, c0745a2, z2);
                } catch (Throwable th3) {
                    aVar.mo614a(th3);
                }
                if (z) {
                    if (i != 0) {
                        c0745a.m492c(c0745a2.m498h());
                    } else {
                        c0745a = c0745a2;
                    }
                    c0745a2 = new C0745a();
                }
            }
            c0745a.m486b("step_cost_" + i, String.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
        }
        return mo1031a(c0745a);
    }

    /* renamed from: a */
    protected boolean mo1032a() {
        return false;
    }

    /* renamed from: b */
    public int mo1091b() {
        return 6;
    }

    /* renamed from: b */
    public C0745a m1092b(C0745a c0745a) {
        c0745a.m475a(C0749e.m574p(), C0749e.m575q());
        if (C0749e.m571m()) {
            c0745a.m484a("is_mp", (Object) 1);
        }
        try {
            c0745a.m482a(this.f682c.getPluginInfo());
        } catch (Throwable th) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("Fetch info failed:\n" + C0799v.m917a(th), 0);
                c0745a.m482a(hashMap);
            } catch (Throwable unused) {
            }
        }
        c0745a.m487b(C0749e.m573o());
        c0745a.m484a("process_name", C0778a.m748c(C0749e.m565g()));
        return c0745a;
    }

    /* renamed from: c */
    public C0745a m1093c(C0745a c0745a) {
        C0812b c0812b;
        if (!C0778a.m746b(C0749e.m565g())) {
            c0745a.m484a("remote_process", (Object) 1);
        }
        c0745a.m484a("pid", Integer.valueOf(Process.myPid()));
        c0745a.m476a(C0749e.m568j());
        if (m1094c() && (c0812b = this.f683d) != null) {
            c0745a.m478a(c0812b);
        }
        try {
            c0745a.m481a(this.f682c.getPatchInfo());
        } catch (Throwable th) {
            try {
                c0745a.m481a(Arrays.asList("Fetch info failed:\n" + C0799v.m917a(th)));
            } catch (Throwable unused) {
            }
        }
        String m569k = C0749e.m569k();
        if (m569k != null) {
            c0745a.m484a("business", (Object) m569k);
        }
        c0745a.m484a("is_background", Boolean.valueOf(!C0778a.m743a(this.f681b)));
        return c0745a;
    }

    /* renamed from: c */
    protected boolean m1094c() {
        return true;
    }

    /* renamed from: d */
    public C0745a m1095d(C0745a c0745a) {
        if (mo1096d()) {
            c0745a.m488b(C0800w.m942a(this.f681b));
        }
        return c0745a;
    }

    /* renamed from: d */
    protected boolean mo1096d() {
        return true;
    }

    /* renamed from: e */
    public C0745a m1097e(C0745a c0745a) {
        C0814d c0814d = this.f684e;
        c0745a.m484a("battery", Integer.valueOf(c0814d == null ? 0 : c0814d.m1101a()));
        c0745a.m490c(C0749e.m558b().m375a());
        return c0745a;
    }

    /* renamed from: f */
    public C0745a m1098f(C0745a c0745a) {
        if (mo1032a()) {
            mo1100h(c0745a);
        }
        return c0745a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m1099g(C0745a c0745a) {
    }

    /* renamed from: h */
    protected void mo1100h(C0745a c0745a) {
    }
}
