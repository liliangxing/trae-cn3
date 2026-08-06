package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.instrumentation.transaction.TransactionData;
import com.bytedance.apm.agent.instrumentation.transaction.TxState;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorRecorder {
    private static final String TAG = "MonitorRecorder";

    public static void reportExceptionMonitor(TxState txState, Exception exc) {
    }

    public static void recordRequest(Request request, TxState txState) {
        if (request == null || txState == null) {
            return;
        }
        txState.addAssistData("NetworkLib", "OkHttp3");
        txState.setUrl(request.url().toString());
        txState.setMethod(request.method());
        txState.setStartTime(System.currentTimeMillis());
        txState.setCarrier("");
        txState.setWanType("");
        FormBody body = request.body();
        if (body != null) {
            if (body instanceof FormBody) {
                txState.setBytesSent(body.contentLength());
            } else if (body instanceof MultipartBody) {
                try {
                    txState.setBytesSent(body.contentLength());
                } catch (IOException e) {
                    Log.d("TransactionData:", "can not get MultipartBody content length", e);
                }
            }
        }
    }

    public static void recordResponse(Response response, TxState txState) {
        if (response == null || txState == null) {
            return;
        }
        txState.setStatusCode(response.code());
        if (response.body() != null) {
            txState.setBytesReceived(response.body().contentLength());
        }
    }

    public static void reportMonitorData(TxState txState, Response response) {
        if (txState == null || response == null) {
            return;
        }
        reportMonitorData(txState, "okhttp");
    }

    public static void reportMonitorData(TxState txState, String str) {
        if (txState == null) {
            return;
        }
        TransactionData end = txState.end();
        if (ApmContext.isDebugMode()) {
            Logger.m88i(DebugLogger.TAG_NET, "auto plugin, reportMonitorData: " + end.toString());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ApmTrafficStats.TTNET_SENT_BYTES, end.getBytesSent());
            jSONObject2.put(ApmTrafficStats.TTNET_RECEIVED_BYTES, end.getBytesReceived());
            jSONObject.put(ApmTrafficStats.TTNET_RESPONSE, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(ApmTrafficStats.TTNET_REQUEST_LOG, jSONObject);
            jSONObject3.put(TrafficConsts.KEY_NET_CONSUME_TYPE, str);
            MonitorTool.monitorSLA(end.getTotalTime(), txState.getStartTime() == 0 ? end.getRequestStart() : txState.getStartTime(), end.getUrl(), "", "", end.getStatusCode(), jSONObject3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
