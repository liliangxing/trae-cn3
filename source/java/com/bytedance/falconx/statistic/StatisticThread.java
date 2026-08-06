package com.bytedance.falconx.statistic;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.falconx.WebOfflineConfig;
import com.bytedance.falconx.WebOfflineGlobalMonitor;
import com.bytedance.falconx.utils.Constants;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.GeckoSDK;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class StatisticThread {
    private static volatile StatisticThread sInstance;
    private WebOfflineConfig mConfig;
    private Executor mExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.falconx.statistic.StatisticThread.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("falconx-io-thread");
            thread.setPriority(3);
            return thread;
        }
    });

    private StatisticThread() {
    }

    public static StatisticThread getInstance() {
        if (sInstance == null) {
            synchronized (StatisticThread.class) {
                if (sInstance == null) {
                    sInstance = new StatisticThread();
                }
            }
        }
        return sInstance;
    }

    public void setWebOfflineConfig(WebOfflineConfig webOfflineConfig) {
        this.mConfig = webOfflineConfig;
    }

    public void save(final WebView webView, final InterceptorModel interceptorModel) {
        this.mExecutor.execute(new Runnable() { // from class: com.bytedance.falconx.statistic.StatisticThread.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        WebOfflineGlobalMonitor.onInterceptRequest(webView, interceptorModel, true);
                    } catch (Throwable th) {
                        GeckoLogger.m299e("WebOfflineGlobalMonitor.onInterceptRequest", th);
                    }
                    StatisticThread statisticThread = StatisticThread.this;
                    statisticThread.report(statisticThread.mConfig.getAppVersion(), StatisticThread.this.mConfig.getDeviceId(), StatisticThread.this.mConfig.getRegion(), interceptorModel);
                } catch (Exception e) {
                    GeckoLogger.m303w("falconx intercept error:", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report(String str, String str2, String str3, InterceptorModel interceptorModel) {
        try {
            if (!TextUtils.isEmpty(this.mConfig.getHost()) && interceptorModel != null) {
                StatisticData statisticData = new StatisticData();
                statisticData.mCommon = new Common();
                statisticData.mCommon.appVersion = str;
                statisticData.mCommon.deviceId = str2;
                statisticData.mCommon.region = str3;
                String uuid = UUID.randomUUID().toString();
                interceptorModel.startTime = null;
                interceptorModel.logId = uuid;
                IStatisticMonitor statisticMonitor = this.mConfig.getStatisticMonitor();
                if (statisticMonitor != null) {
                    assembleData(interceptorModel, statisticData.mCommon);
                    if ((statisticMonitor instanceof DefaultStatisticMonitor) && interceptorModel.offlineStatus.intValue() == 1) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("aid", String.valueOf(WebOfflineConfig.getAid()));
                        jSONObject.put("gecko_sdk_version", "5.1.1.3-bugfix");
                        jSONObject.put("access_key", interceptorModel.accessKey);
                        jSONObject.put("channel", interceptorModel.channel);
                        jSONObject.put("package_id", interceptorModel.pkgVersion);
                        jSONObject.put("from", "1");
                        jSONObject.put("isCombo", interceptorModel.isCombo);
                        if (!TextUtils.isEmpty(interceptorModel.channel) && !TextUtils.isEmpty(interceptorModel.url)) {
                            String[] split = interceptorModel.url.split(interceptorModel.channel + "/");
                            if (split.length == 2) {
                                jSONObject.put("path", split[1]);
                            }
                        }
                        jSONObject.put("offline_rule", interceptorModel.offlineRule);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("read_duration", interceptorModel.offlineDuration);
                        ((DefaultStatisticMonitor) statisticMonitor).monitorEvent(String.valueOf(GeckoSDK.GECKO_AID), Constants.StatisticEvent.RESOURCE_LOAD_INFO, jSONObject, jSONObject2, null, null, false);
                    }
                }
            }
        } catch (Throwable th) {
            GeckoLogger.m303w("falconx-report:", th);
        }
    }

    private static JSONObject assembleData(InterceptorModel interceptorModel, Common common) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("params_for_special", "gecko");
        jSONObject.put("page_url", interceptorModel.pageUrl == null ? "" : interceptorModel.pageUrl);
        jSONObject.put("res_root_dir", interceptorModel.resRootDir == null ? "" : interceptorModel.resRootDir);
        jSONObject.put("resource_url", interceptorModel.url == null ? "" : interceptorModel.url);
        jSONObject.put("offline_rule", interceptorModel.offlineRule != null ? interceptorModel.offlineRule : "");
        jSONObject.put("mime_type", interceptorModel.mimeType);
        jSONObject.put("offline_status", interceptorModel.offlineStatus);
        jSONObject.put("offline_duration", interceptorModel.offlineDuration == null ? 0L : interceptorModel.offlineDuration.longValue());
        jSONObject.put("online_duration", interceptorModel.onlineDuration == null ? 0L : interceptorModel.onlineDuration.longValue());
        jSONObject.put("app_version", common.appVersion);
        jSONObject.put("sdk_version", common.sdkVersion);
        jSONObject.put("pkg_version", interceptorModel.pkgVersion != null ? interceptorModel.pkgVersion.longValue() : 0L);
        jSONObject.put("access_key", interceptorModel.accessKey);
        jSONObject.put("channel", interceptorModel.channel);
        jSONObject.put("os", common.f191os);
        jSONObject.put("device_id", common.deviceId);
        jSONObject.put("device_model", common.deviceModel);
        jSONObject.put("region", common.region);
        jSONObject.put("ac", interceptorModel.f192ac);
        jSONObject.put("err_code", interceptorModel.errCode);
        jSONObject.put("err_msg", interceptorModel.errMsg);
        jSONObject.put(ReportProtocal.KEY_LOG_ID, interceptorModel.logId);
        return jSONObject;
    }
}
