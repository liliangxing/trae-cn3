package com.bytedance.android.monitorV2.webview.cache.base;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.base.BaseReportData;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.cache.impl.WebNativeCommon;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class WebBaseReportData extends BaseReportData implements INativeInfoCache {
    protected ContainerBase containerBase;
    private String containerType;
    private String eventType;
    private JSONObject jsBaseObject;
    private JSONObject jsInfoObject;
    protected WebNativeCommon nativeCommon;

    @Override // com.bytedance.android.monitorV2.base.BaseReportData, com.bytedance.android.monitorV2.base.IReportData
    public abstract BaseNativeInfo getNativeInfo();

    @Override // com.bytedance.android.monitorV2.webview.cache.base.INativeInfoCache
    public void save(JSONObject jSONObject) {
    }

    public WebBaseReportData(WebNativeCommon webNativeCommon, String str, String str2) {
        this.nativeCommon = webNativeCommon;
        this.eventType = str;
        this.containerType = str2;
    }

    public WebBaseReportData() {
    }

    public void saveJsData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.jsBaseObject = new JSONObject();
            this.jsInfoObject = new JSONObject();
            JsonUtils.deepCopy(this.jsBaseObject, jSONObject.optJSONObject("jsBase"));
            JsonUtils.deepCopy(this.jsInfoObject, jSONObject.optJSONObject("jsInfo"));
        }
    }

    public void setContainerBase(ContainerBase containerBase) {
        this.containerBase = containerBase;
    }

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public JSONObject getJsInfo() {
        return this.jsInfoObject;
    }

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public JSONObject getJsBase() {
        return this.jsBaseObject;
    }

    @Override // com.bytedance.android.monitorV2.base.BaseReportData, com.bytedance.android.monitorV2.base.IReportData
    public NativeCommon getNativeBase() {
        return this.nativeCommon;
    }

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public String getEventType() {
        return this.eventType;
    }

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public String getContainerType() {
        return this.containerType;
    }

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public ContainerBase getContainerBase() {
        return this.containerBase;
    }
}
