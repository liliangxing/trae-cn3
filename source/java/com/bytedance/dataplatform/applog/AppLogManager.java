package com.bytedance.dataplatform.applog;

import com.bytedance.dataplatform.Worker;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AppLogManager {
    private static IAppLogService sAppLogService;
    private static Set<String> sExposedVids = new HashSet();
    private static boolean sExposureEventEnabled;
    private static boolean sLocalStrategyEventEnabled;

    public static void setAppLogService(final IAppLogService appLogService, boolean exposureEventEnabled, boolean localStrategyEventEnabled) {
        sAppLogService = appLogService;
        sLocalStrategyEventEnabled = localStrategyEventEnabled;
        sExposureEventEnabled = exposureEventEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendEventInternal(final String event, final JSONObject params) {
        IAppLogService iAppLogService = sAppLogService;
        if (iAppLogService != null) {
            iAppLogService.onEventV3(event, params);
        }
    }

    public static void onEventV3(final String event, final JSONObject params) {
        Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.applog.AppLogManager.1
            @Override // java.lang.Runnable
            public void run() {
                AppLogManager.sendEventInternal(event, params);
            }
        });
    }

    public static void sendExposureEvent(final String triggerVid, final String exposureInfo) {
        if (sExposureEventEnabled) {
            Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.applog.AppLogManager.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AppLogManager.sExposedVids.contains(triggerVid)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("params_for_special", "abtest_ab_sdk");
                        jSONObject.put("ab_sdk_version", exposureInfo);
                        jSONObject.put("trigger_vid", triggerVid);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    AppLogManager.sendEventInternal("abtest_ab_sdk_vid_exposure", jSONObject);
                    AppLogManager.sExposedVids.add(triggerVid);
                }
            });
        }
    }

    public static void sendLocalStrategyEvent(final String layer, final Integer index) {
        if (sLocalStrategyEventEnabled) {
            Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.applog.AppLogManager.3
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("params_for_special", "abtest_ab_sdk");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(layer, index);
                        jSONObject.put("client_layer_info", jSONObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    AppLogManager.onEventV3("local_strategy", jSONObject);
                }
            });
        }
    }
}
