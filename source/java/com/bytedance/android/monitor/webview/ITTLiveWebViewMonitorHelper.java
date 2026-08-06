package com.bytedance.android.monitor.webview;

import android.webkit.WebView;
import com.bytedance.android.monitor.DataMonitor;
import com.bytedance.android.monitor.base.IMonitor;
import com.bytedance.android.monitor.standard.ContainerStandardAction;
import com.bytedance.android.monitor.webview.base.IBusinessCustom;
import com.bytedance.android.monitor.webview.base.IDeprecated;
import com.bytedance.android.monitor.webview.base.IMonitorConfig;
import com.bytedance.android.monitor.webview.base.ITTWebviewDetect;
import com.bytedance.android.monitor.webview.base.IWebBlankCallback;
import com.bytedance.android.monitor.webview.base.IWebCustom;
import com.bytedance.android.monitor.webview.base.IWebExtension;
import com.bytedance.android.monitor.webview.base.IWebviewLifeCycle;
import com.bytedance.android.monitor.webview.gecko.IMonitorGeckoClient;
import com.bytedance.bdturing.verify.TuringVerifyType;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface ITTLiveWebViewMonitorHelper extends IWebviewLifeCycle, IWebCustom, IDeprecated, IMonitorConfig, IWebExtension, IBusinessCustom, ITTWebviewDetect, ContainerStandardAction {
    void report(WebView webView);

    void reportTruly(WebView webView);

    void setEnable(boolean z);

    void setExecutor(ExecutorService executorService);

    void setGeckoClient(IMonitorGeckoClient iMonitorGeckoClient);

    void setTTWebDelegateEnable(boolean z);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Config {
        ITTLiveWebViewMonitorCustomCallback mCustomCallback;
        String mDebugTag;
        ITTLiveWebViewMonitorInfoHandler mInfoHandler;
        IWebBlankCallback mWebBlankCallback;
        String[] mWebViewClasses;
        String[] mWebViewObjKeys;
        ITTWebviewDetect mWebviewDetect;
        IMonitor monitor;
        ITTLiveWebViewMonitor sourceMonitor;
        String virtualAid;
        String mSettingConfig = "";
        boolean mOpenBlankDetect = true;
        boolean mOpenMainRequestDetect = true;
        boolean mOpenJSBDetect = true;
        boolean mOpenFetchDetect = true;
        boolean mOpenLoadLatestPageData = true;
        boolean mIsNeedMonitor = false;
        boolean mIsAutoReport = false;
        boolean mIsNeedDirectPerformance = false;
        String mPerformanceLocType = "loc_after_detach";
        boolean mIsNeedInjectBrowser = true;
        String mSlardarSDKConfig = "";
        String mSlardarSDKPath = "";
        int mWaitForUpdatePageData = 100;
        String mBiz = "";

        @Deprecated
        public Config setSlardarSDKPath(String str) {
            return this;
        }

        public Config setInfoHandler(ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler) {
            this.mInfoHandler = iTTLiveWebViewMonitorInfoHandler;
            return this;
        }

        public Config setDebugTag(String str) {
            this.mDebugTag = str;
            return this;
        }

        public Config setWebViewClasses(String... strArr) {
            this.mWebViewClasses = strArr;
            return this;
        }

        public Config setWebViewObjKeys(String... strArr) {
            this.mWebViewObjKeys = strArr;
            return this;
        }

        public Config setWebViewObjKeys(WebView... webViewArr) {
            if (webViewArr != null && webViewArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (WebView webView : webViewArr) {
                    if (webView != null) {
                        arrayList.add(TTLiveWebViewMonitorHelper.getInstance().createWebViewKey(webView));
                    }
                }
                this.mWebViewObjKeys = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return this;
        }

        public Config setMonitor(ITTLiveWebViewMonitor iTTLiveWebViewMonitor) {
            this.sourceMonitor = iTTLiveWebViewMonitor;
            this.monitor = new DataMonitor(iTTLiveWebViewMonitor);
            return this;
        }

        public Config setSettingConfig(String str) {
            this.mSettingConfig = str;
            return this;
        }

        @Deprecated
        public Config setTTWebviewDetector(ITTWebviewDetect iTTWebviewDetect) {
            this.mWebviewDetect = iTTWebviewDetect;
            return this;
        }

        public Config setBiz(String str) {
            this.mBiz = str;
            return this;
        }

        @Deprecated
        public Config setIsLive(boolean z) {
            if (z) {
                setBiz(TuringVerifyType.live);
            }
            return this;
        }

        public Config setIsNeedMonitor(boolean z) {
            this.mIsNeedMonitor = z;
            return this;
        }

        public Config setIsNeedInjectBrowser(boolean z) {
            this.mIsNeedInjectBrowser = z;
            return this;
        }

        @Deprecated
        public Config setSlardarSDKConfig(String str) {
            this.mSlardarSDKConfig = str;
            return this;
        }

        public Config setIsAutoReport(boolean z) {
            this.mIsAutoReport = z;
            return this;
        }

        @Deprecated
        public Config setIsNeedDirectPerformance(boolean z) {
            this.mIsNeedDirectPerformance = z;
            return this;
        }

        public Config setPerformanceReportAfterTTI() {
            this.mPerformanceLocType = "loc_after_tti";
            return this;
        }

        public Config setPerformanceReportAfterDetach() {
            this.mPerformanceLocType = "loc_after_detach";
            return this;
        }

        public Config setCustomCallback(ITTLiveWebViewMonitorCustomCallback iTTLiveWebViewMonitorCustomCallback) {
            this.mCustomCallback = iTTLiveWebViewMonitorCustomCallback;
            return this;
        }

        public Config setOpenBlankDetect(boolean z) {
            this.mOpenBlankDetect = z;
            return this;
        }

        public Config setOpenJSBDetect(boolean z) {
            this.mOpenJSBDetect = z;
            return this;
        }

        public Config setOpenFetchDetect(boolean z) {
            this.mOpenFetchDetect = z;
            return this;
        }

        public Config setOpenMainFrameError(boolean z) {
            this.mOpenMainRequestDetect = z;
            return this;
        }

        @Deprecated
        public Config setWaitTimeForUpdatePageData(int i) {
            this.mWaitForUpdatePageData = i;
            return this;
        }

        public Config setOpenLoadLatestPageData(boolean z) {
            this.mOpenLoadLatestPageData = z;
            return this;
        }

        public Config setVirtualAID(String str) {
            this.virtualAid = str;
            return this;
        }

        public Config setBlankDetectCallback(IWebBlankCallback iWebBlankCallback) {
            this.mWebBlankCallback = iWebBlankCallback;
            return this;
        }
    }
}
