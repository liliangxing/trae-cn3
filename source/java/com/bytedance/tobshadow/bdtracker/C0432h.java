package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0432h {

    /* renamed from: a */
    public final IKVStore f642a;

    public C0432h(Context context) {
        this.f642a = C0424f5.m438a(context, "device_register_oaid_refine");
    }

    /* renamed from: a */
    public C0425g m452a() {
        String string = this.f642a.getString("oaid", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            return new C0425g(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has(DBData.FIELD_TIME) ? Long.valueOf(jSONObject.optLong(DBData.FIELD_TIME, -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "Oaid#Create model failed", th, new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public void m453a(C0425g c0425g) {
        if (c0425g == null) {
            return;
        }
        this.f642a.putString("oaid", c0425g.m442b().toString());
    }
}
