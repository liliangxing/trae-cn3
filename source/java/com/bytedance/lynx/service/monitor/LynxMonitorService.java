package com.bytedance.lynx.service.monitor;

import android.app.Application;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.service.model.LynxServiceConfig;
import com.bytedance.lynx.service.trace.TraceEventDef;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.image.ImageErrorCodeUtils;
import com.lynx.tasm.service.ILynxMonitorService;
import com.lynx.tasm.service.ILynxResourceService;
import com.lynx.tasm.service.LynxImageInfo;
import com.lynx.tasm.service.LynxServiceCenter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LynxMonitorService.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0002J6\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u000100H\u0016J\u000e\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020(J\u0018\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0016J\u0010\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u00020*2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0016J*\u0010<\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u0002002\b\u0010=\u001a\u0004\u0018\u000100H\u0016J\u0018\u0010>\u001a\u00020*2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/lynx/service/monitor/LynxMonitorService;", "Lcom/lynx/tasm/service/ILynxMonitorService;", "()V", "DEFAULT_BID", "", "DEFAULT_PID", "KEY_BID", "KEY_CHANNEL", "KEY_EXTRA", "KEY_EXTRA_TIMING", "KEY_IMAGE_LOAD_SUCCESS_RATE", "KEY_IMAGE_URL", "KEY_MEMORY", "KEY_MEMORY_COST", "KEY_MEMORY_COST_FROM", "KEY_METRIC", "KEY_METRICS", "KEY_PAGE_CONFIG", "KEY_PID", "KEY_SETUP_TIMING", "KEY_SUCCESS_RATE", "KEY_TIME_METRICS", "KEY_TRIGGER", "KEY_TYPE", "KEY_UPDATE_TIMING", "KEY_URL", "LYNX_SDK_VERSION_TAG", "LYNX_SID", "", "SDK_VERSION_REPORTED", "", "TAG", "initLock", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lynxSdkVersion", "getLynxSdkVersion", "()Ljava/lang/String;", "lynxSdkVersion$delegate", "Lkotlin/Lazy;", "lynxServiceConfig", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "ensureInitialize", "", "formatEventReporter", "view", "Lcom/lynx/tasm/LynxView;", SchemaConstants.INNER_PARAM_EVENT_NAME, "data", "Lorg/json/JSONObject;", LynxMonitorService.KEY_METRICS, "category", "initialize", "lynxConfig", "reportCrashGlobalContextTag", "tagName", "tagValue", "reportImageInfo", "imageInfo", "Lcom/lynx/tasm/service/LynxImageInfo;", "reportImageStatus", "reportResourceStatus", "extra", "reportTrailEvent", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxMonitorService implements ILynxMonitorService {
    public static final String DEFAULT_BID = "LynxInspector";
    public static final String DEFAULT_PID = "Lynx";
    public static final String KEY_BID = "bid";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_EXTRA_TIMING = "extra_timing";
    public static final String KEY_IMAGE_LOAD_SUCCESS_RATE = "image_load_success_rate";
    public static final String KEY_IMAGE_URL = "image_url";
    public static final String KEY_MEMORY = "memory";
    public static final String KEY_MEMORY_COST = "memory_cost";
    public static final String KEY_MEMORY_COST_FROM = "memoryCost";
    public static final String KEY_METRIC = "metric";
    public static final String KEY_METRICS = "metrics";
    public static final String KEY_PAGE_CONFIG = "page_config";
    public static final String KEY_PID = "pid";
    public static final String KEY_SETUP_TIMING = "setup_timing";
    public static final String KEY_SUCCESS_RATE = "successRate";
    public static final String KEY_TIME_METRICS = "timeMetrics";
    public static final String KEY_TRIGGER = "trigger";
    public static final String KEY_TYPE = "type";
    public static final String KEY_UPDATE_TIMING = "update_timings";
    public static final String KEY_URL = "url";
    private static final String LYNX_SDK_VERSION_TAG = "lynx_sdk_version";
    private static final int LYNX_SID = 2951;
    private static volatile boolean SDK_VERSION_REPORTED = false;
    public static final String TAG = "LynxMonitorService";
    private static LynxServiceConfig lynxServiceConfig;
    public static final LynxMonitorService INSTANCE = new LynxMonitorService();
    private static final AtomicBoolean initLock = new AtomicBoolean(false);

    /* renamed from: lynxSdkVersion$delegate, reason: from kotlin metadata */
    private static final Lazy lynxSdkVersion = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.lynx.service.monitor.LynxMonitorService$lynxSdkVersion$2
        public final String invoke() {
            return LynxEnv.inst().getLynxVersion();
        }
    });

    private LynxMonitorService() {
    }

    private final String getLynxSdkVersion() {
        Object value = lynxSdkVersion.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-lynxSdkVersion>(...)");
        return (String) value;
    }

    public final void initialize(LynxServiceConfig lynxConfig) {
        Intrinsics.checkNotNullParameter(lynxConfig, "lynxConfig");
        lynxServiceConfig = lynxConfig;
    }

    private final void ensureInitialize() {
        Object obj;
        LynxServiceConfig lynxServiceConfig2;
        Application context;
        if (initLock.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.Companion;
                Field declaredField = HybridMultiMonitor.class.getDeclaredField("isInitialized");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
                if (!(declaredField != null ? declaredField.getBoolean(HybridMultiMonitor.getInstance()) : false) && (lynxServiceConfig2 = lynxServiceConfig) != null && (context = lynxServiceConfig2.getContext()) != null) {
                    HybridMultiMonitor.getInstance().init(context);
                    HybridSettingInitConfig.Builder builder = new HybridSettingInitConfig.Builder();
                    LynxServiceConfig lynxServiceConfig3 = lynxServiceConfig;
                    builder.setHost(lynxServiceConfig3 != null ? lynxServiceConfig3.getMonitorHost() : null);
                    LynxServiceConfig lynxServiceConfig4 = lynxServiceConfig;
                    builder.setChannel(lynxServiceConfig4 != null ? lynxServiceConfig4.getChannel() : null);
                    LynxServiceConfig lynxServiceConfig5 = lynxServiceConfig;
                    builder.setAid(lynxServiceConfig5 != null ? lynxServiceConfig5.getAppId() : null);
                    LynxServiceConfig lynxServiceConfig6 = lynxServiceConfig;
                    builder.setDeviceId(lynxServiceConfig6 != null ? lynxServiceConfig6.getDeviceId() : null);
                    LynxServiceConfig lynxServiceConfig7 = lynxServiceConfig;
                    builder.setVersionCode(lynxServiceConfig7 != null ? lynxServiceConfig7.getAppVersion() : null);
                    LynxServiceConfig lynxServiceConfig8 = lynxServiceConfig;
                    builder.setUpdateVersionCode(lynxServiceConfig8 != null ? lynxServiceConfig8.getUpdateVersionCode() : null);
                    LynxServiceConfig lynxServiceConfig9 = lynxServiceConfig;
                    builder.setRegion(lynxServiceConfig9 != null ? lynxServiceConfig9.getRegion() : null);
                    HybridMultiMonitor.getInstance().setConfig(builder.build());
                }
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                LLog.e(TAG, "LynxMonitorService ensureInitialize:" + th2.getMessage());
            }
        }
    }

    public void reportTrailEvent(String eventName, JSONObject data) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(data, "data");
        TraceEvent.beginSection(TraceEventDef.MONITOR_PROXY_REPORT_IMAGE_STATUS);
        JSONObject jSONObject = new JSONObject();
        JSONObject optJSONObject = data.optJSONObject(KEY_PAGE_CONFIG);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, optJSONObject.get(next));
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject optJSONObject2 = data.optJSONObject("metric");
        if (optJSONObject2 != null) {
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(KEY_METRICS);
            if (optJSONObject3 != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject3, "optJSONObject(KEY_METRICS)");
                Iterator<String> keys2 = optJSONObject3.keys();
                Intrinsics.checkNotNullExpressionValue(keys2, "it.keys()");
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    jSONObject2.put(next2, optJSONObject3.get(next2));
                }
            }
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject(KEY_SETUP_TIMING);
            if (optJSONObject4 != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject4, "optJSONObject(KEY_SETUP_TIMING)");
                Iterator<String> keys3 = optJSONObject4.keys();
                Intrinsics.checkNotNullExpressionValue(keys3, "it.keys()");
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    jSONObject2.put(next3, optJSONObject4.get(next3));
                }
            }
            JSONObject optJSONObject5 = optJSONObject2.optJSONObject(KEY_EXTRA_TIMING);
            if (optJSONObject5 != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject5, "optJSONObject(KEY_EXTRA_TIMING)");
                Iterator<String> keys4 = optJSONObject5.keys();
                Intrinsics.checkNotNullExpressionValue(keys4, "it.keys()");
                while (keys4.hasNext()) {
                    String next4 = keys4.next();
                    jSONObject2.put(next4, optJSONObject5.get(next4));
                }
            }
            JSONObject optJSONObject6 = optJSONObject2.optJSONObject(KEY_UPDATE_TIMING);
            if (optJSONObject6 != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject6, "optJSONObject(KEY_UPDATE_TIMING)");
                Iterator<String> keys5 = optJSONObject6.keys();
                Intrinsics.checkNotNullExpressionValue(keys5, "it.keys()");
                while (keys5.hasNext()) {
                    String next5 = keys5.next();
                    jSONObject2.put(next5, optJSONObject6.get(next5));
                }
            }
            JSONObject optJSONObject7 = optJSONObject2.optJSONObject("memory");
            if (optJSONObject7 != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONObject7, "optJSONObject(KEY_MEMORY)");
                Iterator<String> keys6 = optJSONObject7.keys();
                Intrinsics.checkNotNullExpressionValue(keys6, "it.keys()");
                while (keys6.hasNext()) {
                    String next6 = keys6.next();
                    jSONObject2.put(next6, optJSONObject7.get(next6));
                }
            }
        }
        formatEventReporter(null, eventName, data, jSONObject2, jSONObject);
        TraceEvent.endSection(TraceEventDef.MONITOR_PROXY_REPORT_IMAGE_STATUS);
    }

    public void reportImageStatus(String eventName, JSONObject data) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(data, "data");
        TraceEvent.beginSection(TraceEventDef.MONITOR_PROXY_REPORT_IMAGE_STATUS);
        JSONObject jSONObject = new JSONObject();
        JSONObject optJSONObject = data.optJSONObject(KEY_TIME_METRICS);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "this.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, optJSONObject.get(next));
            }
        }
        jSONObject.put(KEY_IMAGE_LOAD_SUCCESS_RATE, data.optInt(KEY_SUCCESS_RATE, -1));
        jSONObject.put(KEY_MEMORY_COST, data.optLong(KEY_MEMORY_COST_FROM, -1L));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(KEY_IMAGE_URL, data.optString(KEY_IMAGE_URL, ""));
        formatEventReporter(null, eventName, data, jSONObject, jSONObject2);
        TraceEvent.endSection(TraceEventDef.MONITOR_PROXY_REPORT_IMAGE_STATUS);
    }

    public void formatEventReporter(LynxView view, String eventName, JSONObject data, JSONObject metrics, JSONObject category) {
        String str;
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(data, "data");
        TraceEvent.beginSection(TraceEventDef.MONITOR_PROXY_FORMAT_EVENT);
        ensureInitialize();
        JSONObject optJSONObject = data.optJSONObject("metric");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", optJSONObject.optString("url", ""));
        jSONObject.put("bid", DEFAULT_BID);
        jSONObject.put(KEY_PID, DEFAULT_PID);
        if (category != null) {
            category.put("type", DEFAULT_PID);
            category.put(KEY_TRIGGER, eventName);
            LynxServiceConfig lynxServiceConfig2 = lynxServiceConfig;
            if (lynxServiceConfig2 == null || (str = lynxServiceConfig2.getChannel()) == null) {
                str = "";
            }
            category.put("channel", data.optString("channel", str));
            category.put("url", optJSONObject.optString("url", ""));
        }
        JSONObject optJSONObject2 = data.optJSONObject("extra");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        CustomInfo.Builder sample = new CustomInfo.Builder(eventName).setBid(DEFAULT_BID).setCategory(category).setMetric(metrics).setCommon(jSONObject).setExtra(optJSONObject2).setSample(0);
        LynxServiceConfig lynxServiceConfig3 = lynxServiceConfig;
        CustomInfo build = sample.setVirtualAID(lynxServiceConfig3 != null ? lynxServiceConfig3.getAppId() : null).build();
        if (view != null) {
            LynxViewMonitor instance = LynxViewMonitor.Companion.getINSTANCE();
            Intrinsics.checkNotNullExpressionValue(build, "customInfo");
            instance.reportCustom(view, build);
        } else {
            HybridMultiMonitor.getInstance().customReport(build);
        }
        TraceEvent.endSection(TraceEventDef.MONITOR_PROXY_FORMAT_EVENT);
    }

    public void reportResourceStatus(LynxView view, String eventName, JSONObject data, JSONObject extra) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        Intrinsics.checkNotNullParameter(data, "data");
        TraceEvent.beginSection(TraceEventDef.MONITOR_PROXY_REPORT_RESOURCE_STATUS);
        LynxViewMonitor.Companion.getINSTANCE().handleNativeInfo(view, eventName, data);
        TraceEvent.endSection(TraceEventDef.MONITOR_PROXY_REPORT_RESOURCE_STATUS);
    }

    public void reportCrashGlobalContextTag(final String tagName, final String tagValue) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        Intrinsics.checkNotNullParameter(tagValue, "tagValue");
        TraceEvent.beginSection(TraceEventDef.MONITOR_PROXY_REPORT_CRASH_GLOBAL_CONTEXT_TAG);
        try {
            if (!SDK_VERSION_REPORTED) {
                Npth.registerSdk(LYNX_SID, getLynxSdkVersion());
                Npth.addTag(LYNX_SDK_VERSION_TAG, getLynxSdkVersion());
                SDK_VERSION_REPORTED = true;
            }
            Npth.addTag(LYNX_SDK_VERSION_TAG, getLynxSdkVersion());
            Npth.addTag(tagName, tagValue);
            Npth.addAttachUserData(new AttachUserData() { // from class: com.bytedance.lynx.service.monitor.LynxMonitorService$$ExternalSyntheticLambda0
                public final Map getUserData(CrashType crashType) {
                    Map m707reportCrashGlobalContextTag$lambda22;
                    m707reportCrashGlobalContextTag$lambda22 = LynxMonitorService.m707reportCrashGlobalContextTag$lambda22(tagName, tagValue, crashType);
                    return m707reportCrashGlobalContextTag$lambda22;
                }
            }, CrashType.ALL);
        } catch (ClassCastException e) {
            LLog.e(TAG, "LynxMonitorService reportCrashGlobalContextTag:" + e.getMessage());
        } catch (IllegalArgumentException e2) {
            LLog.e(TAG, "LynxMonitorService reportCrashGlobalContextTag:" + e2.getMessage());
        } catch (NullPointerException e3) {
            LLog.e(TAG, "LynxMonitorService reportCrashGlobalContextTag:" + e3.getMessage());
        } catch (UnsupportedOperationException e4) {
            LLog.e(TAG, "LynxMonitorService reportCrashGlobalContextTag:" + e4.getMessage());
        }
        TraceEvent.endSection(TraceEventDef.MONITOR_PROXY_REPORT_CRASH_GLOBAL_CONTEXT_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reportCrashGlobalContextTag$lambda-22, reason: not valid java name */
    public static final Map m707reportCrashGlobalContextTag$lambda22(String str, String str2, CrashType crashType) {
        Intrinsics.checkNotNullParameter(str, "$tagName");
        Intrinsics.checkNotNullParameter(str2, "$tagValue");
        HashMap hashMap = new HashMap();
        hashMap.put(LYNX_SDK_VERSION_TAG, INSTANCE.getLynxSdkVersion());
        hashMap.put(str, str2);
        return hashMap;
    }

    public void reportImageInfo(LynxImageInfo imageInfo) {
        Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
        TraceEvent.beginSection(TraceEventDef.MONITOR_PROXY_REPORT_IMAGE_INFO);
        try {
            JSONObject put = new JSONObject().put("res_load_start", imageInfo.getStartTimeStamp()).put("res_load_finish", imageInfo.getFinishTimeStamp());
            Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …mageInfo.finishTimeStamp)");
            String str = imageInfo.getIsSuccess() ? "success" : CDNLoader.PIPELINE_STATUS_FAILED;
            String str2 = "missing";
            ILynxResourceService service = LynxServiceCenter.inst().getService(ILynxResourceService.class);
            if (service != null) {
                int isLocalResource = service.isLocalResource(imageInfo.getUrl());
                if (isLocalResource == 0) {
                    str2 = ResourceInfo.RESOURCE_FROM_CDN;
                } else if (isLocalResource == 1) {
                    str2 = ResourceInfo.RESOURCE_FROM_GECKO;
                }
            }
            JSONObject put2 = new JSONObject().put("res_src", imageInfo.getUrl()).put("res_state", str).put("res_scene", "lynx_image").put("res_from", str2).put("res_size", Float.valueOf(imageInfo.getMemoryCost())).put("is_memory", imageInfo.getHitMemoryCache());
            Intrinsics.checkNotNullExpressionValue(put2, "JSONObject()\n           …imageInfo.hitMemoryCache)");
            JSONObject put3 = new JSONObject().put("res_load_perf", put).put("res_info", put2).put("res_loader_info", new JSONObject().put("res_loader_name", DEFAULT_PID).put("res_loader_version", LynxEnv.inst().getLynxVersion()));
            if (imageInfo.getErrorCode() != 0 && !imageInfo.getIsSuccess()) {
                JSONObject put4 = new JSONObject().put("net_library_error_code", imageInfo.getErrorCode()).put("res_loader_error_code", ImageErrorCodeUtils.checkImageExceptionCategory(imageInfo.getErrorCode()));
                Intrinsics.checkNotNullExpressionValue(put4, "JSONObject()\n           …e\", categorizedErrorCode)");
                put3.put("res_load_error", put4);
            }
            LynxView lynxView = imageInfo.getLynxView();
            Intrinsics.checkNotNullExpressionValue(lynxView, "imageInfo.lynxView");
            Intrinsics.checkNotNullExpressionValue(put3, "data");
            reportResourceStatus(lynxView, "res_loader_perf", put3, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TraceEvent.endSection(TraceEventDef.MONITOR_PROXY_REPORT_IMAGE_INFO);
    }
}
