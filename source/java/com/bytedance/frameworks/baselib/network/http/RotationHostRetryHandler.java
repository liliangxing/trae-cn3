package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class RotationHostRetryHandler {
    private final List<BaseRequestContext.RotationHostRetryInfo> mRetryHostInfoList;
    private int mRetryIndex;
    private final List<RetryMetrics> mRetryMetricsList;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class RetryMetrics {
        public long callbackDuration;
        public int code;
        public String host;
        public long lastRequestDuration;
        public String path;
        public boolean retry;

        public RetryMetrics(String str, String str2, int i, long j, long j2, boolean z) {
            this.host = str;
            this.path = str2;
            this.code = i;
            this.callbackDuration = j;
            this.lastRequestDuration = j2;
            this.retry = z;
        }
    }

    public RotationHostRetryHandler(List<BaseRequestContext.RotationHostRetryInfo> list) {
        ArrayList arrayList = new ArrayList();
        this.mRetryHostInfoList = arrayList;
        this.mRetryIndex = 0;
        this.mRetryMetricsList = new CopyOnWriteArrayList();
        if (list == null || list.isEmpty()) {
            return;
        }
        arrayList.addAll(list);
    }

    public boolean noRemainingRetryHost() {
        return this.mRetryHostInfoList.isEmpty() || this.mRetryIndex >= this.mRetryHostInfoList.size();
    }

    public BaseRequestContext.RotationHostRetryInfo getNextRetryHostInfo() {
        if (this.mRetryIndex >= this.mRetryHostInfoList.size()) {
            return null;
        }
        List<BaseRequestContext.RotationHostRetryInfo> list = this.mRetryHostInfoList;
        int i = this.mRetryIndex;
        this.mRetryIndex = i + 1;
        return list.get(i);
    }

    public void recordMetrics(String str, String str2, int i, long j, RequestRetryResult requestRetryResult, BaseHttpRequestInfo baseHttpRequestInfo) {
        this.mRetryMetricsList.add(new RetryMetrics(str, str2, i, j, System.currentTimeMillis() - (baseHttpRequestInfo.requestRetryStart > 0 ? baseHttpRequestInfo.requestRetryStart : baseHttpRequestInfo.requestStart), requestRetryResult != null && requestRetryResult.isRequestRetryEnabled()));
        if (baseHttpRequestInfo.metrics != null) {
            baseHttpRequestInfo.metrics.setRotationHostRetryInfo(constructJsonLog());
        }
    }

    public JSONObject constructJsonLog() {
        if (this.mRetryMetricsList.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (RetryMetrics retryMetrics : this.mRetryMetricsList) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("callback_duration", retryMetrics.callbackDuration);
                jSONObject2.put("request_duration", retryMetrics.lastRequestDuration);
                jSONObject2.put("code", retryMetrics.code);
                jSONObject.put(retryMetrics.host + retryMetrics.path, jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public RotationHostRetryHandler deepCopy() {
        ArrayList arrayList = new ArrayList();
        Iterator<BaseRequestContext.RotationHostRetryInfo> it = this.mRetryHostInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m3477clone());
        }
        RotationHostRetryHandler rotationHostRetryHandler = new RotationHostRetryHandler(arrayList);
        rotationHostRetryHandler.mRetryIndex = this.mRetryIndex;
        for (RetryMetrics retryMetrics : this.mRetryMetricsList) {
            rotationHostRetryHandler.mRetryMetricsList.add(new RetryMetrics(retryMetrics.host, retryMetrics.path, retryMetrics.code, retryMetrics.callbackDuration, retryMetrics.lastRequestDuration, retryMetrics.retry));
        }
        return rotationHostRetryHandler;
    }
}
