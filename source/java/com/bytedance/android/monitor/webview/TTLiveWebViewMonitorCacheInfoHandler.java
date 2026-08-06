package com.bytedance.android.monitor.webview;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.bytedance.android.monitor.DataMonitor;
import com.bytedance.android.monitor.base.BaseNativeInfo;
import com.bytedance.android.monitor.base.IMonitorData;
import com.bytedance.android.monitor.base.IReportData;
import com.bytedance.android.monitor.entity.ContainerCommon;
import com.bytedance.android.monitor.entity.ContainerInfo;
import com.bytedance.android.monitor.entity.ContainerNativeInfo;
import com.bytedance.android.monitor.entity.FetchError;
import com.bytedance.android.monitor.entity.JSBError;
import com.bytedance.android.monitor.entity.JSBInfo;
import com.bytedance.android.monitor.executor.MonitorExecutor;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.bytedance.android.monitor.standard.ContainerError;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.util.TouchUtil;
import com.bytedance.android.monitor.webview.WebSaveTempCache;
import com.bytedance.android.monitor.webview.base.IBusinessCustom;
import com.bytedance.android.monitor.webview.base.IContainerContext;
import com.bytedance.android.monitor.webview.base.ITTWebviewDetect;
import com.bytedance.android.monitor.webview.base.IWebBlankCallback;
import com.bytedance.android.monitor.webview.cache.impl.WebNativeCommon;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.webx.blankdetect.BlankUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTLiveWebViewMonitorCacheInfoHandler implements ITTLiveWebViewMonitorInfoHandler {
    private static final String TAG = "MonitorCacheInfoHandler";
    private static volatile TTLiveWebViewMonitorCacheInfoHandler infoHandler;
    private WebviewCache webviewCache = new WebviewCache();
    private WebSaveTempCache tempCache = new WebSaveTempCache();
    private Map<WebView, List<WebUrlDataCache>> cacheMap = new WeakHashMap();

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleClientOfflineInfo(WebView webView, String str, boolean z) {
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleCustomCoverReport(WebView webView, String str, String str2, String str3, String str4) {
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleCustomDirectlyReport(WebView webView, String str, String str2, String str3, String str4) {
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleCustomParams(WebView webView, String str) {
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleCustomParseKeys(WebView webView, Set<String> set) {
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleOffLineInfo(WebView webView, String str, boolean z) {
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleOfflineInfoExtra(WebView webView, String str, String str2, String str3, String str4, String str5) {
    }

    private TTLiveWebViewMonitorCacheInfoHandler() {
    }

    public static TTLiveWebViewMonitorCacheInfoHandler getInstance() {
        if (infoHandler == null) {
            synchronized (TTLiveWebViewMonitorCacheInfoHandler.class) {
                if (infoHandler == null) {
                    infoHandler = new TTLiveWebViewMonitorCacheInfoHandler();
                }
            }
        }
        return infoHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized WebUrlDataCache getCache(WebView webView) {
        List<WebUrlDataCache> list = this.cacheMap.get(webView);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    private synchronized WebUrlDataCache getCache(WebView webView, String str) {
        List<WebUrlDataCache> list = this.cacheMap.get(webView);
        if (list != null && list.size() > 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                WebUrlDataCache webUrlDataCache = list.get(size);
                if (webUrlDataCache != null && webUrlDataCache.getUrl().equals(str)) {
                    return webUrlDataCache;
                }
            }
        }
        return null;
    }

    private synchronized List<WebUrlDataCache> removeAllCache(WebView webView) {
        return this.cacheMap.remove(webView);
    }

    private WebUrlDataCache buildNewNavigation(WebView webView, String str) {
        MonitorLog.m6d(TAG, "buildNewNavigation cache new url : " + str);
        WebUrlDataCache webUrlDataCache = new WebUrlDataCache(webView, "web", ((ITTWebviewDetect) TTLiveWebViewMonitorHelper.getInnerInstance()).isTTWebview(webView) ? "ttweb" : "web", str, TouchUtil.getLastTouchTime(), this.webviewCache.getLoadUrlMap().get(webView).longValue());
        webUrlDataCache.putReportEvent(pollEventMap(webView));
        webUrlDataCache.setContainerBase(this.webviewCache.getContainerBase(webView));
        webUrlDataCache.setContainerInfo(this.webviewCache.getContainerInfo(webView));
        webUrlDataCache.setWebCache(this.webviewCache);
        List<WebUrlDataCache> list = this.cacheMap.get(webView);
        if (list == null) {
            list = new ArrayList<>();
            this.cacheMap.put(webView, list);
        }
        list.add(webUrlDataCache);
        return webUrlDataCache;
    }

    private synchronized void removeCache(WebView webView, WebUrlDataCache webUrlDataCache) {
        List<WebUrlDataCache> list = this.cacheMap.get(webView);
        if (list != null) {
            list.remove(webUrlDataCache);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public boolean hasReport(WebView webView) {
        return this.webviewCache.hasReport(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleViewCreate(WebView webView) {
        this.webviewCache.handleViewCreate(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleViewAttach(WebView webView) {
        this.webviewCache.handleViewAttach(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleViewDetach(WebView webView) {
        this.webviewCache.handleViewDetach(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleLoadUrl(WebView webView, String str) {
        this.webviewCache.handleLoadUrl(webView, str);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handlePageStart(WebView webView, String str) {
        String lastUrl = getLastUrl(webView);
        if (!TextUtils.isEmpty(lastUrl)) {
            handlePageExit(webView);
        }
        if (str.equals(lastUrl) && getLastCache(webView).getClickStart() == TouchUtil.getLastTouchTime()) {
            MonitorLog.m6d(TAG, "handlePageStart : clickStart is same");
            return;
        }
        if (str == null || !str.equals("about:blank")) {
            buildNewNavigation(webView, str);
            WebUrlDataCache cache = getCache(webView);
            if (cache != null) {
                cache.handlePageEnter();
                cache.handlePageStart();
            }
            handlePv(webView);
            MonitorLog.m6d(TAG, "handlePageStart: " + webView + "   url : " + str);
        }
    }

    private void handlePv(WebView webView) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "invoke_ts", System.currentTimeMillis());
        reportClientDirectly(webView, "navigationStart", jSONObject);
        MonitorLog.m6d(TAG, "handlePv");
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handlePageFinish(WebView webView, String str) {
        WebUrlDataCache cache = getCache(webView);
        if (cache != null) {
            cache.handlePageFinish();
        }
        MonitorLog.m6d(TAG, "handlePageFinish: " + webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handlePageProgress(WebView webView, int i) {
        WebUrlDataCache cache = getCache(webView);
        if (cache != null) {
            cache.handlePageProgress(i);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public boolean checkInCache(WebView webView) {
        return getCache(webView) != null;
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public String getLastUrl(WebView webView) {
        WebUrlDataCache cache = getCache(webView);
        if (cache != null) {
            return cache.getUrl();
        }
        return null;
    }

    public WebUrlDataCache getLastCache(WebView webView) {
        return getCache(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleRequestError(final WebView webView, final String str, final boolean z, final int i, final String str2, final int i2) {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorCacheInfoHandler.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.safePut(jSONObject, "event_type", "nativeError");
                JsonUtils.safePut(jSONObject, "error_code", i);
                JsonUtils.safePut(jSONObject, "error_msg", str2);
                JsonUtils.safePut(jSONObject, "scene", z ? "main_frame" : "child_resource");
                JsonUtils.safePut(jSONObject, "error_url", str);
                JsonUtils.safePut(jSONObject, "http_status", i2);
                TTLiveWebViewMonitorCacheInfoHandler.this.reportClientDirectly(webView, "nativeError", jSONObject);
                MonitorLog.m6d(TTLiveWebViewMonitorCacheInfoHandler.TAG, "handleRequestError: ");
            }
        });
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        String str;
        boolean z;
        String url = webView.getUrl();
        if (TextUtils.isEmpty(url)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            str = "cause by ".concat(renderProcessGoneDetail.didCrash() ? CrashManager.DIR_NAME : "system");
        } else {
            str = null;
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "event_type", "nativeError");
        JsonUtils.safePut(jSONObject, "error_code", -10000);
        JsonUtils.safePut(jSONObject, "error_msg", str);
        JsonUtils.safePut(jSONObject, "scene", "web_process_terminate");
        JsonUtils.safePut(jSONObject, "error_url", url);
        WebUrlDataCache cache = getCache(webView, webView.getUrl());
        if (cache == null) {
            cache = buildNewNavigation(webView, webView.getUrl());
            z = true;
        } else {
            z = false;
        }
        reportClientDirectly(webView, "nativeError", jSONObject);
        if (z) {
            removeCache(webView, cache);
        }
        MonitorLog.m6d(TAG, "handleRenderProcessGone: ");
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleJSBError(final WebView webView, final JSBError jSBError) {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorCacheInfoHandler.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.safePut(jSONObject, "event_type", "jsbError");
                JsonUtils.safePut(jSONObject, "bridge_name", jSBError.bridgeName);
                JsonUtils.safePut(jSONObject, "error_activity", jSBError.errorActivity);
                JsonUtils.safePut(jSONObject, "error_code", jSBError.errorCode);
                JsonUtils.safePut(jSONObject, "error_message", jSBError.errorMessage);
                JsonUtils.safePut(jSONObject, "js_type", jSBError.eventType);
                JsonUtils.safePut(jSONObject, "error_url", jSBError.errorUrl);
                JsonUtils.safePut(jSONObject, "is_sync", jSBError.isSync);
                TTLiveWebViewMonitorCacheInfoHandler.this.reportClientDirectly(webView, "jsbError", jSONObject);
                MonitorLog.m6d(TTLiveWebViewMonitorCacheInfoHandler.TAG, "handleJSBError: ");
            }
        });
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleJSBInfo(final WebView webView, final JSBInfo jSBInfo) {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorCacheInfoHandler.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.safePut(jSONObject, "event_type", "jsbPerf");
                JsonUtils.safePut(jSONObject, "bridge_name", jSBInfo.bridgeName);
                JsonUtils.safePut(jSONObject, "status_code", jSBInfo.statusCode);
                JsonUtils.safePut(jSONObject, "status_description", jSBInfo.statusDescription);
                JsonUtils.safePut(jSONObject, "protocol_version", jSBInfo.protocolVersion);
                JsonUtils.safePut(jSONObject, "cost_time", jSBInfo.costTime);
                JsonUtils.safePut(jSONObject, "invoke_ts", jSBInfo.invokeTime);
                JsonUtils.safePut(jSONObject, "callback_ts", jSBInfo.callbackTime);
                JsonUtils.safePut(jSONObject, "fireEvent_ts", jSBInfo.fireEventTime);
                TTLiveWebViewMonitorCacheInfoHandler.this.reportClientDirectly(webView, "jsbPerf", jSONObject);
                MonitorLog.m6d(TTLiveWebViewMonitorCacheInfoHandler.TAG, "handleJSBInfo: ");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorCacheInfoHandler$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class RunnableC00134 implements Runnable {
        final /* synthetic */ ContainerCommon val$base;
        final /* synthetic */ ContainerError val$error;
        final /* synthetic */ WebView val$webView;

        RunnableC00134(WebView webView, ContainerError containerError, ContainerCommon containerCommon) {
            this.val$webView = webView;
            this.val$error = containerError;
            this.val$base = containerCommon;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = this.val$webView;
            WebUrlDataCache cache = webView != null ? TTLiveWebViewMonitorCacheInfoHandler.this.getCache(webView) : null;
            WebView webView2 = this.val$webView;
            if (webView2 != null && cache != null) {
                TTLiveWebViewMonitorCacheInfoHandler.this.reportClientDirectly(webView2, "containerError", null, this.val$error.toContainerInfo());
                MonitorLog.m6d(TTLiveWebViewMonitorCacheInfoHandler.TAG, "handleContainerError: ");
            } else {
                MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorCacheInfoHandler.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataMonitor.monitor(new IReportData() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorCacheInfoHandler.4.1.1
                            @Override // com.bytedance.android.monitor.base.IReportData
                            public String getContainerType() {
                                return "web";
                            }

                            @Override // com.bytedance.android.monitor.base.IReportData
                            public String getEventType() {
                                return "containerError";
                            }

                            @Override // com.bytedance.android.monitor.base.IReportData
                            public JSONObject getJsBase() {
                                return null;
                            }

                            @Override // com.bytedance.android.monitor.base.IReportData
                            public JSONObject getJsInfo() {
                                return null;
                            }

                            @Override // com.bytedance.android.monitor.base.IReportData
                            public BaseNativeInfo getNativeInfo() {
                                return new ContainerNativeInfo();
                            }

                            @Override // com.bytedance.android.monitor.base.IReportData
                            public IMonitorData getNativeBase() {
                                WebNativeCommon webNativeCommon = new WebNativeCommon();
                                webNativeCommon.virtualAid = RunnableC00134.this.val$error.getVirtualAid();
                                webNativeCommon.containerType = "web";
                                return webNativeCommon;
                            }

                            @Override // com.bytedance.android.monitor.base.IReportData
                            public IMonitorData getContainerInfo() {
                                return RunnableC00134.this.val$error.toContainerInfo();
                            }

                            @Override // com.bytedance.android.monitor.base.IReportData
                            public IMonitorData getContainerBase() {
                                return RunnableC00134.this.val$base;
                            }

                            @Override // com.bytedance.android.monitor.base.IReportData
                            public String getBiz() {
                                return RunnableC00134.this.val$error.getBiz();
                            }
                        }, new TTLiveWebViewMonitorDefault());
                    }
                });
            }
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleContainerError(WebView webView, ContainerCommon containerCommon, ContainerError containerError) {
        MonitorExecutor.INSTANCE.submit(new RunnableC00134(webView, containerError, containerCommon));
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleReportEvent(WebView webView, String str, int i) {
        WebUrlDataCache cache = getCache(webView);
        if (cache == null) {
            this.webviewCache.putEventMap(webView, str, i);
        } else {
            cache.putReportEvent(str, i);
        }
        MonitorLog.m6d(TAG, "handleReportEvent:  type : " + str + "   state : " + i);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleWebviewDestory(WebView webView) {
        this.webviewCache.handleWebviewDestory(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public boolean isWebviewDestoryed(WebView webView) {
        return this.webviewCache.isWebviewDestoryed(webView);
    }

    private Map<String, Integer> pollEventMap(WebView webView) {
        return this.webviewCache.pollEventMap(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleBlankDetect(WebView webView, BlankUtils.DetectorResult detectorResult, IWebBlankCallback iWebBlankCallback) {
        if (detectorResult == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "event_type", "blank");
        boolean z = false;
        JsonUtils.safePut(jSONObject, "is_blank", detectorResult.blankState == 1 ? 1 : 0);
        JsonUtils.safePut(jSONObject, "detect_type", 0);
        JsonUtils.safePut(jSONObject, "cost_time", detectorResult.costTime);
        if (detectorResult.blankState == 3) {
            JsonUtils.safePut(jSONObject, "error_code", detectorResult.errorCode);
            JsonUtils.safePut(jSONObject, "error_msg", detectorResult.errorMsg);
        }
        if (iWebBlankCallback != null) {
            iWebBlankCallback.onDetectCost(webView, detectorResult.costTime);
            iWebBlankCallback.onDetectResult(webView, detectorResult.blankState);
        }
        WebUrlDataCache cache = getCache(webView, webView.getUrl());
        if (cache == null) {
            cache = buildNewNavigation(webView, webView.getUrl());
            z = true;
        }
        reportClientDirectly(webView, "blank", jSONObject);
        if (z) {
            removeCache(webView, cache);
        }
        MonitorLog.m6d(TAG, "handleBlankDetect: ");
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleFetchError(final WebView webView, final FetchError fetchError) {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorCacheInfoHandler.5
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.safePut(jSONObject, "event_type", "fetchError");
                JsonUtils.safePut(jSONObject, "error_no", fetchError.errorCode);
                JsonUtils.safePut(jSONObject, "error_msg", fetchError.errorMessage);
                JsonUtils.safePut(jSONObject, "method", fetchError.method);
                JsonUtils.safePut(jSONObject, "url", fetchError.url);
                JsonUtils.safePut(jSONObject, "status_code", fetchError.statusCode);
                JsonUtils.safePut(jSONObject, "request_error_code", fetchError.requestErrorCode);
                JsonUtils.safePut(jSONObject, "request_error_msg", fetchError.requestErrorMsg);
                JsonUtils.safePut(jSONObject, "jsb_ret", fetchError.jsbReturn);
                JsonUtils.safePut(jSONObject, "hit_prefetch", fetchError.hitPrefetch);
                TTLiveWebViewMonitorCacheInfoHandler.this.reportClientDirectly(webView, "fetchError", jSONObject);
                MonitorLog.m6d(TTLiveWebViewMonitorCacheInfoHandler.TAG, "handleFetchError: ");
            }
        });
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handlePageExit(WebView webView) {
        WebUrlDataCache cache = getCache(webView);
        if (cache != null) {
            cache.handlePageExit();
        }
        MonitorLog.m6d(TAG, "handlePageExit: " + webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleInitTimeInfo(WebView webView, String str) {
        WebUrlDataCache cache = getCache(webView);
        if (cache != null) {
            cache.updateMonitorInitTimeData(str);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void handleInjectJS(WebView webView, long j) {
        WebUrlDataCache cache = getCache(webView);
        if (cache != null) {
            cache.injectJS(j);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public IContainerContext getContainerContext(final WebView webView) {
        return new IContainerContext() { // from class: com.bytedance.android.monitor.webview.TTLiveWebViewMonitorCacheInfoHandler.6
            @Override // com.bytedance.android.monitor.webview.base.IContainerContext
            public String getVirtualAID() {
                return TTLiveWebViewMonitorHelper.getInnerInstance().getVirtualAid(webView);
            }

            @Override // com.bytedance.android.monitor.webview.base.IContainerContext
            public String getBizTag() {
                return TTLiveWebViewMonitorHelper.getInnerInstance().getBiz(webView);
            }

            @Override // com.bytedance.android.monitor.webview.base.IContainerContext
            public String getUrl() {
                WebUrlDataCache lastCache = TTLiveWebViewMonitorCacheInfoHandler.this.getLastCache(webView);
                if (lastCache == null) {
                    return TTLiveWebViewMonitorCacheInfoHandler.this.webviewCache.getLoadUrl(webView);
                }
                return lastCache.getUrl();
            }
        };
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void cover(WebView webView, String str, String str2, String str3) {
        WebUrlDataCache cache = getCache(webView, str);
        if (cache != null) {
            cache.cover(str2, str3);
        }
        MonitorLog.m6d(TAG, "cover: " + str);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void reportPerformance(WebView webView, String str) {
        WebUrlDataCache cache;
        if ("loc_after_detach".equals(str)) {
            List<WebUrlDataCache> removeAllCache = removeAllCache(webView);
            if (removeAllCache != null) {
                for (WebUrlDataCache webUrlDataCache : removeAllCache) {
                    webUrlDataCache.fillCommonData(generateNativeCommon(webView));
                    webUrlDataCache.report(webView);
                }
            }
        } else if (("loc_after_tti".equals(str) || "loc_force".equals(str)) && (cache = getCache(webView)) != null) {
            cache.fillCommonData(generateNativeCommon(webView));
            cache.reportPerformance(webView);
        }
        this.webviewCache.setReportState(webView, true);
    }

    private JSONObject generateNativeCommon(WebView webView) {
        return this.webviewCache.generateNativeCommon(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void reportDirectly(WebView webView, String str, String str2) {
        String safeOptStr = JsonUtils.safeOptStr(JsonUtils.safeToJsonOb(str2), "url");
        if (TextUtils.isEmpty(safeOptStr)) {
            WebUrlDataCache cache = getCache(webView);
            if (cache != null) {
                cache.reportDirectly(webView, str, JsonUtils.safeToJsonOb(str2), null);
                cache.addCount(str);
                return;
            }
            return;
        }
        WebUrlDataCache cache2 = getCache(webView, safeOptStr);
        if (cache2 == null || !cache2.canReport(str)) {
            return;
        }
        cache2.reportDirectly(webView, str, JsonUtils.safeToJsonOb(str2), null);
        cache2.addCount(str);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void reportClientDirectly(WebView webView, String str, JSONObject jSONObject) {
        reportClientDirectly(webView, str, jSONObject, null);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void reportClientDirectly(WebView webView, String str, JSONObject jSONObject, ContainerInfo containerInfo) {
        WebUrlDataCache cache = getCache(webView);
        if (cache == null || !cache.canReport(str)) {
            return;
        }
        cache.fillCommonData(generateNativeCommon(webView));
        cache.reportDirectly(webView, str, null, jSONObject, containerInfo);
        cache.addCount(str);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void save(WebView webView, String str, String str2, JSONObject jSONObject) {
        WebUrlDataCache cache = getCache(webView, str);
        if (cache != null) {
            cache.save(str2, jSONObject);
            List<WebSaveTempCache.Data> poll = this.tempCache.poll(webView, str);
            if (poll == null || poll.size() <= 0) {
                return;
            }
            for (WebSaveTempCache.Data data : poll) {
                save(webView, str, data.type, data.f9o);
            }
            return;
        }
        tempSave(webView, str, str2, jSONObject);
    }

    private void tempSave(WebView webView, String str, String str2, JSONObject jSONObject) {
        this.tempCache.save(webView, str, str2, jSONObject);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void save(WebView webView, String str, JSONObject jSONObject) {
        WebUrlDataCache cache = getCache(webView);
        if (cache != null) {
            cache.save(str, jSONObject);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void addContext(WebView webView, String str, Object obj) {
        WebUrlDataCache cache = getCache(webView);
        if (cache != null) {
            cache.putContext(str, obj);
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorInfoHandler
    public void registerDataCallback(WebView webView, IBusinessCustom.IDataCallback iDataCallback) {
        this.webviewCache.registerDataCallback(webView, iDataCallback);
    }
}
