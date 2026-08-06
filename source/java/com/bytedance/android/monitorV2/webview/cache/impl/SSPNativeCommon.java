package com.bytedance.android.monitorV2.webview.cache.impl;

import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.constant.WebViewMonitorConstant;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SSPNativeCommon extends NativeCommon {
    public String eventType = null;
    public String engineType = null;
    public String formatUrl = null;
    public String fullUrl = null;
    public String rootUrl = null;
    public String parentUrl = null;
    public String biz = null;
    public String resFormatSrc = null;
    public String resFullSrc = null;
    public String resFrom = null;
    public Integer resSize = null;
    public String resType = null;
    public String requestMethod = null;

    public String getContainerType() {
        return this.containerType;
    }

    public void setContainerType(String str) {
        this.containerType = str;
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

    public String getNavigationIdCache() {
        return this.navigationId;
    }

    public void setNavigationIdCache(String str) {
        this.navigationId = str;
    }

    public String getEngineTypeCache() {
        return this.engineType;
    }

    public String getEventTypeCache() {
        return this.eventType;
    }

    public void setEngineType(String str) {
        this.engineType = str;
    }

    public void setEventType(String str) {
        this.eventType = str;
    }

    public String getFormatUrlCache() {
        return this.formatUrl;
    }

    public void setFormatUrl(String str) {
        this.formatUrl = str;
    }

    public String getFullUrl() {
        return this.fullUrl;
    }

    public void setFullUrl(String str) {
        this.fullUrl = str;
    }

    public String getParentUrl() {
        return this.parentUrl;
    }

    public void setParentUrl(String str) {
        this.parentUrl = str;
    }

    public String getRootUrl() {
        return this.rootUrl;
    }

    public void setRootUrl(String str) {
        this.rootUrl = str;
    }

    public String getBiz() {
        return this.biz;
    }

    public void setBiz(String str) {
        this.biz = str;
    }

    public String getResFormatSrc() {
        return this.resFormatSrc;
    }

    public void setResFormatSrc(String str) {
        this.resFormatSrc = str;
    }

    public String getResFrom() {
        return this.resFrom;
    }

    public void setResFrom(String str) {
        this.resFrom = str;
    }

    public Integer getResSize() {
        return this.resSize;
    }

    public void setResSize(Integer num) {
        this.resSize = num;
    }

    public String getResType() {
        return this.resType;
    }

    public void setResType(String str) {
        this.resType = str;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public void setRequestMethod(String str) {
        this.requestMethod = str;
    }

    @Override // com.bytedance.android.monitorV2.entity.NativeCommon, com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jSONObject) {
        super.fillInJsonObject(jSONObject);
        String str = this.engineType;
        if (str != null) {
            JsonUtils.safePut(jSONObject, "engine_type", str);
        }
        String str2 = this.eventType;
        if (str2 != null) {
            JsonUtils.safePut(jSONObject, "event_type", str2);
        }
        String str3 = this.formatUrl;
        if (str3 != null) {
            JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Web.FORMAT_URL, str3);
        }
        String str4 = this.fullUrl;
        if (str4 != null) {
            JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Web.FULL_URL, str4);
        }
        String str5 = this.parentUrl;
        if (str5 != null) {
            JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Web.PARENT_URL, str5);
        }
        String str6 = this.rootUrl;
        if (str6 != null) {
            JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Web.ROOT_URL, str6);
        }
        String str7 = this.biz;
        if (str7 != null) {
            JsonUtils.safePut(jSONObject, "biz", str7);
        }
        String str8 = this.resFormatSrc;
        if (str8 != null) {
            JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Web.RES_FORMAT_SRC, str8);
        }
        String str9 = this.resFullSrc;
        if (str9 != null) {
            JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Web.RES_FULL_SRC, str9);
        }
        String str10 = this.resFrom;
        if (str10 != null) {
            JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Web.RES_FROM, str10);
        }
        Integer num = this.resSize;
        if (num != null) {
            JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Web.RES_SIZE, num);
        }
        String str11 = this.resType;
        if (str11 != null) {
            JsonUtils.safePut(jSONObject, "res_type", str11);
        }
        String str12 = this.requestMethod;
        if (str12 != null) {
            JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Web.REQUEST_METHOD, str12);
        }
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
