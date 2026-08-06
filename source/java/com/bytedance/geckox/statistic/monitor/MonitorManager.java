package com.bytedance.geckox.statistic.monitor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.net.Api;
import com.bytedance.geckox.utils.GeckoSDK;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorManager {
    private AtomicBoolean mIsInit;
    private SDKMonitor mSDKMonitor;

    private MonitorManager() {
        this.mIsInit = new AtomicBoolean(false);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class SingletonHolder {
        private static MonitorManager instance = new MonitorManager();

        private SingletonHolder() {
        }
    }

    public static MonitorManager inst() {
        return SingletonHolder.instance;
    }

    public void init(Context context, final GeckoGlobalConfig geckoGlobalConfig) {
        final GeckoGlobalConfig.IMonitorConfig monitorConfig = geckoGlobalConfig.getMonitorConfig();
        if (monitorConfig != null && this.mIsInit.compareAndSet(false, true)) {
            String valueOf = String.valueOf(monitorConfig.isOversea() ? GeckoSDK.GECKO_SDK_AID_OVERSEA : GeckoSDK.GECKO_SDK_AID);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_id", geckoGlobalConfig.getDeviceId());
                jSONObject.put("host_aid", geckoGlobalConfig.getAppId());
                jSONObject.put("sdk_version", "5.2.4");
                jSONObject.put("app_version", geckoGlobalConfig.getAppVersion());
                String channel = monitorConfig.getChannel();
                if (!TextUtils.isEmpty(channel)) {
                    jSONObject.put("channel", channel);
                }
                String updateVersionCode = monitorConfig.getUpdateVersionCode();
                if (!TextUtils.isEmpty(updateVersionCode)) {
                    jSONObject.put("update_version_code", updateVersionCode);
                }
                String packageId = monitorConfig.getPackageId();
                if (!TextUtils.isEmpty(packageId)) {
                    jSONObject.put("package_name", packageId);
                }
                SDKMonitorUtils.setDefaultReportUrl(valueOf, Collections.singletonList(monitorConfig.getMonitorHost() + Api.MONITOR_REPORT));
                SDKMonitorUtils.setConfigUrl(valueOf, Collections.singletonList(monitorConfig.getMonitorHost() + Api.MONITOR_CONFIG));
                SDKMonitorUtils.initMonitor(context.getApplicationContext(), valueOf, jSONObject, new SDKMonitor.IGetExtendParams() { // from class: com.bytedance.geckox.statistic.monitor.MonitorManager.1
                    public String getSessionId() {
                        return null;
                    }

                    public Map<String, String> getCommonParams() {
                        Map<String, String> commonParams = monitorConfig.getCommonParams();
                        if (commonParams == null) {
                            commonParams = new HashMap<>();
                        }
                        commonParams.put("oversea", monitorConfig.isOversea() ? "1" : "0");
                        commonParams.put("host_aid", String.valueOf(geckoGlobalConfig.getAppId()));
                        return commonParams;
                    }
                });
                this.mSDKMonitor = SDKMonitorUtils.getInstance(valueOf);
            } catch (JSONException e) {
                GeckoLogger.m296d("monitor init failed:" + e.getMessage());
            }
        }
    }

    public boolean hasInit() {
        return this.mIsInit.get();
    }

    public void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        if (!this.mIsInit.get()) {
            throw new IllegalStateException("Please init MonitorManager first");
        }
        SDKMonitor sDKMonitor = this.mSDKMonitor;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorStatusAndDuration(str, i, jSONObject, jSONObject2);
    }

    public void monitorStatusRate(String str, int i, JSONObject jSONObject) {
        if (!this.mIsInit.get()) {
            throw new IllegalStateException("Please init MonitorManager first");
        }
        SDKMonitor sDKMonitor = this.mSDKMonitor;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorStatusRate(str, i, jSONObject);
    }

    public void monitorDuration(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (!this.mIsInit.get()) {
            throw new IllegalStateException("Please init MonitorManager first");
        }
        SDKMonitor sDKMonitor = this.mSDKMonitor;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorDuration(str, jSONObject, jSONObject2);
    }

    public void monitorCommonLog(String str, JSONObject jSONObject) {
        if (!this.mIsInit.get()) {
            throw new IllegalStateException("Please init MonitorManager first");
        }
        SDKMonitor sDKMonitor = this.mSDKMonitor;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorCommonLog(str, jSONObject);
    }

    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (!this.mIsInit.get()) {
            throw new IllegalStateException("Please init MonitorManager first");
        }
        SDKMonitor sDKMonitor = this.mSDKMonitor;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
    }
}
