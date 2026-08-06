package com.bytedance.tobshadow.bdtracker;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import com.bytedance.tobshadow.applog.util.HardwareUtils;
import com.bytedance.tobshadow.applog.util.SensitiveUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.l5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0466l5 {

    /* renamed from: h */
    public static String f746h;

    /* renamed from: i */
    public static String f747i;

    /* renamed from: j */
    public static String f748j;

    /* renamed from: k */
    public static JSONArray f749k;

    /* renamed from: l */
    public static volatile String f750l;

    /* renamed from: m */
    public static String f751m;

    /* renamed from: a */
    public final Context f752a;

    /* renamed from: b */
    public AbstractC0486o4 f753b;

    /* renamed from: c */
    public final C0472m4 f754c;

    /* renamed from: d */
    public final String f755d;

    /* renamed from: e */
    public final C0467m f756e;

    /* renamed from: f */
    public final C0407d2 f757f;

    /* renamed from: g */
    public final List<String> f758g = Collections.singletonList("DeviceParamsProvider");

    public C0466l5(C0467m c0467m, Context context, C0407d2 c0407d2, C0472m4 c0472m4) {
        this.f756e = c0467m;
        this.f757f = c0407d2;
        this.f755d = c0407d2.f502c.getLocalTest() ? "_local" : "";
        Context applicationContext = context.getApplicationContext();
        this.f752a = applicationContext;
        C0459k5 c0459k5 = new C0459k5();
        this.f754c = c0472m4;
        C0563z4 c0563z4 = new C0563z4(c0407d2.f502c, applicationContext, "snssdk_openudid", c0407d2.f502c.getSpName());
        this.f753b = c0563z4;
        c0563z4.f895a = c0472m4;
        if (!c0407d2.f502c.getAnonymous()) {
            new Thread(new RunnableC0452j5(c0459k5)).start();
        }
        m510a(c0407d2.f502c.getAccount());
    }

    /* renamed from: a */
    public void m510a(Account account) {
        C0472m4 c0472m4 = this.f754c;
        if (c0472m4 != null) {
            c0472m4.m529a(account);
        }
    }

    /* renamed from: a */
    public void m511a(String str) {
        this.f753b.mo530a(str);
        this.f756e.f764D.debug(this.f758g, "DeviceParamsProvider#clear clearKey=" + str + " sDeviceId=" + f750l, new Object[0]);
    }

    /* renamed from: b */
    public String m512b() {
        if (!TextUtils.isEmpty(f750l)) {
            return f750l;
        }
        f750l = this.f753b.m596c("", "");
        return f750l;
    }

    /* renamed from: b */
    public void m513b(String str) {
        if (!C0411e.m361a(str) || C0411e.m362a(str, f750l)) {
            return;
        }
        f750l = this.f753b.m596c(str, f750l);
    }

    /* renamed from: c */
    public String m514c() {
        if (!TextUtils.isEmpty(f746h)) {
            return f746h;
        }
        C0407d2 c0407d2 = this.f757f;
        String m509a = c0407d2.f502c.isAndroidIdEnabled() && !c0407d2.m314a("openudid") ? m509a(HardwareUtils.getSecureAndroidId(this.f752a), true) : m509a("", false);
        if (!TextUtils.isEmpty(m509a)) {
            m509a = C0380a.m252a(m509a).append(this.f755d).toString();
        }
        if (!TextUtils.isEmpty(m509a)) {
            f746h = m509a;
        }
        return m509a;
    }

    /* renamed from: d */
    public String m515d() {
        if (!TextUtils.isEmpty(f751m)) {
            return f751m;
        }
        try {
            String m598e = this.f753b.m598e(null, SensitiveUtils.getSerialNumber(this.f752a));
            if (!TextUtils.isEmpty(m598e)) {
                m598e = m598e + this.f755d;
            }
            f751m = m598e;
            return m598e;
        } catch (Throwable th) {
            this.f756e.f764D.error(this.f758g, "getSerialNumber failed", th, new Object[0]);
            return null;
        }
    }

    /* renamed from: e */
    public String m516e() {
        String appImei;
        if (!TextUtils.isEmpty(f748j)) {
            return f748j;
        }
        try {
            C0407d2 c0407d2 = this.f757f;
            if (c0407d2.f502c.isImeiEnable() && !c0407d2.m314a("IMEI")) {
                appImei = SensitiveUtils.getDeviceId(this.f752a);
            } else {
                appImei = this.f757f.f502c.getAppImei();
            }
            String m599f = this.f753b.m599f(null, appImei);
            if (!TextUtils.isEmpty(m599f)) {
                m599f = m599f + this.f755d;
            }
            f748j = m599f;
            return m599f;
        } catch (Throwable th) {
            this.f756e.f764D.error(this.f758g, "getUdId failed", th, new Object[0]);
            return null;
        }
    }

    /* renamed from: f */
    public JSONArray m517f() {
        JSONArray jSONArray = f749k;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
            C0407d2 c0407d2 = this.f757f;
            if (!(c0407d2.f502c.isImeiEnable() && !c0407d2.m314a("IMEI"))) {
                return new JSONArray();
            }
            JSONArray multiImeiFromSystem = SensitiveUtils.getMultiImeiFromSystem(this.f752a);
            if (multiImeiFromSystem == null) {
                multiImeiFromSystem = SensitiveUtils.getMultiImeiFallback(this.f752a);
            }
            if (multiImeiFromSystem == null) {
                multiImeiFromSystem = new JSONArray();
            }
            JSONArray jSONArray2 = new JSONArray(this.f753b.m600g(null, multiImeiFromSystem.toString()));
            if (!TextUtils.isEmpty(this.f755d)) {
                String str = this.f755d;
                if (jSONArray2.length() != 0) {
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("id");
                            if (!TextUtils.isEmpty(optString)) {
                                optJSONObject.remove("id");
                                optJSONObject.put("id", optString + str);
                            }
                        }
                    }
                }
            }
            f749k = jSONArray2;
            return jSONArray2;
        } catch (Throwable th) {
            this.f756e.f764D.error(this.f758g, "getUdIdList failed", th, new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public String m508a() {
        if (!TextUtils.isEmpty(f747i)) {
            return f747i;
        }
        try {
            IKVStore m439a = C0424f5.m439a(this.f757f.f502c, this.f752a, "snssdk_openudid");
            String string = m439a.getString("clientudid", null);
            if (C0411e.m381e(string)) {
                this.f754c.m595b(string, null);
            } else {
                string = UUID.randomUUID().toString();
                m439a.putString("clientudid", string);
            }
            if (!TextUtils.isEmpty(string)) {
                string = string + this.f755d;
            }
            f747i = string;
            return string;
        } catch (Throwable th) {
            this.f756e.f764D.error(this.f758g, "getClientUDID failed", th, new Object[0]);
            return "";
        }
    }

    /* renamed from: a */
    public final String m509a(String str, boolean z) {
        try {
            if (C0411e.m381e(str) && !"9774d56d682e549c".equals(str)) {
                return this.f753b.m597d(null, str);
            }
            IKVStore m439a = C0424f5.m439a(this.f757f.f502c, this.f752a, "snssdk_openudid");
            String str2 = "openudid";
            String string = m439a.getString(z ? "openudid" : "openudid_uuid", null);
            if (C0411e.m381e(string)) {
                this.f754c.m597d(string, null);
                return string;
            }
            String bigInteger = new BigInteger(80, new SecureRandom()).toString(16);
            if (bigInteger.charAt(0) == '-') {
                bigInteger = bigInteger.substring(1);
            }
            int length = 13 - bigInteger.length();
            if (length > 0) {
                StringBuilder sb = new StringBuilder();
                while (length > 0) {
                    sb.append('F');
                    length--;
                }
                sb.append(bigInteger);
                bigInteger = sb.toString();
            }
            if (!z) {
                str2 = "openudid_uuid";
            }
            m439a.putString(str2, bigInteger);
            return bigInteger;
        } catch (Throwable th) {
            this.f756e.f764D.error(this.f758g, "getOpenUdid failed", th, new Object[0]);
            return str;
        }
    }
}
