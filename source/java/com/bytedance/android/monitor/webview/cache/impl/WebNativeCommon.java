package com.bytedance.android.monitor.webview.cache.impl;

import android.app.Activity;
import android.webkit.WebView;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitor.entity.NativeCommon;
import com.bytedance.android.monitor.executor.MonitorExecutor;
import com.bytedance.android.monitor.util.ActivityUtil;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WebNativeCommon extends NativeCommon {
    private String activityName;
    private long loadUrlTime;
    private SoftReference<WebView> webViewSoftReference;
    private JSONObject extraPerformance = new JSONObject();
    private JSONObject eventObject = new JSONObject();

    public void saveCommonData(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JsonUtils.safePut(this.extraPerformance, next, JsonUtils.safeOptObj(jSONObject, next));
        }
    }

    public void saveExtra(String str, Object obj) {
        JsonUtils.safePut(this.eventObject, str, obj);
    }

    public SoftReference<WebView> getWebViewSoftReference() {
        SoftReference<WebView> softReference = this.webViewSoftReference;
        return softReference != null ? softReference : new SoftReference<>(null);
    }

    public void setWebViewSoftReference(SoftReference<WebView> softReference) {
        this.webViewSoftReference = softReference;
        initNativePage();
        this.virtualAid = TTLiveWebViewMonitorHelper.getInnerInstance().getVirtualAid(softReference.get());
    }

    private void initNativePage() {
        MonitorExecutor.INSTANCE.submit(new Runnable() { // from class: com.bytedance.android.monitor.webview.cache.impl.WebNativeCommon.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activityByContext;
                WebView webView = (WebView) WebNativeCommon.this.webViewSoftReference.get();
                if (webView == null || (activityByContext = ActivityUtil.getActivityByContext(webView.getContext())) == null) {
                    return;
                }
                HybridMonitor.getInstance().wrapTouchTraceCallback(activityByContext);
                WebNativeCommon.this.activityName = activityByContext.getClass().getName();
            }
        });
    }

    public String getContainerType() {
        return this.containerType;
    }

    public void setContainerType(String str) {
        this.containerType = str;
    }

    public String getWebViewType() {
        return this.webViewType;
    }

    public void setWebViewType(String str) {
        this.webViewType = str;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public String getUrlCache() {
        return this.url;
    }

    public void setUrlCache(String str) {
        this.url = str;
    }

    public long getClickStartTime() {
        return this.clickStart;
    }

    public void setClickStartTime(long j) {
        this.clickStart = j;
    }

    public long getLoadUrlTime() {
        return this.loadUrlTime;
    }

    public void setLoadUrlTime(long j) {
        this.loadUrlTime = j;
    }

    public String getNavigationIdCache() {
        return this.navigationId;
    }

    public void setNavigationIdCache(String str) {
        this.navigationId = str;
    }

    @Override // com.bytedance.android.monitor.entity.NativeCommon, com.bytedance.android.monitor.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jSONObject) {
        super.fillInJsonObject(jSONObject);
        JsonUtils.safePut(jSONObject, "js_dependency_version", "2.2.1");
        JsonUtils.safePut(jSONObject, "native_page", this.activityName);
        JsonUtils.safePut(jSONObject, "webview_type", this.webViewType);
        JsonUtils.deepCopy(jSONObject, this.extraPerformance);
        JsonUtils.deepCopy(jSONObject, this.eventObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("debug_context");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            JsonUtils.safePut(jSONObject, "debug_context", optJSONObject);
        }
        JsonUtils.safePut(optJSONObject, "is_ttweb_enable", Boolean.valueOf(((TTLiveWebViewMonitorHelper) TTLiveWebViewMonitorHelper.getInstance()).isTTWebEnable()));
    }
}
