package com.bytedance.apm6.foundation.trace;

import android.os.Process;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.trace.TraceBean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LocalTraceRecorder {
    private static final String LOG_TAG = "LogGenTrace";
    private static final int pid = Process.myPid();

    public static void traceCounter(String str, int i) {
        traceCounter(str, i, System.currentTimeMillis());
    }

    public static void traceCounter(String str, int i, long j) {
        traceCounter(ApmContext.getCurrentProcessName(), pid, str, i, j);
    }

    public static void traceCounter(String str, long j, String str2, int i, long j2) {
        ApmAlogHelper.i(LOG_TAG, new TraceBean().setProcessName(str).setProcessId(j).setTraceName(str2).setTimeStamp(j2).setCounterValue(i).setTraceType(TraceBean.TraceType.COUNTER).toJsonString());
    }

    public static void traceFloatCounter(String str, float f) {
        traceFloatCounter(str, f, System.currentTimeMillis());
    }

    public static void traceFloatCounter(String str, float f, long j) {
        traceFloatCounter(ApmContext.getCurrentProcessName(), pid, str, f, j);
    }

    public static void traceFloatCounter(String str, long j, String str2, float f, long j2) {
        ApmAlogHelper.i(LOG_TAG, new TraceBean().setProcessName(str).setProcessId(j).setTraceName(str2).setTimeStamp(j2).setFloatCounterValue(f).setTraceType(TraceBean.TraceType.FLOAT_COUNTER).toJsonString());
    }

    public static void traceEvent(String str, String str2, JSONObject jSONObject) {
        traceEvent(str, str2, System.currentTimeMillis(), jSONObject);
    }

    public static void traceEvent(String str, String str2, long j, JSONObject jSONObject) {
        traceEvent(ApmContext.getCurrentProcessName(), pid, str, str2, j, jSONObject);
    }

    public static void traceEvent(String str, long j, String str2, String str3, long j2, JSONObject jSONObject) {
        ApmAlogHelper.i(LOG_TAG, new TraceBean().setProcessName(str).setProcessId(j).setTraceName(str2).setTimeStamp(j2).setName(str3).setTraceType(TraceBean.TraceType.SLICE_INSTANT).setDebugAnnotation(jSONObject).toJsonString());
    }

    public static void traceBegin(String str, String str2, JSONObject jSONObject) {
        traceBegin(str, str2, System.currentTimeMillis(), jSONObject);
    }

    public static void traceBegin(String str, String str2, long j, JSONObject jSONObject) {
        traceBegin(ApmContext.getCurrentProcessName(), pid, str, str2, j, jSONObject);
    }

    public static void traceBegin(String str, long j, String str2, String str3, long j2, JSONObject jSONObject) {
        ApmAlogHelper.i(LOG_TAG, new TraceBean().setProcessName(str).setProcessId(j).setTraceName(str2).setTimeStamp(j2).setName(str3).setTraceType(TraceBean.TraceType.SLICE_BEGIN).setDebugAnnotation(jSONObject).toJsonString());
    }

    public static void traceEnd(String str, JSONObject jSONObject) {
        traceEnd(str, System.currentTimeMillis(), jSONObject);
    }

    public static void traceEnd(String str, long j, JSONObject jSONObject) {
        traceEnd(ApmContext.getCurrentProcessName(), pid, str, j, jSONObject);
    }

    public static void traceEnd(String str, long j, String str2, long j2, JSONObject jSONObject) {
        ApmAlogHelper.i(LOG_TAG, new TraceBean().setProcessName(str).setProcessId(j).setTraceName(str2).setTimeStamp(j2).setTraceType(TraceBean.TraceType.SLICE_END).setDebugAnnotation(jSONObject).toJsonString());
    }

    public static void asyncTraceBegin(String str, String str2, int i, JSONObject jSONObject) {
        asyncTraceBegin(str, str2, System.currentTimeMillis(), i, jSONObject);
    }

    public static void asyncTraceBegin(String str, String str2, long j, int i, JSONObject jSONObject) {
        asyncTraceBegin(ApmContext.getCurrentProcessName(), pid, str, str2, j, i, jSONObject);
    }

    public static void asyncTraceBegin(String str, long j, String str2, String str3, long j2, int i, JSONObject jSONObject) {
        ApmAlogHelper.i(LOG_TAG, new TraceBean().setProcessName(str).setProcessId(j).setTraceName(str2).setTimeStamp(j2).setName(str3).setAsyncTag(i).setTraceType(TraceBean.TraceType.ASYNC_SLICE_BEGIN).setDebugAnnotation(jSONObject).toJsonString());
    }

    public static void asyncTraceEnd(String str, int i, JSONObject jSONObject) {
        asyncTraceEnd(str, i, System.currentTimeMillis(), jSONObject);
    }

    public static void asyncTraceEnd(String str, int i, long j, JSONObject jSONObject) {
        asyncTraceEnd(ApmContext.getCurrentProcessName(), pid, str, i, j, jSONObject);
    }

    public static void asyncTraceEnd(String str, long j, String str2, int i, long j2, JSONObject jSONObject) {
        ApmAlogHelper.i(LOG_TAG, new TraceBean().setProcessName(str).setProcessId(j).setTraceName(str2).setAsyncTag(i).setTimeStamp(j2).setTraceType(TraceBean.TraceType.ASYNC_SLICE_END).setDebugAnnotation(jSONObject).toJsonString());
    }
}
