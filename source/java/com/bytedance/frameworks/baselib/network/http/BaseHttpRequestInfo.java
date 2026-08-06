package com.bytedance.frameworks.baselib.network.http;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.retrofit2.LegacyLogRecorder;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BaseHttpRequestInfo<T extends BaseRequestContext> implements LegacyLogRecorder {
    public static final int HTTP_CLIENT_TYPE_CRONET = 0;
    public static final int HTTP_CLIENT_TYPE_OK3 = 1;
    public static final String KEY_ABTEST = "ab_test";
    public static final String KEY_COOKIE = "cookie";
    public static final String KEY_EXCEPTION = "ex";
    public static final String KEY_HIT = "hit";
    public static final String KEY_HTTP_CLIENT = "hc";
    public static final String KEY_HTTP_CLIENT_VERSION = "hcv";
    public static final String KEY_RESPONSE_HEADERS = "response-headers";
    public static final String KEY_USER_AGENT = "ua";
    private static volatile ICreate sCreate = new ICreate() { // from class: com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo.1
        @Override // com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo.ICreate
        public BaseHttpRequestInfo create() {
            return new BaseHttpRequestInfo();
        }
    };

    @Deprecated
    public long appLevelRequestStart;

    @Deprecated
    public long beforeAllInterceptors;
    public boolean bypassApiReport;

    @Deprecated
    public long completeReadResponse;

    @Deprecated
    public long connectTime;

    @Deprecated
    public long dnsTime;
    public boolean hasSampled;

    @Deprecated
    public boolean isSocketReused;

    @Deprecated
    public long nativeRequestStartTime;

    @Deprecated
    public long pushTime;

    @Deprecated
    public long receiveTime;

    @Deprecated
    public long receivedByteCount;

    @Deprecated
    public String remoteIp;
    public T reqContext;

    @Deprecated
    public long requestEnd;
    public String requestHeaders;
    public long requestRetryStart;

    @Deprecated
    public long responseBack;
    public long responseBodyByteCount;
    public String responseHeaders;

    @Deprecated
    public long retryAttempts;
    public String retryByHeaderFilterKey;
    public RotationHostRetryHandler rotationHostPathRetryHandler;

    @Deprecated
    public long sendTime;

    @Deprecated
    public long sentByteCount;

    @Deprecated
    public long sslTime;

    @Deprecated
    public long totalTime;

    @Deprecated
    public long ttfbMs;
    public URL url;
    public boolean useCronetInputStreamWithTTBuffer = false;
    public int customInputStreamSize = -1;
    public RetrofitMetrics metrics = new RetrofitMetrics(this);

    @Deprecated
    public long requestStart = System.currentTimeMillis();

    @Deprecated
    public long nativePostTaskStartTime = -1;

    @Deprecated
    public long nativeWaitContext = -1;

    @Deprecated
    public long requestStartAppResumeState = -1;

    @Deprecated
    public long requestEndAppResumeState = -1;

    @Deprecated
    public int recycleCount = -1;
    public boolean fromCache = false;
    public int httpClientType = -1;
    public int fallbackReason = -1;
    public String fallbackMessage = "";

    @Deprecated
    public String requestLog = "";
    public JSONObject extraInfo = new JSONObject();

    @Deprecated
    public boolean downloadFile = false;
    public String contentType = "";
    public String traceCode = "";
    public boolean executeTuringCallback = false;
    public boolean bdTuringRetry = false;

    @Deprecated
    public long turingCallbackDuration = -1;
    public boolean accountRetry = false;

    @Deprecated
    public long retryForAccountCallbackDuration = -1;
    public boolean rotationHostRetry = false;

    @Deprecated
    public boolean useDeprecatedApi = false;

    @Deprecated
    public final AtomicBoolean reported = new AtomicBoolean(false);

    /* loaded from: classes2.dex */
    public interface ICreate {
        BaseHttpRequestInfo create();
    }

    public void attachMetrics(RetrofitMetrics retrofitMetrics) {
        retrofitMetrics.requestInfo = new WeakReference<>(this);
        this.metrics = retrofitMetrics;
        long j = retrofitMetrics.retrofit.eventTs.ssHttpCallApiStartTime;
        this.requestStart = j;
        this.appLevelRequestStart = j;
        this.beforeAllInterceptors = retrofitMetrics.ConvertToWallClockTimeMs(retrofitMetrics.retrofit.eventTs.requestInterceptorStart);
        this.requestStartAppResumeState = retrofitMetrics.retrofit.misc.requestStartAppResumeState;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setRequestEnd(long j) {
        this.requestEnd = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelDns(long j) {
        this.dnsTime = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTCPConnect(long j) {
        this.connectTime = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTls(long j) {
        this.sslTime = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelSend(long j) {
        this.sendTime = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelPush(long j) {
        this.pushTime = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTTFB(long j) {
        this.ttfbMs = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelReceiveBody(long j) {
        this.receiveTime = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setKernelTotal(long j) {
        this.totalTime = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setRequestEndAppResumeState(long j) {
        this.requestEndAppResumeState = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setNetworkKernelRawRequestLog(String str) {
        this.requestLog = str;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setBdTuringCallbackDuration(long j) {
        this.turingCallbackDuration = j;
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void setAccountRetryCallbackDuration(long j) {
        this.retryForAccountCallbackDuration = j;
    }

    public static void setCreate(ICreate iCreate) {
        if (iCreate != null) {
            sCreate = iCreate;
        }
    }

    public static JSONObject getABTestInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        JSONArray jSONArray = new JSONArray();
        for (String str2 : split) {
            jSONArray.put(str2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_HIT, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static BaseHttpRequestInfo createHttpRequestInfo() {
        return sCreate.create();
    }

    @Deprecated
    public long getRequestDurationMs() {
        return this.metrics.retrofit.getRequestDurationMs();
    }

    @Override // com.bytedance.retrofit2.LegacyLogRecorder
    public void generateOldFormatLog(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        packageRequestParamters(jSONObject);
        addMoreBizData(jSONObject);
    }

    @Deprecated
    private void packageRequestParamters(JSONObject jSONObject) throws JSONException {
        jSONObject.put("requestStart", this.requestStart);
        jSONObject.put("responseBack", this.responseBack);
        jSONObject.put("completeReadResponse", this.completeReadResponse);
        jSONObject.put("appLevelRequestStart", this.appLevelRequestStart);
        jSONObject.put("beforeAllInterceptors", this.beforeAllInterceptors);
        jSONObject.put("requestEnd", this.requestEnd);
        jSONObject.put("recycleCount", this.recycleCount);
        jSONObject.put("timing_dns", this.dnsTime);
        jSONObject.put("timing_connect", this.connectTime);
        jSONObject.put("timing_ssl", this.sslTime);
        jSONObject.put("timing_send", this.sendTime);
        jSONObject.put("timing_waiting", this.ttfbMs);
        jSONObject.put("timing_receive", this.receiveTime);
        jSONObject.put("timing_total", this.totalTime);
        jSONObject.put("timing_isSocketReused", this.isSocketReused);
        jSONObject.put(TrafficConsts.KEY_SENT_BYTES, this.sentByteCount);
        jSONObject.put(TrafficConsts.KEY_RECEIVED_BYTES, this.receivedByteCount);
        jSONObject.put("timing_remoteIP", this.remoteIp);
        jSONObject.put("request_log", this.requestLog);
        JSONObject jSONObject2 = this.extraInfo;
        if (jSONObject2 != null) {
            jSONObject.put("req_info", jSONObject2);
        }
        jSONObject.put("download", this.downloadFile);
        jSONObject.put("addExecutorToAllInterceptors", this.beforeAllInterceptors - this.appLevelRequestStart);
        jSONObject.put("addExecutorTime", this.appLevelRequestStart);
        jSONObject.put("allInterceptorsTime", this.beforeAllInterceptors);
        jSONObject.put("fallback", this.fallbackReason);
        jSONObject.put(SlardarSettingsConsts.EXT_REQUEST_HEADER, this.requestHeaders);
        jSONObject.put(SlardarSettingsConsts.EXT_RESPONSE_HEADER, this.responseHeaders);
        if (this.hasSampled) {
            jSONObject.put("hit_rules", 1);
        }
    }

    @Deprecated
    private void addMoreBizData(JSONObject jSONObject) throws JSONException {
        jSONObject.put("use_deprecated_api", this.useDeprecatedApi);
        T t = this.reqContext;
        if (t != null) {
            if (t.protect_timeout > 0) {
                jSONObject.put("protect_timeout", this.reqContext.protect_timeout);
                jSONObject.put("connect_timeout", this.reqContext.socket_connect_timeout);
                jSONObject.put(DownloadSettingKeys.SegmentConfig.READ_TIMEOUT, this.reqContext.socket_read_timeout);
                jSONObject.put("write_timeout", this.reqContext.socket_write_timeout);
            } else {
                jSONObject.put("connect_timeout", this.reqContext.timeout_connect);
                jSONObject.put(DownloadSettingKeys.SegmentConfig.READ_TIMEOUT, this.reqContext.timeout_read);
                jSONObject.put("write_timeout", this.reqContext.timeout_write);
            }
        }
        RetrofitMetrics retrofitMetrics = this.metrics;
        if (retrofitMetrics == null) {
            return;
        }
        jSONObject.put("resp_comp", retrofitMetrics.responseCompressType);
        jSONObject.put("req_comp", this.metrics.requestCompressType);
        Long l = this.metrics.responseInterceptDuration.get("CallServerInterceptor");
        jSONObject.put("parse_time", l != null ? l.longValue() : 0L);
        jSONObject.put("priority_level", this.metrics.priorityLevel);
        jSONObject.put("req_priority_level", this.metrics.requestPriorityLevel);
        jSONObject.put("thread_priority", Thread.currentThread().getPriority());
        if (this.metrics.executeTime > 0) {
            jSONObject.put("biz_before_time", this.metrics.executeTime - this.metrics.appCreateRetrofitStartUpTime);
            jSONObject.put("queue_time", this.metrics.responseChainTime - this.metrics.executeTime);
            jSONObject.put("preprocess_time", this.metrics.executeCallStartTime - this.metrics.responseChainTime);
            jSONObject.put("realcall_time", this.metrics.executeCallEndTime - this.metrics.executeCallStartTime);
            jSONObject.put("is_async", 0);
            if (this.downloadFile) {
                if (this.metrics.executeEndTime > 0) {
                    if (this.metrics.interceptorResponseInfos.size() > 0) {
                        jSONObject.put("postprocess_time", this.metrics.executeEndTime - this.metrics.interceptorResponseInfos.get(0).start);
                    }
                    jSONObject.put("cb_time", this.metrics.executeCallEndTime - this.metrics.executeEndTime);
                } else {
                    jSONObject.put("postprocess_time", -1);
                    jSONObject.put("cb_time", -1);
                    jSONObject.put("executeCallEndTime", this.metrics.executeCallEndTime);
                    jSONObject.put("executeEndTime", this.metrics.executeEndTime);
                }
                jSONObject.put("biz_total_time", this.metrics.executeCallEndTime - this.metrics.appCreateRetrofitStartUpTime);
            } else {
                jSONObject.put("postprocess_time", this.metrics.executeEndTime - this.metrics.executeCallEndTime);
                jSONObject.put("biz_total_time", this.metrics.executeEndTime - this.metrics.appCreateRetrofitStartUpTime);
            }
        } else if (this.metrics.enqueueTime > 0) {
            jSONObject.put("biz_before_time", this.metrics.enqueueTime - this.metrics.appCreateRetrofitStartUpTime);
            jSONObject.put("queue_time", this.metrics.responseChainTime - this.metrics.enqueueTime);
            jSONObject.put("preprocess_time", this.metrics.executeCallStartTime - this.metrics.responseChainTime);
            jSONObject.put("realcall_time", this.metrics.executeCallEndTime - this.metrics.executeCallStartTime);
            jSONObject.put("is_async", 1);
            if (this.downloadFile) {
                if (this.metrics.enqueueCallbackStartTime > 0) {
                    if (this.metrics.interceptorResponseInfos.size() > 0) {
                        jSONObject.put("postprocess_time", this.metrics.enqueueCallbackStartTime - this.metrics.interceptorResponseInfos.get(0).start);
                    }
                    jSONObject.put("cb_time", this.metrics.executeCallEndTime - this.metrics.enqueueCallbackStartTime);
                } else {
                    jSONObject.put("postprocess_time", -1);
                    jSONObject.put("cb_time", -1);
                    jSONObject.put("enqueueCallbackStartTime", this.metrics.enqueueCallbackStartTime);
                    jSONObject.put("executeCallEndTime", this.metrics.executeCallEndTime);
                }
                jSONObject.put("biz_total_time", this.metrics.executeCallEndTime - this.metrics.appCreateRetrofitStartUpTime);
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                jSONObject.put("postprocess_time", this.metrics.enqueueCallbackStartTime - this.metrics.executeCallEndTime);
                jSONObject.put("cb_time", uptimeMillis - this.metrics.enqueueCallbackStartTime);
                jSONObject.put("biz_total_time", uptimeMillis - this.metrics.appCreateRetrofitStartUpTime);
            }
        }
        if (this.metrics.interceptorRequestInfos.size() > 0) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < this.metrics.interceptorRequestInfos.size(); i++) {
                RetrofitMetrics.InterceptorInfo interceptorInfo = this.metrics.interceptorRequestInfos.get(i);
                long j = interceptorInfo.end - interceptorInfo.start;
                Long l2 = (Long) hashMap.get(interceptorInfo.name);
                if (l2 == null) {
                    hashMap.put(interceptorInfo.name, Long.valueOf(j));
                } else {
                    hashMap.put(interceptorInfo.name, Long.valueOf(l2.longValue() + j));
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            for (String str : hashMap.keySet()) {
                jSONObject2.put(str, hashMap.get(str));
            }
            jSONObject.put("request_interceptors_time", jSONObject2);
            HashMap hashMap2 = new HashMap();
            for (int i2 = 0; i2 < this.metrics.interceptorResponseInfos.size(); i2++) {
                RetrofitMetrics.InterceptorInfo interceptorInfo2 = this.metrics.interceptorResponseInfos.get(i2);
                long j2 = interceptorInfo2.end - interceptorInfo2.start;
                Long l3 = (Long) hashMap2.get(interceptorInfo2.name);
                if (l3 == null) {
                    hashMap2.put(interceptorInfo2.name, Long.valueOf(j2));
                } else {
                    hashMap2.put(interceptorInfo2.name, Long.valueOf(l3.longValue() + j2));
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            for (String str2 : hashMap2.keySet()) {
                jSONObject3.put(str2, hashMap2.get(str2));
            }
            jSONObject.put("response_interceptors_time", jSONObject3);
        }
    }
}
