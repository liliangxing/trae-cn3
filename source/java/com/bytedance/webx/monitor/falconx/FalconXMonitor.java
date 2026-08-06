package com.bytedance.webx.monitor.falconx;

import android.webkit.WebView;
import com.bytedance.android.monitor.executor.MonitorExecutor;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper;
import com.bytedance.falconx.WebOfflineGlobalMonitor;
import com.bytedance.falconx.statistic.InterceptorModel;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class FalconXMonitor {
    private static volatile FalconXMonitor instance;
    private boolean hasSetMonitor = false;

    public static FalconXMonitor getInstance() {
        if (instance == null) {
            synchronized (FalconXMonitor.class) {
                if (instance == null) {
                    instance = new FalconXMonitor();
                }
            }
        }
        return instance;
    }

    public void beginMonitor() {
        if (this.hasSetMonitor) {
            return;
        }
        this.hasSetMonitor = true;
        WebOfflineGlobalMonitor.setGlobalMonitor(new WebOfflineGlobalMonitor.IGlobalMonitor() { // from class: com.bytedance.webx.monitor.falconx.FalconXMonitor.1
            public void onInterceptRequest(final WebView webView, final InterceptorModel interceptorModel, final boolean z) {
                if (webView == null || interceptorModel == null) {
                    return;
                }
                MonitorExecutor.INSTANCE.getExecutor().execute(new Runnable() { // from class: com.bytedance.webx.monitor.falconx.FalconXMonitor.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            JsonUtils.safePut(jSONObject, "is_custom_interceptor", z ? 0 : 1);
                            JsonUtils.safePut(jSONObject, "resource_url", interceptorModel.url);
                            JsonUtils.safePut(jSONObject, "offline_rule", interceptorModel.offlineRule);
                            JsonUtils.safePut(jSONObject, "offline_status", interceptorModel.offlineStatus);
                            JsonUtils.safePut(jSONObject, "offline_duration", interceptorModel.offlineDuration);
                            JsonUtils.safePut(jSONObject, "channel", interceptorModel.channel);
                            JsonUtils.safePut(jSONObject, "mime_type", interceptorModel.mimeType);
                            JsonUtils.safePut(jSONObject, "error_code", interceptorModel.errCode);
                            JsonUtils.safePut(jSONObject, "package_version", interceptorModel.pkgVersion);
                            JsonUtils.safePut(jSONObject, "ac", interceptorModel.ac);
                            TTLiveWebViewMonitorHelper.getInstance().saveData(webView, interceptorModel.pageUrl, "falconPerf", jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
