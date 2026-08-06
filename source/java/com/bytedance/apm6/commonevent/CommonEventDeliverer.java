package com.bytedance.apm6.commonevent;

import android.text.TextUtils;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm6.commonevent.config.CommonEventConfig;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.commonevent.model.CommonEvent;
import com.bytedance.apm6.commonevent.model.CommonLog;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.apm6.commonevent.model.TracingData;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CommonEventDeliverer {
    public static boolean FAST_MODE = false;
    private static final int MAX_SIZE = 1000;
    private static volatile boolean inited;
    private static boolean isEnableException;
    private static LimitedQueue<Monitorable> limitedQueue;
    private static volatile CommonEventConfig sCommonEventConfig;

    static {
        LimitedQueue<Monitorable> limitedQueue2 = new LimitedQueue<>(1000);
        limitedQueue = limitedQueue2;
        isEnableException = true;
        limitedQueue2.setEvictListener(new LimitedQueue.EvictListener<Monitorable>() { // from class: com.bytedance.apm6.commonevent.CommonEventDeliverer.1
            @Override // com.bytedance.apm6.util.cache.LimitedQueue.EvictListener
            public void onEvict(Monitorable monitorable) {
                if (CommonEventDeliverer.isEnableException) {
                    Logger.m120e(Constants.TAG, "evicted Monitorable " + monitorable);
                }
            }
        });
    }

    public static synchronized void setReportFullException(boolean z) {
        synchronized (CommonEventDeliverer.class) {
            isEnableException = z;
        }
    }

    private static synchronized void initConfig() {
        CommonEventConfigService commonEventConfigService;
        synchronized (CommonEventDeliverer.class) {
            if (!inited && (commonEventConfigService = (CommonEventConfigService) ServiceManager.getService(CommonEventConfigService.class)) != null) {
                updateConfig(commonEventConfigService.getConfig());
                inited = true;
            }
        }
    }

    public static void monitorEvent(CommonEvent commonEvent) {
        if (commonEvent == null) {
            return;
        }
        if (sCommonEventConfig == null) {
            limitedQueue.push(commonEvent);
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, "cached CommonEvent:" + commonEvent);
            }
            initConfig();
            return;
        }
        if (sCommonEventConfig.isSampledService(commonEvent.getServiceName())) {
            commonEvent.deepCopyJson();
            Monitor.record(commonEvent);
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, "Sampled CommonEvent:" + commonEvent);
                return;
            }
            return;
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "UnSampled CommonEvent:" + commonEvent);
        }
        if (ApmContext.isDebugMode()) {
            commonEvent.deepCopyJson();
            DoctorDataUtil.onReceivedEvent(commonEvent.getLogType(), commonEvent.toJsonObject(), false);
        }
    }

    public static void monitorCommonLog(CommonLog commonLog) {
        if (commonLog == null) {
            return;
        }
        if (sCommonEventConfig == null) {
            limitedQueue.push(commonLog);
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, "Cached CommonLog: " + commonLog);
            }
            initConfig();
            return;
        }
        if (sCommonEventConfig.isSampledLogType(commonLog.getLogType())) {
            commonLog.deepCopyJson();
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, "Sampled CommonLog:" + commonLog);
            }
            Monitor.record(commonLog);
            return;
        }
        if (ApmContext.isDebugMode()) {
            commonLog.deepCopyJson();
            DoctorDataUtil.onReceivedEvent(commonLog.getLogType(), commonLog.toJsonObject(), false);
            Logger.m119d(Constants.TAG, "UnSampled CommonLog:" + commonLog);
        }
    }

    public static boolean needSkip(String str, Boolean bool) {
        if (!FAST_MODE || sCommonEventConfig == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (bool.booleanValue()) {
            if (sCommonEventConfig.isSampledService(str)) {
                return false;
            }
        } else if (sCommonEventConfig.isSampledLogType(str)) {
            return false;
        }
        return true;
    }

    public static void monitorLegacyEvent(GeneralLegacyEvent generalLegacyEvent) {
        if (generalLegacyEvent == null) {
            return;
        }
        Monitor.record(generalLegacyEvent);
    }

    public static void monitorTrace(TracingData tracingData) {
        if (tracingData == null) {
            return;
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "trace_data:" + tracingData.toJsonObject());
        }
        Monitor.record(tracingData);
    }

    public static synchronized void updateConfig(CommonEventConfig commonEventConfig) {
        synchronized (CommonEventDeliverer.class) {
            if (commonEventConfig != null) {
                if (sCommonEventConfig != commonEventConfig) {
                    if (ApmContext.isDebugMode()) {
                        Logger.m119d(Constants.TAG, "updateConfig " + commonEventConfig);
                    }
                    sCommonEventConfig = commonEventConfig;
                    while (!limitedQueue.isEmpty()) {
                        Monitorable pop = limitedQueue.pop();
                        if (pop instanceof CommonEvent) {
                            monitorEvent((CommonEvent) pop);
                        } else if (pop instanceof CommonLog) {
                            monitorCommonLog((CommonLog) pop);
                        }
                    }
                }
            }
        }
    }

    public static void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        monitorStatusAndEvent(str, 0, jSONObject, jSONObject2, jSONObject3);
    }

    public static void monitorEvent(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        monitorEvent(new CommonEvent(str, i, jSONObject, jSONObject2, jSONObject3, jSONObject4));
    }

    public static void monitorStatusAndEvent(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        monitorEvent(str, i, null, jSONObject, jSONObject2, jSONObject3);
    }

    public static void monitorDuration(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        monitorEvent(new CommonEvent(str, 0, jSONObject, null, null, jSONObject2));
    }

    public static void monitorStatusRate(String str, int i, JSONObject jSONObject) {
        monitorStatusAndEvent(str, i, null, null, jSONObject);
    }

    public static void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        monitorEvent(new CommonEvent(str, i, jSONObject, null, null, jSONObject2));
    }

    public static void monitorCommonLog(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, "logType must be not empty");
                return;
            }
            return;
        }
        monitorCommonLog(new CommonLog(str, jSONObject));
    }
}
