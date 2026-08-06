package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.deviceregister.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class OaidSp {
    private static final String DEPRECATED_HUAWEI_SP_FILE = "device-register-oaid";
    private static final String DEPRECATED_HUAWEI_SP_KEY_LAST_SUCCESS_QUERY_OAID = "lastSuccessQueryOaid";
    private static final String DEPRECATED_HUAWEI_SP_KEY_QUERY_HMS_TIMES = "queryHmsTimes";
    private static final String DEPRECATED_XIAOMI_SP_FILE = "device-register-oaid-xiaomi";
    private static final String DEPRECATED_XIAOMI_SP_KEY_LAST_SUCCESS_QUERY_OAID = "lastSuccessQueryOaid";
    private static final String DEPRECATED_XIAOMI_SP_KEY_QUERY_XM_TIMES = "queryXiaomiTimes";
    private static final String KEY_MIGRATED = "migrated";
    private static final String KEY_OAID = "oaid";
    private static final String SP_FILE = "device_register_oaid_refine";
    private final SharedPreferences sp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OaidSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_FILE, 0);
        this.sp = sharedPreferences;
        try {
            migrateDeprecatedSp(context, sharedPreferences);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e(LogUtils.TAG, "OaidSp#constructor", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void save(OaidModel oaidModel) {
        if (oaidModel == null) {
            return;
        }
        this.sp.edit().putString("oaid", oaidModel.toJson().toString()).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OaidModel fetch() {
        return OaidModel.create(this.sp.getString("oaid", ""));
    }

    private void migrateDeprecatedSp(Context context, SharedPreferences sharedPreferences) {
        OaidModel oaidModel;
        OaidModel oaidModel2;
        if (sharedPreferences.getBoolean(KEY_MIGRATED, false)) {
            return;
        }
        LogUtils.e(LogUtils.TAG, "OaidSp#migrateDeprecatedSp");
        sharedPreferences.edit().putBoolean(KEY_MIGRATED, true).apply();
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(DEPRECATED_HUAWEI_SP_FILE, 0);
        if (sharedPreferences2.contains("lastSuccessQueryOaid")) {
            oaidModel2 = toOaidModelFromSpHw(sharedPreferences2);
            LogUtils.d(LogUtils.TAG, "OaidSp#migrateDeprecatedSp spHw");
            sharedPreferences2.edit().clear().apply();
        } else {
            SharedPreferences sharedPreferences3 = context.getSharedPreferences(DEPRECATED_XIAOMI_SP_FILE, 0);
            if (sharedPreferences3.contains("lastSuccessQueryOaid")) {
                oaidModel = toOaidModelFromSpXm(sharedPreferences3);
                LogUtils.d(LogUtils.TAG, "OaidSp#migrateDeprecatedSp spXm");
            } else {
                oaidModel = null;
            }
            sharedPreferences3.edit().clear().apply();
            oaidModel2 = oaidModel;
        }
        LogUtils.d(LogUtils.TAG, "OaidSp#migrateDeprecatedSp oaidModel=" + oaidModel2);
        if (oaidModel2 != null) {
            sharedPreferences.edit().putString("oaid", oaidModel2.toJson().toString()).apply();
        }
    }

    private static OaidModel toOaidModelFromSpHw(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("lastSuccessQueryOaid", null);
        Integer valueOf = Integer.valueOf(sharedPreferences.getInt(DEPRECATED_HUAWEI_SP_KEY_QUERY_HMS_TIMES, -1));
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("id");
            String optString2 = jSONObject.optString("is_track_limited");
            String optString3 = jSONObject.optString("take_ms");
            String optString4 = jSONObject.optString("time");
            return new OaidModel(optString, jSONObject.optString("req_id"), Boolean.valueOf(Boolean.parseBoolean(optString2)), Long.valueOf(OaidWrapper.safeParseLong(optString3, -1L)), Long.valueOf(OaidWrapper.safeParseLong(optString4, -1L)), valueOf, Long.valueOf(OaidWrapper.safeParseLong(jSONObject.optString("hw_id_version_code"), -1L)));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static OaidModel toOaidModelFromSpXm(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("lastSuccessQueryOaid", null);
        Integer valueOf = Integer.valueOf(sharedPreferences.getInt(DEPRECATED_XIAOMI_SP_KEY_QUERY_XM_TIMES, -1));
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            return new OaidModel(jSONObject.optString("oaid"), jSONObject.optString("req_id"), null, Long.valueOf(OaidWrapper.safeParseLong(jSONObject.optString("take_ms"), -1L)), Long.valueOf(OaidWrapper.safeParseLong(jSONObject.optString("last_success_query_oaid_time"), -1L)), valueOf, null);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
