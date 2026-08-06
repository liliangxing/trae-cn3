package com.bytedance.android.monitor.webview.cache.impl;

import android.text.TextUtils;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitor.base.IMonitorData;
import com.bytedance.android.monitor.entity.ContainerInfo;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper;
import com.bytedance.android.monitor.webview.cache.base.AbsWebNativeInfo;
import com.bytedance.android.monitor.webview.cache.base.WebBaseReportData;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WebPerfReportData extends WebBaseReportData {
    private static final String TAG = "WebPerfReportData";
    private Set<String> alreadyReportSet;
    private JSONObject countObject;
    private boolean enableInitTime;
    private long initTime;
    private long injectTime;
    private ContainerInfo mContainerInfo;
    private long pageFinish;
    private long pageLoadCost;
    private long pageStart;
    private AbsWebNativeInfo perfCache;
    private long progressEnd;
    private long showEnd;
    private long showStart;

    public WebPerfReportData(WebNativeCommon webNativeCommon, String str) {
        super(webNativeCommon, str, webNativeCommon.containerType);
        this.perfCache = new AbsWebNativeInfo("performance") { // from class: com.bytedance.android.monitor.webview.cache.impl.WebPerfReportData.1
            {
                enableReport();
            }

            @Override // com.bytedance.android.monitor.webview.cache.base.AbsWebNativeInfo
            public void reset() {
                disableReport();
            }

            @Override // com.bytedance.android.monitor.base.BaseMonitorData
            public void fillInJsonObject(JSONObject jSONObject) {
                JsonUtils.safePut(jSONObject, "page_start", WebPerfReportData.this.pageStart);
                JsonUtils.safePut(jSONObject, "page_finish", WebPerfReportData.this.pageFinish);
                JsonUtils.safePut(jSONObject, "page_progress_100", WebPerfReportData.this.progressEnd);
                JsonUtils.safePut(jSONObject, "show_start", WebPerfReportData.this.showStart);
                JsonUtils.safePut(jSONObject, "show_end", WebPerfReportData.this.showEnd);
                if (WebPerfReportData.this.enableInitTime) {
                    JsonUtils.safePut(jSONObject, "init_time", WebPerfReportData.this.initTime);
                }
                JsonUtils.safePut(jSONObject, "inject_js_time", WebPerfReportData.this.injectTime);
                JsonUtils.safePut(jSONObject, "event_counts", WebPerfReportData.this.countObject);
                JsonUtils.safePut(jSONObject, "load_start", WebPerfReportData.this.nativeCommon.getLoadUrlTime());
            }
        };
        this.countObject = new JSONObject();
        this.alreadyReportSet = new HashSet();
    }

    public Set<String> getAlreadyReportSet() {
        return this.alreadyReportSet;
    }

    @Override // com.bytedance.android.monitor.webview.cache.base.WebBaseReportData, com.bytedance.android.monitor.base.BaseReportData, com.bytedance.android.monitor.base.IReportData
    public AbsWebNativeInfo getNativeInfo() {
        return this.perfCache;
    }

    @Override // com.bytedance.android.monitor.base.IReportData
    public IMonitorData getContainerInfo() {
        return this.mContainerInfo;
    }

    public void handlePageStart() {
        if (this.pageStart == 0) {
            this.pageStart = System.currentTimeMillis();
        }
    }

    public void handlePageFinish() {
        if (this.pageFinish == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.pageFinish = currentTimeMillis;
            long j = currentTimeMillis - this.pageStart;
            this.pageLoadCost = j;
            if (j < 0) {
                this.pageLoadCost = 0L;
            }
            if (HybridMonitor.getInstance().isAbTestEnable()) {
                TTLiveWebViewMonitorHelper.getInstance().reportABTestData(this.nativeCommon.getWebViewSoftReference().get(), this.pageLoadCost);
            }
        }
    }

    public void injectJS(long j) {
        this.injectTime = j;
    }

    public void handlePageEnter() {
        this.showStart = System.currentTimeMillis();
    }

    public void handlePageExit() {
        this.showEnd = System.currentTimeMillis();
    }

    public void handlePageProgress(int i) {
        if (i == 100 && this.progressEnd == 0) {
            this.progressEnd = System.currentTimeMillis();
        }
    }

    public void setContainerInfo(ContainerInfo containerInfo) {
        this.mContainerInfo = containerInfo;
    }

    public void updateMonitorInitTimeData(String str) {
        if (this.nativeCommon.getLoadUrlTime() != 0) {
            this.enableInitTime = true;
            long parseLong = Long.parseLong(str) - this.nativeCommon.getLoadUrlTime();
            this.initTime = parseLong;
            if (parseLong < 0) {
                this.initTime = 0L;
            }
            MonitorLog.m6d(TAG, " updateMonitorInitTimeData : " + this.initTime);
        }
    }

    public void addCount(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JsonUtils.safePut(this.countObject, str, JsonUtils.safeOptInt(this.countObject, str) + 1);
        this.alreadyReportSet.add(str);
        MonitorLog.m6d(TAG, "addCount: " + str);
    }
}
