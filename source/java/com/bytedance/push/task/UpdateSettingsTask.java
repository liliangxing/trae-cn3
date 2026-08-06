package com.bytedance.push.task;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.settings.AliveOnlineSettings;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.StatisticsSettings;
import com.bytedance.push.third.PushLifeManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.pushmanager.setting.PushSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UpdateSettingsTask implements Runnable {
    private static final String TAG = "UpdateSettingsTask";
    public static final String UPDATE_SOURCE_HOST = "settings_source_host";
    public static final String UPDATE_SOURCE_SDK = "settings_source_sdk";
    private final Context mContext;
    private final boolean mIsPreInstallVersion;
    private final JSONObject mSettings;
    private boolean mSynchronous;
    private final String mUpdateSource;

    public static void updateSettings(Context context, JSONObject jSONObject, boolean z, String str) {
        new UpdateSettingsTask(context, jSONObject, z, str, false).run();
    }

    public static void updateSettingsSynchronous(Context context, JSONObject jSONObject, boolean z, String str) {
        new UpdateSettingsTask(context, jSONObject, z, str, true).run();
    }

    public UpdateSettingsTask(Context context, JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2;
        this.mContext = context;
        try {
            jSONObject2 = new JSONObject(jSONObject.toString());
        } catch (Throwable unused) {
            Logger.m271e(TAG, "error when clone Settings object");
            jSONObject2 = null;
        }
        this.mSettings = jSONObject2;
        this.mIsPreInstallVersion = z;
        this.mUpdateSource = null;
    }

    private UpdateSettingsTask(Context context, JSONObject jSONObject, boolean z, String str, boolean z2) {
        this.mContext = context;
        this.mSettings = jSONObject;
        this.mIsPreInstallVersion = z;
        this.mUpdateSource = str;
        this.mSynchronous = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mSettings == null) {
            return;
        }
        updatePushSettings(this.mUpdateSource);
        updateAllianceSettings();
        for (Object obj : PushSetting.getInstance().getSettingsUpdateListenerSet()) {
            ((ISettingsUpdateListener) obj).onSettingsUpdate();
        }
    }

    private void updateAllianceSettings() {
        JSONObject jSONObject = this.mSettings;
        if (jSONObject.has("sdk_key_alliance_sdk")) {
            jSONObject = this.mSettings.optJSONObject("sdk_key_alliance_sdk");
        }
        if (jSONObject == null) {
            Logger.m271e(TAG, "can't find settings");
            if (Logger.debug()) {
                throw new IllegalArgumentException("settings missing sdk_key_alliance_sdk");
            }
        } else if (this.mIsPreInstallVersion) {
            parseSettingsWhenPreInstallForAlliance(this.mContext, jSONObject);
        } else {
            parseSettingsForAlliance(this.mContext, jSONObject);
        }
    }

    private void parseSettingsForAlliance(Context context, JSONObject jSONObject) {
        PushServiceManager.get().getIAllianceService().updateSettings(context, jSONObject);
    }

    private void parseSettingsWhenPreInstallForAlliance(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("alliance_sdk_enable_wakeup", false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        parseSettingsForAlliance(context, jSONObject);
    }

    private void updatePushSettings(String str) {
        Logger.m268d(TAG, "[updatePushSettings]updateSource:" + str);
        JSONObject jSONObject = this.mSettings;
        if (jSONObject.has("sdk_key_PushSDK")) {
            jSONObject = this.mSettings.optJSONObject("sdk_key_PushSDK");
        }
        if (jSONObject == null) {
            Logger.m271e(TAG, "can't find settings");
            if (Logger.debug()) {
                throw new IllegalArgumentException("settings missing sdk_key_PushSDK");
            }
            return;
        }
        if (!TextUtils.equals(str, UPDATE_SOURCE_SDK)) {
            for (String str2 : PushOnlineSettings.SDK_SETTINGS_KEY) {
                Logger.m268d(TAG, "cur settings source is not UPDATE_SOURCE_SDK,remove " + str2);
                jSONObject.remove(str2);
            }
        }
        if (this.mIsPreInstallVersion) {
            parseSettingsWhenPreInstall(this.mContext, jSONObject);
        } else {
            parseSettings(this.mContext, jSONObject);
        }
    }

    private void parseSettingsWhenPreInstall(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            jSONObject2.remove(AliveOnlineSettings.SERVER_KEY_NOTIFY_STICKY);
            jSONObject2.remove(AliveOnlineSettings.SERVER_KEY_PUSH_DAEMON);
            jSONObject2.remove(AliveOnlineSettings.SERVER_KEY_ALARM_WAKE_UP);
            jSONObject2.remove(AliveOnlineSettings.SERVER_KEY_JOB_SERVICE);
            parseSettings(context, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseSettings(final Context context, final JSONObject jSONObject) {
        Runnable runnable = new Runnable() { // from class: com.bytedance.push.task.UpdateSettingsTask.1
            @Override // java.lang.Runnable
            public void run() {
                ((AliveOnlineSettings) SettingsManager.obtain(context, AliveOnlineSettings.class)).updateSettings(context, jSONObject);
                PushOnlineSettings pushOnlineSettings = (PushOnlineSettings) SettingsManager.obtain(context, PushOnlineSettings.class);
                if (jSONObject.has(PushOnlineSettings.KEY_PULL_API_STRATEGY)) {
                    ((LocalSettings) SettingsManager.obtain(context, LocalSettings.class)).setPullApiStrategyOfOnlineSettings(jSONObject.optInt(PushOnlineSettings.KEY_PULL_API_STRATEGY));
                    jSONObject.remove(PushOnlineSettings.KEY_PULL_API_STRATEGY);
                }
                pushOnlineSettings.updateSettings(context, jSONObject);
                ((StatisticsSettings) SettingsManager.obtain(context, StatisticsSettings.class)).updateSettings(context, jSONObject);
                UpdateSettingsTask.this.notifyThirdSettings(context, jSONObject);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadPlus.submitRunnable(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyThirdSettings(Context context, JSONObject jSONObject) {
        PushLifeManager.inst().onSetSettingsData(context, jSONObject);
    }
}
