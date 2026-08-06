package com.bytedance.sdk.open.douyin.settings;

import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class f {
    public static final String f = "SettingsModel";
    public static final String g = "vid_info";
    public static final String h = "settings_json";
    public static final String i = "ctx_info";
    public static final String j = "update_time";
    public static final String k = "settings_time";
    public static final long l = 86400000;
    private long a;
    private String b;
    private JSONObject c;
    private JSONObject d;
    private long e;

    public f(long j2, String str, JSONObject jSONObject, JSONObject jSONObject2, long j3) {
        this.a = j2;
        this.b = str;
        this.c = jSONObject;
        this.d = jSONObject2;
        this.e = j3;
    }

    public static f a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong(j);
            JSONObject optJSONObject = jSONObject.optJSONObject(g);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            JSONObject jSONObject2 = optJSONObject;
            String optString = jSONObject.optString(i);
            String str2 = TextUtils.isEmpty(optString) ? null : optString;
            long optLong2 = jSONObject.optLong("settings_time");
            JSONObject optJSONObject2 = jSONObject.optJSONObject(h);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            return new f(optLong, str2, optJSONObject2, jSONObject2, optLong2);
        } catch (Exception e) {
            LogUtils.w(f, e.getMessage());
            return null;
        }
    }

    public String a() {
        return this.b;
    }

    public long b() {
        return this.a;
    }

    public JSONObject c() {
        return this.c;
    }

    public long d() {
        return this.e;
    }

    public JSONObject e() {
        return this.d;
    }

    public boolean f() {
        return (this.a == 0 || this.e == 0) ? false : true;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(j, this.a);
            jSONObject.put(g, this.d);
            jSONObject.put(i, this.b);
            jSONObject.put("settings_time", this.e);
            jSONObject.put(h, this.c);
        } catch (JSONException e) {
            LogUtils.w(f, "toJson", e);
        }
        return jSONObject;
    }
}
