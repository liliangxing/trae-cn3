package com.bytedance.android.monitorV2.webview;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.standard.ContainerStandardAction;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.base.IBusinessCustom;
import com.bytedance.android.monitorV2.webview.base.IDeprecated;
import com.bytedance.android.monitorV2.webview.base.IMonitorConfig;
import com.bytedance.android.monitorV2.webview.base.IWebBlankCallback;
import com.bytedance.android.monitorV2.webview.base.IWebCustom;
import com.bytedance.android.monitorV2.webview.base.IWebExtension;
import com.bytedance.android.monitorV2.webview.base.InterfaceC0190IWebviewLifeCycle;
import com.bytedance.android.monitorV2.webview.gecko.IHybridMonitorGeckoClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IWebViewMonitorHelper extends InterfaceC0190IWebviewLifeCycle, IWebCustom, IDeprecated, IMonitorConfig, IWebExtension, IBusinessCustom, ContainerStandardAction {
    HashMap<String, Object> getExtraInfo(WebView webView);

    void report(WebView webView);

    void setEnable(boolean z);

    void setGeckoClient(IHybridMonitorGeckoClient iHybridMonitorGeckoClient);

    void setTTWebDelegateEnable(boolean z);

    /* loaded from: classes3.dex */
    public static class Config {

        @Deprecated
        String fallbackContainerName;
        IWebBlankCallback mWebBlankCallback;
        String[] mWebViewClasses;
        String[] mWebViewObjKeys;
        IHybridMonitor sourceMonitor;
        String virtualAid;
        String mSettingConfig = "";

        @Deprecated
        boolean mIsNeedInjectBrowser = true;
        boolean mIsNeedMonitor = true;
        String mBid = "";
        JSONObject mContext = new JSONObject();
        String mSlardarSDKConfig = "";
        String mSlardarSDKPath = "";
        public String mSessionId = "";

        public Config setPerformanceReportAfterDetach() {
            return this;
        }

        public Config setPerformanceReportAfterTTI() {
            return this;
        }

        @Deprecated
        public Config setSlardarSDKPath(String str) {
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
                        arrayList.add(createWebViewKey(webView));
                    }
                }
                this.mWebViewObjKeys = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return this;
        }

        @Deprecated
        public Config setMonitor(IHybridMonitor iHybridMonitor) {
            this.sourceMonitor = iHybridMonitor;
            return this;
        }

        public Config setSettingConfig(String str) {
            this.mSettingConfig = str;
            return this;
        }

        public Config setBid(String str) {
            this.mBid = str;
            return this;
        }

        @Deprecated
        public Config setIsLive(boolean z) {
            if (z) {
                setBid("live");
            }
            return this;
        }

        public Config setIsNeedMonitor(boolean z) {
            this.mIsNeedMonitor = z;
            return this;
        }

        @Deprecated
        public Config setSlardarSDKConfig(String str) {
            this.mSlardarSDKConfig = str;
            return this;
        }

        public Config setVirtualAID(String str) {
            this.virtualAid = str;
            return this;
        }

        @Deprecated
        public Config setFallbackContainerName(String str) {
            this.fallbackContainerName = str;
            return this;
        }

        public Config setBlankDetectCallback(IWebBlankCallback iWebBlankCallback) {
            this.mWebBlankCallback = iWebBlankCallback;
            return this;
        }

        public Config setIsNeedInjectBrowser(Boolean bool) {
            this.mIsNeedInjectBrowser = bool.booleanValue();
            return this;
        }

        public Config setContext(String str, String str2) {
            JsonUtils.safePut(this.mContext, str, str2);
            return this;
        }

        public Config setSessionId(String str) {
            this.mSessionId = str;
            return this;
        }

        private String createWebViewKey(WebView webView) {
            return webView == null ? "" : webView.hashCode() + "";
        }

        public String toString() {
            return "Config{mWebViewClasses=" + Arrays.toString(this.mWebViewClasses) + ", mWebViewObjKeys=" + Arrays.toString(this.mWebViewObjKeys) + ", mIsNeedMonitor='" + this.mIsNeedMonitor + "', mIsNeedInjectBrowser='" + this.mIsNeedInjectBrowser + "', sourceMonitor='" + this.sourceMonitor + "', mBid='" + this.mBid + "', virtualAid='" + this.virtualAid + "'}";
        }
    }
}
