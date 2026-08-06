package com.lynx.tasm.p001ui.image.helper;

import android.text.TextUtils;
import com.lynx.devtoolwrapper.MemoryListener;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxMemoryMonitorService;
import com.lynx.tasm.service.ILynxMonitorService;
import com.lynx.tasm.service.LynxImageInfo;
import com.lynx.tasm.service.LynxMemoryInfo;
import com.lynx.tasm.service.LynxServiceCenter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FrescoEventHelper {
    public static void monitorReporterV2(final LynxContext lynxContext, int i, final String str, final boolean z, boolean z2, final long j, long j2, final int i2, final JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && j > 0 && j2 > 0) {
            final long j3 = j2 - j;
            final long currentTimeMillis = System.currentTimeMillis();
            final long j4 = currentTimeMillis - j;
            LynxEventReporter.runOnReportThread(new Runnable() { // from class: com.lynx.tasm.ui.image.helper.FrescoEventHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    ILynxMemoryMonitorService iLynxMemoryMonitorService;
                    LynxContext lynxContext2 = LynxContext.this;
                    if (lynxContext2 == null || lynxContext2.getLynxView() == null || (iLynxMemoryMonitorService = (ILynxMemoryMonitorService) LynxServiceCenter.inst().getService(ILynxMemoryMonitorService.class)) == null) {
                        return;
                    }
                    LynxMemoryInfo.Builder isSuccess = new LynxMemoryInfo.Builder().type(LynxMemoryInfo.TYPE_IMAGE).resourceURL(str).memoryCost(i2).finishTimeStamp(currentTimeMillis).fetchDuration(j3).completeDuration(j4).startTimeStamp(j).isSuccess(z ? 1 : 0);
                    LynxContext lynxContext3 = LynxContext.this;
                    if (lynxContext3 != null && lynxContext3.getLynxView() != null) {
                        isSuccess.sessionId(LynxContext.this.getLynxSessionID());
                        isSuccess.phase(LynxContext.this.getLynxView().getRenderPhase());
                        isSuccess.templateURL(LynxContext.this.getTemplateUrl());
                    }
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        long optLong = jSONObject2.optLong("viewWidth");
                        long optLong2 = jSONObject.optLong("viewHeight");
                        long optLong3 = jSONObject.optLong("width");
                        isSuccess.viewHeight(optLong2).viewWidth(optLong).width(optLong3).height(jSONObject.optLong("height")).config(jSONObject.optString("config")).isFlattenAnim(jSONObject.optInt("isFlattenAnim"));
                    }
                    iLynxMemoryMonitorService.reportMemoryUsage(isSuccess.build());
                }
            });
        }
    }

    public static void monitorReporter(final LynxContext lynxContext, final String str, final boolean z, final boolean z2, final long j, long j2, final int i, final JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && j > 0 && j2 > 0) {
            final long j3 = j2 - j;
            final long currentTimeMillis = System.currentTimeMillis();
            final long j4 = currentTimeMillis - j;
            LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.ui.image.helper.FrescoEventHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject reportData = FrescoEventHelper.getReportData(LynxContext.this, str, z, z2, j, j3, j4, currentTimeMillis, i, jSONObject);
                    if (reportData != null) {
                        MemoryListener.getInstance().uploadImageInfo(reportData);
                        ILynxMonitorService iLynxMonitorService = (ILynxMonitorService) LynxServiceCenter.inst().getService(ILynxMonitorService.class);
                        if (iLynxMonitorService != null) {
                            iLynxMonitorService.reportImageStatus("lynx_image_status", reportData);
                        }
                    }
                }
            });
        }
    }

    public static JSONObject getReportData(LynxContext lynxContext, String str, boolean z, boolean z2, long j, long j2, long j3, long j4, int i, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("fetchTime", j2 / 1000.0d);
            jSONObject3.put("completeTime", j3 / 1000.0d);
            jSONObject3.put("fetchTimeStamp", j);
            jSONObject3.put("finishTimeStamp", j4);
            jSONObject2.put("timeMetrics", jSONObject3);
            if (lynxContext != null && lynxContext.getLynxView() != null) {
                String templateUrl = lynxContext.getLynxView().getTemplateUrl();
                if (TextUtils.isEmpty(templateUrl)) {
                    templateUrl = "";
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", templateUrl);
                if (jSONObject != null) {
                    long optLong = jSONObject.optLong("viewWidth");
                    long optLong2 = jSONObject.optLong("viewHeight");
                    long optLong3 = jSONObject.optLong("width");
                    long optLong4 = jSONObject.optLong("height");
                    int optInt = jSONObject.optInt("isFlattenAnim");
                    String optString = jSONObject.optString("config");
                    if (optLong <= 0) {
                        optLong = -1;
                    }
                    jSONObject4.put("viewWidth", optLong);
                    if (optLong2 <= 0) {
                        optLong2 = -1;
                    }
                    jSONObject4.put("viewHeight", optLong2);
                    if (optLong3 <= 0) {
                        optLong3 = -1;
                    }
                    jSONObject4.put("width", optLong3);
                    jSONObject4.put("height", optLong4 > 0 ? optLong4 : -1L);
                    jSONObject4.put("flattenAnim", optInt);
                    jSONObject4.put("config", optString);
                }
                jSONObject2.put("metric", jSONObject4);
            }
            jSONObject2.put("image_url", str);
            int i2 = 1;
            jSONObject2.put("successRate", z ? 1 : 0);
            jSONObject2.put("memoryCost", i);
            if (!z2) {
                i2 = 0;
            }
            jSONObject2.put("resourceFromMemoryCache", i2);
            return jSONObject2;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void reportImageInfo(final LynxContext lynxContext, final String str, final boolean z, final boolean z2, final long j, final long j2, final int i, final int i2) {
        LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.ui.image.helper.FrescoEventHelper.3
            @Override // java.lang.Runnable
            public void run() {
                ILynxMonitorService iLynxMonitorService;
                LynxContext lynxContext2 = LynxContext.this;
                LynxView lynxView = lynxContext2 != null ? lynxContext2.getLynxView() : null;
                if (lynxView == null || (iLynxMonitorService = (ILynxMonitorService) LynxServiceCenter.inst().getService(ILynxMonitorService.class)) == null) {
                    return;
                }
                iLynxMonitorService.reportImageInfo(new LynxImageInfo.Builder().startTimeStamp(j).finishTimeStamp(j2).isSuccess(z).url(str).memoryCost(i).errorCode(i2).lynxView(lynxView).hitMemoryCache(z2).build());
            }
        });
    }

    public static void reportImageEvent(LynxContext lynxContext, String str, int i, boolean z, int i2, long j, long j2, boolean z2, int i3, int i4, Map<String, String> map) {
        if (lynxContext == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("load_start", Long.valueOf(j));
            hashMap.put("load_finish", Long.valueOf(j2));
            hashMap.put("cost", Long.valueOf(j2 - j));
            hashMap.put(PropsConstants.SRC, str);
            hashMap.put("memory", Boolean.valueOf(z));
            hashMap.put("origin", Integer.valueOf(i2));
            hashMap.put("error_code", Integer.valueOf(i));
            hashMap.put(PropsConstants.FLATTEN, Boolean.valueOf(z2));
            hashMap.put("width", Integer.valueOf(i3));
            hashMap.put("height", Integer.valueOf(i4));
            if (map != null) {
                hashMap.putAll(map);
            }
            LynxEventReporter.onEvent("lynxsdk_image_event", hashMap, lynxContext.getInstanceId());
        } catch (Exception e) {
            LLog.e("FrescoEventHelper", "reportImageEvent got exception:" + e);
        }
    }
}
