package com.bytedance.timonbase.report;

import android.app.Application;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timon.foundation.TimonFoundation;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMInjection;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.config.TMConfigService;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.bytedance.timonbase.utils.ProcessUtil;
import com.bytedance.tracing.internal.TracingConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import org.json.JSONObject;

/* compiled from: TMDataCollector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002deB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u00020,0\u001dJ\u0016\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00042\u0006\u00105\u001a\u00020,Jq\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020.2\u0016\b\u0002\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010 2-\u0010=\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 ¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u001e0>H\u0002J1\u0010B\u001a\u0014\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040C2\b\u0010D\u001a\u0004\u0018\u00010:2\u0006\u0010E\u001a\u00020,H\u0000¢\u0006\u0002\bFJ:\u0010G\u001a\u00020.2\u0006\u00108\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010;\u001a\u00020.2\u0016\b\u0002\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010 Jv\u0010H\u001a\u00020.2\u0006\u00108\u001a\u00020\u00042\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020.2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 2\b\b\u0002\u0010;\u001a\u00020.Jp\u0010H\u001a\u00020.2\u0006\u00108\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020.2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 2\b\b\u0002\u0010;\u001a\u00020.J<\u0010H\u001a\u00020.2\u0006\u00108\u001a\u00020\u00042\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00042\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 2\b\b\u0002\u0010;\u001a\u00020.J8\u0010V\u001a\u00020.2\u0006\u0010W\u001a\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010Z\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020.JB\u0010[\u001a\u00020.2\u0006\u0010W\u001a\u00020\u00042\b\u0010\\\u001a\u0004\u0018\u00010:2\b\u0010]\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010Z\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020.J \u0010^\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020.JL\u0010_\u001a\u00020.2\u0006\u00108\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00042\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 2\b\b\u0002\u0010;\u001a\u00020.J\u001c\u0010a\u001a\u00020b2\b\u0010D\u001a\u0004\u0018\u00010:2\b\u0010E\u001a\u0004\u0018\u00010cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R,\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010&0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020,0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b-\u0010/¨\u0006f"}, d2 = {"Lcom/bytedance/timonbase/report/TMDataCollector;", "", "()V", "APPLOG_BEFORE_PRIVACY_MONITOR_EVENT_NAME", "", "APP_LOG_CACHE_SIZE", "", "CHANNEL_APP_LOG", "CHANNEL_MONITOR", "CHANNEL_SLARDAR", "DATA_COLLECT_MAIN_KEY", "EXTRA_KEY_HOST_APP_ID", "EXTRA_KEY_HOST_UPDATE_VERSION_CODE", "EXTRA_KEY_HOST_VERSION_CODE", "EXTRA_KEY_HOST_VERSION_NAME", "EXTRA_KEY_MAIN_PROCESS", "EXTRA_KEY_MARK", "EXTRA_KEY_SAMPLE_RATE", "EXTRA_KEY_SAMPLE_RATE_STRATEGY", "EXTRA_KEY_TIMON_TIMESTAMP", "EXTRA_KEY_TIMON_VERSION", "EXTRA_RULE_ENGINE_PARAMS", "KEY_SAMPLE_RATE_DEFAULT", "SAMPLE_RATE_NONE", "SAMPLE_RATE_VALID", "", "TAG", "appLogCache", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Function0;", "", "customParams", "", "getCustomParams", "()Ljava/util/Map;", "setCustomParams", "(Ljava/util/Map;)V", "extraParamsBuilder", "", "getExtraParamsBuilder", "()Lkotlin/jvm/functions/Function0;", "setExtraParamsBuilder", "(Lkotlin/jvm/functions/Function0;)V", "internalDefaultSampleRate", "Lcom/google/gson/JsonObject;", "isMainProcess", "", "()Z", "isMainProcess$delegate", "Lkotlin/Lazy;", "addDefaultSampleRate", "key", "jsonGetter", "json", "doSamplerCall", Constant.KEY_CHANNEL, "eventType", "eventParams", "Lorg/json/JSONObject;", "needContext", TracingConstants.KEY_TAGS, "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "contextParams", "getSampleResult", "Lkotlin/Triple;", "actualTags", "config", "getSampleResult$timonbase_release", "reportAppLog", "reportException", "javaStackBuilder", "message", "logType", "ensureType", "threadName", "isCore", "customData", "filterData", "javaStack", "throwable", "", "msg", "data", "reportMonitorDuration", "serviceName", ReportConstant.COMMON_INIT_DURATION, "logExtra", PageDataManager.EXTRA_STATUS, "reportMonitorEvent", "category", "metrics", "reportMonitorStatus", "reportNativeException", "nativeStack", "selectRateKeyAndItemRateByPriority", "Lcom/bytedance/timonbase/report/TMDataCollector$SelectResult;", "Lcom/bytedance/timonbase/report/TMDataCollector$SampleRateConfig;", "SampleRateConfig", "SelectResult", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMDataCollector {
    private static final String APPLOG_BEFORE_PRIVACY_MONITOR_EVENT_NAME = "timon_appLog_before_privacy";
    private static final int APP_LOG_CACHE_SIZE = 100;
    private static final String CHANNEL_APP_LOG = "app_log";
    private static final String CHANNEL_MONITOR = "monitor";
    private static final String CHANNEL_SLARDAR = "user_exception";
    private static final String DATA_COLLECT_MAIN_KEY = "data_collect_config";
    private static final String EXTRA_KEY_HOST_APP_ID = "extra_host_app_id";
    private static final String EXTRA_KEY_HOST_UPDATE_VERSION_CODE = "extra_host_update_version_code";
    private static final String EXTRA_KEY_HOST_VERSION_CODE = "extra_host_version_code";
    private static final String EXTRA_KEY_HOST_VERSION_NAME = "extra_host_version_name";
    private static final String EXTRA_KEY_MAIN_PROCESS = "extra_main_process";
    private static final String EXTRA_KEY_MARK = "extra_mark";
    private static final String EXTRA_KEY_SAMPLE_RATE = "extra_timon_sample_rate";
    private static final String EXTRA_KEY_SAMPLE_RATE_STRATEGY = "sample_rate_strategy";
    private static final String EXTRA_KEY_TIMON_TIMESTAMP = "extra_timon_timestamp";
    private static final String EXTRA_KEY_TIMON_VERSION = "extra_timon_version";
    private static final String EXTRA_RULE_ENGINE_PARAMS = "rule_engine_params";
    private static final String KEY_SAMPLE_RATE_DEFAULT = "default";
    private static final int SAMPLE_RATE_NONE = 0;
    private static final double SAMPLE_RATE_VALID = 1.0d;
    private static final String TAG = "TMDataCollector";
    private static Map<String, String> customParams;
    private static final Map<String, JsonObject> internalDefaultSampleRate;
    public static final TMDataCollector INSTANCE = new TMDataCollector();
    private static Function0<? extends Map<String, Object>> extraParamsBuilder = new Function0<Map<String, Object>>() { // from class: com.bytedance.timonbase.report.TMDataCollector$extraParamsBuilder$1
        public final Map<String, Object> invoke() {
            return new LinkedHashMap();
        }
    };

    /* renamed from: isMainProcess$delegate, reason: from kotlin metadata */
    private static final Lazy isMainProcess = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.timonbase.report.TMDataCollector$isMainProcess$2
        public /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.valueOf(m1060invoke());
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final boolean m1060invoke() {
            Application application = TMEnv.INSTANCE.getApplication();
            if (application != null) {
                return ProcessUtil.INSTANCE.isMainProcess(application);
            }
            return false;
        }
    });
    private static final ConcurrentLinkedQueue<Function0<Unit>> appLogCache = new ConcurrentLinkedQueue<>();

    private final boolean isMainProcess() {
        return ((Boolean) isMainProcess.getValue()).booleanValue();
    }

    static {
        Pair[] pairArr = new Pair[9];
        JsonObject jsonObject = new JsonObject();
        JsonElement jsonObject2 = new JsonObject();
        jsonObject2.addProperty("default", (Number) 1);
        jsonObject.add(TracingConstants.KEY_SAMPLE_RATE, jsonObject2);
        pairArr[0] = TuplesKt.to("timon_action_log", jsonObject);
        JsonObject jsonObject3 = new JsonObject();
        JsonElement jsonObject4 = new JsonObject();
        jsonObject4.addProperty("default", (Number) 1);
        jsonObject3.add(TracingConstants.KEY_SAMPLE_RATE, jsonObject4);
        pairArr[1] = TuplesKt.to("timon_permission_dialog", jsonObject3);
        JsonObject jsonObject5 = new JsonObject();
        JsonElement jsonObject6 = new JsonObject();
        jsonObject6.addProperty("default", (Number) 1);
        jsonObject5.add(TracingConstants.KEY_SAMPLE_RATE, jsonObject6);
        pairArr[2] = TuplesKt.to("timon_permission_manager", jsonObject5);
        JsonObject jsonObject7 = new JsonObject();
        JsonElement jsonObject8 = new JsonObject();
        jsonObject8.addProperty("default", (Number) 1);
        jsonObject7.add(TracingConstants.KEY_SAMPLE_RATE, jsonObject8);
        pairArr[3] = TuplesKt.to("timon_dye_mark", jsonObject7);
        JsonObject jsonObject9 = new JsonObject();
        JsonElement jsonObject10 = new JsonObject();
        jsonObject10.addProperty("default", (Number) 1);
        jsonObject9.add(TracingConstants.KEY_SAMPLE_RATE, jsonObject10);
        pairArr[4] = TuplesKt.to("timon_effective_read_pasteboard_feedback", jsonObject9);
        JsonObject jsonObject11 = new JsonObject();
        JsonElement jsonObject12 = new JsonObject();
        jsonObject12.addProperty("default", (Number) 1);
        jsonObject11.add(TracingConstants.KEY_SAMPLE_RATE, jsonObject12);
        pairArr[5] = TuplesKt.to("timon_read_pasteboard_event", jsonObject11);
        JsonObject jsonObject13 = new JsonObject();
        JsonElement jsonObject14 = new JsonObject();
        jsonObject14.addProperty("default", (Number) 1);
        jsonObject13.add(TracingConstants.KEY_SAMPLE_RATE, jsonObject14);
        pairArr[6] = TuplesKt.to("timon_calendar_event", jsonObject13);
        JsonObject jsonObject15 = new JsonObject();
        JsonElement jsonObject16 = new JsonObject();
        if (TMEnv.INSTANCE.getDEBUG()) {
            jsonObject16.addProperty("default", (Number) 1);
        } else {
            jsonObject16.addProperty("default", (Number) 100);
        }
        jsonObject15.add(TracingConstants.KEY_SAMPLE_RATE, jsonObject16);
        pairArr[7] = TuplesKt.to("timon_process_killer", jsonObject15);
        JsonObject jsonObject17 = new JsonObject();
        JsonElement jsonObject18 = new JsonObject();
        if (TMEnv.INSTANCE.getDEBUG()) {
            jsonObject18.addProperty("default", (Number) 1);
        } else {
            jsonObject18.addProperty("default", (Number) 10);
        }
        jsonObject17.add(TracingConstants.KEY_SAMPLE_RATE, jsonObject18);
        pairArr[8] = TuplesKt.to("timon_process_report", jsonObject17);
        internalDefaultSampleRate = MapsKt.mutableMapOf(pairArr);
    }

    private TMDataCollector() {
    }

    public final Function0<Map<String, Object>> getExtraParamsBuilder() {
        return extraParamsBuilder;
    }

    public final void setExtraParamsBuilder(Function0<? extends Map<String, Object>> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        extraParamsBuilder = function0;
    }

    public final Map<String, String> getCustomParams() {
        return customParams;
    }

    public final void setCustomParams(Map<String, String> map) {
        customParams = map;
    }

    public final synchronized void addDefaultSampleRate(String key, JsonObject json) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(json, "json");
        internalDefaultSampleRate.put(key, json);
    }

    public final void addDefaultSampleRate(String key, Function0<JsonObject> jsonGetter) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(jsonGetter, "jsonGetter");
        addDefaultSampleRate(key, (JsonObject) jsonGetter.invoke());
    }

    public static /* synthetic */ boolean reportException$default(TMDataCollector tMDataCollector, String str, Throwable th, String str2, Map map, boolean z, int i, Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        return tMDataCollector.reportException(str, th, str2, map, z);
    }

    public final boolean reportException(String eventType, final Throwable throwable, final String msg, final Map<String, String> data, boolean needContext) {
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(data, "data");
        return doSamplerCall$default(this, CHANNEL_SLARDAR, eventType, new JSONObject(data), needContext, null, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.bytedance.timonbase.report.TMDataCollector$reportException$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, String> map) {
                Intrinsics.checkParameterIsNotNull(map, "extraParams");
                Map<String, String> mutableMap = MapsKt.toMutableMap(data);
                mutableMap.putAll(map);
                TimonFoundation.INSTANCE.getExceptionMonitor().monitorThrowable(throwable, msg, mutableMap);
            }
        }, 16, null);
    }

    public final boolean reportException(String eventType, final String javaStack, final String message, final String logType, final String ensureType, final String threadName, final boolean isCore, final Map<String, String> customData, final Map<String, String> filterData, boolean needContext) {
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(javaStack, "javaStack");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(logType, "logType");
        Intrinsics.checkParameterIsNotNull(ensureType, "ensureType");
        Intrinsics.checkParameterIsNotNull(threadName, "threadName");
        Intrinsics.checkParameterIsNotNull(customData, "customData");
        Intrinsics.checkParameterIsNotNull(filterData, "filterData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(customData);
        linkedHashMap.putAll(filterData);
        return doSamplerCall$default(this, CHANNEL_SLARDAR, eventType, new JSONObject(MapsKt.toMap(linkedHashMap)), needContext, null, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.bytedance.timonbase.report.TMDataCollector$reportException$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, String> map) {
                Intrinsics.checkParameterIsNotNull(map, "extraParams");
                Map<String, String> mutableMap = MapsKt.toMutableMap(customData);
                mutableMap.putAll(map);
                TimonFoundation.INSTANCE.getExceptionMonitor().monitorThrowable(javaStack, message, logType, ensureType, threadName, isCore, mutableMap, filterData);
            }
        }, 16, null);
    }

    public final boolean reportException(String eventType, final Function0<String> javaStackBuilder, final String message, final String logType, final String ensureType, final String threadName, final boolean isCore, final Map<String, String> customData, final Map<String, String> filterData, boolean needContext) {
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(javaStackBuilder, "javaStackBuilder");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(logType, "logType");
        Intrinsics.checkParameterIsNotNull(ensureType, "ensureType");
        Intrinsics.checkParameterIsNotNull(threadName, "threadName");
        Intrinsics.checkParameterIsNotNull(customData, "customData");
        Intrinsics.checkParameterIsNotNull(filterData, "filterData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(customData);
        linkedHashMap.putAll(filterData);
        return doSamplerCall$default(this, CHANNEL_SLARDAR, eventType, new JSONObject(MapsKt.toMap(linkedHashMap)), needContext, null, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.bytedance.timonbase.report.TMDataCollector$reportException$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, String> map) {
                Intrinsics.checkParameterIsNotNull(map, "extraParams");
                Map<String, String> mutableMap = MapsKt.toMutableMap(customData);
                mutableMap.putAll(map);
                TimonFoundation.INSTANCE.getExceptionMonitor().monitorThrowable((String) javaStackBuilder.invoke(), message, logType, ensureType, threadName, isCore, mutableMap, filterData);
            }
        }, 16, null);
    }

    public final boolean reportNativeException(String eventType, final String nativeStack, final String javaStack, final String threadName, final String message, final Map<String, String> data, boolean needContext) {
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(nativeStack, "nativeStack");
        Intrinsics.checkParameterIsNotNull(javaStack, "javaStack");
        Intrinsics.checkParameterIsNotNull(threadName, "threadName");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(data, "data");
        return doSamplerCall$default(this, CHANNEL_SLARDAR, eventType, new JSONObject(data), needContext, null, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.bytedance.timonbase.report.TMDataCollector$reportNativeException$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, String> map) {
                Intrinsics.checkParameterIsNotNull(map, "extraParams");
                Map<String, String> mutableMap = MapsKt.toMutableMap(data);
                mutableMap.putAll(map);
                TimonFoundation.INSTANCE.getExceptionMonitor().monitorNativeException(nativeStack, javaStack, threadName, message, mutableMap);
            }
        }, 16, null);
    }

    public static /* synthetic */ void reportMonitorStatus$default(TMDataCollector tMDataCollector, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        tMDataCollector.reportMonitorStatus(str, i, z);
    }

    public final void reportMonitorStatus(String serviceName, int r10, boolean needContext) {
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        reportMonitorEvent(serviceName, null, null, null, r10, needContext);
    }

    public static /* synthetic */ boolean reportMonitorEvent$default(TMDataCollector tMDataCollector, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, int i, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            jSONObject3 = null;
        }
        return tMDataCollector.reportMonitorEvent(str, jSONObject, jSONObject2, jSONObject3, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? false : z);
    }

    public final boolean reportMonitorEvent(final String serviceName, final JSONObject category, final JSONObject metrics, final JSONObject logExtra, final int r17, boolean needContext) {
        Iterator<String> keys;
        Iterator<String> keys2;
        Iterator<String> keys3;
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        JSONObject jSONObject = new JSONObject();
        if (category != null && (keys3 = category.keys()) != null) {
            while (keys3.hasNext()) {
                String next = keys3.next();
                jSONObject.put(next, category.opt(next));
            }
        }
        if (metrics != null && (keys2 = metrics.keys()) != null) {
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                jSONObject.put(next2, metrics.opt(next2));
            }
        }
        if (logExtra != null && (keys = logExtra.keys()) != null) {
            while (keys.hasNext()) {
                String next3 = keys.next();
                jSONObject.put(next3, logExtra.opt(next3));
            }
        }
        return doSamplerCall$default(this, "monitor", serviceName, jSONObject, needContext, null, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.bytedance.timonbase.report.TMDataCollector$reportMonitorEvent$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, String> map) {
                Intrinsics.checkParameterIsNotNull(map, "extraParams");
                JSONObject jSONObject2 = logExtra;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                JSONObject jSONObject3 = jSONObject2;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject3.put(entry.getKey(), entry.getValue());
                }
                TimonFoundation.INSTANCE.getEventMonitor().monitorStatusAndEvent(serviceName, r17, category, metrics, jSONObject3);
            }
        }, 16, null);
    }

    public static /* synthetic */ boolean reportMonitorDuration$default(TMDataCollector tMDataCollector, String str, JSONObject jSONObject, JSONObject jSONObject2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            jSONObject2 = null;
        }
        return tMDataCollector.reportMonitorDuration(str, jSONObject, jSONObject2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z);
    }

    public final boolean reportMonitorDuration(final String serviceName, final JSONObject r12, final JSONObject logExtra, final int r14, boolean needContext) {
        Iterator<String> keys;
        Iterator<String> keys2;
        Intrinsics.checkParameterIsNotNull(serviceName, "serviceName");
        JSONObject jSONObject = new JSONObject();
        if (r12 != null && (keys2 = r12.keys()) != null) {
            while (keys2.hasNext()) {
                String next = keys2.next();
                jSONObject.put(next, r12.get(next));
            }
        }
        if (logExtra != null && (keys = logExtra.keys()) != null) {
            while (keys.hasNext()) {
                String next2 = keys.next();
                jSONObject.put(next2, logExtra.get(next2));
            }
        }
        return doSamplerCall$default(this, "monitor", serviceName, jSONObject, needContext, null, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.bytedance.timonbase.report.TMDataCollector$reportMonitorDuration$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, String> map) {
                Intrinsics.checkParameterIsNotNull(map, "extraParams");
                JSONObject jSONObject2 = logExtra;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                TimonFoundation.INSTANCE.getEventMonitor().monitorStatusAndDuration(serviceName, r14, r12, jSONObject2);
            }
        }, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean reportAppLog$default(TMDataCollector tMDataCollector, String str, JSONObject jSONObject, boolean z, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            map = null;
        }
        return tMDataCollector.reportAppLog(str, jSONObject, z, map);
    }

    public final boolean reportAppLog(final String eventType, final JSONObject eventParams, boolean needContext, Map<String, String> r12) {
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        return doSamplerCall(CHANNEL_APP_LOG, eventType, eventParams, needContext, r12, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.bytedance.timonbase.report.TMDataCollector$reportAppLog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, String> map) {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                ConcurrentLinkedQueue concurrentLinkedQueue2;
                ConcurrentLinkedQueue concurrentLinkedQueue3;
                ConcurrentLinkedQueue concurrentLinkedQueue4;
                ConcurrentLinkedQueue concurrentLinkedQueue5;
                Intrinsics.checkParameterIsNotNull(map, "extraParams");
                final JSONObject jSONObject = eventParams;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                if (!ScenesDetector.INSTANCE.isAgreedPrivacy()) {
                    TMDataCollector tMDataCollector = TMDataCollector.INSTANCE;
                    concurrentLinkedQueue4 = TMDataCollector.appLogCache;
                    if (concurrentLinkedQueue4.size() < 100) {
                        TMDataCollector tMDataCollector2 = TMDataCollector.INSTANCE;
                        concurrentLinkedQueue5 = TMDataCollector.appLogCache;
                        concurrentLinkedQueue5.add(new Function0<Unit>() { // from class: com.bytedance.timonbase.report.TMDataCollector$reportAppLog$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m1061invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m1061invoke() {
                                TimonFoundation.INSTANCE.getAppLog().log(eventType, jSONObject);
                            }
                        });
                        return;
                    } else {
                        TMDataCollector tMDataCollector3 = TMDataCollector.INSTANCE;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("EventType", eventType);
                        jSONObject2.put("mutableParams", jSONObject);
                        TMDataCollector.reportMonitorEvent$default(tMDataCollector3, "timon_appLog_before_privacy", jSONObject2, null, null, 0, false, 56, null);
                        return;
                    }
                }
                TMDataCollector tMDataCollector4 = TMDataCollector.INSTANCE;
                concurrentLinkedQueue = TMDataCollector.appLogCache;
                if (!concurrentLinkedQueue.isEmpty()) {
                    TMDataCollector tMDataCollector5 = TMDataCollector.INSTANCE;
                    concurrentLinkedQueue2 = TMDataCollector.appLogCache;
                    Iterator it = concurrentLinkedQueue2.iterator();
                    while (it.hasNext()) {
                        ((Function0) it.next()).invoke();
                    }
                    TMDataCollector tMDataCollector6 = TMDataCollector.INSTANCE;
                    concurrentLinkedQueue3 = TMDataCollector.appLogCache;
                    concurrentLinkedQueue3.clear();
                }
                TimonFoundation.INSTANCE.getAppLog().log(eventType, jSONObject);
            }
        });
    }

    static /* synthetic */ boolean doSamplerCall$default(TMDataCollector tMDataCollector, String str, String str2, JSONObject jSONObject, boolean z, Map map, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            map = null;
        }
        return tMDataCollector.doSamplerCall(str, str2, jSONObject, z, map, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x005e A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:3:0x0003, B:6:0x000f, B:8:0x0015, B:10:0x001d, B:13:0x0027, B:17:0x002e, B:21:0x0070, B:25:0x00d8, B:27:0x011c, B:29:0x0121, B:30:0x0146, B:32:0x014c, B:34:0x015a, B:36:0x0160, B:40:0x017c, B:44:0x016c, B:45:0x0173, B:46:0x0174, B:49:0x019a, B:53:0x003b, B:59:0x004d, B:62:0x005e, B:63:0x0048), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0048 A[Catch: Exception -> 0x019e, TryCatch #0 {Exception -> 0x019e, blocks: (B:3:0x0003, B:6:0x000f, B:8:0x0015, B:10:0x001d, B:13:0x0027, B:17:0x002e, B:21:0x0070, B:25:0x00d8, B:27:0x011c, B:29:0x0121, B:30:0x0146, B:32:0x014c, B:34:0x015a, B:36:0x0160, B:40:0x017c, B:44:0x016c, B:45:0x0173, B:46:0x0174, B:49:0x019a, B:53:0x003b, B:59:0x004d, B:62:0x005e, B:63:0x0048), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean doSamplerCall(String r8, String eventType, JSONObject eventParams, boolean needContext, Map<String, String> r12, Function1<? super Map<String, String>, Unit> block) {
        boolean z;
        Triple<Boolean, Integer, String> sampleResult$timonbase_release;
        int i;
        String obj;
        try {
            String str = "null";
            JsonObject configJson = TMConfigService.INSTANCE.getConfigJson("data_collect_config", r8, eventType);
            if (configJson == null && Intrinsics.areEqual(r8, CHANNEL_APP_LOG)) {
                Map<String, JsonObject> map = internalDefaultSampleRate;
                if (map.containsKey(eventType)) {
                    configJson = map.get(eventType);
                }
            }
            if (configJson == null) {
                if (Intrinsics.areEqual(r8, CHANNEL_APP_LOG) || TMConfigService.INSTANCE.getConfigJson("data_collect_config") == null) {
                    return false;
                }
                i = -1;
            } else {
                if (r12 != null && !r12.isEmpty()) {
                    z = false;
                    if (z) {
                        eventParams = new JSONObject(r12);
                    }
                    sampleResult$timonbase_release = getSampleResult$timonbase_release(eventParams, configJson);
                    if (((Boolean) sampleResult$timonbase_release.getFirst()).booleanValue()) {
                        return false;
                    }
                    int intValue = ((Number) sampleResult$timonbase_release.getSecond()).intValue();
                    str = (String) sampleResult$timonbase_release.getThird();
                    i = intValue;
                }
                z = true;
                if (z) {
                }
                sampleResult$timonbase_release = getSampleResult$timonbase_release(eventParams, configJson);
                if (((Boolean) sampleResult$timonbase_release.getFirst()).booleanValue()) {
                }
            }
            Pair[] pairArr = new Pair[10];
            pairArr[0] = TuplesKt.to(EXTRA_KEY_SAMPLE_RATE, String.valueOf(i));
            pairArr[1] = TuplesKt.to(EXTRA_KEY_SAMPLE_RATE_STRATEGY, str);
            pairArr[2] = TuplesKt.to(EXTRA_KEY_TIMON_VERSION, "4.0.0");
            pairArr[3] = TuplesKt.to(EXTRA_KEY_HOST_VERSION_NAME, TMEnv.INSTANCE.getVersionName());
            pairArr[4] = TuplesKt.to(EXTRA_KEY_HOST_VERSION_CODE, String.valueOf(TMEnv.INSTANCE.getVersionCode()));
            pairArr[5] = TuplesKt.to(EXTRA_KEY_HOST_UPDATE_VERSION_CODE, String.valueOf(TMEnv.INSTANCE.getUpdateVersionCode()));
            pairArr[6] = TuplesKt.to(EXTRA_KEY_MAIN_PROCESS, isMainProcess() ? "1" : "0");
            pairArr[7] = TuplesKt.to(EXTRA_KEY_HOST_APP_ID, String.valueOf(TMEnv.INSTANCE.getAppId()));
            pairArr[8] = TuplesKt.to(EXTRA_KEY_TIMON_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            pairArr[9] = TuplesKt.to(EXTRA_KEY_MARK, TMEnv.INSTANCE.getTimonDyeMark());
            Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
            Map<String, String> map2 = customParams;
            if (map2 != null) {
                mutableMapOf.putAll(map2);
            }
            if (needContext) {
                Map map3 = (Map) extraParamsBuilder.invoke();
                String json = TMInjection.INSTANCE.getGson().toJson(map3);
                Intrinsics.checkExpressionValueIsNotNull(json, "TMInjection.gson.toJson(envParams)");
                mutableMapOf.put(EXTRA_RULE_ENGINE_PARAMS, json);
                for (Map.Entry entry : map3.entrySet()) {
                    if (entry.getValue() instanceof Boolean) {
                        Object value = entry.getValue();
                        if (value == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        obj = ((Boolean) value).booleanValue() ? "1" : "0";
                    } else {
                        obj = entry.getValue().toString();
                    }
                    mutableMapOf.put("rule_engine_param_" + ((String) entry.getKey()), obj);
                }
            }
            block.invoke(mutableMapOf);
            return true;
        } catch (Exception e) {
            TMLogger.INSTANCE.m222e(TAG, "sampler call failed.", e);
            return false;
        }
    }

    /* compiled from: TMDataCollector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/timonbase/report/TMDataCollector$SelectResult;", "", "rateKey", "", "itemRate", "", "(Ljava/lang/String;I)V", "getItemRate", "()I", "getRateKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SelectResult {
        private final int itemRate;
        private final String rateKey;

        public static /* synthetic */ SelectResult copy$default(SelectResult selectResult, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = selectResult.rateKey;
            }
            if ((i2 & 2) != 0) {
                i = selectResult.itemRate;
            }
            return selectResult.copy(str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getRateKey() {
            return this.rateKey;
        }

        /* renamed from: component2, reason: from getter */
        public final int getItemRate() {
            return this.itemRate;
        }

        public final SelectResult copy(String rateKey, int itemRate) {
            Intrinsics.checkParameterIsNotNull(rateKey, "rateKey");
            return new SelectResult(rateKey, itemRate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectResult)) {
                return false;
            }
            SelectResult selectResult = (SelectResult) other;
            return Intrinsics.areEqual(this.rateKey, selectResult.rateKey) && this.itemRate == selectResult.itemRate;
        }

        public int hashCode() {
            String str = this.rateKey;
            return ((str != null ? str.hashCode() : 0) * 31) + Integer.hashCode(this.itemRate);
        }

        public String toString() {
            return "SelectResult(rateKey=" + this.rateKey + ", itemRate=" + this.itemRate + ")";
        }

        public SelectResult(String str, int i) {
            Intrinsics.checkParameterIsNotNull(str, "rateKey");
            this.rateKey = str;
            this.itemRate = i;
        }

        public final int getItemRate() {
            return this.itemRate;
        }

        public final String getRateKey() {
            return this.rateKey;
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.bytedance.timonbase.report.TMDataCollector$selectRateKeyAndItemRateByPriority$1] */
    private final SelectResult selectRateKeyAndItemRateByPriority(JSONObject actualTags, SampleRateConfig config) {
        List<String> emptyList;
        Map<String, Integer> sampleRate;
        Integer num;
        if (config == null || (emptyList = config.getTags()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = emptyList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (actualTags != null && actualTags.has((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (String str : arrayList2) {
            arrayList3.add(str + '=' + (actualTags != null ? actualTags.opt(str) : null));
        }
        List<String> mutableList = CollectionsKt.toMutableList(arrayList3);
        if (emptyList.size() > 1) {
            String sb = ((StringBuilder) CollectionsKt.joinTo$default(mutableList, new StringBuilder(), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<String, String>() { // from class: com.bytedance.timonbase.report.TMDataCollector$selectRateKeyAndItemRateByPriority$allCondition$1
                public final String invoke(String str2) {
                    Intrinsics.checkParameterIsNotNull(str2, "it");
                    return str2;
                }
            }, 60, (Object) null)).toString();
            Intrinsics.checkExpressionValueIsNotNull(sb, "conditions.joinTo(String…), \"&\") { it }.toString()");
            mutableList.add(sb);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = (config == null || (sampleRate = config.getSampleRate()) == null || (num = sampleRate.get("default")) == null) ? 0 : num.intValue();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "default";
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = 0;
        ?? r5 = new Function3<String, Integer, Integer, Unit>() { // from class: com.bytedance.timonbase.report.TMDataCollector$selectRateKeyAndItemRateByPriority$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(String str2, int i, int i2) {
                Intrinsics.checkParameterIsNotNull(str2, "key");
                objectRef.element = str2;
                intRef.element = i;
                intRef2.element = i2;
            }
        };
        if (config != null) {
            for (String str2 : mutableList) {
                Integer num2 = config.getPriority().get(str2);
                int intValue = num2 != null ? num2.intValue() : 0;
                Integer num3 = config.getSampleRate().get(str2);
                if (num3 != null) {
                    if (intValue > intRef2.element) {
                        r5.invoke(str2, num3.intValue(), intValue);
                    } else if (intValue == intRef2.element) {
                        if (Intrinsics.areEqual((String) objectRef.element, "default")) {
                            r5.invoke(str2, num3.intValue(), intValue);
                        } else if (num3.intValue() == 0 || (num3.intValue() > intRef.element && intRef.element != 0)) {
                            r5.invoke(str2, num3.intValue(), intValue);
                        }
                    }
                }
            }
        }
        return new SelectResult((String) objectRef.element, intRef.element);
    }

    public final Triple<Boolean, Integer, String> getSampleResult$timonbase_release(JSONObject actualTags, JsonObject config) {
        int i;
        JsonElement jsonElement;
        Intrinsics.checkParameterIsNotNull(config, "config");
        JsonObject asJsonObject = config.getAsJsonObject(TracingConstants.KEY_SAMPLE_RATE);
        String str = "default";
        Integer valueOf = (asJsonObject == null || (jsonElement = asJsonObject.get("default")) == null) ? null : Integer.valueOf(jsonElement.getAsInt());
        if (config.has(TracingConstants.KEY_TAGS)) {
            SelectResult selectRateKeyAndItemRateByPriority = selectRateKeyAndItemRateByPriority(actualTags, (SampleRateConfig) TMInjection.INSTANCE.getGson().fromJson((JsonElement) config, SampleRateConfig.class));
            str = selectRateKeyAndItemRateByPriority.getRateKey();
            i = Math.max(Integer.MIN_VALUE, selectRateKeyAndItemRateByPriority.getItemRate());
        } else {
            i = Integer.MIN_VALUE;
        }
        if (i == Integer.MIN_VALUE) {
            if (valueOf == null) {
                return new Triple<>(false, 0, str);
            }
            i = valueOf.intValue();
        }
        if (i == 0) {
            return new Triple<>(false, 0, str);
        }
        return new Triple<>(Boolean.valueOf(Random.Default.nextDouble(0.0d, (double) i) <= SAMPLE_RATE_VALID), Integer.valueOf(i), str);
    }

    /* compiled from: TMDataCollector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001BA\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\tR\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/timonbase/report/TMDataCollector$SampleRateConfig;", "", TracingConstants.KEY_TAGS, "", "", "sampleRate", "", "", "priority", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)V", "getPriority", "()Ljava/util/Map;", "getSampleRate", "getTags", "()Ljava/util/List;", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class SampleRateConfig {

        @SerializedName("priority")
        private final Map<String, Integer> priority;

        @SerializedName(TracingConstants.KEY_SAMPLE_RATE)
        private final Map<String, Integer> sampleRate;

        @SerializedName(TracingConstants.KEY_TAGS)
        private final List<String> tags;

        public SampleRateConfig() {
            this(null, null, null, 7, null);
        }

        public SampleRateConfig(List<String> list, Map<String, Integer> map, Map<String, Integer> map2) {
            Intrinsics.checkParameterIsNotNull(list, TracingConstants.KEY_TAGS);
            Intrinsics.checkParameterIsNotNull(map, "sampleRate");
            Intrinsics.checkParameterIsNotNull(map2, "priority");
            this.tags = list;
            this.sampleRate = map;
            this.priority = map2;
        }

        public /* synthetic */ SampleRateConfig(List list, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2);
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public final Map<String, Integer> getSampleRate() {
            return this.sampleRate;
        }

        public final Map<String, Integer> getPriority() {
            return this.priority;
        }
    }
}
