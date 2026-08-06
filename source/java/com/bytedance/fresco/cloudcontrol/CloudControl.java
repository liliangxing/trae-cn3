package com.bytedance.fresco.cloudcontrol;

import android.os.Build;
import com.bytedance.fresco.cloudcontrol.NetworkFetcher;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class CloudControl {
    private static final String PULL_CLOUD_CONFIG = "/app/monitor/settings";
    private static final String PULL_CLOUD_URL_BOE = "https://imagex-settings-boe.byted.org";
    private static final String PULL_CLOUD_URL_CN_NORTH = "https://imagex-settings.bytedanceapi.com";
    private static final String PULL_CLOUD_URL_SINGAPORE = "https://imagex-settings-sg.bytevcloudapi.com";
    private static final String PULL_CLOUD_URL_US_EAST = "https://imagex-settings-va.bytevcloudapi.com";
    private static final String TAG = "CloudControl";
    private static volatile CloudControl sSingleCloudControl;
    private InitConfig initConfig;
    private final CloudControlCache mControlCache;

    private String parseUriConfig(int i) {
        if (i == 2) {
            return PULL_CLOUD_URL_SINGAPORE;
        }
        if (i == 3) {
            return PULL_CLOUD_URL_US_EAST;
        }
        if (i == 1) {
            return PULL_CLOUD_URL_CN_NORTH;
        }
        if (i == 4) {
            return PULL_CLOUD_URL_BOE;
        }
        return null;
    }

    private CloudControl(InitConfig initConfig) {
        CloudControlCache cloudControlCache = new CloudControlCache(initConfig.getContext());
        this.mControlCache = cloudControlCache;
        this.initConfig = initConfig;
        if (canPullImageMonitorSettings(cloudControlCache)) {
            pullCloudConfig(initConfig.getAid(), "android", initConfig.getVersionName(), initConfig.getUriConfig(), "1.33.2", Build.VERSION.SDK);
        }
    }

    private boolean canPullImageMonitorSettings(CloudControlCache cloudControlCache) {
        return System.currentTimeMillis() - cloudControlCache.getLastFetchSettingTimeStamp() > ((long) (cloudControlCache.getFetchSettingInterval() * 1000));
    }

    public static void init(InitConfig initConfig) {
        sSingleCloudControl = new CloudControl(initConfig);
    }

    private void pullCloudConfig(String str, String str2, String str3, int i, String str4, String str5) {
        NetworkFetcher networkFetcher = new NetworkFetcher();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("os", str2);
        linkedHashMap.put("app_version", str3);
        linkedHashMap.put("sdk_version", str4);
        linkedHashMap.put("aid", str);
        linkedHashMap.put("os_version", str5);
        networkFetcher.fetch(parseUriConfig(i) + PULL_CLOUD_CONFIG, new NetworkFetcher.Callback() { // from class: com.bytedance.fresco.cloudcontrol.CloudControl.1
            @Override // com.bytedance.fresco.cloudcontrol.NetworkFetcher.Callback
            public void onResponse(InputStream inputStream, int i2) throws IOException {
                FLog.d(CloudControl.TAG, "Pull cloud config successfully");
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = inputStream.read();
                    if (read > 0) {
                        sb.append((char) read);
                    } else {
                        handleResponse(sb.toString());
                        return;
                    }
                }
            }

            private void handleResponse(String str6) throws IOException {
                FLog.d(CloudControl.TAG, "config : " + str6);
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (SccResult.MESSAGE_OK.equals(jSONObject.optString("msg"))) {
                        CloudControl.this.mControlCache.cacheCloudConfig(jSONObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.bytedance.fresco.cloudcontrol.NetworkFetcher.Callback
            public void onFailure(Throwable th) {
                FLog.e(CloudControl.TAG, "Failed to pull cloud config", th);
            }

            @Override // com.bytedance.fresco.cloudcontrol.NetworkFetcher.Callback
            public void onCancellation() {
                FLog.e(CloudControl.TAG, "Cancel to pull cloud config");
            }
        }, linkedHashMap);
    }

    private static CloudControl checkNotNull(CloudControl cloudControl) {
        if (cloudControl != null) {
            return cloudControl;
        }
        throw new IllegalStateException("CloudControl must be initiated first");
    }

    public static boolean isHeifEnabled() {
        return checkNotNull(sSingleCloudControl).mControlCache.isEnableHeif() == 1;
    }

    public static boolean isSrEnabled() {
        return checkNotNull(sSingleCloudControl).mControlCache.isEnableSr() == 1;
    }

    public static boolean isHttp2Enabled() {
        return checkNotNull(sSingleCloudControl).mControlCache.isEnableHttp2();
    }

    public static boolean isHttpDnsEnabled() {
        return checkNotNull(sSingleCloudControl).mControlCache.isEnableHttpdns();
    }

    public static boolean canUploadImageMonitorV2ForSampling() {
        return Float.compare(checkNotNull(sSingleCloudControl).mControlCache.getImageMonitorV2(), new Random().nextFloat()) == 1;
    }

    public static boolean canUploadImageMonitorErrorV2ForSampling() {
        return Float.compare(checkNotNull(sSingleCloudControl).mControlCache.getImageMonitorErrorV2(), new Random().nextFloat()) == 1;
    }

    public static String getCloudControlConfig() {
        return checkNotNull(sSingleCloudControl).mControlCache.getCloudControlConfig();
    }

    public static String getTTNetConfig() {
        return checkNotNull(sSingleCloudControl).mControlCache.getTTNetConfig();
    }

    public static String getHttpdnsAuthId() {
        return checkNotNull(sSingleCloudControl).mControlCache.getHttpdnsAuthId();
    }

    public static String getHttpdnsAuthKey() {
        return checkNotNull(sSingleCloudControl).mControlCache.getHttpdnsAuthKey();
    }

    public static boolean getDecodeHeicUseSystemApiFirst() {
        return checkNotNull(sSingleCloudControl).mControlCache.isDecodeHeicUseSystemApiFirst() == 1;
    }

    public static String[] getStaticAdaptivePolicy() {
        String staticAdaptivePolicy = checkNotNull(sSingleCloudControl).mControlCache.getStaticAdaptivePolicy();
        if (staticAdaptivePolicy == null || staticAdaptivePolicy.isEmpty()) {
            return null;
        }
        return staticAdaptivePolicy.split(",");
    }

    public static String[] getAnimatedAdaptivePolicy() {
        String animatedAdaptivePolicy = checkNotNull(sSingleCloudControl).mControlCache.getAnimatedAdaptivePolicy();
        if (animatedAdaptivePolicy == null || animatedAdaptivePolicy.isEmpty()) {
            return null;
        }
        return animatedAdaptivePolicy.split(",");
    }

    public static InitConfig getInitConfig() {
        return checkNotNull(sSingleCloudControl).initConfig;
    }

    public static String getExpectImageFormat() {
        return ImageFormatUtils.getExpectImageFormat();
    }
}
