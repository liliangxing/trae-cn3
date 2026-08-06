package com.bytedance.push.event.sync.adapter;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.bytedance.common.model.ClientDisplayFeature;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.SystemUtils;
import com.ss.android.message.AppProvider;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClientDisplayFeatureReporter extends AbsSignalReporterAdapter {
    private final String TAG = "UserDisplayInfoReporter";

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    String getSignalName() {
        return ISignalReportConstants.SIGNAL_NAME_USER_DISPLAY_INFO;
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void startSignalReport(String str, SignalReportConfig signalReportConfig) {
        super.startSignalReport(str, signalReportConfig);
        reportUserDisplayInfo();
    }

    private void reportUserDisplayInfo() {
        Application app = AppProvider.getApp();
        ContentResolver contentResolver = app.getContentResolver();
        ClientDisplayFeature clientDisplayFeature = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mClientDisplayFeature;
        if (clientDisplayFeature == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        add(jSONObject2, ISignalReportConstants.KEY_DISPLAY_BRIGHTNESS, getScreenBrightness(contentResolver));
        add(jSONObject2, ISignalReportConstants.KEY_DISPLAY_AUTO_BRIGHTNESS, isAutoBrightnessEnabled(contentResolver));
        add(jSONObject2, "font_scale", getFontScale(contentResolver));
        add(jSONObject2, "dark_mode_enabled", isDarkModeEnabled(app));
        add(jSONObject3, "font_scale", clientDisplayFeature.getFontScale());
        add(jSONObject3, ISignalReportConstants.KEY_DISPLAY_APP_FOLLOW_SYSTEM, clientDisplayFeature.isFontFollowSystem().booleanValue());
        add(jSONObject3, ISignalReportConstants.KEY_DISPLAY_APP_FONT_LARGE_MODE, clientDisplayFeature.isLargeMode().booleanValue());
        add(jSONObject3, "dark_mode_enabled", clientDisplayFeature.isDarkMode().booleanValue());
        add(jSONObject, ISignalReportConstants.KEY_SYSTEM_DISPLAY, jSONObject2);
        add(jSONObject, ISignalReportConstants.KEY_APP_DISPLAY, jSONObject3);
        add(jSONObject, ISignalReportConstants.KEY_BUSINESS_EXTRA_STRING, clientDisplayFeature.getExtraParams());
        Logger.m268d("UserDisplayInfoReporter", String.valueOf(jSONObject));
        PushSupporter.get().getSignalReportService().getISignalReporter().reportSignal(this.mSignalReportConfig, getSignalName(), this.mTriggerScene, jSONObject);
    }

    private int getScreenBrightness(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            Logger.m271e("UserDisplayInfoReporter", "getScreenBrightness: " + e);
            e.printStackTrace();
            return -1;
        }
    }

    private boolean isAutoBrightnessEnabled(ContentResolver contentResolver) {
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            Logger.m271e("UserDisplayInfoReporter", "isAutoBrightnessEnabled: " + e);
            e.printStackTrace();
            return false;
        }
    }

    private float getFontScale(ContentResolver contentResolver) {
        try {
            return Settings.System.getFloat(contentResolver, "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            Logger.m271e("UserDisplayInfoReporter", "getFontScale: " + e);
            e.printStackTrace();
            return -1.0f;
        }
    }

    private boolean isDarkModeEnabled(Context context) {
        return SystemUtils.isDarkMode(context);
    }
}
