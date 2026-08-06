package com.bytedance.android.live.core.setting;

import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class SettingGuard {
    private static String LOG_TYPE_LIVE_SETTING_EXCEPTION = "ttlive_setting_guard_log_type";
    private static final String SETTING_DIAGNOSE_SERVICE_NAME = "ttlive_setting_diagnose";
    public static final String TAG = "SettingGuard";

    private SettingGuard() {
    }

    public static void info(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveSettingOldContext.i(TAG, str);
    }

    public static void warn(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveSettingOldContext.w(TAG, str);
    }

    public static void error(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveSettingOldContext.e(TAG, str);
    }

    public static void error(String str, Throwable th) {
        if (th == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = " ";
        }
        LiveSettingOldContext.e(TAG, str, th);
    }

    public static void sendUnCatchException(String str, Throwable th) {
        if (str == null) {
            str = " ";
        }
        if (th == null) {
            try {
                th = new Throwable(str);
            } catch (Throwable th2) {
                LiveSettingOldContext.e("ensureNotReachHereTest", "error occur!", th2);
                return;
            }
        }
        if (LiveSettingConfig.LIVE_ENABLE_SETTING_MONITOR.getValue().booleanValue()) {
            LiveSettingOldContext.ensureNotReachHere(LOG_TYPE_LIVE_SETTING_EXCEPTION, th, "[SettingGuard]" + str);
        } else {
            LiveSettingOldContext.e(TAG, str, th);
        }
    }

    public static void sendSettingInitStep(String str, Map<String, String> map, Map<String, Number> map2) {
        LiveSettingOldContext.i(TAG, "setting_step: " + str);
        if (LiveSettingConfig.LIVE_ENABLE_SETTING_MONITOR.getValue().booleanValue()) {
            try {
                if (map == null) {
                    map = Collections.emptyMap();
                }
                JSONObject jSONObject = new JSONObject(map);
                if (map2 == null) {
                    map2 = Collections.emptyMap();
                }
                JSONObject jSONObject2 = new JSONObject(map2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject.put("step", str);
                LiveSettingOldContext.monitorEvent(SETTING_DIAGNOSE_SERVICE_NAME, jSONObject, jSONObject2, jSONObject3);
            } catch (JSONException e) {
                LiveSettingOldContext.e(TAG, "sendSettingInitStep format json failed", e);
            }
        }
    }
}
