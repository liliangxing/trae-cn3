package org.chromium;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetRequestExtraInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import java.util.Date;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTCronetRequestFinishedInfoListener extends RequestFinishedInfo.Listener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private BaseHttpRequestInfo requestInfo;

    private static long getCostTime(long j, long j2) {
        if (j2 == -1 || j == -1 || j2 > j) {
            return -1L;
        }
        return j - j2;
    }

    public TTCronetRequestFinishedInfoListener(BaseHttpRequestInfo baseHttpRequestInfo) {
        super(new Executor() { // from class: org.chromium.TTCronetRequestFinishedInfoListener$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TTCronetRequestFinishedInfoListener.lambda$new$0(runnable);
            }
        });
        this.requestInfo = baseHttpRequestInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$new$0(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
        RequestFinishedInfo.Metrics metrics;
        if (this.requestInfo == null || requestFinishedInfo == null || (metrics = requestFinishedInfo.getMetrics()) == null) {
            return;
        }
        this.requestInfo.nativeRequestStartTime = getTime(metrics.getRequestStart());
        this.requestInfo.metrics.setKernelDns(getCostTime(getTime(metrics.getDnsEnd()), getTime(metrics.getDnsStart())));
        this.requestInfo.metrics.setKernelTCPConnect(getCostTime(getTime(metrics.getConnectEnd()), getTime(metrics.getConnectStart())));
        this.requestInfo.metrics.setKernelTls(getCostTime(getTime(metrics.getSslEnd()), getTime(metrics.getSslStart())));
        this.requestInfo.metrics.setKernelSend(getCostTime(getTime(metrics.getSendingEnd()), getTime(metrics.getSendingStart())));
        this.requestInfo.metrics.setKernelPush(getCostTime(getTime(metrics.getPushEnd()), getTime(metrics.getPushStart())));
        this.requestInfo.metrics.setKernelTTFB(getValue(metrics.getTtfbMs()));
        this.requestInfo.metrics.setKernelReceiveBody(getCostTime(getTime(metrics.getRequestEnd()), getTime(metrics.getResponseStart())));
        this.requestInfo.metrics.setKernelTotal(getValue(metrics.getTotalTimeMs()));
        this.requestInfo.metrics.setUpperAddCookieDurationUs(getValue(metrics.getAddCookieCostUs()));
        this.requestInfo.metrics.setUpperSaveCookieDurationUs(getValue(metrics.getSaveCookieCostUs()));
        this.requestInfo.metrics.setRequestCookieSourceType(getValue(metrics.getRequestCookieSource()));
        this.requestInfo.metrics.setCronetReadResponseBodyMetrics(metrics.getResponseBodyReadTimes(), metrics.getFirstReadResponseBodyStart(), metrics.getLastReadResponseBodyEnd(), metrics.getReadResponseBodyDuration(), metrics.getBizReadResponseBodyInterval());
        this.requestInfo.metrics.setNetworkKernelRawRequestLog(metrics.getRequestLog());
        CronetRequestExtraInfo cronetRequestExtraInfo = new CronetRequestExtraInfo();
        cronetRequestExtraInfo.urlDispatchDropReason = metrics.getURLDispatchDropReason();
        this.requestInfo.metrics.setRequestExtraInfo(cronetRequestExtraInfo);
        this.requestInfo.remoteIp = metrics.getPeerAddr() + ":" + metrics.getPeerPort();
        this.requestInfo.isSocketReused = metrics.getSocketReused();
        this.requestInfo.sentByteCount = getValue(metrics.getSentByteCount());
        this.requestInfo.receivedByteCount = getValue(metrics.getReceivedByteCount());
        this.requestInfo.retryAttempts = getValue(metrics.getRetryAttempts());
        this.requestInfo.requestHeaders = metrics.getRequestHeaders();
        this.requestInfo.responseHeaders = metrics.getResponseHeaders();
        this.requestInfo.hasSampled = metrics.getPreSamplingReportable();
        this.requestInfo.bypassApiReport = metrics.getBypassApiReport();
        if (TextUtils.isEmpty(this.requestInfo.requestLog)) {
            addABTestInfo(this.requestInfo.extraInfo);
        }
        try {
            this.requestInfo.metrics.extra.put("sentByteCount", Long.valueOf(this.requestInfo.sentByteCount));
            this.requestInfo.metrics.extra.put("receivedByteCount", Long.valueOf(this.requestInfo.receivedByteCount));
            this.requestInfo.extraInfo.put("retrofit", this.requestInfo.metrics.getRetrofitLog());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.requestInfo.metrics.markNetworkKernelLogCollected();
    }

    private static void addABTestInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject aBTest = SsCronetHttpClient.getCronetTncInfoGet() != null ? SsCronetHttpClient.getCronetTncInfoGet().getABTest() : null;
        if (aBTest != null) {
            try {
                jSONObject.put("ab_test", aBTest);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static int getValue(Integer num) {
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    private static long getValue(Long l) {
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    private static long getTime(Date date) {
        if (date == null) {
            return -1L;
        }
        return date.getTime();
    }
}
