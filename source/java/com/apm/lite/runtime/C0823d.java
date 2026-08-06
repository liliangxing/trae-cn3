package com.apm.lite.runtime;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.apm.lite.ICommonParams;
import com.apm.lite.p023k.C0778a;
import com.apm.lite.p023k.C0799v;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.apm.lite.runtime.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0823d {

    /* renamed from: a */
    private Context f700a;

    /* renamed from: b */
    private ICommonParams f701b;

    /* renamed from: c */
    private ICommonParams f702c;

    public C0823d(Context context, ICommonParams iCommonParams) {
        this(context, iCommonParams, null);
    }

    public C0823d(Context context, ICommonParams iCommonParams, C0823d c0823d) {
        this.f700a = context;
        this.f701b = iCommonParams;
        this.f702c = c0823d == null ? null : c0823d.f701b;
    }

    /* renamed from: a */
    public static String m1119a(Map<String, Object> map, String str) {
        Object obj;
        if (map == null || (obj = map.get(str)) == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    /* renamed from: a */
    public static boolean m1120a(Map<String, Object> map) {
        return map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey("version_name")) && map.containsKey("version_code") && map.containsKey("update_version_code"));
    }

    /* renamed from: a */
    public Map<String, Object> m1121a() {
        Map<String, Object> m1122b = m1122b();
        if (m1119a(m1122b, MonitorConstants.KEY_AID) == null) {
            m1122b.put(MonitorConstants.KEY_AID, 4444);
        }
        return m1122b;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, Object> m1122b() {
        Map<String, Object> map;
        Throwable th;
        Map<String, Object> map2;
        try {
            ICommonParams iCommonParams = this.f702c;
            map2 = iCommonParams != null ? iCommonParams.getCommonParams() : new HashMap<>();
            try {
                map2.putAll(this.f701b.getCommonParams());
                th = null;
            } catch (Throwable th2) {
                map = map2;
                th = th2;
                Map<String, Object> map3 = map;
                th = th;
                map2 = map3;
                if (map2 == null) {
                }
                if (m1120a(map2)) {
                }
                return map2;
            }
        } catch (Throwable th3) {
            th = th3;
            map = null;
        }
        if (map2 == null) {
            map2 = new HashMap<>(4);
            if (th != null) {
                try {
                    map2.put("err_info", C0799v.m917a(th));
                } catch (Throwable unused) {
                }
            }
        }
        if (m1120a(map2)) {
            try {
                String str = this.f700a.getPackageManager().getPackageInfo(this.f700a.getPackageName(), 128).versionName;
                String str2 = (String) Class.forName(this.f700a.getPackageName() + ".BuildConfig").getDeclaredField("VERSION_NAME").get(null);
                if (str != null && !str.equals(str2)) {
                    map2.put("manifest_version", str);
                }
            } catch (Throwable unused2) {
            }
        } else {
            try {
                PackageInfo packageInfo = this.f700a.getPackageManager().getPackageInfo(this.f700a.getPackageName(), 128);
                map2.put("version_name", packageInfo.versionName);
                map2.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (map2.get("update_version_code") == null) {
                    Object obj = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = map2.get("version_code");
                    }
                    map2.put("update_version_code", obj);
                }
            } catch (Throwable unused3) {
                map2.put("version_name", C0778a.m749d(this.f700a));
                map2.put("version_code", Integer.valueOf(C0778a.m750e(this.f700a)));
                if (map2.get("update_version_code") == null) {
                    map2.put("update_version_code", map2.get("version_code"));
                }
            }
        }
        return map2;
    }

    /* renamed from: c */
    public ICommonParams m1123c() {
        return this.f701b;
    }

    /* renamed from: d */
    public String m1124d() {
        try {
            return this.f701b.getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: e */
    public String m1125e() {
        try {
            return String.valueOf(this.f701b.getCommonParams().get(MonitorConstants.KEY_AID));
        } catch (Throwable unused) {
            return "4444";
        }
    }

    /* renamed from: f */
    public long m1126f() {
        try {
            return this.f701b.getUserId();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
