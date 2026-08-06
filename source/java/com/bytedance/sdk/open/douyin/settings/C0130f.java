package com.bytedance.sdk.open.douyin.settings;

import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.open.douyin.settings.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0130f {

    /* renamed from: f */
    public static final String f133f = "SettingsModel";

    /* renamed from: g */
    public static final String f134g = "vid_info";

    /* renamed from: h */
    public static final String f135h = "settings_json";

    /* renamed from: i */
    public static final String f136i = "ctx_info";

    /* renamed from: j */
    public static final String f137j = "update_time";

    /* renamed from: k */
    public static final String f138k = "settings_time";

    /* renamed from: l */
    public static final long f139l = 86400000;

    /* renamed from: a */
    private long f140a;

    /* renamed from: b */
    private String f141b;

    /* renamed from: c */
    private JSONObject f142c;

    /* renamed from: d */
    private JSONObject f143d;

    /* renamed from: e */
    private long f144e;

    public C0130f(long j, String str, JSONObject jSONObject, JSONObject jSONObject2, long j2) {
        this.f140a = j;
        this.f141b = str;
        this.f142c = jSONObject;
        this.f143d = jSONObject2;
        this.f144e = j2;
    }

    /* renamed from: a */
    public static C0130f m72a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong(f137j);
            JSONObject optJSONObject = jSONObject.optJSONObject(f134g);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            JSONObject jSONObject2 = optJSONObject;
            String optString = jSONObject.optString(f136i);
            String str2 = TextUtils.isEmpty(optString) ? null : optString;
            long optLong2 = jSONObject.optLong(f138k);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(f135h);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            return new C0130f(optLong, str2, optJSONObject2, jSONObject2, optLong2);
        } catch (Exception e) {
            LogUtils.m30w(f133f, e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public String m73a() {
        return this.f141b;
    }

    /* renamed from: b */
    public long m74b() {
        return this.f140a;
    }

    /* renamed from: c */
    public JSONObject m75c() {
        return this.f142c;
    }

    /* renamed from: d */
    public long m76d() {
        return this.f144e;
    }

    /* renamed from: e */
    public JSONObject m77e() {
        return this.f143d;
    }

    /* renamed from: f */
    public boolean m78f() {
        return (this.f140a == 0 || this.f144e == 0) ? false : true;
    }

    /* renamed from: g */
    public JSONObject m79g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f137j, this.f140a);
            jSONObject.put(f134g, this.f143d);
            jSONObject.put(f136i, this.f141b);
            jSONObject.put(f138k, this.f144e);
            jSONObject.put(f135h, this.f142c);
        } catch (JSONException e) {
            LogUtils.m30w(f133f, "toJson", e);
        }
        return jSONObject;
    }
}
