package com.apm.lite.nativecrash;

import android.text.TextUtils;
import com.apm.lite.C0738c;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0788k;
import com.apm.lite.p023k.C0792o;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.apm.lite.nativecrash.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0806d {

    /* renamed from: com.apm.lite.nativecrash.d$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a extends c {
        a(File file) {
            super(file);
            this.f628b = "Total FD Count:";
            this.f629c = ":";
            this.f630d = -2;
        }
    }

    /* renamed from: com.apm.lite.nativecrash.d$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class b extends c {
        b(File file) {
            super(file);
            this.f628b = "VmSize:";
            this.f629c = "\\s+";
            this.f630d = -1;
        }
    }

    /* renamed from: com.apm.lite.nativecrash.d$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class c {

        /* renamed from: a */
        protected File f627a;

        /* renamed from: b */
        protected String f628b;

        /* renamed from: c */
        protected String f629c;

        /* renamed from: d */
        protected int f630d;

        public c(File file) {
            this.f627a = file;
        }

        /* renamed from: a */
        public int m1003a() {
            int i;
            Throwable th;
            if (!this.f627a.exists() || !this.f627a.isFile()) {
                return -1;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.f627a));
                int i2 = -1;
                do {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        i2 = m1004a(readLine);
                    } catch (Throwable th2) {
                        th = th2;
                        i = i2;
                        bufferedReader = bufferedReader2;
                        try {
                            C0738c.m435a();
                            C0738c.m436a("NPTH_CATCH", th);
                            return i;
                        } finally {
                            if (bufferedReader != null) {
                                C0788k.m813a(bufferedReader);
                            }
                        }
                    }
                } while (i2 == -1);
                C0788k.m813a(bufferedReader2);
                return i2;
            } catch (Throwable th3) {
                i = -1;
                th = th3;
            }
        }

        /* renamed from: a */
        public int m1004a(String str) {
            int i = this.f630d;
            if (!str.startsWith(this.f628b)) {
                return i;
            }
            try {
                i = Integer.parseInt(str.split(this.f629c)[1].trim());
            } catch (NumberFormatException e) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", e);
            }
            if (i < 0) {
                return -2;
            }
            return i;
        }
    }

    /* renamed from: com.apm.lite.nativecrash.d$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class d extends c {
        d(File file) {
            super(file);
        }

        /* renamed from: b */
        public HashMap<String, List<String>> m1005b() {
            JSONArray m799b;
            HashMap<String, List<String>> hashMap = new HashMap<>();
            try {
                m799b = C0786i.m799b(this.f627a.getAbsolutePath());
            } catch (IOException unused) {
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
            if (m799b == null) {
                return hashMap;
            }
            for (int i = 0; i < m799b.length(); i++) {
                String optString = m799b.optString(i);
                if (!TextUtils.isEmpty(optString) && optString.startsWith("[tid:0") && optString.endsWith("sigstack:0x0]")) {
                    int indexOf = optString.indexOf("[routine:0x");
                    int i2 = indexOf + 11;
                    String substring = indexOf > 0 ? optString.substring(i2, optString.indexOf(93, i2)) : "unknown addr";
                    List<String> list = hashMap.get(substring);
                    if (list == null) {
                        list = new ArrayList<>();
                        hashMap.put(substring, list);
                    }
                    list.add(optString);
                }
            }
            return hashMap;
        }
    }

    /* renamed from: com.apm.lite.nativecrash.d$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class e extends c {
        e(File file) {
            super(file);
        }

        /* renamed from: a */
        public JSONArray m1006a(HashMap<String, List<String>> hashMap) {
            JSONArray m799b;
            int indexOf;
            List<String> list;
            JSONArray jSONArray = new JSONArray();
            if (hashMap.isEmpty()) {
                return jSONArray;
            }
            try {
                m799b = C0786i.m799b(this.f627a.getAbsolutePath());
            } catch (IOException unused) {
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
            if (m799b == null) {
                return jSONArray;
            }
            for (int i = 0; i < m799b.length(); i++) {
                String optString = m799b.optString(i);
                if (!TextUtils.isEmpty(optString) && (indexOf = optString.indexOf(":")) > 2) {
                    String substring = optString.substring(2, indexOf);
                    if (hashMap.containsKey(substring) && (list = hashMap.get(substring)) != null) {
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next() + " " + optString);
                        }
                        hashMap.remove(substring);
                    }
                }
            }
            Iterator<List<String>> it2 = hashMap.values().iterator();
            while (it2.hasNext()) {
                Iterator<String> it3 = it2.next().iterator();
                while (it3.hasNext()) {
                    jSONArray.put(it3.next() + "  0x000000:unknown");
                }
            }
            return jSONArray;
        }
    }

    /* renamed from: com.apm.lite.nativecrash.d$f */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class f extends c {
        f(File file) {
            super(file);
            this.f628b = "Total Threads Count:";
            this.f629c = ":";
            this.f630d = -2;
        }
    }

    /* renamed from: a */
    public static int m999a(String str) {
        return new a(C0792o.m850a(str)).m1003a();
    }

    /* renamed from: a */
    public static JSONArray m1000a(File file, File file2) {
        return new e(file2).m1006a(new d(file).m1005b());
    }

    /* renamed from: b */
    public static int m1001b(String str) {
        return new f(C0792o.m854b(str)).m1003a();
    }

    /* renamed from: c */
    public static int m1002c(String str) {
        return new b(C0792o.m858c(str)).m1003a();
    }
}
