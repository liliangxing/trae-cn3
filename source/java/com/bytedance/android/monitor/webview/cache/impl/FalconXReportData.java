package com.bytedance.android.monitor.webview.cache.impl;

import com.bytedance.android.monitor.base.IMonitorData;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.webview.cache.base.AbsWebNativeInfo;
import com.bytedance.android.monitor.webview.cache.base.WebBaseReportData;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FalconXReportData extends WebBaseReportData {
    private static final String TAG = "FalconXReportData";
    private FalconXInfo nativeInfo;

    @Override // com.bytedance.android.monitor.base.IReportData
    public IMonitorData getContainerInfo() {
        return null;
    }

    public FalconXReportData(WebNativeCommon webNativeCommon) {
        super(webNativeCommon, "falconPerf", webNativeCommon.containerType);
        this.nativeInfo = new FalconXInfo("falconPerf");
    }

    @Override // com.bytedance.android.monitor.webview.cache.base.WebBaseReportData, com.bytedance.android.monitor.base.BaseReportData, com.bytedance.android.monitor.base.IReportData
    public AbsWebNativeInfo getNativeInfo() {
        return this.nativeInfo;
    }

    @Override // com.bytedance.android.monitor.webview.cache.base.WebBaseReportData, com.bytedance.android.monitor.webview.cache.base.INativeInfoCache
    public void save(JSONObject jSONObject) {
        this.nativeInfo.save(jSONObject);
    }

    @Override // com.bytedance.android.monitor.webview.cache.base.WebBaseReportData, com.bytedance.android.monitor.webview.cache.base.INativeInfoCache
    public boolean isCanReport() {
        return this.nativeInfo.isCanReport();
    }

    @Override // com.bytedance.android.monitor.webview.cache.base.WebBaseReportData, com.bytedance.android.monitor.webview.cache.base.INativeInfoCache
    public void reset() {
        this.nativeInfo.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class FalconXInfo extends AbsWebNativeInfo {
        private JSONArray array;

        public FalconXInfo(String str) {
            super(str);
            this.array = new JSONArray();
        }

        @Override // com.bytedance.android.monitor.webview.cache.base.AbsWebNativeInfo
        public void reset() {
            disableReport();
        }

        @Override // com.bytedance.android.monitor.base.BaseMonitorData
        public void fillInJsonObject(JSONObject jSONObject) {
            JsonUtils.safePut(jSONObject, "resource_list", this.array);
        }

        public void save(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.array.put(jSONObject);
            enableReport();
        }
    }
}
