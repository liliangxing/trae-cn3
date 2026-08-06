package org.chromium;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.ttnet.org.chromium.net.TTMonitorProvider;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CronetAppMonitorProvider extends TTMonitorProvider {
    private static CronetAppMonitorProvider sInstance;

    @Deprecated
    public boolean handleApiSample(String str, String str2) {
        return true;
    }

    public static CronetAppMonitorProvider inst() {
        if (sInstance == null) {
            synchronized (CronetAppMonitorProvider.class) {
                if (sInstance == null) {
                    sInstance = new CronetAppMonitorProvider();
                }
            }
        }
        return sInstance;
    }

    private CronetAppMonitorProvider() {
    }

    public void sendAppMonitorEvent(String str, String str2) {
        CronetAppProviderManager.inst().sendAppMonitorEvent(str, str2);
    }

    public void handleApiResult(boolean z, String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, boolean z2, long j11, long j12, String str4, String str5, String str6, int i, int i2, String str7) {
        BaseHttpRequestInfo createHttpRequestInfo = BaseHttpRequestInfo.createHttpRequestInfo();
        createHttpRequestInfo.traceCode = str2;
        createHttpRequestInfo.remoteIp = str3;
        createHttpRequestInfo.appLevelRequestStart = j;
        createHttpRequestInfo.beforeAllInterceptors = j;
        createHttpRequestInfo.requestStart = j2;
        createHttpRequestInfo.metrics.retrofit.eventTs.ssHttpCallApiStartTime = j2;
        createHttpRequestInfo.requestEnd = j5;
        createHttpRequestInfo.metrics.retrofit.eventTs.requestEndTime = j5;
        createHttpRequestInfo.metrics.setKernelDns(j6);
        createHttpRequestInfo.metrics.setKernelTCPConnect(j7);
        createHttpRequestInfo.metrics.setKernelTls(j8);
        createHttpRequestInfo.metrics.setKernelSend(j9);
        createHttpRequestInfo.metrics.setKernelTTFB(j11);
        createHttpRequestInfo.metrics.setKernelReceiveBody(j10);
        createHttpRequestInfo.metrics.setKernelTotal(j5 - j2);
        createHttpRequestInfo.metrics.setNetworkKernelRawRequestLog(str4);
        createHttpRequestInfo.responseBack = j3;
        createHttpRequestInfo.completeReadResponse = j4;
        createHttpRequestInfo.isSocketReused = z2;
        createHttpRequestInfo.receivedByteCount = j12;
        createHttpRequestInfo.requestHeaders = str5;
        createHttpRequestInfo.responseHeaders = str6;
        createHttpRequestInfo.httpClientType = 0;
        if (z) {
            NetworkParams.monitorApiOk(str, createHttpRequestInfo);
        } else {
            NetworkParams.monitorApiError(str, createHttpRequestInfo, Utils.tryConvertCronetException(Utils.createCronetException(i, i2, str7)));
        }
    }
}
