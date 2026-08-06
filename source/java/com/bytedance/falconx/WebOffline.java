package com.bytedance.falconx;

import android.os.SystemClock;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.falconx.debug.WebOfflineAnalyze;
import com.bytedance.falconx.statistic.InterceptorModel;
import com.bytedance.falconx.statistic.StatisticThread;
import com.bytedance.geckox.logger.GeckoLogger;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WebOffline {
    public static final String TAG = "WebOffline-falcon";
    private boolean isEnable = true;
    private WebOfflineConfig mConfig;
    private FalconRequestIntercept mFalconRequestIntercept;

    public WebOffline(WebOfflineConfig webOfflineConfig) {
        if (webOfflineConfig == null) {
            throw new IllegalArgumentException("config == null");
        }
        this.mConfig = webOfflineConfig;
        StatisticThread.getInstance().setWebOfflineConfig(this.mConfig);
        this.mFalconRequestIntercept = new FalconRequestIntercept(this.mConfig);
        WebOfflineAnalyze.addOfflineCache(this.mConfig);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!isEnable()) {
            return null;
        }
        try {
            List<IRequestIntercept> requestIntercepts = this.mConfig.getRequestIntercepts();
            if (requestIntercepts != null && !requestIntercepts.isEmpty()) {
                InterceptorModel interceptorModel = new InterceptorModel();
                for (IRequestIntercept iRequestIntercept : requestIntercepts) {
                    interceptorModel.startTime = Long.valueOf(SystemClock.uptimeMillis());
                    WebResourceResponse shouldInterceptRequest = iRequestIntercept.shouldInterceptRequest(webView, str);
                    if (shouldInterceptRequest != null) {
                        interceptorModel.loadFinish(true);
                        interceptorModel.url = str;
                        interceptorModel.mimeType = shouldInterceptRequest.getMimeType();
                        WebOfflineGlobalMonitor.onInterceptRequest(webView, interceptorModel, false);
                        return shouldInterceptRequest;
                    }
                }
            }
            return this.mFalconRequestIntercept.shouldInterceptRequest(webView, str);
        } catch (Throwable th) {
            GeckoLogger.m302w(TAG, "shouldInterceptRequest:", th);
            return null;
        }
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public void release() throws Throwable {
        this.mFalconRequestIntercept.release();
        WebOfflineAnalyze.release();
    }
}
