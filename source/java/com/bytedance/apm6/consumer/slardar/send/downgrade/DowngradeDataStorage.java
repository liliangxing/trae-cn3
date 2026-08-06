package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class DowngradeDataStorage {
    private static final String KEY_RULE = "rule";
    private static final String PREFS_MONITOR_DOWNGRADE = "monitor_downgrade";
    public static final String TAG = "APM-Downgrade";
    private SharedPreferences mPrefs;

    public DowngradeDataStorage(Context context) {
        if (this.mPrefs == null) {
            synchronized (this) {
                if (this.mPrefs == null) {
                    this.mPrefs = context.getSharedPreferences(PREFS_MONITOR_DOWNGRADE, 0);
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
        if (ApmContext.isDebugMode()) {
            Logger.i(TAG, "DowngradeData-save-" + jSONObject);
        }
        this.mPrefs.edit().putString("rule", json.toString()).apply();
    }

    public DowngradeInfo loadFromSp() {
        String string = this.mPrefs.getString("rule", null);
        if (string != null) {
            try {
                if (ApmContext.isDebugMode()) {
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
