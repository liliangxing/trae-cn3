package com.bytedance.android.monitor.webview;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.monitor.base.IMonitor;
import com.bytedance.android.monitor.base.IMonitorData;
import com.bytedance.android.monitor.entity.ContainerCommon;
import com.bytedance.android.monitor.entity.ContainerInfo;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.util.NavigationUtil;
import com.bytedance.android.monitor.webview.cache.base.AbsWebNativeInfo;
import com.bytedance.android.monitor.webview.cache.base.INativeInfoCache;
import com.bytedance.android.monitor.webview.cache.base.WebBaseReportData;
import com.bytedance.android.monitor.webview.cache.impl.FalconXReportData;
import com.bytedance.android.monitor.webview.cache.impl.WebNativeCommon;
import com.bytedance.android.monitor.webview.cache.impl.WebPerfReportData;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WebUrlDataCache {
    private static final String TAG = "WebViewMonitorDataCache";
    private ContainerCommon mContainerBase;
    private Map<String, INativeInfoCache> matchers = new HashMap();
    private WebPerfReportData perfReportData;
    private WebNativeCommon webNativeCommon;
    private WebviewCache webviewCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebUrlDataCache(WebView webView, String str, String str2, String str3, long j, long j2) {
        WebNativeCommon webNativeCommon = new WebNativeCommon();
        this.webNativeCommon = webNativeCommon;
        webNativeCommon.setWebViewSoftReference(new SoftReference<>(webView));
        this.webNativeCommon.setContainerType(str);
        this.webNativeCommon.setWebViewType(str2);
        this.webNativeCommon.setUrlCache(str3);
        this.webNativeCommon.setClickStartTime(j);
        this.webNativeCommon.setLoadUrlTime(j2);
        this.webNativeCommon.setNavigationIdCache(NavigationUtil.generateID());
        initMatcher();
    }

    private void initMatcher() {
        registerMatcher("falconPerf", new FalconXReportData(this.webNativeCommon));
    }

    private WebPerfReportData getWebPerfData() {
        if (this.perfReportData == null) {
            this.perfReportData = new WebPerfReportData(this.webNativeCommon, "perf");
        }
        return this.perfReportData;
    }

    public void cover(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        getWebPerfData().saveJsData(JsonUtils.safeToJsonOb(str2));
    }

    public void handlePageEnter() {
        getWebPerfData().handlePageEnter();
    }

    public void handlePageExit() {
        getWebPerfData().handlePageExit();
    }

    public void handlePageStart() {
        getWebPerfData().handlePageStart();
    }

    public void handlePageFinish() {
        getWebPerfData().handlePageFinish();
    }

    public void handlePageProgress(int i) {
        getWebPerfData().handlePageProgress(i);
    }

    public void injectJS(long j) {
        getWebPerfData().injectJS(j);
    }

    public void updateMonitorInitTimeData(String str) {
        getWebPerfData().updateMonitorInitTimeData(str);
    }

    public void addCount(String str) {
        getWebPerfData().addCount(str);
    }

    public boolean canReport(String str) {
        if (getWebPerfData().getAlreadyReportSet().contains(str)) {
            return ("blank".equals(str) || "performance".equals(str) || "resource_performance".equals(str)) ? false : true;
        }
        return true;
    }

    public String getUrl() {
        return this.webNativeCommon.getUrlCache();
    }

    public long getClickStart() {
        return this.webNativeCommon.getClickStartTime();
    }

    public void fillCommonData(JSONObject jSONObject) {
        this.webNativeCommon.saveCommonData(jSONObject);
    }

    public void putReportEvent(String str, int i) {
        this.webNativeCommon.saveExtra(str, Integer.valueOf(i));
    }

    public void putReportEvent(Map<String, Integer> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                putReportEvent(str, map.get(str).intValue());
            }
        }
    }

    public void putContext(String str, Object obj) {
        this.webNativeCommon.addContext(str, obj);
    }

    public void setWebCache(WebviewCache webviewCache) {
        this.webviewCache = webviewCache;
    }

    public void setContainerBase(ContainerCommon containerCommon) {
        this.mContainerBase = containerCommon;
        getWebPerfData().setContainerBase(containerCommon);
        for (INativeInfoCache iNativeInfoCache : this.matchers.values()) {
            if (iNativeInfoCache instanceof WebBaseReportData) {
                ((WebBaseReportData) iNativeInfoCache).setContainerBase(containerCommon);
            }
        }
    }

    public void setContainerInfo(ContainerInfo containerInfo) {
        getWebPerfData().setContainerInfo(containerInfo);
    }

    public void report(WebView webView) {
        reportPerformance(webView);
        reportOther(webView);
    }

    public void reportPerformance(WebView webView) {
        WebPerfReportData webPerfData = getWebPerfData();
        reportDirectly(webView, webPerfData);
        getWebPerfData().reset();
        this.webviewCache.notifyPerf(webView, webPerfData);
    }

    private void reportOther(WebView webView) {
        for (INativeInfoCache iNativeInfoCache : this.matchers.values()) {
            if (iNativeInfoCache.isCanReport() && (iNativeInfoCache instanceof WebBaseReportData)) {
                reportDirectly(webView, (WebBaseReportData) iNativeInfoCache);
                iNativeInfoCache.reset();
            }
        }
    }

    public void reportDirectly(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        reportDirectly(webView, str, jSONObject, jSONObject2, null);
    }

    public void reportDirectly(WebView webView, final String str, JSONObject jSONObject, final JSONObject jSONObject2, final ContainerInfo containerInfo) {
        WebNativeCommon webNativeCommon = this.webNativeCommon;
        WebBaseReportData webBaseReportData = new WebBaseReportData(webNativeCommon, str, webNativeCommon.containerType) { // from class: com.bytedance.android.monitor.webview.WebUrlDataCache.1
            @Override // com.bytedance.android.monitor.webview.cache.base.WebBaseReportData, com.bytedance.android.monitor.base.BaseReportData, com.bytedance.android.monitor.base.IReportData
            public AbsWebNativeInfo getNativeInfo() {
                if (jSONObject2 == null) {
                    return null;
                }
                return new AbsWebNativeInfo(str) { // from class: com.bytedance.android.monitor.webview.WebUrlDataCache.1.1
                    @Override // com.bytedance.android.monitor.webview.cache.base.AbsWebNativeInfo
                    public void reset() {
                    }

                    {
                        enableReport();
                    }

                    @Override // com.bytedance.android.monitor.base.BaseMonitorData
                    public void fillInJsonObject(JSONObject jSONObject3) {
                        JsonUtils.deepCopy(jSONObject3, jSONObject2);
                    }
                };
            }

            @Override // com.bytedance.android.monitor.base.IReportData
            public IMonitorData getContainerInfo() {
                return containerInfo;
            }
        };
        webBaseReportData.setContainerBase(this.mContainerBase);
        webBaseReportData.saveJsData(jSONObject);
        reportDirectly(webView, webBaseReportData);
    }

    public void reportDirectly(WebView webView, WebBaseReportData webBaseReportData) {
        IMonitor monitor;
        if (webView == null || webBaseReportData == null || !webBaseReportData.isCanReport() || (monitor = TTLiveWebViewMonitorHelper.getInnerInstance().getMonitor(webView)) == null) {
            return;
        }
        monitor.monitor(webBaseReportData);
    }

    public void save(String str, JSONObject jSONObject) {
        INativeInfoCache iNativeInfoCache = this.matchers.get(str);
        if (iNativeInfoCache != null) {
            iNativeInfoCache.save(jSONObject);
        }
    }

    private void registerMatcher(String str, INativeInfoCache iNativeInfoCache) {
        this.matchers.put(str, iNativeInfoCache);
    }
}
