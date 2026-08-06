package com.bytedance.bdinstall.oaid;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class OaidModel {
    public static final String KEY_HW_ID_VERSION_CODE = "hw_id_version_code";
    public static final String KEY_ID = "id";
    public static final String KEY_IS_TRACK_LIMITED = "is_track_limited";
    public static final String KEY_QUERY_TIMES = "query_times";
    public static final String KEY_REQ_ID = "req_id";
    public static final String KEY_TAKE_MS = "take_ms";
    public static final String KEY_TIME = "time";
    public final Boolean isTrackLimited;
    public final Long mHwIdVersionCode;
    public final String oaid;
    public final Integer queryTimes;
    public final String reqId;
    public final Long takeMs;
    public final Long time;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OaidModel(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.oaid = str;
        this.reqId = str2;
        this.isTrackLimited = bool;
        this.takeMs = l;
        this.time = l2;
        this.queryTimes = num;
        this.mHwIdVersionCode = l3;
    }

    public String toString() {
        return toJson().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> toApiMap() {
        HashMap hashMap = new HashMap();
        Oaid.safePutNonNullValue(hashMap, "id", this.oaid);
        Oaid.safePutNonNullValue(hashMap, "req_id", this.reqId);
        Oaid.safePutNonNullValue(hashMap, "is_track_limited", String.valueOf(this.isTrackLimited));
        Oaid.safePutNonNullValue(hashMap, "take_ms", String.valueOf(this.takeMs));
        Oaid.safePutNonNullValue(hashMap, "time", String.valueOf(this.time));
        Oaid.safePutNonNullValue(hashMap, "query_times", String.valueOf(this.queryTimes));
        Oaid.safePutNonNullValue(hashMap, "hw_id_version_code", String.valueOf(this.mHwIdVersionCode));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        Oaid.safePutNonEmptyValue(jSONObject, "id", this.oaid);
        Oaid.safePutNonEmptyValue(jSONObject, "req_id", this.reqId);
        Oaid.safePutNonEmptyValue(jSONObject, "is_track_limited", this.isTrackLimited);
        Oaid.safePutNonEmptyValue(jSONObject, "take_ms", this.takeMs);
        Oaid.safePutNonEmptyValue(jSONObject, "time", this.time);
        Oaid.safePutNonEmptyValue(jSONObject, "query_times", this.queryTimes);
        Oaid.safePutNonEmptyValue(jSONObject, "hw_id_version_code", this.mHwIdVersionCode);
        return jSONObject;
    }

    public static OaidModel create(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new OaidModel(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
