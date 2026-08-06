package com.bytedance.trae.network.ttnet;

import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.utils.TtnetUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TTNetExt.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J6\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$MonitorProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "<init>", "()V", "TAG", "", "needTrace", "", "url", "monitorApiError", "", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "sendTime", "traceCode", "info", "e", "", "monitorApiOk", "packageRequestParamters", "jsonObject", "Lorg/json/JSONObject;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MonitorProcessHook implements NetworkParams.MonitorProcessHook<HttpRequestInfo> {
    public static final MonitorProcessHook INSTANCE = new MonitorProcessHook();
    public static final String TAG = "MonitorProcessHook";

    private MonitorProcessHook() {
    }

    private final boolean needTrace(String url) {
        return !StringsKt.startsWith$default(url, "https://log.snssdk.com", false, 2, (Object) null);
    }

    public void monitorApiError(long duration, long sendTime, String url, String traceCode, HttpRequestInfo info, Throwable e) {
        try {
            String[] strArr = new String[1];
            int ConvertIOExceptionToStatus = ConvertIOException.ConvertIOExceptionToStatus(e, strArr);
            JSONObject jSONObject = new JSONObject();
            if (e != null && !StringUtils.isEmpty(e.getClass().getName())) {
                jSONObject.put("ex_name", e.getClass().getName());
                if ((ConvertIOExceptionToStatus == 1 && ApmDelegate.getInstance().getLogTypeSwitch("ex_message_open")) || ApmDelegate.getInstance().getLogTypeSwitch("debug_ex_message_open")) {
                    String outputThrowableStackTrace = TtnetUtil.outputThrowableStackTrace(e);
                    if (!StringUtils.isEmpty(outputThrowableStackTrace)) {
                        jSONObject.put("ex_message", outputThrowableStackTrace);
                    }
                    String cronetExceptionMessage = HttpClient.getCronetExceptionMessage();
                    if (!StringUtils.isEmpty(cronetExceptionMessage)) {
                        jSONObject.put("cronet_init_ex_message", cronetExceptionMessage);
                    }
                }
            }
            if (StringUtils.isEmpty(strArr[0])) {
                Intrinsics.checkNotNull(info);
                strArr[0] = info.remoteIp;
            }
            packageRequestParamters(info, jSONObject);
            ApmAgent.monitorApiError(duration, sendTime, url, strArr[0], traceCode, ConvertIOExceptionToStatus, jSONObject);
            ApmAgent.monitorSLA(duration, sendTime, url, strArr[0], traceCode, ConvertIOExceptionToStatus, jSONObject);
            if (url != null) {
                needTrace(url);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:
    
        if (r0 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008d, code lost:
    
        if (r0.hasNext() == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008f, code lost:
    
        r4 = r0.next();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r4);
        r5 = r4.toLowerCase();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "toLowerCase(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5, "x-tt-logid") == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ab, code lost:
    
        r1.optString(r4, "Unknown");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void monitorApiOk(long duration, long sendTime, String url, String traceCode, HttpRequestInfo info) {
        int i;
        String str;
        String str2;
        Object obj;
        if (info == null || (str2 = info.requestLog) == null) {
            i = 200;
        } else {
            try {
                Result.Companion companion = Result.Companion;
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject("response");
                obj = Result.constructor-impl(Integer.valueOf(optJSONObject != null ? optJSONObject.optInt("code", 200) : 200));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = 200;
            }
            i = ((Number) obj).intValue();
        }
        if (!(200 <= i && i < 300)) {
            monitorApiError(duration, sendTime, url, traceCode, info, (Throwable) null);
            return;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            MonitorProcessHook monitorProcessHook = this;
            if (url == null || needTrace(url)) {
                JSONObject jSONObject = (info == null || (str = info.responseHeaders) == null) ? null : new JSONObject(str);
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                }
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th2));
        }
        try {
            String[] strArr = new String[1];
            JSONObject jSONObject2 = new JSONObject();
            if (StringUtils.isEmpty(strArr[0])) {
                Intrinsics.checkNotNull(info);
                strArr[0] = info.remoteIp;
            }
            packageRequestParamters(info, jSONObject2);
            ApmAgent.monitorSLA(duration, sendTime, url, strArr[0], traceCode, 200, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    private final void packageRequestParamters(HttpRequestInfo info, JSONObject jsonObject) {
        if (info != null && jsonObject != null) {
            try {
                jsonObject.put("cronet_plugin_install", TTNetInit.getTTNetDepend().isCronetPluginInstalled());
                NetInfo userEsimNetworkInfo = TTNetExt.INSTANCE.getUserEsimNetworkInfo();
                jsonObject.put("networkType", userEsimNetworkInfo != null ? userEsimNetworkInfo.getNetworkType() : null);
                NetInfo userEsimNetworkInfo2 = TTNetExt.INSTANCE.getUserEsimNetworkInfo();
                jsonObject.put("isRoaming", userEsimNetworkInfo2 != null ? userEsimNetworkInfo2.isRoaming() : null);
                NetInfo userEsimNetworkInfo3 = TTNetExt.INSTANCE.getUserEsimNetworkInfo();
                jsonObject.put("simCountry", userEsimNetworkInfo3 != null ? userEsimNetworkInfo3.getSimCountry() : null);
                NetInfo userEsimNetworkInfo4 = TTNetExt.INSTANCE.getUserEsimNetworkInfo();
                jsonObject.put("netCountry", userEsimNetworkInfo4 != null ? userEsimNetworkInfo4.getNetCountry() : null);
                NetInfo userEsimNetworkInfo5 = TTNetExt.INSTANCE.getUserEsimNetworkInfo();
                jsonObject.put("simOperatorName", userEsimNetworkInfo5 != null ? userEsimNetworkInfo5.getSimOperatorName() : null);
                NetInfo userEsimNetworkInfo6 = TTNetExt.INSTANCE.getUserEsimNetworkInfo();
                jsonObject.put("netOperatorName", userEsimNetworkInfo6 != null ? userEsimNetworkInfo6.getNetOperatorName() : null);
                NetInfo userEsimNetworkInfo7 = TTNetExt.INSTANCE.getUserEsimNetworkInfo();
                jsonObject.put("airplaneMode", userEsimNetworkInfo7 != null ? userEsimNetworkInfo7.getAirplaneMode() : null);
                jsonObject.put("appLevelRequestStart", info.appLevelRequestStart);
                jsonObject.put("beforeAllInterceptors", info.beforeAllInterceptors);
                jsonObject.put("requestStart", info.requestStart);
                jsonObject.put("responseBack", info.responseBack);
                jsonObject.put("completeReadResponse", info.completeReadResponse);
                jsonObject.put("requestEnd", info.requestEnd);
                jsonObject.put("recycleCount", info.recycleCount);
                if (info.httpClientType == 0) {
                    jsonObject.put("timing_dns", info.dnsTime);
                    jsonObject.put("timing_connect", info.connectTime);
                    jsonObject.put("timing_ssl", info.sslTime);
                    jsonObject.put("timing_send", info.sendTime);
                    jsonObject.put("timing_waiting", info.ttfbMs);
                    jsonObject.put("timing_receive", info.receiveTime);
                    jsonObject.put("timing_total", info.totalTime);
                    jsonObject.put("timing_isSocketReused", info.isSocketReused);
                    jsonObject.put("timing_totalSendBytes", info.sentByteCount);
                    jsonObject.put("timing_totalReceivedBytes", info.receivedByteCount);
                    jsonObject.put("timing_remoteIP", info.remoteIp);
                    jsonObject.put("request_log", info.requestLog);
                }
                if (info.extraInfo != null) {
                    jsonObject.put("req_info", info.extraInfo);
                }
                jsonObject.put("streaming", info.downloadFile);
            } catch (JSONException unused) {
            }
        }
    }
}
