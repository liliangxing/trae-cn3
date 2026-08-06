package com.bytedance.android.monitorV2.webview.cache.impl;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.util.ActivityUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WebNativeCommon extends NativeCommon {
    private long loadUrlTime;
    public String webViewType = "web";
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

    public void initNativePage(Context context) {
        Activity activityByContext = ActivityUtil.getActivityByContext(context);
        if (activityByContext != null) {
            HybridMultiMonitor.getInstance().wrapTouchTraceCallback(activityByContext);
            this.nativePage = activityByContext.getClass().getName();
        }
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

    @Override // com.bytedance.android.monitorV2.entity.NativeCommon, com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jSONObject) {
        super.fillInJsonObject(jSONObject);
        JsonUtils.safePut(jSONObject, "js_dependency_version", "2.2.1");
        JsonUtils.safePut(jSONObject, "webview_type", this.webViewType);
        JsonUtils.deepCopy(jSONObject, this.extraPerformance);
        JsonUtils.deepCopy(jSONObject, this.eventObject);
        addDebugContext(jSONObject);
    }

    public void addDebugContext(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("debug_context");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            JsonUtils.safePut(jSONObject, "debug_context", optJSONObject);
        }
        JsonUtils.safePut(optJSONObject, "is_ttweb_enable", String.valueOf(((WebViewMonitorHelper) WebViewMonitorHelper.getInstance()).isTTWebEnable()));
    }
}
