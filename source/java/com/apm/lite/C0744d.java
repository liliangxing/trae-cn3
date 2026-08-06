package com.apm.lite;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.apm.lite.p016d.C0746b;
import com.apm.lite.p021i.C0763b;
import com.apm.lite.p022j.C0775j;
import com.apm.lite.p023k.C0789l;
import com.apm.lite.p023k.C0799v;
import com.apm.lite.runtime.p024a.C0812b;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0744d {

    /* renamed from: b */
    protected static volatile MonitorCrash f400b;

    /* renamed from: c */
    protected static volatile ConcurrentHashMap<String, MonitorCrash> f401c = new ConcurrentHashMap<>();

    /* renamed from: a */
    protected MonitorCrash f402a;

    private C0744d(MonitorCrash monitorCrash) {
        this.f402a = monitorCrash;
        C0746b.m506a(this);
        C0763b.m645d();
        C0775j.m729e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static MonitorCrash m449a(String str) {
        return f401c.get(str);
    }

    /* renamed from: a */
    public static Object m450a() {
        return f400b;
    }

    /* renamed from: a */
    private JSONObject m451a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f402a.mConfig.f329f == null) {
                Context m565g = C0749e.m565g();
                PackageInfo packageInfo = m565g.getPackageManager().getPackageInfo(m565g.getPackageName(), 128);
                if (packageInfo != null) {
                    if (this.f402a.mConfig.f327d == -1) {
                        this.f402a.mConfig.f327d = packageInfo.versionCode;
                    }
                    if (this.f402a.mConfig.f328e == null) {
                        this.f402a.mConfig.f328e = packageInfo.versionName;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if ((TextUtils.isEmpty(this.f402a.mConfig.getDeviceId()) || "0".equals(this.f402a.mConfig.getDeviceId())) && this.f402a.mAppLog != null) {
            this.f402a.mConfig.setDeviceId(this.f402a.mAppLog.m384a(), false);
        }
        try {
            jSONObject.put(MonitorConstants.KEY_AID, String.valueOf(this.f402a.mConfig.f324a));
            if (z && !TextUtils.isEmpty(this.f402a.mConfig.f325b)) {
                jSONObject.put("x-auth-token", this.f402a.mConfig.f325b);
            }
            jSONObject.put("update_version_code", this.f402a.mConfig.f327d);
            jSONObject.put("version_code", this.f402a.mConfig.f327d);
            jSONObject.put("app_version", this.f402a.mConfig.f328e);
            jSONObject.put("channel", this.f402a.mConfig.f326c);
            jSONObject.put("package", C0789l.m819a(this.f402a.mConfig.f329f));
            jSONObject.put("device_id", this.f402a.mConfig.getDeviceId());
            jSONObject.put("user_id", this.f402a.mConfig.getUID());
            jSONObject.put("os", "Android");
            jSONObject.put("so_list", C0789l.m819a(this.f402a.mConfig.f330g));
            jSONObject.put("single_upload", m465d() ? 1 : 0);
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m452a(MonitorCrash monitorCrash) {
        new C0744d(monitorCrash);
        if (monitorCrash == null || monitorCrash.mConfig == null) {
            return;
        }
        f401c.put(monitorCrash.mConfig.f324a, monitorCrash);
    }

    /* renamed from: b */
    public static String m453b(String str) {
        MonitorCrash monitorCrash;
        if (f400b != null && TextUtils.equals(str, f400b.mConfig.f324a)) {
            monitorCrash = f400b;
        } else if (f401c == null || (monitorCrash = f401c.get(str)) == null) {
            return null;
        }
        return monitorCrash.mConfig.f325b;
    }

    /* renamed from: b */
    private JSONObject m454b(CrashType crashType) {
        Map<? extends String, ? extends String> userData;
        if (this.f402a.mCustomData == null || (userData = this.f402a.mCustomData.getUserData(crashType)) == null) {
            return null;
        }
        return new JSONObject(userData);
    }

    /* renamed from: c */
    private JSONObject m455c(CrashType crashType) {
        return new JSONObject(this.f402a.mTagMap);
    }

    /* renamed from: e */
    public static String m456e() {
        if (f400b == null) {
            return null;
        }
        return f400b.mConfig.f324a;
    }

    /* renamed from: a */
    public JSONArray m457a(StackTraceElement[] stackTraceElementArr, Throwable th) {
        if (this.f402a.mConfig.f329f == null) {
            return new JSONArray().put(new C0799v.a(0, stackTraceElementArr.length).m940a());
        }
        if (th == null || stackTraceElementArr == null) {
            return null;
        }
        return C0799v.m922a(stackTraceElementArr, this.f402a.mConfig.f329f);
    }

    /* renamed from: a */
    public JSONArray m458a(String[] strArr) {
        if (this.f402a.config().f329f == null) {
            return new JSONArray().put(new C0799v.a(0, strArr.length).m940a());
        }
        JSONArray m923a = C0799v.m923a(strArr, this.f402a.mConfig.f329f);
        try {
            if (C0789l.m821a(m923a) && this.f402a.mConfig.f333j) {
                String m1086h = C0812b.m1057d().m1086h();
                if (!TextUtils.isEmpty(m1086h)) {
                    for (String str : this.f402a.mConfig.f329f) {
                        if (m1086h.contains(str)) {
                            return new JSONArray().put(new C0799v.a(0, strArr.length).m940a());
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return m923a;
    }

    /* renamed from: a */
    public JSONObject m459a(CrashType crashType) {
        return m460a(crashType, (JSONArray) null);
    }

    /* renamed from: a */
    public JSONObject m460a(CrashType crashType, JSONArray jSONArray) {
        return m461a(crashType, jSONArray, false);
    }

    /* renamed from: a */
    public JSONObject m461a(CrashType crashType, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.KEY_HEADER, m451a(z));
            if (crashType != null) {
                jSONObject.put("custom", m454b(crashType));
                jSONObject.put("filters", m455c(crashType));
            }
            jSONObject.put("line_num", jSONArray);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public boolean m462a(Object obj) {
        return this.f402a == obj;
    }

    /* renamed from: b */
    public String m463b() {
        return this.f402a.mConfig.f324a;
    }

    /* renamed from: c */
    public JSONObject m464c() {
        return m451a(true);
    }

    /* renamed from: d */
    public boolean m465d() {
        return false;
    }
}
