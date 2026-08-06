package com.apm.lite.p012b;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.ICrashCallback;
import com.apm.lite.Npth;
import com.apm.lite.nativecrash.C0805c;
import com.apm.lite.nativecrash.C0806d;
import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.p011a.C0730a;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p016d.C0746b;
import com.apm.lite.p016d.C0747c;
import com.apm.lite.p022j.C0769d;
import com.apm.lite.p022j.C0770e;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0779b;
import com.apm.lite.p023k.C0781d;
import com.apm.lite.p023k.C0783f;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0789l;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0795r;
import com.apm.lite.p023k.C0799v;
import com.apm.lite.runtime.C0810a;
import com.apm.lite.runtime.C0829j;
import com.apm.lite.runtime.C0831l;
import com.apm.lite.runtime.C0833n;
import com.apm.lite.runtime.C0834o;
import com.apm.lite.runtime.p024a.C0812b;
import com.apm.lite.runtime.p024a.C0815e;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.b.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0732a {

    /* renamed from: a */
    static volatile boolean f347a = true;

    /* renamed from: f */
    private static volatile boolean f348f;

    /* renamed from: c */
    private C0733b f355c;

    /* renamed from: d */
    private final Context f356d;

    /* renamed from: e */
    private volatile boolean f357e;

    /* renamed from: j */
    private JSONObject f361j;

    /* renamed from: k */
    private JSONObject f362k;

    /* renamed from: p */
    private JSONArray f367p;

    /* renamed from: q */
    private JSONObject f368q;

    /* renamed from: t */
    private JSONArray f371t;

    /* renamed from: u */
    private JSONArray f372u;

    /* renamed from: v */
    private JSONObject f373v;

    /* renamed from: w */
    private boolean f374w;

    /* renamed from: y */
    private volatile boolean f376y;

    /* renamed from: g */
    private long f358g = -1;

    /* renamed from: h */
    private File f359h = null;

    /* renamed from: i */
    private boolean f360i = true;

    /* renamed from: l */
    private String f363l = "unknown";

    /* renamed from: m */
    private String f364m = "unknown";

    /* renamed from: n */
    private String f365n = "unknown";

    /* renamed from: o */
    private String f366o = "npth_inner_default";

    /* renamed from: r */
    private int f369r = 0;

    /* renamed from: s */
    private long f370s = -1;

    /* renamed from: x */
    private final Object f375x = new Object();

    /* renamed from: z */
    private long f377z = -1;

    /* renamed from: A */
    private long f349A = 0;

    /* renamed from: B */
    private final Runnable f350B = new Runnable() { // from class: com.apm.lite.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                C0732a.this.m408a(200, 25);
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
        }
    };

    /* renamed from: C */
    private int f351C = 0;

    /* renamed from: D */
    private List<Pattern> f352D = null;

    /* renamed from: b */
    Pattern f354b = null;

    /* renamed from: E */
    private File f353E = null;

    public C0732a(Context context) {
        this.f356d = context;
    }

    /* renamed from: a */
    private static String m389a(float f) {
        return f <= 0.0f ? "0%" : f <= 0.1f ? "0% - 10%" : f <= 0.3f ? "10% - 30%" : f <= 0.6f ? "30% - 60%" : f <= 0.9f ? "60% - 90%" : "90% - 100%";
    }

    /* renamed from: a */
    private static String m390a(float f, float f2) {
        return f2 > 0.0f ? m389a(f / f2) : f > 0.0f ? "100%" : "0%";
    }

    /* renamed from: a */
    private JSONObject m391a(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray m817a = C0789l.m817a(256, 128, jSONArray);
        if (m817a.length() != jSONArray.length()) {
            this.f369r++;
        }
        try {
            jSONObject.put("thread_name", str);
            jSONObject.put("thread_stack", m817a);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0216, code lost:
    
        if (r8 != 5) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02db A[LOOP:2: B:91:0x01ff->B:121:0x02db, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03ae A[EDGE_INSN: B:122:0x03ae->B:123:0x03ae BREAK  A[LOOP:2: B:91:0x01ff->B:121:0x02db], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0402 A[EDGE_INSN: B:21:0x0402->B:22:0x0402 BREAK  A[LOOP:0: B:2:0x0039->B:8:0x03eb], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x03eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0202  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m392a(String str, JSONObject jSONObject) {
        HashMap hashMap;
        HashMap hashMap2;
        String[] strArr;
        int i;
        String str2;
        char c;
        char c2;
        char c3;
        int i2;
        boolean z;
        String str3;
        String trim;
        String str4;
        HashMap hashMap3;
        String str5;
        int i3;
        char c4;
        String[] strArr2;
        String str6;
        float floatValue;
        float floatValue2;
        C0732a c0732a = this;
        SystemClock.uptimeMillis();
        String[] split = str.split("\n");
        float[] fArr = {-1.0f, -1.0f, -1.0f};
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        HashMap hashMap6 = new HashMap();
        HashMap hashMap7 = new HashMap();
        HashMap hashMap8 = new HashMap();
        int length = split.length;
        String str7 = "unknown";
        String str8 = "unknown";
        String str9 = str8;
        int i4 = 0;
        char c5 = 0;
        boolean z2 = false;
        while (true) {
            if (i4 >= length) {
                hashMap = hashMap7;
                hashMap2 = hashMap8;
                break;
            }
            String str10 = split[i4];
            if (!TextUtils.isEmpty(str10)) {
                strArr = split;
                i = length;
                if (c5 != 0) {
                    str2 = str7;
                    if (c5 == 1) {
                        hashMap = hashMap7;
                        hashMap2 = hashMap8;
                        c = c5;
                        i2 = 0;
                        str10 = str10.trim();
                        String lowerCase = str10.toLowerCase();
                        if (lowerCase.startsWith("shortmsg")) {
                            str10.substring(str10.indexOf(58));
                            z = false;
                        } else if (lowerCase.startsWith("reason:")) {
                            str10.substring(str10.indexOf(58));
                            z = true;
                        } else {
                            c2 = 3;
                            if (lowerCase.contains("appfreeze")) {
                                str9 = "AppFreeze";
                                c5 = '\n';
                                c3 = 4;
                            }
                            c5 = c;
                            c3 = 4;
                        }
                        if (lowerCase.contains("input dispatch")) {
                            str3 = "Input dispatching timed out";
                        } else if (lowerCase.contains("broadcast of intent")) {
                            str3 = "Broadcast of Intent";
                        } else {
                            if (lowerCase.contains("executing service")) {
                                if ("null".equalsIgnoreCase(str8)) {
                                    str8 = str10.substring(str10.indexOf("service ") + 8).trim();
                                }
                                str9 = "executing service";
                            } else if (lowerCase.contains("service.startforeground")) {
                                str3 = "not call Service.startForeground";
                            } else {
                                str9 = str2;
                            }
                            if (z) {
                                c3 = 4;
                                c2 = 3;
                                c5 = 2;
                            }
                            trim = str10.trim();
                            if (trim.startsWith("Load:")) {
                            }
                            c2 = 3;
                            c5 = c;
                            c3 = 4;
                        }
                        str9 = str3;
                        if (z) {
                        }
                        trim = str10.trim();
                        if (trim.startsWith("Load:")) {
                        }
                        c2 = 3;
                        c5 = c;
                        c3 = 4;
                    } else if (c5 != 2) {
                        if (c5 != 3) {
                            hashMap = hashMap7;
                            hashMap2 = hashMap8;
                            c2 = 3;
                            c = c5;
                        } else {
                            String[] split2 = str10.split("\\s");
                            c = c5;
                            if (split2.length < 2) {
                                hashMap = hashMap7;
                                hashMap2 = hashMap8;
                                c2 = 3;
                            } else {
                                if ("CPU".equalsIgnoreCase(split2[0]) && "usage".equalsIgnoreCase(split2[1])) {
                                    if (str10.contains("ago")) {
                                        z2 = true;
                                    }
                                    if (hashMap4.isEmpty() && hashMap5.isEmpty() && hashMap6.isEmpty() && hashMap8.isEmpty() && hashMap7.isEmpty()) {
                                        hashMap = hashMap7;
                                        hashMap2 = hashMap8;
                                        c5 = c;
                                        c3 = 4;
                                        c2 = 3;
                                    }
                                } else if (hashMap4.isEmpty() || hashMap5.isEmpty() || hashMap6.isEmpty() || hashMap8.isEmpty() || hashMap7.isEmpty()) {
                                    if (hashMap4.isEmpty() && split2[1].equalsIgnoreCase("TOTAL:")) {
                                        str4 = "";
                                        hashMap3 = hashMap4;
                                    } else if (str10.contains(c0732a.f356d.getPackageName())) {
                                        str4 = "";
                                        int i5 = 0;
                                        while (i5 < split2.length) {
                                            if (split2[i5].contains(c0732a.f356d.getPackageName())) {
                                                StringBuilder sb = new StringBuilder();
                                                String str11 = split2[i5];
                                                str4 = sb.append(str11.substring(str11.indexOf(47) + 1, split2[i5].length() - 1)).append('_').toString();
                                            }
                                            i5++;
                                            c0732a = this;
                                        }
                                        hashMap3 = hashMap6;
                                    } else if (hashMap5.isEmpty() && str10.contains("system_server:")) {
                                        str4 = "";
                                        hashMap3 = hashMap5;
                                    } else if (hashMap8.isEmpty() && str10.contains("kswapd")) {
                                        str4 = "";
                                        hashMap3 = hashMap8;
                                    } else if (hashMap7.isEmpty() && str10.contains("dex2oat")) {
                                        str4 = "";
                                        hashMap3 = hashMap7;
                                    } else {
                                        str4 = "";
                                        hashMap3 = null;
                                    }
                                    if (hashMap3 != null) {
                                        int i6 = 0;
                                        try {
                                            do {
                                                str5 = "%";
                                                if (!split2[i6].contains("%")) {
                                                    i6++;
                                                }
                                                break;
                                            } while (i6 < split2.length);
                                            break;
                                            floatValue2 = Float.valueOf(split2[i6].replace("%", "")).floatValue();
                                            hashMap = hashMap7;
                                        } catch (Throwable unused) {
                                            hashMap = hashMap7;
                                        }
                                        try {
                                            String str12 = str4 + "total";
                                            if (hashMap3 == hashMap4) {
                                                hashMap2 = hashMap8;
                                            } else {
                                                hashMap2 = hashMap8;
                                                try {
                                                    floatValue2 /= C0781d.m768e();
                                                } catch (Throwable unused2) {
                                                    hashMap3.put(str4 + "total", Float.valueOf(-1.0f));
                                                    i3 = i6 + 3;
                                                    char c6 = 0;
                                                    while (i3 < split2.length) {
                                                    }
                                                    c2 = 3;
                                                    c5 = c;
                                                    c3 = 4;
                                                    if (c5 >= c3) {
                                                    }
                                                }
                                            }
                                            hashMap3.put(str12, Float.valueOf(floatValue2));
                                        } catch (Throwable unused3) {
                                            hashMap2 = hashMap8;
                                            hashMap3.put(str4 + "total", Float.valueOf(-1.0f));
                                            i3 = i6 + 3;
                                            char c62 = 0;
                                            while (i3 < split2.length) {
                                            }
                                            c2 = 3;
                                            c5 = c;
                                            c3 = 4;
                                            if (c5 >= c3) {
                                            }
                                        }
                                        i3 = i6 + 3;
                                        char c622 = 0;
                                        while (i3 < split2.length) {
                                            String str13 = "softirq";
                                            if (c622 == 0) {
                                                c4 = c622;
                                                if ("user".equalsIgnoreCase(split2[i3])) {
                                                    str13 = "user";
                                                    c622 = 1;
                                                    if (str13 == null) {
                                                    }
                                                    if (c622 < 6) {
                                                    }
                                                }
                                            } else if (c622 == 1) {
                                                c4 = c622;
                                            } else if (c622 == 2) {
                                                c4 = c622;
                                                if ("iowait".equalsIgnoreCase(split2[i3])) {
                                                    str13 = "iowait";
                                                    c622 = 3;
                                                    if (str13 == null) {
                                                    }
                                                    if (c622 < 6) {
                                                    }
                                                }
                                                if ("irq".equalsIgnoreCase(split2[i3])) {
                                                }
                                                if ("softirq".equalsIgnoreCase(split2[i3])) {
                                                }
                                                if ("softirq".equalsIgnoreCase(split2[i3])) {
                                                }
                                                c622 = c4;
                                                str13 = null;
                                                if (str13 == null) {
                                                }
                                                if (c622 < 6) {
                                                }
                                            } else if (c622 == 3) {
                                                c4 = c622;
                                                if ("irq".equalsIgnoreCase(split2[i3])) {
                                                    str13 = "irq";
                                                    c622 = 4;
                                                    if (str13 == null) {
                                                    }
                                                    if (c622 < 6) {
                                                    }
                                                }
                                                if ("softirq".equalsIgnoreCase(split2[i3])) {
                                                }
                                                if ("softirq".equalsIgnoreCase(split2[i3])) {
                                                }
                                                c622 = c4;
                                                str13 = null;
                                                if (str13 == null) {
                                                }
                                                if (c622 < 6) {
                                                }
                                            } else if (c622 != 4) {
                                                c4 = c622;
                                            } else {
                                                c4 = c622;
                                                if ("softirq".equalsIgnoreCase(split2[i3])) {
                                                    c622 = 5;
                                                    if (str13 == null) {
                                                        try {
                                                            floatValue = Float.valueOf(split2[i3 - 1].replace(str5, "")).floatValue();
                                                            strArr2 = split2;
                                                        } catch (Throwable unused4) {
                                                            strArr2 = split2;
                                                        }
                                                        try {
                                                            String str14 = str4 + str13;
                                                            if (hashMap3 == hashMap4) {
                                                                str6 = str5;
                                                            } else {
                                                                str6 = str5;
                                                                try {
                                                                    floatValue /= C0781d.m768e();
                                                                } catch (Throwable unused5) {
                                                                    hashMap3.put(str4 + str13, Float.valueOf(-1.0f));
                                                                    if (c622 < 6) {
                                                                    }
                                                                }
                                                            }
                                                            hashMap3.put(str14, Float.valueOf(floatValue));
                                                        } catch (Throwable unused6) {
                                                            str6 = str5;
                                                            hashMap3.put(str4 + str13, Float.valueOf(-1.0f));
                                                            if (c622 < 6) {
                                                            }
                                                        }
                                                    } else {
                                                        strArr2 = split2;
                                                        str6 = str5;
                                                    }
                                                    if (c622 < 6) {
                                                        break;
                                                    }
                                                    i3 += 3;
                                                    split2 = strArr2;
                                                    str5 = str6;
                                                }
                                                if ("softirq".equalsIgnoreCase(split2[i3])) {
                                                    c622 = 6;
                                                    if (str13 == null) {
                                                    }
                                                    if (c622 < 6) {
                                                    }
                                                }
                                                c622 = c4;
                                                str13 = null;
                                                if (str13 == null) {
                                                }
                                                if (c622 < 6) {
                                                }
                                            }
                                            if ("kernel".equalsIgnoreCase(split2[i3])) {
                                                str13 = "kernel";
                                                c622 = 2;
                                                if (str13 == null) {
                                                }
                                                if (c622 < 6) {
                                                }
                                            }
                                            if ("iowait".equalsIgnoreCase(split2[i3])) {
                                            }
                                            if ("irq".equalsIgnoreCase(split2[i3])) {
                                            }
                                            if ("softirq".equalsIgnoreCase(split2[i3])) {
                                            }
                                            if ("softirq".equalsIgnoreCase(split2[i3])) {
                                            }
                                            c622 = c4;
                                            str13 = null;
                                            if (str13 == null) {
                                            }
                                            if (c622 < 6) {
                                            }
                                        }
                                    } else {
                                        hashMap = hashMap7;
                                        hashMap2 = hashMap8;
                                    }
                                    c2 = 3;
                                    c5 = c;
                                    c3 = 4;
                                }
                                hashMap = hashMap7;
                                hashMap2 = hashMap8;
                                c3 = 4;
                                c2 = 3;
                                c5 = 4;
                            }
                        }
                        c5 = c;
                        c3 = 4;
                    } else {
                        hashMap = hashMap7;
                        hashMap2 = hashMap8;
                        c = c5;
                        i2 = 0;
                        trim = str10.trim();
                        if (trim.startsWith("Load:")) {
                            String[] split3 = trim.replace("Load:", "").trim().split("/");
                            c2 = 3;
                            if (3 == split3.length) {
                                for (int i7 = i2; i7 < split3.length; i7++) {
                                    fArr[i7] = Float.valueOf(split3[i7]).floatValue();
                                }
                            }
                            c5 = 3;
                            c3 = 4;
                        }
                        c2 = 3;
                        c5 = c;
                        c3 = 4;
                    }
                } else {
                    hashMap = hashMap7;
                    hashMap2 = hashMap8;
                    str2 = str7;
                    c = c5;
                    c2 = 3;
                    String trim2 = str10.trim();
                    if (trim2.startsWith("tag:")) {
                        str8 = trim2.replace("tag:", "").trim();
                        c3 = 4;
                        c5 = 1;
                    }
                    c5 = c;
                    c3 = 4;
                }
                if (c5 >= c3) {
                    break;
                }
            } else {
                strArr = split;
                hashMap = hashMap7;
                hashMap2 = hashMap8;
                i = length;
                str2 = str7;
                c2 = 3;
            }
            i4++;
            c0732a = this;
            split = strArr;
            length = i;
            str7 = str2;
            hashMap7 = hashMap;
            hashMap8 = hashMap2;
        }
        jSONObject.put("anr_tag", str8);
        jSONObject.put("anr_has_ago", String.valueOf(z2));
        jSONObject.put("anr_reason", str9);
        m393a(hashMap6, jSONObject, "app");
        m393a(hashMap4, jSONObject, "total");
        if (hashMap5.isEmpty()) {
            jSONObject.put("npth_anr_systemserver_total", "not found");
        } else {
            jSONObject.put("npth_anr_systemserver_total", m398b(C0795r.m894a(hashMap5).floatValue()));
        }
        if (hashMap2.isEmpty()) {
            jSONObject.put("npth_anr_kswapd_total", "not found");
        } else {
            jSONObject.put("npth_anr_kswapd_total", m398b(C0795r.m894a(hashMap2).floatValue()));
        }
        if (hashMap.isEmpty()) {
            jSONObject.put("npth_anr_dex2oat_total", "not found");
        } else {
            jSONObject.put("npth_anr_dex2oat_total", m398b(C0795r.m894a(hashMap).floatValue()));
        }
    }

    /* renamed from: a */
    private static void m393a(HashMap<String, Float> hashMap, JSONObject jSONObject, String str) {
        String str2;
        String m390a;
        String str3 = "npth_anr_" + str;
        if (hashMap.isEmpty()) {
            str2 = str3 + "_total";
            m390a = "not found";
        } else {
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            for (Map.Entry<String, Float> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                if (key.endsWith("user")) {
                    f += entry.getValue().floatValue();
                } else if (key.endsWith("kernel")) {
                    f2 += entry.getValue().floatValue();
                } else if (key.endsWith("iowait")) {
                    f3 += entry.getValue().floatValue();
                } else if (key.endsWith("irq")) {
                    f4 += entry.getValue().floatValue();
                } else if (key.endsWith("softirq")) {
                    f5 += entry.getValue().floatValue();
                }
            }
            float f6 = f + f2 + f3 + f4 + f5;
            jSONObject.put(str3 + "_total", m398b(f6));
            jSONObject.put(str3 + "_kernel_user_ratio", m390a(f2, f6));
            str2 = str3 + "_iowait_user_ratio";
            m390a = m390a(f3, f6);
        }
        jSONObject.put(str2, m390a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x018a, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0150 A[Catch: all -> 0x0177, TRY_LEAVE, TryCatch #3 {all -> 0x0177, blocks: (B:93:0x0142, B:95:0x0150), top: B:92:0x0142 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m394a(JSONArray jSONArray) {
        int[] iArr;
        int[] iArr2;
        if (jSONArray == null) {
            return;
        }
        this.f361j = null;
        this.f368q = null;
        this.f369r = 0;
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        this.f363l = "unknown";
        this.f364m = "unknown";
        this.f365n = "unknown";
        int[] iArr3 = {0, 0, 0};
        JSONArray jSONArray5 = jSONArray4;
        String str = null;
        boolean z = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (TextUtils.isEmpty(optString)) {
                if (jSONArray5.length() > 0 && !TextUtils.isEmpty(str)) {
                    if (this.f361j == null && "main".equals(str)) {
                        this.f361j = m403c(jSONArray5);
                    } else {
                        jSONArray2.put(m391a(str, jSONArray5));
                    }
                    try {
                        if (!"main".equals(str)) {
                            str = str.substring(0, str.indexOf(40)).trim();
                        }
                    } catch (Throwable unused) {
                    }
                    String str2 = str;
                    if (!m397a(str2)) {
                        try {
                            iArr2 = m401b(jSONArray5);
                        } catch (IllegalArgumentException e) {
                            C0738c.m435a();
                            C0738c.m436a("NPTH_CATCH", e);
                            iArr2 = null;
                            if (iArr2 != null) {
                            }
                            if (jSONArray5.length() > 0) {
                            }
                            str = null;
                        } catch (Throwable unused2) {
                            iArr2 = null;
                            if (iArr2 != null) {
                            }
                            if (jSONArray5.length() > 0) {
                            }
                            str = null;
                        }
                        if (iArr2 != null) {
                            int i2 = iArr2[0];
                            if (i2 > iArr3[0]) {
                                iArr3[0] = i2;
                                this.f363l = str2;
                            }
                            int i3 = iArr2[1];
                            if (i3 > iArr3[1]) {
                                iArr3[1] = i3;
                                this.f364m = str2;
                            }
                            int i4 = iArr2[2];
                            if (i4 > iArr3[2]) {
                                iArr3[2] = i4;
                                this.f365n = str2;
                            }
                        }
                    }
                }
                if (jSONArray5.length() > 0) {
                    jSONArray5 = new JSONArray();
                }
                str = null;
            } else {
                if (z) {
                    if (z) {
                        if (optString.contains(" prio=")) {
                            if (jSONArray5.length() > 0 && !TextUtils.isEmpty(str)) {
                                if (this.f361j == null && "main".equals(str)) {
                                    this.f361j = m403c(jSONArray5);
                                } else {
                                    jSONArray2.put(m391a(str, jSONArray5));
                                }
                                try {
                                    if (!"main".equals(str)) {
                                        str = str.substring(0, str.indexOf(40)).trim();
                                    }
                                } catch (Throwable unused3) {
                                }
                                String str3 = str;
                                if (!m397a(str3)) {
                                    try {
                                        iArr = m401b(jSONArray5);
                                    } catch (IllegalArgumentException e2) {
                                        C0738c.m435a();
                                        C0738c.m436a("NPTH_CATCH", e2);
                                        iArr = null;
                                        if (iArr != null) {
                                        }
                                        str = str3;
                                        str = optString.substring(1, optString.indexOf(34, 1));
                                        if (!"main".equals(str)) {
                                        }
                                        if (jSONArray5.length() > 0) {
                                        }
                                        jSONArray5.put(optString);
                                    } catch (Throwable unused4) {
                                        iArr = null;
                                        if (iArr != null) {
                                        }
                                        str = str3;
                                        str = optString.substring(1, optString.indexOf(34, 1));
                                        if (!"main".equals(str)) {
                                        }
                                        if (jSONArray5.length() > 0) {
                                        }
                                        jSONArray5.put(optString);
                                    }
                                    if (iArr != null) {
                                        int i5 = iArr[0];
                                        if (i5 > iArr3[0]) {
                                            iArr3[0] = i5;
                                            this.f363l = str3;
                                        }
                                        int i6 = iArr[1];
                                        if (i6 > iArr3[1]) {
                                            iArr3[1] = i6;
                                            this.f364m = str3;
                                        }
                                        int i7 = iArr[2];
                                        if (i7 > iArr3[2]) {
                                            iArr3[2] = i7;
                                            this.f365n = str3;
                                        }
                                    }
                                }
                                str = str3;
                            }
                            try {
                                str = optString.substring(1, optString.indexOf(34, 1));
                                if (!"main".equals(str)) {
                                    str = str + "  (" + optString.substring(optString.indexOf(34, 2) + 1) + " )";
                                }
                            } catch (Throwable unused5) {
                            }
                            if (jSONArray5.length() > 0) {
                                jSONArray5 = new JSONArray();
                            }
                        }
                        jSONArray5.put(optString);
                    }
                } else if (optString.startsWith("DALVIK THREADS") || optString.startsWith("suspend") || optString.startsWith("\"")) {
                    z = true;
                }
                jSONArray3.put(optString);
            }
        }
        if (jSONArray2.length() > 0) {
            this.f367p = jSONArray3;
            try {
                JSONObject jSONObject = new JSONObject();
                this.f368q = jSONObject;
                jSONObject.put("thread_all_count", jSONArray2.length());
                this.f368q.put("thread_stacks", jSONArray2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private boolean m395a(long j) {
        if (this.f376y) {
            this.f376y = false;
            m399b(j);
        }
        return false;
    }

    /* renamed from: a */
    private boolean m397a(String str) {
        if (this.f352D == null) {
            JSONArray m1023c = C0810a.m1023c();
            if (m1023c != null) {
                this.f352D = new LinkedList();
                this.f366o = m1023c.optString(0);
                for (int i = 1; i < m1023c.length(); i++) {
                    try {
                        this.f352D.add(Pattern.compile(m1023c.optString(i)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.f352D == null) {
                LinkedList linkedList = new LinkedList();
                this.f352D = linkedList;
                linkedList.add(Pattern.compile("^main$"));
                this.f352D.add(Pattern.compile("^default_npth_thread$"));
                this.f352D.add(Pattern.compile("^RenderThread$"));
                this.f352D.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        Iterator<Pattern> it = this.f352D.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static String m398b(float f) {
        return m389a(f / 100.0f);
    }

    /* renamed from: b */
    private void m399b(long j) {
        if (this.f349A != this.f377z) {
            try {
                this.f370s = System.currentTimeMillis();
                this.f372u = C0735d.m427a();
                this.f371t = C0737f.m434a(100, j);
                this.f362k = C0735d.m428a(j);
                JSONObject jSONObject = new JSONObject();
                this.f373v = jSONObject;
                C0778a.m739a(this.f356d, jSONObject);
                this.f374w = m404f();
                this.f360i = !Npth.hasCrash();
            } catch (Throwable unused) {
            }
            try {
                this.f358g = this.f370s;
                String m855b = C0792o.m855b();
                File file = new File(new File(C0792o.m865f(this.f356d), m855b), "trace_" + C0778a.m748c(this.f356d).replace(':', '_') + ".txt");
                file.getParentFile().mkdirs();
                C0786i.m788a(file, C0779b.m753a().format(new Date(System.currentTimeMillis())) + "\n", false);
                C0834o.m1195a("anr_trace", m855b);
                NativeImpl.doDumpAllThread(file.getAbsolutePath());
                try {
                    JSONArray m799b = C0786i.m799b(file.getAbsolutePath());
                    this.f367p = m799b;
                    m394a(m799b);
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th);
                }
                if (this.f361j == null) {
                    this.f361j = C0734c.m422a(true);
                }
            } catch (Throwable th2) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th2);
            }
            C0783f.m771a();
        } else {
            try {
                this.f358g = this.f370s;
                String m855b2 = C0792o.m855b();
                File file2 = new File(new File(C0792o.m865f(this.f356d), m855b2), "trace" + C0778a.m748c(this.f356d).replace(':', '_') + ".txt");
                file2.getParentFile().mkdirs();
                C0786i.m788a(file2, C0779b.m753a().format(new Date(System.currentTimeMillis())) + "\n", false);
                C0834o.m1195a("anr_trace", m855b2);
                NativeImpl.doDumpAllThread(file2.getAbsolutePath());
                try {
                    JSONArray m799b2 = C0786i.m799b(file2.getAbsolutePath());
                    this.f367p = m799b2;
                    m394a(m799b2);
                } catch (IOException unused3) {
                } catch (Throwable th3) {
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th3);
                }
                if (this.f361j == null) {
                    this.f361j = C0734c.m422a(true);
                }
            } catch (Throwable th4) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th4);
            }
        }
        long j2 = this.f377z;
        this.f349A = j2;
        this.f377z = -1L;
        if (j2 == -1) {
            this.f349A = (-1) - 1;
        }
    }

    /* renamed from: b */
    private static void m400b(String str) {
        Iterator<ICrashCallback> it = C0831l.m1159a().m1118e().iterator();
        while (it.hasNext()) {
            try {
                it.next().onCrash(CrashType.ANR, str, null);
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
        }
    }

    /* renamed from: b */
    private int[] m401b(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            int indexOf = (optString == null || optString.isEmpty()) ? -1 : optString.indexOf("utm=");
            if (indexOf > 0) {
                if (this.f354b == null) {
                    this.f354b = Pattern.compile("[^0-9]+");
                }
                String[] split = this.f354b.split(optString.substring(indexOf));
                if (split == null || split.length < 2) {
                    return null;
                }
                int intValue = Integer.decode(split[1]).intValue();
                int intValue2 = Integer.decode(split[2]).intValue();
                return new int[]{intValue, intValue2, intValue + intValue2};
            }
        }
        return null;
    }

    /* renamed from: c */
    private String m402c(long j) {
        long m568j = j - C0749e.m568j();
        return m568j < 30000 ? "0 - 30s" : m568j < 60000 ? "30s - 1min" : m568j < 120000 ? "1min - 2min" : m568j < 300000 ? "2min - 5min" : m568j < 600000 ? "5min - 10min" : m568j < 1800000 ? "10min - 30min" : m568j < 3600000 ? "30min - 1h" : "1h - ";
    }

    /* renamed from: c */
    private JSONObject m403c(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray m817a = C0789l.m817a(256, 128, jSONArray);
        if (m817a.length() != jSONArray.length()) {
            this.f369r++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m817a.length(); i++) {
                sb.append(m817a.getString(i)).append('\n');
            }
            jSONObject.put("mainStackFromTrace", sb.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: f */
    private boolean m404f() {
        boolean z = !C0778a.m743a(this.f356d);
        if (!z || C0812b.m1057d().m1083e() > 2000) {
            return z;
        }
        return false;
    }

    /* renamed from: g */
    private File m405g() {
        if (this.f353E == null) {
            this.f353E = new File(this.f356d.getFilesDir(), "has_anr_signal_" + C0778a.m748c(this.f356d).replaceAll(":", "_"));
        }
        return this.f353E;
    }

    /* renamed from: h */
    private boolean m406h() {
        return C0810a.m1029h();
    }

    /* renamed from: a */
    public void m407a() {
        if (this.f357e) {
            return;
        }
        this.f355c = new C0733b(this);
        this.f358g = C0749e.m568j();
        this.f357e = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03c9 A[Catch: all -> 0x046e, TRY_ENTER, TryCatch #3 {all -> 0x046e, blocks: (B:45:0x017f, B:48:0x01f9, B:50:0x01fe, B:53:0x0207, B:55:0x020b, B:57:0x0211, B:58:0x0219, B:79:0x03c9, B:80:0x03f2, B:82:0x03f6, B:83:0x03fc, B:94:0x0452, B:124:0x0217), top: B:44:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03f2 A[Catch: all -> 0x046e, TryCatch #3 {all -> 0x046e, blocks: (B:45:0x017f, B:48:0x01f9, B:50:0x01fe, B:53:0x0207, B:55:0x020b, B:57:0x0211, B:58:0x0219, B:79:0x03c9, B:80:0x03f2, B:82:0x03f6, B:83:0x03fc, B:94:0x0452, B:124:0x0217), top: B:44:0x017f }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean m408a(int i, int i2) {
        boolean z;
        boolean z2;
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        boolean z3;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        boolean z4;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z5;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONArray jSONArray4;
        JSONObject jSONObject6;
        String str5;
        JSONObject jSONObject7;
        JSONArray jSONArray5;
        boolean m433a = C0736e.m433a();
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean m395a = m395a(uptimeMillis);
        String m421a = C0734c.m421a(this.f356d, 1);
        final long currentTimeMillis = System.currentTimeMillis();
        String str6 = "normal";
        boolean z6 = TextUtils.isEmpty(m421a) && m395a;
        if (m395a || !TextUtils.isEmpty(m421a)) {
            synchronized (this.f375x) {
                z = !z6;
            }
            if (this.f361j != null) {
                z2 = z;
                if (System.currentTimeMillis() - this.f358g <= 20000) {
                    str6 = z6 ? "trace_only" : "trace_last";
                    JSONObject jSONObject8 = this.f361j;
                    String str7 = this.f363l;
                    String str8 = this.f364m;
                    String str9 = this.f365n;
                    JSONArray jSONArray6 = this.f367p;
                    JSONArray jSONArray7 = this.f372u;
                    jSONArray = this.f371t;
                    jSONObject = this.f373v;
                    jSONObject2 = jSONObject8;
                    jSONObject3 = this.f362k;
                    boolean z7 = this.f374w;
                    long j = this.f370s;
                    z3 = z7;
                    if (!z6) {
                        this.f361j = null;
                        this.f367p = null;
                        this.f371t = null;
                        this.f362k = null;
                        this.f372u = null;
                        this.f363l = "unknown";
                        this.f364m = "unknown";
                        this.f365n = "unknown";
                        this.f369r = 0;
                    }
                    jSONArray2 = jSONArray6;
                    jSONArray3 = jSONArray7;
                    String str10 = str6;
                    z4 = z2;
                    currentTimeMillis = j;
                    str = str9;
                    str2 = str8;
                    str3 = str7;
                    str4 = str10;
                }
            } else {
                z2 = z;
            }
            if (this.f376y) {
                this.f376y = false;
                str6 = "trace_after";
            }
            m399b(uptimeMillis);
            JSONObject jSONObject82 = this.f361j;
            String str72 = this.f363l;
            String str82 = this.f364m;
            String str92 = this.f365n;
            JSONArray jSONArray62 = this.f367p;
            JSONArray jSONArray72 = this.f372u;
            jSONArray = this.f371t;
            jSONObject = this.f373v;
            jSONObject2 = jSONObject82;
            jSONObject3 = this.f362k;
            boolean z72 = this.f374w;
            long j2 = this.f370s;
            z3 = z72;
            if (!z6) {
            }
            jSONArray2 = jSONArray62;
            jSONArray3 = jSONArray72;
            String str102 = str6;
            z4 = z2;
            currentTimeMillis = j2;
            str = str92;
            str2 = str82;
            str3 = str72;
            str4 = str102;
        } else {
            z3 = false;
            str = "unknown";
            jSONArray2 = null;
            jSONArray = null;
            jSONObject2 = null;
            jSONObject3 = null;
            jSONArray3 = null;
            str2 = "unknown";
            jSONObject = null;
            str3 = "unknown";
            str4 = "normal";
            z4 = false;
        }
        if (!z6 && TextUtils.isEmpty(m421a)) {
            if (this.f361j == null || System.currentTimeMillis() - this.f358g <= 20000) {
                if (this.f361j == null || System.currentTimeMillis() - this.f358g <= 2000 || !NativeImpl.isResendSigQuit()) {
                    return false;
                }
                C0786i.m796a(m405g());
                return false;
            }
            this.f361j = null;
            this.f367p = null;
            this.f371t = null;
            this.f362k = null;
            this.f372u = null;
            this.f363l = "unknown";
            this.f364m = "unknown";
            this.f365n = "unknown";
            this.f369r = 0;
            File file = this.f359h;
            if (file != null) {
                C0786i.m796a(file);
            }
            this.f359h = null;
            return false;
        }
        if (jSONObject2 == null) {
            if (jSONArray == null) {
                try {
                    jSONArray5 = C0735d.m427a();
                    JSONObject jSONObject9 = jSONObject;
                    try {
                        jSONArray = C0737f.m434a(100, uptimeMillis);
                        jSONObject3 = C0735d.m428a(uptimeMillis);
                        JSONObject jSONObject10 = new JSONObject();
                        try {
                            C0778a.m739a(this.f356d, jSONObject10);
                            jSONObject = jSONObject10;
                        } catch (Throwable unused) {
                            jSONObject = jSONObject10;
                        }
                    } catch (Throwable unused2) {
                        jSONObject = jSONObject9;
                    }
                } catch (Throwable unused3) {
                    jSONArray5 = jSONArray3;
                }
            } else {
                jSONArray5 = jSONArray3;
            }
            try {
                jSONObject2 = C0734c.m422a(f347a);
            } catch (Throwable unused4) {
            }
            jSONArray4 = jSONArray5;
            jSONObject4 = jSONObject2;
            z5 = z4;
            jSONObject5 = jSONObject3;
        } else {
            z5 = z4;
            jSONObject4 = jSONObject2;
            jSONObject5 = jSONObject3;
            jSONArray4 = jSONArray3;
        }
        if (jSONObject4 != null && jSONObject4.length() > 0) {
            try {
                jSONObject4.put("pid", Process.myPid());
                jSONObject4.put("package", this.f356d.getPackageName());
                jSONObject4.put("is_remote_process", 0);
                jSONObject4.put("is_new_stack", 10);
                C0745a c0745a = new C0745a(new JSONObject());
                String str11 = str;
                c0745a.m484a(Constants.KEY_DATA, (Object) jSONObject4.toString());
                JSONObject jSONObject11 = jSONObject4;
                boolean z8 = true;
                c0745a.m484a("is_anr", (Object) 1);
                c0745a.m484a("anrType", (Object) str4);
                c0745a.m484a("history_message", (Object) jSONArray4);
                c0745a.m484a("current_message", jSONObject5);
                c0745a.m484a("pending_messages", (Object) jSONArray);
                c0745a.m484a("anr_time", Long.valueOf(System.currentTimeMillis()));
                c0745a.m484a("crash_time", Long.valueOf(currentTimeMillis));
                c0745a.m492c(jSONObject);
                c0745a.m484a("anr_info", (Object) (z6 ? "no anr info" : m421a));
                if (jSONArray2 != null) {
                    c0745a.m484a("dump_trace", (Object) jSONArray2);
                }
                c0745a.m484a("all_thread_stacks", (z6 || !((jSONObject7 = this.f368q) == null || jSONObject7.length() == 0)) ? this.f368q : C0799v.m933b((String) null));
                C0745a m1104a = C0815e.m1103a().m1104a(CrashType.ANR, c0745a);
                m1104a.m484a("is_background", Boolean.valueOf(z3));
                m1104a.m484a("logcat", (Object) C0829j.m1151b(C0749e.m564f()));
                m1104a.m484a("has_dump", (Object) "true");
                m1104a.m484a("crash_uuid", (Object) C0749e.m554a(currentTimeMillis, CrashType.ANR, false, false));
                m1104a.m484a("jiffy", Long.valueOf(C0833n.a.m1191a()));
                JSONObject optJSONObject = m1104a.m498h().optJSONObject("filters");
                if (optJSONObject == null) {
                    try {
                        jSONObject6 = new JSONObject();
                        try {
                            m1104a.m484a("filters", jSONObject6);
                        } catch (Throwable unused5) {
                            optJSONObject = jSONObject6;
                            str5 = m421a;
                            jSONObject6 = optJSONObject;
                            if (z6) {
                            }
                            return z5;
                        }
                    } catch (Throwable unused6) {
                        str5 = m421a;
                        jSONObject6 = optJSONObject;
                        if (z6) {
                        }
                        return z5;
                    }
                } else {
                    jSONObject6 = optJSONObject;
                }
                try {
                    jSONObject6.put("anrType", str4);
                    jSONObject6.put("max_utm_thread", str3);
                    jSONObject6.put("max_stm_thread", str2);
                    jSONObject6.put("max_utm_stm_thread", str11);
                    jSONObject6.put("max_utm_thread_version", this.f366o);
                    jSONObject6.put("crash_length", m402c(currentTimeMillis));
                    jSONObject6.put("disable_looper_monitor", String.valueOf(C0810a.m1025d()));
                    jSONObject6.put("sdk_version", "0.0.2");
                    jSONObject6.put("has_logcat", String.valueOf(m1104a.m485a()));
                    jSONObject6.put("memory_leak", String.valueOf(m1104a.m496f()));
                    jSONObject6.put("fd_leak", String.valueOf(m1104a.m493d()));
                    jSONObject6.put("threads_leak", String.valueOf(m1104a.m495e()));
                    jSONObject6.put("is_64_devices", String.valueOf(C0747c.m516a()));
                    jSONObject6.put("is_64_runtime", String.valueOf(NativeImpl.is64BitRuntime()));
                    jSONObject6.put("is_x86_devices", String.valueOf(C0747c.m520b()));
                    jSONObject6.put("has_meminfo_file", String.valueOf(m1104a.m497g()));
                    jSONObject6.put("is_root", C0805c.m972m() ? "true" : "false");
                    if (this.f376y) {
                        z8 = false;
                    }
                    jSONObject6.put("anr_normal_trace", String.valueOf(z8));
                    jSONObject6.put("anr_no_run", String.valueOf(m433a));
                    jSONObject6.put("crash_after_crash", Npth.hasCrash() ? "true" : "false");
                    jSONObject6.put("from_file", String.valueOf(C0734c.m423a()));
                    jSONObject6.put("has_dump", "true");
                    jSONObject6.put("from_kill", String.valueOf(z6));
                    str5 = C0812b.m1057d().m1086h();
                    jSONObject6.put("last_resume_activity", str5);
                    int i3 = this.f369r;
                    if (i3 > 0) {
                        str5 = "may_have_stack_overflow";
                        jSONObject6.put("may_have_stack_overflow", String.valueOf(i3));
                    }
                } catch (Throwable unused7) {
                    str5 = m421a;
                }
                try {
                    if (z6) {
                        str5 = m421a;
                        if (!m406h()) {
                            jSONObject6.put(MonitorConstants.KEY_AID, String.valueOf(m1104a.m499i().m537g().opt(MonitorConstants.KEY_AID)));
                        }
                    } else {
                        str5 = m421a;
                        try {
                            m392a(str5, jSONObject6);
                        } catch (Throwable th) {
                            C0738c.m435a();
                            C0738c.m436a("NPTH_CATCH", th);
                        }
                    }
                } catch (Throwable unused8) {
                    optJSONObject = jSONObject6;
                    jSONObject6 = optJSONObject;
                    if (z6) {
                    }
                    return z5;
                }
                if (z6) {
                    File file2 = this.f359h;
                    if (file2 != null) {
                        C0786i.m796a(file2);
                        this.f359h = null;
                    }
                    C0730a.m378a().m379a(CrashType.ANR, currentTimeMillis, C0749e.m563e());
                    try {
                        if (C0783f.m776f().length() > 1024) {
                            m1104a.m479a("has_system_traces", "true");
                        }
                    } catch (Throwable unused9) {
                    }
                    try {
                        JSONArray m1000a = C0806d.m1000a(C0792o.m861d(C0749e.m564f()), C0792o.m864e(C0749e.m564f()));
                        jSONObject6.put("leak_threads_count", String.valueOf(m1000a.length()));
                        if (m1000a.length() > 0) {
                            C0786i.m790a(C0792o.m867f(C0749e.m564f()), m1000a, false);
                        }
                    } catch (Throwable unused10) {
                    }
                    C0746b.m508a(m1104a.m498h(), C0746b.m503a(jSONObject11.optString("mainStackFromTrace")), new C0746b.a() { // from class: com.apm.lite.b.a.2
                        @Override // com.apm.lite.p016d.C0746b.a
                        /* renamed from: a */
                        public void mo413a(JSONObject jSONObject12) {
                            C0769d.m685a().m686a(jSONObject12, currentTimeMillis, C0732a.this.f360i);
                        }
                    });
                    m400b(str5);
                } else {
                    String m707c = C0770e.m707c();
                    File file3 = new File(C0792o.m846a(this.f356d), C0749e.m554a(currentTimeMillis, CrashType.ANR, false, false));
                    this.f359h = file3;
                    C0786i.m784a(file3, file3.getName(), m707c, m1104a.m498h(), C0770e.m704b());
                }
            } catch (Throwable th2) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th2);
            }
        }
        return z5;
    }

    /* renamed from: b */
    public void m409b() {
        C0733b c0733b = this.f355c;
        if (c0733b != null) {
            c0733b.m419a();
        }
    }

    /* renamed from: c */
    public void m410c() {
        if (f348f) {
            return;
        }
        synchronized (this.f375x) {
            if (f348f) {
                return;
            }
            this.f350B.run();
        }
    }

    /* renamed from: d */
    public void m411d() {
        if (NativeImpl.isResendSigQuit()) {
            try {
                C0786i.m788a(m405g(), String.valueOf(this.f351C + 1), false);
            } catch (Throwable th) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", th);
            }
        }
        this.f377z = SystemClock.uptimeMillis();
        this.f376y = true;
    }

    /* renamed from: e */
    public void m412e() {
        File m405g = m405g();
        try {
            int intValue = Integer.decode(C0786i.m804c(m405g.getAbsolutePath())).intValue();
            this.f351C = intValue;
            if (intValue >= 2) {
                NativeImpl.setResendSigQuit(false);
            } else {
                NativeImpl.setResendSigQuit(true);
            }
        } catch (IOException unused) {
            NativeImpl.setResendSigQuit(true);
        } catch (Throwable unused2) {
            C0786i.m796a(m405g);
        }
    }
}
