package com.apm.lite.runtime;

import com.apm.lite.C0749e;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0792o;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.apm.lite.runtime.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0821b {

    /* renamed from: a */
    private static long f691a = -30000;

    /* renamed from: b */
    private static File f692b;

    /* renamed from: a */
    public static String m1106a(long j, String str) {
        try {
            return C0786i.m803c(new File(C0792o.m875j(C0749e.m565g()), "apmlite/TrackInfo/" + ((j - (j % 86400000)) / 86400000) + "/" + str));
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    /* renamed from: a */
    public static void m1107a() {
        File file = new File(C0792o.m875j(C0749e.m565g()), "apmlite/TrackInfo/");
        String[] list = file.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            for (int i = 0; i < list.length - 5; i++) {
                C0786i.m796a(new File(file, list[i]));
            }
        }
    }

    /* renamed from: a */
    public static void m1108a(long j) {
        if (j - f691a < 30000) {
            return;
        }
        f691a = j;
        try {
            C0786i.m788a(m1109b(), String.valueOf(System.currentTimeMillis()), false);
        } catch (IOException unused) {
        }
    }

    /* renamed from: b */
    private static File m1109b() {
        if (f692b == null) {
            long currentTimeMillis = System.currentTimeMillis();
            f692b = new File(C0792o.m875j(C0749e.m565g()), "apmlite/TrackInfo/" + ((currentTimeMillis - (currentTimeMillis % 86400000)) / 86400000) + "/" + C0749e.m564f());
        }
        return f692b;
    }
}
