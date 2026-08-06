package com.apm.lite.nativecrash;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashFilter;
import com.apm.lite.p013c.C0739a;
import com.apm.lite.p013c.p014a.C0740a;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p016d.C0747c;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0788k;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0796s;
import com.apm.lite.p023k.C0799v;
import com.apm.lite.p023k.C0800w;
import com.apm.lite.runtime.C0833n;
import com.apm.lite.runtime.C0835p;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.nativecrash.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0805c {

    /* renamed from: d */
    private static Boolean f610d;

    /* renamed from: a */
    private final Context f611a;

    /* renamed from: b */
    private JSONObject f612b = null;

    /* renamed from: c */
    private b f613c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.apm.lite.nativecrash.c$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static String m990b(File file) {
            BufferedReader bufferedReader;
            String readLine;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    readLine = bufferedReader.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    try {
                        C0738c.m435a();
                        C0738c.m436a("NPTH_CATCH", th);
                        return "";
                    } finally {
                        C0788k.m813a(bufferedReader2);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (readLine == null) {
                C0788k.m813a(bufferedReader);
                return "";
            }
            if (!readLine.startsWith("[FATAL:jni_android.cc") || !readLine.contains("Please include Java exception stack in crash report ttwebview:")) {
                C0788k.m813a(bufferedReader);
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int indexOf = readLine.indexOf(" ttwebview:");
            sb.append("Caused by: ");
            sb.append("Please include Java exception stack in crash report");
            sb.append("\n");
            sb.append(readLine.substring(indexOf + 11));
            while (true) {
                sb.append("\n");
                String readLine2 = bufferedReader.readLine();
                if (readLine2 == null) {
                    String sb2 = sb.toString();
                    C0788k.m813a(bufferedReader);
                    return sb2;
                }
                sb.append(readLine2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.apm.lite.nativecrash.c$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public class b {

        /* renamed from: b */
        private final C0807e f615b;

        /* renamed from: c */
        private final C0803a f616c;

        /* renamed from: d */
        private final File f617d;

        /* renamed from: e */
        private final File f618e;

        public b(File file) {
            this.f617d = file;
            this.f618e = C0792o.m847a(C0749e.m565g(), file.getName());
            C0803a c0803a = new C0803a(file);
            this.f616c = c0803a;
            C0807e c0807e = new C0807e(file);
            this.f615b = c0807e;
            if (c0803a.m952a() && c0807e.m1008a() == null) {
                c0807e.m1009a(file);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x001d A[Catch: all -> 0x0018, TRY_LEAVE, TryCatch #0 {all -> 0x0018, blocks: (B:15:0x0008, B:17:0x000e, B:5:0x001d), top: B:14:0x0008 }] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long m994a() {
            String str;
            Map<String, String> m954c = this.f616c.m954c();
            if (m954c != null) {
                try {
                } catch (Throwable th) {
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th);
                }
                if (!m954c.isEmpty()) {
                    str = m954c.get(StrategyConstants.START_TIME);
                    if (str != null) {
                        return Long.parseLong(str);
                    }
                    return System.currentTimeMillis();
                }
            }
            str = null;
            if (str != null) {
            }
            return System.currentTimeMillis();
        }

        /* renamed from: b */
        public File m995b() {
            return this.f617d;
        }

        /* renamed from: c */
        public boolean m996c() {
            return this.f616c.m952a();
        }
    }

    /* renamed from: com.apm.lite.nativecrash.c$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public class c extends e {
        c() {
            super();
            this.f622c = "Total FD Count:";
            this.f621b = C0792o.m873i(C0805c.this.f613c.m995b());
            this.f623d = ":";
            this.f624e = -2;
        }
    }

    /* renamed from: com.apm.lite.nativecrash.c$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public class d extends e {
        d() {
            super();
            this.f622c = "VmSize:";
            this.f621b = C0792o.m877k(C0805c.this.f613c.m995b());
            this.f623d = "\\s+";
            this.f624e = -1;
        }
    }

    /* renamed from: com.apm.lite.nativecrash.c$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public class e {

        /* renamed from: b */
        protected File f621b;

        /* renamed from: c */
        protected String f622c;

        /* renamed from: d */
        protected String f623d;

        /* renamed from: e */
        protected int f624e;

        public e() {
        }

        /* renamed from: a */
        public int m997a() {
            int i;
            Throwable th;
            if (!this.f621b.exists() || !this.f621b.isFile()) {
                return -1;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.f621b));
                int i2 = -1;
                do {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        i2 = m998a(readLine);
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
        public int m998a(String str) {
            int i = this.f624e;
            if (!str.startsWith(this.f622c)) {
                return i;
            }
            try {
                i = Integer.parseInt(str.split(this.f623d)[1].trim());
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

    /* renamed from: com.apm.lite.nativecrash.c$f */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public class f extends e {
        f() {
            super();
            this.f622c = "Total Threads Count:";
            this.f621b = C0792o.m874j(C0805c.this.f613c.m995b());
            this.f623d = ":";
            this.f624e = -2;
        }
    }

    public C0805c(Context context) {
        this.f611a = context;
    }

    /* renamed from: a */
    private String m961a(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            if (str.length() < 16) {
                sb.append(str);
            } else {
                sb.append(str.charAt(6));
                sb.append(str.charAt(7));
                sb.append(str.charAt(4));
                sb.append(str.charAt(5));
                sb.append(str.charAt(2));
                sb.append(str.charAt(3));
                sb.append(str.charAt(0));
                sb.append(str.charAt(1));
                sb.append(str.charAt(10));
                sb.append(str.charAt(11));
                sb.append(str.charAt(8));
                sb.append(str.charAt(9));
                sb.append(str.charAt(14));
                sb.append(str.charAt(15));
                sb.append(str.charAt(12));
                sb.append(str.charAt(13));
                if (str.length() >= 32) {
                    sb.append((CharSequence) str, 16, 32);
                    sb.append('0');
                }
            }
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
        return sb.toString().toUpperCase();
    }

    /* renamed from: a */
    private void m962a(C0745a c0745a) {
        c0745a.m477a(m973n());
        c0745a.m484a("is_native_crash", (Object) 1);
        c0745a.m484a("repack_time", Long.valueOf(System.currentTimeMillis()));
        c0745a.m484a("crash_uuid", (Object) this.f613c.m995b().getName());
        c0745a.m484a("jiffy", Long.valueOf(C0833n.a.m1191a()));
    }

    /* renamed from: a */
    private void m963a(Map<String, String> map) {
        map.put("has_fds_file", C0792o.m873i(this.f613c.m995b()).exists() ? "true" : "false");
        File m871h = C0792o.m871h(this.f613c.m995b());
        map.put("has_logcat_file", (!m871h.exists() || m871h.length() <= 128) ? "false" : "true");
        map.put("has_maps_file", C0792o.m860d(this.f613c.m995b()).exists() ? "true" : "false");
        map.put("has_tombstone_file", C0792o.m853b(this.f613c.m995b()).exists() ? "true" : "false");
        map.put("has_meminfo_file", C0792o.m877k(this.f613c.m995b()).exists() ? "true" : "false");
        map.put("has_threads_file", C0792o.m874j(this.f613c.m995b()).exists() ? "true" : "false");
    }

    /* renamed from: b */
    private void m964b(C0745a c0745a) {
        HashMap hashMap = new HashMap();
        if (m972m()) {
            hashMap.put("is_root", "true");
            c0745a.m484a("is_root", "true");
        } else {
            hashMap.put("is_root", "false");
            c0745a.m484a("is_root", "false");
        }
        m963a(hashMap);
        int m974o = m974o();
        if (m974o > 0) {
            if (m974o > 960) {
                hashMap.put("fd_leak", "true");
            } else {
                hashMap.put("fd_leak", "false");
            }
            c0745a.m484a("fd_count", Integer.valueOf(m974o));
        }
        int m975p = m975p();
        if (m975p > 0) {
            if (m975p > 350) {
                hashMap.put("threads_leak", "true");
            } else {
                hashMap.put("threads_leak", "false");
            }
            c0745a.m484a("threads_count", Integer.valueOf(m975p));
        }
        int m976q = m976q();
        if (m976q > 0) {
            if (m976q > m971i()) {
                hashMap.put("memory_leak", "true");
            } else {
                hashMap.put("memory_leak", "false");
            }
            c0745a.m484a("memory_size", Integer.valueOf(m976q));
        }
        hashMap.put("sdk_version", "0.0.2");
        hashMap.put("has_java_stack", String.valueOf(c0745a.m498h().opt("java_data") != null));
        JSONArray m1000a = C0806d.m1000a(C0792o.m879l(this.f613c.f617d), C0792o.m880m(this.f613c.f617d));
        hashMap.put("leak_threads_count", String.valueOf(m1000a.length()));
        if (m1000a.length() > 0) {
            try {
                C0786i.m790a(C0792o.m881n(this.f613c.f617d), m1000a, false);
            } catch (Throwable unused) {
            }
        }
        c0745a.m489b();
        c0745a.m491c();
        c0745a.m490c(hashMap);
    }

    /* renamed from: c */
    private void m965c(C0745a c0745a) {
        Map<String, String> m1010b = this.f613c.f615b.m1010b();
        if (m1010b.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : m1010b.keySet()) {
            String m961a = m961a(m1010b.get(str));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lib_name", str);
                jSONObject.put("lib_uuid", m961a);
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", e2);
            }
        }
        c0745a.m484a("crash_lib_uuid", (Object) jSONArray);
    }

    /* renamed from: d */
    private void m966d(C0745a c0745a) {
        File m863e = C0792o.m863e(this.f613c.m995b());
        if (!m863e.exists() && this.f612b == null) {
            c0745a.m488b(C0800w.m942a(C0749e.m565g()));
            c0745a.m479a("has_callback", "false");
            return;
        }
        try {
            JSONObject jSONObject = this.f612b;
            if (jSONObject == null) {
                jSONObject = new JSONObject(C0786i.m804c(m863e.getAbsolutePath()));
            }
            c0745a.m492c(jSONObject);
            c0745a.m479a("has_callback", "true");
            if (c0745a.m498h().opt("storage") == null) {
                c0745a.m488b(C0800w.m942a(C0749e.m565g()));
            }
            C0796s.m898a(c0745a, c0745a.m499i(), CrashType.NATIVE);
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
        long j = -1;
        long optLong = c0745a.m498h().optLong("crash_time", -1L);
        long optLong2 = c0745a.m498h().optLong("java_end", -1L);
        if (optLong2 != -1 && optLong != -1) {
            j = optLong2 - optLong;
        }
        try {
            c0745a.m486b("total_cost", String.valueOf(j));
            c0745a.m479a("total_cost", String.valueOf(j / 1000));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005d A[Catch: all -> 0x0063, TRY_LEAVE, TryCatch #0 {all -> 0x0063, blocks: (B:11:0x0057, B:13:0x005d), top: B:10:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0034  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m967e(C0745a c0745a) {
        String m916a;
        File m882o;
        File m869g = C0792o.m869g(this.f613c.m995b());
        try {
            if (m869g.exists()) {
                try {
                    m916a = C0799v.m916a(m869g.getAbsolutePath());
                } catch (Throwable th) {
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th);
                }
                m882o = C0792o.m882o(this.f613c.m995b());
                if (m882o.exists()) {
                    String m990b = a.m990b(m882o);
                    m916a = !m916a.isEmpty() ? m916a + "\n" + m990b : m990b;
                }
                if (m916a.isEmpty()) {
                    c0745a.m484a("java_data", (Object) m916a);
                    return;
                }
                return;
            }
            if (m916a.isEmpty()) {
            }
        } catch (Throwable th2) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th2);
            return;
        }
        m916a = "";
        m882o = C0792o.m882o(this.f613c.m995b());
        if (m882o.exists()) {
        }
    }

    /* renamed from: f */
    private void m968f(C0745a c0745a) {
        File m848a = C0792o.m848a(this.f613c.m995b());
        if (m848a.exists()) {
            try {
                c0745a.m484a("native_log", (Object) C0786i.m800b(C0786i.m785a(m848a.getAbsolutePath(), "\n"), "\n"));
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
        }
    }

    /* renamed from: g */
    private void m969g(C0745a c0745a) {
        File m871h = C0792o.m871h(this.f613c.m995b());
        if (!m871h.exists()) {
            NativeImpl.dumpLogcat(m871h.getAbsolutePath(), String.valueOf(C0749e.m567i().getLogcatDumpCount()), String.valueOf(C0749e.m567i().getLogcatLevel()));
        }
        JSONArray jSONArray = new JSONArray();
        String str = " " + this.f613c.f616c.m954c().get("pid") + " ";
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(m871h));
            try {
                if (m871h.length() > 512000) {
                    bufferedReader2.skip(m871h.length() - 512000);
                }
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if ((readLine.length() > 32 ? readLine.substring(0, 31) : readLine).contains(str)) {
                        jSONArray.put(readLine);
                    }
                }
                C0788k.m813a(bufferedReader2);
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                C0788k.m813a(bufferedReader);
                c0745a.m484a("logcat", (Object) jSONArray);
            }
        } catch (Throwable unused2) {
        }
        c0745a.m484a("logcat", (Object) jSONArray);
    }

    /* renamed from: h */
    private void m970h(C0745a c0745a) {
        Map<String, String> m977a = m977a();
        if (m977a == null || c0745a == null) {
            return;
        }
        String str = m977a.get("process_name");
        if (str != null) {
            c0745a.m484a("process_name", (Object) str);
        }
        String str2 = m977a.get(StrategyConstants.START_TIME);
        if (str2 != null) {
            try {
                c0745a.m476a(Long.decode(str2).longValue());
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
        }
        String str3 = m977a.get("pid");
        if (str3 != null) {
            try {
                c0745a.m484a("pid", Long.decode(str3));
            } catch (Throwable th2) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th2);
            }
        }
        String str4 = m977a.get("crash_thread_name");
        if (str4 != null) {
            c0745a.m484a("crash_thread_name", (Object) str4);
        }
        String str5 = m977a.get("crash_time");
        if (str5 != null) {
            try {
                c0745a.m484a("crash_time", Long.decode(str5));
            } catch (Throwable th3) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th3);
            }
        }
        c0745a.m484a(Constants.KEY_DATA, (Object) m979b());
    }

    /* renamed from: i */
    public static long m971i() {
        return NativeImpl.is64BitRuntime() ? LocationRequestCompat.PASSIVE_INTERVAL : C0747c.m516a() ? 3891200L : 2867200L;
    }

    /* renamed from: m */
    public static boolean m972m() {
        Boolean bool = f610d;
        if (bool != null) {
            return bool.booleanValue();
        }
        String[] strArr = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        for (int i = 0; i < 11; i++) {
            try {
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
            if (new File(strArr[i]).exists()) {
                Boolean bool2 = true;
                f610d = bool2;
                return bool2.booleanValue();
            }
            continue;
        }
        Boolean bool3 = false;
        f610d = bool3;
        return bool3.booleanValue();
    }

    /* renamed from: n */
    private C0747c m973n() {
        C0747c c0747c = new C0747c(this.f611a);
        JSONObject m1208a = C0835p.m1198a().m1208a(this.f613c.m994a());
        if (m1208a != null) {
            c0747c.m533c(m1208a);
            c0747c.m535e();
            c0747c.m536f();
        }
        C0747c.m518b(c0747c);
        return c0747c;
    }

    /* renamed from: o */
    private int m974o() {
        return new c().m997a();
    }

    /* renamed from: p */
    private int m975p() {
        return new f().m997a();
    }

    /* renamed from: q */
    private int m976q() {
        return new d().m997a();
    }

    /* renamed from: a */
    public Map<String, String> m977a() {
        b bVar = this.f613c;
        if (bVar != null) {
            return bVar.f616c.m954c();
        }
        return null;
    }

    /* renamed from: a */
    public void m978a(File file) {
        this.f613c = new b(file);
    }

    /* renamed from: b */
    public String m979b() {
        b bVar = this.f613c;
        if (bVar == null) {
            return null;
        }
        String m1012c = bVar.f615b.m1012c();
        return (m1012c == null || m1012c.isEmpty()) ? this.f613c.f616c.m953b() : m1012c;
    }

    /* renamed from: c */
    public boolean m980c() {
        b bVar = this.f613c;
        if (bVar != null) {
            return bVar.m996c();
        }
        return false;
    }

    /* renamed from: d */
    public JSONObject m981d() {
        File m866f = C0792o.m866f(this.f613c.m995b());
        if (!m866f.exists()) {
            return null;
        }
        try {
            String m804c = C0786i.m804c(m866f.getAbsolutePath());
            if (m804c != null && !m804c.isEmpty()) {
                return new JSONObject(m804c);
            }
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
        return null;
    }

    /* renamed from: e */
    public void m982e() {
        try {
            File m863e = C0792o.m863e(this.f613c.m995b());
            File file = new File(m863e.getAbsolutePath() + ".tmp'");
            if (file.exists()) {
                file.delete();
            }
            int i = 0;
            if (m863e.exists()) {
                while (i < C0804b.m955a()) {
                    File file2 = new File(m863e.getAbsolutePath() + '.' + i);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    i++;
                }
                return;
            }
            C0745a c0745a = new C0745a();
            for (int i2 = 0; i2 < C0804b.m955a(); i2++) {
                File file3 = new File(m863e.getAbsolutePath() + '.' + i2);
                if (file3.exists()) {
                    try {
                        String m804c = C0786i.m804c(file3.getAbsolutePath());
                        if (!TextUtils.isEmpty(m804c)) {
                            JSONObject jSONObject = new JSONObject(m804c);
                            if (jSONObject.length() > 0) {
                                c0745a.m492c(jSONObject);
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
            JSONObject m498h = c0745a.m498h();
            try {
                if (m498h.length() != 0 && m498h.opt("storage") == null) {
                    C0745a.m469a(m498h, C0800w.m942a(C0749e.m565g()));
                }
            } catch (Throwable unused2) {
            }
            if (m498h.length() != 0) {
                this.f612b = m498h;
                C0786i.m801b(file, m498h, false);
                if (file.renameTo(m863e)) {
                    while (i < C0804b.m955a()) {
                        File file4 = new File(m863e.getAbsolutePath() + '.' + i);
                        if (file4.exists()) {
                            file4.delete();
                        }
                        i++;
                    }
                }
            }
        } catch (IOException e2) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", e2);
        }
    }

    /* renamed from: f */
    public boolean m983f() {
        ICrashFilter m376b = C0749e.m558b().m376b();
        if (m376b == null) {
            return true;
        }
        try {
            return m376b.onNativeCrashFilter(m979b(), "");
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
            return true;
        }
    }

    /* renamed from: g */
    public boolean m984g() {
        return C0739a.m438a().m442a(C0792o.m866f(this.f613c.m995b()).getAbsolutePath());
    }

    /* renamed from: h */
    public void m985h() {
        C0739a.m438a().m441a(C0740a.m443a(C0792o.m866f(this.f613c.m995b()).getAbsolutePath()));
    }

    /* renamed from: j */
    public JSONObject m986j() {
        try {
            C0745a c0745a = new C0745a();
            m962a(c0745a);
            m970h(c0745a);
            m965c(c0745a);
            m966d(c0745a);
            m967e(c0745a);
            m969g(c0745a);
            m968f(c0745a);
            m964b(c0745a);
            File m866f = C0792o.m866f(this.f613c.m995b());
            JSONObject m498h = c0745a.m498h();
            C0786i.m791a(m866f, m498h, false);
            return m498h;
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
            return null;
        }
    }

    /* renamed from: k */
    public boolean m987k() {
        return C0786i.m796a(this.f613c.m995b());
    }

    /* renamed from: l */
    public void m988l() {
        try {
            C0786i.m805c(this.f613c.m995b().getAbsolutePath(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/localDebug/" + C0749e.m565g().getPackageName() + "/" + this.f613c.m995b().getName() + ".zip");
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
    }
}
