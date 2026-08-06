package com.bytedance.android.monitorV2.webview.cache.impl;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.base.IMonitorData;
import com.bytedance.android.monitorV2.entity.ContainerInfo;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.cache.base.WebBaseReportData;
import com.bytedance.android.monitorV2.webview.constant.WebViewMonitorConstant;
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
    private boolean isFirstPageStarted;
    private ContainerInfo mContainerInfo;
    private JSONObject mTTWebViewMetrics;
    private long pageFinish;
    private long pageStart;
    private BaseNativeInfo perfCache;
    private long progressEnd;
    private long showEnd;
    private long showStart;

    public WebPerfReportData(WebNativeCommon webNativeCommon, String str) {
        super(webNativeCommon, str, webNativeCommon.containerType);
        this.perfCache = new BaseNativeInfo("performance") { // from class: com.bytedance.android.monitorV2.webview.cache.impl.WebPerfReportData.1
            @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
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
                JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Params.IS_FIRST_PAGE_STARTED, Boolean.valueOf(WebPerfReportData.this.isFirstPageStarted));
                JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Params.TTWEBVIEW_TIMING, WebPerfReportData.this.mTTWebViewMetrics);
            }
        };
        this.countObject = new JSONObject();
        this.alreadyReportSet = new HashSet();
    }

    public Set<String> getAlreadyReportSet() {
        return this.alreadyReportSet;
    }

    @Override // com.bytedance.android.monitorV2.webview.cache.base.WebBaseReportData, com.bytedance.android.monitorV2.base.BaseReportData, com.bytedance.android.monitorV2.base.IReportData
    public BaseNativeInfo getNativeInfo() {
        return this.perfCache;
    }

    @Override // com.bytedance.android.monitorV2.base.IReportData
    public IMonitorData getContainerInfo() {
        return this.mContainerInfo;
    }

    public void handlePageStart(boolean z) {
        if (this.pageStart == 0) {
            this.pageStart = System.currentTimeMillis();
        }
        this.isFirstPageStarted = z;
    }

    public void handlePageFinish() {
        if (this.pageFinish == 0) {
            this.pageFinish = System.currentTimeMillis();
        }
    }

    public void setTTWebViewMetrics(JSONObject jSONObject) {
        this.mTTWebViewMetrics = jSONObject;
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
        long j;
        if (this.nativeCommon.getLoadUrlTime() != 0) {
            this.enableInitTime = true;
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
                ExceptionUtil.handleException(e);
                j = 0;
            }
            long loadUrlTime = j - this.nativeCommon.getLoadUrlTime();
            this.initTime = loadUrlTime;
            if (loadUrlTime < 0) {
                this.initTime = 0L;
            }
            MonitorLog.m26d(TAG, " updateMonitorInitTimeData : " + this.initTime);
        }
    }

    public void addCount(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JsonUtils.safePut(this.countObject, str, JsonUtils.safeOptInt(this.countObject, str) + 1);
        this.alreadyReportSet.add(str);
        MonitorLog.m26d(TAG, "addCount: " + str);
    }

    public long getPageStart() {
        return this.pageStart;
    }
}
