package com.apm.lite.p016d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.apm.lite.C0749e;
import com.apm.lite.p023k.C0781d;
import com.apm.lite.p023k.C0793p;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.p023k.C0797t;
import com.apm.lite.runtime.C0835p;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.d.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0747c {

    /* renamed from: a */
    private static final String[] f407a = {"version_code", "manifest_version_code", MonitorConstants.KEY_AID, "update_version_code"};

    /* renamed from: d */
    private static String f408d = null;

    /* renamed from: e */
    private static int f409e = -1;

    /* renamed from: f */
    private static int f410f = -1;

    /* renamed from: b */
    private Context f411b;

    /* renamed from: c */
    private JSONObject f412c = new JSONObject();

    public C0747c(Context context) {
        this.f411b = context;
    }

    /* renamed from: a */
    public static C0747c m512a(Context context) {
        C0747c c0747c = new C0747c(context);
        c0747c.m525g(c0747c.m537g());
        return c0747c;
    }

    /* renamed from: a */
    public static C0747c m513a(Context context, long j) {
        C0747c m512a;
        C0835p m1198a = C0835p.m1198a();
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        JSONObject m1208a = m1198a.m1208a(j);
        if (m1208a == null || m1208a.length() == 0) {
            m512a = m512a(C0749e.m565g());
            m512a.m534d();
            try {
                m512a.m537g().put("errHeader", 1);
            } catch (Throwable unused) {
            }
        } else {
            m512a = new C0747c(C0749e.m565g());
        }
        m518b(m512a);
        m512a.m533c(m1208a);
        return m512a;
    }

    /* renamed from: a */
    public static C0747c m514a(C0747c c0747c) {
        m515a(c0747c.m537g());
        return c0747c;
    }

    /* renamed from: a */
    public static void m515a(JSONObject jSONObject) {
        m530k(jSONObject);
        m531l(jSONObject);
    }

    /* renamed from: a */
    public static boolean m516a() {
        if (f409e == -1) {
            f409e = m526h().contains("64") ? 1 : 0;
        }
        return f409e == 1;
    }

    /* renamed from: b */
    public static C0747c m517b(Context context) {
        C0747c m512a = m512a(context);
        m514a(m512a);
        m518b(m512a);
        m512a.m534d();
        m512a.m535e();
        m512a.m536f();
        return m512a;
    }

    /* renamed from: b */
    public static void m518b(C0747c c0747c) {
        if (c0747c == null) {
            return;
        }
        m519b(c0747c.m537g());
    }

    /* renamed from: b */
    public static void m519b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        m529j(jSONObject);
        m527h(jSONObject);
        m528i(jSONObject);
        try {
            jSONObject.put("os", "Android");
            jSONObject.put("device_id", C0749e.m560c().m1226a());
            jSONObject.put("os_version", m521c());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            String str = Build.MODEL;
            String str2 = Build.BRAND;
            if (str == null) {
                str = str2;
            } else if (str2 != null && !str.contains(str2)) {
                str = str2 + ' ' + str;
            }
            jSONObject.put("device_model", str);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", m526h());
            Context m565g = C0749e.m565g();
            String packageName = m565g.getPackageName();
            jSONObject.put("package", packageName);
            PackageInfo packageInfo = m565g.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo.applicationInfo != null) {
                int i = packageInfo.applicationInfo.labelRes;
                jSONObject.put("display_name", i > 0 ? m565g.getString(i) : m565g.getPackageManager().getApplicationLabel(packageInfo.applicationInfo));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public static boolean m520b() {
        if (f410f == -1) {
            f410f = m526h().contains("86") ? 1 : 0;
        }
        return f410f == 1;
    }

    /* renamed from: c */
    public static String m521c() {
        String str = Build.VERSION.RELEASE;
        return str.contains(".") ? str : str + ".0";
    }

    /* renamed from: d */
    public static boolean m522d(JSONObject jSONObject) {
        return jSONObject.optInt("unauthentic_version", 0) == 1;
    }

    /* renamed from: e */
    public static boolean m523e(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0 || (jSONObject.opt("app_version") == null && jSONObject.opt("version_name") == null) || jSONObject.opt("version_code") == null || jSONObject.opt("update_version_code") == null;
    }

    /* renamed from: f */
    public static boolean m524f(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            String optString = jSONObject.optString(MonitorConstants.KEY_AID);
            if (TextUtils.isEmpty(optString)) {
                return true;
            }
            try {
                return Integer.parseInt(optString) <= 0;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    /* renamed from: g */
    private void m525g(JSONObject jSONObject) {
        try {
            jSONObject.put("sdk_version", 290);
            jSONObject.put("sdk_version_name", "0.0.2");
        } catch (Exception unused) {
        }
    }

    /* renamed from: h */
    private static String m526h() {
        if (f408d == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                        sb.append(Build.SUPPORTED_ABIS[i]);
                        if (i != Build.SUPPORTED_ABIS.length - 1) {
                            sb.append(", ");
                        }
                    }
                } else {
                    sb = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    f408d = "unknown";
                }
                f408d = sb.toString();
            } catch (Exception e) {
                C0794q.m893b(e);
                f408d = "unknown";
            }
        }
        return f408d;
    }

    /* renamed from: h */
    private static void m527h(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = C0749e.m565g().getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    /* renamed from: i */
    private static void m528i(JSONObject jSONObject) {
        try {
            String language = C0749e.m565g().getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0043 A[Catch: all -> 0x0057, TryCatch #0 {all -> 0x0057, blocks: (B:3:0x0005, B:6:0x000d, B:7:0x0038, B:9:0x0043, B:10:0x004d, B:14:0x0011, B:17:0x001a, B:19:0x0024, B:20:0x0029, B:22:0x002f), top: B:2:0x0005 }] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m529j(JSONObject jSONObject) {
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            if (C0781d.m765c()) {
                str = "MIUI-";
            } else {
                if (!C0781d.m767d()) {
                    String m760a = C0781d.m760a();
                    if (C0781d.m761a(m760a)) {
                        sb.append("EMUI-");
                    }
                    if (!TextUtils.isEmpty(m760a)) {
                        sb.append(m760a).append("-");
                    }
                    sb.append(Build.VERSION.INCREMENTAL);
                    if (sb.length() > 0) {
                        jSONObject.put("rom", sb.toString());
                    }
                    jSONObject.put("rom_version", C0797t.m900a());
                }
                str = "FLYME-";
            }
            sb.append(str);
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
            }
            jSONObject.put("rom_version", C0797t.m900a());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: k */
    private static void m530k(JSONObject jSONObject) {
        try {
            jSONObject.put("access", C0793p.m883a(C0749e.m565g()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: l */
    private static void m531l(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) C0749e.m565g().getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public JSONObject m532a(Map<String, Object> map) {
        if (map == null) {
            return this.f412c;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.f412c.has(entry.getKey())) {
                this.f412c.put(entry.getKey(), entry.getValue());
            }
        }
        for (String str : f407a) {
            if (map.containsKey(str)) {
                try {
                    this.f412c.put(str, Integer.parseInt(String.valueOf(map.get(str))));
                } catch (Throwable unused) {
                    this.f412c.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            try {
                this.f412c.put("manifest_version_code", Integer.parseInt(String.valueOf(map.get("version_code"))));
            } catch (Throwable unused2) {
            }
        }
        if (map.containsKey("iid")) {
            this.f412c.put("udid", map.get("iid"));
            this.f412c.remove("iid");
        }
        if (map.containsKey("version_name")) {
            this.f412c.put("app_version", map.get("version_name"));
            this.f412c.remove("version_name");
        }
        return this.f412c;
    }

    /* renamed from: c */
    public JSONObject m533c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this.f412c;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f412c.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.f412c;
    }

    /* renamed from: d */
    public JSONObject m534d() {
        return m532a(C0749e.m553a().m1121a());
    }

    /* renamed from: e */
    public JSONObject m535e() {
        try {
            this.f412c.put("device_id", C0749e.m560c().m1226a());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.f412c;
    }

    /* renamed from: f */
    public JSONObject m536f() {
        try {
            long m1126f = C0749e.m553a().m1126f();
            if (m1126f > 0) {
                this.f412c.put("user_id", m1126f);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.f412c;
    }

    /* renamed from: g */
    public JSONObject m537g() {
        return this.f412c;
    }
}
