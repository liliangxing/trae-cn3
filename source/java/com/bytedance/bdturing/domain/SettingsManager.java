package com.bytedance.bdturing.domain;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.cache.ResourceManager;
import com.bytedance.bdturing.livedetect.LiveModelResManager;
import com.bytedance.bdturing.setting.ConfigProvider;
import com.bytedance.bdturing.setting.ServiceInterceptor;
import com.bytedance.bdturing.setting.SettingUpdateRequest;
import com.bytedance.bdturing.ttnet.HttpClient;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SettingsManager {
    private static final String TAG = "SettingsManager";
    private static SettingUpdateRequest.Callback mRequestCallback = new SettingUpdateRequest.Callback() { // from class: com.bytedance.bdturing.domain.SettingsManager.1
        @Override // com.bytedance.bdturing.setting.SettingUpdateRequest.Callback
        public void onResponse(int i, String str, long j) {
            if (i == 200) {
                SettingsManager.recordSettingsInited();
            }
            EventReport.statisticSetting(j, i == 200 ? 0 : 1);
        }
    };

    private static String transfrom(int i) {
        return i != 1 ? i != 3 ? com.bytedance.bdturing.setting.SettingsManager.VERIFY_SERVICE : "qa" : "sms";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recordSettingsInited() {
        try {
            Context applicationContext = BdTuring.getInstance().getConfig() != null ? BdTuring.getInstance().getConfig().getApplicationContext() : null;
            if (applicationContext != null) {
                SharedPreferences.Editor edit = applicationContext.getSharedPreferences("bd_turning_settings_init", 0).edit();
                edit.putBoolean("inited", true);
                edit.commit();
            }
        } catch (Exception unused) {
        }
    }

    public static double getAlpha() {
        return com.bytedance.bdturing.setting.SettingsManager.INSTANCE.getServiceSettings(com.bytedance.bdturing.setting.SettingsManager.COMMON_SERVICE).optDouble("alpha", 0.5d);
    }

    public static JSONObject getSettings(int i) {
        return com.bytedance.bdturing.setting.SettingsManager.INSTANCE.getServiceSettings(transfrom(i));
    }

    public static void init(final BdTuringConfig bdTuringConfig) {
        com.bytedance.bdturing.setting.SettingsManager.INSTANCE.addCallback(ResourceManager.getInstance());
        com.bytedance.bdturing.setting.SettingsManager.INSTANCE.addCallback(LiveModelResManager.getInstance());
        com.bytedance.bdturing.setting.SettingsManager.INSTANCE.init(bdTuringConfig.getApplicationContext(), new ConfigProvider() { // from class: com.bytedance.bdturing.domain.SettingsManager.2
            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public String getSDKVersion() {
                return "4.1.1.cn";
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public String getAppVersionCode() {
                return BdTuringConfig.this.getAppVersionCode();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public ServiceInterceptor getServiceInterceptor() {
                return BdTuringConfig.this.getServiceInterceptor();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public HttpClient getHttpClient() {
                return BdTuringConfig.this.getHttpClient();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public String getAppId() {
                return BdTuringConfig.this.getAppId();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public String getInstallId() {
                return BdTuringConfig.this.getInstallId();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public String getDeviceId() {
                return BdTuringConfig.this.getDeviceId();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public String getLang() {
                return BdTuringConfig.this.getLanguage();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public String getAppName() {
                return BdTuringConfig.this.getAppName();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public String getAppVersion() {
                return BdTuringConfig.this.getAppVersion();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public String getChannel() {
                return BdTuringConfig.this.getChannel();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public String getRegion() {
                return (BdTuringConfig.this.getRegionType() != null ? BdTuringConfig.this.getRegionType() : BdTuringConfig.RegionType.REGION_CN).getName();
            }

            @Override // com.bytedance.bdturing.setting.ConfigProvider
            public Looper getWorkerLooper() {
                return VerifyTaskHandler.getInstance().getLooper();
            }
        });
        com.bytedance.bdturing.setting.SettingsManager.INSTANCE.addCallback(mRequestCallback);
    }
}
