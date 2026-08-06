package com.bytedance.android.monitor.webview.cache.base;

import com.bytedance.android.monitor.base.BaseReportData;
import com.bytedance.android.monitor.entity.ContainerCommon;
import com.bytedance.android.monitor.entity.NativeCommon;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper;
import com.bytedance.android.monitor.webview.cache.impl.WebNativeCommon;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class WebBaseReportData extends BaseReportData implements INativeInfoCache {
    private String biz;
    protected ContainerCommon containerBase;
    private String containerType;
    private String eventType;
    private JSONObject jsBaseObject;
    private JSONObject jsInfoObject;
    protected WebNativeCommon nativeCommon;

    @Override // com.bytedance.android.monitor.base.BaseReportData, com.bytedance.android.monitor.base.IReportData
    public abstract AbsWebNativeInfo getNativeInfo();

    @Override // com.bytedance.android.monitor.webview.cache.base.INativeInfoCache
    public void save(JSONObject jSONObject) {
    }

    public WebBaseReportData(WebNativeCommon webNativeCommon, String str, String str2) {
        this.nativeCommon = webNativeCommon;
        this.biz = TTLiveWebViewMonitorHelper.getInnerInstance().getBiz(webNativeCommon.getWebViewSoftReference().get());
        this.eventType = str;
        this.containerType = str2;
    }

    public void saveJsData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.jsBaseObject = new JSONObject();
            this.jsInfoObject = new JSONObject();
            JsonUtils.deepCopy(this.jsBaseObject, jSONObject.optJSONObject("jsBase"));
            JsonUtils.deepCopy(this.jsInfoObject, jSONObject.optJSONObject("jsInfo"));
        }
    }

    public void setContainerBase(ContainerCommon containerCommon) {
        this.containerBase = containerCommon;
    }

    @Override // com.bytedance.android.monitor.base.IReportData
    public JSONObject getJsInfo() {
        return this.jsInfoObject;
    }

    @Override // com.bytedance.android.monitor.base.IReportData
    public JSONObject getJsBase() {
        return this.jsBaseObject;
    }

    @Override // com.bytedance.android.monitor.base.BaseReportData, com.bytedance.android.monitor.base.IReportData
    public NativeCommon getNativeBase() {
        return this.nativeCommon;
    }

    @Override // com.bytedance.android.monitor.base.IReportData
    public String getEventType() {
        return this.eventType;
    }

    @Override // com.bytedance.android.monitor.base.IReportData
    public String getContainerType() {
        return this.containerType;
    }

    @Override // com.bytedance.android.monitor.base.IReportData
    public ContainerCommon getContainerBase() {
        return this.containerBase;
    }

    @Override // com.bytedance.android.monitor.base.IReportData
    public String getBiz() {
        return this.biz;
    }

    @Override // com.bytedance.android.monitor.webview.cache.base.INativeInfoCache
    public boolean isCanReport() {
        if (getNativeInfo() != null) {
            return getNativeInfo().isCanReport();
        }
        return true;
    }

    @Override // com.bytedance.android.monitor.webview.cache.base.INativeInfoCache
    public void reset() {
        if (getNativeInfo() != null) {
            getNativeInfo().reset();
        }
    }
}
