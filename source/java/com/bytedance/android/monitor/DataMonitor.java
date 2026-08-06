package com.bytedance.android.monitor;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.monitor.base.IMonitor;
import com.bytedance.android.monitor.base.IReportData;
import com.bytedance.android.monitor.entity.CustomInfo;
import com.bytedance.android.monitor.executor.MonitorExecutor;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.bytedance.android.monitor.util.ALogUtil;
import com.bytedance.android.monitor.util.ExceptionUtil;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.util.MonitorUtils;
import com.bytedance.android.monitor.util.UrlUtil;
import com.bytedance.android.monitor.webview.ITTLiveWebViewMonitor;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DataMonitor implements IMonitor {
    private static final String TAG = "DataMonitor";
    protected ITTLiveWebViewMonitor monitor;

    public DataMonitor(ITTLiveWebViewMonitor iTTLiveWebViewMonitor) {
        this.monitor = iTTLiveWebViewMonitor;
    }

    @Override // com.bytedance.android.monitor.base.IMonitor
    public void monitor(final IReportData iReportData) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            MonitorExecutor.INSTANCE.getExecutor().submit(new Runnable() { // from class: com.bytedance.android.monitor.DataMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    DataMonitor.monitor(iReportData, DataMonitor.this.monitor);
                }
            });
        } else {
            monitor(iReportData, this.monitor);
        }
    }

    public static void monitorCustom(CustomInfo customInfo) {
        if (customInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (customInfo.getCategory() != null) {
            JsonUtils.safePut(jSONObject, "client_category", customInfo.getCategory());
        }
        if (customInfo.getMetric() != null) {
            JsonUtils.safePut(jSONObject, "client_metric", customInfo.getMetric());
        }
        if (customInfo.getExtra() != null) {
            JsonUtils.safePut(customInfo.getExtra(), "event_name", customInfo.getEventName());
            JsonUtils.safePut(jSONObject, "client_extra", customInfo.getExtra());
        }
        if (customInfo.getTiming() != null) {
            JsonUtils.safePut(jSONObject, "client_timing", customInfo.getTiming());
        }
        String str = customInfo.isSample() ? "samplecustom" : "newcustom";
        String url = customInfo.getUrl();
        JsonUtils.safePut(jSONObject, "url", url);
        if (url != null) {
            JsonUtils.safePut(jSONObject, "host", UrlUtil.getHost(url));
            JsonUtils.safePut(jSONObject, "path", UrlUtil.getPath(url));
        }
        JsonUtils.safePut(jSONObject, "ev_type", "custom");
        JsonUtils.deepCopy(jSONObject, customInfo.getCommon());
        if (!TextUtils.isEmpty(customInfo.getVid())) {
            JsonUtils.safePut(jSONObject, "virtual_aid", customInfo.getVid());
        }
        monitorCustom(customInfo.getMonitor(), jSONObject, str, customInfo.getBiz(), false);
    }

    public static void monitorCustom(ITTLiveWebViewMonitor iTTLiveWebViewMonitor, JSONObject jSONObject, String str, String str2, boolean z) {
        try {
            if (jSONObject == null) {
                throw new NullPointerException("data should not be null");
            }
            if (iTTLiveWebViewMonitor == null) {
                throw new NullPointerException("monitor should not be null");
            }
            realMonitor(iTTLiveWebViewMonitor, jSONObject, str, "", str2, z);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    public static void monitor(IReportData iReportData, ITTLiveWebViewMonitor iTTLiveWebViewMonitor) {
        try {
            if (iReportData == null) {
                throw new NullPointerException("data should not be null");
            }
            if (iTTLiveWebViewMonitor == null) {
                throw new NullPointerException("monitor should not be null");
            }
            JSONObject jSONObject = new JSONObject();
            JsonUtils.safePut(jSONObject, "event_type", iReportData.getNativeInfo().eventType);
            if (iReportData.getNativeBase() != null) {
                JsonUtils.safePut(jSONObject, "nativeBase", iReportData.getNativeBase().toJsonObject());
            }
            if (iReportData.getNativeInfo() != null) {
                JsonUtils.safePut(jSONObject, "nativeInfo", iReportData.getNativeInfo().toJsonObject());
            }
            if (iReportData.getJsInfo() != null) {
                JsonUtils.safePut(jSONObject, "jsInfo", iReportData.getJsInfo());
            }
            if (iReportData.getJsBase() != null) {
                JsonUtils.safePut(jSONObject, "jsBase", iReportData.getJsBase());
            }
            if (iReportData.getContainerBase() != null) {
                JsonUtils.safePut(jSONObject, "containerBase", iReportData.getContainerBase().toJsonObject());
            }
            if (iReportData.getContainerInfo() != null) {
                JsonUtils.safePut(jSONObject, "containerInfo", iReportData.getContainerInfo().toJsonObject());
            }
            realMonitor(iTTLiveWebViewMonitor, jSONObject, iReportData.getEventType(), iReportData.getContainerType(), iReportData.getBiz(), !isInALogFilter(iReportData.getEventType()));
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    private static void realMonitor(ITTLiveWebViewMonitor iTTLiveWebViewMonitor, JSONObject jSONObject, String str, String str2, String str3, boolean z) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.safePut(jSONObject2, "extra", jSONObject);
        String mapService = MonitorUtils.mapService(str, str2, str3);
        HybridMonitor.getInstance().notifyReportInterceptor(mapService, str, str2, jSONObject2);
        if (iTTLiveWebViewMonitor != null && checkEnableReport(jSONObject2, mapService)) {
            iTTLiveWebViewMonitor.monitorStatusAndDuration(mapService, 0, null, jSONObject2);
            MonitorLog.m6d(TAG, "monitor : " + mapService);
        }
        if (z) {
            ALogUtil.m12i("BDHybridMonitor", String.format("service:%s,data:%s", mapService, jSONObject2));
        }
    }

    private static boolean isInALogFilter(String str) {
        return "jsbPerf".equals(str);
    }

    private static boolean checkEnableReport(JSONObject jSONObject, String str) {
        String str2;
        if (jSONObject == null || str == null) {
            str2 = null;
        } else {
            try {
                JSONObject safeOptJsonObj = JsonUtils.safeOptJsonObj(jSONObject, "extra");
                str2 = JsonUtils.safeOptStr(safeOptJsonObj, "virtual_aid");
                if (TextUtils.isEmpty(str2)) {
                    str2 = JsonUtils.safeOptStr(JsonUtils.safeOptJsonObj(safeOptJsonObj, "nativeBase"), "virtual_aid");
                }
            } catch (Throwable th) {
                ExceptionUtil.handleException(th);
                return true;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "default";
        }
        return !DisableListDataManager.get().isMatchDisable(str2, str);
    }
}
