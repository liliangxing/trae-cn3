package com.bytedance.apm;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.apm.alog.IALogActiveUploadCallback;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.BatteryEnergyCollector;
import com.bytedance.apm.battery.BatteryTemperatureCollector;
import com.bytedance.apm.battery.ProcessEnergyCollector;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.config.ApmReportConfig;
import com.bytedance.apm.config.EventConfig;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.ExceptionTypeName;
import com.bytedance.apm.constant.ReportUrl;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.data.type.ApiData;
import com.bytedance.apm.data.type.CommonLogData;
import com.bytedance.apm.data.type.EventData;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.data.type.MetricsData;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.data.type.UIActionData;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.perf.PerfCollectUtils;
import com.bytedance.apm.perf.PerfDataCenter;
import com.bytedance.apm.perf.PerfFilterManager;
import com.bytedance.apm.perf.TemperatureDataManager;
import com.bytedance.apm.perf.ThreadCollector;
import com.bytedance.apm.perf.entity.MemoryInfo;
import com.bytedance.apm.perf.traffic.BizTrafficStats;
import com.bytedance.apm.perf.traffic.TrafficCollector;
import com.bytedance.apm.report.FileUploadServiceImpl;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.thread.LogBypassStoreEventManager;
import com.bytedance.apm.ttnet.TTNetUtils;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.TimeUtils;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.crash.dumper.ProcInfo;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.ActivityUtils;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.services.apm.api.IFileUploadCallback;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.ss.thor.ThorUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApmAgent {
    private static final long CHECK_DISK_INTERVAL_MS = 3600000;
    private static final long CHILD_PROC_MAP_FILE_SIZE = 262144;
    public static boolean FAST_MODE = false;
    private static final String KEY_DEBUG_UUID = "_debug_uuid";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final long MAIN_PROC_MAP_FILE_SIZE = 2097152;
    private static final long MAX_LOGS_SIZE = 1073741824;
    public static final String MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE = "nothing to do, implementation code has been removed in version 5+";
    private static final long REMAINING_ROM_THRESHOLD = 1073741824;
    public static final String TAG_DEPRECATED = "Deprecated";
    private static final int WEED_OUT_FILE_NUM = 60;
    static AtomicLong atomicLong = new AtomicLong(0);
    public static boolean sDeepCopy = false;
    private static long sLastCheckDiskTime = -1;
    private static MappedByteBuffer sMappedByteBuffer;
    private static File sProcessLogsFolder;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IBatteryDataListener {
        void onData(float f, float f2, String str);
    }

    @Deprecated
    public static void addBlockFilter(Map<String, String> map) {
    }

    @Deprecated
    public static void addFpsFilter(Map<String, String> map) {
    }

    @Deprecated
    public static void monitorImageSample(String str, int i, String str2, long j, JSONObject jSONObject) {
    }

    public static void reportLegacyMonitorLog(Context context, long j, long j2, boolean z) {
    }

    public static void monitorSLA(final long j, final long j2, final String str, final String str2, final String str3, final int i, JSONObject jSONObject) {
        final JSONObject optShallowCopyJson = optShallowCopyJson(jSONObject);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.1
            @Override // java.lang.Runnable
            public void run() {
                NetDataPipeline.getInstance().handle(new ApiData("api_all", j, j2, str, str2, str3, i, ApmAgent.optDeepCopyJson(optShallowCopyJson, false)));
            }
        });
        if (ApmContext.isInternalTest()) {
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.2
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new ApiData("api_all", j, j2, str, str2, str3, i, optShallowCopyJson).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorSLA", packLog.toString());
                    }
                }
            });
        }
    }

    public static void monitorApiError(final long j, final long j2, final String str, final String str2, final String str3, final int i, JSONObject jSONObject) {
        final JSONObject optShallowCopyJson = optShallowCopyJson(jSONObject);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.3
            @Override // java.lang.Runnable
            public void run() {
                NetDataPipeline.getInstance().handle(new ApiData("api_error", j, j2, str, str2, str3, i, ApmAgent.optDeepCopyJson(optShallowCopyJson, false)));
            }
        });
        if (ApmContext.isInternalTest()) {
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.4
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new ApiData("api_error", j, j2, str, str2, str3, i, optShallowCopyJson).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorApiError", packLog.toString());
                    }
                }
            });
        }
    }

    public static void monitorSLA(final long j, final long j2, final String str, final String str2, final String str3, final int i, JSONObject jSONObject, HttpRequestInfo httpRequestInfo) {
        final JSONObject optShallowCopyJson = optShallowCopyJson(jSONObject);
        TTNetUtils.updateNetAllExtraInfo(httpRequestInfo, optShallowCopyJson);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.5
            @Override // java.lang.Runnable
            public void run() {
                NetDataPipeline.getInstance().handle(new ApiData("api_all", j, j2, str, str2, str3, i, ApmAgent.optDeepCopyJson(optShallowCopyJson, false)));
            }
        });
        if (ApmContext.isInternalTest()) {
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.6
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new ApiData("api_all", j, j2, str, str2, str3, i, optShallowCopyJson).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorSLA", packLog.toString());
                    }
                }
            });
        }
    }

    public static void monitorApiError(final long j, final long j2, final String str, final String str2, final String str3, final int i, JSONObject jSONObject, HttpRequestInfo httpRequestInfo, Throwable th) {
        final JSONObject optShallowCopyJson = optShallowCopyJson(jSONObject);
        TTNetUtils.updateNetErrorExtraInfo(httpRequestInfo, th, optShallowCopyJson);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.7
            @Override // java.lang.Runnable
            public void run() {
                NetDataPipeline.getInstance().handle(new ApiData("api_error", j, j2, str, str2, str3, i, ApmAgent.optDeepCopyJson(optShallowCopyJson, false)));
            }
        });
        if (ApmContext.isInternalTest()) {
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.8
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new ApiData("api_error", j, j2, str, str2, str3, i, optShallowCopyJson).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorApiError", packLog.toString());
                    }
                }
            });
        }
    }

    public static void monitorEvent(final String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (CommonEventDeliverer.needSkip(str, true)) {
            notifyNotSampled(str, jSONObject);
            return;
        }
        JSONObject preProcessExtJson2 = preProcessExtJson2(jSONObject3);
        addDebugMessage(preProcessExtJson2);
        CommonEventDeliverer.monitorEvent(str, optDeepCopyJson(jSONObject, true), optDeepCopyJson(jSONObject2, true), preProcessExtJson2);
        if (ApmContext.isInternalTest()) {
            final JSONObject optDeepCopyJson = optDeepCopyJson(jSONObject, true);
            final JSONObject optDeepCopyJson2 = optDeepCopyJson(jSONObject2, true);
            final JSONObject optDeepCopyJson3 = optDeepCopyJson(preProcessExtJson2, true);
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.9
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new EventData(str, 0, null, optDeepCopyJson, optDeepCopyJson2, optDeepCopyJson3).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorEvent", packLog.toString());
                    }
                }
            });
        }
    }

    public static void monitorEvent(final EventConfig eventConfig) {
        if (eventConfig == null) {
            return;
        }
        if (CommonEventDeliverer.needSkip(eventConfig.getServiceName(), true)) {
            notifyNotSampled(eventConfig.getServiceName(), null);
            return;
        }
        final JSONObject extraLog = getExtraLog(eventConfig.getExtraLog());
        addDebugMessage(extraLog);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.10
            @Override // java.lang.Runnable
            public void run() {
                CommonEventDeliverer.monitorEvent(EventConfig.this.getServiceName(), EventConfig.this.getStatus(), null, EventConfig.this.getCategory(), EventConfig.this.getMetric(), extraLog);
            }
        });
        if (ApmContext.isInternalTest()) {
            final JSONObject optDeepCopyJson = optDeepCopyJson(eventConfig.getCategory(), true);
            final JSONObject optDeepCopyJson2 = optDeepCopyJson(eventConfig.getMetric(), true);
            final JSONObject optDeepCopyJson3 = optDeepCopyJson(extraLog, true);
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.11
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new EventData(EventConfig.this.getServiceName(), EventConfig.this.getStatus(), null, optDeepCopyJson, optDeepCopyJson2, optDeepCopyJson3, EventConfig.this.isUploadImmediate()).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorEvent", packLog.toString());
                    }
                }
            });
        }
    }

    private static JSONObject getExtraLog(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.isNull("timestamp")) {
            try {
                jSONObject.put("timestamp", System.currentTimeMillis());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static void monitorStatusAndEvent(final String str, final int i, final JSONObject jSONObject, final JSONObject jSONObject2, JSONObject jSONObject3) {
        if (CommonEventDeliverer.needSkip(str, true)) {
            notifyNotSampled(str, jSONObject);
            return;
        }
        final JSONObject optShallowCopyJson = optShallowCopyJson(jSONObject3);
        addDebugMessage(optShallowCopyJson);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.12
            @Override // java.lang.Runnable
            public void run() {
                CommonEventDeliverer.monitorStatusAndEvent(str, i, ApmAgent.optDeepCopyJson(jSONObject, true), ApmAgent.optDeepCopyJson(jSONObject2, true), ApmAgent.optDeepCopyJson(optShallowCopyJson, false));
            }
        });
        if (ApmContext.isInternalTest()) {
            final JSONObject optDeepCopyJson = optDeepCopyJson(jSONObject, true);
            final JSONObject optDeepCopyJson2 = optDeepCopyJson(jSONObject2, true);
            final JSONObject optDeepCopyJson3 = optDeepCopyJson(optShallowCopyJson, true);
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.13
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new EventData(str, i, null, optDeepCopyJson, optDeepCopyJson2, optDeepCopyJson3).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorStatusAndEvent", packLog.toString());
                    }
                }
            });
        }
    }

    public static void monitorStatusRate(final String str, final int i, JSONObject jSONObject) {
        if (CommonEventDeliverer.needSkip(str, true)) {
            notifyNotSampled(str, jSONObject);
            return;
        }
        JSONObject preProcessExtJson2 = preProcessExtJson2(jSONObject);
        addDebugMessage(preProcessExtJson2);
        CommonEventDeliverer.monitorStatusRate(str, i, preProcessExtJson2);
        if (ApmContext.isInternalTest()) {
            final JSONObject optDeepCopyJson = optDeepCopyJson(preProcessExtJson2, true);
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.14
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new EventData(str, i, null, null, null, optDeepCopyJson).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorStatusRate", packLog.toString());
                    }
                }
            });
        }
    }

    @Deprecated
    public static void monitorDuration(final String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (CommonEventDeliverer.needSkip(str, true)) {
            notifyNotSampled(str, jSONObject);
            return;
        }
        JSONObject preProcessExtJson2 = preProcessExtJson2(jSONObject2);
        addDebugMessage(preProcessExtJson2);
        CommonEventDeliverer.monitorDuration(str, sDeepCopy ? JsonUtils.safeCopyJson2(jSONObject) : jSONObject, preProcessExtJson2);
        if (ApmContext.isInternalTest()) {
            final JSONObject optDeepCopyJson = optDeepCopyJson(jSONObject, true);
            final JSONObject optDeepCopyJson2 = optDeepCopyJson(preProcessExtJson2, true);
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.15
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new EventData(str, 0, optDeepCopyJson, null, null, optDeepCopyJson2).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorDuration", packLog.toString());
                    }
                }
            });
        }
    }

    @Deprecated
    public static void monitorDuration(final String str, final JSONObject jSONObject, JSONObject jSONObject2, long j) {
        if (CommonEventDeliverer.needSkip(str, true)) {
            notifyNotSampled(str, jSONObject);
            return;
        }
        if (jSONObject2 != null) {
            try {
                jSONObject2.put("timestamp", j);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        final JSONObject optShallowCopyJson = optShallowCopyJson(jSONObject2);
        addDebugMessage(optShallowCopyJson);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.16
            @Override // java.lang.Runnable
            public void run() {
                CommonEventDeliverer.monitorDuration(str, ApmAgent.optDeepCopyJson(jSONObject, true), ApmAgent.optDeepCopyJson(optShallowCopyJson, false));
            }
        });
        if (ApmContext.isInternalTest()) {
            final JSONObject optDeepCopyJson = optDeepCopyJson(jSONObject, true);
            final JSONObject optDeepCopyJson2 = optDeepCopyJson(optShallowCopyJson, true);
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.17
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new EventData(str, 0, optDeepCopyJson, null, null, optDeepCopyJson2).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorDuration", packLog.toString());
                    }
                }
            });
        }
    }

    @Deprecated
    public static void monitorStatusAndDuration(final String str, final int i, JSONObject jSONObject, JSONObject jSONObject2) {
        if (CommonEventDeliverer.needSkip(str, true)) {
            notifyNotSampled(str, jSONObject);
            return;
        }
        JSONObject optShallowCopyJson = optShallowCopyJson(jSONObject2);
        addDebugMessage(optShallowCopyJson);
        CommonEventDeliverer.monitorStatusAndDuration(str, i, optDeepCopyJson(jSONObject, true), optDeepCopyJson(optShallowCopyJson, false));
        if (ApmContext.isInternalTest()) {
            final JSONObject optDeepCopyJson = optDeepCopyJson(jSONObject, true);
            final JSONObject optDeepCopyJson2 = optDeepCopyJson(jSONObject2, true);
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.18
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new EventData(str, i, optDeepCopyJson, null, null, optDeepCopyJson2).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorStatusAndDuration", packLog.toString());
                    }
                }
            });
        }
    }

    public static void monitorCommonLog(String str, JSONObject jSONObject) {
        monitorCommonLog(str, jSONObject, false);
    }

    public static void monitorExceptionLog(final String str, JSONObject jSONObject) {
        final JSONObject preProcessExtJson2 = preProcessExtJson2(jSONObject);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.19
            @Override // java.lang.Runnable
            public void run() {
                CommonDataPipeline.getInstance().handle(new ExceptionLogData(str, preProcessExtJson2));
            }
        });
        if (ApmContext.isInternalTest()) {
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.20
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new ExceptionLogData(str, preProcessExtJson2).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorExceptionLog", packLog.toString());
                    }
                }
            });
        }
    }

    public static void monitorCommonLog(final String str, JSONObject jSONObject, final boolean z) {
        if (CommonEventDeliverer.needSkip(str, false)) {
            notifyNotSampled(str, jSONObject);
            return;
        }
        final JSONObject preProcessExtJson2 = preProcessExtJson2(jSONObject);
        addDebugMessage(preProcessExtJson2);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.21
            @Override // java.lang.Runnable
            public void run() {
                CommonEventDeliverer.monitorCommonLog(str, preProcessExtJson2);
            }
        });
        if (ApmContext.isInternalTest()) {
            final JSONObject optDeepCopyJson = optDeepCopyJson(preProcessExtJson2, true);
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.22
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new CommonLogData(str, optDeepCopyJson, z).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorCommonLog", packLog.toString());
                    }
                }
            });
        }
    }

    public static boolean getServiceSwitch(String str) {
        return ApmDelegate.getInstance().getServiceNameSwitch(str);
    }

    public static boolean getLogTypeSwitch(String str) {
        return ApmDelegate.getInstance().getLogTypeSwitch(str);
    }

    @Deprecated
    public static void setReportMode(ApmReportConfig apmReportConfig) {
        ApmDelegate.getInstance().setReportConfig(apmReportConfig);
    }

    @Deprecated
    public static boolean getMetricsSwitch(String str) {
        return ApmDelegate.getInstance().getMetricsTypeSwitch(str);
    }

    public static boolean isConfigReady() {
        return ApmDelegate.getInstance().isConfigReady();
    }

    public static void monitorPageLoad(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            monitorPerformance("page_load", "page_load", jSONObject, jSONObject2, null);
        } catch (Exception unused) {
        }
    }

    public static void monitorUIAction(String str, String str2, JSONObject jSONObject) {
        monitorUIAction(str, str2, jSONObject, null);
    }

    public static void monitorUIAction(final String str, final String str2, final JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            final JSONObject preProcessExtJson = sDeepCopy ? preProcessExtJson(jSONObject2) : preProcessExtJson2(jSONObject2);
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.23
                @Override // java.lang.Runnable
                public void run() {
                    CommonDataPipeline.getInstance().handle(new UIActionData(str, str2, jSONObject, preProcessExtJson));
                }
            });
            if (ApmContext.isInternalTest()) {
                LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.24
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject packLog = new UIActionData(str, str2, ApmAgent.optDeepCopyJson(jSONObject, true), preProcessExtJson).packLog();
                        if (packLog != null) {
                            ApmAgent.storeLogBypass("monitorUIAction", packLog.toString());
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    public static void monitorPerformance(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        monitorPerformance(str, "", jSONObject, jSONObject2, jSONObject3);
    }

    public static void monitorPerformance(final String str, final String str2, final JSONObject jSONObject, final JSONObject jSONObject2, JSONObject jSONObject3) {
        try {
            JSONObject preProcessExtJson = sDeepCopy ? preProcessExtJson(jSONObject3) : preProcessExtJson2(jSONObject3);
            final JSONObject jSONObject4 = preProcessExtJson;
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.25
                @Override // java.lang.Runnable
                public void run() {
                    CommonDataPipeline.getInstance().handle(new PerfData(str, str2, jSONObject, jSONObject2, jSONObject4));
                }
            });
            if (ApmContext.isInternalTest()) {
                final JSONObject jSONObject5 = preProcessExtJson;
                LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.26
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject packLog = new PerfData(str, str2, ApmAgent.optDeepCopyJson(jSONObject, true), ApmAgent.optDeepCopyJson(jSONObject2, true), jSONObject5).packLog();
                        if (packLog != null) {
                            ApmAgent.storeLogBypass("monitorPerformance", packLog.toString());
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public static void monitorDirectOnTimer(final String str, final String str2, final float f) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.27
            @Override // java.lang.Runnable
            public void run() {
                CommonDataPipeline.getInstance().handle(new MetricsData(str, str2, f));
            }
        });
        if (ApmContext.isInternalTest()) {
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.28
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject packLog = new MetricsData(str, str2, f).packLog();
                    if (packLog != null) {
                        ApmAgent.storeLogBypass("monitorDirectOnTimer", packLog.toString());
                    }
                }
            });
        }
    }

    private static JSONObject preProcessExtJson(JSONObject jSONObject) {
        try {
            JSONObject copyJson2 = JsonUtils.copyJson2(jSONObject);
            if (copyJson2 == null) {
                copyJson2 = new JSONObject();
            }
            if (copyJson2.isNull("timestamp")) {
                copyJson2.put("timestamp", System.currentTimeMillis());
            }
            return copyJson2;
        } catch (Exception unused) {
            return jSONObject;
        }
    }

    private static JSONObject preProcessExtJson2(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        if (jSONObject.isNull("timestamp")) {
            jSONObject.put("timestamp", System.currentTimeMillis());
        }
        return jSONObject;
    }

    public static void activeUploadAlog(String str, long j, long j2, String str2, IALogActiveUploadObserver iALogActiveUploadObserver, IALogActiveUploadCallback iALogActiveUploadCallback) {
        ApmDelegate.getInstance().activeUploadAlog(str, j, j2, str2, iALogActiveUploadObserver, iALogActiveUploadCallback);
    }

    public static void activeUploadAlog(String str, long j, long j2, String str2, IALogActiveUploadObserver iALogActiveUploadObserver) {
        activeUploadAlog(str, j, j2, str2, iALogActiveUploadObserver, null);
    }

    public static void activeUploadAlog(long j, long j2, String str, IALogActiveUploadObserver iALogActiveUploadObserver) {
        activeUploadAlog("", j, j2, str, iALogActiveUploadObserver);
    }

    public static int reportThreadCount(String str) {
        try {
            return ThreadCollector.reportThreadCount(str, true);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void trafficStats(long j, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        BizTrafficStats.getInstance().trafficStats(j, str, str2, str3, jSONObject, jSONObject2);
    }

    public static void startTrafficStats(String str) {
        TrafficCollector.getInstance().startMetric(str, false);
    }

    public static void startTrafficStats(String str, boolean z) {
        TrafficCollector.getInstance().startMetric(str, z);
    }

    public static void stopTrafficStats(String str) {
        TrafficCollector.getInstance().stopMetric(str);
    }

    public static void startScene(String str) {
        PerfFilterManager.getInstance().startScene(str);
        com.bytedance.apm6.perf.base.PerfFilterManager.getInstance().startScene(str);
    }

    public static void stopScene(String str) {
        PerfFilterManager.getInstance().stopScene(str);
        com.bytedance.apm6.perf.base.PerfFilterManager.getInstance().stopScene(str);
    }

    public static void addPerfTag(String str, String str2) {
        PerfFilterManager.getInstance().addPerfTag(str, str2);
        com.bytedance.apm6.perf.base.PerfFilterManager.getInstance().addPerfTag(str, str2);
    }

    public static void removePerfTag(String str, String str2) {
        PerfFilterManager.getInstance().removePerfTag(str, str2);
        com.bytedance.apm6.perf.base.PerfFilterManager.getInstance().removePerfTag(str, str2);
    }

    public static void startCollectCurrent(final String str) {
        if (ApmContext.getContext() != null) {
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.29
                @Override // java.lang.Runnable
                public void run() {
                    BatteryEnergyCollector.getInstance().startSceneMonitor(str);
                }
            });
        } else {
            ApmAlogHelper.m77i("apm_debug", "ApmAgent#startCollectCurrent  apm do not be init");
        }
    }

    public static void stopCollectCurrent(final String str) {
        if (ApmContext.getContext() != null) {
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.30
                @Override // java.lang.Runnable
                public void run() {
                    BatteryEnergyCollector.getInstance().endSceneMonitor(str);
                }
            });
        } else {
            ApmAlogHelper.m77i("apm_debug", "ApmAgent#stopCollectCurrent  apm do not be init");
        }
    }

    public static void startBatteryCollect(String str) {
        if (ApmContext.getContext() != null) {
            BatteryCollector.getInstance().startSceneMonitor(str);
        } else {
            ApmAlogHelper.m77i("apm_debug", "ApmAgent#startBatteryCollect  apm do not be init");
        }
    }

    public static void stopBatteryCollect(String str) {
        if (ApmContext.getContext() != null) {
            BatteryCollector.getInstance().stopSceneMonitor(str);
        } else {
            ApmAlogHelper.m77i("apm_debug", "ApmAgent#startBatteryCollect  apm do not be init");
        }
    }

    public static void configSceneMinDuration(HashMap<String, Long> hashMap) {
        ProcessEnergyCollector.getInstance().configSceneMinDuration(hashMap);
    }

    public static void startCpuMonitor(final String str) {
        if (ApmContext.getContext() != null) {
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.31
                @Override // java.lang.Runnable
                public void run() {
                    ProcessEnergyCollector.getInstance().startScene(str);
                }
            });
        } else {
            ApmAlogHelper.m77i("apm_debug", "ApmAgent#startCpuMonitor  apm do not be init");
        }
    }

    public static void stopCpuMonitor(final String str) {
        if (ApmContext.getContext() != null) {
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.32
                @Override // java.lang.Runnable
                public void run() {
                    ProcessEnergyCollector.getInstance().stopScene(str);
                }
            });
        } else {
            ApmAlogHelper.m77i("apm_debug", "ApmAgent#stopCpuMonitor  apm do not be init");
        }
    }

    public static void addBatteryDataListener(IBatteryDataListener iBatteryDataListener) {
        BatteryTemperatureCollector.getInstance().addBatteryDataListener(iBatteryDataListener);
    }

    public static void uploadMappingFile(String str, IFileUploadCallback iFileUploadCallback) {
        String optString = ApmContext.getHeaderInner().optString("aid");
        String optString2 = ApmContext.getHeaderInner().optString("update_version_code");
        String optString3 = ApmContext.getHeaderInner().optString("channel");
        String optString4 = ApmContext.getHeaderInner().optString("release_build");
        String optString5 = ApmContext.getHeaderInner().optString("device_id");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
            FileUploadServiceImpl.uploadMappingFiles(optString, optString2, optString3, optString4, str, null, optString5, iFileUploadCallback);
        } else if (iFileUploadCallback != null) {
            iFileUploadCallback.onFail("Missing required parameters");
        }
    }

    public static void uploadMappingFile(String str, String str2, String str3, String str4, String str5, IFileUploadCallback iFileUploadCallback, String str6) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            FileUploadServiceImpl.setMappingFileUploadHost(str6);
            FileUploadServiceImpl.uploadMappingFiles(str2, str3, str4, str5, str, null, iFileUploadCallback);
        } else if (iFileUploadCallback != null) {
            iFileUploadCallback.onFail("Missing required parameters");
        }
    }

    public static void uploadMappingFile(String str, String str2, String str3, String str4, String str5, IFileUploadCallback iFileUploadCallback, String str6, String str7) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str6)) {
            FileUploadServiceImpl.setMappingFileUploadHost(str6);
            FileUploadServiceImpl.uploadMappingFiles(str2, str3, str4, str5, str, null, str7, iFileUploadCallback);
        } else if (iFileUploadCallback != null) {
            iFileUploadCallback.onFail("Missing required parameters");
        }
    }

    public static void uploadMappingFile(String str, String str2, String str3, String str4, String str5, IFileUploadCallback iFileUploadCallback) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            uploadMappingFileInternal(str, str2, str3, str4, str5, null, iFileUploadCallback);
        } else if (iFileUploadCallback != null) {
            iFileUploadCallback.onFail("Missing required parameters");
        }
    }

    public static void uploadMappingFile(String str, String str2, String str3, String str4, String str5, String str6, IFileUploadCallback iFileUploadCallback) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            uploadMappingFileInternal(str, str2, str3, str4, str5, str6, iFileUploadCallback);
        } else if (iFileUploadCallback != null) {
            iFileUploadCallback.onFail("Missing required parameters");
        }
    }

    private static void uploadMappingFileInternal(String str, String str2, String str3, String str4, String str5, String str6, IFileUploadCallback iFileUploadCallback) {
        if (ListUtils.isEmpty(ReportUrl.REPORT_URL_LIST)) {
            if (iFileUploadCallback != null) {
                iFileUploadCallback.onFail("need host");
            }
        } else {
            try {
                FileUploadServiceImpl.setMappingFileUploadHost(new URL(ReportUrl.REPORT_URL_LIST.get(0)).getHost());
                FileUploadServiceImpl.uploadMappingFiles(str2, str3, str4, str5, str, null, str6, iFileUploadCallback);
            } catch (MalformedURLException unused) {
                if (iFileUploadCallback != null) {
                    iFileUploadCallback.onFail("MalformedURLException");
                }
            }
        }
    }

    public static void feedbackReport(final long j, final long j2, final boolean z) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.ApmAgent.33
            @Override // java.lang.Runnable
            public void run() {
                ApmAgent.reportLegacyMonitorLog(ApmContext.getContext(), j, j2, z);
            }
        });
    }

    private static void reportFeedbackInfo() {
        try {
            if (!TemperatureDataManager.getInstance().isRegistered() && ApmContext.getContext() != null) {
                TemperatureDataManager.getInstance().registerTemperatureReceiver();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject perfFiltersJson = PerfFilterManager.getInstance().getPerfFiltersJson(true);
            perfFiltersJson.put(CommonKey.KEY_CRASH_SECTION, ApmContext.getTimeRange(System.currentTimeMillis()));
            perfFiltersJson.put(Header.KEY_CRASH_TYPE, "feedback");
            JSONObject dumpInfos = PerfMonitorManager.getInstance().dumpInfos();
            dumpInfos.put(ActivityLifecycle.ACTIVITY_TRACK, ActivityUtils.getActivityTrack());
            dumpInfos.put(MonitorConstant.BLANK_CPU_INFO, PerfDataCenter.getInstance().getCpuInfo());
            dumpInfos.put(MonitorConstant.BLANK_MEMORY_INFO, getMemInfo(PerfCollectUtils.getMemory(ApmContext.getContext())));
            dumpInfos.put(CommonServiceName.MONITOR_TYPE_TEMPERATURE, TemperatureDataManager.getInstance().getTemperature());
            String evilMethod = MethodCollector.getInstance().getEvilMethod(0L, SystemClock.uptimeMillis());
            if (!TextUtils.isEmpty(evilMethod)) {
                dumpInfos.put(CommonKey.KEY_EVIL_METHOD, evilMethod);
                perfFiltersJson.put(CommonKey.KEY_WITH_EVIL_METHOD, "true");
            }
            String dumpSortedStackTrace = PerfMonitorManager.getInstance().dumpSortedStackTrace(0L, SystemClock.uptimeMillis());
            if (!TextUtils.isEmpty(dumpSortedStackTrace) && dumpSortedStackTrace.length() > 10) {
                dumpInfos.put(CommonKey.KEY_STACK_TRACE, dumpSortedStackTrace);
            }
            dumpInfos.put("battery", getCapacity());
            dumpInfos.put("battery_current", getGalvanicNow());
            jSONObject.put("custom", dumpInfos);
            jSONObject.put("filters", perfFiltersJson);
            jSONObject.put("stack", "at feedback.*(a.java:-1)");
            jSONObject.put("event_type", ExceptionTypeName.EXCEPTION_EVENT_TYPE_SERIOUS_LAG);
            ExceptionLogData exceptionLogData = new ExceptionLogData("serious_block_monitor", jSONObject);
            exceptionLogData.forceSample();
            CommonDataPipeline.getInstance().handle(exceptionLogData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getCapacity() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("battery_percent", ThorUtils.getCapacity(ApmContext.getContext()));
            JSONObject mainThreadBatteryData = BatteryDataManager.getInstance().getMainThreadBatteryData();
            if (mainThreadBatteryData.length() == 0) {
                jSONObject.put("more", "no-more-info");
            } else {
                jSONObject.put("more", mainThreadBatteryData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject getGalvanicNow() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("battery_current", ThorUtils.getGalvanicNow(ApmContext.getContext()));
            jSONObject.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject getMemInfo(MemoryInfo memoryInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("javaTotalMemory", memoryInfo.javaTotalMemory);
        jSONObject.put("javaFreeMemory", memoryInfo.javaFreeMemory);
        jSONObject.put("javaUsedMemory", memoryInfo.javaUsedMemory);
        jSONObject.put("pssDalvik", memoryInfo.pssDalvik);
        jSONObject.put("pssNative", memoryInfo.pssNative);
        jSONObject.put("pssTotal", memoryInfo.pssTotal);
        jSONObject.put("graphics", memoryInfo.graphics);
        jSONObject.put("vmSize", memoryInfo.vmSize);
        return jSONObject;
    }

    public static void storeLogBypass(String str, String str2) {
        try {
            synchronized (ApmAgent.class) {
                String currentProcessName = ApmContext.getCurrentProcessName();
                long id = Thread.currentThread().getId();
                long currentTimeMillis = System.currentTimeMillis();
                String currentFormatTime = TimeUtils.getCurrentFormatTime();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str).append("#").append(id).append("#").append(currentTimeMillis).append("#").append(currentFormatTime).append("\n").append(str2).append("\n");
                byte[] bytes = stringBuffer.toString().getBytes(UrlUtils.UTF_8);
                String absolutePath = ApmContext.getContext().getExternalFilesDir(null).getAbsolutePath();
                if (sMappedByteBuffer == null) {
                    File file = new File(absolutePath + "/logs");
                    sProcessLogsFolder = new File(absolutePath + "/logs/proc: " + currentProcessName);
                    File file2 = new File(absolutePath + "/logs/proc: " + currentProcessName + "/" + currentFormatTime);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (!sProcessLogsFolder.exists()) {
                        sProcessLogsFolder.mkdirs();
                    }
                    file2.createNewFile();
                    sMappedByteBuffer = new RandomAccessFile(file2, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, ApmContext.isMainProcess() ? 2097152L : 262144L);
                }
                if (sMappedByteBuffer.remaining() < bytes.length) {
                    sMappedByteBuffer.force();
                    sMappedByteBuffer = new RandomAccessFile(new File(absolutePath + "/logs/proc: " + currentProcessName + "/" + currentFormatTime), "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, ApmContext.isMainProcess() ? 2097152L : 262144L);
                }
                sMappedByteBuffer.put(bytes);
                if (sLastCheckDiskTime == -1 || System.currentTimeMillis() - sLastCheckDiskTime > 3600000) {
                    if (FileUtils.getSize(sProcessLogsFolder) > ProcInfo.f137GB || FileUtils.getExternalRootDir(ApmContext.getContext()).getFreeSpace() < ProcInfo.f137GB) {
                        weedOutOldestLogFiles();
                    }
                    sLastCheckDiskTime = System.currentTimeMillis();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void weedOutOldestLogFiles() {
        if (ApmContext.isMainProcess() && sProcessLogsFolder.exists()) {
            File[] listFiles = sProcessLogsFolder.listFiles();
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.bytedance.apm.ApmAgent.34
                @Override // java.util.Comparator
                public int compare(File file, File file2) {
                    return Long.compare(file.lastModified(), file2.lastModified());
                }
            });
            int length = listFiles.length <= 60 ? listFiles.length : 60;
            for (int i = 0; i < length; i++) {
                listFiles[i].delete();
            }
        }
    }

    private static void addDebugMessage(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_DEBUG_UUID, ApmContext.getStartId() + "_" + atomicLong.getAndAdd(1L));
            jSONObject.put(KEY_SELF_DEBUG_MESSAGE, jSONObject2);
        } catch (Exception unused) {
        }
    }

    private static JSONObject optShallowCopyJson(JSONObject jSONObject) {
        if (FAST_MODE) {
            return JsonUtils.safeJsonObject(jSONObject);
        }
        return preProcessExtJson2(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject optDeepCopyJson(JSONObject jSONObject, boolean z) {
        return !FAST_MODE ? JsonUtils.deepCopy(jSONObject) : z ? JsonUtils.safeJsonObject(jSONObject) : jSONObject;
    }

    private static void notifyNotSampled(String str, JSONObject jSONObject) {
        if (ApmContext.isDebugMode()) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            DoctorDataUtil.onReceivedEvent(str, jSONObject, false);
        }
    }
}
