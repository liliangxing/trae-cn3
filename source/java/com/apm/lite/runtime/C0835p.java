package com.apm.lite.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.p016d.C0747c;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.runtime.p024a.C0812b;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.runtime.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0835p {

    /* renamed from: a */
    private static C0835p f731a;

    /* renamed from: b */
    private File f732b;

    /* renamed from: c */
    private File f733c;

    /* renamed from: d */
    private File f734d;

    /* renamed from: e */
    private Context f735e;

    /* renamed from: f */
    private a f736f = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.apm.lite.runtime.p$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a {

        /* renamed from: a */
        private long f739a;

        /* renamed from: b */
        private long f740b;

        /* renamed from: c */
        private File f741c;

        /* renamed from: d */
        private JSONObject f742d;

        private a(File file) {
            long parseLong;
            this.f742d = null;
            this.f741c = file;
            String[] split = file.getName().split("-|\\.");
            if (split.length >= 2) {
                this.f739a = Long.parseLong(split[0]);
                parseLong = Long.parseLong(split[1]);
            } else {
                String name = file.getName();
                if (TextUtils.isEmpty(name) || name.length() < 13) {
                    return;
                }
                String substring = name.substring(0, 13);
                if (!TextUtils.isDigitsOnly(substring)) {
                    return;
                }
                parseLong = Long.parseLong(substring);
                this.f739a = parseLong;
            }
            this.f740b = parseLong;
        }

        /* renamed from: a */
        private String m1214a() {
            return this.f739a + "-" + this.f740b + ".ctx";
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m1216a(long j) {
            this.f740b = j;
            this.f741c.renameTo(new File(this.f741c.getParent(), m1214a()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public JSONObject m1219b() {
            if (this.f742d == null) {
                try {
                    this.f742d = new JSONObject(C0786i.m804c(this.f741c.getAbsolutePath()));
                } catch (Throwable unused) {
                }
                if (this.f742d == null) {
                    this.f742d = new JSONObject();
                }
            }
            return this.f742d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public boolean m1220b(long j) {
            long j2 = this.f739a;
            if (j2 > j && j2 - j > 604800000) {
                return true;
            }
            long j3 = this.f740b;
            if (j3 >= j || j - j3 <= 604800000) {
                return this.f741c.lastModified() < j && j - this.f741c.lastModified() > 604800000;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m1223c() {
            this.f741c.delete();
        }
    }

    private C0835p(Context context) {
        File m856c = C0792o.m856c(context);
        if (!m856c.exists() || (!m856c.isDirectory() && m856c.delete())) {
            m856c.mkdirs();
            C0812b.m1041a();
        }
        this.f732b = m856c;
        this.f733c = new File(m856c, "did");
        this.f734d = new File(m856c, "device_uuid");
        this.f735e = context;
    }

    /* renamed from: a */
    public static int m1197a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (C0747c.m523e(jSONObject)) {
            return 2;
        }
        if (C0747c.m523e(jSONObject2)) {
            return 0;
        }
        return (String.valueOf(jSONObject2.opt("update_version_code")).equals(String.valueOf(jSONObject.opt("update_version_code"))) && C0747c.m524f(jSONObject)) ? 1 : 2;
    }

    /* renamed from: a */
    public static C0835p m1198a() {
        if (f731a == null) {
            f731a = new C0835p(C0749e.m565g());
        }
        return f731a;
    }

    /* renamed from: a */
    private void m1199a(long j, long j2, JSONObject jSONObject, JSONArray jSONArray) {
        File file = new File(this.f732b, "" + j + "-" + j2 + ".ctx");
        File file2 = new File(this.f732b, "" + j + "-" + j2 + ".allData");
        try {
            C0786i.m791a(file, jSONObject, false);
            C0786i.m790a(file2, jSONArray, false);
            this.f736f = new a(file);
        } catch (IOException e) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", e);
        }
    }

    /* renamed from: c */
    private a m1200c() {
        if (this.f736f == null) {
            m1203d(".ctx");
        }
        return this.f736f;
    }

    /* renamed from: c */
    private void m1201c(long j) {
        try {
            ArrayList<a> m1203d = m1203d("");
            if (m1203d.size() <= 6) {
                return;
            }
            Iterator<a> it = m1203d.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.m1220b(j)) {
                    next.m1223c();
                }
            }
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
    }

    /* renamed from: d */
    private File m1202d(long j) {
        Iterator<a> it = m1203d(".ctx").iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (j >= next.f739a && j <= next.f740b) {
                return next.f741c;
            }
        }
        return null;
    }

    /* renamed from: d */
    private ArrayList<a> m1203d(final String str) {
        File[] listFiles = this.f732b.listFiles(new FilenameFilter() { // from class: com.apm.lite.runtime.p.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return str2.endsWith(str) && Pattern.compile("^\\d{1,13}-\\d{1,13}.*").matcher(str2).matches();
            }
        });
        ArrayList<a> arrayList = new ArrayList<>();
        if (listFiles == null) {
            return arrayList;
        }
        C0794q.m887a((Object) ("foundRuntimeContextFiles " + listFiles.length));
        a aVar = null;
        for (File file : listFiles) {
            try {
                a aVar2 = new a(file);
                arrayList.add(aVar2);
                if (this.f736f == null) {
                    if (".ctx".equals(str)) {
                        if (aVar != null && aVar2.f740b < aVar.f740b) {
                        }
                        aVar = aVar2;
                    }
                }
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
        }
        if (this.f736f == null && aVar != null) {
            this.f736f = aVar;
        }
        return arrayList;
    }

    /* renamed from: e */
    private File m1204e(long j) {
        Iterator<a> it = m1203d(".allData").iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (j >= next.f739a && j <= next.f740b) {
                return next.f741c;
            }
        }
        return null;
    }

    /* renamed from: f */
    private File m1205f(long j) {
        Iterator<a> it = m1203d(".ctx").iterator();
        a aVar = null;
        while (it.hasNext()) {
            a next = it.next();
            if (aVar == null || Math.abs(aVar.f740b - j) > Math.abs(next.f740b - j)) {
                aVar = next;
            }
        }
        if (aVar == null) {
            return null;
        }
        return aVar.f741c;
    }

    /* renamed from: g */
    private File m1206g(long j) {
        Iterator<a> it = m1203d(".allData").iterator();
        a aVar = null;
        while (it.hasNext()) {
            a next = it.next();
            if (aVar == null || Math.abs(aVar.f740b - j) > Math.abs(next.f740b - j)) {
                aVar = next;
            }
        }
        if (aVar == null) {
            return null;
        }
        return aVar.f741c;
    }

    /* renamed from: a */
    public String m1207a(String str) {
        try {
            return C0786i.m804c(this.f734d.getAbsolutePath());
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: a */
    public JSONObject m1208a(long j) {
        boolean z;
        String str;
        File m1202d = m1202d(j);
        if (m1202d == null) {
            m1202d = m1205f(j);
            z = true;
        } else {
            z = false;
        }
        JSONObject jSONObject = null;
        if (m1202d != null) {
            try {
                str = C0786i.m804c(m1202d.getAbsolutePath());
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable th) {
                    th = th;
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", new IOException("content :" + str, th));
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("unauthentic_version", 1);
                        } catch (JSONException e) {
                            C0738c.m435a();
                            C0738c.m436a("NPTH_CATCH", e);
                        }
                    }
                    return jSONObject;
                }
            } catch (Throwable th2) {
                th = th2;
                str = null;
            }
        }
        if (jSONObject != null && z) {
            jSONObject.put("unauthentic_version", 1);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void m1209a(Map<String, Object> map, JSONArray jSONArray) {
        JSONObject m532a = C0747c.m512a(this.f735e).m532a(map);
        if (C0747c.m523e(m532a)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a m1200c = m1200c();
        if (m1200c == null) {
            m1199a(currentTimeMillis, currentTimeMillis, m532a, jSONArray);
            return;
        }
        int m1197a = m1197a(m1200c.m1219b(), m532a);
        if (m1197a == 1) {
            m1199a(m1200c.f739a, currentTimeMillis, m532a, jSONArray);
            C0786i.m796a(m1200c.f741c);
        } else if (m1197a == 2) {
            m1199a(currentTimeMillis, currentTimeMillis, m532a, jSONArray);
        } else if (m1197a == 3) {
            m1200c.m1216a(currentTimeMillis);
        }
        m1201c(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public String m1210b() {
        try {
            return C0786i.m804c(this.f733c.getAbsolutePath());
        } catch (Throwable unused) {
            return "0";
        }
    }

    /* renamed from: b */
    public JSONArray m1211b(long j) {
        String str;
        File m1204e = m1204e(j);
        if (m1204e == null) {
            m1204e = m1206g(j);
        }
        if (m1204e == null) {
            return null;
        }
        try {
            str = C0786i.m804c(m1204e.getAbsolutePath());
            try {
                return new JSONArray(str);
            } catch (Throwable th) {
                th = th;
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", new IOException("content :" + str, th));
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m1212b(String str) {
        try {
            C0786i.m788a(this.f733c, str, false);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public void m1213c(String str) {
        try {
            C0786i.m788a(this.f734d, str, false);
        } catch (Throwable unused) {
        }
    }
}
