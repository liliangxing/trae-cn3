package com.bytedance.framwork.core.sdklib.apm6.downgrade;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.framwork.core.sdklib.apm6.SDKContext;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import com.bytedance.framwork.core.sdkmonitor.MonitorHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class DowngradeDataStorage {
    private static final String KEY_RULE = "rule";
    private static final String PREFS_MONITOR_DOWNGRADE = "monitor_downgrade";
    public static final String TAG = "SDK-Downgrade";
    private SharedPreferences mPrefs;

    public DowngradeDataStorage(Context context) {
        if (this.mPrefs == null) {
            synchronized (this) {
                if (this.mPrefs == null) {
                    this.mPrefs = context.getSharedPreferences(PREFS_MONITOR_DOWNGRADE + MonitorHelper.getShortProcessName(context), 0);
                }
            }
        }
    }

    public void save(DowngradeInfo downgradeInfo) {
        JSONObject json;
        if (downgradeInfo == null || this.mPrefs == null || (json = downgradeInfo.toJson()) == null) {
            return;
        }
        String jSONObject = json.toString();
        if (SDKContext.isDebugMode()) {
            Logger.i(TAG, "DowngradeData-save-" + jSONObject);
        }
        this.mPrefs.edit().putString("rule", jSONObject).apply();
    }

    public DowngradeInfo loadFromSp() {
        String string = this.mPrefs.getString("rule", null);
        if (string != null) {
            try {
                if (SDKContext.isDebugMode()) {
                    Logger.i(TAG, "DowngradeData-load-" + string);
                }
                DowngradeInfo parse = DowngradeInfo.parse(new JSONObject(string));
                if (System.currentTimeMillis() < parse.expireTime) {
                    return parse;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
