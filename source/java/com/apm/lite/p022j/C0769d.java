package com.apm.lite.p022j;

import android.content.Context;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.Npth;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.runtime.C0810a;
import com.apm.lite.runtime.C0826g;
import com.apm.lite.runtime.C0834o;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.apm.lite.j.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0769d {

    /* renamed from: a */
    private static volatile C0769d f531a;

    /* renamed from: b */
    private volatile Context f532b;

    private C0769d(Context context) {
        this.f532b = context;
    }

    /* renamed from: a */
    public static C0769d m685a() {
        if (f531a == null) {
            f531a = new C0769d(C0749e.m565g());
        }
        return f531a;
    }

    /* renamed from: a */
    public void m686a(JSONObject jSONObject, long j, boolean z) {
        File[] fileArr;
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String m707c = C0770e.m707c();
                int i = 0;
                File file = new File(C0792o.m846a(this.f532b), C0749e.m554a(j, CrashType.ANR, false, false));
                C0786i.m784a(file, file.getName(), m707c, jSONObject, C0770e.m704b());
                if (z && !Npth.isStopUpload()) {
                    jSONObject.put("upload_scene", "direct");
                    jSONObject.put("crash_uuid", file.getName());
                    if (C0810a.m1030i()) {
                        HashMap<String, C0834o.a> m1193a = C0834o.m1193a(j, "anr_trace");
                        fileArr = new File[m1193a.size() + 2];
                        for (Map.Entry<String, C0834o.a> entry : m1193a.entrySet()) {
                            if (!entry.getKey().equals(C0778a.m748c(this.f532b))) {
                                fileArr[i] = C0792o.m847a(this.f532b, entry.getValue().f729b);
                                i++;
                            }
                        }
                    } else {
                        fileArr = new File[2];
                    }
                    fileArr[fileArr.length - 1] = C0792o.m847a(this.f532b, C0749e.m564f());
                    fileArr[fileArr.length - 2] = C0834o.m1192a(j);
                    if (!C0770e.m692a(m707c, jSONObject.toString(), fileArr).m732a()) {
                        return;
                    }
                    C0786i.m796a(file);
                    if (!Npth.hasCrash()) {
                        C0786i.m796a(C0792o.m862e(C0749e.m565g()));
                    }
                    C0826g.m1142a(C0792o.m876k(C0749e.m565g()), CrashType.ANR, file.getName());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public boolean m687a(JSONObject jSONObject, File file, File file2) {
        try {
            return C0770e.m692a(C0770e.m710f(), jSONObject.toString(), file, file2, C0834o.m1192a(System.currentTimeMillis())).m732a();
        } catch (Throwable th) {
            C0794q.m893b(th);
            return false;
        }
    }
}
