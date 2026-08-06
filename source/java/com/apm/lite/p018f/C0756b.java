package com.apm.lite.p018f;

import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.runtime.C0832m;
import com.apm.lite.runtime.C0834o;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.apm.lite.f.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0756b {

    /* renamed from: a */
    private static HashMap<String, String> f470a;

    /* renamed from: a */
    public static String m623a() {
        return C0749e.m565g().getFilesDir() + "/apmlite/selflib/";
    }

    /* renamed from: a */
    public static String m624a(String str) {
        return C0749e.m565g().getFilesDir() + "/apmlite/selflib/lib" + str + ".so";
    }

    /* renamed from: b */
    public static void m626b(final String str) {
        C0832m.m1190b().m1238a(new Runnable() { // from class: com.apm.lite.f.b.1

            /* renamed from: a */
            boolean f471a = false;

            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3;
                C0756b.m630d();
                if (C0756b.m632f(str)) {
                    return;
                }
                C0834o.m1195a("updateSo", str);
                File file = new File(C0756b.m624a(str));
                file.getParentFile().mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                C0794q.m888a("doUnpackLibrary: " + str);
                try {
                    str2 = C0757c.m633a(C0749e.m565g(), str, file);
                } catch (Throwable th) {
                    C0834o.m1195a("updateSoError", str);
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th);
                    str2 = null;
                }
                if (str2 == null) {
                    C0756b.f470a.put(file.getName(), "0.0.2");
                    try {
                        C0786i.m788a(new File(C0756b.m631e(str)), "0.0.2", false);
                    } catch (Throwable unused) {
                    }
                    str3 = "updateSoSuccess";
                } else {
                    if (!this.f471a) {
                        this.f471a = true;
                        C0834o.m1195a("updateSoPostRetry", str);
                        C0832m.m1190b().m1239a(this, 3000L);
                        return;
                    }
                    str3 = "updateSoFailed";
                }
                C0834o.m1195a(str3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m630d() {
        if (f470a != null) {
            return;
        }
        f470a = new HashMap<>();
        File file = new File(C0749e.m565g().getFilesDir(), "/apmlite/selflib/");
        String[] list = file.list();
        if (list == null) {
            return;
        }
        for (String str : list) {
            if (str.endsWith(".ver")) {
                try {
                    f470a.put(str.substring(0, str.length() - 4), C0786i.m804c(file.getAbsolutePath() + "/" + str));
                } catch (Throwable th) {
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th);
                }
            } else if (!str.endsWith(".so")) {
                C0786i.m796a(new File(file, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static String m631e(String str) {
        return C0749e.m565g().getFilesDir() + "/apmlite/selflib/" + str + ".ver";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static boolean m632f(String str) {
        return "0.0.2".equals(f470a.get(str)) && new File(m624a(str)).exists();
    }
}
