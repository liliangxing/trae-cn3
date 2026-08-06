package com.bytedance.platform.settingsx.api.exposed;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.platform.settingsx.api.GlobalConfig;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ExposedManagerX {
    private static final String KET_VID_INFO = "key_vid_info";
    private static final String KEY_UPDATE_VERSION_CODE = "key_update_version_code";
    private static volatile ExposedManagerX sInstance;
    private boolean isEnable = false;
    private volatile boolean isSetUpdateVersionCode;
    private SharedPreferences.Editor mExposedEditor;
    private SharedPreferences mExposedSp;
    private SharedPreferences.Editor mLocalClientVidInfoEditor;
    private SharedPreferences mLocalClientVidInfoSp;
    private JSONObject mVidInfo;
    private SharedPreferences mVidInfoSp;
    private boolean useOneSpForAppSettings;

    public static ExposedManagerX getInstance(Context context) {
        if (sInstance == null) {
            synchronized (ExposedManagerX.class) {
                if (sInstance == null) {
                    sInstance = new ExposedManagerX(context);
                }
            }
        }
        return sInstance;
    }

    private ExposedManagerX(Context context) {
        this.mVidInfoSp = GlobalConfig.getSp().getSharedPreferences(context, "__ab_vid_info.sp", 0);
        this.mExposedSp = GlobalConfig.getSp().getSharedPreferences(context, "__ab_exposed_info.sp", 0);
        SharedPreferences sharedPreferences = GlobalConfig.getSp().getSharedPreferences(context, "__ab_local_exposed_info.sp", 0);
        this.mLocalClientVidInfoSp = sharedPreferences;
        this.mLocalClientVidInfoEditor = sharedPreferences.edit();
        this.mExposedEditor = this.mExposedSp.edit();
        String string = this.mVidInfoSp.getString(KET_VID_INFO, "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            this.mVidInfo = new JSONObject(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public synchronized void updateVidInfo(JSONObject jSONObject) {
        this.mVidInfo = jSONObject;
        this.mVidInfoSp.edit().putString(KET_VID_INFO, jSONObject.toString()).apply();
        for (String str : this.mExposedSp.getAll().keySet()) {
            if (!this.mVidInfo.has(str)) {
                this.mExposedEditor.remove(str);
            }
        }
        this.mExposedEditor.apply();
    }

    public void markExposed(String str) {
        if (this.mVidInfo != null) {
            synchronized (this) {
                JSONObject jSONObject = this.mVidInfo;
                if (jSONObject != null) {
                    long optLong = jSONObject.optLong(str);
                    if (optLong > 0 && !this.mExposedSp.contains(str)) {
                        this.mExposedEditor.putString(str, String.valueOf(optLong)).apply();
                    }
                }
            }
        }
    }

    public void markLocalClientExposed(String str) {
        if (TextUtils.isEmpty(str) || this.mLocalClientVidInfoSp == null) {
            return;
        }
        synchronized (this) {
            SharedPreferences sharedPreferences = this.mLocalClientVidInfoSp;
            if (sharedPreferences != null && !sharedPreferences.contains(str)) {
                this.mLocalClientVidInfoSp.edit().putString(str, str).apply();
            }
        }
    }

    public String getExposedVids() {
        StringBuilder sb;
        if (!this.isEnable) {
            return null;
        }
        if (this.mVidInfo != null) {
            sb = new StringBuilder();
            try {
                for (Object obj : this.mExposedSp.getAll().values()) {
                    if (sb.length() > 1) {
                        sb.append(",");
                    }
                    sb.append(obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            sb = null;
        }
        if (this.mLocalClientVidInfoSp != null) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            try {
                for (Map.Entry<String, ?> entry : this.mLocalClientVidInfoSp.getAll().entrySet()) {
                    if (!TextUtils.equals(entry.getKey(), KEY_UPDATE_VERSION_CODE)) {
                        Object value = entry.getValue();
                        if (sb.length() > 1) {
                            sb.append(",");
                        }
                        sb.append(value);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }

    public void setUpdateVersionCode(String str) {
        if (this.isSetUpdateVersionCode) {
            return;
        }
        this.isSetUpdateVersionCode = true;
        SharedPreferences sharedPreferences = this.mLocalClientVidInfoSp;
        if (sharedPreferences == null || this.mLocalClientVidInfoEditor == null) {
            return;
        }
        String string = sharedPreferences.getString(KEY_UPDATE_VERSION_CODE, "");
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(str)) {
                this.mLocalClientVidInfoEditor.putString(KEY_UPDATE_VERSION_CODE, "").apply();
                return;
            } else {
                this.mLocalClientVidInfoEditor.putString(KEY_UPDATE_VERSION_CODE, str).apply();
                return;
            }
        }
        if (TextUtils.equals(string, str)) {
            return;
        }
        this.mLocalClientVidInfoEditor.clear().apply();
    }
}
