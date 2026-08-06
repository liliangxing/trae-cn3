package com.bytedance.lynx.scc.cloudservice.worker;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.lynx.scc.cloudservice.SccCloudServiceManager;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.lynx.scc.cloudservice.network.UrlRequest;
import com.bytedance.lynx.scc.cloudservice.network.UrlResponse;
import com.bytedance.lynx.scc.cloudservice.utils.Logger;
import com.bytedance.lynx.scc.cloudservice.utils.SccUtils;
import com.bytedance.perf.monitor.ReportConst;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CloudCheckWorker implements Callable<SccResult> {
    private final SccCloudServiceImpl mService;
    private final String seclinkScene;
    private int ttnetTimeoutMs = 5000;
    private final String url;

    public CloudCheckWorker(String url, String seclinkScene, SccCloudServiceImpl service) {
        this.url = url;
        this.seclinkScene = seclinkScene;
        this.mService = service;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public SccResult call() throws Exception {
        Logger.m93d("already send cloud service request, will wait for response");
        return sendCsRequest(this.url);
    }

    private SccResult sendCsRequest(String url) {
        String str;
        UrlRequest urlRequest = new UrlRequest(SccCloudServiceManager.getSccConfig().getServiceUrl());
        urlRequest.setMethod("POST");
        urlRequest.setParamMap(new HashMap());
        urlRequest.getParamMap().put(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json");
        urlRequest.setBody(toBody(url, this.seclinkScene));
        urlRequest.setTimeoutMs(this.ttnetTimeoutMs);
        long uptimeMillis = SystemClock.uptimeMillis();
        UrlResponse sendSync = SccCloudServiceManager.getNetAdapter().sendSync(urlRequest, true);
        SccResult fromUrlResponse = SccResult.fromUrlResponse(sendSync);
        onCSEnd(url, sendSync, fromUrlResponse);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (fromUrlResponse == null || fromUrlResponse.getCode() == -1) {
            Logger.m94e("cloud service response is error:" + sendSync);
            str = "";
        } else {
            str = fromUrlResponse.getClientLogId();
            if (fromUrlResponse.isAllow()) {
                CacheManager.getInstance().addAllowUrl(url);
            }
        }
        reportSccData(uptimeMillis2, str, SccUtils.getHeaderValue(sendSync, SccUtils.HEADER_TRACE_ID, SccUtils.HEADER_TRACE_ID_LOWER_CASE));
        return fromUrlResponse;
    }

    private void onCSEnd(String url, UrlResponse response, SccResult result) {
        EventTracker eventTracker = this.mService.getEventTracker(url);
        if (eventTracker != null) {
            if (result == null) {
                eventTracker.onCSEnd(response.getStatusCode(), -1, "error", null, null);
            } else {
                eventTracker.onCSEnd(response.getStatusCode(), result.getCode(), result.getLabel(), result.getClientLogId(), result.getOriginJsonResponse());
            }
        }
    }

    private void reportSccData(long time, String logid, String traceid) {
        HashMap hashMap = new HashMap();
        hashMap.put(SccUtils.REPORT_PASSED_TIME, time + "");
        if (logid == null) {
            logid = "";
        }
        hashMap.put("scc_logid", logid);
        if (traceid == null) {
            traceid = "";
        }
        hashMap.put(SccUtils.REPORT_TRACE_ID, traceid);
        SccCloudServiceManager.onDataReport(SccUtils.REPORT_EVENT_NAME, hashMap);
    }

    public static String toBody(String url, String scene) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("url", url);
            jSONObject.put("sign", "");
            if (TextUtils.isEmpty(scene)) {
                scene = "common";
            }
            jSONObject.put(ReportConst.KEY_SCENE, scene);
        } catch (Exception unused) {
            Logger.m94e("CSRequestParams fail!");
        }
        return jSONObject.toString();
    }
}
