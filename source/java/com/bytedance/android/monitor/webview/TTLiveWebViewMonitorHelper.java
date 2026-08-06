package com.bytedance.android.monitor.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitor.base.IMonitor;
import com.bytedance.android.monitor.entity.ContainerCommon;
import com.bytedance.android.monitor.entity.CustomInfo;
import com.bytedance.android.monitor.entity.FallBackInfo;
import com.bytedance.android.monitor.entity.FetchError;
import com.bytedance.android.monitor.entity.JSBError;
import com.bytedance.android.monitor.entity.JSBInfo;
import com.bytedance.android.monitor.executor.MonitorExecutor;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.bytedance.android.monitor.setting.WebSettingConfig;
import com.bytedance.android.monitor.standard.ContainerError;
import com.bytedance.android.monitor.standard.ContainerStandardApi;
import com.bytedance.android.monitor.util.ExceptionUtil;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper;
import com.bytedance.android.monitor.webview.abtest.AbData;
import com.bytedance.android.monitor.webview.base.IBusinessCustom;
import com.bytedance.android.monitor.webview.base.IContainerContext;
import com.bytedance.android.monitor.webview.base.ITTWebviewDetect;
import com.bytedance.android.monitor.webview.base.IWebBlankCallback;
import com.bytedance.android.monitor.webview.base.IWebCustom;
import com.bytedance.android.monitor.webview.gecko.IMonitorGeckoClient;
import com.bytedance.android.monitor.webview.util.MonitorJsUtils;
import com.bytedance.webx.blankdetect.BlankUtils;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTLiveWebViewMonitorHelper implements ITTLiveWebViewMonitorHelper, ITTLiveWebViewMonitorInnerHelper {
    private static final long DELAY_LOAD = 20000;
    private static final int PROGRESS_LIMIT = 15;
    private static String WEBVIEW_AUTO_REPORT_TAG = "ttlive_web_view_auto_report_tag";
    private static String WEBVIEW_LAST_URL_TAG = "ttlive_web_view_last_url_tag";
    private static String WEBVIEW_TAG = "ttlive_web_view_tag";
    private static ITTLiveWebViewMonitorHelper helper;
    private static ITTLiveWebViewMonitorInnerHelper innerHelper;
    private static Map<String, String> mWebViewConfig = new HashMap();
    private IMonitorGeckoClient geckoClient;
    private Map<String, ITTLiveWebViewMonitorHelper.Config> mWebViewClasses = new HashMap();
    private Map<String, ITTLiveWebViewMonitorHelper.Config> mWebViewObjs = new HashMap();
    private Set<String> mWebViewMissClasses = new HashSet();
    private OnAutoReportListener autoReportListener = new OnAutoReportListener();
    private AbData abData = new AbData();
    private boolean hasTTWebViewRegistered = false;
    private boolean isMonitorEnable = true;
    private boolean isTTWebDelegateEnable = false;
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override // com.bytedance.android.monitor.standard.ContainerStandardAction
    public void handleCollectEvent(View view, String str, Object obj) {
    }

    @Override // com.bytedance.android.monitor.webview.base.IDeprecated
    public void onClientOffline(WebView webView, String str, boolean z) {
    }

    @Override // com.bytedance.android.monitor.webview.base.IDeprecated
    public void onOffline(WebView webView, String str, boolean z) {
    }

    @Override // com.bytedance.android.monitor.webview.base.IDeprecated
    public void onOfflineInfoExtra(WebView webView, String str, String str2, String str3, String str4, String str5) {
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebCustom
    public void rejectReportCallback(WebView webView, IWebCustom.IContextCallback iContextCallback) {
    }

    @Override // com.bytedance.android.monitor.webview.base.IMonitorConfig
    public void setDefaultConfig(ITTLiveWebViewMonitorHelper.Config config) {
    }

    static {
        TTLiveWebViewMonitorHelper tTLiveWebViewMonitorHelper = new TTLiveWebViewMonitorHelper();
        helper = tTLiveWebViewMonitorHelper;
        innerHelper = tTLiveWebViewMonitorHelper;
    }

    private TTLiveWebViewMonitorHelper() {
        ContainerStandardApi.INSTANCE.registerAction("web", this);
        registerTTWebViewDelegate();
    }

    private void registerTTWebViewDelegate() {
        try {
            Class<?> cls = Class.forName("com.bytedance.lynx.webview.TTWebSdk");
            Class<?> cls2 = Class.forName("com.bytedance.lynx.webview.monitors.IWebViewDelegate");
            Class<?> cls3 = Class.forName("com.bytedance.lynx.webview.monitors.IWebViewClientDelegate");
            Class<?> cls4 = Class.forName("com.bytedance.lynx.webview.monitors.IWebChromeClientDelegate");
            cls.getDeclaredMethod("registerGlobalWebViewDelegate", cls2).invoke(null, new TTWebViewDelegateHandler().getInstance());
            cls.getDeclaredMethod("registerGlobalWebViewClientDelegate", cls3).invoke(null, new TTWebViewClientDelegateHandler().getInstance());
            cls.getDeclaredMethod("registerGlobalWebChromeClientDelegate", cls4).invoke(null, new TTWebChromeClientDelegateHandler().getInstance());
            this.hasTTWebViewRegistered = true;
        } catch (Exception e) {
            this.hasTTWebViewRegistered = false;
            ExceptionUtil.handleException(e);
        }
    }

    private WebSettingConfig getWebMonitorSetting() {
        return HybridMonitor.getInstance().getSettingManager().getWebInfo();
    }

    public static ITTLiveWebViewMonitorHelper getInstance() {
        return helper;
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void setGeckoClient(IMonitorGeckoClient iMonitorGeckoClient) {
        if (iMonitorGeckoClient != null) {
            this.geckoClient = iMonitorGeckoClient;
        }
        this.mainHandler.postDelayed(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTLiveWebViewMonitorHelper.this.geckoClient != null) {
                    TTLiveWebViewMonitorHelper.this.geckoClient.checkAndInit();
                }
            }
        }, 20000L);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void setEnable(boolean z) {
        this.isMonitorEnable = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEnable() {
        return this.isMonitorEnable && getWebMonitorSetting().enableMonitor;
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void setTTWebDelegateEnable(boolean z) {
        this.isTTWebDelegateEnable = z;
    }

    public boolean isTTWebEnable() {
        return this.isTTWebDelegateEnable && this.hasTTWebViewRegistered;
    }

    public static ITTLiveWebViewMonitorInnerHelper getInnerInstance() {
        return innerHelper;
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebExtension
    public void handleFetchSuccess(WebView webView) {
        isEnable();
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void setExecutor(ExecutorService executorService) {
        MonitorExecutor.INSTANCE.setExecutor(executorService);
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void handleFetchError(WebView webView, FetchError fetchError) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (isEnable() && webView != null && isNeedMonitor(webView) && checkInCache(webView) && (config = getConfig(webView)) != null && isSwitchOn(config.mOpenFetchDetect) && getWebMonitorSetting().enableFetch && (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) != null) {
                iTTLiveWebViewMonitorInfoHandler.handleFetchError(webView, fetchError);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void handleRequestError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (isTTWebEnable()) {
            return;
        }
        handleRequestErrorInner(webView, webResourceRequest, webResourceError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleRequestErrorInner(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (!isEnable() || webView == null || webResourceRequest == null || webResourceError == null || !isNeedMonitor(webView) || !checkInCache(webView) || (config = getConfig(webView)) == null || !isSwitchOn(config.mOpenMainRequestDetect) || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleRequestError(webView, webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), webResourceError.getErrorCode(), webResourceError.getDescription().toString(), 0);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void handleRequestError(WebView webView, int i, String str, String str2) {
        if (isTTWebEnable()) {
            return;
        }
        handleRequestErrorInner(webView, i, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleRequestErrorInner(WebView webView, int i, String str, String str2) {
        try {
            isEnable();
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private boolean isSwitchOn(boolean z) {
        return HybridMonitor.isDebuggable() || z;
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void handleRequestHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (isTTWebEnable()) {
            return;
        }
        handleRequestHttpErrorInner(webView, webResourceRequest, webResourceResponse);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleRequestHttpErrorInner(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (!isEnable() || webView == null || webResourceRequest == null || webResourceResponse == null || !isNeedMonitor(webView) || !checkInCache(webView) || (config = getConfig(webView)) == null || !isSwitchOn(config.mOpenMainRequestDetect) || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleRequestError(webView, webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), 0, webResourceResponse.getReasonPhrase(), webResourceResponse.getStatusCode());
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void handleRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (!isEnable() || webView == null || renderProcessGoneDetail == null || !isNeedMonitor(webView) || (config = getConfig(webView)) == null || !isSwitchOn(config.mOpenMainRequestDetect) || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleRenderProcessGone(webView, renderProcessGoneDetail);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void handleViewCreate(WebView webView) {
        if (isTTWebEnable()) {
            return;
        }
        handleViewCreateInner(webView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleViewCreateInner(WebView webView) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (isEnable() && webView != null) {
                if (isNeedMonitor(webView)) {
                    ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
                    if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                    } else {
                        iTTLiveWebViewMonitorInfoHandler.handleViewCreate(webView);
                    }
                } else {
                    TTLiveWebViewMonitorCacheInfoHandler tTLiveWebViewMonitorCacheInfoHandler = TTLiveWebViewMonitorCacheInfoHandler.getInstance();
                    if (tTLiveWebViewMonitorCacheInfoHandler != null) {
                        tTLiveWebViewMonitorCacheInfoHandler.handleViewCreate(webView);
                    }
                }
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebExtension
    public void handleJSBError(WebView webView, JSBError jSBError) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (isEnable() && webView != null && isNeedMonitor(webView) && checkInCache(webView) && (config = getConfig(webView)) != null && isSwitchOn(config.mOpenJSBDetect) && getWebMonitorSetting().enableJSB && (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) != null) {
                iTTLiveWebViewMonitorInfoHandler.handleJSBError(webView, jSBError);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebExtension
    public void handleJSBInfo(WebView webView, JSBInfo jSBInfo) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (isEnable() && webView != null && isNeedMonitor(webView) && checkInCache(webView) && (config = getConfig(webView)) != null && isSwitchOn(config.mOpenJSBDetect) && getWebMonitorSetting().enableJSB && (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) != null) {
                iTTLiveWebViewMonitorInfoHandler.handleJSBInfo(webView, jSBInfo);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private boolean checkInCache(WebView webView) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
        if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
            return false;
        }
        return iTTLiveWebViewMonitorInfoHandler.checkInCache(webView);
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void destroy(WebView webView) {
        if (isTTWebEnable()) {
            return;
        }
        destroyInner(webView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroyInner(WebView webView) {
        try {
            if (isEnable() && isNeedMonitor(webView)) {
                updateLatestData(webView, false, 100L);
                handleBlankDetect(webView, getBlankDetectCallback(webView));
                handleWebviewDestory(webView);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void reload(WebView webView) {
        if (isTTWebEnable()) {
            return;
        }
        reloadInner(webView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reloadInner(WebView webView) {
        try {
            if (isEnable() && isNeedMonitor(webView)) {
                removeWebViewTag(webView, WEBVIEW_LAST_URL_TAG);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void goBack(WebView webView) {
        if (isTTWebEnable()) {
            return;
        }
        goBackInner(webView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void goBackInner(WebView webView) {
        try {
            if (isEnable() && isNeedMonitor(webView)) {
                updateLatestData(webView, false, 30L);
                handleBlankDetect(webView, getBlankDetectCallback(webView));
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLatestData(WebView webView, boolean z, long j) throws InterruptedException {
        ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
        if (config != null && isNeedMonitor(webView) && isSwitchOn(config.mOpenLoadLatestPageData) && !isWebviewDestoryed(webView)) {
            String format = String.format(" javascript: (function () {\n    var target = {}\n    if (typeof SlardarHybrid !== 'undefined' && typeof jsIESLiveTimingMonitor !== 'undefined'){\n    var performacess = SlardarHybrid('getLatestPerformance');\n    var resourcess = SlardarHybrid('getLatestResource');\n    target.performance = performacess;\n    target.resource = resourcess;\n    target.needReport = %s;\n    jsIESLiveTimingMonitor.reportPageLatestData(target);}\n })()", z ? "true" : "false");
            if (webView != null) {
                webView.evaluateJavascript(format, null);
            }
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IMonitorConfig
    public void addConfig(ITTLiveWebViewMonitorHelper.Config config) {
        try {
            ITTLiveWebViewMonitorHelper.Config copyConfig = copyConfig(config);
            String[] strArr = copyConfig.mWebViewObjKeys;
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    this.mWebViewObjs.put(str, copyConfig);
                }
            }
            String[] strArr2 = copyConfig.mWebViewClasses;
            if (strArr2 != null && strArr2.length != 0) {
                for (String str2 : strArr2) {
                    this.mWebViewClasses.put(str2, copyConfig);
                }
            }
            this.mWebViewMissClasses.clear();
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private ITTLiveWebViewMonitorHelper.Config copyConfig(ITTLiveWebViewMonitorHelper.Config config) {
        ITTLiveWebViewMonitorHelper.Config config2 = new ITTLiveWebViewMonitorHelper.Config();
        config.setBiz(config.mBiz);
        config2.mInfoHandler = config.mInfoHandler != null ? config.mInfoHandler : TTLiveWebViewMonitorCacheInfoHandler.getInstance();
        config2.mDebugTag = config.mDebugTag != null ? config.mDebugTag : "WebViewMonitor";
        config2.virtualAid = config.virtualAid;
        config2.sourceMonitor = config.sourceMonitor;
        config2.monitor = config.monitor;
        config2.mIsAutoReport = config.mIsAutoReport;
        config2.mIsNeedDirectPerformance = config.mIsNeedDirectPerformance;
        config2.mPerformanceLocType = config.mPerformanceLocType;
        config2.mSlardarSDKPath = getGeckoSlardarJs();
        config2.mIsNeedMonitor = config.mIsNeedMonitor;
        config2.mIsNeedInjectBrowser = config.mIsNeedInjectBrowser;
        config2.mWebViewObjKeys = config.mWebViewObjKeys;
        config2.mWebViewClasses = config.mWebViewClasses;
        config2.mCustomCallback = config.mCustomCallback;
        config2.mWebBlankCallback = config.mWebBlankCallback;
        config2.mBiz = config.mBiz;
        config2.mSlardarSDKConfig = TextUtils.isEmpty(config.mSlardarSDKConfig) ? TTLiveWebViewMonitorConfig.buildDefaultConfig() : config.mSlardarSDKConfig;
        config2.mWebviewDetect = config.mWebviewDetect;
        config2.mOpenBlankDetect = config.mOpenBlankDetect;
        config2.mOpenMainRequestDetect = config.mOpenMainRequestDetect;
        config2.mOpenFetchDetect = config.mOpenFetchDetect;
        config2.mOpenJSBDetect = config.mOpenJSBDetect;
        config2.mOpenLoadLatestPageData = config.mOpenLoadLatestPageData;
        if (!TextUtils.isEmpty(config.mSettingConfig)) {
            JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(config.mSettingConfig);
            config2.mWebViewClasses = JsonUtils.safeOptObj(safeToJsonOb, "webview_classes") == null ? config2.mWebViewClasses : getWebViewClass(config.mSettingConfig);
            config2.mIsNeedMonitor = JsonUtils.safeOptObj(safeToJsonOb, "webview_is_need_monitor") == null ? config2.mIsNeedMonitor : getIsNeedMonitor(config.mSettingConfig);
            config2.mSlardarSDKConfig = TextUtils.isEmpty(config.mSettingConfig) ? config2.mSlardarSDKConfig : new TTLiveWebViewMonitorConfig(config.mSettingConfig).buildConfig();
            config2.mOpenBlankDetect = JsonUtils.safeOptObj(safeToJsonOb, "webview_is_open_blankdetect") == null ? config2.mOpenBlankDetect : JsonUtils.safeOptBool(safeToJsonOb, "webview_is_open_blankdetect", false);
            config2.mOpenJSBDetect = JsonUtils.safeOptObj(safeToJsonOb, "webview_is_open_jsb") == null ? config2.mOpenJSBDetect : JsonUtils.safeOptBool(safeToJsonOb, "webview_is_open_jsb", false);
            config2.mOpenFetchDetect = JsonUtils.safeOptObj(safeToJsonOb, "webview_is_open_fetch") == null ? config2.mOpenFetchDetect : JsonUtils.safeOptBool(safeToJsonOb, "webview_is_open_fetch", false);
            config2.mIsNeedInjectBrowser = JsonUtils.safeOptObj(safeToJsonOb, "webview_is_inject_js") == null ? config2.mIsNeedInjectBrowser : JsonUtils.safeOptBool(safeToJsonOb, "webview_is_inject_js", false);
            config2.mOpenLoadLatestPageData = JsonUtils.safeOptObj(safeToJsonOb, "webview_is_update_page_data") == null ? config2.mOpenLoadLatestPageData : JsonUtils.safeOptBool(safeToJsonOb, "webview_is_update_page_data", false);
        }
        return config2;
    }

    private String getGeckoSlardarJs() {
        if (this.geckoClient == null) {
            return null;
        }
        try {
            File file = new File(this.geckoClient.getResourcePath() + "/slardar.js");
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return null;
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IDeprecated
    public void initConfig(ITTLiveWebViewMonitorHelper.Config config) {
        try {
            addConfig(config);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IMonitorConfig
    public ITTLiveWebViewMonitorHelper.Config buildConfig() {
        return new ITTLiveWebViewMonitorHelper.Config();
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        try {
            onPageStarted(webView, str);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void onPageStarted(WebView webView, String str) {
        if (isTTWebEnable()) {
            return;
        }
        onPageStartedInner(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageStartedInner(WebView webView, String str) {
        try {
            if (!isEnable()) {
                this.abData.onPageStarted(str);
            } else {
                tryBindWebViewForAutoReport(webView, str);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void onPageFinished(WebView webView, String str) {
        if (isTTWebEnable()) {
            return;
        }
        onPageFinishedInner(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageFinishedInner(WebView webView, String str) {
        try {
            if (!isEnable()) {
                this.abData.onPageEnd(webView, str);
            } else if (isNeedMonitor(webView)) {
                handlePageFinished(webView, str);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void onProgressChanged(WebView webView, int i) {
        if (isTTWebEnable()) {
            return;
        }
        onProgressChangedInner(webView, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onProgressChangedInner(WebView webView, int i) {
        try {
            if (isEnable()) {
                initJsMonitor(webView, i);
                handleProgressChanged(webView, i);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void onAttachedToWindow(WebView webView) {
        if (isTTWebEnable()) {
            return;
        }
        onAttachedToWindowInner(webView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAttachedToWindowInner(WebView webView) {
        try {
            if (isEnable() && isNeedMonitor(webView)) {
                onViewAttach(webView);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private void handleProgressChanged(WebView webView, int i) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        if (webView == null) {
            return;
        }
        try {
            if (!isNeedMonitor(webView) || !checkInCache(webView) || (config = getConfig(webView)) == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handlePageProgress(webView, i);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebviewLifeCycle
    public void onLoadUrl(WebView webView, String str) {
        if (isTTWebEnable()) {
            return;
        }
        onLoadUrlInner(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLoadUrlInner(WebView webView, String str) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (isEnable() && isNeedMonitor(webView) && !str.contains("javascript:")) {
                removeWebViewTag(webView, WEBVIEW_LAST_URL_TAG);
                MonitorLog.m6d("TTLiveWebViewMonitorHelper", "onLoadUrl : " + str);
                if (needHandleBlankWhenLoadUrl(webView, str)) {
                    updateLatestData(webView, false, 30L);
                    handleBlankDetect(webView, getConfig(webView).mWebBlankCallback);
                }
                addJavascriptInterface(webView);
                ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
                if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                    return;
                }
                iTTLiveWebViewMonitorInfoHandler.handleLoadUrl(webView, str);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebCustom
    public void customReport(WebView webView, String str, String str2, String str3, String str4) {
        customReport(webView, null, null, str, str2, str3, str4);
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebCustom
    public void customReport(WebView webView, String str, String str2, String str3, String str4, String str5, String str6) {
        customReport(webView, str, str2, JsonUtils.safeToJsonOb(str3), JsonUtils.safeToJsonOb(str4), JsonUtils.safeToJsonOb(str5), (JSONObject) null, true);
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebCustom
    public void customReport(WebView webView, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z) {
        customReportInner(webView, str, str2, jSONObject, jSONObject2, jSONObject3, jSONObject4, z);
    }

    private void customReportInner(WebView webView, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z) {
        String str3;
        JSONObject jSONObject5;
        String str4;
        try {
            if (webView != null) {
                IContainerContext containerContext = getContainerContext(webView);
                if (containerContext != null) {
                    JSONObject jSONObject6 = jSONObject4 == null ? new JSONObject() : jSONObject4;
                    JsonUtils.safePut(jSONObject6, "virtual_aid", containerContext.getVirtualAID());
                    String bizTag = containerContext.getBizTag();
                    if (TextUtils.isEmpty(str)) {
                        jSONObject5 = jSONObject6;
                        str3 = containerContext.getUrl();
                    } else {
                        str3 = str;
                        jSONObject5 = jSONObject6;
                    }
                    str4 = bizTag;
                } else {
                    str3 = str;
                    jSONObject5 = jSONObject4;
                    str4 = "";
                }
                ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
                customReportFinal(config != null ? config.sourceMonitor : null, str4, str3, str2, jSONObject, jSONObject2, jSONObject3, jSONObject5, z);
                return;
            }
            customReport("", str, str2, jSONObject, jSONObject2, jSONObject3, jSONObject4, z);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebCustom
    public void customReport(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z) {
        customReportFinal(null, str, str2, str3, jSONObject, jSONObject2, jSONObject3, jSONObject4, z);
    }

    private void customReportFinal(ITTLiveWebViewMonitor iTTLiveWebViewMonitor, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z) {
        if (jSONObject4 == null) {
            jSONObject4 = new JSONObject();
        }
        JsonUtils.safePut(jSONObject4, "platform", 0);
        HybridMonitor.getInstance().customReport(new CustomInfo.Builder(str3).setBiz(str).setUrl(str2).setCategory(jSONObject).setMetric(jSONObject2).setExtra(jSONObject3).setCommon(jSONObject4).setEnableSample(z).setMonitor(iTTLiveWebViewMonitor).build());
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebCustom
    public void customReport(WebView webView, CustomInfo customInfo) {
        IContainerContext containerContext;
        if (webView != null && (containerContext = getContainerContext(webView)) != null) {
            if (TextUtils.isEmpty(customInfo.getBiz())) {
                customInfo.setBiz(containerContext.getBizTag());
            }
            if (TextUtils.isEmpty(customInfo.getUrl())) {
                customInfo.setUrl(containerContext.getUrl());
            }
            if (TextUtils.isEmpty(customInfo.getVid())) {
                customInfo.setVid(containerContext.getVirtualAID());
            }
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config != null && config.sourceMonitor != null) {
                customInfo.setMonitor(config.sourceMonitor);
            }
        }
        JsonUtils.safePut(customInfo.getCommon(), "platform", 0);
        HybridMonitor.getInstance().customReport(customInfo);
    }

    public IContainerContext getContainerContext(WebView webView) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (isEnable() && isNeedMonitor(webView) && (config = getConfig(webView)) != null && (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) != null) {
                return iTTLiveWebViewMonitorInfoHandler.getContainerContext(webView);
            }
            return null;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
        return null;
    }

    @Override // com.bytedance.android.monitor.webview.base.IDeprecated
    public String createWebViewKey(WebView webView) {
        return webView == null ? "" : webView.hashCode() + "";
    }

    @Override // com.bytedance.android.monitor.webview.base.IDeprecated
    public void removeWebViewKey(String str) {
        try {
            Map<String, ITTLiveWebViewMonitorHelper.Config> map = this.mWebViewObjs;
            if (map != null) {
                map.remove(str);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebExtension
    public void reportEvent(WebView webView, String str, int i) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (isEnable() && isNeedMonitor(webView) && (config = getConfig(webView)) != null && (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) != null) {
                iTTLiveWebViewMonitorInfoHandler.handleReportEvent(webView, str, i);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebExtension
    public void forceReport(WebView webView, String str) {
        try {
            if (isEnable() && isNeedMonitor(webView)) {
                dispatchReportEvent(webView, str, null);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebExtension
    public void forceReport(WebView webView, String str, IWebBlankCallback iWebBlankCallback) {
        try {
            if (isEnable() && isNeedMonitor(webView)) {
                dispatchReportEvent(webView, str, iWebBlankCallback);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebExtension
    public void reportABTestData(WebView webView, long j) {
        if (j <= 0 || webView == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        Uri parse = Uri.parse(webView.getUrl());
        JsonUtils.safePut(jSONObject, "url", parse.toString());
        JsonUtils.safePut(jSONObject, "host", parse.getHost());
        JsonUtils.safePut(jSONObject, "path", parse.getPath());
        JsonUtils.safePut(jSONObject, "hybrid_monitor_switch", (isEnable() && isNeedMonitor(webView)) ? "true" : "false");
        JsonUtils.safePut(jSONObject, "js_inject_switch", (isEnable() && isJsInject(webView)) ? "true" : "false");
        JsonUtils.safePut(jSONObject, "container_type", "web");
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.safePut(jSONObject2, "web_page_cost", j);
        customReport(webView, webView.getUrl(), "performance_test", jSONObject.toString(), jSONObject2.toString(), null, "0");
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebExtension
    public void saveData(WebView webView, String str, String str2, JSONObject jSONObject) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (isEnable()) {
                if (isNeedMonitor(webView)) {
                    ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
                    if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                        return;
                    }
                    if (str != null) {
                        iTTLiveWebViewMonitorInfoHandler.save(webView, str, str2, jSONObject);
                    } else {
                        iTTLiveWebViewMonitorInfoHandler.save(webView, str2, jSONObject);
                    }
                }
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IWebExtension
    public void saveData(WebView webView, String str, JSONObject jSONObject) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (isEnable() && isNeedMonitor(webView) && (config = getConfig(webView)) != null && (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) != null) {
                iTTLiveWebViewMonitorInfoHandler.save(webView, str, jSONObject);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private void dispatchReportEvent(WebView webView, String str, IWebBlankCallback iWebBlankCallback) {
        if ("report_blank_detect".equals(str)) {
            handleBlankDetect(webView, iWebBlankCallback);
        } else if ("report_page_perf".equals(str)) {
            reportInfo(webView, "loc_force");
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IBusinessCustom
    public void reportGeckoInfo(WebView webView, String str, String str2, String str3) {
        reportGeckoInfo(webView, str, str2, str3, "0");
    }

    @Override // com.bytedance.android.monitor.webview.base.IBusinessCustom
    public void reportGeckoInfo(final WebView webView, final String str, final String str2, final String str3, final String str4) {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (webView == null || TextUtils.isEmpty(str3)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JsonUtils.safePut(jSONObject, "res_status", str);
                JsonUtils.safePut(jSONObject, "res_type", str2);
                JsonUtils.safePut(jSONObject, "res_url", str3);
                JsonUtils.safePut(jSONObject, "container", "web");
                JsonUtils.safePut(jSONObject, "res_version", str4);
                TTLiveWebViewMonitorHelper.this.customReport(webView, (String) null, "bd_monitor_get_resource", jSONObject, (JSONObject) null, (JSONObject) null, (JSONObject) null, true);
            }
        });
    }

    @Override // com.bytedance.android.monitor.webview.base.IBusinessCustom
    public void reportFallbackPage(final WebView webView, final FallBackInfo fallBackInfo) {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (webView == null || fallBackInfo == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JsonUtils.safePut(jSONObject, "source_container", fallBackInfo.sourceContainer);
                JsonUtils.safePut(jSONObject, "source_url", fallBackInfo.sourceUrl);
                JsonUtils.safePut(jSONObject, "fallback_type", fallBackInfo.fallbackType);
                JsonUtils.safePut(jSONObject, "target_container", fallBackInfo.targetContainer);
                JsonUtils.safePut(jSONObject, "target_url", fallBackInfo.targetUrl);
                TTLiveWebViewMonitorHelper.this.customReport(webView, (String) null, "bd_monitor_fallback_page", jSONObject, (JSONObject) null, (JSONObject) null, (JSONObject) null, false);
            }
        });
    }

    @Override // com.bytedance.android.monitor.webview.base.IBusinessCustom
    public void addContext(final WebView webView, final String str, final Object obj) {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper.4
            @Override // java.lang.Runnable
            public void run() {
                ITTLiveWebViewMonitorHelper.Config config;
                ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
                try {
                    if (TTLiveWebViewMonitorHelper.this.isEnable() && TTLiveWebViewMonitorHelper.this.isNeedMonitor(webView) && (config = TTLiveWebViewMonitorHelper.this.getConfig(webView)) != null && (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) != null) {
                        iTTLiveWebViewMonitorInfoHandler.addContext(webView, str, obj);
                    }
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                }
            }
        });
    }

    @Override // com.bytedance.android.monitor.webview.base.IBusinessCustom
    public void registerDataCallback(final WebView webView, final IBusinessCustom.IDataCallback iDataCallback) {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper.5
            @Override // java.lang.Runnable
            public void run() {
                ITTLiveWebViewMonitorHelper.Config config;
                ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
                try {
                    if (TTLiveWebViewMonitorHelper.this.isEnable() && TTLiveWebViewMonitorHelper.this.isNeedMonitor(webView) && (config = TTLiveWebViewMonitorHelper.this.getConfig(webView)) != null && (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) != null) {
                        iTTLiveWebViewMonitorInfoHandler.registerDataCallback(webView, iDataCallback);
                    }
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                }
            }
        });
    }

    @Override // com.bytedance.android.monitor.standard.ContainerStandardAction
    public void handleContainerError(View view, ContainerCommon containerCommon, ContainerError containerError) {
        WebView webView;
        try {
            if (isEnable()) {
                ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler = null;
                if (view == null || !(view instanceof WebView)) {
                    webView = null;
                } else {
                    webView = (WebView) view;
                    if (isNeedMonitor(webView) && checkInCache(webView)) {
                        iTTLiveWebViewMonitorInfoHandler = getConfig(webView).mInfoHandler;
                    }
                }
                if (iTTLiveWebViewMonitorInfoHandler != null) {
                    iTTLiveWebViewMonitorInfoHandler.handleContainerError(webView, containerCommon, containerError);
                } else {
                    TTLiveWebViewMonitorCacheInfoHandler.getInstance().handleContainerError(webView, containerCommon, containerError);
                }
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.ITTWebviewDetect
    public boolean isTTWebview(WebView webView) {
        try {
            return ((Boolean) Class.forName("com.bytedance.lynx.webview.TTWebSdk").getDeclaredMethod("isTTWebView", WebView.class).invoke(null, webView)).booleanValue();
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return false;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private class CheckRunnable implements Runnable {
        private WebView webView;

        private CheckRunnable(WebView webView) {
            this.webView = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTLiveWebViewMonitorHelper.this.reportTruly(this.webView);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void reportTruly(WebView webView) {
        try {
            if (hasReport(webView)) {
                return;
            }
            handlePageExit(webView);
            handleBlankDetect(webView, getBlankDetectCallback(webView));
            reportInfo(webView, "loc_after_detach");
            removeWebViewTag(webView, WEBVIEW_LAST_URL_TAG);
            removeWebViewTag(webView, WEBVIEW_AUTO_REPORT_TAG);
            removeWebViewTag(webView, WEBVIEW_TAG);
            removeConfig(webView);
            unbindView(webView);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private boolean hasReport(WebView webView) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        if (webView == null) {
            return false;
        }
        try {
            if (!isNeedMonitor(webView) || (config = getConfig(webView)) == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return false;
            }
            return iTTLiveWebViewMonitorInfoHandler.hasReport(webView);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return false;
        }
    }

    private boolean needHandleBlankWhenLoadUrl(WebView webView, String str) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        if ((!TextUtils.isEmpty(str) && !"about:blank".equals(str)) || (config = getConfig(webView)) == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
            return false;
        }
        String lastUrl = iTTLiveWebViewMonitorInfoHandler.getLastUrl(webView);
        return (TextUtils.isEmpty(lastUrl) || lastUrl.equals("about:blank")) ? false : true;
    }

    private void handleBlankDetect(WebView webView, IWebBlankCallback iWebBlankCallback) {
        ITTLiveWebViewMonitorHelper.Config config;
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            if (isWebviewDestoryed(webView) || webView == null || webView.getUrl() == null || webView.getUrl().equals("about:blank") || !isNeedMonitor(webView) || (config = getConfig(webView)) == null || !isSwitchOn(config.mOpenBlankDetect) || !getWebMonitorSetting().enableBlank || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null || isWebviewDestoryed(webView)) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleBlankDetect(webView, BlankUtils.getDetectorResultFast(webView), iWebBlankCallback);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private void handleWebviewDestory(WebView webView) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleWebviewDestory(webView);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void report(final WebView webView) {
        try {
            if (webView == null) {
                reportTruly(null);
            } else {
                CheckRunnable checkRunnable = new CheckRunnable(webView);
                if (isWebviewDestoryed(webView)) {
                    this.mainHandler.post(checkRunnable);
                } else {
                    this.mainHandler.post(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper.6
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                TTLiveWebViewMonitorHelper.this.updateLatestData(webView, true, 30L);
                            } catch (Exception unused) {
                            }
                        }
                    });
                    this.mainHandler.postDelayed(checkRunnable, 500L);
                }
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IDeprecated
    public void customParams(WebView webView, String str) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleCustomParams(webView, str);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.base.IDeprecated
    public void customParseKey(WebView webView, Set<String> set) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleCustomParseKeys(webView, set);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public ITTWebviewDetect getTTWebviewDetect(WebView webView) {
        return getConfig(webView).mWebviewDetect;
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public void onViewAttach(WebView webView) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleViewAttach(webView);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public void onViewDetach(WebView webView) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleViewDetach(webView);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public String getBiz(WebView webView) {
        ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
        return config != null ? config.mBiz : "";
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public String getVirtualAid(WebView webView) {
        ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
        return config != null ? config.virtualAid : "";
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public boolean isNeedMonitor(WebView webView) {
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null) {
                return false;
            }
            return config.mIsNeedMonitor;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return false;
        }
    }

    private boolean isJsInject(WebView webView) {
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null) {
                return false;
            }
            return config.mIsNeedInjectBrowser;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return false;
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public boolean isWebviewDestoryed(WebView webView) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
        if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
            return false;
        }
        return iTTLiveWebViewMonitorInfoHandler.isWebviewDestoryed(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public void cover(WebView webView, String str, String str2, String str3) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.cover(webView, str, str2, str3);
            reportInfo(webView, "loc_after_tti");
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public void reportDirectly(WebView webView, String str, String str2) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.reportDirectly(webView, str, str2);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public void initTime(WebView webView, String str) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleInitTimeInfo(webView, str);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public void injectJS(WebView webView, long j) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handleInjectJS(webView, j);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public boolean isNeedAutoReport(WebView webView) {
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config != null) {
                return config.mIsAutoReport;
            }
            return false;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return false;
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public IMonitor getMonitor(WebView webView) {
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null) {
                return null;
            }
            return config.monitor;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return null;
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public ITTLiveWebViewMonitorCustomCallback getCustomCallback(WebView webView) {
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null) {
                return null;
            }
            return config.mCustomCallback;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return null;
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInnerHelper
    public IWebBlankCallback getBlankDetectCallback(WebView webView) {
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null) {
                return null;
            }
            return config.mWebBlankCallback;
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return null;
        }
    }

    private boolean isAssignedFrom(String str, String str2) {
        Class<?> loadClass = loadClass(str);
        Class<?> loadClass2 = loadClass(str2);
        if (loadClass == null || loadClass2 == null) {
            return false;
        }
        return loadClass2.isAssignableFrom(loadClass);
    }

    private Class<?> loadClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return null;
        }
    }

    private boolean getIsNeedMonitor(String str) {
        return JsonUtils.safeOptBool(JsonUtils.safeToJsonOb(str), "webview_is_need_monitor", false);
    }

    private String[] getWebViewClass(String str) {
        JSONArray safeOptJsonArray;
        String[] strArr = new String[0];
        if (TextUtils.isEmpty(str) || (safeOptJsonArray = JsonUtils.safeOptJsonArray(JsonUtils.safeToJsonOb(str), "webview_classes")) == null) {
            return strArr;
        }
        String[] strArr2 = new String[safeOptJsonArray.length()];
        for (int i = 0; i < safeOptJsonArray.length(); i++) {
            try {
                strArr2[i] = safeOptJsonArray.getString(i);
            } catch (JSONException unused) {
            }
        }
        return strArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ITTLiveWebViewMonitorHelper.Config getConfig(WebView webView) {
        ITTLiveWebViewMonitorHelper.Config config;
        if (webView == null) {
            return null;
        }
        ITTLiveWebViewMonitorHelper.Config config2 = this.mWebViewObjs.get(createWebViewKey(webView));
        if (config2 != null) {
            return config2;
        }
        String name = webView.getClass().getName();
        ITTLiveWebViewMonitorHelper.Config config3 = this.mWebViewClasses.get(name);
        if (config3 != null) {
            return config3;
        }
        if (this.mWebViewMissClasses.contains(name)) {
            return null;
        }
        for (String str : new HashSet(this.mWebViewClasses.keySet())) {
            if (isAssignedFrom(name, str) && (config = this.mWebViewClasses.get(str)) != null) {
                this.mWebViewClasses.put(name, config);
                return config;
            }
        }
        this.mWebViewMissClasses.add(name);
        return null;
    }

    private void handleCustomCoverReport(WebView webView, String str, String str2, String str3, String str4) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
        if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
            return;
        }
        iTTLiveWebViewMonitorInfoHandler.handleCustomCoverReport(webView, str, str2, str3, str4);
    }

    private void handleCustomDirectlyReport(WebView webView, String str, String str2, String str3, String str4) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
        if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
            return;
        }
        iTTLiveWebViewMonitorInfoHandler.handleCustomDirectlyReport(webView, str, str2, str3, str4);
    }

    private String dealUrl(String str) {
        int indexOf;
        return (TextUtils.isEmpty(str) || (indexOf = str.indexOf("?")) == -1) ? str : str.substring(0, indexOf);
    }

    private void reportInfo(WebView webView, String str) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
        if (config == null || config.mPerformanceLocType == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
            return;
        }
        if ("loc_force".equals(str) || "loc_after_detach".equals(str) || config.mPerformanceLocType.equals(str)) {
            iTTLiveWebViewMonitorInfoHandler.reportPerformance(webView, str);
        }
    }

    private void tryBindWebViewForAutoReport(WebView webView, String str) {
        if (isNeedMonitor(webView)) {
            String str2 = WEBVIEW_AUTO_REPORT_TAG;
            if (!str2.equals(getWebViewTag(webView, str2))) {
                bindView(webView);
                String str3 = WEBVIEW_AUTO_REPORT_TAG;
                setWebViewTag(webView, str3, str3);
            }
            handlePageStart(webView, str);
        }
    }

    private void handlePageStart(WebView webView, String str) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handlePageStart(webView, str);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private void handlePageFinished(WebView webView, String str) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handlePageFinish(webView, str);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private void handlePageExit(WebView webView) {
        ITTLiveWebViewMonitorInfoHandler iTTLiveWebViewMonitorInfoHandler;
        try {
            ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
            if (config == null || (iTTLiveWebViewMonitorInfoHandler = config.mInfoHandler) == null) {
                return;
            }
            iTTLiveWebViewMonitorInfoHandler.handlePageExit(webView);
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private void addJavascriptInterface(WebView webView) {
        if (isNeedMonitor(webView)) {
            String str = WEBVIEW_TAG;
            if (str.equals(getWebViewTag(webView, str))) {
                return;
            }
            WebViewMonitorJsBridge webViewMonitorJsBridge = new WebViewMonitorJsBridge(webView);
            if (!webView.getSettings().getJavaScriptEnabled()) {
                webView.getSettings().setJavaScriptEnabled(true);
            }
            webView.addJavascriptInterface(webViewMonitorJsBridge, "iesJsBridgeTransferMonitor");
            String str2 = WEBVIEW_TAG;
            setWebViewTag(webView, str2, str2);
        }
    }

    private void bindView(WebView webView) {
        OnAutoReportListener onAutoReportListener = this.autoReportListener;
        if (onAutoReportListener != null) {
            onAutoReportListener.bindWebView(webView);
        }
    }

    private void unbindView(WebView webView) {
        OnAutoReportListener onAutoReportListener = this.autoReportListener;
        if (onAutoReportListener != null) {
            onAutoReportListener.unbindWebView(webView);
        }
    }

    private void initJsMonitor(WebView webView, int i) {
        if (isNeedMonitor(webView) && i >= 15 && webView != null) {
            if (!webView.getSettings().getJavaScriptEnabled()) {
                webView.getSettings().setJavaScriptEnabled(true);
            }
            injectJsScript(webView);
        }
    }

    private void injectJsScript(WebView webView) {
        boolean z;
        try {
            String url = webView.getUrl();
            if (url == null || !url.equals("about:blank")) {
                String webViewTag = getWebViewTag(webView, WEBVIEW_LAST_URL_TAG);
                if (TextUtils.isEmpty(url) || url.equals(webViewTag)) {
                    return;
                }
                ITTLiveWebViewMonitorHelper.Config config = getConfig(webView);
                String buildDefaultConfig = config == null ? TTLiveWebViewMonitorConfig.buildDefaultConfig() : config.mSlardarSDKConfig;
                String str = config == null ? "" : config.mSlardarSDKPath;
                if (config != null && !isSwitchOn(config.mIsNeedInjectBrowser)) {
                    z = false;
                    if (z && getWebMonitorSetting().enableInjectJS) {
                        webView.evaluateJavascript(MonitorJsUtils.buildJs(webView.getContext(), str, buildDefaultConfig, z), null);
                    }
                    setWebViewTag(webView, WEBVIEW_LAST_URL_TAG, url);
                    MonitorLog.m6d("WebViewMonitorHelper", "injectJsScript : " + url);
                }
                z = true;
                if (z) {
                    webView.evaluateJavascript(MonitorJsUtils.buildJs(webView.getContext(), str, buildDefaultConfig, z), null);
                }
                setWebViewTag(webView, WEBVIEW_LAST_URL_TAG, url);
                MonitorLog.m6d("WebViewMonitorHelper", "injectJsScript : " + url);
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private void setWebViewTag(WebView webView, String str, String str2) {
        mWebViewConfig.put(str + createWebViewKey(webView), str2);
    }

    private String getWebViewTag(WebView webView, String str) {
        String createWebViewKey = createWebViewKey(webView);
        String str2 = mWebViewConfig.get(str + createWebViewKey);
        if (str2 == null) {
            return null;
        }
        return str2.replaceAll(createWebViewKey, "");
    }

    private void removeWebViewTag(WebView webView, String str) {
        mWebViewConfig.remove(str + createWebViewKey(webView));
    }

    private void removeConfig(WebView webView) {
        this.mWebViewObjs.remove(createWebViewKey(webView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class OnAutoReportListener implements View.OnAttachStateChangeListener {
        private OnAutoReportListener() {
        }

        public void bindWebView(WebView webView) {
            if (webView != null) {
                webView.removeOnAttachStateChangeListener(this);
                webView.addOnAttachStateChangeListener(this);
            }
        }

        public void unbindWebView(WebView webView) {
            if (webView != null) {
                webView.removeOnAttachStateChangeListener(this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (view instanceof WebView) {
                TTLiveWebViewMonitorHelper.getInnerInstance().onViewAttach((WebView) view);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (view instanceof WebView) {
                WebView webView = (WebView) view;
                TTLiveWebViewMonitorHelper.getInnerInstance().onViewDetach(webView);
                onAutoReport(webView);
            }
        }

        public void onAutoReport(WebView webView) {
            if (TTLiveWebViewMonitorHelper.getInnerInstance().isNeedAutoReport(webView)) {
                TTLiveWebViewMonitorHelper.getInstance().report(webView);
            }
        }
    }
}
