package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitMetrics;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class TTNetRequestLogReporterBridge implements RetrofitMetrics.IRequestLogReporterBridge {
    private static final TTNetRequestLogReporterBridge BRIDGE = new TTNetRequestLogReporterBridge();
    private static boolean useMonitorV2 = false;
    private static boolean disallowDupReport = false;

    private void processCastError(Object obj) {
        BaseHttpRequestInfo baseHttpRequestInfo = (BaseHttpRequestInfo) obj;
        if (baseHttpRequestInfo.url != null) {
            Logger.e("TTNetCallMonitor", "monitor cast error" + baseHttpRequestInfo.url.getPath());
        }
    }

    public static void inject() {
        RetrofitMetrics.setRequestLogReporterBridge(BRIDGE);
    }

    public static void setUseMonitorV2(boolean z) {
        useMonitorV2 = z;
    }

    public static void setDisallowDupReport(boolean z) {
        disallowDupReport = z;
    }

    public void monitorApiOk(String str, Object obj) {
        try {
            BaseHttpRequestInfo baseHttpRequestInfo = (BaseHttpRequestInfo) obj;
            if (!disallowDupReport || baseHttpRequestInfo.reported.compareAndSet(false, true)) {
                if (useMonitorV2) {
                    NetworkParams.monitorApiOkV2(str, baseHttpRequestInfo);
                } else {
                    NetworkParams.monitorApiOk(str, baseHttpRequestInfo);
                }
            }
        } catch (ClassCastException unused) {
            processCastError(obj);
        }
    }

    public void monitorApiError(String str, Object obj, Throwable th) {
        try {
            BaseHttpRequestInfo baseHttpRequestInfo = (BaseHttpRequestInfo) obj;
            if (!disallowDupReport || baseHttpRequestInfo.reported.compareAndSet(false, true)) {
                if (useMonitorV2) {
                    NetworkParams.monitorApiErrorV2(str, baseHttpRequestInfo, th);
                } else {
                    NetworkParams.monitorApiError(str, baseHttpRequestInfo, th);
                }
            }
        } catch (ClassCastException unused) {
            processCastError(obj);
        }
    }

    public boolean isAllErrorReport() {
        return NetworkParams.isAllErrorReport();
    }
}
