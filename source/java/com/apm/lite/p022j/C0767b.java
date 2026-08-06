package com.apm.lite.p022j;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.Npth;
import com.apm.lite.nativecrash.C0805c;
import com.apm.lite.nativecrash.C0806d;
import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.p011a.C0730a;
import com.apm.lite.p013c.C0739a;
import com.apm.lite.p013c.p014a.C0740a;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p016d.C0746b;
import com.apm.lite.p016d.C0747c;
import com.apm.lite.p016d.C0748d;
import com.apm.lite.p017e.C0750a;
import com.apm.lite.p019g.C0758a;
import com.apm.lite.p022j.AbstractC0768c;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0789l;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0793p;
import com.apm.lite.p023k.C0800w;
import com.apm.lite.runtime.C0810a;
import com.apm.lite.runtime.C0821b;
import com.apm.lite.runtime.C0826g;
import com.apm.lite.runtime.C0827h;
import com.apm.lite.runtime.C0829j;
import com.apm.lite.runtime.C0832m;
import com.apm.lite.runtime.C0833n;
import com.apm.lite.runtime.C0835p;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.apm.lite.j.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0767b {

    /* renamed from: b */
    private static volatile C0767b f497b;

    /* renamed from: a */
    private Context f498a;

    /* renamed from: d */
    private b f500d;

    /* renamed from: e */
    private HashMap<String, b> f501e;

    /* renamed from: c */
    private int f499c = -1;

    /* renamed from: f */
    private volatile boolean f502f = false;

    /* renamed from: g */
    private Runnable f503g = new Runnable() { // from class: com.apm.lite.j.b.1
        @Override // java.lang.Runnable
        public void run() {
            C0767b.this.m674g();
        }
    };

    /* renamed from: h */
    private Runnable f504h = new Runnable() { // from class: com.apm.lite.j.b.2
        @Override // java.lang.Runnable
        public void run() {
            C0767b.this.m672e();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apm.lite.j.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a {

        /* renamed from: a */
        File f514a;

        /* renamed from: b */
        long f515b;

        /* renamed from: c */
        long f516c;

        /* renamed from: d */
        CrashType f517d;

        /* renamed from: e */
        String f518e;

        a(File file, long j, CrashType crashType) {
            this.f516c = -1L;
            this.f514a = file;
            this.f515b = j;
            this.f517d = crashType;
            this.f518e = file.getName();
        }

        a(File file, CrashType crashType) {
            this.f515b = -1L;
            this.f516c = -1L;
            this.f514a = file;
            this.f517d = crashType;
            this.f518e = file.getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.apm.lite.j.b$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class b {

        /* renamed from: a */
        String f519a;

        /* renamed from: d */
        a f522d;

        /* renamed from: e */
        a f523e;

        /* renamed from: b */
        List<a> f520b = new ArrayList();

        /* renamed from: c */
        List<a> f521c = new ArrayList();

        /* renamed from: f */
        boolean f524f = false;

        /* renamed from: g */
        int f525g = 0;

        b(String str) {
            this.f519a = str;
        }
    }

    private C0767b(Context context) {
        this.f498a = context;
    }

    /* renamed from: a */
    private C0748d m655a(File file, CrashType crashType, String str, long j, long j2) {
        C0748d c0748d;
        try {
            try {
                if (file.isFile()) {
                    C0786i.m796a(file);
                    return null;
                }
                boolean z = crashType == CrashType.LAUNCH;
                if (crashType == null) {
                    try {
                        return C0786i.m807d(new File(file, file.getName()).getAbsolutePath());
                    } catch (Throwable th) {
                        th = th;
                        c0748d = null;
                        C0786i.m796a(file);
                        C0738c.m435a();
                        C0738c.m436a("NPTH_CATCH", th);
                        return c0748d;
                    }
                }
                C0748d m780a = C0786i.m780a(file, crashType);
                try {
                    JSONObject m543b = m780a.m543b();
                    if (m780a.m543b() == null) {
                        C0786i.m796a(file);
                    } else {
                        if (crashType == CrashType.ANR) {
                            return m780a;
                        }
                        m543b.put("crash_time", j);
                        m543b.put("app_start_time", j2);
                        JSONObject optJSONObject = m543b.optJSONObject(Constants.KEY_HEADER);
                        if (optJSONObject == null) {
                            optJSONObject = C0747c.m513a(this.f498a, j).m537g();
                        } else if (z) {
                            m543b.remove(Constants.KEY_HEADER);
                        }
                        String optString = optJSONObject.optString("sdk_version_name", null);
                        if (optString == null) {
                            optString = "0.0.2";
                        }
                        C0745a.m466a(m543b, "filters", "sdk_version", optString);
                        if (C0786i.m798a(m543b.optJSONArray("logcat"))) {
                            m543b.put("logcat", C0829j.m1151b(str));
                        }
                        C0745a.m466a(m543b, "filters", "has_dump", "true");
                        C0745a.m466a(m543b, "filters", "has_logcat", String.valueOf(!C0789l.m823a(m543b, "logcat")));
                        C0745a.m466a(m543b, "filters", "memory_leak", String.valueOf(C0745a.m472b(str)));
                        C0745a.m466a(m543b, "filters", "fd_leak", String.valueOf(C0745a.m473c(str)));
                        C0745a.m466a(m543b, "filters", "threads_leak", String.valueOf(C0745a.m474d(str)));
                        C0745a.m466a(m543b, "filters", "is_64_devices", String.valueOf(C0747c.m516a()));
                        C0745a.m466a(m543b, "filters", "is_64_runtime", String.valueOf(NativeImpl.is64BitRuntime()));
                        C0745a.m466a(m543b, "filters", "is_x86_devices", String.valueOf(C0747c.m520b()));
                        C0745a.m466a(m543b, "filters", "has_meminfo_file", String.valueOf(C0745a.m470a(str)));
                        C0745a.m466a(m543b, "filters", "is_root", String.valueOf(C0805c.m972m()));
                        m543b.put("launch_did", C0758a.m635a(this.f498a));
                        m543b.put("crash_uuid", file.getName());
                        m543b.put("jiffy", C0833n.a.m1191a());
                        try {
                            long parseLong = Long.parseLong(C0821b.m1106a(j, str));
                            C0745a.m466a(m543b, "filters", "lastAliveTime", Math.abs(parseLong - j) < 60000 ? "< 60s" : "> 60s");
                            m543b.put("lastAliveTime", String.valueOf(parseLong));
                        } catch (Throwable unused) {
                            m543b.put("lastAliveTime", "unknown");
                            C0745a.m466a(m543b, "filters", "lastAliveTime", "unknown");
                        }
                        m543b.put("has_dump", "true");
                        if (m543b.opt("storage") == null) {
                            C0745a.m469a(m543b, C0800w.m942a(C0749e.m565g()));
                        }
                        if (C0747c.m522d(optJSONObject)) {
                            C0745a.m466a(m543b, "filters", "unauthentic_version", "unauthentic_version");
                        }
                        m780a.m543b().put("upload_scene", "launch_scan");
                        if (z) {
                            JSONObject jSONObject = new JSONObject();
                            m543b.put("event_type", "start_crash");
                            m543b.put("stack", m543b.remove(Constants.KEY_DATA));
                            jSONObject.put(Constants.KEY_DATA, new JSONArray().put(m543b));
                            jSONObject.put(Constants.KEY_HEADER, optJSONObject);
                            m780a.m541a(jSONObject);
                        } else {
                            m543b.put("isJava", 1);
                        }
                    }
                    return m780a;
                } catch (Throwable th2) {
                    th = th2;
                    c0748d = m780a;
                    C0786i.m796a(file);
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th);
                    return c0748d;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            c0748d = null;
        }
    }

    /* renamed from: a */
    public static C0767b m656a() {
        if (f497b == null) {
            synchronized (C0767b.class) {
                if (f497b == null) {
                    f497b = new C0767b(C0749e.m565g());
                }
            }
        }
        return f497b;
    }

    /* renamed from: a */
    private JSONObject m657a(C0805c c0805c) {
        JSONObject m981d = c0805c.m981d();
        if (m981d != null && m981d.length() != 0) {
            return m981d;
        }
        if (C0749e.m562d()) {
            c0805c.m988l();
        }
        if (!c0805c.m980c()) {
            c0805c.m987k();
            return null;
        }
        if (!c0805c.m983f()) {
            c0805c.m987k();
            return null;
        }
        if (c0805c.m984g()) {
            c0805c.m987k();
            return null;
        }
        c0805c.m982e();
        return c0805c.m986j();
    }

    /* renamed from: a */
    private void m658a(b bVar) {
        C0786i.m796a(C0792o.m847a(this.f498a, bVar.f519a));
        C0786i.m796a(C0792o.m852b(this.f498a, bVar.f519a));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(5:37|38|39|(1:41)(1:70)|42)|(1:(3:68|69|20))(2:46|47)|48|49|50|51|(1:53)|54|55|20) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0161, code lost:
    
        r0 = th;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m659a(final b bVar, boolean z, C0827h c0827h) {
        Iterator<a> it;
        File file;
        CrashType crashType;
        final C0748d m655a;
        JSONObject m543b;
        JSONObject optJSONObject;
        final File file2;
        JSONArray jSONArray;
        JSONObject optJSONObject2;
        if (bVar.f520b.isEmpty()) {
            return;
        }
        if (bVar.f523e == null) {
            bVar.f523e = bVar.f522d;
        }
        Iterator<a> it2 = bVar.f520b.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            try {
                file = next.f514a;
                crashType = next.f517d;
                it = it2;
                try {
                    m655a = m655a(file, crashType, bVar.f519a, next.f515b, next.f516c);
                } catch (Throwable th) {
                    th = th;
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th);
                    C0786i.m796a(next.f514a);
                    it2 = it;
                }
            } catch (Throwable th2) {
                th = th2;
                it = it2;
            }
            if (m655a != null && (m543b = m655a.m543b()) != null && (optJSONObject = m543b.optJSONObject(Constants.KEY_HEADER)) != null) {
                if (crashType == null) {
                    file2 = file;
                    if (new File(file2, file.getName()).exists() || file2.getName().split("_").length < 5) {
                        if (!C0770e.m690a(m655a.m538a(), m543b.toString(), false).m732a()) {
                            it2 = it;
                        }
                        C0786i.m796a(file2);
                        it2 = it;
                    }
                } else {
                    file2 = file;
                }
                File m500a = C0746b.m500a(file2);
                if (m500a.exists()) {
                    try {
                        jSONArray = new JSONArray(C0786i.m803c(m500a));
                        optJSONObject2 = crashType == CrashType.LAUNCH ? ((JSONArray) m543b.opt(Constants.KEY_DATA)).optJSONObject(0) : m543b;
                    } catch (Throwable unused) {
                    }
                    if ((!z && bVar.f523e != next) || next.f518e.contains("ignore")) {
                        try {
                            C0745a.m466a(optJSONObject2, "filters", MonitorConstants.KEY_AID, String.valueOf(String.valueOf(optJSONObject.opt(MonitorConstants.KEY_AID))));
                            C0745a.m466a(optJSONObject2, "filters", "has_ignore", String.valueOf(next.f518e.contains("ignore")));
                        } catch (Throwable th3) {
                            C0738c.m435a();
                            C0738c.m436a("NPTH_CATCH", th3);
                        }
                    } else if (c0827h != null && !c0827h.m1148a(optJSONObject2.optString("crash_md5", DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE))) {
                        C0786i.m796a(next.f514a);
                        it2 = it;
                    }
                    C0745a.m466a(optJSONObject2, "filters", "start_uuid", bVar.f519a);
                    C0745a.m466a(optJSONObject2, "filters", "leak_threads_count", String.valueOf(bVar.f525g));
                    C0745a.m466a(optJSONObject2, "filters", "crash_thread_name", optJSONObject2.optString("crash_thread_name", "unknown"));
                    C0746b.m508a(m543b, jSONArray, new C0746b.a() { // from class: com.apm.lite.j.b.3
                        @Override // com.apm.lite.p016d.C0746b.a
                        /* renamed from: a */
                        public void mo413a(JSONObject jSONObject) {
                            C0770e.m692a(m655a.m538a(), jSONObject.toString(), new File(file2, "logZip"), C0792o.m847a(C0767b.this.f498a, bVar.f519a));
                        }
                    });
                    if (!C0786i.m796a(file2)) {
                        C0739a.m438a().m441a(C0740a.m443a(file2.getAbsolutePath()));
                    }
                    C0826g.m1143a(C0792o.m852b(C0749e.m565g(), bVar.f519a), file2.getName());
                    AbstractC0768c.m680a(crashType, m543b);
                    it2 = it;
                }
                C0786i.m796a(file2);
                it2 = it;
            }
            C0786i.m796a(file);
            it2 = it;
        }
    }

    /* renamed from: a */
    private void m661a(File file, b bVar) {
    }

    /* renamed from: a */
    private void m662a(HashMap<String, b> hashMap) {
        File[] listFiles = C0792o.m865f(this.f498a).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (int i = 0; i < listFiles.length && i < 5; i++) {
            File file = listFiles[i];
            try {
                if (file.isDirectory() && file.getName().endsWith("G")) {
                    String name = file.getName();
                    b bVar = hashMap.get(name);
                    if (bVar == null) {
                        bVar = new b(name);
                        hashMap.put(name, bVar);
                    }
                    JSONArray m1000a = C0806d.m1000a(C0792o.m879l(file), C0792o.m880m(file));
                    bVar.f525g = m1000a.length();
                    if (bVar.f525g > 0) {
                        try {
                            C0786i.m790a(C0792o.m881n(file), m1000a, false);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    C0786i.m796a(file);
                }
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
                C0786i.m796a(file);
            }
        }
    }

    /* renamed from: a */
    private void m663a(HashMap<String, b> hashMap, b bVar) {
        File[] listFiles = C0792o.m859d(this.f498a).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (int i = 0; i < listFiles.length && i < 5; i++) {
            File file = listFiles[i];
            try {
                if (file.isDirectory() && file.getName().endsWith("G")) {
                    String name = file.getName();
                    b bVar2 = hashMap.get(name);
                    if (bVar2 == null) {
                        bVar2 = new b(name);
                        hashMap.put(name, bVar2);
                    }
                    bVar2.f521c.add(new a(file, CrashType.NATIVE));
                } else {
                    C0786i.m796a(file);
                }
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
                C0786i.m796a(file);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005b, code lost:
    
        if (r0.equals("launch") == false) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m664a(HashMap<String, b> hashMap, b bVar, File file, String str) {
        if (!str.endsWith("G")) {
            C0786i.m796a(file);
            return;
        }
        String[] split = str.split("_");
        CrashType crashType = null;
        if (split.length < 5) {
            bVar.f520b.add(new a(file, null));
            return;
        }
        boolean z = false;
        try {
            long parseLong = Long.parseLong(split[0]);
            long parseLong2 = Long.parseLong(split[4]);
            String str2 = split[2];
            String str3 = split[1];
            str3.hashCode();
            switch (str3.hashCode()) {
                case -1109843021:
                    break;
                case 96741:
                    if (str3.equals("anr")) {
                        z = true;
                        break;
                    }
                    z = -1;
                    break;
                case 3254818:
                    if (str3.equals("java")) {
                        z = 2;
                        break;
                    }
                    z = -1;
                    break;
                default:
                    z = -1;
                    break;
            }
            switch (z) {
                case false:
                    crashType = CrashType.LAUNCH;
                    break;
                case true:
                    crashType = CrashType.ANR;
                    break;
                case true:
                    crashType = CrashType.JAVA;
                    break;
            }
            b bVar2 = hashMap.get(str2);
            if (bVar2 == null) {
                bVar2 = new b(str2);
                hashMap.put(str2, bVar2);
            }
            a aVar = new a(file, parseLong, crashType);
            aVar.f516c = parseLong2;
            if ((bVar2.f522d == null || bVar2.f522d.f515b > aVar.f515b) && crashType != null && crashType != CrashType.ANR && !str.contains("ignore")) {
                bVar2.f522d = aVar;
            }
            bVar2.f520b.add(aVar);
        } catch (Throwable unused) {
            bVar.f520b.add(new a(file, null));
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", new RuntimeException("err format crashTime:" + str));
        }
    }

    /* renamed from: a */
    private boolean m665a(File file) {
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.endsWith("")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m666b(final b bVar, boolean z, C0827h c0827h) {
        boolean z2;
        JSONObject m657a;
        if (bVar.f521c.size() <= 1 && bVar.f521c.isEmpty()) {
            bVar.f523e = bVar.f522d;
            return;
        }
        boolean m885b = C0793p.m885b(this.f498a);
        bVar.f523e = bVar.f522d;
        C0805c c0805c = new C0805c(this.f498a);
        for (a aVar : bVar.f521c) {
            final File file = aVar.f514a;
            try {
                c0805c.m978a(file);
                m657a = m657a(c0805c);
            } catch (Throwable th) {
                th = th;
                z2 = m885b;
            }
            if (m657a != null && m657a.length() != 0) {
                if (m657a.length() != 0) {
                    if (z) {
                        z2 = m885b;
                        if (c0827h != null && !c0827h.m1148a(DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE)) {
                            c0805c.m987k();
                        }
                    } else {
                        long optLong = m657a.optLong("crash_time");
                        try {
                        } catch (Throwable th2) {
                            th = th2;
                            z2 = m885b;
                        }
                        if (bVar.f523e == null) {
                            bVar.f523e = aVar;
                            bVar.f524f = true;
                            if (c0827h == null || c0827h.m1148a(DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE)) {
                                z2 = m885b;
                            } else {
                                c0805c.m987k();
                            }
                        } else {
                            if (bVar.f524f) {
                                z2 = m885b;
                            } else {
                                z2 = m885b;
                                try {
                                } catch (Throwable th3) {
                                    th = th3;
                                    C0738c.m435a();
                                    C0738c.m436a("NPTH_CATCH", th);
                                    C0786i.m796a(file);
                                    m885b = z2;
                                }
                                if (optLong < bVar.f523e.f515b) {
                                    bVar.f523e = aVar;
                                    if (c0827h == null || c0827h.m1148a(DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE)) {
                                        if (!m665a(file)) {
                                            m661a(file, bVar);
                                        }
                                        bVar.f524f = true;
                                    } else {
                                        c0805c.m987k();
                                        m885b = z2;
                                    }
                                }
                            }
                            C0745a.m466a(m657a, "filters", MonitorConstants.KEY_AID, String.valueOf(m657a.optJSONObject(Constants.KEY_HEADER).opt(MonitorConstants.KEY_AID)));
                        }
                    }
                    C0745a.m466a(m657a, "filters", "start_uuid", bVar.f519a);
                    C0745a.m466a(m657a, "filters", "crash_thread_name", m657a.optString("crash_thread_name", "unknown"));
                    if (z2) {
                        try {
                            AbstractC0768c.a aVar2 = new AbstractC0768c.a(m657a, CrashType.NATIVE);
                            File m500a = C0746b.m500a(file);
                            JSONArray jSONArray = null;
                            try {
                                if (m500a.exists()) {
                                    jSONArray = new JSONArray(C0786i.m803c(m500a));
                                }
                            } catch (Throwable unused) {
                            }
                            if (jSONArray == null) {
                                jSONArray = C0835p.m1198a().m1211b(aVar2.m683b() == -1 ? System.currentTimeMillis() : aVar2.m683b());
                            }
                            C0746b.m508a(m657a, C0746b.m504a(aVar2.m684c(), aVar2.m682a(), jSONArray), new C0746b.a() { // from class: com.apm.lite.j.b.4
                                @Override // com.apm.lite.p016d.C0746b.a
                                /* renamed from: a */
                                public void mo413a(JSONObject jSONObject) {
                                    C0769d.m685a().m687a(jSONObject, file, C0792o.m847a(C0767b.this.f498a, bVar.f519a));
                                }
                            });
                            if (!c0805c.m987k()) {
                                c0805c.m985h();
                            }
                            C0826g.m1143a(C0792o.m852b(C0749e.m565g(), bVar.f519a), file.getName());
                        } catch (Throwable th4) {
                            th = th4;
                            C0738c.m435a();
                            C0738c.m436a("NPTH_CATCH", th);
                            C0786i.m796a(file);
                            m885b = z2;
                        }
                    }
                    AbstractC0768c.m680a(CrashType.NATIVE, m657a);
                } else {
                    z2 = m885b;
                }
                m885b = z2;
            }
            z2 = m885b;
            c0805c.m987k();
            m885b = z2;
        }
    }

    /* renamed from: b */
    private void m668b(HashMap<String, b> hashMap, b bVar) {
        File[] listFiles = C0792o.m846a(this.f498a).listFiles();
        if (listFiles == null) {
            return;
        }
        Arrays.sort(listFiles, Collections.reverseOrder());
        for (File file : listFiles) {
            try {
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
            if (!C0739a.m438a().m442a(file.getAbsolutePath())) {
                if (!C0786i.m811g(file) && !C0750a.m581a().m604b(file.getName())) {
                    if (!file.isFile()) {
                        m664a(hashMap, bVar, file, file.getName());
                    }
                }
            }
            C0786i.m796a(file);
        }
    }

    /* renamed from: c */
    private void m670c(HashMap<String, b> hashMap, b bVar) {
        C0786i.m796a(C0792o.m851b(this.f498a));
    }

    /* renamed from: d */
    private void m671d() {
        if (this.f500d != null) {
            return;
        }
        this.f500d = new b("old_uuid");
        HashMap<String, b> hashMap = new HashMap<>();
        this.f501e = hashMap;
        m662a(hashMap);
        m668b(this.f501e, this.f500d);
        m670c(this.f501e, this.f500d);
        m663a(this.f501e, this.f500d);
        m666b(this.f500d, true, null);
        m659a(this.f500d, true, null);
        this.f500d = null;
        if (this.f501e.isEmpty()) {
            m673f();
        } else {
            m674g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m672e() {
        if (this.f502f || this.f501e == null) {
            return;
        }
        if (!C0793p.m885b(this.f498a)) {
            m673f();
        }
        boolean m675h = m675h();
        C0827h c0827h = new C0827h(this.f498a);
        Iterator<b> it = this.f501e.values().iterator();
        while (it.hasNext()) {
            m666b(it.next(), m675h, c0827h);
        }
        Iterator<b> it2 = this.f501e.values().iterator();
        while (it2.hasNext()) {
            m659a(it2.next(), m675h, c0827h);
        }
        Iterator<b> it3 = this.f501e.values().iterator();
        while (it3.hasNext()) {
            m658a(it3.next());
        }
        C0786i.m796a(C0792o.m878l(this.f498a));
        c0827h.m1147a();
        C0821b.m1107a();
        m673f();
    }

    /* renamed from: f */
    private void m673f() {
        this.f502f = true;
        this.f501e = null;
        NativeImpl.setUploadEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m674g() {
        if (this.f502f) {
            return;
        }
        if (!C0793p.m885b(this.f498a) || (System.currentTimeMillis() - C0749e.m568j() <= CoroutineLiveDataKt.DEFAULT_TIMEOUT && !Npth.hasCrash())) {
            C0832m.m1190b().m1239a(this.f503g, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        } else {
            m672e();
        }
    }

    /* renamed from: h */
    private boolean m675h() {
        if (this.f499c == -1) {
            if (C0810a.m1021b() && C0810a.m1028g()) {
                this.f499c = 1;
            } else {
                this.f499c = 0;
            }
        }
        return this.f499c == 1;
    }

    /* renamed from: i */
    private void m676i() {
        File[] listFiles = C0792o.m872i(this.f498a).listFiles();
        if (listFiles == null) {
            return;
        }
        for (int i = 0; i < listFiles.length && i < 5; i++) {
            File file = listFiles[i];
            if (file.getName().endsWith(".atmp")) {
                C0730a.m378a().m380a(file.getAbsolutePath());
            } else {
                try {
                    C0748d m808e = C0786i.m808e(file.getAbsolutePath());
                    if (m808e != null) {
                        if (m808e.m543b() != null) {
                            m808e.m543b().put("upload_scene", "launch_scan");
                        }
                        if (C0770e.m697a(C0770e.m708d(), m808e.m549e(), m808e.m547d(), m808e.m551f(), m808e.m552g())) {
                            C0786i.m796a(file);
                            C0786i.m797a(m808e.m545c());
                        }
                    } else {
                        C0786i.m796a(file);
                    }
                } catch (Throwable th) {
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th);
                }
            }
        }
    }

    /* renamed from: a */
    public void m677a(boolean z) {
        if (!Npth.isStopUpload() && z) {
            m671d();
            m676i();
        }
    }

    /* renamed from: b */
    public void m678b() {
        try {
            if (!this.f502f && C0778a.m746b(C0749e.m565g())) {
                C0832m.m1190b().m1238a(this.f504h);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public boolean m679c() {
        return this.f502f;
    }
}
