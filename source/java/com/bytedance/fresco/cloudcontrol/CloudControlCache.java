package com.bytedance.fresco.cloudcontrol;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Iterator;
import kotlinx.datetime.internal.DateCalculationsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CloudControlCache {
    private static final String KEY_ANIMATED_ADAPTIVE_POLICY = "animated_adaptive_policy";
    private static final String KEY_CLOUD_CONTROL_CONFIG = "CloudControlConfig";
    public static final String KEY_DECODE_HEIC_USE_SYSTEM_API_FIRST = "decode_heic_use_system_api_first";
    private static final String KEY_ENABLE_HEIF = "enable_heif";
    private static final String KEY_ENABLE_SR = "enable_sr";
    private static final String KEY_FETCH_SETTING_INTERVAL = "FetchSettingInterval";
    private static final String KEY_HTTPDNS_AUTH_ID = "Httpdns_auth_id";
    private static final String KEY_HTTPDNS_AUTH_KEY = "Httpdns_auth_key";
    private static final String KEY_HTTPDNS_ENABLE = "ttnet_http_dns_enabled";
    private static final String KEY_HTTPDNS_SERVICEID = "ttnet_http_dns_serviceid";
    private static final String KEY_IMAGE_ADAPTIVE_FORMAT = "image_adaptive_format";
    private static final String KEY_IMAGE_MONITOR_ERROR_V2 = "ImageMonitorErrorV2";
    private static final String KEY_IMAGE_MONITOR_V2 = "ImageMonitorV2";
    private static final String KEY_LAST_FETCH_SETTING_TS = "LastFetchSetting";
    private static final String KEY_STATIC_ADAPTIVE_POLICY = "static_adaptive_policy";
    private static final String KEY_TTNET_CONFIG = "TTNetConfig";
    private static final String SHARED_NAME = "ImageCloudControl";
    private static final String TAG = "CloudControlCache";
    private SharedPreferences mSharedPreferences;
    private static final String KEY_HTTP2_ENABLE = "ttnet_h2_enabled";
    private static final String[] TTNET_SETTINGS_KEYS = {"ttnet_preconnect_urls", "ttnet_socket_pool_param", "ttnet_h2_config", KEY_HTTP2_ENABLE};
    private final int ENABLE_HTTPDNS = 1;
    private final int ENABLE_HTTP2 = 1;

    public CloudControlCache(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(SHARED_NAME, 0);
    }

    public void cacheCloudConfig(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            JSONObject jSONObject3 = jSONObject2.getJSONObject("custom_settings");
            JSONObject generateTtnetJson = generateTtnetJson(jSONObject3);
            JSONObject jSONObject4 = jSONObject2.getJSONObject("general_settings");
            JSONObject jSONObject5 = jSONObject3.getJSONObject("allow_log_type");
            JSONObject jSONObject6 = jSONObject3.getJSONObject(KEY_IMAGE_ADAPTIVE_FORMAT);
            int optInt = jSONObject3.optInt(KEY_ENABLE_SR);
            int optInt2 = jSONObject3.optInt(KEY_ENABLE_HEIF);
            int optInt3 = jSONObject3.optInt(KEY_DECODE_HEIC_USE_SYSTEM_API_FIRST);
            float optDouble = (float) jSONObject5.optDouble("imagex_load_monitor");
            float optDouble2 = (float) jSONObject5.optDouble("imagex_load_monitor_error");
            int optInt4 = jSONObject4.optInt("fetch_settings_interval");
            String adaptiveFormats = getAdaptiveFormats(jSONObject6.optJSONArray(KEY_STATIC_ADAPTIVE_POLICY));
            String adaptiveFormats2 = getAdaptiveFormats(jSONObject6.optJSONArray(KEY_ANIMATED_ADAPTIVE_POLICY));
            SharedPreferences.Editor edit = this.mSharedPreferences.edit();
            edit.putFloat(KEY_IMAGE_MONITOR_V2, optDouble);
            edit.putFloat(KEY_IMAGE_MONITOR_ERROR_V2, optDouble2);
            edit.putInt(KEY_FETCH_SETTING_INTERVAL, optInt4);
            edit.putLong(KEY_LAST_FETCH_SETTING_TS, System.currentTimeMillis());
            edit.putString(KEY_CLOUD_CONTROL_CONFIG, jSONObject.toString());
            edit.putString(KEY_TTNET_CONFIG, generateTtnetJson.toString());
            edit.putInt(KEY_ENABLE_SR, optInt);
            edit.putInt(KEY_ENABLE_HEIF, optInt2);
            edit.putInt(KEY_DECODE_HEIC_USE_SYSTEM_API_FIRST, optInt3);
            edit.putString(KEY_ANIMATED_ADAPTIVE_POLICY, adaptiveFormats2);
            edit.putString(KEY_STATIC_ADAPTIVE_POLICY, adaptiveFormats);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONObject generateTtnetJson(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject jSONObject4 = jSONObject.getJSONObject("httpdns_settings");
            cacheHttpdnsConfig(jSONObject4.optString(KEY_HTTPDNS_SERVICEID), null, jSONObject4.optInt(KEY_HTTPDNS_ENABLE));
            Iterator<String> keys = jSONObject4.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject3.put(next.toString(), jSONObject4.get(next));
                } catch (Exception unused) {
                    Log.e(TAG, "Json failed to get key " + ((Object) next) + " from httpdns_settings");
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        try {
            JSONObject jSONObject5 = jSONObject.getJSONObject("ttnet_settings");
            cacheHttp2Config(jSONObject5.optInt(KEY_HTTP2_ENABLE));
            for (String str : TTNET_SETTINGS_KEYS) {
                try {
                    jSONObject3.put(str, jSONObject5.get(str));
                } catch (Exception unused2) {
                    Log.e(TAG, "Json failed to get key " + str + " from ttnet_settings");
                }
            }
        } catch (Exception e2) {
            Log.e(TAG, e2.getMessage());
        }
        try {
            jSONObject2.put("data", jSONObject3);
            jSONObject2.put("message", "success");
        } catch (JSONException e3) {
            Log.e(TAG, e3.getMessage());
        }
        return jSONObject2;
    }

    private String getAdaptiveFormats(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            if (i > 0) {
                try {
                    sb.append(",");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            sb.append(jSONArray.getString(i));
        }
        return sb.toString();
    }

    public void cacheHttpdnsConfig(String str, String str2, int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(KEY_HTTPDNS_AUTH_ID, str);
        edit.putString(KEY_HTTPDNS_AUTH_KEY, str2);
        if (i == 1) {
            edit.putBoolean(KEY_HTTPDNS_ENABLE, true);
        } else {
            edit.putBoolean(KEY_HTTPDNS_ENABLE, false);
        }
        edit.apply();
    }

    public void cacheHttp2Config(int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        if (i == 1) {
            edit.putBoolean(KEY_HTTP2_ENABLE, true);
        } else {
            edit.putBoolean(KEY_HTTP2_ENABLE, false);
        }
        edit.apply();
    }

    public float getImageMonitorV2() {
        return this.mSharedPreferences.getFloat(KEY_IMAGE_MONITOR_V2, 0.0f);
    }

    public float getImageMonitorErrorV2() {
        return this.mSharedPreferences.getFloat(KEY_IMAGE_MONITOR_ERROR_V2, 1.0f);
    }

    public int getFetchSettingInterval() {
        return this.mSharedPreferences.getInt(KEY_FETCH_SETTING_INTERVAL, DateCalculationsKt.SECONDS_PER_HOUR);
    }

    public long getLastFetchSettingTimeStamp() {
        return this.mSharedPreferences.getLong(KEY_LAST_FETCH_SETTING_TS, 0L);
    }

    public String getCloudControlConfig() {
        return this.mSharedPreferences.getString(KEY_CLOUD_CONTROL_CONFIG, "No config, default value here");
    }

    public String getTTNetConfig() {
        return this.mSharedPreferences.getString(KEY_TTNET_CONFIG, null);
    }

    public String getHttpdnsAuthId() {
        return this.mSharedPreferences.getString(KEY_HTTPDNS_AUTH_ID, null);
    }

    public String getHttpdnsAuthKey() {
        return this.mSharedPreferences.getString(KEY_HTTPDNS_AUTH_KEY, null);
    }

    public boolean isEnableHttpdns() {
        return this.mSharedPreferences.getBoolean(KEY_HTTPDNS_ENABLE, false);
    }

    public boolean isEnableHttp2() {
        return this.mSharedPreferences.getBoolean(KEY_HTTP2_ENABLE, false);
    }

    public int isEnableSr() {
        return this.mSharedPreferences.getInt(KEY_ENABLE_SR, 0);
    }

    public int isEnableHeif() {
        return this.mSharedPreferences.getInt(KEY_ENABLE_HEIF, 1);
    }

    public int isDecodeHeicUseSystemApiFirst() {
        return this.mSharedPreferences.getInt(KEY_DECODE_HEIC_USE_SYSTEM_API_FIRST, 0);
    }

    public String getAnimatedAdaptivePolicy() {
        return this.mSharedPreferences.getString(KEY_ANIMATED_ADAPTIVE_POLICY, null);
    }

    public String getStaticAdaptivePolicy() {
        return this.mSharedPreferences.getString(KEY_STATIC_ADAPTIVE_POLICY, null);
    }
}
