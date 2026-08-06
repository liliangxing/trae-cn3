package com.bytedance.android.monitorV2.webview.cache.impl;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.base.IMonitorData;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.cache.base.WebBaseReportData;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FalconXReportData extends WebBaseReportData {
    private static final String TAG = "FalconXReportData";
    private FalconXInfo nativeInfo;

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public IMonitorData getContainerInfo() {
        return null;
    }

    public FalconXReportData(WebNativeCommon webNativeCommon) {
        super(webNativeCommon, "falconPerf", webNativeCommon.containerType);
        this.nativeInfo = new FalconXInfo("falconPerf");
    }

    @Override // com.bytedance.android.monitorV2.webview.cache.base.WebBaseReportData, com.bytedance.android.monitorV2.base.BaseReportData, com.bytedance.android.monitorV2.base.IReportData
    public BaseNativeInfo getNativeInfo() {
        return this.nativeInfo;
    }

    @Override // com.bytedance.android.monitorV2.webview.cache.base.WebBaseReportData, com.bytedance.android.monitorV2.webview.cache.base.INativeInfoCache
    public void save(JSONObject jSONObject) {
        this.nativeInfo.save(jSONObject);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private class FalconXInfo extends BaseNativeInfo {
        private JSONArray array;

        public FalconXInfo(String str) {
            super(str);
            this.array = new JSONArray();
        }

        @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
        public void fillInJsonObject(JSONObject jSONObject) {
            JsonUtils.safePut(jSONObject, "resource_list", this.array);
        }

        public void save(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.array.put(jSONObject);
        }
    }
}
