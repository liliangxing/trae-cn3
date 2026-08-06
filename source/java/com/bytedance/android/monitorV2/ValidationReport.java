package com.bytedance.android.monitorV2;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.android.anniex.R;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.ReportDataUtils;
import com.bytedance.applog.server.Api;
import java.io.IOException;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ValidationReport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J(\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u001fH\u0002J&\u0010(\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010)\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%J\u000e\u0010*\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/android/monitorV2/ValidationReport;", "", "()V", "TAG", "", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "initConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/HybridSettingInitConfig;", "getInitConfig", "()Lcom/bytedance/android/monitorV2/hybridSetting/entity/HybridSettingInitConfig;", "setInitConfig", "(Lcom/bytedance/android/monitorV2/hybridSetting/entity/HybridSettingInitConfig;)V", "path", "translateMap", "", "doValidationReport", "", "jsonString", "extractInfoForKey", Api.KEY_ENCRYPT_RESP_KEY, "eventType", "result", "Lorg/json/JSONObject;", "generateBodyForClient", "bid", "containerType", "generateBodyForEvent", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "generateBodyForJs", "jsonObject", "validationReportForClient", "validationReportForEvent", "validationReportForJS", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ValidationReport {
    public static final String TAG = "ValidationReport";
    private static final Application application;
    private static HybridSettingInitConfig initConfig;
    private static final Map<String, String> translateMap;
    public static final ValidationReport INSTANCE = new ValidationReport();

    /* renamed from: client$delegate, reason: from kotlin metadata */
    private static final Lazy client = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.bytedance.android.monitorV2.ValidationReport$client$2
        public final OkHttpClient invoke() {
            return new OkHttpClient.Builder().build();
        }
    });
    private static String path = "/monitor/data/validation";

    private ValidationReport() {
    }

    public final HybridSettingInitConfig getInitConfig() {
        return initConfig;
    }

    public final void setInitConfig(HybridSettingInitConfig hybridSettingInitConfig) {
        initConfig = hybridSettingInitConfig;
    }

    static {
        Application application2 = HybridMultiMonitor.getInstance().getApplication();
        application = application2;
        Pair[] pairArr = new Pair[10];
        pairArr[0] = TuplesKt.to(HybridEvent.EventPhase.EVENT_CREATE.name(), application2 != null ? application2.getString(R.string.event_create) : null);
        pairArr[1] = TuplesKt.to(HybridEvent.EventPhase.EVENT_UPLOAD.name(), application2 != null ? application2.getString(R.string.event_upload) : null);
        pairArr[2] = TuplesKt.to(HybridEvent.EventPhase.SAMPLE_THROW.name(), application2 != null ? application2.getString(R.string.sample_throw) : null);
        pairArr[3] = TuplesKt.to(HybridEvent.EventPhase.EVENT_TERMINATED.name(), application2 != null ? application2.getString(R.string.event_terminated) : null);
        pairArr[4] = TuplesKt.to(HybridEvent.TerminateType.SWITCH_OFF.name(), application2 != null ? application2.getString(R.string.switch_off) : null);
        pairArr[5] = TuplesKt.to(HybridEvent.TerminateType.PARAM_EXCEPTION.name(), application2 != null ? application2.getString(R.string.param_exception) : null);
        pairArr[6] = TuplesKt.to(HybridEvent.TerminateType.CATCH_EXCEPTION.name(), application2 != null ? application2.getString(R.string.catch_exception) : null);
        pairArr[7] = TuplesKt.to(HybridEvent.TerminateType.EVENT_REPEATED.name(), application2 != null ? application2.getString(R.string.event_repeated) : null);
        pairArr[8] = TuplesKt.to(HybridEvent.TerminateType.INVALID_CASE.name(), application2 != null ? application2.getString(R.string.invalid_case) : null);
        pairArr[9] = TuplesKt.to(HybridEvent.TerminateType.BLOCK_LIST.name(), application2 != null ? application2.getString(R.string.invalid_case) : null);
        translateMap = MapsKt.hashMapOf(pairArr);
    }

    public final OkHttpClient getClient() {
        Object value = client.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-client>(...)");
        return (OkHttpClient) value;
    }

    public final Application getApplication() {
        return application;
    }

    public final void validationReportForClient(String eventType, String bid, String containerType, JSONObject result) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(containerType, "containerType");
        Intrinsics.checkNotNullParameter(result, "result");
        doValidationReport(generateBodyForClient(eventType, bid, containerType, result));
    }

    public final void validationReportForJS(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        doValidationReport(generateBodyForJs(jsonObject));
    }

    public final void validationReportForEvent(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        doValidationReport(generateBodyForEvent(event));
    }

    private final void doValidationReport(String jsonString) {
        RequestBody create = RequestBody.create(MediaType.parse("application/json"), jsonString);
        Intrinsics.checkNotNullExpressionValue(create, "create(mediaType, jsonString)");
        Request.Builder builder = new Request.Builder();
        StringBuilder sb = new StringBuilder();
        HybridSettingInitConfig hybridSettingInitConfig = initConfig;
        Request build = builder.url(sb.append(hybridSettingInitConfig != null ? hybridSettingInitConfig.getHost() : null).append(path).toString()).method("POST", create).addHeader("Content-Type", "application/json").build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .u…on\")\n            .build()");
        try {
            MonitorLog.m26d("Validation", "report code " + getClient().newCall(build).execute().code());
        } catch (IOException e) {
            ExceptionUtil.handleException(e);
        }
    }

    private final String generateBodyForClient(String eventType, String bid, String containerType, JSONObject result) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.MODULE, "monitor");
        JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.BODY, result);
        JsonUtils.safePut(jSONObject, "ev_type", eventType);
        JsonUtils.safePut(jSONObject, "timestamp", System.currentTimeMillis());
        JsonUtils.safePut(jSONObject, "hit_sample", (Object) true);
        HybridSettingInitConfig hybridSettingInitConfig = initConfig;
        JsonUtils.safePut(jSONObject, "device_id", hybridSettingInitConfig != null ? hybridSettingInitConfig.getDeviceId() : null);
        HybridSettingInitConfig hybridSettingInitConfig2 = initConfig;
        JsonUtils.safePut(jSONObject, "os", hybridSettingInitConfig2 != null ? hybridSettingInitConfig2.getOs() : null);
        JsonUtils.safePut(jSONObject, "container_name", extractInfoForKey("container_name", eventType, result));
        JsonUtils.safePut(jSONObject, "container_type", containerType);
        JsonUtils.safePut(jSONObject, "url", extractInfoForKey("url", eventType, result));
        JsonUtils.safePut(jSONObject, "bid", bid);
        HybridSettingInitConfig hybridSettingInitConfig3 = initConfig;
        JsonUtils.safePut(jSONObject, "aid", hybridSettingInitConfig3 != null ? hybridSettingInitConfig3.getAid() : null);
        JsonUtils.safePut(jSONObject, "sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
        JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.SDK_NAME, "Android Hybrid Monitor");
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    private final String generateBodyForJs(JSONObject jsonObject) {
        HybridSettingInitConfig hybridSettingInitConfig = initConfig;
        JsonUtils.safePut(jsonObject, "device_id", hybridSettingInitConfig != null ? hybridSettingInitConfig.getDeviceId() : null);
        JsonUtils.safePut(jsonObject, "timestamp", System.currentTimeMillis());
        String jSONObject = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
        return jSONObject;
    }

    private final String generateBodyForEvent(HybridEvent event) {
        JSONObject customEventToJsonObj;
        String str = null;
        if (event instanceof CommonEvent) {
            customEventToJsonObj = ReportDataUtils.INSTANCE.commonEventToJsonObj((CommonEvent) event);
        } else {
            customEventToJsonObj = event instanceof CustomEvent ? ReportDataUtils.INSTANCE.customEventToJsonObj((CustomEvent) event) : null;
        }
        JSONObject put = new JSONObject().put("extra", customEventToJsonObj);
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.MODULE, "monitor");
        if (HybridEvent.EventPhase.EVENT_UPLOAD == event.getState().getEventPhase() || HybridEvent.EventPhase.SAMPLE_THROW == event.getState().getEventPhase()) {
            JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.BODY, put);
        } else {
            JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.BODY, new JSONObject());
        }
        JsonUtils.safePut(jSONObject, "ev_type", event.getEventType());
        JsonUtils.safePut(jSONObject, "timestamp", System.currentTimeMillis());
        int i = 1;
        JsonUtils.safePut(jSONObject, "hit_sample", Boolean.valueOf(HybridEvent.EventPhase.SAMPLE_THROW != event.getState().getEventPhase()));
        HybridSettingInitConfig hybridSettingInitConfig = initConfig;
        JsonUtils.safePut(jSONObject, "device_id", hybridSettingInitConfig != null ? hybridSettingInitConfig.getDeviceId() : null);
        HybridSettingInitConfig hybridSettingInitConfig2 = initConfig;
        JsonUtils.safePut(jSONObject, "os", hybridSettingInitConfig2 != null ? hybridSettingInitConfig2.getOs() : null);
        String eventType = event.getEventType();
        Intrinsics.checkNotNullExpressionValue(put, ReportConst.ValidationReport.BODY);
        JsonUtils.safePut(jSONObject, "container_name", extractInfoForKey("container_name", eventType, put));
        JsonUtils.safePut(jSONObject, "container_type", event.getNativeBase().containerType);
        JsonUtils.safePut(jSONObject, "url", extractInfoForKey("url", event.getEventType(), put));
        JsonUtils.safePut(jSONObject, "bid", ReportDataUtils.INSTANCE.determineBid(event));
        HybridSettingInitConfig hybridSettingInitConfig3 = initConfig;
        JsonUtils.safePut(jSONObject, "aid", hybridSettingInitConfig3 != null ? hybridSettingInitConfig3.getAid() : null);
        JsonUtils.safePut(jSONObject, "sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
        JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.SDK_NAME, "Android Hybrid Monitor");
        JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.TRACE_ID, event.getEventId());
        if (HybridEvent.EventPhase.EVENT_UPLOAD != event.getState().getEventPhase() && HybridEvent.EventPhase.EVENT_CREATE != event.getState().getEventPhase()) {
            i = 0;
        }
        JsonUtils.safePut(jSONObject, "trace_type", i);
        if (HybridEvent.EventPhase.EVENT_TERMINATED == event.getState().getEventPhase()) {
            HybridEvent.TerminateType terminateType = event.getState().getTerminateType();
            if (terminateType != null) {
                str = terminateType.name();
            }
        } else {
            HybridEvent.EventPhase eventPhase = event.getState().getEventPhase();
            if (eventPhase != null) {
                str = eventPhase.name();
            }
        }
        String str2 = translateMap.get(str);
        if (str2 != null) {
            str = str2;
        }
        JsonUtils.safePut(jSONObject, ReportConst.ValidationReport.TRACE_CONTENT, str);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        r3 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String extractInfoForKey(String key, String eventType, JSONObject result) {
        String str;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            str = null;
        } catch (JSONException e) {
            ExceptionUtil.handleException(e);
            str = "";
        }
        if (TextUtils.equals("url", key)) {
            if (TextUtils.equals("custom", eventType)) {
                JSONObject optJSONObject3 = result.optJSONObject("extra");
                if (optJSONObject3 != null) {
                    str = optJSONObject3.optString("url");
                }
            } else {
                JSONObject optJSONObject4 = result.optJSONObject("extra");
                if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("nativeBase")) != null) {
                    str = optJSONObject2.optString(key);
                }
            }
        } else {
            if (TextUtils.equals("container_name", key)) {
                JSONObject optJSONObject5 = result.optJSONObject("extra");
                if (optJSONObject5 != null && (optJSONObject = optJSONObject5.optJSONObject("containerBase")) != null) {
                    str = optJSONObject.optString(key);
                }
            }
            str = "";
        }
        return str == null ? "" : str;
    }
}
