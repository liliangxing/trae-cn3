package com.apm.lite.p022j;

import com.apm.lite.C0749e;
import com.apm.lite.p016d.C0746b;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0793p;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.runtime.C0810a;
import com.apm.lite.runtime.C0832m;
import com.apm.lite.runtime.C0837r;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.apm.lite.j.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0766a {

    /* renamed from: a */
    private static Runnable f495a = new Runnable() { // from class: com.apm.lite.j.a.1
        @Override // java.lang.Runnable
        public void run() {
            C0837r m1190b;
            Runnable runnable;
            long j;
            C0832m.m1190b().m1241b(C0766a.f495a);
            if (C0793p.m885b(C0749e.m565g())) {
                C0766a.m654g();
            }
            if (C0766a.f496b > 0) {
                if (C0778a.m746b(C0749e.m565g())) {
                    m1190b = C0832m.m1190b();
                    runnable = C0766a.f495a;
                    j = 15000;
                } else {
                    m1190b = C0832m.m1190b();
                    runnable = C0766a.f495a;
                    j = 60000;
                }
                m1190b.m1239a(runnable, j);
            }
        }
    };

    /* renamed from: b */
    private static int f496b = 0;

    /* renamed from: a */
    public static void m648a() {
        f496b = 40;
        C0832m.m1190b().m1238a(f495a);
    }

    /* renamed from: b */
    public static void m649b() {
        if (!C0775j.m726b()) {
            C0775j.m727c();
        }
        if (C0793p.m885b(C0749e.m565g()) && C0775j.m725a(false)) {
            m654g();
        }
    }

    /* renamed from: f */
    private static byte[] m653f() {
        try {
            return C0770e.m699a(C0749e.m567i().getConfigUrl(), (Map<String, String>) null, C0746b.m502a().toString().getBytes());
        } catch (Throwable th) {
            C0794q.m892a(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        if (com.apm.lite.p022j.C0775j.m724a() != false) goto L20;
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void m654g() {
        synchronized (C0766a.class) {
            int i = f496b;
            if (i > 0) {
                f496b = i - 1;
            }
            C0794q.m887a((Object) "try fetchApmConfig");
            if (C0778a.m746b(C0749e.m565g())) {
                JSONArray jSONArray = null;
                try {
                    byte[] m653f = m653f();
                    if (m653f != null) {
                        jSONArray = new JSONObject(new String(m653f)).optJSONArray(Constants.KEY_DATA);
                    }
                } catch (Throwable th) {
                    C0794q.m891a("npth", th);
                }
                C0794q.m887a((Object) ("after fetchApmConfig net " + jSONArray));
                if (jSONArray != null) {
                    C0810a.m1019a(jSONArray, true);
                    f496b = 0;
                } else {
                    f496b -= 10;
                }
            } else {
                C0775j.m727c();
            }
        }
    }
}
