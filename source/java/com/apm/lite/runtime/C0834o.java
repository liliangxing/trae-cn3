package com.apm.lite.runtime;

import android.text.TextUtils;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0792o;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;

/* renamed from: com.apm.lite.runtime.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0834o {

    /* renamed from: a */
    private static File f727a;

    /* renamed from: com.apm.lite.runtime.o$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a {

        /* renamed from: a */
        public String f728a;

        /* renamed from: b */
        public String f729b;

        /* renamed from: c */
        public long f730c;

        a(String str) {
            String[] split = str.split("\\s+");
            if (split.length != 3) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", new RuntimeException("err ProcessTrack line:" + str));
                return;
            }
            this.f728a = split[0];
            this.f729b = split[1];
            try {
                this.f730c = Long.parseLong(split[2]);
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", new RuntimeException("err ProcessTrack line:" + str, th));
            }
        }
    }

    /* renamed from: a */
    public static File m1192a(long j) {
        return new File(C0792o.m875j(C0749e.m565g()), "apmlite/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
    }

    /* renamed from: a */
    public static HashMap<String, a> m1193a(long j, String str) {
        File file = new File(C0792o.m875j(C0749e.m565g()), "apmlite/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
        String[] list = file.list();
        HashMap<String, a> hashMap = new HashMap<>();
        if (list != null) {
            for (String str2 : list) {
                File file2 = new File(file, str2);
                long length = file2.length();
                try {
                    JSONArray m786a = C0786i.m786a(file2, length > 1048576 ? length - 524288 : 0L);
                    int length2 = m786a.length() - 1;
                    while (true) {
                        if (length2 >= 0) {
                            String optString = m786a.optString(length2);
                            if (!TextUtils.isEmpty(optString) && optString.startsWith(str)) {
                                hashMap.put(str2.replace('_', ':').replace(".txt", ""), new a(optString));
                                break;
                            }
                            length2--;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static void m1194a() {
        File file;
        String[] list;
        if (C0778a.m746b(C0749e.m565g()) && (list = (file = new File(C0792o.m875j(C0749e.m565g()), "apmlite/ProcessTrack/")).list()) != null && list.length > 25) {
            Arrays.sort(list);
            for (int i = 0; i < list.length - 25; i++) {
                C0786i.m796a(new File(file, list[i]));
            }
        }
    }

    /* renamed from: a */
    public static void m1195a(String str, String str2) {
        try {
            File m1196b = m1196b();
            if (m1196b != null) {
                C0786i.m788a(m1196b, str + ' ' + str2 + ' ' + System.currentTimeMillis() + '\n', true);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private static File m1196b() {
        if (f727a == null) {
            String m748c = C0778a.m748c(C0749e.m565g());
            if (m748c == null) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            f727a = new File(C0792o.m875j(C0749e.m565g()), "apmlite/ProcessTrack/" + ((currentTimeMillis - (currentTimeMillis % 86400000)) / 86400000) + '/' + m748c.replace(':', '_') + ".txt");
            C0832m.m1190b().m1239a(new Runnable() { // from class: com.apm.lite.runtime.o.1
                @Override // java.lang.Runnable
                public void run() {
                    C0834o.m1194a();
                }
            }, 15000L);
        }
        return f727a;
    }
}
