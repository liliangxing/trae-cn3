package com.apm.lite.p022j;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.apm.lite.C0749e;
import com.apm.lite.MonitorCrash;
import com.apm.lite.p016d.C0746b;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.runtime.C0810a;
import com.apm.lite.runtime.C0824e;
import com.apm.lite.runtime.C0832m;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: com.apm.lite.j.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0775j {

    /* renamed from: a */
    private static File f560a;

    /* renamed from: b */
    private static volatile boolean f561b;

    /* renamed from: c */
    private static volatile boolean f562c;

    /* renamed from: d */
    private static Map<String, String> f563d;

    /* renamed from: a */
    public static void m722a(String str) {
        if (f563d == null) {
            f563d = new HashMap();
        }
        f563d.put(str, String.valueOf(System.currentTimeMillis()));
        MonitorCrash.reInitAppLog(str);
    }

    /* renamed from: a */
    public static void m723a(boolean z, JSONArray jSONArray) {
        try {
            C0786i.m790a(new File(C0792o.m875j(C0749e.m565g()), "apmlite/configCrash/configFile"), jSONArray, false);
        } catch (IOException unused) {
        }
        try {
            C0786i.m789a(m731g(), f563d);
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m724a() {
        return f561b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m725a(boolean z) {
        File m731g = m731g();
        try {
            Map<String, String> map = f563d;
            if (map == null) {
                map = C0786i.m809e(m731g);
            }
            f563d = map;
            if (map == null) {
                f563d = new HashMap();
                return true;
            }
            if (map.size() < C0746b.m510c()) {
                return true;
            }
            Iterator<String> it = C0746b.m511d().iterator();
            while (it.hasNext()) {
                if (!f563d.containsKey(it.next())) {
                    return true;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = false;
            for (Map.Entry<String, String> entry : f563d.entrySet()) {
                try {
                    long longValue = Long.decode(entry.getValue()).longValue();
                    if (C0824e.m1129a(entry.getKey())) {
                        if (currentTimeMillis - longValue > C0824e.m1131c(entry.getKey())) {
                            z2 = true;
                        }
                    }
                } catch (Throwable th) {
                    C0794q.m892a(th);
                }
            }
            C0794q.m887a((Object) (z2 ? "config should be updated" : "config should not be updated"));
            return z2;
        } catch (Throwable th2) {
            Log.e("npth", NotificationCompat.CATEGORY_ERROR, th2);
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m726b() {
        return f562c;
    }

    /* renamed from: c */
    public static void m727c() {
        if (f561b) {
            return;
        }
        f562c = true;
        File file = new File(C0792o.m875j(C0749e.m565g()), "apmlite/configCrash/configFile");
        if (file.exists()) {
            try {
                C0810a.m1019a(new JSONArray(C0786i.m803c(file)), false);
                f561b = true;
            } catch (Throwable unused) {
                C0810a.m1019a((JSONArray) null, false);
            }
        }
    }

    /* renamed from: d */
    public static void m728d() {
        m727c();
        if (m725a(false)) {
            C0766a.m648a();
        }
    }

    /* renamed from: e */
    public static void m729e() {
        C0832m.m1190b().m1238a(new Runnable() { // from class: com.apm.lite.j.j.1
            @Override // java.lang.Runnable
            public void run() {
                C0775j.m727c();
                if (C0775j.m725a(false)) {
                    C0766a.m648a();
                }
            }
        });
    }

    /* renamed from: f */
    public static void m730f() {
        Map<String, String> map = f563d;
        if (map != null) {
            map.clear();
        }
    }

    /* renamed from: g */
    private static File m731g() {
        if (f560a == null) {
            f560a = new File(C0792o.m875j(C0749e.m565g()), "apmlite/configCrash/configInvalid");
        }
        return f560a;
    }
}
